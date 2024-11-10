#pragma once
#include "lexer.hpp"

namespace spade
{
    namespace ast
    {
        class AstNode {
          protected:
            int line_start;
            int line_end;
            int col_start;
            int col_end;

          public:
            AstNode(int line_start, int line_end, int col_start, int col_end)
                : line_start(line_start), line_end(line_end), col_start(col_start), col_end(col_end) {}

            AstNode(std::shared_ptr<Token> start, std::shared_ptr<Token> end)
                : line_start(start->get_line()),
                  line_end(end->get_line()),
                  col_start(start->get_col()),
                  col_end(end->get_col()) {}

            AstNode(std::shared_ptr<AstNode> start, std::shared_ptr<AstNode> end)
                : line_start(start->get_line_start()),
                  line_end(end->get_line_end()),
                  col_start(start->get_col_start()),
                  col_end(end->get_col_end()) {}

            AstNode(std::shared_ptr<Token> start, std::shared_ptr<AstNode> end)
                : line_start(start->get_line()),
                  line_end(end->get_line_end()),
                  col_start(start->get_col()),
                  col_end(end->get_col_end()) {}

            AstNode(std::shared_ptr<AstNode> start, std::shared_ptr<Token> end)
                : line_start(start->get_line_start()),
                  line_end(end->get_line()),
                  col_start(start->get_col_start()),
                  col_end(end->get_col()) {}

            AstNode(const AstNode &other) = default;
            AstNode(AstNode &&other) noexcept = default;
            AstNode &operator=(const AstNode &other) = default;
            AstNode &operator=(AstNode &&other) noexcept = default;
            virtual ~AstNode() = default;

            int get_line_start() const {
                return line_start;
            }

            int get_line_end() const {
                return line_end;
            }

            int get_col_start() const {
                return col_start;
            }

            int get_col_end() const {
                return col_end;
            }
        };

        class Reference : public AstNode {
            std::vector<std::shared_ptr<Token>> path;

          public:
            explicit Reference(std::vector<std::shared_ptr<Token>> path) : AstNode(path.front(), path.back()), path(path) {}

            const std::vector<std::shared_ptr<Token>> &get_path() const {
                return path;
            }
        };

        class Type : public AstNode {};

        class Expression : public AstNode {
          public:
            Expression(std::shared_ptr<Token> start, std::shared_ptr<Token> end) : AstNode(start, end) {}

            Expression(std::shared_ptr<AstNode> start, std::shared_ptr<AstNode> end) : AstNode(start, end) {}

            Expression(std::shared_ptr<Token> start, std::shared_ptr<AstNode> end) : AstNode(start, end) {}

            Expression(std::shared_ptr<AstNode> start, std::shared_ptr<Token> end) : AstNode(start, end) {}
        };

        class Constant : public Expression {
            std::shared_ptr<Token> token;

          public:
            Constant(std::shared_ptr<Token> token) : Expression(token, token), token(token) {}

            std::shared_ptr<Token> get_token() const {
                return token;
            }
        };

        class Super : public Expression {
            std::shared_ptr<Reference> reference;

          public:
            Super(std::shared_ptr<Token> start, std::shared_ptr<Token> end, std::shared_ptr<Reference> reference)
                : Expression(start, end), reference(reference) {}

            std::shared_ptr<Reference> get_reference() const {
                return reference;
            }
        };

        class Self : public Expression {
            Self(std::shared_ptr<Token> self) : Expression(self, self) {}
        };

        class Postfix : public Expression {
          protected:
            std::shared_ptr<Expression> caller;

          public:
            Postfix(std::shared_ptr<Token> end, std::shared_ptr<Expression> caller) : Expression(caller, end), caller(caller) {}

            std::shared_ptr<Expression> get_caller() const {
                return caller;
            }
        };

        class Argument : public AstNode {
            std::shared_ptr<Token> name;
            std::shared_ptr<Expression> expr;

          public:
            Argument(std::shared_ptr<Token> name, std::shared_ptr<Expression> expr)
                : AstNode(name, expr), name(name), expr(expr) {}

            Argument(std::shared_ptr<Expression> expr) : AstNode(expr, expr), name(null), expr(expr) {}

            std::shared_ptr<Token> get_name() const {
                return name;
            }

            std::shared_ptr<Expression> get_expr() const {
                return expr;
            }
        };

        class Call : public Postfix {
            std::vector<std::shared_ptr<Argument>> args;

          public:
            const std::vector<std::shared_ptr<Argument>> &get_args() const {
                return args;
            }
        };

        class Reify : public Postfix {
            std::vector<std::shared_ptr<Type>> type_args;

          public:
            const std::vector<std::shared_ptr<Type>> &get_type_args() const {
                return type_args;
            }
        };

        class Slice : public AstNode {
          public:
            enum class Kind { INDEX, SLICE };

          private:
            Kind kind;
            std::shared_ptr<Expression> from;
            std::shared_ptr<Expression> to;
            std::shared_ptr<Expression> step;

          public:
            Slice(std::shared_ptr<Token> start, std::shared_ptr<Token> end, Kind kind, std::shared_ptr<Expression> from,
                  std::shared_ptr<Expression> to, std::shared_ptr<Expression> step)
                : AstNode(start, end), kind(kind), from(from), to(to), step(step) {}

            Kind get_kind() const {
                return kind;
            }

            std::shared_ptr<Expression> get_from() const {
                return from;
            }

            std::shared_ptr<Expression> get_to() const {
                return to;
            }

            std::shared_ptr<Expression> get_step() const {
                return step;
            }
        };

        class Index : public Postfix {
            std::vector<Slice> slices;

          public:
            Index(std::shared_ptr<Token> end, std::shared_ptr<Expression> caller, const std::vector<Slice> &slices)
                : Postfix(end, caller), slices(std::move(slices)) {}

            const std::vector<Slice> &get_slices() const {
                return slices;
            }
        };

        class Unary : public Expression {
            std::shared_ptr<Token> op;
            std::shared_ptr<Expression> expr;

          public:
            Unary(std::shared_ptr<Token> op, std::shared_ptr<Expression> expr) : Expression(op, expr), op(op), expr(expr) {}

            std::shared_ptr<Token> get_op() const {
                return op;
            }

            std::shared_ptr<Expression> get_expr() const {
                return expr;
            }
        };

        class Binary : public Expression {
          protected:
            std::shared_ptr<Expression> left;
            std::shared_ptr<Token> op;
            std::shared_ptr<Expression> right;

          public:
            Binary(std::shared_ptr<Expression> left, std::shared_ptr<Token> op, std::shared_ptr<Expression> right)
                : Expression(left, right), left(left), op(op), right(right) {}

            std::shared_ptr<Expression> get_left() const {
                return left;
            }

            std::shared_ptr<Token> get_op() const {
                return op;
            }

            std::shared_ptr<Expression> get_right() const {
                return right;
            }
        };

        class Binary2 : public Binary {
          private:
            std::shared_ptr<Token> op_extra;

          public:
            Binary2(std::shared_ptr<Expression> left, std::shared_ptr<Token> op, std::shared_ptr<Token> op_extra,
                    std::shared_ptr<Expression> right)
                : Binary(left, op, right), op_extra(op_extra) {}

            std::shared_ptr<Token> get_op_extra() const {
                return op_extra;
            }
        };

        class Ternary : public Expression {
            std::shared_ptr<Expression> condition;
            std::shared_ptr<Expression> on_true;
            std::shared_ptr<Expression> on_false;

          public:
            Ternary(std::shared_ptr<Expression> condition, std::shared_ptr<Expression> on_true,
                    std::shared_ptr<Expression> on_false)
                : Expression(condition, on_false), condition(condition), on_true(on_true), on_false(on_false) {}

            std::shared_ptr<Expression> get_condition() const {
                return condition;
            }

            std::shared_ptr<Expression> get_on_true() const {
                return on_true;
            }

            std::shared_ptr<Expression> get_on_false() const {
                return on_false;
            }
        };

        class Assignment : public Expression {
            std::vector<std::shared_ptr<Expression>> assignees;
            std::vector<std::shared_ptr<Expression>> exprs;

          public:
            Assignment(const std::vector<std::shared_ptr<Expression>> &assignees,
                       const std::vector<std::shared_ptr<Expression>> &exprs)
                : Expression(assignees.front(), exprs.back()), assignees(assignees), exprs(exprs) {}

            const std::vector<std::shared_ptr<Expression>> &get_assignees() const {
                return assignees;
            }

            const std::vector<std::shared_ptr<Expression>> &get_exprs() const {
                return exprs;
            }
        };
    }    // namespace ast

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

        // Parser rules
        ast::Constant constant();

      public:
        explicit Parser(Lexer *lexer) : lexer(lexer) {}

        Parser(const Parser &other) = default;
        Parser(Parser &&other) noexcept = default;
        Parser &operator=(const Parser &other) = default;
        Parser &operator=(Parser &&other) noexcept = default;
        ~Parser() = default;
    };
}    // namespace spade