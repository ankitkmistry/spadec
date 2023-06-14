#ifndef SPADEC_NODE_HPP
#define SPADEC_NODE_HPP

#include "../utils/common.hpp"
#include "../grammar/SpadeParser.h"

class DeclNode {
protected:
    vector<DeclNode *> children;
    DeclNode *parent = null;
    antlr4::Token *name;

    explicit DeclNode(antlr4::Token *name) : name(name) {}

public:
    void addChild(DeclNode *node);

    const vector<DeclNode *> &getChildren() const { return children; }

    vector<DeclNode *> &getChildren() { return children; }

    void setChildren(const vector<DeclNode *> &children_) { children = children_; }

    DeclNode *getParent() const { return parent; }

    void setParent(DeclNode *parent_) { parent = parent_; }

    antlr4::Token *getName() const { return name; }

    void setName(antlr4::Token *name_) { name = name_; }

    virtual string getSign() = 0;
};

class Package : public DeclNode {
public:
    explicit Package(antlr4::Token *name) : DeclNode(name) {}

    string getSign() override;
};

class Interface;

class Type : public DeclNode {
protected:
    vector<Interface *> implements;
public:
    explicit Type(antlr4::Token *name) : DeclNode(name) {}

    const vector<Interface *> &getImplements() const { return implements; }

    vector<Interface *> &getImplements() { return implements; }

    void setImplements(const vector<Interface *> &implements_) { implements = implements_; }
};

class Class : public Type {
private:
    const SpadeParser::ClassDeclContext *ctx;
    Class *extends;
public:
    explicit Class(antlr4::Token *name, SpadeParser::ClassDeclContext *ctx) : Type(name), ctx(ctx) {}

    const SpadeParser::ClassDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Interface : public Type {
private:
    const SpadeParser::InterfaceDeclContext *ctx;
public:
    explicit Interface(antlr4::Token *name, SpadeParser::InterfaceDeclContext *ctx) : Type(name), ctx(ctx) {}

    const SpadeParser::InterfaceDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Enum : public Type {
private:
    const SpadeParser::EnumDeclContext *ctx;
public:
    explicit Enum(antlr4::Token *name, SpadeParser::EnumDeclContext *ctx) : Type(name), ctx(ctx) {}

    const SpadeParser::EnumDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Annotation : public Type {
private:
    const SpadeParser::AnnoDeclContext *ctx;
public:
    explicit Annotation(antlr4::Token *name, SpadeParser::AnnoDeclContext *ctx) : Type(name), ctx(ctx) {}

    const SpadeParser::AnnoDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

class Method : public DeclNode {
private:
    const SpadeParser::MethodDeclContext *ctx;
public:
    explicit Method(antlr4::Token *name, SpadeParser::MethodDeclContext *ctx) : DeclNode(name), ctx(ctx) {}

    const SpadeParser::MethodDeclContext *getCtx() const { return ctx; }

    string getSign() override;
};

enum class VariableType {
    GLOBAL, LOCAL, ARG
};

class Variable : public DeclNode {
protected:
    VariableType type;
public:
    Variable(antlr4::Token *name, VariableType type) : DeclNode(name), type(type) {}

    VariableType getType() const { return type; }

    void setType(VariableType type_) { type = type_; }

    string getSign() override;
};

class Constant : public Variable {
public:
    Constant(antlr4::Token *name, VariableType type) : Variable(name, type) {}
};

class TypeParam : public DeclNode {
public:
    explicit TypeParam(antlr4::Token *name) : DeclNode(name) {}

    string getSign() override;
};

#endif //SPADEC_NODE_HPP
