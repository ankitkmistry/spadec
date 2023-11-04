// Generated from d:/Programming (Ankit)/Projects/spadec/grammar/Spade.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpadeParser}.
 */
public interface SpadeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SpadeParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(SpadeParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(SpadeParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SpadeParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SpadeParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#packageStmt}.
	 * @param ctx the parse tree
	 */
	void enterPackageStmt(SpadeParser.PackageStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#packageStmt}.
	 * @param ctx the parse tree
	 */
	void exitPackageStmt(SpadeParser.PackageStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(SpadeParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(SpadeParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(SpadeParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(SpadeParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SpadeParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SpadeParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(SpadeParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(SpadeParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(SpadeParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(SpadeParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(SpadeParser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(SpadeParser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#annoDecl}.
	 * @param ctx the parse tree
	 */
	void enterAnnoDecl(SpadeParser.AnnoDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#annoDecl}.
	 * @param ctx the parse tree
	 */
	void exitAnnoDecl(SpadeParser.AnnoDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDecl(SpadeParser.InterfaceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDecl(SpadeParser.InterfaceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(SpadeParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(SpadeParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#parentList}.
	 * @param ctx the parse tree
	 */
	void enterParentList(SpadeParser.ParentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#parentList}.
	 * @param ctx the parse tree
	 */
	void exitParentList(SpadeParser.ParentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(SpadeParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(SpadeParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#declName}.
	 * @param ctx the parse tree
	 */
	void enterDeclName(SpadeParser.DeclNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#declName}.
	 * @param ctx the parse tree
	 */
	void exitDeclName(SpadeParser.DeclNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void enterTypeParams(SpadeParser.TypeParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void exitTypeParams(SpadeParser.TypeParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#typeParam}.
	 * @param ctx the parse tree
	 */
	void enterTypeParam(SpadeParser.TypeParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#typeParam}.
	 * @param ctx the parse tree
	 */
	void exitTypeParam(SpadeParser.TypeParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#memberDecl}.
	 * @param ctx the parse tree
	 */
	void enterMemberDecl(SpadeParser.MemberDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#memberDecl}.
	 * @param ctx the parse tree
	 */
	void exitMemberDecl(SpadeParser.MemberDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(SpadeParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(SpadeParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(SpadeParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(SpadeParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#operators}.
	 * @param ctx the parse tree
	 */
	void enterOperators(SpadeParser.OperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#operators}.
	 * @param ctx the parse tree
	 */
	void exitOperators(SpadeParser.OperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDecl(SpadeParser.ConstructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDecl(SpadeParser.ConstructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void enterModifiers(SpadeParser.ModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void exitModifiers(SpadeParser.ModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#accessors}.
	 * @param ctx the parse tree
	 */
	void enterAccessors(SpadeParser.AccessorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#accessors}.
	 * @param ctx the parse tree
	 */
	void exitAccessors(SpadeParser.AccessorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SpadeParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SpadeParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(SpadeParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(SpadeParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(SpadeParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(SpadeParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(SpadeParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(SpadeParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SpadeParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SpadeParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(SpadeParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(SpadeParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SpadeParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SpadeParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(SpadeParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(SpadeParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(SpadeParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(SpadeParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SpadeParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SpadeParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDoStmt(SpadeParser.DoStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDoStmt(SpadeParser.DoStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(SpadeParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(SpadeParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code foreachStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForeachStmt(SpadeParser.ForeachStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code foreachStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForeachStmt(SpadeParser.ForeachStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterMatchStmt(SpadeParser.MatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitMatchStmt(SpadeParser.MatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code throwStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterThrowStmt(SpadeParser.ThrowStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code throwStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitThrowStmt(SpadeParser.ThrowStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterTryStmt(SpadeParser.TryStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitTryStmt(SpadeParser.TryStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(SpadeParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(SpadeParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(SpadeParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(SpadeParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SpadeParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SpadeParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yieldStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterYieldStmt(SpadeParser.YieldStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yieldStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitYieldStmt(SpadeParser.YieldStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterNoStmt(SpadeParser.NoStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitNoStmt(SpadeParser.NoStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(SpadeParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link SpadeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(SpadeParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#destructDecl}.
	 * @param ctx the parse tree
	 */
	void enterDestructDecl(SpadeParser.DestructDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#destructDecl}.
	 * @param ctx the parse tree
	 */
	void exitDestructDecl(SpadeParser.DestructDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#destruct}.
	 * @param ctx the parse tree
	 */
	void enterDestruct(SpadeParser.DestructContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#destruct}.
	 * @param ctx the parse tree
	 */
	void exitDestruct(SpadeParser.DestructContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SpadeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SpadeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#matchCase}.
	 * @param ctx the parse tree
	 */
	void enterMatchCase(SpadeParser.MatchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#matchCase}.
	 * @param ctx the parse tree
	 */
	void exitMatchCase(SpadeParser.MatchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#catchStmt}.
	 * @param ctx the parse tree
	 */
	void enterCatchStmt(SpadeParser.CatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#catchStmt}.
	 * @param ctx the parse tree
	 */
	void exitCatchStmt(SpadeParser.CatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#finallyStmt}.
	 * @param ctx the parse tree
	 */
	void enterFinallyStmt(SpadeParser.FinallyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#finallyStmt}.
	 * @param ctx the parse tree
	 */
	void exitFinallyStmt(SpadeParser.FinallyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(SpadeParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(SpadeParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(SpadeParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(SpadeParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpr(SpadeParser.PowerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpr(SpadeParser.PowerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(SpadeParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(SpadeParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(SpadeParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(SpadeParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(SpadeParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(SpadeParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(SpadeParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(SpadeParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpr(SpadeParser.FactorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpr(SpadeParser.FactorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elvisExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterElvisExpr(SpadeParser.ElvisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elvisExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitElvisExpr(SpadeParser.ElvisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitXorExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitXorExpr(SpadeParser.BitXorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitXorExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitXorExpr(SpadeParser.BitXorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpr(SpadeParser.ShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpr(SpadeParser.ShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpr(SpadeParser.BitOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOrExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpr(SpadeParser.BitOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(SpadeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(SpadeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(SpadeParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(SpadeParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(SpadeParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(SpadeParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(SpadeParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(SpadeParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpr(SpadeParser.BitAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAndExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpr(SpadeParser.BitAndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(SpadeParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(SpadeParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(SpadeParser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(SpadeParser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(SpadeParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link SpadeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(SpadeParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#assigneeList}.
	 * @param ctx the parse tree
	 */
	void enterAssigneeList(SpadeParser.AssigneeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#assigneeList}.
	 * @param ctx the parse tree
	 */
	void exitAssigneeList(SpadeParser.AssigneeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#assignee}.
	 * @param ctx the parse tree
	 */
	void enterAssignee(SpadeParser.AssigneeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#assignee}.
	 * @param ctx the parse tree
	 */
	void exitAssignee(SpadeParser.AssigneeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#assignOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignOperator(SpadeParser.AssignOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#assignOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignOperator(SpadeParser.AssignOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixPrimary}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixPrimary(SpadeParser.PostfixPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixPrimary}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixPrimary(SpadeParser.PostfixPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixDot}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixDot(SpadeParser.PostfixDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixDot}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixDot(SpadeParser.PostfixDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixBlock}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixBlock(SpadeParser.PostfixBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixBlock}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixBlock(SpadeParser.PostfixBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixGeneric}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixGeneric(SpadeParser.PostfixGenericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixGeneric}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixGeneric(SpadeParser.PostfixGenericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixCall}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCall(SpadeParser.PostfixCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixCall}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCall(SpadeParser.PostfixCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixIndexer}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfixIndexer(SpadeParser.PostfixIndexerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixIndexer}
	 * labeled alternative in {@link SpadeParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfixIndexer(SpadeParser.PostfixIndexerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(SpadeParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(SpadeParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(SpadeParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(SpadeParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#indexer}.
	 * @param ctx the parse tree
	 */
	void enterIndexer(SpadeParser.IndexerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#indexer}.
	 * @param ctx the parse tree
	 */
	void exitIndexer(SpadeParser.IndexerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterSlice(SpadeParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitSlice(SpadeParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpr(SpadeParser.ConstantExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpr(SpadeParser.ConstantExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code builderExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterBuilderExpr(SpadeParser.BuilderExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code builderExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitBuilderExpr(SpadeParser.BuilderExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code superExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpr(SpadeParser.SuperExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code superExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpr(SpadeParser.SuperExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(SpadeParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(SpadeParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterGroupExpr(SpadeParser.GroupExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitGroupExpr(SpadeParser.GroupExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTupleExpr(SpadeParser.TupleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTupleExpr(SpadeParser.TupleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterSetExpr(SpadeParser.SetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitSetExpr(SpadeParser.SetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterMapExpr(SpadeParser.MapExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitMapExpr(SpadeParser.MapExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(SpadeParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(SpadeParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpr(SpadeParser.TypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeExpr}
	 * labeled alternative in {@link SpadeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpr(SpadeParser.TypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SpadeParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SpadeParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SpadeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SpadeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#objectBuilder}.
	 * @param ctx the parse tree
	 */
	void enterObjectBuilder(SpadeParser.ObjectBuilderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#objectBuilder}.
	 * @param ctx the parse tree
	 */
	void exitObjectBuilder(SpadeParser.ObjectBuilderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#items}.
	 * @param ctx the parse tree
	 */
	void enterItems(SpadeParser.ItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#items}.
	 * @param ctx the parse tree
	 */
	void exitItems(SpadeParser.ItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#entries}.
	 * @param ctx the parse tree
	 */
	void enterEntries(SpadeParser.EntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#entries}.
	 * @param ctx the parse tree
	 */
	void exitEntries(SpadeParser.EntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(SpadeParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(SpadeParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterLiteralType(SpadeParser.LiteralTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitLiteralType(SpadeParser.LiteralTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeofType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeofType(SpadeParser.TypeofTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeofType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeofType(SpadeParser.TypeofTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullableType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNullableType(SpadeParser.NullableTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullableType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNullableType(SpadeParser.NullableTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intersectionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntersectionType(SpadeParser.IntersectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intersectionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntersectionType(SpadeParser.IntersectionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code referenceType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(SpadeParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(SpadeParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(SpadeParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(SpadeParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(SpadeParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(SpadeParser.ObjectTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterUnionType(SpadeParser.UnionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionType}
	 * labeled alternative in {@link SpadeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitUnionType(SpadeParser.UnionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#typeArgs}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgs(SpadeParser.TypeArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#typeArgs}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgs(SpadeParser.TypeArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#typeArg}.
	 * @param ctx the parse tree
	 */
	void enterTypeArg(SpadeParser.TypeArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#typeArg}.
	 * @param ctx the parse tree
	 */
	void exitTypeArg(SpadeParser.TypeArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#paramTypes}.
	 * @param ctx the parse tree
	 */
	void enterParamTypes(SpadeParser.ParamTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#paramTypes}.
	 * @param ctx the parse tree
	 */
	void exitParamTypes(SpadeParser.ParamTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(SpadeParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(SpadeParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(SpadeParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(SpadeParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#memberTypeList}.
	 * @param ctx the parse tree
	 */
	void enterMemberTypeList(SpadeParser.MemberTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#memberTypeList}.
	 * @param ctx the parse tree
	 */
	void exitMemberTypeList(SpadeParser.MemberTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpadeParser#memberType}.
	 * @param ctx the parse tree
	 */
	void enterMemberType(SpadeParser.MemberTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpadeParser#memberType}.
	 * @param ctx the parse tree
	 */
	void exitMemberType(SpadeParser.MemberTypeContext ctx);
}