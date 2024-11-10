#pragma once

#include <functional>
#include <unordered_map>

#include "utils/common.hpp"
#include "utils/error.hpp"
#include "utils/format.hpp"

namespace spade
{
    enum class TokenType {
        // Brackets
        LPAREN,
        RPAREN,
        LBRACE,
        RBRACE,
        LBRACKET,
        RBRACKET,
        LANGLE,
        RANGLE,
        // Operators
        BANG,
        TILDE,
        PLUS,
        DASH,
        STAR,
        SLASH,
        PERCENT,
        AMPERSAND,
        PIPE,
        CARET,
        DOT,
        COMMA,
        EQUAL,
        COLON,

        // Keywords
        // Heading
        PACKAGE,
        IMPORT,
        EXPORT,
        // Clauses
        EXTENDS,
        IMPLEMENTS,
        // Declarations
        ENUM,
        CLASS,
        INTERFACE,
        ANNOTATION,
        INIT,
        FUN,
        CONST,
        VAR,
        // Modifiers
        ABSTRACT,
        FINAL,
        STATIC,
        INLINE,
        // Accessors
        PRIVATE,
        PROTECTED,
        INTERNAL,
        PUBLIC,
        // Statements
        IF,
        ELSE,
        WHILE,
        DO,
        FOR,
        IN,
        MATCH,
        WHEN,
        THROW,
        TRY,
        CATCH,
        FINALLY,
        CONTINUE,
        BREAK,
        RETURN,
        YIELD,
        // Operators
        AS,
        IS,
        NOT,
        AND,
        OR,
        // Primary expressions
        SUPER,
        THIS,
        // Literals
        TRUE,
        FALSE,
        NULL,
        // Special keywords
        OBJECT,
        TYPE,
        TYPEOF,
        // Other types
        IDENTIFIER,
        INTEGER,
        FLOAT,
        STRING,
        // End of file
        END_OF_FILE
    };

    inline const char *to_string(TokenType e);

    class Token {
      private:
        TokenType type;
        string text;
        int line;
        int col;

      public:
        Token(TokenType type, string text, int line, int col) : type(type), text(std::move(text)), line(line), col(col) {}

        Token(const Token &other) = default;
        Token(Token &&other) noexcept = default;
        Token &operator=(const Token &other) = default;
        Token &operator=(Token &&other) noexcept = default;
        ~Token() = default;

        friend bool operator==(const Token &lhs, const Token &rhs) {
            return lhs.type == rhs.type && lhs.text == rhs.text;
        }

        friend bool operator!=(const Token &lhs, const Token &rhs) {
            return !(lhs == rhs);
        }

        bool operator==(TokenType type) const {
            return this->type == type;
        }

        bool operator!=(TokenType type) const {
            return this->type != type;
        }

        bool operator==(string text) const {
            return this->text == text;
        }

        bool operator!=(string text) const {
            return this->text != text;
        }

        string to_string() const {
            return format("[%02d:%02d] %s %s", line, col, spade::to_string(type), text.c_str());
        }

        TokenType get_type() const {
            return type;
        }

        void set_type(TokenType type) {
            this->type = type;
        }

        const string &get_text() const {
            return text;
        }

        void set_text(string text) {
            this->text = text;
        }

        int get_line() const {
            return line;
        }

        void set_line(int line) {
            this->line = line;
        }

        int get_col() const {
            return col;
        }

        void set_col(int col) {
            this->col = col;
        }
    };

    inline const static std::unordered_map<string, TokenType> KEYWORDS = {
            {
             "package", TokenType::PACKAGE,
             },
            {
             "import", TokenType::IMPORT,
             },
            {
             "export", TokenType::EXPORT,
             },
            {
             "extends", TokenType::EXTENDS,
             },
            {
             "implements", TokenType::IMPLEMENTS,
             },
            {
             "enum", TokenType::ENUM,
             },
            {
             "class", TokenType::CLASS,
             },
            {
             "interface", TokenType::INTERFACE,
             },
            {
             "annotation", TokenType::ANNOTATION,
             },
            {
             "init", TokenType::INIT,
             },
            {
             "fun", TokenType::FUN,
             },
            {
             "const", TokenType::CONST,
             },
            {
             "var", TokenType::VAR,
             },
            {
             "abstract", TokenType::ABSTRACT,
             },
            {
             "final", TokenType::FINAL,
             },
            {
             "static", TokenType::STATIC,
             },
            {
             "inline", TokenType::INLINE,
             },
            {
             "private", TokenType::PRIVATE,
             },
            {
             "protected", TokenType::PROTECTED,
             },
            {
             "internal", TokenType::INTERNAL,
             },
            {
             "public", TokenType::PUBLIC,
             },
            {"if", TokenType::IF},
            {"else", TokenType::ELSE},
            {"while", TokenType::WHILE},
            {"do", TokenType::DO},
            {"for", TokenType::FOR},
            {"in", TokenType::IN},
            {"match", TokenType::MATCH},
            {"when", TokenType::WHEN},
            {"throw", TokenType::THROW},
            {"try", TokenType::TRY},
            {"catch", TokenType::CATCH},
            {"finally", TokenType::FINALLY},
            {"continue", TokenType::CONTINUE},
            {"break", TokenType::BREAK},
            {"return", TokenType::RETURN},
            {"yield", TokenType::YIELD},
            {"as", TokenType::AS},
            {"is", TokenType::IS},
            {"not", TokenType::NOT},
            {"and", TokenType::AND},
            {"or", TokenType::OR},
            {"super", TokenType::SUPER},
            {"this", TokenType::THIS},
            {"true", TokenType::TRUE},
            {"false", TokenType::FALSE},
            {"null", TokenType::NULL},
            {"object", TokenType::OBJECT},
            {"type", TokenType::TYPE},
            {"typeof", TokenType::TYPEOF}
    };

    std::shared_ptr<Token> make_token(TokenType type, const string &text, int line, int col);

    class Lexer {
      private:
        string data;
        int start = 0;
        int end = 0;
        int line = 1;
        int col = 0;

        std::stack<std::shared_ptr<Token>> token_buffer;

        int current() const;
        int peek() const;
        int advance();
        bool match(int c);
        bool is_at_end() const;
        int length() const;

        std::shared_ptr<Token> get_token(TokenType type);
        LexerError make_error(const string &msg) const;

      public:
        explicit Lexer(std::FILE *stream);

        void complete_float_part(std::function<bool(int)> validator, char exp1, char exp2);
        std::shared_ptr<Token> next_token();

        void pushback_token(std::shared_ptr<Token> token);
    };
}    // namespace spade