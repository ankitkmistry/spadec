
// Generated from D:/Programming (Ankit)/Projects/spadec/grammar\Spade.g4 by ANTLR 4.12.0

#pragma once


#include "antlr4-runtime.h"




class  SpadeParser : public antlr4::Parser {
public:
  enum {
    T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, 
    T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, 
    T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, 
    T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, 
    T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, T__31 = 32, 
    T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38, 
    T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, 
    T__44 = 45, T__45 = 46, PACKAGE = 47, IMPORT = 48, EXPORT = 49, EXTENDS = 50, 
    IMPLEMENTS = 51, ENUM = 52, CLASS = 53, INTERFACE = 54, ANNOTATION = 55, 
    INIT = 56, FUN = 57, CONST = 58, VAR = 59, ABSTRACT = 60, FINAL = 61, 
    STATIC = 62, INLINE = 63, PRIVATE = 64, PROTECTED = 65, INTERNAL = 66, 
    PUBLIC = 67, IF = 68, ELSE = 69, WHILE = 70, DO = 71, FOR = 72, IN = 73, 
    MATCH = 74, WHEN = 75, THROW = 76, TRY = 77, CATCH = 78, FINALLY = 79, 
    CONTINUE = 80, BREAK = 81, RETURN = 82, YIELD = 83, AS = 84, IS = 85, 
    NOT = 86, AND = 87, OR = 88, SUPER = 89, THIS = 90, TRUE = 91, FALSE = 92, 
    NULL_ = 93, OBJECT = 94, TYPE = 95, TYPEOF = 96, OUT = 97, REF = 98, 
    IDENTIFIER = 99, INTEGER = 100, FLOAT = 101, STRING = 102, WS = 103, 
    NEWLINE = 104, BLOCK_COMMENT = 105, LINE_COMMENT = 106
  };

  enum {
    RuleSep = 0, RuleCompilationUnit = 1, RulePackageStmt = 2, RuleImportStmt = 3, 
    RuleReference = 4, RuleDeclaration = 5, RuleEnumDecl = 6, RuleEnumList = 7, 
    RuleEnumerator = 8, RuleAnnoDecl = 9, RuleInterfaceDecl = 10, RuleClassDecl = 11, 
    RuleParentList = 12, RuleParent = 13, RuleDeclName = 14, RuleTypeParams = 15, 
    RuleTypeParam = 16, RuleMemberDecl = 17, RuleFieldDecl = 18, RuleMethodDecl = 19, 
    RuleConstructorDecl = 20, RuleModifiers = 21, RuleAccessors = 22, RuleFunctionDecl = 23, 
    RuleDefinition = 24, RuleParams = 25, RuleParamList = 26, RuleParam = 27, 
    RuleVarDecl = 28, RuleName = 29, RuleStmts = 30, RuleStmt = 31, RuleDestructDecl = 32, 
    RuleDestruct = 33, RuleBlock = 34, RuleMatchCase = 35, RuleCatchStmt = 36, 
    RuleFinallyStmt = 37, RuleBody = 38, RuleElse = 39, RuleExpr = 40, RuleAssigneeList = 41, 
    RuleAssignee = 42, RuleAssignOperator = 43, RulePostfix = 44, RuleArgs = 45, 
    RuleArg = 46, RuleIndexer = 47, RuleSlice = 48, RulePrimary = 49, RuleConstant = 50, 
    RuleLiteral = 51, RuleObjectBuilder = 52, RuleItems = 53, RuleEntries = 54, 
    RuleEntry = 55, RuleType = 56, RuleTypeArgs = 57, RuleTypeArg = 58, 
    RuleParamTypes = 59, RuleParamType = 60, RuleTypeList = 61, RuleMemberTypeList = 62, 
    RuleMemberType = 63
  };

  explicit SpadeParser(antlr4::TokenStream *input);

  SpadeParser(antlr4::TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options);

  ~SpadeParser() override;

  std::string getGrammarFileName() const override;

  const antlr4::atn::ATN& getATN() const override;

  const std::vector<std::string>& getRuleNames() const override;

  const antlr4::dfa::Vocabulary& getVocabulary() const override;

  antlr4::atn::SerializedATNView getSerializedATN() const override;


  class SepContext;
  class CompilationUnitContext;
  class PackageStmtContext;
  class ImportStmtContext;
  class ReferenceContext;
  class DeclarationContext;
  class EnumDeclContext;
  class EnumListContext;
  class EnumeratorContext;
  class AnnoDeclContext;
  class InterfaceDeclContext;
  class ClassDeclContext;
  class ParentListContext;
  class ParentContext;
  class DeclNameContext;
  class TypeParamsContext;
  class TypeParamContext;
  class MemberDeclContext;
  class FieldDeclContext;
  class MethodDeclContext;
  class ConstructorDeclContext;
  class ModifiersContext;
  class AccessorsContext;
  class FunctionDeclContext;
  class DefinitionContext;
  class ParamsContext;
  class ParamListContext;
  class ParamContext;
  class VarDeclContext;
  class NameContext;
  class StmtsContext;
  class StmtContext;
  class DestructDeclContext;
  class DestructContext;
  class BlockContext;
  class MatchCaseContext;
  class CatchStmtContext;
  class FinallyStmtContext;
  class BodyContext;
  class ElseContext;
  class ExprContext;
  class AssigneeListContext;
  class AssigneeContext;
  class AssignOperatorContext;
  class PostfixContext;
  class ArgsContext;
  class ArgContext;
  class IndexerContext;
  class SliceContext;
  class PrimaryContext;
  class ConstantContext;
  class LiteralContext;
  class ObjectBuilderContext;
  class ItemsContext;
  class EntriesContext;
  class EntryContext;
  class TypeContext;
  class TypeArgsContext;
  class TypeArgContext;
  class ParamTypesContext;
  class ParamTypeContext;
  class TypeListContext;
  class MemberTypeListContext;
  class MemberTypeContext; 

  class  SepContext : public antlr4::ParserRuleContext {
  public:
    SepContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  SepContext* sep();

  class  CompilationUnitContext : public antlr4::ParserRuleContext {
  public:
    CompilationUnitContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *EOF();
    PackageStmtContext *packageStmt();
    std::vector<ImportStmtContext *> importStmt();
    ImportStmtContext* importStmt(size_t i);
    std::vector<DeclarationContext *> declaration();
    DeclarationContext* declaration(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  CompilationUnitContext* compilationUnit();

  class  PackageStmtContext : public antlr4::ParserRuleContext {
  public:
    PackageStmtContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *PACKAGE();
    ReferenceContext *reference();
    SepContext *sep();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  PackageStmtContext* packageStmt();

  class  ImportStmtContext : public antlr4::ParserRuleContext {
  public:
    ImportStmtContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IMPORT();
    ReferenceContext *reference();
    SepContext *sep();
    antlr4::tree::TerminalNode *AS();
    antlr4::tree::TerminalNode *IDENTIFIER();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ImportStmtContext* importStmt();

  class  ReferenceContext : public antlr4::ParserRuleContext {
  public:
    ReferenceContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<antlr4::tree::TerminalNode *> IDENTIFIER();
    antlr4::tree::TerminalNode* IDENTIFIER(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ReferenceContext* reference();

  class  DeclarationContext : public antlr4::ParserRuleContext {
  public:
    DeclarationContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ModifiersContext *modifiers();
    VarDeclContext *varDecl();
    SepContext *sep();
    FunctionDeclContext *functionDecl();
    ClassDeclContext *classDecl();
    InterfaceDeclContext *interfaceDecl();
    EnumDeclContext *enumDecl();
    AnnoDeclContext *annoDecl();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclarationContext* declaration();

  class  EnumDeclContext : public antlr4::ParserRuleContext {
  public:
    EnumDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ENUM();
    antlr4::tree::TerminalNode *IDENTIFIER();
    antlr4::tree::TerminalNode *IMPLEMENTS();
    ParentListContext *parentList();
    EnumListContext *enumList();
    SepContext *sep();
    std::vector<MemberDeclContext *> memberDecl();
    MemberDeclContext* memberDecl(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  EnumDeclContext* enumDecl();

  class  EnumListContext : public antlr4::ParserRuleContext {
  public:
    EnumListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<EnumeratorContext *> enumerator();
    EnumeratorContext* enumerator(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  EnumListContext* enumList();

  class  EnumeratorContext : public antlr4::ParserRuleContext {
  public:
    EnumeratorContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    ExprContext *expr();
    ArgsContext *args();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  EnumeratorContext* enumerator();

  class  AnnoDeclContext : public antlr4::ParserRuleContext {
  public:
    AnnoDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ANNOTATION();
    DeclNameContext *declName();
    antlr4::tree::TerminalNode *EXTENDS();
    ParentContext *parent();
    antlr4::tree::TerminalNode *IMPLEMENTS();
    ParentListContext *parentList();
    std::vector<MemberDeclContext *> memberDecl();
    MemberDeclContext* memberDecl(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AnnoDeclContext* annoDecl();

  class  InterfaceDeclContext : public antlr4::ParserRuleContext {
  public:
    InterfaceDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *INTERFACE();
    DeclNameContext *declName();
    antlr4::tree::TerminalNode *EXTENDS();
    ParentListContext *parentList();
    std::vector<MemberDeclContext *> memberDecl();
    MemberDeclContext* memberDecl(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  InterfaceDeclContext* interfaceDecl();

  class  ClassDeclContext : public antlr4::ParserRuleContext {
  public:
    ClassDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *CLASS();
    DeclNameContext *declName();
    antlr4::tree::TerminalNode *EXTENDS();
    ParentContext *parent();
    antlr4::tree::TerminalNode *IMPLEMENTS();
    ParentListContext *parentList();
    std::vector<MemberDeclContext *> memberDecl();
    MemberDeclContext* memberDecl(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ClassDeclContext* classDecl();

  class  ParentListContext : public antlr4::ParserRuleContext {
  public:
    ParentListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ParentContext *> parent();
    ParentContext* parent(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParentListContext* parentList();

  class  ParentContext : public antlr4::ParserRuleContext {
  public:
    ParentContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ReferenceContext *reference();
    TypeArgsContext *typeArgs();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParentContext* parent();

  class  DeclNameContext : public antlr4::ParserRuleContext {
  public:
    DeclNameContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    TypeParamsContext *typeParams();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DeclNameContext* declName();

  class  TypeParamsContext : public antlr4::ParserRuleContext {
  public:
    TypeParamsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<TypeParamContext *> typeParam();
    TypeParamContext* typeParam(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TypeParamsContext* typeParams();

  class  TypeParamContext : public antlr4::ParserRuleContext {
  public:
    SpadeParser::TypeContext *variantOf = nullptr;
    SpadeParser::TypeContext *defaultValue = nullptr;
    TypeParamContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    antlr4::tree::TerminalNode *OUT();
    antlr4::tree::TerminalNode *IN();
    std::vector<TypeContext *> type();
    TypeContext* type(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TypeParamContext* typeParam();

  class  MemberDeclContext : public antlr4::ParserRuleContext {
  public:
    MemberDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ModifiersContext *modifiers();
    SepContext *sep();
    FieldDeclContext *fieldDecl();
    MethodDeclContext *methodDecl();
    ConstructorDeclContext *constructorDecl();
    ClassDeclContext *classDecl();
    InterfaceDeclContext *interfaceDecl();
    EnumDeclContext *enumDecl();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MemberDeclContext* memberDecl();

  class  FieldDeclContext : public antlr4::ParserRuleContext {
  public:
    FieldDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    NameContext *name();
    antlr4::tree::TerminalNode *CONST();
    ExprContext *expr();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  FieldDeclContext* fieldDecl();

  class  MethodDeclContext : public antlr4::ParserRuleContext {
  public:
    MethodDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    ParamsContext *params();
    TypeContext *type();
    DefinitionContext *definition();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MethodDeclContext* methodDecl();

  class  ConstructorDeclContext : public antlr4::ParserRuleContext {
  public:
    ConstructorDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *INIT();
    ParamsContext *params();
    DefinitionContext *definition();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ConstructorDeclContext* constructorDecl();

  class  ModifiersContext : public antlr4::ParserRuleContext {
  public:
    ModifiersContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<antlr4::tree::TerminalNode *> ABSTRACT();
    antlr4::tree::TerminalNode* ABSTRACT(size_t i);
    std::vector<antlr4::tree::TerminalNode *> FINAL();
    antlr4::tree::TerminalNode* FINAL(size_t i);
    std::vector<antlr4::tree::TerminalNode *> STATIC();
    antlr4::tree::TerminalNode* STATIC(size_t i);
    std::vector<antlr4::tree::TerminalNode *> INLINE();
    antlr4::tree::TerminalNode* INLINE(size_t i);
    std::vector<AccessorsContext *> accessors();
    AccessorsContext* accessors(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ModifiersContext* modifiers();

  class  AccessorsContext : public antlr4::ParserRuleContext {
  public:
    AccessorsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *PRIVATE();
    antlr4::tree::TerminalNode *INTERNAL();
    antlr4::tree::TerminalNode *PROTECTED();
    antlr4::tree::TerminalNode *PUBLIC();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AccessorsContext* accessors();

  class  FunctionDeclContext : public antlr4::ParserRuleContext {
  public:
    FunctionDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *FUN();
    MethodDeclContext *methodDecl();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  FunctionDeclContext* functionDecl();

  class  DefinitionContext : public antlr4::ParserRuleContext {
  public:
    DefinitionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    StmtContext *stmt();
    SepContext *sep();
    BlockContext *block();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DefinitionContext* definition();

  class  ParamsContext : public antlr4::ParserRuleContext {
  public:
    ParamsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ParamListContext *> paramList();
    ParamListContext* paramList(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamsContext* params();

  class  ParamListContext : public antlr4::ParserRuleContext {
  public:
    ParamListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ParamContext *> param();
    ParamContext* param(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamListContext* paramList();

  class  ParamContext : public antlr4::ParserRuleContext {
  public:
    ParamContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    TypeContext *type();
    ExprContext *expr();
    antlr4::tree::TerminalNode *CONST();
    antlr4::tree::TerminalNode *REF();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamContext* param();

  class  VarDeclContext : public antlr4::ParserRuleContext {
  public:
    VarDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    NameContext *name();
    antlr4::tree::TerminalNode *VAR();
    antlr4::tree::TerminalNode *CONST();
    ExprContext *expr();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  VarDeclContext* varDecl();

  class  NameContext : public antlr4::ParserRuleContext {
  public:
    NameContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    TypeContext *type();
    DestructDeclContext *destructDecl();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  NameContext* name();

  class  StmtsContext : public antlr4::ParserRuleContext {
  public:
    StmtsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    StmtContext *stmt();
    SepContext *sep();
    BlockContext *block();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  StmtsContext* stmts();

  class  StmtContext : public antlr4::ParserRuleContext {
  public:
    StmtContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    StmtContext() = default;
    void copyFrom(StmtContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  ForStmtContext : public StmtContext {
  public:
    ForStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *FOR();
    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);
    BodyContext *body();
    VarDeclContext *varDecl();
    ElseContext *else_();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  WhileStmtContext : public StmtContext {
  public:
    WhileStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *WHILE();
    ExprContext *expr();
    BodyContext *body();
    ElseContext *else_();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ForeachStmtContext : public StmtContext {
  public:
    ForeachStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *FOR();
    antlr4::tree::TerminalNode *IDENTIFIER();
    antlr4::tree::TerminalNode *IN();
    PostfixContext *postfix();
    BodyContext *body();
    ElseContext *else_();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TryStmtContext : public StmtContext {
  public:
    TryStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *TRY();
    BlockContext *block();
    FinallyStmtContext *finallyStmt();
    std::vector<CatchStmtContext *> catchStmt();
    CatchStmtContext* catchStmt(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  YieldStmtContext : public StmtContext {
  public:
    YieldStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *YIELD();
    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ReturnStmtContext : public StmtContext {
  public:
    ReturnStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *RETURN();
    StmtsContext *stmts();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ThrowStmtContext : public StmtContext {
  public:
    ThrowStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *THROW();
    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  NoStmtContext : public StmtContext {
  public:
    NoStmtContext(StmtContext *ctx);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ExprStmtContext : public StmtContext {
  public:
    ExprStmtContext(StmtContext *ctx);

    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  IfStmtContext : public StmtContext {
  public:
    IfStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *IF();
    ExprContext *expr();
    BodyContext *body();
    ElseContext *else_();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  MatchStmtContext : public StmtContext {
  public:
    MatchStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *MATCH();
    ExprContext *expr();
    std::vector<MatchCaseContext *> matchCase();
    MatchCaseContext* matchCase(size_t i);
    antlr4::tree::TerminalNode *ELSE();
    StmtsContext *stmts();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  BreakStmtContext : public StmtContext {
  public:
    BreakStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *BREAK();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  DoStmtContext : public StmtContext {
  public:
    DoStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *DO();
    BlockContext *block();
    antlr4::tree::TerminalNode *WHILE();
    ExprContext *expr();
    ElseContext *else_();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ContinueStmtContext : public StmtContext {
  public:
    ContinueStmtContext(StmtContext *ctx);

    antlr4::tree::TerminalNode *CONTINUE();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  StmtContext* stmt();

  class  DestructDeclContext : public antlr4::ParserRuleContext {
  public:
    DestructDeclContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<DestructContext *> destruct();
    DestructContext* destruct(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DestructDeclContext* destructDecl();

  class  DestructContext : public antlr4::ParserRuleContext {
  public:
    DestructContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    antlr4::tree::TerminalNode *INTEGER();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  DestructContext* destruct();

  class  BlockContext : public antlr4::ParserRuleContext {
  public:
    BlockContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<BlockContext *> block();
    BlockContext* block(size_t i);
    std::vector<DeclarationContext *> declaration();
    DeclarationContext* declaration(size_t i);
    std::vector<StmtContext *> stmt();
    StmtContext* stmt(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  BlockContext* block();

  class  MatchCaseContext : public antlr4::ParserRuleContext {
  public:
    MatchCaseContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *WHEN();
    ItemsContext *items();
    StmtsContext *stmts();
    antlr4::tree::TerminalNode *IF();
    ExprContext *expr();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MatchCaseContext* matchCase();

  class  CatchStmtContext : public antlr4::ParserRuleContext {
  public:
    CatchStmtContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *CATCH();
    TypeListContext *typeList();
    BlockContext *block();
    antlr4::tree::TerminalNode *AS();
    antlr4::tree::TerminalNode *IDENTIFIER();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  CatchStmtContext* catchStmt();

  class  FinallyStmtContext : public antlr4::ParserRuleContext {
  public:
    FinallyStmtContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *FINALLY();
    BlockContext *block();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  FinallyStmtContext* finallyStmt();

  class  BodyContext : public antlr4::ParserRuleContext {
  public:
    BodyContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    StmtContext *stmt();
    SepContext *sep();
    BlockContext *block();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  BodyContext* body();

  class  ElseContext : public antlr4::ParserRuleContext {
  public:
    ElseContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ELSE();
    BodyContext *body();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ElseContext* else_();

  class  ExprContext : public antlr4::ParserRuleContext {
  public:
    ExprContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    ExprContext() = default;
    void copyFrom(ExprContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  PowerExprContext : public ExprContext {
  public:
    PowerExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  CastExprContext : public ExprContext {
  public:
    CastExprContext(ExprContext *ctx);

    ExprContext *expr();
    antlr4::tree::TerminalNode *AS();
    TypeContext *type();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TermExprContext : public ExprContext {
  public:
    TermExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ConditonalExprContext : public ExprContext {
  public:
    ConditonalExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);
    antlr4::tree::TerminalNode *IS();
    antlr4::tree::TerminalNode *IN();
    antlr4::tree::TerminalNode *NOT();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  OrExprContext : public ExprContext {
  public:
    OrExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);
    antlr4::tree::TerminalNode *OR();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  RelationalExprContext : public ExprContext {
  public:
    RelationalExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  FactorExprContext : public ExprContext {
  public:
    FactorExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ElvisExprContext : public ExprContext {
  public:
    ElvisExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  BitXorExprContext : public ExprContext {
  public:
    BitXorExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ShiftExprContext : public ExprContext {
  public:
    ShiftExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  BitOrExprContext : public ExprContext {
  public:
    BitOrExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  UnaryExprContext : public ExprContext {
  public:
    UnaryExprContext(ExprContext *ctx);

    PostfixContext *postfix();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  NotExprContext : public ExprContext {
  public:
    NotExprContext(ExprContext *ctx);

    antlr4::tree::TerminalNode *NOT();
    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TernaryExprContext : public ExprContext {
  public:
    TernaryExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  LambdaExprContext : public ExprContext {
  public:
    LambdaExprContext(ExprContext *ctx);

    ParamContext *param();
    BlockContext *block();
    ExprContext *expr();
    TypeContext *type();
    ParamsContext *params();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  BitAndExprContext : public ExprContext {
  public:
    BitAndExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  AssignExprContext : public ExprContext {
  public:
    AssignExprContext(ExprContext *ctx);

    AssigneeListContext *assigneeList();
    AssignOperatorContext *assignOperator();
    ItemsContext *items();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  AndExprContext : public ExprContext {
  public:
    AndExprContext(ExprContext *ctx);

    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);
    antlr4::tree::TerminalNode *AND();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  ExprContext* expr();
  ExprContext* expr(int precedence);
  class  AssigneeListContext : public antlr4::ParserRuleContext {
  public:
    AssigneeListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<AssigneeContext *> assignee();
    AssigneeContext* assignee(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AssigneeListContext* assigneeList();

  class  AssigneeContext : public antlr4::ParserRuleContext {
  public:
    AssigneeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    PostfixContext *postfix();
    DestructDeclContext *destructDecl();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AssigneeContext* assignee();

  class  AssignOperatorContext : public antlr4::ParserRuleContext {
  public:
    AssignOperatorContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  AssignOperatorContext* assignOperator();

  class  PostfixContext : public antlr4::ParserRuleContext {
  public:
    PostfixContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    PostfixContext() = default;
    void copyFrom(PostfixContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  PostfixDotContext : public PostfixContext {
  public:
    PostfixDotContext(PostfixContext *ctx);

    PostfixContext *postfix();
    antlr4::tree::TerminalNode *IDENTIFIER();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  PostFixPrimaryContext : public PostfixContext {
  public:
    PostFixPrimaryContext(PostfixContext *ctx);

    PrimaryContext *primary();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  PostfixBlockContext : public PostfixContext {
  public:
    PostfixBlockContext(PostfixContext *ctx);

    PostfixContext *postfix();
    BlockContext *block();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  PostfixGenericContext : public PostfixContext {
  public:
    PostfixGenericContext(PostfixContext *ctx);

    PostfixContext *postfix();
    TypeArgsContext *typeArgs();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  PostfixCallContext : public PostfixContext {
  public:
    PostfixCallContext(PostfixContext *ctx);

    PostfixContext *postfix();
    ArgsContext *args();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  PostfixIndexerContext : public PostfixContext {
  public:
    PostfixIndexerContext(PostfixContext *ctx);

    PostfixContext *postfix();
    IndexerContext *indexer();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  PostfixContext* postfix();
  PostfixContext* postfix(int precedence);
  class  ArgsContext : public antlr4::ParserRuleContext {
  public:
    ArgsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ArgContext *> arg();
    ArgContext* arg(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ArgsContext* args();

  class  ArgContext : public antlr4::ParserRuleContext {
  public:
    ArgContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ExprContext *expr();
    antlr4::tree::TerminalNode *IDENTIFIER();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ArgContext* arg();

  class  IndexerContext : public antlr4::ParserRuleContext {
  public:
    IndexerContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<SliceContext *> slice();
    SliceContext* slice(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  IndexerContext* indexer();

  class  SliceContext : public antlr4::ParserRuleContext {
  public:
    SliceContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  SliceContext* slice();

  class  PrimaryContext : public antlr4::ParserRuleContext {
  public:
    PrimaryContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    PrimaryContext() = default;
    void copyFrom(PrimaryContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  GroupExprContext : public PrimaryContext {
  public:
    GroupExprContext(PrimaryContext *ctx);

    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ThisExprContext : public PrimaryContext {
  public:
    ThisExprContext(PrimaryContext *ctx);

    antlr4::tree::TerminalNode *THIS();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  SuperExprContext : public PrimaryContext {
  public:
    SuperExprContext(PrimaryContext *ctx);

    antlr4::tree::TerminalNode *SUPER();
    antlr4::tree::TerminalNode *IDENTIFIER();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TypeExprContext : public PrimaryContext {
  public:
    TypeExprContext(PrimaryContext *ctx);

    TypeContext *type();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  MapExprContext : public PrimaryContext {
  public:
    MapExprContext(PrimaryContext *ctx);

    EntriesContext *entries();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TupleExprContext : public PrimaryContext {
  public:
    TupleExprContext(PrimaryContext *ctx);

    ItemsContext *items();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  BuilderExprContext : public PrimaryContext {
  public:
    BuilderExprContext(PrimaryContext *ctx);

    ObjectBuilderContext *objectBuilder();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ListExprContext : public PrimaryContext {
  public:
    ListExprContext(PrimaryContext *ctx);

    ItemsContext *items();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  SetExprContext : public PrimaryContext {
  public:
    SetExprContext(PrimaryContext *ctx);

    ItemsContext *items();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ConstantExprContext : public PrimaryContext {
  public:
    ConstantExprContext(PrimaryContext *ctx);

    ConstantContext *constant();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  PrimaryContext* primary();

  class  ConstantContext : public antlr4::ParserRuleContext {
  public:
    ConstantContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *TRUE();
    antlr4::tree::TerminalNode *FALSE();
    antlr4::tree::TerminalNode *NULL_();
    LiteralContext *literal();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ConstantContext* constant();

  class  LiteralContext : public antlr4::ParserRuleContext {
  public:
    LiteralContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *INTEGER();
    antlr4::tree::TerminalNode *FLOAT();
    antlr4::tree::TerminalNode *STRING();
    antlr4::tree::TerminalNode *IDENTIFIER();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  LiteralContext* literal();

  class  ObjectBuilderContext : public antlr4::ParserRuleContext {
  public:
    ObjectBuilderContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *OBJECT();
    TypeContext *type();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ObjectBuilderContext* objectBuilder();

  class  ItemsContext : public antlr4::ParserRuleContext {
  public:
    ItemsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ExprContext *> expr();
    ExprContext* expr(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ItemsContext* items();

  class  EntriesContext : public antlr4::ParserRuleContext {
  public:
    EntriesContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<EntryContext *> entry();
    EntryContext* entry(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  EntriesContext* entries();

  class  EntryContext : public antlr4::ParserRuleContext {
  public:
    EntryContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    PrimaryContext *primary();
    ExprContext *expr();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  EntryContext* entry();

  class  TypeContext : public antlr4::ParserRuleContext {
  public:
    TypeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    TypeContext() = default;
    void copyFrom(TypeContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  LiteralTypeContext : public TypeContext {
  public:
    LiteralTypeContext(TypeContext *ctx);

    antlr4::tree::TerminalNode *TYPE();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  TypeofTypeContext : public TypeContext {
  public:
    TypeofTypeContext(TypeContext *ctx);

    antlr4::tree::TerminalNode *TYPEOF();
    ExprContext *expr();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  NullableTypeContext : public TypeContext {
  public:
    NullableTypeContext(TypeContext *ctx);

    TypeContext *type();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  IntersectionTypeContext : public TypeContext {
  public:
    IntersectionTypeContext(TypeContext *ctx);

    std::vector<TypeContext *> type();
    TypeContext* type(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ReferenceTypeContext : public TypeContext {
  public:
    ReferenceTypeContext(TypeContext *ctx);

    ReferenceContext *reference();
    TypeArgsContext *typeArgs();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  FunctionTypeContext : public TypeContext {
  public:
    FunctionTypeContext(TypeContext *ctx);

    ParamTypesContext *paramTypes();
    TypeContext *type();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  ObjectTypeContext : public TypeContext {
  public:
    ObjectTypeContext(TypeContext *ctx);

    antlr4::tree::TerminalNode *OBJECT();
    MemberTypeListContext *memberTypeList();

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  UnionTypeContext : public TypeContext {
  public:
    UnionTypeContext(TypeContext *ctx);

    std::vector<TypeContext *> type();
    TypeContext* type(size_t i);

    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  TypeContext* type();
  TypeContext* type(int precedence);
  class  TypeArgsContext : public antlr4::ParserRuleContext {
  public:
    TypeArgsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<TypeArgContext *> typeArg();
    TypeArgContext* typeArg(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TypeArgsContext* typeArgs();

  class  TypeArgContext : public antlr4::ParserRuleContext {
  public:
    TypeArgContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    TypeContext *type();
    antlr4::tree::TerminalNode *OUT();
    antlr4::tree::TerminalNode *IN();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TypeArgContext* typeArg();

  class  ParamTypesContext : public antlr4::ParserRuleContext {
  public:
    ParamTypesContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<ParamTypeContext *> paramType();
    ParamTypeContext* paramType(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamTypesContext* paramTypes();

  class  ParamTypeContext : public antlr4::ParserRuleContext {
  public:
    ParamTypeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    TypeContext *type();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ParamTypeContext* paramType();

  class  TypeListContext : public antlr4::ParserRuleContext {
  public:
    TypeListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<TypeContext *> type();
    TypeContext* type(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  TypeListContext* typeList();

  class  MemberTypeListContext : public antlr4::ParserRuleContext {
  public:
    MemberTypeListContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<MemberTypeContext *> memberType();
    MemberTypeContext* memberType(size_t i);


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MemberTypeListContext* memberTypeList();

  class  MemberTypeContext : public antlr4::ParserRuleContext {
  public:
    MemberTypeContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *IDENTIFIER();
    TypeContext *type();


    virtual std::any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  MemberTypeContext* memberType();


  bool sempred(antlr4::RuleContext *_localctx, size_t ruleIndex, size_t predicateIndex) override;

  bool exprSempred(ExprContext *_localctx, size_t predicateIndex);
  bool postfixSempred(PostfixContext *_localctx, size_t predicateIndex);
  bool typeSempred(TypeContext *_localctx, size_t predicateIndex);

  // By default the static state used to implement the parser is lazily initialized during the first
  // call to the constructor. You can call this function if you wish to initialize the static state
  // ahead of time.
  static void initialize();

private:
};

