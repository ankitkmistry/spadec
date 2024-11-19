#pragma once

#include <functional>

#include "token.hpp"
#include "utils/common.hpp"
#include "utils/error.hpp"

namespace spade
{
    class Lexer final {
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