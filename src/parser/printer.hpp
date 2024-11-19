#pragma once

#include <ostream>

#include "ast.hpp"
#include "utils/common.hpp"

namespace spade::ast
{
    class Printer final {
      private:
        std::shared_ptr<AstNode> root;

      public:
        explicit Printer(std::shared_ptr<AstNode> root) : root(root) {}

        void print(std::ostream &os);

        std::shared_ptr<AstNode> get_root() const {
            return root;
        }

        void set_root(std::shared_ptr<AstNode> root) {
            this->root = root;
        }
    };
}    // namespace spade::ast