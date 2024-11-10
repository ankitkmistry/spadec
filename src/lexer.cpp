#include "lexer.hpp"

#include "utils/error.hpp"

namespace spade
{
    const char *to_string(TokenType e) {
        switch (e) {
            case TokenType::LPAREN:
                return "LPAREN";
            case TokenType::RPAREN:
                return "RPAREN";
            case TokenType::LBRACE:
                return "LBRACE";
            case TokenType::RBRACE:
                return "RBRACE";
            case TokenType::LBRACKET:
                return "LBRACKET";
            case TokenType::RBRACKET:
                return "RBRACKET";
            case TokenType::LANGLE:
                return "LANGLE";
            case TokenType::RANGLE:
                return "RANGLE";
            case TokenType::BANG:
                return "BANG";
            case TokenType::TILDE:
                return "TILDE";
            case TokenType::PLUS:
                return "PLUS";
            case TokenType::DASH:
                return "DASH";
            case TokenType::STAR:
                return "STAR";
            case TokenType::SLASH:
                return "SLASH";
            case TokenType::PERCENT:
                return "PERCENT";
            case TokenType::AMPERSAND:
                return "AMPERSAND";
            case TokenType::PIPE:
                return "PIPE";
            case TokenType::CARET:
                return "CARET";
            case TokenType::DOT:
                return "DOT";
            case TokenType::COMMA:
                return "COMMA";
            case TokenType::EQUAL:
                return "EQUAL";
            case TokenType::COLON:
                return "COLON";
            case TokenType::PACKAGE:
                return "PACKAGE";
            case TokenType::IMPORT:
                return "IMPORT";
            case TokenType::EXPORT:
                return "EXPORT";
            case TokenType::EXTENDS:
                return "EXTENDS";
            case TokenType::IMPLEMENTS:
                return "IMPLEMENTS";
            case TokenType::ENUM:
                return "ENUM";
            case TokenType::CLASS:
                return "CLASS";
            case TokenType::INTERFACE:
                return "INTERFACE";
            case TokenType::ANNOTATION:
                return "ANNOTATION";
            case TokenType::INIT:
                return "INIT";
            case TokenType::FUN:
                return "FUN";
            case TokenType::CONST:
                return "CONST";
            case TokenType::VAR:
                return "VAR";
            case TokenType::ABSTRACT:
                return "ABSTRACT";
            case TokenType::FINAL:
                return "FINAL";
            case TokenType::STATIC:
                return "STATIC";
            case TokenType::INLINE:
                return "INLINE";
            case TokenType::PRIVATE:
                return "PRIVATE";
            case TokenType::PROTECTED:
                return "PROTECTED";
            case TokenType::INTERNAL:
                return "INTERNAL";
            case TokenType::PUBLIC:
                return "PUBLIC";
            case TokenType::IF:
                return "IF";
            case TokenType::ELSE:
                return "ELSE";
            case TokenType::WHILE:
                return "WHILE";
            case TokenType::DO:
                return "DO";
            case TokenType::FOR:
                return "FOR";
            case TokenType::IN:
                return "IN";
            case TokenType::MATCH:
                return "MATCH";
            case TokenType::WHEN:
                return "WHEN";
            case TokenType::THROW:
                return "THROW";
            case TokenType::TRY:
                return "TRY";
            case TokenType::CATCH:
                return "CATCH";
            case TokenType::FINALLY:
                return "FINALLY";
            case TokenType::CONTINUE:
                return "CONTINUE";
            case TokenType::BREAK:
                return "BREAK";
            case TokenType::RETURN:
                return "RETURN";
            case TokenType::YIELD:
                return "YIELD";
            case TokenType::AS:
                return "AS";
            case TokenType::IS:
                return "IS";
            case TokenType::NOT:
                return "NOT";
            case TokenType::AND:
                return "AND";
            case TokenType::OR:
                return "OR";
            case TokenType::SUPER:
                return "SUPER";
            case TokenType::THIS:
                return "THIS";
            case TokenType::TRUE:
                return "TRUE";
            case TokenType::FALSE:
                return "FALSE";
            case TokenType::NULL:
                return "NULL";
            case TokenType::OBJECT:
                return "OBJECT";
            case TokenType::TYPE:
                return "TYPE";
            case TokenType::TYPEOF:
                return "TYPEOF";
            case TokenType::IDENTIFIER:
                return "IDENTIFIER";
            case TokenType::INTEGER:
                return "INTEGER";
            case TokenType::FLOAT:
                return "FLOAT";
            case TokenType::STRING:
                return "STRING";
            case TokenType::END_OF_FILE:
                return "END_OF_FILE";
            default:
                return "unknown";
        }
    }

    std::shared_ptr<Token> make_token(TokenType type, const string &text, int line, int col) {
        return std::make_shared<Token>(type, text, line, col);
    }

    int Lexer::current() const {
        if (end - 1 >= length()) return EOF;
        return data[end - 1];
    }

    int Lexer::peek() const {
        if (end >= length()) return EOF;
        return data[end];
    }

    int Lexer::advance() {
        if (end >= length()) return EOF;
        return data[end++];
    }

    bool Lexer::match(int c) {
        if (peek() == c) {
            advance();
            return true;
        }
        return false;
    }

    bool Lexer::is_at_end() const {
        return peek() == EOF;
    }

    int Lexer::length() const {
        return static_cast<int>(data.size());
    }

    std::shared_ptr<Token> Lexer::get_token(TokenType type) {
        auto token = make_token(type, data.substr(start, end - start), line, col);
        start = end;
        return token;
    }

    LexerError Lexer::make_error(const string &msg) const {
        return {msg, line, col};
    }

    Lexer::Lexer(std::FILE *stream) {
        if (stream) {
            fseek(stream, 0, SEEK_END);
            size_t length = ftell(stream);
            fseek(stream, 0, SEEK_SET);
            if (auto buffer = new char[length]) {
                auto num_written = fread(buffer, 1, length, stream);
                data = string(buffer, num_written);
            }
        }
    }

    static bool is_binary_digit(int c) {
        return c == '0' || c == '1';
    }

    static bool is_octal_digit(int c) {
        return '0' <= c && c <= '7';
    }

    static bool is_decimal_digit(int c) {
        return '0' <= c && c <= '9';
    }

    static bool is_hex_digit(int c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F');
    }

    void Lexer::complete_float_part(std::function<bool(int)> validator, char exp1, char exp2) {
        int c;
        bool allow_underscore = false;
        while (true) {
            if (validator(c = peek()) || (allow_underscore && c == '_')) {
                advance();
                if (!allow_underscore) allow_underscore = true;
            } else
                break;
        }
        if (match(exp1) || match(exp2)) {
            if (match('+') || match('-')) {
                if (!is_decimal_digit(peek())) throw make_error("expected decimal digit");
                while (is_decimal_digit(c = peek())) advance();
            } else {
                throw make_error("expected '+', '-'");
            }
        }
    }

    std::shared_ptr<Token> Lexer::next_token() {
        if (!token_buffer.empty()) {
            auto token = token_buffer.top();
            token_buffer.pop();
            return token;
        }
        while (!is_at_end()) {
            start = end;
            int c = advance();
            col++;
            switch (c) {
                case '(':
                    return get_token(TokenType::LPAREN);
                case ')':
                    return get_token(TokenType::RPAREN);
                case '{':
                    return get_token(TokenType::LBRACE);
                case '}':
                    return get_token(TokenType::RBRACE);
                case '[':
                    return get_token(TokenType::LBRACKET);
                case ']':
                    return get_token(TokenType::RBRACKET);
                case '<':
                    return get_token(TokenType::LANGLE);
                case '>':
                    return get_token(TokenType::RANGLE);
                case '!':
                    return get_token(TokenType::BANG);
                case '~':
                    return get_token(TokenType::TILDE);
                case '+':
                    return get_token(TokenType::PLUS);
                case '-':
                    return get_token(TokenType::DASH);
                case '*':
                    return get_token(TokenType::STAR);
                case '/': {
                    if (match('/')) {
                        while (peek() != '\n') {
                            if (peek() == EOF) return get_token(TokenType::END_OF_FILE);
                            advance();
                        }
                    } else if (match('*')) {
                        while (true) {
                            if (match('*') && match('/')) break;
                            advance();
                        }
                    } else
                        return get_token(TokenType::SLASH);
                    break;
                }
                case '%':
                    return get_token(TokenType::PERCENT);
                case '&':
                    return get_token(TokenType::AMPERSAND);
                case '|':
                    return get_token(TokenType::PIPE);
                case '^':
                    return get_token(TokenType::CARET);
                case '.':
                    return get_token(TokenType::DOT);
                case ',':
                    return get_token(TokenType::COMMA);
                case '=':
                    return get_token(TokenType::EQUAL);
                case ':':
                    return get_token(TokenType::COLON);
                // String
                case '"':
                    while (true) {
                        if (peek() == EOF) throw make_error("expected '\"'");
                        if (match('\\')) advance();
                        if (match('"')) break;
                        advance();
                    }
                    return get_token(TokenType::STRING);
                case '\'':
                    while (true) {
                        if (peek() == EOF) throw make_error("expected '''");
                        if (match('\\')) advance();
                        if (match('\'')) break;
                        advance();
                    }
                    return get_token(TokenType::STRING);
                // Whitespace
                case ' ':
                case '\t':
                case '\r':
                    start = end;
                    break;
                case '\n':
                    line++;
                    col = 0;
                    start = end;
                    break;
                default: {
                    if (std::isalpha(c)) {
                        while (std::isalnum(c = peek()) || c == '_') advance();
                        auto token = get_token(TokenType::IDENTIFIER);
                        try {
                            auto type = KEYWORDS.at(token->get_text());
                            token->set_type(type);
                            return token;
                        } catch (const std::out_of_range &) {
                            return token;
                        }
                    }
                    if (is_decimal_digit(c)) {
                        if (c == '0') {
                            if (match('b') || match('B')) {
                                if (!is_binary_digit(peek())) throw make_error("expected binary digit");
                                while (is_binary_digit(c = peek()) || c == '_') advance();
                            } else if (match('x') || match('X')) {
                                if (!is_hex_digit(peek())) throw make_error("expected hexadecimal digit");
                                while (is_hex_digit(c = peek()) || c == '_') advance();
                                if (match('.')) {
                                    complete_float_part(is_hex_digit, 'p', 'P');
                                    return get_token(TokenType::FLOAT);
                                }
                            } else {
                                if (match('.')) {
                                    complete_float_part(is_decimal_digit, 'e', 'E');
                                    return get_token(TokenType::FLOAT);
                                }
                                while (is_octal_digit(c = peek()) || c == '_') advance();
                            }
                        } else {
                            while (is_decimal_digit(c = peek()) || c == '_') advance();
                            if (match('.')) {
                                complete_float_part(is_decimal_digit, 'e', 'E');
                                return get_token(TokenType::FLOAT);
                            }
                        }
                        return get_token(TokenType::INTEGER);
                    }
                    throw make_error(format("unexpected character: %lc", c));
                }
            }
        }
        return get_token(TokenType::END_OF_FILE);
    }

    void Lexer::pushback_token(std::shared_ptr<Token> token) {
        token_buffer.push(token);
    }
}    // namespace spade