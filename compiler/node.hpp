#ifndef SPADEC_NODE_HPP
#define SPADEC_NODE_HPP

#include "../utils/common.hpp"
#include "../grammar/SpadeParser.h"

class DeclNode {
public:
    enum class Kind {
        PACKAGE, SCOPE, TYPE, METHOD, CONSTRUCTOR, VARIABLE, TYPE_PARAM
    };
protected:
    Kind kind;
    antlr4::Token *name;
    DeclNode *parent = null;
    vector<DeclNode *> children;
    vector<antlr4::Token *> modifiers;

    explicit DeclNode(Kind type, antlr4::Token *name) : name(name), kind(type) {}

public:
    void addChild(DeclNode *node);

    Kind getKind() const { return kind; }

    void setKind(Kind type_) { kind = type_; }

    const vector<DeclNode *> &getChildren() const { return children; }

    vector<DeclNode *> &getChildren() { return children; }

    void setChildren(const vector<DeclNode *> &children_) { children = children_; }

    DeclNode *getParent() const { return parent; }

    void setParent(DeclNode *parent_) { parent = parent_; }

    antlr4::Token *getName() const { return name; }

    void setName(antlr4::Token *name_) { name = name_; }

    const vector<antlr4::Token *> &getModifiers() const { return modifiers; }

    void setModifiers(const vector<antlr4::Token *> &modifiers_) { modifiers = modifiers_; }

    virtual string getSign() = 0;
};

class Package : public DeclNode {
public:
    explicit Package(antlr4::Token *name) : DeclNode(Kind::PACKAGE, name) {}

    string getSign() override;
};

class Scope : public DeclNode {
public:
    explicit Scope(antlr4::Token *name) : DeclNode(Kind::SCOPE, name) {}
};

class Interface;

class Type : public DeclNode {
public :
    enum class Kind {
        CLASS, INTERFACE, ENUM, ANNOTATION
    };
protected:
    Kind typeKind;
    vector<Interface *> implements;

    explicit Type(Kind typeKind, antlr4::Token *name) : DeclNode(DeclNode::Kind::TYPE, name), typeKind(typeKind) {}

public:
    Kind getTypeKind() const { return typeKind; }

    void setTypeKind(Kind typeKind_) { typeKind = typeKind_; }

    const vector<Interface *> &getImplements() const { return implements; }

    vector<Interface *> &getImplements() { return implements; }

    void setImplements(const vector<Interface *> &implements_) { implements = implements_; }
};

class Class : public Type {
private:
    SpadeParser::ClassDeclContext *ctx;
    Class *extends = null;
public:
    explicit Class(SpadeParser::ClassDeclContext *ctx) : Type(Kind::CLASS, null),
                                                         ctx(ctx) {}

    Class *getExtends() const { return extends; }

    void setExtends(Class *extends_) { extends = extends_; }

    SpadeParser::ClassDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Interface : public Type {
private:
    SpadeParser::InterfaceDeclContext *ctx;
public:
    explicit Interface(SpadeParser::InterfaceDeclContext *ctx) : Type(Kind::INTERFACE,
                                                                      null),
                                                                 ctx(ctx) {}

    SpadeParser::InterfaceDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Enum : public Type {
private:
    SpadeParser::EnumDeclContext *ctx;
public:
    explicit Enum(SpadeParser::EnumDeclContext *ctx) : Type(Kind::ENUM, ctx->IDENTIFIER()->getSymbol()), ctx(ctx) {}

    SpadeParser::EnumDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Annotation : public Type {
private:
    SpadeParser::AnnoDeclContext *ctx;
    Annotation *extends = null;
public:
    explicit Annotation(SpadeParser::AnnoDeclContext *ctx) : Type(Kind::ANNOTATION,
                                                                  null),
                                                             ctx(ctx) {}

    SpadeParser::AnnoDeclContext *getCtx() const { return ctx; }

    Annotation *getExtends() const { return extends; }

    void setExtends(Annotation *extends_) { extends = extends_; }

    string getSign() override;
};

class Method : public DeclNode {
private:
    SpadeParser::MethodDeclContext *ctx;
public:
    explicit Method(SpadeParser::MethodDeclContext *ctx) : DeclNode(Kind::METHOD, ctx->IDENTIFIER()->getSymbol()),
                                                           ctx(ctx) {}

    SpadeParser::MethodDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};


class Constructor : public DeclNode {
private:
    SpadeParser::ConstructorDeclContext *ctx;
public:
    explicit Constructor(SpadeParser::ConstructorDeclContext *ctx) : DeclNode(Kind::CONSTRUCTOR,
                                                                              ctx->INIT()->getSymbol()), ctx(ctx) {}

    SpadeParser::ConstructorDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Variable : public DeclNode {
public:
    enum class VarKind {
        GLOBAL, LOCAL, ARG, FIELD
    };
private:
    bool assignable;
    VarKind varKind;
    SpadeParser::NameContext *nameCtx;
    SpadeParser::ExprContext *exprCtx;

    Type *type;
public:
    Variable(SpadeParser::NameContext *nameCtx, SpadeParser::ExprContext *exprCtx, bool assignable, VarKind type)
            : DeclNode(DeclNode::Kind::VARIABLE, nameCtx->IDENTIFIER()->getSymbol()),
              assignable(assignable),
              varKind(type),
              nameCtx(nameCtx),
              exprCtx(exprCtx) {}

    bool isAssignable() const { return assignable; }

    void setAssignable(bool assignable_) { assignable = assignable_; }

    VarKind getVarType() const { return varKind; }

    void setVarType(VarKind type_) { varKind = type_; }

    SpadeParser::NameContext *getNameCtx() const { return nameCtx; }

    SpadeParser::ExprContext *getExprCtx() const { return exprCtx; }

    Type *getType() const { return type; }

    void setType(Type *type_) { type = type_; }

    string getSign() override;
};

class TypeParam : public DeclNode {
public:
    enum class Variant {
        CONTRAVARIANT, INVARIANT, COVARIANT
    };
private:
    SpadeParser::TypeParamContext *ctx;
    Variant variant;
    Type *variantOf;
    Type *defaultValue;
public:
    explicit TypeParam(SpadeParser::TypeParamContext *ctx) : DeclNode(Kind::TYPE_PARAM,
                                                                      ctx->IDENTIFIER()->getSymbol()), ctx(ctx) {}

    SpadeParser::TypeParamContext *getCtx() const { return ctx; }

    Variant getVariant() const { return variant; }

    void setVariant(Variant variant_) { variant = variant_; }

    Type *getVariantOf() const { return variantOf; }

    void setVariantOf(Type *variantOf_) { variantOf = variantOf_; }

    Type *getDefaultValue() const { return defaultValue; }

    void setDefaultValue(Type *defaultValue_) { defaultValue = defaultValue_; }

    string getSign() override;
};

#endif //SPADEC_NODE_HPP
