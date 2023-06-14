#include "node.hpp"

void DeclNode::addChild(DeclNode *node) {
    children.push_back(node);
    node->parent = this;
}

string Package::getSign() {
    return (parent != null ? parent->getSign() + "::" : "") + name->getText();
}

string Class::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Interface::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Enum::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Annotation::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Method::getSign() {
    // TODO: param support to be added
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string Variable::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}

string TypeParam::getSign() {
    return (parent != null ? parent->getSign() + "." : "") + name->getText();
}