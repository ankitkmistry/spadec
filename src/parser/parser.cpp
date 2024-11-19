#include "parser.hpp"

namespace spade
{
    template<typename... Ts>
        requires(std::same_as<TokenType, Ts> && ...)
    static string make_expected_string(Ts... types) {
        std::vector<TokenType> list{types...};
        string result;
        for (int i = 0; i < list.size(); ++i) {
            result += TokenInfo::get_repr(list[i]);
            if (i < list.size() - 1) result += ", ";
        }
        return result;
    }

    void Parser::fill_tokens_buffer(int n) {
        for (int i = 0; i < n; ++i) {
            auto token = lexer->next_token();
            if (token->get_type() == TokenType::END_OF_FILE && tokens.back()->get_type() == TokenType::END_OF_FILE)
                break;    // Already EOF occured
            tokens.push_back(token);
        }
    }

    std::shared_ptr<Token> Parser::current() {
        if (index == 0) return null;
        if (index >= tokens.size()) {
            fill_tokens_buffer(FILL_CONSTANT);
            if (index >= tokens.size()) return tokens.back();    // EOF
        }
        return tokens[index - 1];
    }

    std::shared_ptr<Token> Parser::peek() {
        if (index >= tokens.size()) {
            fill_tokens_buffer(FILL_CONSTANT);
            if (index >= tokens.size()) return tokens.back();    // EOF
        }
        return tokens[index];
    }

    std::shared_ptr<Token> Parser::advance() {
        if (index >= tokens.size()) {
            fill_tokens_buffer(FILL_CONSTANT);
            if (index >= tokens.size()) return tokens.back();    // EOF
        }
        return tokens[index++];
    }

    std::shared_ptr<Token> Parser::match(TokenType type) {
        if (peek()->get_type() == type) {
            return advance();
        }
        return null;
    }

    std::shared_ptr<Token> Parser::expect(TokenType type) {
        if (peek()->get_type() == type) {
            return advance();
        }
        throw error("expected " + TokenInfo::get_repr(type));
    }

    ParserError Parser::error(const string &msg, std::shared_ptr<Token> token) {
        int line_start = token->get_line();
        int col_start = token->get_col();
        int line_end = line_start;
        int col_end = col_start;
        for (auto c: token->get_text()) {
            if (c == '\n') {
                line_end++;
                col_end = 0;
            } else
                col_end++;
        }
        return {msg, line_start, col_start, line_end, col_end};
    }

    ParserError Parser::error(const string &msg) {
        return error(msg, peek());
    }

    std::shared_ptr<ast::Reference> Parser::reference() {
        std::vector<std::shared_ptr<Token>> path;
        path.push_back(expect(TokenType::IDENTIFIER));
        while (match(TokenType::DOT)) {
            path.push_back(expect(TokenType::IDENTIFIER));
        }
        return std::make_shared<ast::Reference>(path);
    }

    std::shared_ptr<ast::Expression> Parser::expression() {
        return rule_or<ast::Expression>([&] { return assignment(); }, [&] { return ternary(); });
    }

    std::shared_ptr<ast::Expression> Parser::assignment() {
        auto assignees = assignee_list();
        std::shared_ptr<Token> op1;
        switch (peek()->get_type()) {
            case TokenType::PLUS:
            case TokenType::DASH:
            case TokenType::STAR:
            case TokenType::SLASH:
            case TokenType::PERCENT:
            case TokenType::STAR_STAR:
            case TokenType::LSHIFT:
            case TokenType::RSHIFT:
            case TokenType::URSHIFT:
            case TokenType::AMPERSAND:
            case TokenType::PIPE:
            case TokenType::CARET:
            case TokenType::ELVIS:
                op1 = advance();
                [[fallthrough]];
            case TokenType::EQUAL: {
                std::shared_ptr<Token> op2;
                if (op1) {
                    op2 = expect(TokenType::EQUAL);
                } else
                    op1 = advance();
                auto exprs = expr_list();
                return std::make_shared<ast::expr::Assignment>(assignees, op1, op2, exprs);
            }
            default:
                throw error(std::format("expected {}",
                                        make_expected_string(TokenType::PLUS, TokenType::DASH, TokenType::STAR,
                                                             TokenType::SLASH, TokenType::PERCENT, TokenType::STAR_STAR,
                                                             TokenType::LSHIFT, TokenType::RSHIFT, TokenType::URSHIFT,
                                                             TokenType::AMPERSAND, TokenType::PIPE, TokenType::CARET,
                                                             TokenType::ELVIS, TokenType::EQUAL)));
        }
    }

    std::shared_ptr<ast::Expression> Parser::ternary() {
        auto expr1 = or_();
        if (match(TokenType::IF)) {
            auto expr2 = or_();
            expect(TokenType::ELSE);
            auto expr3 = or_();
            return std::make_shared<ast::expr::Ternary>(expr2, expr1, expr3);
        }
        return expr1;
    }

    std::shared_ptr<ast::Expression> Parser::or_() {
        auto left = and_();
        while (match(TokenType::OR)) {
            auto op = current();
            auto right = and_();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::and_() {
        auto left = not_();
        while (match(TokenType::AND)) {
            auto op = current();
            auto right = not_();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::not_() {
        if (match(TokenType::NOT)) {
            auto op = current();
            auto expr = not_();
            return std::make_shared<ast::expr::Unary>(op, expr);
        }
        auto expr = conditional();
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::conditional() {
        auto left = relational();
        while (true) {
            switch (peek()->get_type()) {
                case TokenType::IS: {
                    auto op = advance();
                    if (match(TokenType::NOT)) {
                        auto op_extra = current();
                        auto right = relational();
                        left = std::make_shared<ast::expr::Binary2>(left, op, op_extra, right);
                        break;
                    }
                    auto right = relational();
                    left = std::make_shared<ast::expr::Binary>(left, op, right);
                    break;
                }
                case TokenType::NOT: {
                    auto op = advance();
                    auto op_extra = expect(TokenType::IN);
                    auto right = relational();
                    left = std::make_shared<ast::expr::Binary2>(left, op, op_extra, right);
                    break;
                }
                case TokenType::IN: {
                    auto op = advance();
                    auto right = relational();
                    left = std::make_shared<ast::expr::Binary>(left, op, right);
                    break;
                }
                default:
                    return left;
            }
        }
    }

    std::shared_ptr<ast::Expression> Parser::relational() {
        std::vector<std::shared_ptr<ast::Expression>> exprs;
        std::vector<std::shared_ptr<Token>> ops;
        exprs.push_back(bit_or());

        while (match(TokenType::LT) || match(TokenType::LE) || match(TokenType::EQ) || match(TokenType::NE) ||
               match(TokenType::GE) || match(TokenType::GT)) {
            ops.push_back(current());
            exprs.push_back(bit_or());
        }

        if (exprs.size() == 1) return exprs[0];
        return std::make_shared<ast::expr::ChainBinary>(exprs, ops);
    }

    std::shared_ptr<ast::Expression> Parser::bit_or() {
        auto left = bit_xor();
        while (match(TokenType::PIPE)) {
            auto op = current();
            auto right = bit_xor();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::bit_xor() {
        auto left = bit_and();
        while (match(TokenType::CARET)) {
            auto op = current();
            auto right = bit_and();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::bit_and() {
        auto left = shift();
        while (match(TokenType::AMPERSAND)) {
            auto op = current();
            auto right = shift();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::shift() {
        auto left = term();
        while (match(TokenType::LSHIFT) || match(TokenType::RSHIFT) || match(TokenType::URSHIFT)) {
            auto op = current();
            auto right = term();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::term() {
        auto left = factor();
        while (match(TokenType::PLUS) || match(TokenType::DASH)) {
            auto op = current();
            auto right = factor();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::factor() {
        auto left = power();
        while (match(TokenType::STAR) || match(TokenType::SLASH) || match(TokenType::PERCENT)) {
            auto op = current();
            auto right = power();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::power() {
        std::vector<std::shared_ptr<Token>> ops;
        std::vector<std::shared_ptr<ast::Expression>> exprs;
        exprs.push_back(cast());
        while (match(TokenType::STAR_STAR)) {
            ops.push_back(current());
            exprs.push_back(cast());
        }
        std::shared_ptr<ast::Expression> expr = exprs.back();
        for (int i = static_cast<int>(ops.size()) - 1; i >= 0; i--) {
            expr = std::make_shared<ast::expr::Binary>(exprs[i], ops[i], expr);
        }
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::cast() {
        auto expr = elvis();
        while (match(TokenType::AS)) {
            auto safe = match(TokenType::HOOK);
            auto cast_type = type();
            expr = std::make_shared<ast::expr::Cast>(expr, safe, cast_type);
        }
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::elvis() {
        auto left = unary();
        while (match(TokenType::ELVIS)) {
            auto op = current();
            auto right = unary();
            left = std::make_shared<ast::expr::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::unary() {
        if (match(TokenType::BANG) || match(TokenType::TILDE) || match(TokenType::DASH) || match(TokenType::PLUS)) {
            auto op = current();
            auto expr = unary();
            return std::make_shared<ast::expr::Unary>(op, expr);
        }
        auto expr = postfix();
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::postfix() {
        auto caller = primary();
        std::shared_ptr<Token> safe = null;
        switch (peek()->get_type()) {
            case TokenType::HOOK:
                safe = advance();
                [[fallthrough]];
            case TokenType::DOT: {
                expect(TokenType::DOT);
                auto member = expect(TokenType::IDENTIFIER);
                return std::make_shared<ast::expr::DotAccess>(caller, member, safe);
            }
            default:
                break;
        }
        return caller;
    }

    std::shared_ptr<ast::Expression> Parser::primary() {
        switch (peek()->get_type()) {
            case TokenType::TRUE:
            case TokenType::FALSE:
            case TokenType::NULL_:
            case TokenType::INTEGER:
            case TokenType::FLOAT:
            case TokenType::STRING:
            case TokenType::IDENTIFIER:
                return std::make_shared<ast::expr::Constant>(advance());

            case TokenType::SUPER: {
                std::shared_ptr<Token> end;
                std::shared_ptr<Token> start = end = advance();
                if (match(TokenType::LBRACKET)) {
                    auto ref = reference();
                    end = expect(TokenType::RBRACKET);
                    return std::make_shared<ast::expr::Super>(start, end, ref);
                }
                return std::make_shared<ast::expr::Super>(start, end, null);
            }

            case TokenType::SELF:
                return std::make_shared<ast::expr::Self>(advance());
            default:
                throw error(std::format("expected {}",
                                        make_expected_string(TokenType::TRUE, TokenType::FALSE, TokenType::NULL_,
                                                             TokenType::INTEGER, TokenType::FLOAT, TokenType::STRING,
                                                             TokenType::IDENTIFIER, TokenType::SUPER, TokenType::SELF)));
        }
    }

    std::shared_ptr<ast::Type> Parser::type() {
        return union_type();
    }

    std::shared_ptr<ast::Type> Parser::union_type() {
        auto left = intersection_type();
        while (match(TokenType::PIPE)) {
            auto op = current();
            auto right = intersection_type();
            left = std::make_shared<ast::type::BinaryOp>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Type> Parser::intersection_type() {
        auto left = nullable_type();
        while (match(TokenType::AMPERSAND)) {
            auto op = current();
            auto right = nullable_type();
            left = std::make_shared<ast::type::BinaryOp>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Type> Parser::nullable_type() {
        auto type = primary_type();
        if (match(TokenType::HOOK)) return std::make_shared<ast::type::Nullable>(current(), type);
        return type;
    }

    std::shared_ptr<ast::Type> Parser::primary_type() {
        switch (peek()->get_type()) {
            case TokenType::IDENTIFIER: {
                auto ref = reference();
                if (match(TokenType::LBRACKET)) {
                    auto list = type_list();
                    auto end = expect(TokenType::RBRACKET);
                    return std::make_shared<ast::type::Reference>(end, ref, list);
                }
                return std::make_shared<ast::type::Reference>(ref);
            }
            case TokenType::TYPE:
                return std::make_shared<ast::type::TypeLiteral>(advance());
            case TokenType::LPAREN: {
                auto start = advance();
                return rule_or<ast::Type, ast::type::Function, ast::Type>(
                        [&] {
                            std::vector<std::shared_ptr<ast::Type>> params;
                            if (!match(TokenType::RPAREN)) {
                                params = type_list();
                                expect(TokenType::RPAREN);
                            }
                            expect(TokenType::ARROW);
                            auto ret_type = type();
                            return std::make_shared<ast::type::Function>(start, params, ret_type);
                        },
                        [&] {
                            auto grouped = type();
                            expect(TokenType::RPAREN);
                            return grouped;
                        });
            }
            default:
                throw error(std::format("expected {}",
                                        make_expected_string(TokenType::IDENTIFIER, TokenType::TYPE, TokenType::LPAREN)));
        }
    }

    std::vector<std::shared_ptr<ast::Type>> Parser::type_list() {
        std::vector<std::shared_ptr<ast::Type>> list;
        list.push_back(type());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::Type>([this] { return type(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }

    std::vector<std::shared_ptr<ast::Expression>> Parser::assignee_list() {
        std::vector<std::shared_ptr<ast::Expression>> list;
        list.push_back(postfix());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::Expression>([this] { return postfix(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }

    std::vector<std::shared_ptr<ast::Expression>> Parser::expr_list() {
        std::vector<std::shared_ptr<ast::Expression>> list;
        list.push_back(expression());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::Expression>([this] { return expression(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }
}    // namespace spade