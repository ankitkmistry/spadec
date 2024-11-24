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
            if (token->get_type() == TokenType::END_OF_FILE && !tokens.empty() &&
                tokens.back()->get_type() == TokenType::END_OF_FILE)
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

    std::shared_ptr<Token> Parser::peek(int i) {
        auto idx = index + i;
        if (idx >= tokens.size()) {
            fill_tokens_buffer(FILL_CONSTANT);
            if (idx >= tokens.size()) return tokens.back();    // EOF
        }
        return tokens[idx];
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

    std::shared_ptr<ast::Declaration> Parser::function_decl() {
        auto token = expect(TokenType::FUN);
        auto name = expect(TokenType::IDENTIFIER);
        expect(TokenType::LPAREN);
        std::shared_ptr<ast::decl::Params> fun_params;
        if (peek()->get_type() != TokenType::RPAREN) fun_params = params();
        expect(TokenType::RPAREN);
        std::shared_ptr<ast::Type> ret_type;
        if (match(TokenType::ARROW)) ret_type = type();
        std::shared_ptr<ast::Statement> def;
        if (match(TokenType::EQUAL)) def = statement();
        else if (peek()->get_type() == TokenType::LBRACE)
            def = block();
        return std::make_shared<ast::decl::Function>(token, current(), name, fun_params, ret_type, def);
    }

    std::shared_ptr<ast::decl::Params> Parser::params() {
        const static std::vector<std::shared_ptr<ast::decl::Param>> EMPTY;
        std::vector<std::shared_ptr<ast::decl::Param>> param_list1 = param_list();
        std::vector<std::shared_ptr<ast::decl::Param>> param_list2;
        std::vector<std::shared_ptr<ast::decl::Param>> param_list3;
        if (current()->get_type() == TokenType::COMMA && match(TokenType::STAR)) {
            expect(TokenType::COMMA);
            param_list2 = param_list();
        }
        if (current()->get_type() == TokenType::COMMA && match(TokenType::SLASH)) {
            expect(TokenType::COMMA);
            param_list3 = param_list();
        }
        if (param_list2.empty() && param_list3.empty())
            return std::make_shared<ast::decl::Params>(param_list1.front(), current(), EMPTY, param_list1, EMPTY);
        if (param_list2.empty())
            return std::make_shared<ast::decl::Params>(param_list1.front(), current(), EMPTY, param_list1, param_list3);
        if (param_list3.empty())
            return std::make_shared<ast::decl::Params>(param_list1.front(), current(), param_list1, param_list2, EMPTY);
        return std::make_shared<ast::decl::Params>(param_list1.front(), current(), param_list1, param_list2, param_list3);
    }

    std::shared_ptr<ast::decl::Param> Parser::param() {
        auto is_const = match(TokenType::CONST);
        auto variadic = match(TokenType::STAR);
        auto name = expect(TokenType::IDENTIFIER);
        std::shared_ptr<ast::Type> param_type;
        std::shared_ptr<ast::Expression> expr;
        if (match(TokenType::COLON)) param_type = type();
        if (match(TokenType::EQUAL)) expr = expression();
        int line_start, col_start, line_end, col_end;
        if (is_const) {
            line_start = is_const->get_line_start();
            col_start = is_const->get_col_start();
        } else if (variadic) {
            line_start = variadic->get_line_start();
            col_start = variadic->get_col_start();
        } else {
            line_start = name->get_line_start();
            col_start = name->get_col_start();
        }
        if (expr) {
            line_end = expr->get_line_end();
            col_end = expr->get_col_end();
        } else if (param_type) {
            line_end = param_type->get_line_end();
            col_end = param_type->get_col_end();
        } else {
            line_end = name->get_line_end();
            col_end = name->get_col_end();
        }
        return std::make_shared<ast::decl::Param>(line_start, line_end, col_start, col_end, is_const, variadic, name,
                                                  param_type, expr);
    }

    std::shared_ptr<ast::Statement> Parser::statements() {
        if (peek()->get_type() == TokenType::LBRACE) return block();
        return statement();
    }

    std::shared_ptr<ast::Statement> Parser::block() {
        auto start = expect(TokenType::LBRACE);
        std::vector<std::shared_ptr<ast::Statement>> stmts;
        while (peek()->get_type() != TokenType::RBRACE) stmts.push_back(statement());
        auto end = expect(TokenType::RBRACE);
        return std::make_shared<ast::stmt::Block>(start, end, stmts);
    }

    std::shared_ptr<ast::Statement> Parser::statement() {
        switch (peek()->get_type()) {
            case TokenType::IF:
                return if_stmt();
            case TokenType::WHILE:
                return while_stmt();
            case TokenType::DO:
                return do_while_stmt();
            case TokenType::TRY:
                return try_stmt();
            case TokenType::CONTINUE:
                return std::make_shared<ast::stmt::Continue>(advance());
            case TokenType::BREAK:
                return std::make_shared<ast::stmt::Break>(advance());
            case TokenType::THROW: {
                auto token = advance();
                auto expr = expression();
                return std::make_shared<ast::stmt::Throw>(token, expr);
            }
            case TokenType::RETURN: {
                auto token = advance();
                auto expr = expression();
                return std::make_shared<ast::stmt::Return>(token, expr);
            }
            case TokenType::YIELD: {
                auto token = advance();
                auto expr = expression();
                return std::make_shared<ast::stmt::Yield>(token, expr);
            }
            default: {
                int tok_idx = index;
                try {
                    return std::make_shared<ast::stmt::Expr>(expression());
                } catch (const ParserError &) {
                    index = tok_idx;
                    throw error("expected a statement or expression");
                }
            }
        }
    }

#define BODY() (match(TokenType::COLON) ? statement() : block())

    std::shared_ptr<ast::Statement> Parser::if_stmt() {
        auto token = expect(TokenType::IF);
        auto expr = expression();
        auto body = BODY();
        auto else_body = match(TokenType::ELSE) ? BODY() : null;
        return std::make_shared<ast::stmt::If>(token, expr, body, else_body);
    }

    std::shared_ptr<ast::Statement> Parser::while_stmt() {
        auto token = expect(TokenType::WHILE);
        auto expr = expression();
        auto body = BODY();
        auto else_body = match(TokenType::ELSE) ? BODY() : null;
        return std::make_shared<ast::stmt::While>(token, expr, body, else_body);
    }

    std::shared_ptr<ast::Statement> Parser::do_while_stmt() {
        auto token = expect(TokenType::DO);
        auto body = block();
        expect(TokenType::WHILE);
        auto expr = expression();
        auto else_body = match(TokenType::ELSE) ? BODY() : null;
        return std::make_shared<ast::stmt::DoWhile>(token, body, expr, else_body);
    }

    std::shared_ptr<ast::Statement> Parser::try_stmt() {
        auto token = expect(TokenType::TRY);
        auto body = BODY();
        std::shared_ptr<ast::Statement> finally;
        std::vector<std::shared_ptr<ast::Statement>> catches;
        if (match(TokenType::FINALLY)) finally = BODY();
        else {
            do {
                catches.push_back(catch_stmt());
            } while (peek()->get_type() == TokenType::CATCH);
            if (match(TokenType::FINALLY)) finally = BODY();
        }
        return std::make_shared<ast::stmt::Try>(token, body, catches, finally);
    }

    std::shared_ptr<ast::Statement> Parser::catch_stmt() {
        auto token = expect(TokenType::CATCH);
        auto refs = reference_list();
        std::shared_ptr<Token> symbol;
        if (match(TokenType::AS)) symbol = expect(TokenType::IDENTIFIER);
        auto body = BODY();
        return std::make_shared<ast::stmt::Catch>(token, refs, symbol, body);
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
        return conditional();
    }

    std::shared_ptr<ast::Expression> Parser::conditional() {
        auto left = relational();
        std::shared_ptr<Token> op;
        std::shared_ptr<Token> op_extra;
        switch (peek()->get_type()) {
            case TokenType::IS:
                op = advance();
                op_extra = match(TokenType::NOT);
                break;
            case TokenType::NOT:
                op = advance();
                op_extra = expect(TokenType::IN);
                break;
            case TokenType::IN:
                op = advance();
                break;
            default:
                break;
        }
        if (op) {
            auto right = relational();
            left = std::make_shared<ast::expr::Binary>(left, op, op_extra, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::relational() {
        std::vector<std::shared_ptr<ast::Expression>> exprs;
        std::vector<std::shared_ptr<Token>> ops;
        auto expr = bit_or();
        while (true) {
            switch (peek()->get_type()) {
                case TokenType::LT:
                case TokenType::LE:
                case TokenType::EQ:
                case TokenType::NE:
                case TokenType::GE:
                case TokenType::GT:
                    ops.push_back(advance());
                    if (exprs.empty()) exprs.push_back(expr);
                    exprs.push_back(bit_or());
                    break;
                default:
                    if (exprs.empty()) return expr;
                    return std::make_shared<ast::expr::ChainBinary>(exprs, ops);
            }
        }
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
        switch (peek()->get_type()) {
            case TokenType::BANG:
            case TokenType::TILDE:
            case TokenType::DASH:
            case TokenType::PLUS: {
                auto op = advance();
                auto expr = unary();
                return std::make_shared<ast::expr::Unary>(op, expr);
            }
            default:
                return postfix();
        }
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
            case TokenType::LPAREN: {
                advance();
                std::vector<std::shared_ptr<ast::expr::Argument>> args;
                auto end = match(TokenType::RPAREN);
                if (!end) {
                    args = argument_list();
                    end = expect(TokenType::RPAREN);
                }
                return std::make_shared<ast::expr::Call>(end, caller, args);
            }
            case TokenType::LBRACKET: {
                advance();
                return rule_or<ast::Expression, ast::expr::Index, ast::expr::Reify>(
                        [&] {
                            auto slices = slice_list();
                            auto end = expect(TokenType::RBRACKET);
                            return std::make_shared<ast::expr::Index>(end, caller, slices);
                        },
                        [&] {
                            auto type_args = type_list();
                            auto end = expect(TokenType::RBRACKET);
                            return std::make_shared<ast::expr::Reify>(end, caller, type_args);
                        });
            }
            default:
                break;
        }
        return caller;
    }

    std::shared_ptr<ast::expr::Argument> Parser::argument() {
        std::shared_ptr<Token> name;
        if (peek()->get_type() == TokenType::IDENTIFIER && peek(1)->get_type() == TokenType::COLON) {
            name = advance();
            advance();
        }
        auto expr = expression();
        return name ? std::make_shared<ast::expr::Argument>(name, expr) : std::make_shared<ast::expr::Argument>(expr);
    }

    std::shared_ptr<ast::expr::Slice> Parser::slice() {
        std::shared_ptr<ast::Expression> from = null;
        std::shared_ptr<ast::Expression> to = null;
        std::shared_ptr<ast::Expression> step = null;

        if (peek()->get_type() != TokenType::COLON) from = expression();
        std::shared_ptr<Token> c1 = match(TokenType::COLON);
        if (c1 && peek()->get_type() != TokenType::COLON) to = rule_optional<ast::Expression>([&] { return expression(); });
        std::shared_ptr<Token> c2 = match(TokenType::COLON);
        if (c2) step = rule_optional<ast::Expression>([&] { return expression(); });

        auto kind = ast::expr::Slice::Kind::SLICE;
        if (from && !c1 && !to && !c2 && !step) kind = ast::expr::Slice::Kind::INDEX;

        int line_start, col_start;
        int line_end, col_end;
        // Determine line, col starting
        if (from) {
            line_start = from->get_line_start();
            col_start = from->get_col_start();
        } else if (c1) {
            line_start = c1->get_line();
            col_start = c1->get_col();
        } else if (to) {
            line_start = to->get_line_start();
            col_start = to->get_col_start();
        } else if (c2) {
            line_start = c2->get_line();
            col_start = c2->get_col();
        } else if (step) {
            line_start = step->get_line_start();
            col_start = step->get_col_start();
        } else
            throw error("expected ':', <expression>");
        // Determine line, col ending
        if (step) {
            line_end = step->get_line_end();
            col_end = step->get_col_end();
        } else if (c2) {
            line_end = c2->get_line();
            col_end = c2->get_col();
        } else if (to) {
            line_end = to->get_line_end();
            col_end = to->get_col_end();
        } else if (c1) {
            line_end = c1->get_line();
            col_end = c1->get_col();
        } else if (from) {
            line_end = from->get_line_end();
            col_end = from->get_col_end();
        } else
            throw error("expected ':', <expression>");
        return std::make_shared<ast::expr::Slice>(line_start, line_end, col_start, col_end, kind, from, to, step);
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
            case TokenType::LPAREN: {
                advance();
                auto expr = expression();
                expect(TokenType::RPAREN);
                return expr;
            }
            default:
                throw error(
                        std::format("expected {}", make_expected_string(TokenType::TRUE, TokenType::FALSE, TokenType::NULL_,
                                                                        TokenType::INTEGER, TokenType::FLOAT, TokenType::STRING,
                                                                        TokenType::IDENTIFIER, TokenType::SUPER,
                                                                        TokenType::SELF, TokenType::LPAREN)));
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

    std::vector<std::shared_ptr<ast::expr::Argument>> Parser::argument_list() {
        std::vector<std::shared_ptr<ast::expr::Argument>> list;
        list.push_back(argument());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::expr::Argument>([this] { return argument(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }

    std::vector<std::shared_ptr<ast::expr::Slice>> Parser::slice_list() {
        std::vector<std::shared_ptr<ast::expr::Slice>> list;
        list.push_back(slice());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::expr::Slice>([this] { return slice(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }

    std::vector<std::shared_ptr<ast::Reference>> Parser::reference_list() {
        std::vector<std::shared_ptr<ast::Reference>> list;
        list.push_back(reference());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::Reference>([this] { return reference(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }

    std::vector<std::shared_ptr<ast::decl::Param>> Parser::param_list() {
        std::vector<std::shared_ptr<ast::decl::Param>> list;
        list.push_back(param());
        while (match(TokenType::COMMA)) {
            if (auto item = rule_optional<ast::decl::Param>([this] { return param(); })) {
                list.push_back(item);
            } else
                break;
        }
        return list;
    }
}    // namespace spade