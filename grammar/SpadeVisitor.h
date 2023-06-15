
// Generated from D:/Programming (Ankit)/Projects/spadec/grammar\Spade.g4 by ANTLR 4.12.0

#pragma once


#include "antlr4-runtime.h"
#include "SpadeParser.h"



/**
 * This class defines an abstract visitor for a parse tree
 * produced by SpadeParser.
 */
class  SpadeVisitor : public antlr4::tree::AbstractParseTreeVisitor {
public:

  /**
   * Visit parse trees produced by SpadeParser.
   */
    virtual std::any visitSep(SpadeParser::SepContext *context) = 0;

    virtual std::any visitCompilationUnit(SpadeParser::CompilationUnitContext *context) = 0;

    virtual std::any visitPackageStmt(SpadeParser::PackageStmtContext *context) = 0;

    virtual std::any visitImportStmt(SpadeParser::ImportStmtContext *context) = 0;

    virtual std::any visitReference(SpadeParser::ReferenceContext *context) = 0;

    virtual std::any visitDeclaration(SpadeParser::DeclarationContext *context) = 0;

    virtual std::any visitEnumDecl(SpadeParser::EnumDeclContext *context) = 0;

    virtual std::any visitEnumList(SpadeParser::EnumListContext *context) = 0;

    virtual std::any visitEnumerator(SpadeParser::EnumeratorContext *context) = 0;

    virtual std::any visitAnnoDecl(SpadeParser::AnnoDeclContext *context) = 0;

    virtual std::any visitInterfaceDecl(SpadeParser::InterfaceDeclContext *context) = 0;

    virtual std::any visitClassDecl(SpadeParser::ClassDeclContext *context) = 0;

    virtual std::any visitParentList(SpadeParser::ParentListContext *context) = 0;

    virtual std::any visitParent(SpadeParser::ParentContext *context) = 0;

    virtual std::any visitDeclName(SpadeParser::DeclNameContext *context) = 0;

    virtual std::any visitTypeParams(SpadeParser::TypeParamsContext *context) = 0;

    virtual std::any visitTypeParam(SpadeParser::TypeParamContext *context) = 0;

    virtual std::any visitMemberDecl(SpadeParser::MemberDeclContext *context) = 0;

    virtual std::any visitFieldDecl(SpadeParser::FieldDeclContext *context) = 0;

    virtual std::any visitMethodDecl(SpadeParser::MethodDeclContext *context) = 0;

    virtual std::any visitConstructorDecl(SpadeParser::ConstructorDeclContext *context) = 0;

    virtual std::any visitModifiers(SpadeParser::ModifiersContext *context) = 0;

    virtual std::any visitAccessors(SpadeParser::AccessorsContext *context) = 0;

    virtual std::any visitFunctionDecl(SpadeParser::FunctionDeclContext *context) = 0;

    virtual std::any visitDefinition(SpadeParser::DefinitionContext *context) = 0;

    virtual std::any visitParams(SpadeParser::ParamsContext *context) = 0;

    virtual std::any visitParamList(SpadeParser::ParamListContext *context) = 0;

    virtual std::any visitParam(SpadeParser::ParamContext *context) = 0;

    virtual std::any visitVarDecl(SpadeParser::VarDeclContext *context) = 0;

    virtual std::any visitName(SpadeParser::NameContext *context) = 0;

    virtual std::any visitStmts(SpadeParser::StmtsContext *context) = 0;

    virtual std::any visitIfStmt(SpadeParser::IfStmtContext *context) = 0;

    virtual std::any visitWhileStmt(SpadeParser::WhileStmtContext *context) = 0;

    virtual std::any visitDoStmt(SpadeParser::DoStmtContext *context) = 0;

    virtual std::any visitForStmt(SpadeParser::ForStmtContext *context) = 0;

    virtual std::any visitForeachStmt(SpadeParser::ForeachStmtContext *context) = 0;

    virtual std::any visitMatchStmt(SpadeParser::MatchStmtContext *context) = 0;

    virtual std::any visitThrowStmt(SpadeParser::ThrowStmtContext *context) = 0;

    virtual std::any visitTryStmt(SpadeParser::TryStmtContext *context) = 0;

    virtual std::any visitContinueStmt(SpadeParser::ContinueStmtContext *context) = 0;

    virtual std::any visitBreakStmt(SpadeParser::BreakStmtContext *context) = 0;

    virtual std::any visitReturnStmt(SpadeParser::ReturnStmtContext *context) = 0;

    virtual std::any visitYieldStmt(SpadeParser::YieldStmtContext *context) = 0;

    virtual std::any visitNoStmt(SpadeParser::NoStmtContext *context) = 0;

    virtual std::any visitExprStmt(SpadeParser::ExprStmtContext *context) = 0;

    virtual std::any visitDestructDecl(SpadeParser::DestructDeclContext *context) = 0;

    virtual std::any visitDestruct(SpadeParser::DestructContext *context) = 0;

    virtual std::any visitBlock(SpadeParser::BlockContext *context) = 0;

    virtual std::any visitMatchCase(SpadeParser::MatchCaseContext *context) = 0;

    virtual std::any visitCatchStmt(SpadeParser::CatchStmtContext *context) = 0;

    virtual std::any visitFinallyStmt(SpadeParser::FinallyStmtContext *context) = 0;

    virtual std::any visitBody(SpadeParser::BodyContext *context) = 0;

    virtual std::any visitElse(SpadeParser::ElseContext *context) = 0;

    virtual std::any visitPowerExpr(SpadeParser::PowerExprContext *context) = 0;

    virtual std::any visitCastExpr(SpadeParser::CastExprContext *context) = 0;

    virtual std::any visitTermExpr(SpadeParser::TermExprContext *context) = 0;

    virtual std::any visitConditonalExpr(SpadeParser::ConditonalExprContext *context) = 0;

    virtual std::any visitOrExpr(SpadeParser::OrExprContext *context) = 0;

    virtual std::any visitRelationalExpr(SpadeParser::RelationalExprContext *context) = 0;

    virtual std::any visitFactorExpr(SpadeParser::FactorExprContext *context) = 0;

    virtual std::any visitElvisExpr(SpadeParser::ElvisExprContext *context) = 0;

    virtual std::any visitBitXorExpr(SpadeParser::BitXorExprContext *context) = 0;

    virtual std::any visitShiftExpr(SpadeParser::ShiftExprContext *context) = 0;

    virtual std::any visitBitOrExpr(SpadeParser::BitOrExprContext *context) = 0;

    virtual std::any visitUnaryExpr(SpadeParser::UnaryExprContext *context) = 0;

    virtual std::any visitNotExpr(SpadeParser::NotExprContext *context) = 0;

    virtual std::any visitTernaryExpr(SpadeParser::TernaryExprContext *context) = 0;

    virtual std::any visitLambdaExpr(SpadeParser::LambdaExprContext *context) = 0;

    virtual std::any visitBitAndExpr(SpadeParser::BitAndExprContext *context) = 0;

    virtual std::any visitAssignExpr(SpadeParser::AssignExprContext *context) = 0;

    virtual std::any visitAndExpr(SpadeParser::AndExprContext *context) = 0;

    virtual std::any visitAssigneeList(SpadeParser::AssigneeListContext *context) = 0;

    virtual std::any visitAssignee(SpadeParser::AssigneeContext *context) = 0;

    virtual std::any visitAssignOperator(SpadeParser::AssignOperatorContext *context) = 0;

    virtual std::any visitPostfixDot(SpadeParser::PostfixDotContext *context) = 0;

    virtual std::any visitPostFixPrimary(SpadeParser::PostFixPrimaryContext *context) = 0;

    virtual std::any visitPostfixBlock(SpadeParser::PostfixBlockContext *context) = 0;

    virtual std::any visitPostfixGeneric(SpadeParser::PostfixGenericContext *context) = 0;

    virtual std::any visitPostfixCall(SpadeParser::PostfixCallContext *context) = 0;

    virtual std::any visitPostfixIndexer(SpadeParser::PostfixIndexerContext *context) = 0;

    virtual std::any visitArgs(SpadeParser::ArgsContext *context) = 0;

    virtual std::any visitArg(SpadeParser::ArgContext *context) = 0;

    virtual std::any visitIndexer(SpadeParser::IndexerContext *context) = 0;

    virtual std::any visitSlice(SpadeParser::SliceContext *context) = 0;

    virtual std::any visitConstantExpr(SpadeParser::ConstantExprContext *context) = 0;

    virtual std::any visitBuilderExpr(SpadeParser::BuilderExprContext *context) = 0;

    virtual std::any visitSuperExpr(SpadeParser::SuperExprContext *context) = 0;

    virtual std::any visitThisExpr(SpadeParser::ThisExprContext *context) = 0;

    virtual std::any visitGroupExpr(SpadeParser::GroupExprContext *context) = 0;

    virtual std::any visitTupleExpr(SpadeParser::TupleExprContext *context) = 0;

    virtual std::any visitSetExpr(SpadeParser::SetExprContext *context) = 0;

    virtual std::any visitMapExpr(SpadeParser::MapExprContext *context) = 0;

    virtual std::any visitListExpr(SpadeParser::ListExprContext *context) = 0;

    virtual std::any visitTypeExpr(SpadeParser::TypeExprContext *context) = 0;

    virtual std::any visitConstant(SpadeParser::ConstantContext *context) = 0;

    virtual std::any visitLiteral(SpadeParser::LiteralContext *context) = 0;

    virtual std::any visitObjectBuilder(SpadeParser::ObjectBuilderContext *context) = 0;

    virtual std::any visitItems(SpadeParser::ItemsContext *context) = 0;

    virtual std::any visitEntries(SpadeParser::EntriesContext *context) = 0;

    virtual std::any visitEntry(SpadeParser::EntryContext *context) = 0;

    virtual std::any visitLiteralType(SpadeParser::LiteralTypeContext *context) = 0;

    virtual std::any visitTypeofType(SpadeParser::TypeofTypeContext *context) = 0;

    virtual std::any visitNullableType(SpadeParser::NullableTypeContext *context) = 0;

    virtual std::any visitIntersectionType(SpadeParser::IntersectionTypeContext *context) = 0;

    virtual std::any visitReferenceType(SpadeParser::ReferenceTypeContext *context) = 0;

    virtual std::any visitFunctionType(SpadeParser::FunctionTypeContext *context) = 0;

    virtual std::any visitObjectType(SpadeParser::ObjectTypeContext *context) = 0;

    virtual std::any visitUnionType(SpadeParser::UnionTypeContext *context) = 0;

    virtual std::any visitTypeArgs(SpadeParser::TypeArgsContext *context) = 0;

    virtual std::any visitTypeArg(SpadeParser::TypeArgContext *context) = 0;

    virtual std::any visitParamTypes(SpadeParser::ParamTypesContext *context) = 0;

    virtual std::any visitParamType(SpadeParser::ParamTypeContext *context) = 0;

    virtual std::any visitTypeList(SpadeParser::TypeListContext *context) = 0;

    virtual std::any visitMemberTypeList(SpadeParser::MemberTypeListContext *context) = 0;

    virtual std::any visitMemberType(SpadeParser::MemberTypeContext *context) = 0;


};

