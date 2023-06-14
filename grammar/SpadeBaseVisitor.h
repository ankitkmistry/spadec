
// Generated from D:/Programming (Ankit)/Projects/spadec/grammar\Spade.g4 by ANTLR 4.12.0

#pragma once


#include "antlr4-runtime.h"
#include "SpadeVisitor.h"


/**
 * This class provides an empty implementation of SpadeVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  SpadeBaseVisitor : public SpadeVisitor {
public:

  virtual std::any visitSep(SpadeParser::SepContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitCompilationUnit(SpadeParser::CompilationUnitContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPackageStmt(SpadeParser::PackageStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitImportStmt(SpadeParser::ImportStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitReference(SpadeParser::ReferenceContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclaration(SpadeParser::DeclarationContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEnumDecl(SpadeParser::EnumDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEnumList(SpadeParser::EnumListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEnumerator(SpadeParser::EnumeratorContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAnnoDecl(SpadeParser::AnnoDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitInterfaceDecl(SpadeParser::InterfaceDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitClassDecl(SpadeParser::ClassDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParentList(SpadeParser::ParentListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParent(SpadeParser::ParentContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDeclName(SpadeParser::DeclNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeParams(SpadeParser::TypeParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeParam(SpadeParser::TypeParamContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMemberDecl(SpadeParser::MemberDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFieldDecl(SpadeParser::FieldDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMethodDecl(SpadeParser::MethodDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitConstructorDecl(SpadeParser::ConstructorDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitModifiers(SpadeParser::ModifiersContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAccessors(SpadeParser::AccessorsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFunctionDecl(SpadeParser::FunctionDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDefinition(SpadeParser::DefinitionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParams(SpadeParser::ParamsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamList(SpadeParser::ParamListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParam(SpadeParser::ParamContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarDecl(SpadeParser::VarDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNames(SpadeParser::NamesContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitName(SpadeParser::NameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStmts(SpadeParser::StmtsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitIfStmt(SpadeParser::IfStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitWhileStmt(SpadeParser::WhileStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDoStmt(SpadeParser::DoStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitForStmt(SpadeParser::ForStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitForeachStmt(SpadeParser::ForeachStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMatchStmt(SpadeParser::MatchStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitThrowStmt(SpadeParser::ThrowStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTryStmt(SpadeParser::TryStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitContinueStmt(SpadeParser::ContinueStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBreakStmt(SpadeParser::BreakStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitReturnStmt(SpadeParser::ReturnStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitYieldStmt(SpadeParser::YieldStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNoStmt(SpadeParser::NoStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExprStmt(SpadeParser::ExprStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDestructDecl(SpadeParser::DestructDeclContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitDestruct(SpadeParser::DestructContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBlock(SpadeParser::BlockContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMatchCase(SpadeParser::MatchCaseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitCatchStmt(SpadeParser::CatchStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFinallyStmt(SpadeParser::FinallyStmtContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBody(SpadeParser::BodyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitElse(SpadeParser::ElseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPowerExpr(SpadeParser::PowerExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitCastExpr(SpadeParser::CastExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTermExpr(SpadeParser::TermExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitConditonalExpr(SpadeParser::ConditonalExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOrExpr(SpadeParser::OrExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitRelationalExpr(SpadeParser::RelationalExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFactorExpr(SpadeParser::FactorExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitElvisExpr(SpadeParser::ElvisExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBitXorExpr(SpadeParser::BitXorExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitShiftExpr(SpadeParser::ShiftExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBitOrExpr(SpadeParser::BitOrExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnaryExpr(SpadeParser::UnaryExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNotExpr(SpadeParser::NotExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTernaryExpr(SpadeParser::TernaryExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLambdaExpr(SpadeParser::LambdaExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBitAndExpr(SpadeParser::BitAndExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAssignExpr(SpadeParser::AssignExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAndExpr(SpadeParser::AndExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAssigneeList(SpadeParser::AssigneeListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAssignee(SpadeParser::AssigneeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAssignOperator(SpadeParser::AssignOperatorContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostfixDot(SpadeParser::PostfixDotContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostFixPrimary(SpadeParser::PostFixPrimaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostfixBlock(SpadeParser::PostfixBlockContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostfixGeneric(SpadeParser::PostfixGenericContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostfixCall(SpadeParser::PostfixCallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPostfixIndexer(SpadeParser::PostfixIndexerContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgs(SpadeParser::ArgsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArg(SpadeParser::ArgContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitIndexer(SpadeParser::IndexerContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSlice(SpadeParser::SliceContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitConstantExpr(SpadeParser::ConstantExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBuilderExpr(SpadeParser::BuilderExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSuperExpr(SpadeParser::SuperExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitThisExpr(SpadeParser::ThisExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitGroupExpr(SpadeParser::GroupExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTupleExpr(SpadeParser::TupleExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitSetExpr(SpadeParser::SetExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMapExpr(SpadeParser::MapExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitListExpr(SpadeParser::ListExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeExpr(SpadeParser::TypeExprContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitConstant(SpadeParser::ConstantContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLiteral(SpadeParser::LiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitObjectBuilder(SpadeParser::ObjectBuilderContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitItems(SpadeParser::ItemsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEntries(SpadeParser::EntriesContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitEntry(SpadeParser::EntryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLiteralType(SpadeParser::LiteralTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeofType(SpadeParser::TypeofTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNullableType(SpadeParser::NullableTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitIntersectionType(SpadeParser::IntersectionTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitReferenceType(SpadeParser::ReferenceTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFunctionType(SpadeParser::FunctionTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitObjectType(SpadeParser::ObjectTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitUnionType(SpadeParser::UnionTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeArgs(SpadeParser::TypeArgsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeArg(SpadeParser::TypeArgContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamTypes(SpadeParser::ParamTypesContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParamType(SpadeParser::ParamTypeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTypeList(SpadeParser::TypeListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMemberTypeList(SpadeParser::MemberTypeListContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitMemberType(SpadeParser::MemberTypeContext *ctx) override {
    return visitChildren(ctx);
  }


};

