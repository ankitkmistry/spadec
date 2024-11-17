#include "parser.hpp"

#include "utils/utils.hpp"

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

    std::shared_ptr<ast::Expression> Parser::or_() {
        auto left = and_();
        while (match(TokenType::OR)) {
            auto op = current();
            auto right = and_();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::and_() {
        auto left = not_();
        while (match(TokenType::AND)) {
            auto op = current();
            auto right = not_();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::not_() {
        if (match(TokenType::NOT)) {
            auto op = current();
            auto expr = not_();
            return std::make_shared<ast::Unary>(op, expr);
        }
        auto expr = conditional();
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::bit_or() {
        auto left = bit_xor();
        while (match(TokenType::PIPE)) {
            auto op = current();
            auto right = bit_xor();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::bit_xor() {
        auto left = bit_and();
        while (match(TokenType::CARET)) {
            auto op = current();
            auto right = bit_and();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::bit_and() {
        auto left = shift();
        while (match(TokenType::AMPERSAND)) {
            auto op = current();
            auto right = shift();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::shift() {
        auto left = term();
        while (match(TokenType::LSHIFT) || match(TokenType::RSHIFT) || match(TokenType::URSHIFT)) {
            auto op = current();
            auto right = term();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::term() {
        auto left = factor();
        while (match(TokenType::PLUS) || match(TokenType::DASH)) {
            auto op = current();
            auto right = factor();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::factor() {
        auto left = power();
        while (match(TokenType::STAR) || match(TokenType::SLASH) || match(TokenType::PERCENT)) {
            auto op = current();
            auto right = power();
            left = std::make_shared<ast::Binary>(left, op, right);
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
            expr = std::make_shared<ast::Binary>(exprs[i], ops[i], expr);
        }
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::elvis() {
        auto left = unary();
        while (match(TokenType::ELVIS)) {
            auto op = current();
            auto right = unary();
            left = std::make_shared<ast::Binary>(left, op, right);
        }
        return left;
    }

    std::shared_ptr<ast::Expression> Parser::unary() {
        if (match(TokenType::BANG) || match(TokenType::TILDE) || match(TokenType::DASH) || match(TokenType::PLUS)) {
            auto op = current();
            auto expr = unary();
            return std::make_shared<ast::Unary>(op, expr);
        }
        auto expr = postfix();
        return expr;
    }

    std::shared_ptr<ast::Expression> Parser::postfix() {
        auto caller = primary();
        bool safe = false;
        switch (peek()->get_type()) {
            case TokenType::HOOK:
                safe = true;
                advance();
            case TokenType::DOT: {
                expect(TokenType::DOT);
                auto member = expect(TokenType::IDENTIFIER);
                return safe ? std::make_shared<ast::SafeDotAccess>(caller, member)
                            : std::make_shared<ast::DotAccess>(caller, member);
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
            case TokenType::NULL:
            case TokenType::INTEGER:
            case TokenType::FLOAT:
            case TokenType::STRING:
            case TokenType::IDENTIFIER:
                return std::make_shared<ast::Constant>(advance());

            case TokenType::SUPER: {
                std::shared_ptr<Token> end;
                std::shared_ptr<Token> start = end = expect(TokenType::SUPER);
                if (match(TokenType::LBRACKET)) {
                    auto ref = reference();
                    end = expect(TokenType::RBRACKET);
                    return std::make_shared<ast::Super>(start, end, ref);
                }
                return std::make_shared<ast::Super>(start, end, null);
            }

            case TokenType::SELF:
                return std::make_shared<ast::Self>(advance());
            default:
                throw error(std::format("expected {}",
                                        make_expected_string(TokenType::TRUE, TokenType::FALSE, TokenType::NULL,
                                                             TokenType::INTEGER, TokenType::FLOAT, TokenType::STRING,
                                                             TokenType::IDENTIFIER, TokenType::SUPER, TokenType::SELF)));
        }
    }
}    // namespace spade