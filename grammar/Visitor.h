#pragma once

#include "antlr4-runtime.h"
#include "SpadeVisitor.h"
#include "../utils/common.hpp"
#include "../compiler/tree.hpp"
#include "ErrorListener.hpp"
#include "../utils/format.hpp"
#include "../utils/utils.hpp"

/**
 * This class provides an empty implementation of SpadeVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class Visitor : public SpadeVisitor {
private:
    DeclTree *tree = null;
    vector<Package *> currentPackages;
    vector<Type *> currentTypes;
    vector<Method *> currentMethods;
    vector<Scope *> currentScopes;

    ErrorListener *listener;
    SpadeParser *parser;

    bool checkingStarted = false;

    [[noreturn]]void reportError(antlr4::Token *token, string msg) {
        listener->syntaxError(parser, token, token->getLine(), token->getCharPositionInLine(), msg,
                              std::make_exception_ptr(std::runtime_error(msg)));
        exit(-1);
    }

    [[noreturn]]void reportError(antlr4::ParserRuleContext *ctx, string msg) {
        listener->syntaxError(parser, ctx, msg);
        exit(-1);
    }

public:
    explicit Visitor(SpadeParser *parser, ErrorListener *listener) : listener(listener), parser(parser) {}

    std::any visitSep(SpadeParser::SepContext *ctx) override {
        return null;
    }

    Type *checkType(SpadeParser::ReferenceContext *ctx) {
        auto tokens = any_cast<vector<antlr4::Token *>>(visitReference(ctx));
        DeclNode *node = null;
        for (auto token: tokens) {
            if (node == null) {
                node = tree->getRoot();
            } else {
                auto itr = std::find_if(node->getChildren().begin(), node->getChildren().end(), [&](DeclNode *node) {
                    return node->getName()->getText() == token->getText();
                });
                if (itr == node->getChildren().end())reportError(ctx, "cannot find symbol");
                else node = *itr;
            }

            auto name = node->getName()->getText();
            if (!name.empty() && name != token->getText()) reportError(ctx, "cannot find symbol");
        }
        try { return cast<Type *>(node); }
        catch (const CastError &) { reportError(ctx, "not a kind"); }
    }

    Type *checkType(SpadeParser::TypeContext *ctx) {
        // Todo: implement this
        return null;
    }


    void checkPermittedModifiers(Type *type, vector<string> modifiers) {
        for (auto modifier: type->getModifiers())
            for (auto modStr: modifiers)
                if (modifier->getText() != modStr)
                    reportError(modifier, "not permitted");
    }

    void checkModifiers(Class *klass) {
        auto modifiers = klass->getModifiers();
        switch (klass->getParent()->getKind()) {
            case DeclNode::Kind::PACKAGE:
                checkPermittedModifiers(klass, {"public", "abstract", "final"});
                break;
            case DeclNode::Kind::SCOPE:
                checkPermittedModifiers(klass, {"abstract", "final"});
                break;
            case DeclNode::Kind::TYPE:
                checkPermittedModifiers(klass,
                                        {"private", "internal", "protected", "public", "abstract", "final", "static"});
                break;
            case DeclNode::Kind::METHOD:
                checkPermittedModifiers(klass, {"abstract", "final"});
                break;
            case DeclNode::Kind::CONSTRUCTOR:
                checkPermittedModifiers(klass, {"abstract", "final"});
                break;
            default:
                break;
        }
    }

    void checkModifiers(Interface *interface) {
        auto modifiers = interface->getModifiers();
        switch (interface->getParent()->getKind()) {
            case DeclNode::Kind::PACKAGE:
                checkPermittedModifiers(interface, {"public"});
                break;
            case DeclNode::Kind::SCOPE:
                checkPermittedModifiers(interface, {""});
                break;
            case DeclNode::Kind::TYPE:
                checkPermittedModifiers(interface, {"private", "internal", "protected", "public", "static"});
                break;
            case DeclNode::Kind::METHOD:
                checkPermittedModifiers(interface, {""});
                break;
            case DeclNode::Kind::CONSTRUCTOR:
                checkPermittedModifiers(interface, {""});
                break;
            default:
                break;
        }
    }

    void checkModifiers(Enum *enumClass) {
        auto modifiers = enumClass->getModifiers();
        switch (enumClass->getParent()->getKind()) {
            case DeclNode::Kind::PACKAGE:
                checkPermittedModifiers(enumClass, {"public"});
                break;
            case DeclNode::Kind::SCOPE:
                checkPermittedModifiers(enumClass, {""});
                break;
            case DeclNode::Kind::TYPE:
                checkPermittedModifiers(enumClass, {"private", "internal", "protected", "public", "static"});
                break;
            case DeclNode::Kind::METHOD:
                checkPermittedModifiers(enumClass, {""});
                break;
            case DeclNode::Kind::CONSTRUCTOR:
                checkPermittedModifiers(enumClass, {""});
                break;
            default:
                break;
        }
    }

    void checkModifiers(Annotation *annotation) {
        auto modifiers = annotation->getModifiers();
        switch (annotation->getParent()->getKind()) {
            case DeclNode::Kind::PACKAGE:
                checkPermittedModifiers(annotation, {"public", "abstract", "final"});
                break;
            case DeclNode::Kind::SCOPE:
                checkPermittedModifiers(annotation, {"abstract", "final"});
                break;
            case DeclNode::Kind::TYPE:
                checkPermittedModifiers(annotation,
                                        {"private", "internal", "protected", "public", "abstract", "final", "static"});
                break;
            case DeclNode::Kind::METHOD:
                checkPermittedModifiers(annotation, {"abstract", "final"});
                break;
            case DeclNode::Kind::CONSTRUCTOR:
                checkPermittedModifiers(annotation, {"abstract", "final"});
                break;
            default:
                break;
        }
    }

    void checkTypeParam(TypeParam *typeParam) {
        auto ctx = typeParam->getCtx();
        if (ctx->OUT() != null) typeParam->setVariant(TypeParam::Variant::COVARIANT);
        else if (ctx->IN() != null) typeParam->setVariant(TypeParam::Variant::CONTRAVARIANT);
        else {
            typeParam->setVariant(TypeParam::Variant::INVARIANT);
            if (ctx->variantOf)
                reportError(ctx->variantOf, "variant cannot be specified to an invariant kind parameter");
        }

        if (ctx->variantOf)
            typeParam->setVariantOf(checkType(ctx->variantOf));
        if (ctx->defaultValue)
            typeParam->setDefaultValue(checkType(ctx->defaultValue));
    }

    Type *checkExpr(SpadeParser::ExprContext *ctx) {
        return null;
    }

    void checkVariable(Variable *variable) {
        auto nameCtx = variable->getNameCtx();
        auto valueCtx = variable->getExprCtx();

        Type *exprType = checkExpr(valueCtx);
        auto type = any_cast<Type *>(visitName(nameCtx));
        if (type == null && exprType == null)reportError(nameCtx, "type of the variable cannot be inferred");
        else if (type == null) variable->setType(exprType);
        else if (exprType == null) variable->setType(type);
        else {
            if (type->isSuperOf(exprType)) variable->setType(type); // Need to get a cast
            else reportError(valueCtx, "cannot be assigned");
        }
    }

    void traverseDeclNode(DeclNode *node) {
        switch (node->getKind()) {
            case DeclNode::Kind::PACKAGE: {
                auto package = cast<Package *>(node);
                currentPackages.push_back(package);
                for (auto child: package->getChildren()) {
                    switch (child->getKind()) {
                        case DeclNode::Kind::SCOPE:
                            reportError(cast<Scope *>(child)->getCtx(), "not allowed as a top-level declaration");
                            break;
                        case DeclNode::Kind::CONSTRUCTOR:
                            reportError(cast<Constructor *>(child)->getCtx(), "not allowed as a top-level declaration");
                            break;
                        case DeclNode::Kind::TYPE_PARAM:
                            reportError(cast<TypeParam *>(child)->getCtx(), "not allowed as a top-level declaration");
                            break;
                        default:
                            break;
                    }
                    traverseDeclNode(child);
                }
                currentPackages.pop_back();
                break;
            }
            case DeclNode::Kind::SCOPE:
                currentScopes.push_back(cast<Scope *>(node));
                // Todo: Do something
                currentScopes.pop_back();
                break;
            case DeclNode::Kind::TYPE: {
                Type *type = cast<Type *>(node);
                currentTypes.push_back(type);
                for (auto child: type->getChildren()) {
                    switch (child->getKind()) {
                        case DeclNode::Kind::SCOPE:
                            reportError(cast<Scope *>(child)->getCtx(), "not allowed as a class-level declaration");
                            break;
                        default:
                            break;
                    }
                }
                switch (type->getTypeKind()) {
                    case Type::Kind::CLASS:
                        visitClassDecl(cast<Class *>(type)->getCtx());
                        break;
                    case Type::Kind::INTERFACE:
                        visitInterfaceDecl(cast<Interface *>(type)->getCtx());
                        break;
                    case Type::Kind::ENUM:
                        visitEnumDecl(cast<Enum *>(type)->getCtx());
                        break;
                    case Type::Kind::ANNOTATION:
                        visitAnnoDecl(cast<Annotation *>(type)->getCtx());
                        break;
                }
                currentTypes.pop_back();
                break;
            }
            case DeclNode::Kind::METHOD: {
                auto method = cast<Method *>(node);
                currentMethods.push_back(method);
                // Todo: Do something
                currentMethods.pop_back();
                break;
            }
            case DeclNode::Kind::CONSTRUCTOR:
                break;
            case DeclNode::Kind::VARIABLE:
                checkVariable(cast<Variable *>(node));
                break;
            case DeclNode::Kind::TYPE_PARAM:
                checkTypeParam(cast<TypeParam *>(node));
                break;
        }
    }

    std::any visitCompilationUnit(SpadeParser::CompilationUnitContext *ctx) override {
        if (ctx->packageStmt() == null) {
            currentPackages.push_back(new Package(null));
            tree = new DeclTree(currentPackages.back());
        } else
            visitPackageStmt(ctx->packageStmt());

        for (auto decl: ctx->declaration()) visitDeclaration(decl);

        // Reset everything
        currentPackages.clear();
        currentTypes.clear();
        currentMethods.clear();
        currentScopes.clear();

        checkingStarted = true;
        traverseDeclNode(tree->getRoot());
        checkingStarted = false;

        return null;
    }

    std::any visitPackageStmt(SpadeParser::PackageStmtContext *ctx) override {
        auto list = any_cast<vector<antlr4::Token *>>(visitReference(ctx->reference()));
        for (int i = 0; i < list.size(); ++i) {
            auto item = list[i];
            if (tree == null) {
                currentPackages.push_back(new Package(item));
                tree = new DeclTree(currentPackages.back());
            } else {
                auto package = new Package(item);
                currentPackages.back()->addChild(package);
                currentPackages.push_back(package);
            }
        }
        return null;
    }

    std::any visitImportStmt(SpadeParser::ImportStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDeclaration(SpadeParser::DeclarationContext *ctx) override {
        auto modifiers = any_cast<vector<antlr4::Token *>>(visitModifiers(ctx->modifiers()));
        DeclNode *decl = null;
        if (ctx->classDecl() != null)decl = any_cast<DeclNode *>(visitClassDecl(ctx->classDecl()));
        else if (ctx->interfaceDecl() != null)decl = any_cast<DeclNode *>(visitInterfaceDecl(ctx->interfaceDecl()));
        else if (ctx->enumDecl() != null)decl = any_cast<DeclNode *>(visitEnumDecl(ctx->enumDecl()));
        else if (ctx->annoDecl() != null)decl = any_cast<DeclNode *>(visitAnnoDecl(ctx->annoDecl()));
        else if (ctx->functionDecl() != null)decl = any_cast<DeclNode *>(visitFunctionDecl(ctx->functionDecl()));
        else if (ctx->varDecl() != null)decl = any_cast<DeclNode *>(visitVarDecl(ctx->varDecl()));
        decl->setModifiers(modifiers);
        return decl;
    }

    std::any visitEnumDecl(SpadeParser::EnumDeclContext *ctx) override {
        if (!checkingStarted) {
            auto *decl = new Enum(ctx);
            currentTypes.push_back(decl);

            for (auto member: ctx->memberDecl()) {
                visitMemberDecl(member);
            }

            currentTypes.pop_back();
            if (!currentMethods.empty())currentScopes.back()->addChild(decl);
            else if (currentTypes.back() != null)currentTypes.back()->addChild(decl);
            else currentPackages.back()->addChild(decl);
            return cast<DeclNode *>(decl);
        } else {
            auto enumClass = cast<Enum *>(currentTypes.back());
            checkModifiers(enumClass);
            for (auto parent: ctx->parentList()->parent()) {
                Type *super = checkType(parent->reference());
                try { enumClass->getImplements().push_back(cast<Interface *>(super)); }
                catch (const CastError &) { reportError(ctx, "not an interface"); }
            }
            for (auto child: enumClass->getChildren()) traverseDeclNode(child);
            return null;
        }
    }

    std::any visitEnumList(SpadeParser::EnumListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitEnumerator(SpadeParser::EnumeratorContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAnnoDecl(SpadeParser::AnnoDeclContext *ctx) override {
        if (!checkingStarted) {
            auto *decl = new Annotation(ctx);
            currentTypes.push_back(decl);

            visitDeclName(ctx->declName());
            for (auto member: ctx->memberDecl()) {
                visitMemberDecl(member);
            }

            currentTypes.pop_back();
            if (!currentMethods.empty())currentScopes.back()->addChild(decl);
            else if (currentTypes.back() != null)currentTypes.back()->addChild(decl);
            else currentPackages.back()->addChild(decl);
            return cast<DeclNode *>(decl);
        } else {
            auto annotation = cast<Annotation *>(currentTypes.back());
            checkModifiers(annotation);
            if (ctx->parent()) {
                Type *super = checkType(ctx->parent()->reference());
                try { annotation->setExtends(cast<Annotation *>(super)); }
                catch (const CastError &) { reportError(ctx, "not an annotation"); }
            }
            for (auto parent: ctx->parentList()->parent()) {
                Type *super = checkType(parent->reference());
                try { annotation->getImplements().push_back(cast<Interface *>(super)); }
                catch (const CastError &) { reportError(ctx, "not an interface"); }
            }
            for (auto child: annotation->getChildren()) traverseDeclNode(child);
            return null;
        }
    }

    std::any visitInterfaceDecl(SpadeParser::InterfaceDeclContext *ctx) override {
        if (!checkingStarted) {
            auto *decl = new Interface(ctx);
            currentTypes.push_back(decl);

            visitDeclName(ctx->declName());
            for (auto member: ctx->memberDecl()) {
                visitMemberDecl(member);
            }

            currentTypes.pop_back();
            if (!currentMethods.empty())currentScopes.back()->addChild(decl);
            else if (currentTypes.back() != null)currentTypes.back()->addChild(decl);
            else currentPackages.back()->addChild(decl);
            return cast<DeclNode *>(decl);
        } else {
            auto interface = cast<Interface *>(currentTypes.back());
            checkModifiers(interface);
            for (auto parent: ctx->parentList()->parent()) {
                Type *super = checkType(parent->reference());
                try { interface->getImplements().push_back(cast<Interface *>(super)); }
                catch (const CastError &) { reportError(ctx, "not an interface"); }
            }
            for (auto child: interface->getChildren()) traverseDeclNode(child);
            return null;
        }
    }

    std::any visitClassDecl(SpadeParser::ClassDeclContext *ctx) override {
        if (!checkingStarted) {
            auto *decl = new Class(ctx);
            currentTypes.push_back(decl);

            visitDeclName(ctx->declName());
            for (auto member: ctx->memberDecl()) {
                visitMemberDecl(member);
            }

            currentTypes.pop_back();
            if (!currentMethods.empty())currentScopes.back()->addChild(decl);
            else if (currentTypes.back() != null)currentTypes.back()->addChild(decl);
            else currentPackages.back()->addChild(decl);
            return cast<DeclNode *>(decl);
        } else {
            auto klass = cast<Class *>(currentTypes.back());
            checkModifiers(klass);
            if (ctx->parent()) {
                Type *super = checkType(ctx->parent()->reference());
                try { klass->setExtends(cast<Class *>(super)); }
                catch (const CastError &) { reportError(ctx, "not a class"); }
            }
            for (auto parent: ctx->parentList()->parent()) {
                Type *super = checkType(parent->reference());
                try { klass->getImplements().push_back(cast<Interface *>(super)); }
                catch (const CastError &) { reportError(ctx, "not an interface"); }
            }
            for (auto child: klass->getChildren()) traverseDeclNode(child);
            return null;
        }
    }

    std::any visitParentList(SpadeParser::ParentListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParent(SpadeParser::ParentContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDeclName(SpadeParser::DeclNameContext *ctx) override {
        currentTypes.back()->setName(ctx->IDENTIFIER()->getSymbol());
        auto typeParams = any_cast<vector<SpadeParser::TypeParamContext *>>(visitTypeParams(ctx->typeParams()));
        for (auto typeParam: typeParams) currentTypes.back()->addChild(new TypeParam(typeParam));
        return null;
    }

    std::any visitTypeParams(SpadeParser::TypeParamsContext *ctx) override {
        return ctx->typeParam();
    }

    std::any visitTypeParam(SpadeParser::TypeParamContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMemberDecl(SpadeParser::MemberDeclContext *ctx) override {
        auto modifiers = any_cast<vector<antlr4::Token *>>(visitModifiers(ctx->modifiers()));
        DeclNode *decl = null;
        if (ctx->classDecl() != null)decl = any_cast<DeclNode *>(visitClassDecl(ctx->classDecl()));
        else if (ctx->interfaceDecl() != null)decl = any_cast<DeclNode *>(visitInterfaceDecl(ctx->interfaceDecl()));
        else if (ctx->enumDecl() != null)decl = any_cast<DeclNode *>(visitEnumDecl(ctx->enumDecl()));
        else if (ctx->fieldDecl() != null)decl = any_cast<DeclNode *>(visitFieldDecl(ctx->fieldDecl()));
        else if (ctx->methodDecl() != null)decl = any_cast<DeclNode *>(visitMethodDecl(ctx->methodDecl()));
        else if (ctx->constructorDecl() != null)
            decl = any_cast<DeclNode *>(visitConstructorDecl(ctx->constructorDecl()));
        decl->setModifiers(modifiers);
        return decl;
    }

    std::any visitFieldDecl(SpadeParser::FieldDeclContext *ctx) override {
        auto decl = new Variable(ctx->name(), ctx->expr(), ctx->CONST() == null, Variable::VarKind::FIELD);
        currentTypes.back()->addChild(decl);
        return cast<DeclNode *>(decl);
    }

    std::any visitMethodDecl(SpadeParser::MethodDeclContext *ctx) override {
        auto decl = new Method(ctx);
        if (currentTypes.empty()) currentPackages.back()->addChild(decl);
        else currentTypes.back()->addChild(decl);
        return cast<DeclNode *>(decl);
    }

    std::any visitConstructorDecl(SpadeParser::ConstructorDeclContext *ctx) override {
        auto decl = new Constructor(ctx);
        currentTypes.back()->addChild(decl);
        return decl;
    }

    std::any visitModifiers(SpadeParser::ModifiersContext *ctx) override {
        vector<antlr4::Token *> tokens;
        for (auto modifier: ctx->ABSTRACT()) tokens.push_back(modifier->getSymbol());
        for (auto modifier: ctx->FINAL()) tokens.push_back(modifier->getSymbol());
        for (auto modifier: ctx->STATIC()) tokens.push_back(modifier->getSymbol());
        for (auto modifier: ctx->INLINE()) tokens.push_back(modifier->getSymbol());
        for (auto accessors: ctx->accessors())
            for (auto accessor:
                    any_cast<vector<antlr4::Token *>>(visitAccessors(accessors)))
                tokens.push_back(accessor);

        map<antlr4::Token *, int> table;
        for (auto token: tokens)
            try { table.at(token)++; }
            catch (std::out_of_range &) { table[token] = 1; }

        for (auto [token, occurrences]: table)
            if (occurrences > 1)
                reportError(token, "occurred more than 1 time");

        return tokens;
    }

    std::any visitAccessors(SpadeParser::AccessorsContext *ctx) override {
        vector<antlr4::Token *> tokens;
        if (ctx->PRIVATE() != null)tokens.push_back(ctx->PRIVATE()->getSymbol());
        else if (ctx->INTERNAL() != null)tokens.push_back(ctx->INTERNAL()->getSymbol());
        else if (ctx->PROTECTED() != null)tokens.push_back(ctx->PROTECTED()->getSymbol());
        else if (ctx->PUBLIC() != null)tokens.push_back(ctx->PUBLIC()->getSymbol());
        return tokens;
    }

    std::any visitFunctionDecl(SpadeParser::FunctionDeclContext *ctx) override {
        return visitMethodDecl(ctx->methodDecl());
    }

    std::any visitDefinition(SpadeParser::DefinitionContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParams(SpadeParser::ParamsContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParamList(SpadeParser::ParamListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParam(SpadeParser::ParamContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitVarDecl(SpadeParser::VarDeclContext *ctx) override {
        auto decl = new Variable(ctx->name(), ctx->expr(),
                                 ctx->CONST() == null, !currentMethods.empty()
                                                       ? Variable::VarKind::LOCAL
                                                       : Variable::VarKind::GLOBAL);
        if (!currentMethods.empty())currentScopes.back()->addChild(decl);
        else currentPackages.back()->addChild(decl);
        return decl;
    }

    std::any visitName(SpadeParser::NameContext *ctx) override {
        return ctx->type() ? checkType(ctx->type()) : null;
    }

    std::any visitStmts(SpadeParser::StmtsContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitIfStmt(SpadeParser::IfStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitWhileStmt(SpadeParser::WhileStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDoStmt(SpadeParser::DoStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitForStmt(SpadeParser::ForStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitForeachStmt(SpadeParser::ForeachStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMatchStmt(SpadeParser::MatchStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitThrowStmt(SpadeParser::ThrowStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTryStmt(SpadeParser::TryStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitContinueStmt(SpadeParser::ContinueStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBreakStmt(SpadeParser::BreakStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitReturnStmt(SpadeParser::ReturnStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitYieldStmt(SpadeParser::YieldStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitNoStmt(SpadeParser::NoStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitExprStmt(SpadeParser::ExprStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDestructDecl(SpadeParser::DestructDeclContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDestruct(SpadeParser::DestructContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBlock(SpadeParser::BlockContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMatchCase(SpadeParser::MatchCaseContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitCatchStmt(SpadeParser::CatchStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitFinallyStmt(SpadeParser::FinallyStmtContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBody(SpadeParser::BodyContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitElse(SpadeParser::ElseContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPowerExpr(SpadeParser::PowerExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitCastExpr(SpadeParser::CastExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTermExpr(SpadeParser::TermExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitConditonalExpr(SpadeParser::ConditonalExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitOrExpr(SpadeParser::OrExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitRelationalExpr(SpadeParser::RelationalExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitFactorExpr(SpadeParser::FactorExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitElvisExpr(SpadeParser::ElvisExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBitXorExpr(SpadeParser::BitXorExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitShiftExpr(SpadeParser::ShiftExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBitOrExpr(SpadeParser::BitOrExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitUnaryExpr(SpadeParser::UnaryExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitNotExpr(SpadeParser::NotExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTernaryExpr(SpadeParser::TernaryExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitLambdaExpr(SpadeParser::LambdaExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBitAndExpr(SpadeParser::BitAndExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAssignExpr(SpadeParser::AssignExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAndExpr(SpadeParser::AndExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAssigneeList(SpadeParser::AssigneeListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAssignee(SpadeParser::AssigneeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAssignOperator(SpadeParser::AssignOperatorContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostfixDot(SpadeParser::PostfixDotContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostFixPrimary(SpadeParser::PostFixPrimaryContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostfixBlock(SpadeParser::PostfixBlockContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostfixGeneric(SpadeParser::PostfixGenericContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostfixCall(SpadeParser::PostfixCallContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitPostfixIndexer(SpadeParser::PostfixIndexerContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitArgs(SpadeParser::ArgsContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitArg(SpadeParser::ArgContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitIndexer(SpadeParser::IndexerContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitSlice(SpadeParser::SliceContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitConstantExpr(SpadeParser::ConstantExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitBuilderExpr(SpadeParser::BuilderExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitSuperExpr(SpadeParser::SuperExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitThisExpr(SpadeParser::ThisExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitGroupExpr(SpadeParser::GroupExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTupleExpr(SpadeParser::TupleExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitSetExpr(SpadeParser::SetExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMapExpr(SpadeParser::MapExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitListExpr(SpadeParser::ListExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeExpr(SpadeParser::TypeExprContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitConstant(SpadeParser::ConstantContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitLiteral(SpadeParser::LiteralContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitObjectBuilder(SpadeParser::ObjectBuilderContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitItems(SpadeParser::ItemsContext *ctx) override {
        return ctx->expr();
    }

    std::any visitEntries(SpadeParser::EntriesContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitEntry(SpadeParser::EntryContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitLiteralType(SpadeParser::LiteralTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeofType(SpadeParser::TypeofTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitNullableType(SpadeParser::NullableTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitIntersectionType(SpadeParser::IntersectionTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitReferenceType(SpadeParser::ReferenceTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitFunctionType(SpadeParser::FunctionTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitObjectType(SpadeParser::ObjectTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitUnionType(SpadeParser::UnionTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitReference(SpadeParser::ReferenceContext *ctx) override {
        vector<antlr4::Token *> tokens;
        tokens.reserve(ctx->IDENTIFIER().size());
        for (auto identifier: ctx->IDENTIFIER()) {
            tokens.push_back(identifier->getSymbol());
        }
        return tokens;
    }

    std::any visitTypeArgs(SpadeParser::TypeArgsContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeArg(SpadeParser::TypeArgContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParamTypes(SpadeParser::ParamTypesContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParamType(SpadeParser::ParamTypeContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeList(SpadeParser::TypeListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMemberTypeList(SpadeParser::MemberTypeListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMemberType(SpadeParser::MemberTypeContext *ctx) override {
        return visitChildren(ctx);
    }
};

