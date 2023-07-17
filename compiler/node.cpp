#include "node.hpp"

void DeclNode::addChild(DeclNode *node) {
    children.push_back(node);
    node->parent = this;
}

string Package::getSign() {
    if (name == null)return "";
    return (parent != null ? parent->getSign() + "::" : "") + name->getText();
}

string Class::getSign() {
    if (name == null)return "";
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Interface::getSign() {
    if (name == null)return "";
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Enum::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Annotation::getSign() {
    if (name == null)return "";
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Method::getSign() {
    // TODO: param support to be added
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Constructor::getSign() {
    // TODO: param support to be added
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Variable::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string TypeParam::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

bool Type::isSuperOf(Type *type) const {
    if (type == this)return true;
    if ((is<Class *>(type) && cast<Class *>(type)->getExtends() == this) ||
        (is<Annotation *>(type) && cast<Annotation *>(type)->getExtends() == this))
        return true;
    for (auto implement: implements) {
        if (implement->isSuperOf(type))return true;
    }
    return false;
}
