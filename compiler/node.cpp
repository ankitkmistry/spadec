#include "node.hpp"
#include "../grammar/SpadeLexer.h"

// TODO: Correctly specify
Type *Type::INT = new Class(null);
Type *Type::FLOAT = new Class(null);
Type *Type::STRING = new Class(null);
Type *Type::BOOL = new Class(null);
Type *Type::NULL_TYPE = new Class(null);
Type *Type::ARRAY = new Class(null);

void DeclNode::addChild(DeclNode *node) {
    children.push_back(node);
    node->parent = this;
    try {
        members.at(node->getName()->getText()).push_back(node);
    } catch (const std::out_of_range &) {
        members[node->getName()->getText()] = {node};
    }
}

antlr4::ParserRuleContext *DeclNode::getCtx(DeclNode *node) {
    switch (node->kind) {
        case Kind::PACKAGE:
            return null;
        case Kind::SCOPE:
            return cast<Scope *>(node)->getCtx();
        case Kind::TYPE:
            switch (cast<Type *>(node)->getTypeKind()) {
                case Type::Kind::CLASS:
                    return cast<Class *>(node)->getCtx();
                case Type::Kind::INTERFACE:
                    return cast<Interface *>(node)->getCtx();
                case Type::Kind::ENUM:
                    return cast<Enum *>(node)->getCtx();
                case Type::Kind::ANNOTATION:
                    return cast<Annotation *>(node)->getCtx();
            }
        case Kind::METHOD:
            return cast<Method *>(node)->getCtx();
        case Kind::CONSTRUCTOR:
            return cast<Constructor *>(node)->getCtx();
        case Kind::VARIABLE:
            return cast<Variable *>(node)->getNameCtx();
        case Kind::TYPE_PARAM:
            return cast<TypeParam *>(node)->getCtx();
    }
    return nullptr;
}

DeclNode::Accessor DeclNode::getAccessibility() {
    for (auto modifier: modifiers) {
        switch (modifier->getType()) {
            case SpadeLexer::PRIVATE:
                return Accessor::PRIVATE;
            case SpadeLexer::INTERNAL:
                return Accessor::INTERNAL;
            case SpadeLexer::PROTECTED:
                return Accessor::PROTECTED;
            case SpadeLexer::PUBLIC:
                return Accessor::PUBLIC;
            default:
                break;
        }
    }
    return Accessor::PACKAGE_PRIVATE;
}

Package *DeclNode::getPackage() {
    for (auto node = parent; node != null; node = node->parent) {
        if (is<Package *>(node))return cast<Package *>(node);
    }
    return null;
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

vector<Type *> Type::getSuperTypes(Type *type) {
    vector<Type *> superTypes;
    for (auto implement: type->implements) {
        superTypes.push_back(implement);
    }
    switch (type->typeKind) {
        case Kind::CLASS:
            superTypes.push_back(cast<Class *>(type)->getExtends());
            break;
        case Kind::ANNOTATION:
            superTypes.push_back(cast<Annotation *>(type)->getExtends());
            break;
        default:
            break;
    }
    return superTypes;
}
