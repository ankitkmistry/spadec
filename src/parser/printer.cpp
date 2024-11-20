#include "printer.hpp"

#include <sstream>

#include "utils/utils.hpp"

namespace spade::ast
{
    void Printer::start_level() {
        if (!ss.str().empty() && ss.str().back() != '\n') ss << '\n';
        level++;
    }

    void Printer::end_level() {
        if (!ss.str().empty() && ss.str().back() != '\n') ss << '\n';
        level--;
    }

    void Printer::write_repr(const std::shared_ptr<AstNode> &node) {
        ss << std::format("[{:02d}:{:02d}]->[{:02d}:{:02d}] ", node->get_line_start(), node->get_col_start(),
                          node->get_line_end(), node->get_col_end());
    }

    void Printer::write_repr(const std::shared_ptr<Reference> &node) {
        write_repr(cast<AstNode>(node));
        ss << "Reference '";
        int i = 0;
        for (const auto &elm: node->get_path()) {
            ss << elm->get_text();
            if (i < node->get_path().size() - 1) ss << ".";
            i++;
        }
        ss << "'";
    }

    void Printer::write_repr(const std::shared_ptr<type::Reference> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::Reference";
        print(node->get_reference(), "reference");
        print(node->get_type_args(), "type_args");
    }

    void Printer::write_repr(const std::shared_ptr<type::Function> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::Function";
        print(node->get_param_types(), "param_types");
        print(node->get_return_type(), "return_type");
    }

    void Printer::write_repr(const std::shared_ptr<type::TypeLiteral> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::TypeLiteral";
    }

    void Printer::write_repr(const std::shared_ptr<type::TypeOf> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::Function";
        print(node->get_expr(), "expr");
    }

    void Printer::write_repr(const std::shared_ptr<type::BinaryOp> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::Function";
        print(node->get_op(), "op");
        print(node->get_left(), "left");
        print(node->get_right(), "right");
    }

    void Printer::write_repr(const std::shared_ptr<type::Nullable> &node) {
        write_repr(cast<AstNode>(node));
        ss << "type::Nullable";
        print(node->get_type(), "type");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Constant> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Constant '" << node->get_token()->to_string() << "'";
    }

    void Printer::write_repr(const std::shared_ptr<expr::Super> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Super";
        print(node->get_reference(), "reference");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Self> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Self";
    }

    void Printer::write_repr(const std::shared_ptr<expr::DotAccess> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::DotAccess";
        print(node->get_caller(), "caller");
        print(node->get_safe(), "safe");
        print(node->get_member(), "member");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Argument> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Argument";
        print(node->get_name(), "name");
        print(node->get_expr(), "expr");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Call> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Call";
        print(node->get_caller(), "caller");
        print(node->get_args(), "args");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Reify> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Reify";
        print(node->get_caller(), "caller");
        print(node->get_type_args(), "type_args");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Slice> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Slice";
        start_level();
        ss << leading_conv(level);
        ss << "kind: ";
        switch (node->get_kind()) {
            case expr::Slice::Kind::INDEX:
                ss << "INDEX";
                break;
            case expr::Slice::Kind::SLICE:
                ss << "SLICE";
                break;
        }
        end_level();
        print(node->get_from(), "from");
        print(node->get_to(), "to");
        print(node->get_step(), "step");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Index> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Index";
        print(node->get_caller(), "caller");
        print(node->get_slices(), "slices");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Unary> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Unary";
        print(node->get_op(), "op");
        print(node->get_expr(), "expr");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Cast> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Cast";
        print(node->get_expr(), "expr");
        print(node->get_safe(), "safe");
        print(node->get_type(), "type");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Binary> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Binary";
        print(node->get_left(), "left");
        if (node->get_op2()) {
            print(node->get_op1(), "op1");
            print(node->get_op2(), "op2");
        } else {
            print(node->get_op1(), "op");
        }
        print(node->get_right(), "right");
    }

    void Printer::write_repr(const std::shared_ptr<expr::ChainBinary> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::ChainBinary";
        print(node->get_exprs(), "exprs");
        print(node->get_ops(), "ops");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Ternary> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Ternary";
        print(node->get_condition(), "condition");
        print(node->get_on_true(), "on_true");
        print(node->get_on_false(), "on_false");
    }

    void Printer::write_repr(const std::shared_ptr<expr::Assignment> &node) {
        write_repr(cast<AstNode>(node));
        ss << "expr::Assignment";
        print(node->get_assignees(), "assignees");
        print(node->get_op1(), "op1");
        print(node->get_op2(), "op2");
        print(node->get_exprs(), "exprs");
    }

    void Printer::print(const std::shared_ptr<Token> &token, const string &name) {
        start_level();
        ss << leading_conv(level);
        if (!name.empty()) ss << name << ": ";
        ss << (token ? token->to_string() : "null");
        end_level();
    }

    void Printer::print(const std::shared_ptr<AstNode> &node, const string &name) {
        start_level();
        ss << leading_conv(level);
        if (!name.empty()) ss << name << ": ";
        if (!node) {
            ss << "null";
        } else if (is<Reference>(node)) {
            write_repr(cast<Reference>(node));
        } else if (is<expr::Argument>(node)) {
            write_repr(cast<expr::Argument>(node));
        } else if (is<expr::Slice>(node)) {
            write_repr(cast<expr::Slice>(node));
        } else if (is<Type>(node)) {
            if (is<type::Reference>(node)) {
                write_repr(cast<type::Reference>(node));
            } else if (is<type::Function>(node)) {
                write_repr(cast<type::Function>(node));
            } else if (is<type::TypeLiteral>(node)) {
                write_repr(cast<type::TypeLiteral>(node));
            } else if (is<type::TypeOf>(node)) {
                write_repr(cast<type::TypeOf>(node));
            } else if (is<type::BinaryOp>(node)) {
                write_repr(cast<type::BinaryOp>(node));
            } else if (is<type::Nullable>(node)) {
                write_repr(cast<type::Nullable>(node));
            }
        } else if (is<Expression>(node)) {
            if (is<expr::Constant>(node)) {
                write_repr(cast<expr::Constant>(node));
            } else if (is<expr::Super>(node)) {
                write_repr(cast<expr::Super>(node));
            } else if (is<expr::Self>(node)) {
                write_repr(cast<expr::Self>(node));
            } else if (is<expr::DotAccess>(node)) {
                write_repr(cast<expr::DotAccess>(node));
            } else if (is<expr::Argument>(node)) {
                write_repr(cast<expr::Argument>(node));
            } else if (is<expr::Call>(node)) {
                write_repr(cast<expr::Call>(node));
            } else if (is<expr::Reify>(node)) {
                write_repr(cast<expr::Reify>(node));
            } else if (is<expr::Index>(node)) {
                write_repr(cast<expr::Index>(node));
            } else if (is<expr::Unary>(node)) {
                write_repr(cast<expr::Unary>(node));
            } else if (is<expr::Cast>(node)) {
                write_repr(cast<expr::Cast>(node));
            } else if (is<expr::Binary>(node)) {
                write_repr(cast<expr::Binary>(node));
            } else if (is<expr::ChainBinary>(node)) {
                write_repr(cast<expr::ChainBinary>(node));
            } else if (is<expr::Ternary>(node)) {
                write_repr(cast<expr::Ternary>(node));
            } else if (is<expr::Assignment>(node)) {
                write_repr(cast<expr::Assignment>(node));
            }
        } else {
            write_repr(node);
            ss << "AstNode";
        }
        end_level();
    }
}    // namespace spade::ast