#pragma once

#include <ostream>
#include <sstream>

#include "ast.hpp"
#include "utils/common.hpp"

namespace spade::ast
{
    class Printer final {
      private:
        int level = 0;
        std::stringstream ss;
        std::shared_ptr<AstNode> root;
        std::function<string(int)> leading_conv = [](int level) {
            int times = level - 1;
            string s;
            for (int i = 0; i < times; i++) {
                if (i == times - 1) s += "|-";
                else
                    s += "| ";
            }
            return s;
        };

        void start_level();
        void end_level();

        void write_repr(const std::shared_ptr<AstNode> &node);
        void write_repr(const std::shared_ptr<Reference> &node);
        void write_repr(const std::shared_ptr<type::Reference> &node);
        void write_repr(const std::shared_ptr<type::Function> &node);
        void write_repr(const std::shared_ptr<type::TypeLiteral> &node);
        void write_repr(const std::shared_ptr<type::TypeOf> &node);
        void write_repr(const std::shared_ptr<type::BinaryOp> &node);
        void write_repr(const std::shared_ptr<type::Nullable> &node);
        void write_repr(const std::shared_ptr<expr::Constant> &node);
        void write_repr(const std::shared_ptr<expr::Super> &node);
        void write_repr(const std::shared_ptr<expr::Self> &node);
        void write_repr(const std::shared_ptr<expr::DotAccess> &node);
        void write_repr(const std::shared_ptr<expr::Argument> &node);
        void write_repr(const std::shared_ptr<expr::Call> &node);
        void write_repr(const std::shared_ptr<expr::Reify> &node);
        void write_repr(const std::shared_ptr<expr::Slice> &node);
        void write_repr(const std::shared_ptr<expr::Index> &node);
        void write_repr(const std::shared_ptr<expr::Unary> &node);
        void write_repr(const std::shared_ptr<expr::Cast> &node);
        void write_repr(const std::shared_ptr<expr::Binary> &node);
        void write_repr(const std::shared_ptr<expr::ChainBinary> &node);
        void write_repr(const std::shared_ptr<expr::Ternary> &node);
        void write_repr(const std::shared_ptr<expr::Assignment> &node);

        void print(const std::shared_ptr<Token> &token, const string &name);
        void print(const std::shared_ptr<AstNode> &node, const string &name = "");

        template<typename T>
            requires std::derived_from<T, AstNode>
        void print(const std::vector<std::shared_ptr<T>> vec, const string &name = "") {
            start_level();
            ss << leading_conv(level);
            if (!name.empty()) ss << name << ": ";
            if (vec.empty()) ss << "[]";
            else {
                start_level();
                int i = 0;
                for (const auto &node: vec) {
                    print(node, std::format("[{}]", i));
                    i++;
                }
                end_level();
            }
            end_level();
        }

        void print(const std::vector<std::shared_ptr<Token>> vec, const string &name = "") {
            start_level();
            ss << leading_conv(level);
            if (!name.empty()) ss << name << ": ";
            if (vec.empty()) ss << "[]";
            else {
                start_level();
                int i = 0;
                for (const auto &token: vec) {
                    print(token, std::format("[{}]", i));
                    i++;
                }
                end_level();
            }
            end_level();
        }

      public:
        explicit Printer(const std::shared_ptr<AstNode> &root) : root(root) {}

        string to_string() const {
            auto self = const_cast<Printer *>(this);
            self->print(self->root);
            auto res = ss.str();
            self->ss.str("");
            self->ss.clear();
            return res;
        }

        std::shared_ptr<AstNode> get_root() const {
            return root;
        }

        void set_root(std::shared_ptr<AstNode> root) {
            this->root = root;
        }
    };
}    // namespace spade::ast