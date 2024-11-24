#pragma once

#include "utils/common.hpp"
#include "lexer/token.hpp"
#include "utils/utils.hpp"

namespace spade::ast
{
    namespace decl
    {
        class Param;
        class Params;
        class Function;
    }    // namespace decl

    class Reference;
    class AstNode;
    class Expression;

    namespace expr
    {
        class Slice;
        class Argument;
        class Assignment;
        class Ternary;
        class ChainBinary;
        class Binary;
        class Cast;
        class Unary;
        class Index;
        class Reify;
        class Call;
        class DotAccess;
        class Self;
        class Super;
        class Constant;
    }    // namespace expr

    namespace type
    {
        class Nullable;
        class BinaryOp;
        class TypeOf;
        class TypeLiteral;
        class Function;
        class Reference;
    }    // namespace type

    namespace stmt
    {
        class Expr;
        class Yield;
        class Return;
        class Break;
        class Continue;
        class Try;
        class Catch;
        class Throw;
        class DoWhile;
        class While;
        class If;
        class Block;
    }    // namespace stmt

    class VisitorBase {
      public:
        VisitorBase() = default;
        VisitorBase(const VisitorBase &other) = default;
        VisitorBase(VisitorBase &&other) noexcept = default;
        VisitorBase &operator=(const VisitorBase &other) = default;
        VisitorBase &operator=(VisitorBase &&other) noexcept = default;
        virtual ~VisitorBase() = default;

        // Visitor
        virtual void visit(Reference &node) = 0;
        virtual void visit(expr::Argument &node) = 0;
        virtual void visit(expr::Slice &node) = 0;
        // Type visitor
        virtual void visit(type::Reference &node) = 0;
        virtual void visit(type::Function &node) = 0;
        virtual void visit(type::TypeLiteral &node) = 0;
        virtual void visit(type::TypeOf &node) = 0;
        virtual void visit(type::BinaryOp &node) = 0;
        virtual void visit(type::Nullable &node) = 0;
        // Expression visitor
        virtual void visit(expr::Constant &node) = 0;
        virtual void visit(expr::Super &node) = 0;
        virtual void visit(expr::Self &node) = 0;
        virtual void visit(expr::DotAccess &node) = 0;
        virtual void visit(expr::Call &node) = 0;
        virtual void visit(expr::Reify &node) = 0;
        virtual void visit(expr::Index &node) = 0;
        virtual void visit(expr::Unary &node) = 0;
        virtual void visit(expr::Cast &node) = 0;
        virtual void visit(expr::Binary &node) = 0;
        virtual void visit(expr::ChainBinary &node) = 0;
        virtual void visit(expr::Ternary &node) = 0;
        virtual void visit(expr::Assignment &node) = 0;
        // Statement visitor
        virtual void visit(stmt::Block &node) = 0;
        virtual void visit(stmt::If &node) = 0;
        virtual void visit(stmt::While &node) = 0;
        virtual void visit(stmt::DoWhile &node) = 0;
        virtual void visit(stmt::Throw &node) = 0;
        virtual void visit(stmt::Catch &node) = 0;
        virtual void visit(stmt::Try &node) = 0;
        virtual void visit(stmt::Continue &node) = 0;
        virtual void visit(stmt::Break &node) = 0;
        virtual void visit(stmt::Return &node) = 0;
        virtual void visit(stmt::Yield &node) = 0;
        virtual void visit(stmt::Expr &node) = 0;
        // Declaration visitor
        virtual void visit(decl::Param &node) = 0;
        virtual void visit(decl::Params &node) = 0;
        virtual void visit(decl::Function &node) = 0;
    };

    template<typename T>
    concept HasLineInfo = requires(T t) {
        { t->get_line_start() } -> std::same_as<int>;
        { t->get_line_end() } -> std::same_as<int>;
        { t->get_col_start() } -> std::same_as<int>;
        { t->get_col_end() } -> std::same_as<int>;
    };

    class AstNode {
      protected:
        int line_start;
        int line_end;
        int col_start;
        int col_end;

      public:
        AstNode(int line_start, int line_end, int col_start, int col_end)
            : line_start(line_start), line_end(line_end), col_start(col_start), col_end(col_end) {}

        template<typename T1, typename T2>
            requires HasLineInfo<T1> && HasLineInfo<T2>
        AstNode(T1 start, T2 end)
            : line_start(start->get_line_start()),
              line_end(end->get_line_end()),
              col_start(start->get_col_start()),
              col_end(end->get_col_end()) {}

        AstNode(const AstNode &other) = default;
        AstNode(AstNode &&other) noexcept = default;
        AstNode &operator=(const AstNode &other) = default;
        AstNode &operator=(AstNode &&other) noexcept = default;
        virtual ~AstNode() = default;

        virtual void accept(VisitorBase *visitor) = 0;

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

        void accept(VisitorBase *visitor) override {
            visitor->visit(*this);
        }
    };

    class Type : public AstNode {
      public:
        template<typename T1, typename T2>
            requires HasLineInfo<T1> && HasLineInfo<T2>
        Type(T1 start, T2 end) : AstNode(start, end) {}
    };

    namespace type
    {
        class Reference : public Type {
            std::shared_ptr<ast::Reference> reference;
            std::vector<std::shared_ptr<Type>> type_args;

          public:
            Reference(std::shared_ptr<Token> end, std::shared_ptr<ast::Reference> reference,
                      const std::vector<std::shared_ptr<Type>> &type_args)
                : Type(reference, end), reference(reference), type_args(type_args) {}

            Reference(std::shared_ptr<ast::Reference> reference) : Type(reference, reference), reference(reference) {}

            std::shared_ptr<ast::Reference> get_reference() const {
                return reference;
            }

            const std::vector<std::shared_ptr<Type>> &get_type_args() const {
                return type_args;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Function : public Type {
            std::vector<std::shared_ptr<Type>> param_types;
            std::shared_ptr<Type> return_type;

          public:
            Function(std::shared_ptr<Token> start, const std::vector<std::shared_ptr<Type>> &param_types,
                     std::shared_ptr<Type> return_type)
                : Type(start, return_type), param_types(param_types), return_type(return_type) {}

            const std::vector<std::shared_ptr<Type>> &get_param_types() const {
                return param_types;
            }

            std::shared_ptr<Type> get_return_type() const {
                return return_type;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class TypeLiteral : public Type {
          public:
            TypeLiteral(std::shared_ptr<Token> token) : Type(token, token) {}

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class TypeOf : public Type {
            std::shared_ptr<Expression> expr;

          public:
            TypeOf(std::shared_ptr<Token> start, std::shared_ptr<Token> end, std::shared_ptr<Expression> expr)
                : Type(start, end), expr(expr) {}

            std::shared_ptr<Expression> get_expr() const {
                return expr;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class BinaryOp : public Type {
            std::shared_ptr<Type> left;
            std::shared_ptr<Token> op;
            std::shared_ptr<Type> right;

          public:
            BinaryOp(std::shared_ptr<Type> left, std::shared_ptr<Token> op, std::shared_ptr<Type> right)
                : Type(left, right), left(left), op(op), right(right) {}

            std::shared_ptr<Type> get_left() const {
                return left;
            }

            std::shared_ptr<Token> get_op() const {
                return op;
            }

            std::shared_ptr<Type> get_right() const {
                return right;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Nullable : public Type {
            std::shared_ptr<Type> type;

          public:
            Nullable(std::shared_ptr<Token> end, std::shared_ptr<Type> type) : Type(type, end), type(type) {}

            std::shared_ptr<Type> get_type() const {
                return type;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };
    }    // namespace type

    class Expression : public AstNode {
      public:
        template<typename T1, typename T2>
            requires HasLineInfo<T1> && HasLineInfo<T2>
        Expression(T1 start, T2 end) : AstNode(start, end) {}
    };

    namespace expr
    {
        class Constant : public Expression {
            std::shared_ptr<Token> token;

          public:
            Constant(std::shared_ptr<Token> token) : Expression(token, token), token(token) {}

            std::shared_ptr<Token> get_token() const {
                return token;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
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

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Self : public Expression {
          public:
            Self(std::shared_ptr<Token> self) : Expression(self, self) {}

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
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

        class DotAccess : public Postfix {
          protected:
            std::shared_ptr<Token> member;
            std::shared_ptr<Token> safe;

          public:
            DotAccess(std::shared_ptr<Expression> caller, std::shared_ptr<Token> member, std::shared_ptr<Token> safe)
                : Postfix(member, caller), member(member), safe(safe) {}

            std::shared_ptr<Token> get_member() const {
                return member;
            }

            std::shared_ptr<Token> get_safe() const {
                return safe;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Argument : public AstNode {
            std::shared_ptr<Token> name;
            std::shared_ptr<Expression> expr;

          public:
            Argument(std::shared_ptr<Token> name, std::shared_ptr<Expression> expr)
                : AstNode(name, expr), name(name), expr(expr) {}

            Argument(std::shared_ptr<Expression> expr) : AstNode(expr, expr), expr(expr) {}

            std::shared_ptr<Token> get_name() const {
                return name;
            }

            std::shared_ptr<Expression> get_expr() const {
                return expr;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Call : public Postfix {
            std::vector<std::shared_ptr<Argument>> args;

          public:
            Call(std::shared_ptr<Token> end, std::shared_ptr<Expression> caller,
                 const std::vector<std::shared_ptr<Argument>> &args)
                : Postfix(end, caller), args(args) {}

            const std::vector<std::shared_ptr<Argument>> &get_args() const {
                return args;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Reify : public Postfix {
            std::vector<std::shared_ptr<Type>> type_args;

          public:
            Reify(std::shared_ptr<Token> end, std::shared_ptr<Expression> caller,
                  const std::vector<std::shared_ptr<Type>> &type_args)
                : Postfix(end, caller), type_args(type_args) {}

            const std::vector<std::shared_ptr<Type>> &get_type_args() const {
                return type_args;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
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
            Slice(int line_start, int line_end, int col_start, int col_end, Kind kind, std::shared_ptr<Expression> from,
                  std::shared_ptr<Expression> to, std::shared_ptr<Expression> step)
                : AstNode(line_start, line_end, col_start, col_end), kind(kind), from(from), to(to), step(step) {}

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

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Index : public Postfix {
            std::vector<std::shared_ptr<Slice>> slices;

          public:
            Index(std::shared_ptr<Token> end, std::shared_ptr<Expression> caller,
                  const std::vector<std::shared_ptr<Slice>> &slices)
                : Postfix(end, caller), slices(std::move(slices)) {}

            const std::vector<std::shared_ptr<Slice>> &get_slices() const {
                return slices;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
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

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Cast : public Expression {
            std::shared_ptr<Expression> expr;
            std::shared_ptr<Token> safe;
            std::shared_ptr<Type> type;

          public:
            Cast(std::shared_ptr<Expression> expr, std::shared_ptr<Token> safe, std::shared_ptr<Type> type)
                : Expression(expr, type), expr(expr), safe(safe), type(type) {}

            std::shared_ptr<Expression> get_expr() const {
                return expr;
            }

            std::shared_ptr<Token> get_safe() const {
                return safe;
            }

            std::shared_ptr<Type> get_type() const {
                return type;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Binary : public Expression {
          protected:
            std::shared_ptr<Expression> left;
            std::shared_ptr<Token> op1;
            std::shared_ptr<Token> op2;
            std::shared_ptr<Expression> right;

          public:
            Binary(std::shared_ptr<Expression> left, std::shared_ptr<Token> op, std::shared_ptr<Expression> right)
                : Expression(left, right), left(left), op1(op), right(right) {}

            Binary(std::shared_ptr<Expression> left, std::shared_ptr<Token> op1, std::shared_ptr<Token> op2,
                   std::shared_ptr<Expression> right)
                : Expression(left, right), left(left), op1(op1), op2(op2), right(right) {}

            std::shared_ptr<Expression> get_left() const {
                return left;
            }

            std::shared_ptr<Token> get_op1() const {
                return op1;
            }

            std::shared_ptr<Token> get_op2() const {
                return op2;
            }

            std::shared_ptr<Expression> get_right() const {
                return right;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class ChainBinary : public Expression {
            std::vector<std::shared_ptr<Expression>> exprs;
            std::vector<std::shared_ptr<Token>> ops;

          public:
            ChainBinary(const std::vector<std::shared_ptr<Expression>> &exprs, const std::vector<std::shared_ptr<Token>> &ops)
                : Expression(exprs.front(), exprs.back()), exprs(exprs), ops(ops) {}

            const std::vector<std::shared_ptr<Expression>> &get_exprs() const {
                return exprs;
            }

            const std::vector<std::shared_ptr<Token>> &get_ops() const {
                return ops;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
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

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Assignment : public Expression {
            std::vector<std::shared_ptr<Expression>> assignees;
            std::shared_ptr<Token> op1;
            std::shared_ptr<Token> op2;
            std::vector<std::shared_ptr<Expression>> exprs;

          public:
            Assignment(const std::vector<std::shared_ptr<Expression>> &assignees, std::shared_ptr<Token> op1,
                       std::shared_ptr<Token> op2, const std::vector<std::shared_ptr<Expression>> &exprs)
                : Expression(assignees.front(), exprs.back()), assignees(assignees), op1(op1), op2(op2), exprs(exprs) {}

            const std::vector<std::shared_ptr<Expression>> &get_assignees() const {
                return assignees;
            }

            std::shared_ptr<Token> get_op1() const {
                return op1;
            }

            std::shared_ptr<Token> get_op2() const {
                return op2;
            }

            const std::vector<std::shared_ptr<Expression>> &get_exprs() const {
                return exprs;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };
    }    // namespace expr

    class Statement : public AstNode {
      public:
        template<typename T1, typename T2>
            requires HasLineInfo<T1> && HasLineInfo<T2>
        Statement(T1 start, T2 end) : AstNode(start, end) {}
    };

    namespace stmt
    {
        class Block final : public Statement {
            std::vector<std::shared_ptr<Statement>> statements;

          public:
            Block(std::shared_ptr<Token> start, std::shared_ptr<Token> end,
                  const std::vector<std::shared_ptr<Statement>> &statements)
                : Statement(start, end), statements(statements) {}

            const std::vector<std::shared_ptr<Statement>> &get_statements() const {
                return statements;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class If final : public Statement {
            std::shared_ptr<Expression> condition;
            std::shared_ptr<Statement> body;
            std::shared_ptr<Statement> else_body;

          public:
            If(std::shared_ptr<Token> token, std::shared_ptr<Expression> condition, std::shared_ptr<Statement> body,
               std::shared_ptr<Statement> else_body)
                : Statement(token, else_body ? else_body : body), condition(condition), body(body), else_body(else_body) {}

            std::shared_ptr<Expression> get_condition() const {
                return condition;
            }

            std::shared_ptr<Statement> get_body() const {
                return body;
            }

            std::shared_ptr<Statement> get_else_body() const {
                return else_body;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class While final : public Statement {
            std::shared_ptr<Expression> condition;
            std::shared_ptr<Statement> body;
            std::shared_ptr<Statement> else_body;

          public:
            While(std::shared_ptr<Token> token, std::shared_ptr<Expression> condition, std::shared_ptr<Statement> body,
                  std::shared_ptr<Statement> else_body)
                : Statement(token, else_body ? else_body : body), condition(condition), body(body), else_body(else_body) {}

            std::shared_ptr<Expression> get_condition() const {
                return condition;
            }

            std::shared_ptr<Statement> get_body() const {
                return body;
            }

            std::shared_ptr<Statement> get_else_body() const {
                return else_body;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class DoWhile final : public Statement {
            std::shared_ptr<Statement> body;
            std::shared_ptr<Expression> condition;
            std::shared_ptr<Statement> else_body;

          public:
            DoWhile(std::shared_ptr<Token> token, std::shared_ptr<Statement> body, std::shared_ptr<Expression> condition,
                    std::shared_ptr<Statement> else_body)
                : Statement(token, else_body ? else_body : body), body(body), condition(condition), else_body(else_body) {}

            std::shared_ptr<Expression> get_condition() const {
                return condition;
            }

            std::shared_ptr<Statement> get_body() const {
                return body;
            }

            std::shared_ptr<Statement> get_else_body() const {
                return else_body;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Throw final : public Statement {
            std::shared_ptr<Expression> expression;

          public:
            Throw(std::shared_ptr<Token> token, std::shared_ptr<Expression> expression)
                : Statement(token, expression), expression(expression) {}

            std::shared_ptr<Expression> get_expression() const {
                return expression;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Catch final : public Statement {
            std::vector<std::shared_ptr<Reference>> references;
            std::shared_ptr<Token> symbol;
            std::shared_ptr<Statement> body;

          public:
            Catch(std::shared_ptr<Token> token, const std::vector<std::shared_ptr<Reference>> &references,
                  std::shared_ptr<Token> symbol, std::shared_ptr<Statement> body)
                : Statement(token, body), references(references), symbol(symbol), body(body) {}

            const std::vector<std::shared_ptr<Reference>> &get_references() const {
                return references;
            }

            std::shared_ptr<Token> get_symbol() const {
                return symbol;
            }

            std::shared_ptr<Statement> get_body() const {
                return body;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Try final : public Statement {
            std::shared_ptr<Statement> body;
            std::vector<std::shared_ptr<Statement>> catches;
            std::shared_ptr<Statement> finally;

          public:
            Try(std::shared_ptr<Token> token, std::shared_ptr<Statement> body,
                const std::vector<std::shared_ptr<Statement>> &catches, std::shared_ptr<Statement> finally)
                : Statement(token, finally ? finally : catches.back()), body(body), catches(catches), finally(finally) {}

            std::shared_ptr<Statement> get_body() const {
                return body;
            }

            const std::vector<std::shared_ptr<Statement>> &get_catches() const {
                return catches;
            }

            std::shared_ptr<Statement> get_finally() const {
                return finally;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Continue final : public Statement {
          public:
            Continue(std::shared_ptr<Token> token) : Statement(token, token) {}

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Break final : public Statement {
          public:
            Break(std::shared_ptr<Token> token) : Statement(token, token) {}

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Return final : public Statement {
            std::shared_ptr<Expression> expression;

          public:
            Return(std::shared_ptr<Token> token, std::shared_ptr<Expression> expression)
                : Statement(token, expression), expression(expression) {}

            std::shared_ptr<Expression> get_expression() const {
                return expression;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Yield final : public Statement {
            std::shared_ptr<Expression> expression;

          public:
            Yield(std::shared_ptr<Token> token, std::shared_ptr<Expression> expression)
                : Statement(token, expression), expression(expression) {}

            std::shared_ptr<Expression> get_expression() const {
                return expression;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Expr final : public Statement {
            std::shared_ptr<Expression> expression;

          public:
            explicit Expr(std::shared_ptr<Expression> expression) : Statement(expression, expression), expression(expression) {}

            std::shared_ptr<Expression> get_expression() const {
                return expression;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };
    }    // namespace stmt

    class Declaration : public AstNode {
      public:
        Declaration(int line_start, int line_end, int col_start, int col_end)
            : AstNode(line_start, line_end, col_start, col_end) {}

        template<typename T1, typename T2>
            requires HasLineInfo<T1> && HasLineInfo<T2>
        Declaration(T1 start, T2 end) : AstNode(start, end) {}
    };

    namespace decl
    {
        class Param : public Declaration {
            std::shared_ptr<Token> is_const;
            std::shared_ptr<Token> variadic;
            std::shared_ptr<Token> name;
            std::shared_ptr<Type> type;
            std::shared_ptr<Expression> default_expr;

          public:
            Param(int line_start, int line_end, int col_start, int col_end, std::shared_ptr<Token> is_const,
                  std::shared_ptr<Token> variadic, std::shared_ptr<Token> name, std::shared_ptr<Type> type,
                  std::shared_ptr<Expression> default_expr)
                : Declaration(line_start, line_end, col_start, col_end),
                  is_const(is_const),
                  variadic(variadic),
                  name(name),
                  type(type),
                  default_expr(default_expr) {}

            std::shared_ptr<Token> get_is_const() const {
                return is_const;
            }

            std::shared_ptr<Token> get_variadic() const {
                return variadic;
            }

            std::shared_ptr<Token> get_name() const {
                return name;
            }

            std::shared_ptr<Type> get_type() const {
                return type;
            }

            std::shared_ptr<Expression> get_default_expr() const {
                return default_expr;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Params : public Declaration {
            std::vector<std::shared_ptr<Param>> pos_only;
            std::vector<std::shared_ptr<Param>> pos_kwd;
            std::vector<std::shared_ptr<Param>> kwd_only;

          public:
            template<typename T1, typename T2>
                requires HasLineInfo<T1> && HasLineInfo<T2>
            Params(T1 start, T2 end, const std::vector<std::shared_ptr<Param>> &pos_only,
                   const std::vector<std::shared_ptr<Param>> &pos_kwd, const std::vector<std::shared_ptr<Param>> &kwd_only)
                : Declaration(start, end), pos_only(pos_only), pos_kwd(pos_kwd), kwd_only(kwd_only) {}

            const std::vector<std::shared_ptr<Param>> &get_pos_only() const {
                return pos_only;
            }

            const std::vector<std::shared_ptr<Param>> &get_pos_kwd() const {
                return pos_kwd;
            }

            const std::vector<std::shared_ptr<Param>> &get_kwd_only() const {
                return kwd_only;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };

        class Function : public Declaration {
            std::shared_ptr<Token> name;
            std::shared_ptr<Params> params;
            std::shared_ptr<Type> return_type;
            std::shared_ptr<Statement> definition;

          public:
            template<typename T>
                requires HasLineInfo<T>
            Function(std::shared_ptr<Token> token, T end, std::shared_ptr<Token> name, std::shared_ptr<Params> params,
                     std::shared_ptr<Type> return_type, std::shared_ptr<Statement> definition)
                : Declaration(token, end), name(name), params(params), return_type(return_type), definition(definition) {}

            std::shared_ptr<Token> get_name() const {
                return name;
            }

            std::shared_ptr<Params> get_params() const {
                return params;
            }

            std::shared_ptr<Type> get_return_type() const {
                return return_type;
            }

            std::shared_ptr<Statement> get_definition() const {
                return definition;
            }

            void accept(VisitorBase *visitor) override {
                visitor->visit(*this);
            }
        };
    }    // namespace decl
}    // namespace spade::ast