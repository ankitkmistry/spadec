#pragma once


#include "antlr4-runtime.h"
#include "SpadeVisitor.h"
#include "../utils/common.hpp"
#include "../compiler/tree.hpp"
#include "ErrorListener.hpp"
#include "../utils/format.hpp"

/**
 * This class provides an empty implementation of SpadeVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class Visitor : public SpadeVisitor {
private:
    stack<DeclTree *> scopes;
    Package *currentPackage = null;
    stack<Type *> currentTypes;
    Method *currentMethod = null;

    ErrorListener *errorListener = new ErrorListener;

    std::function<void(antlr4::Token *, string)> reportError;

public:
    explicit Visitor(function<void(antlr4::Token *, string)> reportError) : reportError(reportError) {}

    std::any visitSep(SpadeParser::SepContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitCompilationUnit(SpadeParser::CompilationUnitContext *ctx) override {
        visitPackageStmt(ctx->packageStmt());
        for (auto decl: ctx->declaration()) {
            auto declNode = any_cast<DeclNode *>(visitDeclaration(decl));
            currentPackage->addChild(declNode);
        }
        return null;
    }

    std::any visitPackageStmt(SpadeParser::PackageStmtContext *ctx) override {
        auto list = any_cast<vector<antlr4::Token *>>(visitReference(ctx->reference()));
        for (int i = 0; i < list.size(); ++i) {
            auto item = list[i];
            if (scopes.empty()) {
                currentPackage = new Package(item);
                scopes.push(new DeclTree(currentPackage));
            } else {
                auto package = new Package(item);
                currentPackage->addChild(package);
                currentPackage = package;
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
        return decl;
    }

    std::any visitEnumDecl(SpadeParser::EnumDeclContext *ctx) override {
        auto *decl = new Enum(ctx->IDENTIFIER()->getSymbol(), ctx);
        currentTypes.push(decl);

        for (auto member: ctx->memberDecl()) {
            visitMemberDecl(member);
        }

        currentTypes.pop();
        if (currentTypes.top() != null)currentTypes.top()->addChild(decl);
        else currentPackage->addChild(decl);
        return decl;
    }

    std::any visitEnumList(SpadeParser::EnumListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitEnumerator(SpadeParser::EnumeratorContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitAnnoDecl(SpadeParser::AnnoDeclContext *ctx) override {
        auto *decl = new Annotation(ctx->declName()->IDENTIFIER()->getSymbol(), ctx);
        currentTypes.push(decl);

        for (auto member: ctx->memberDecl()) {
            visitMemberDecl(member);
        }

        currentTypes.pop();
        if (currentTypes.top() != null)currentTypes.top()->addChild(decl);
        else currentPackage->addChild(decl);
        return decl;
    }

    std::any visitInterfaceDecl(SpadeParser::InterfaceDeclContext *ctx) override {
        auto *decl = new Interface(ctx->declName()->IDENTIFIER()->getSymbol(), ctx);
        currentTypes.push(decl);

        for (auto member: ctx->memberDecl()) {
            visitMemberDecl(member);
        }

        currentTypes.pop();
        if (currentTypes.top() != null)currentTypes.top()->addChild(decl);
        else currentPackage->addChild(decl);
        return decl;
    }

    std::any visitClassDecl(SpadeParser::ClassDeclContext *ctx) override {
        auto *decl = new Class(ctx->declName()->IDENTIFIER()->getSymbol(), ctx);
        currentTypes.push(decl);

        for (auto member: ctx->memberDecl()) {
            visitMemberDecl(member);
        }

        currentTypes.pop();
        if (currentTypes.top() != null)currentTypes.top()->addChild(decl);
        else currentPackage->addChild(decl);
        return decl;
    }

    std::any visitParentList(SpadeParser::ParentListContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitParent(SpadeParser::ParentContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitDeclName(SpadeParser::DeclNameContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeParams(SpadeParser::TypeParamsContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitTypeParam(SpadeParser::TypeParamContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMemberDecl(SpadeParser::MemberDeclContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitFieldDecl(SpadeParser::FieldDeclContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitMethodDecl(SpadeParser::MethodDeclContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitConstructorDecl(SpadeParser::ConstructorDeclContext *ctx) override {
        return visitChildren(ctx);
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
        for (auto token: tokens) {
            try { table.at(token)++; }
            catch (std::out_of_range &) {
                table[token] = 1;
            }
        }

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
        return visitChildren(ctx);
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
        return visitChildren(ctx);
    }

    std::any visitNames(SpadeParser::NamesContext *ctx) override {
        return visitChildren(ctx);
    }

    std::any visitName(SpadeParser::NameContext *ctx) override {
        return visitChildren(ctx);
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
        return visitChildren(ctx);
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

