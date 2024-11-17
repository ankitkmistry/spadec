#pragma once
#include "ast.hpp"
#include "lexer.hpp"

namespace spade
{
    class Parser final {
        static constexpr int FILL_CONSTANT = 64;

      private:
        Lexer *lexer;
        std::vector<std::shared_ptr<Token>> tokens;
        int index = 0;

        void fill_tokens_buffer(int n);

        std::shared_ptr<Token> current();
        std::shared_ptr<Token> peek();
        std::shared_ptr<Token> advance();

        std::shared_ptr<Token> match(TokenType type);
        std::shared_ptr<Token> expect(TokenType type);

        ParserError error(const string &msg, std::shared_ptr<Token> token);
        ParserError error(const string &msg);

        // Parser rules


      public:
        std::shared_ptr<ast::Reference> reference();

        std::shared_ptr<ast::Constant> constant();
        std::shared_ptr<ast::Super> super();
        std::shared_ptr<ast::Self> self();

        explicit Parser(Lexer *lexer) : lexer(lexer) {}

        Parser(const Parser &other) = default;
        Parser(Parser &&other) noexcept = default;
        Parser &operator=(const Parser &other) = default;
        Parser &operator=(Parser &&other) noexcept = default;
        ~Parser() = default;

        Lexer *get_lexer() const {
            return lexer;
        }
    };
}    // namespace spade