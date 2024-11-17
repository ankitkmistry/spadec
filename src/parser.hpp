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

        template<typename R, typename C1, typename C2>
        std::shared_ptr<R> rule_or(std::function<std::shared_ptr<C1>()> rule1, std::function<std::shared_ptr<C2>()> rule2) {
            int tok_idx = index;
            try {
                return cast<R>(rule1());
            } catch (const ParserError &) {
                index = tok_idx;
                return cast<R>(rule2());
            }
        }

        template<typename R, typename C1, typename C2>
            requires std::same_as<R, C1> && std::same_as<R, C2>
        std::shared_ptr<R> rule_or(std::function<std::shared_ptr<C1>()> rule1, std::function<std::shared_ptr<C2>()> rule2) {
            int tok_idx = index;
            try {
                return rule1();
            } catch (const ParserError &) {
                index = tok_idx;
                return rule2();
            }
        }

      public:
        std::shared_ptr<ast::Reference> reference();

        // Expressions
        // Binary
        std::shared_ptr<ast::Expression> or_();
        std::shared_ptr<ast::Expression> and_();
        std::shared_ptr<ast::Expression> not_();
        std::shared_ptr<ast::Expression> conditional();
        std::shared_ptr<ast::Expression> relational();
        std::shared_ptr<ast::Expression> bit_or();
        std::shared_ptr<ast::Expression> bit_xor();
        std::shared_ptr<ast::Expression> bit_and();
        std::shared_ptr<ast::Expression> shift();
        std::shared_ptr<ast::Expression> term();
        std::shared_ptr<ast::Expression> factor();
        std::shared_ptr<ast::Expression> power();
        std::shared_ptr<ast::Expression> cast();
        std::shared_ptr<ast::Expression> elvis();
        // Unary
        std::shared_ptr<ast::Expression> unary();
        // Postfix
        std::shared_ptr<ast::Expression> postfix();
        // Primary
        std::shared_ptr<ast::Expression> primary();

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