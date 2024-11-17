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

    std::shared_ptr<ast::Constant> Parser::constant() {
        auto type = peek()->get_type();
        if (type == TokenType::TRUE || type == TokenType::FALSE || type == TokenType::NULL || type == TokenType::INTEGER ||
            type == TokenType::FLOAT || type == TokenType::STRING || type == TokenType::IDENTIFIER) {
            return std::make_shared<ast::Constant>(advance());
        }
        throw error(std::format("expected {}",
                                make_expected_string(TokenType::TRUE, TokenType::FALSE, TokenType::NULL, TokenType::INTEGER,
                                                     TokenType::FLOAT, TokenType::STRING, TokenType::IDENTIFIER)));
    }

    std::shared_ptr<ast::Super> Parser::super() {
        std::shared_ptr<Token> end;
        std::shared_ptr<Token> start = end = expect(TokenType::SUPER);
        if (match(TokenType::LBRACKET)) {
            auto ref = reference();
            end = expect(TokenType::RBRACKET);
            return std::make_shared<ast::Super>(start, end, ref);
        }
        return std::make_shared<ast::Super>(start, end, null);
    }

    std::shared_ptr<ast::Self> Parser::self() {
        return std::make_shared<ast::Self>(expect(TokenType::SELF));
    }
}    // namespace spade