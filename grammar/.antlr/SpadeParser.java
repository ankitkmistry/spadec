// Generated from d:/Programming (Ankit)/Projects/spadec/grammar/Spade.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SpadeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, PACKAGE=38, 
		IMPORT=39, EXPORT=40, EXTENDS=41, IMPLEMENTS=42, ENUM=43, CLASS=44, INTERFACE=45, 
		ANNOTATION=46, INIT=47, FUN=48, CONST=49, VAR=50, ABSTRACT=51, FINAL=52, 
		STATIC=53, INLINE=54, PRIVATE=55, PROTECTED=56, INTERNAL=57, PUBLIC=58, 
		IF=59, ELSE=60, WHILE=61, DO=62, FOR=63, IN=64, MATCH=65, WHEN=66, THROW=67, 
		TRY=68, CATCH=69, FINALLY=70, CONTINUE=71, BREAK=72, RETURN=73, YIELD=74, 
		GT=75, GE=76, NE=77, EQ=78, LE=79, LT=80, MODULUS=81, SLASH=82, STAR=83, 
		PLUS=84, DASH=85, TILDE=86, BANG=87, AS=88, IS=89, NOT=90, AND=91, OR=92, 
		SUPER=93, THIS=94, TRUE=95, FALSE=96, NULL=97, OBJECT=98, TYPE=99, TYPEOF=100, 
		OUT=101, REF=102, IDENTIFIER=103, INTEGER=104, FLOAT=105, STRING=106, 
		WS=107, NEWLINE=108, BLOCK_COMMENT=109, LINE_COMMENT=110;
	public static final int
		RULE_sep = 0, RULE_compilationUnit = 1, RULE_packageStmt = 2, RULE_importStmt = 3, 
		RULE_reference = 4, RULE_declaration = 5, RULE_enumDecl = 6, RULE_enumList = 7, 
		RULE_enumerator = 8, RULE_annoDecl = 9, RULE_interfaceDecl = 10, RULE_classDecl = 11, 
		RULE_parentList = 12, RULE_parent = 13, RULE_declName = 14, RULE_typeParams = 15, 
		RULE_typeParam = 16, RULE_memberDecl = 17, RULE_fieldDecl = 18, RULE_methodDecl = 19, 
		RULE_operators = 20, RULE_constructorDecl = 21, RULE_modifiers = 22, RULE_accessors = 23, 
		RULE_functionDecl = 24, RULE_definition = 25, RULE_params = 26, RULE_paramList = 27, 
		RULE_param = 28, RULE_varDecl = 29, RULE_name = 30, RULE_stmts = 31, RULE_stmt = 32, 
		RULE_destructDecl = 33, RULE_destruct = 34, RULE_block = 35, RULE_matchCase = 36, 
		RULE_catchStmt = 37, RULE_finallyStmt = 38, RULE_body = 39, RULE_else = 40, 
		RULE_expr = 41, RULE_assigneeList = 42, RULE_assignee = 43, RULE_assignOperator = 44, 
		RULE_postfix = 45, RULE_args = 46, RULE_arg = 47, RULE_indexer = 48, RULE_slice = 49, 
		RULE_primary = 50, RULE_constant = 51, RULE_literal = 52, RULE_objectBuilder = 53, 
		RULE_items = 54, RULE_entries = 55, RULE_entry = 56, RULE_type = 57, RULE_typeArgs = 58, 
		RULE_typeArg = 59, RULE_paramTypes = 60, RULE_paramType = 61, RULE_typeList = 62, 
		RULE_memberTypeList = 63, RULE_memberType = 64;
	private static String[] makeRuleNames() {
		return new String[] {
			"sep", "compilationUnit", "packageStmt", "importStmt", "reference", "declaration", 
			"enumDecl", "enumList", "enumerator", "annoDecl", "interfaceDecl", "classDecl", 
			"parentList", "parent", "declName", "typeParams", "typeParam", "memberDecl", 
			"fieldDecl", "methodDecl", "operators", "constructorDecl", "modifiers", 
			"accessors", "functionDecl", "definition", "params", "paramList", "param", 
			"varDecl", "name", "stmts", "stmt", "destructDecl", "destruct", "block", 
			"matchCase", "catchStmt", "finallyStmt", "body", "else", "expr", "assigneeList", 
			"assignee", "assignOperator", "postfix", "args", "arg", "indexer", "slice", 
			"primary", "constant", "literal", "objectBuilder", "items", "entries", 
			"entry", "type", "typeArgs", "typeArg", "paramTypes", "paramType", "typeList", 
			"memberTypeList", "memberType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'{'", "'}'", "','", "'='", "'('", "')'", "':'", 
			"'operator'", "'->'", "'??'", "'**'", "'<<'", "'>>>'", "'>>'", "'&'", 
			"'^'", "'|'", "'_'", "'...'", "'['", "']'", "'?'", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'**='", "'<<='", "'>>='", "'>>>='", "'&='", "'|='", 
			"'^='", "'??='", "'package'", "'import'", "'export'", "'extends'", "'implements'", 
			"'enum'", "'class'", "'interface'", "'annotation'", "'init'", "'fun'", 
			"'const'", "'var'", "'abstract'", "'final'", "'static'", "'inline'", 
			"'private'", "'protected'", "'internal'", "'public'", "'if'", "'else'", 
			"'while'", "'do'", "'for'", "'in'", "'match'", "'when'", "'throw'", "'try'", 
			"'catch'", "'finally'", "'continue'", "'break'", "'return'", "'yield'", 
			"'>'", "'>='", "'!='", "'=='", "'<='", "'<'", "'%'", "'/'", "'*'", "'+'", 
			"'-'", "'~'", "'!'", "'as'", "'is'", "'not'", "'and'", "'or'", "'super'", 
			"'this'", "'true'", "'false'", "'null'", "'object'", "'varKind'", "'typeof'", 
			"'out'", "'ref'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "PACKAGE", "IMPORT", "EXPORT", "EXTENDS", "IMPLEMENTS", "ENUM", 
			"CLASS", "INTERFACE", "ANNOTATION", "INIT", "FUN", "CONST", "VAR", "ABSTRACT", 
			"FINAL", "STATIC", "INLINE", "PRIVATE", "PROTECTED", "INTERNAL", "PUBLIC", 
			"IF", "ELSE", "WHILE", "DO", "FOR", "IN", "MATCH", "WHEN", "THROW", "TRY", 
			"CATCH", "FINALLY", "CONTINUE", "BREAK", "RETURN", "YIELD", "GT", "GE", 
			"NE", "EQ", "LE", "LT", "MODULUS", "SLASH", "STAR", "PLUS", "DASH", "TILDE", 
			"BANG", "AS", "IS", "NOT", "AND", "OR", "SUPER", "THIS", "TRUE", "FALSE", 
			"NULL", "OBJECT", "TYPE", "TYPEOF", "OUT", "REF", "IDENTIFIER", "INTEGER", 
			"FLOAT", "STRING", "WS", "NEWLINE", "BLOCK_COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Spade.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpadeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SepContext extends ParserRuleContext {
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sep);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					match(T__0);
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SpadeParser.EOF, 0); }
		public PackageStmtContext packageStmt() {
			return getRuleContext(PackageStmtContext.class,0);
		}
		public List<ImportStmtContext> importStmt() {
			return getRuleContexts(ImportStmtContext.class);
		}
		public ImportStmtContext importStmt(int i) {
			return getRuleContext(ImportStmtContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(136);
				packageStmt();
				}
			}

			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(139);
				importStmt();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576311218722045952L) != 0)) {
				{
				{
				setState(145);
				declaration();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageStmtContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(SpadeParser.PACKAGE, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public PackageStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStmt; }
	}

	public final PackageStmtContext packageStmt() throws RecognitionException {
		PackageStmtContext _localctx = new PackageStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_packageStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(PACKAGE);
			setState(154);
			reference();
			setState(155);
			sep();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStmtContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(SpadeParser.IMPORT, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public TerminalNode AS() { return getToken(SpadeParser.AS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public ImportStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStmt; }
	}

	public final ImportStmtContext importStmt() throws RecognitionException {
		ImportStmtContext _localctx = new ImportStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(IMPORT);
			setState(158);
			reference();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(159);
				match(AS);
				setState(160);
				match(IDENTIFIER);
				}
			}

			setState(163);
			sep();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SpadeParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SpadeParser.IDENTIFIER, i);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_reference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IDENTIFIER);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					match(T__1);
					setState(167);
					match(IDENTIFIER);
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public InterfaceDeclContext interfaceDecl() {
			return getRuleContext(InterfaceDeclContext.class,0);
		}
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public AnnoDeclContext annoDecl() {
			return getRuleContext(AnnoDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			modifiers();
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case VAR:
				{
				setState(174);
				varDecl();
				setState(175);
				sep();
				}
				break;
			case FUN:
				{
				setState(177);
				functionDecl();
				}
				break;
			case CLASS:
				{
				setState(178);
				classDecl();
				}
				break;
			case INTERFACE:
				{
				setState(179);
				interfaceDecl();
				}
				break;
			case ENUM:
				{
				setState(180);
				enumDecl();
				}
				break;
			case ANNOTATION:
				{
				setState(181);
				annoDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(SpadeParser.ENUM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(SpadeParser.IMPLEMENTS, 0); }
		public ParentListContext parentList() {
			return getRuleContext(ParentListContext.class,0);
		}
		public EnumListContext enumList() {
			return getRuleContext(EnumListContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public List<MemberDeclContext> memberDecl() {
			return getRuleContexts(MemberDeclContext.class);
		}
		public MemberDeclContext memberDecl(int i) {
			return getRuleContext(MemberDeclContext.class,i);
		}
		public EnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDecl; }
	}

	public final EnumDeclContext enumDecl() throws RecognitionException {
		EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(ENUM);
			setState(185);
			match(IDENTIFIER);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(186);
				match(IMPLEMENTS);
				setState(187);
				parentList();
				}
			}

			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(190);
				match(T__2);
				setState(191);
				enumList();
				setState(192);
				sep();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574974212586865664L) != 0) || _la==AS || _la==IDENTIFIER) {
					{
					{
					setState(193);
					memberDecl();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199);
				match(T__3);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumListContext extends ParserRuleContext {
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public EnumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumList; }
	}

	public final EnumListContext enumList() throws RecognitionException {
		EnumListContext _localctx = new EnumListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_enumList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			enumerator();
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					match(T__4);
					setState(205);
					enumerator();
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(211);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumeratorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(IDENTIFIER);
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(215);
				match(T__5);
				setState(216);
				expr(0);
				}
				break;
			case T__6:
				{
				setState(217);
				match(T__6);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
					{
					setState(218);
					args();
					}
				}

				setState(221);
				match(T__7);
				}
				break;
			case T__0:
			case T__3:
			case T__4:
			case T__9:
			case T__21:
			case ENUM:
			case CLASS:
			case INTERFACE:
			case INIT:
			case CONST:
			case ABSTRACT:
			case FINAL:
			case STATIC:
			case INLINE:
			case PRIVATE:
			case PROTECTED:
			case INTERNAL:
			case PUBLIC:
			case AS:
			case IDENTIFIER:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnoDeclContext extends ParserRuleContext {
		public TerminalNode ANNOTATION() { return getToken(SpadeParser.ANNOTATION, 0); }
		public DeclNameContext declName() {
			return getRuleContext(DeclNameContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(SpadeParser.EXTENDS, 0); }
		public ParentContext parent() {
			return getRuleContext(ParentContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(SpadeParser.IMPLEMENTS, 0); }
		public ParentListContext parentList() {
			return getRuleContext(ParentListContext.class,0);
		}
		public List<MemberDeclContext> memberDecl() {
			return getRuleContexts(MemberDeclContext.class);
		}
		public MemberDeclContext memberDecl(int i) {
			return getRuleContext(MemberDeclContext.class,i);
		}
		public AnnoDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annoDecl; }
	}

	public final AnnoDeclContext annoDecl() throws RecognitionException {
		AnnoDeclContext _localctx = new AnnoDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_annoDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(ANNOTATION);
			setState(225);
			declName();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(226);
				match(EXTENDS);
				setState(227);
				parent();
				}
			}

			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(230);
				match(IMPLEMENTS);
				setState(231);
				parentList();
				}
			}

			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(234);
				match(T__2);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574974212586865664L) != 0) || _la==AS || _la==IDENTIFIER) {
					{
					{
					setState(235);
					memberDecl();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(T__3);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(SpadeParser.INTERFACE, 0); }
		public DeclNameContext declName() {
			return getRuleContext(DeclNameContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(SpadeParser.EXTENDS, 0); }
		public ParentListContext parentList() {
			return getRuleContext(ParentListContext.class,0);
		}
		public List<MemberDeclContext> memberDecl() {
			return getRuleContexts(MemberDeclContext.class);
		}
		public MemberDeclContext memberDecl(int i) {
			return getRuleContext(MemberDeclContext.class,i);
		}
		public InterfaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDecl; }
	}

	public final InterfaceDeclContext interfaceDecl() throws RecognitionException {
		InterfaceDeclContext _localctx = new InterfaceDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_interfaceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(INTERFACE);
			setState(245);
			declName();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(246);
				match(EXTENDS);
				setState(247);
				parentList();
				}
			}

			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(250);
				match(T__2);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574974212586865664L) != 0) || _la==AS || _la==IDENTIFIER) {
					{
					{
					setState(251);
					memberDecl();
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(257);
				match(T__3);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(SpadeParser.CLASS, 0); }
		public DeclNameContext declName() {
			return getRuleContext(DeclNameContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(SpadeParser.EXTENDS, 0); }
		public ParentContext parent() {
			return getRuleContext(ParentContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(SpadeParser.IMPLEMENTS, 0); }
		public ParentListContext parentList() {
			return getRuleContext(ParentListContext.class,0);
		}
		public List<MemberDeclContext> memberDecl() {
			return getRuleContexts(MemberDeclContext.class);
		}
		public MemberDeclContext memberDecl(int i) {
			return getRuleContext(MemberDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(CLASS);
			setState(261);
			declName();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(262);
				match(EXTENDS);
				setState(263);
				parent();
				}
			}

			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(266);
				match(IMPLEMENTS);
				setState(267);
				parentList();
				}
			}

			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(270);
				match(T__2);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574974212586865664L) != 0) || _la==AS || _la==IDENTIFIER) {
					{
					{
					setState(271);
					memberDecl();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(277);
				match(T__3);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParentListContext extends ParserRuleContext {
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
		public ParentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentList; }
	}

	public final ParentListContext parentList() throws RecognitionException {
		ParentListContext _localctx = new ParentListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parentList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			parent();
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					match(T__4);
					setState(282);
					parent();
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(288);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParentContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public ParentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent; }
	}

	public final ParentContext parent() throws RecognitionException {
		ParentContext _localctx = new ParentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			reference();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(292);
				match(LT);
				setState(293);
				typeArgs();
				setState(294);
				match(GT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public DeclNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declName; }
	}

	public final DeclNameContext declName() throws RecognitionException {
		DeclNameContext _localctx = new DeclNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(IDENTIFIER);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(299);
				match(LT);
				setState(300);
				typeParams();
				setState(301);
				match(GT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParamsContext extends ParserRuleContext {
		public List<TypeParamContext> typeParam() {
			return getRuleContexts(TypeParamContext.class);
		}
		public TypeParamContext typeParam(int i) {
			return getRuleContext(TypeParamContext.class,i);
		}
		public TypeParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParams; }
	}

	public final TypeParamsContext typeParams() throws RecognitionException {
		TypeParamsContext _localctx = new TypeParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeParams);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			typeParam();
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(306);
					match(T__4);
					setState(307);
					typeParam();
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(313);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParamContext extends ParserRuleContext {
		public TypeContext variantOf;
		public TypeContext defaultValue;
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode OUT() { return getToken(SpadeParser.OUT, 0); }
		public TerminalNode IN() { return getToken(SpadeParser.IN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParam; }
	}

	public final TypeParamContext typeParam() throws RecognitionException {
		TypeParamContext _localctx = new TypeParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN || _la==OUT) {
				{
				setState(316);
				_la = _input.LA(1);
				if ( !(_la==IN || _la==OUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(319);
			match(IDENTIFIER);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(320);
				match(T__8);
				setState(321);
				((TypeParamContext)_localctx).variantOf = type(0);
				}
			}

			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(324);
				match(T__5);
				setState(325);
				((TypeParamContext)_localctx).defaultValue = type(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberDeclContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public FieldDeclContext fieldDecl() {
			return getRuleContext(FieldDeclContext.class,0);
		}
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public ConstructorDeclContext constructorDecl() {
			return getRuleContext(ConstructorDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public InterfaceDeclContext interfaceDecl() {
			return getRuleContext(InterfaceDeclContext.class,0);
		}
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public MemberDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDecl; }
	}

	public final MemberDeclContext memberDecl() throws RecognitionException {
		MemberDeclContext _localctx = new MemberDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_memberDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			modifiers();
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(329);
				fieldDecl();
				}
				break;
			case 2:
				{
				setState(330);
				methodDecl();
				}
				break;
			case 3:
				{
				setState(331);
				constructorDecl();
				}
				break;
			case 4:
				{
				setState(332);
				classDecl();
				}
				break;
			case 5:
				{
				setState(333);
				interfaceDecl();
				}
				break;
			case 6:
				{
				setState(334);
				enumDecl();
				}
				break;
			}
			setState(337);
			sep();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode CONST() { return getToken(SpadeParser.CONST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(339);
				match(CONST);
				}
			}

			setState(342);
			name();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(343);
				match(T__5);
				setState(344);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public OperatorsContext op;
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(SpadeParser.AS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public OperatorsContext operators() {
			return getRuleContext(OperatorsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(347);
				match(IDENTIFIER);
				}
				break;
			case T__9:
				{
				setState(348);
				match(T__9);
				setState(349);
				((MethodDeclContext)_localctx).op = operators();
				}
				break;
			case AS:
				{
				setState(350);
				match(AS);
				setState(351);
				type(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(354);
			match(T__6);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==CONST || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 1572865L) != 0)) {
				{
				setState(355);
				params();
				}
			}

			setState(358);
			match(T__7);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(359);
				match(T__10);
				setState(360);
				type(0);
				}
			}

			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(363);
				definition();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode BANG() { return getToken(SpadeParser.BANG, 0); }
		public TerminalNode DASH() { return getToken(SpadeParser.DASH, 0); }
		public TerminalNode TILDE() { return getToken(SpadeParser.TILDE, 0); }
		public TerminalNode PLUS() { return getToken(SpadeParser.PLUS, 0); }
		public TerminalNode STAR() { return getToken(SpadeParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SpadeParser.SLASH, 0); }
		public TerminalNode MODULUS() { return getToken(SpadeParser.MODULUS, 0); }
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TerminalNode LE() { return getToken(SpadeParser.LE, 0); }
		public TerminalNode EQ() { return getToken(SpadeParser.EQ, 0); }
		public TerminalNode NE() { return getToken(SpadeParser.NE, 0); }
		public TerminalNode GE() { return getToken(SpadeParser.GE, 0); }
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public TerminalNode IS() { return getToken(SpadeParser.IS, 0); }
		public TerminalNode NOT() { return getToken(SpadeParser.NOT, 0); }
		public TerminalNode IN() { return getToken(SpadeParser.IN, 0); }
		public TerminalNode AND() { return getToken(SpadeParser.AND, 0); }
		public TerminalNode OR() { return getToken(SpadeParser.OR, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operators);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				match(BANG);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				match(DASH);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
				match(TILDE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(369);
				match(PLUS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(370);
				match(T__11);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(371);
				match(T__12);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(372);
				match(STAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(373);
				match(SLASH);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(374);
				match(MODULUS);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(375);
				match(T__13);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(376);
				match(T__14);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(377);
				match(T__15);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(378);
				match(LT);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(379);
				match(LE);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(380);
				match(EQ);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(381);
				match(NE);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(382);
				match(GE);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(383);
				match(GT);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(384);
				match(T__16);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(385);
				match(T__17);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(386);
				match(T__18);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(387);
				match(IS);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(388);
					match(NOT);
					}
				}

				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(391);
					match(NOT);
					}
				}

				setState(394);
				match(IN);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(395);
				match(NOT);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(396);
				match(AND);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(397);
				match(OR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(SpadeParser.INIT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public ConstructorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDecl; }
	}

	public final ConstructorDeclContext constructorDecl() throws RecognitionException {
		ConstructorDeclContext _localctx = new ConstructorDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constructorDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(INIT);
			setState(401);
			match(T__6);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==CONST || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 1572865L) != 0)) {
				{
				setState(402);
				params();
				}
			}

			setState(405);
			match(T__7);
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2 || _la==T__5) {
				{
				setState(406);
				definition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifiersContext extends ParserRuleContext {
		public List<TerminalNode> ABSTRACT() { return getTokens(SpadeParser.ABSTRACT); }
		public TerminalNode ABSTRACT(int i) {
			return getToken(SpadeParser.ABSTRACT, i);
		}
		public List<TerminalNode> FINAL() { return getTokens(SpadeParser.FINAL); }
		public TerminalNode FINAL(int i) {
			return getToken(SpadeParser.FINAL, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(SpadeParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(SpadeParser.STATIC, i);
		}
		public List<TerminalNode> INLINE() { return getTokens(SpadeParser.INLINE); }
		public TerminalNode INLINE(int i) {
			return getToken(SpadeParser.INLINE, i);
		}
		public List<AccessorsContext> accessors() {
			return getRuleContexts(AccessorsContext.class);
		}
		public AccessorsContext accessors(int i) {
			return getRuleContext(AccessorsContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574208952489738240L) != 0)) {
				{
				setState(414);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ABSTRACT:
					{
					setState(409);
					match(ABSTRACT);
					}
					break;
				case FINAL:
					{
					setState(410);
					match(FINAL);
					}
					break;
				case STATIC:
					{
					setState(411);
					match(STATIC);
					}
					break;
				case INLINE:
					{
					setState(412);
					match(INLINE);
					}
					break;
				case PRIVATE:
				case PROTECTED:
				case INTERNAL:
				case PUBLIC:
					{
					setState(413);
					accessors();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessorsContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(SpadeParser.PRIVATE, 0); }
		public TerminalNode INTERNAL() { return getToken(SpadeParser.INTERNAL, 0); }
		public TerminalNode PROTECTED() { return getToken(SpadeParser.PROTECTED, 0); }
		public TerminalNode PUBLIC() { return getToken(SpadeParser.PUBLIC, 0); }
		public AccessorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessors; }
	}

	public final AccessorsContext accessors() throws RecognitionException {
		AccessorsContext _localctx = new AccessorsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_accessors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 540431955284459520L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(SpadeParser.FUN, 0); }
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(FUN);
			setState(422);
			methodDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_definition);
		try {
			setState(429);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(T__5);
				setState(425);
				stmt();
				setState(426);
				sep();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamListContext> paramList() {
			return getRuleContexts(ParamListContext.class);
		}
		public ParamListContext paramList(int i) {
			return getRuleContext(ParamListContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			paramList();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(432);
				match(T__18);
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19 || _la==CONST || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 1572865L) != 0)) {
					{
					setState(433);
					paramList();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_paramList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			param();
			setState(443);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(439);
					match(T__4);
					setState(440);
					param();
					}
					} 
				}
				setState(445);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(446);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode STAR() { return getToken(SpadeParser.STAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CONST() { return getToken(SpadeParser.CONST, 0); }
		public TerminalNode REF() { return getToken(SpadeParser.REF, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==REF) {
				{
				setState(449);
				_la = _input.LA(1);
				if ( !(_la==CONST || _la==REF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(452);
				match(STAR);
				}
			}

			setState(455);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(456);
				match(T__8);
				setState(457);
				type(0);
				}
			}

			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(460);
				match(T__5);
				setState(461);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode VAR() { return getToken(SpadeParser.VAR, 0); }
		public TerminalNode CONST() { return getToken(SpadeParser.CONST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( !(_la==CONST || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(465);
			name();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(466);
				match(T__5);
				setState(467);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DestructDeclContext destructDecl() {
			return getRuleContext(DestructDeclContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_name);
		int _la;
		try {
			setState(476);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(IDENTIFIER);
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(471);
					match(T__8);
					setState(472);
					type(0);
					}
				}

				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(475);
				destructDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtsContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_stmts);
		try {
			setState(482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(478);
				stmt();
				setState(479);
				sep();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public TerminalNode FOR() { return getToken(SpadeParser.FOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StmtContext {
		public TerminalNode WHILE() { return getToken(SpadeParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForeachStmtContext extends StmtContext {
		public TerminalNode FOR() { return getToken(SpadeParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(SpadeParser.IN, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public ForeachStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryStmtContext extends StmtContext {
		public TerminalNode TRY() { return getToken(SpadeParser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyStmtContext finallyStmt() {
			return getRuleContext(FinallyStmtContext.class,0);
		}
		public List<CatchStmtContext> catchStmt() {
			return getRuleContexts(CatchStmtContext.class);
		}
		public CatchStmtContext catchStmt(int i) {
			return getRuleContext(CatchStmtContext.class,i);
		}
		public TryStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class YieldStmtContext extends StmtContext {
		public TerminalNode YIELD() { return getToken(SpadeParser.YIELD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public YieldStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(SpadeParser.RETURN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStmtContext extends StmtContext {
		public TerminalNode THROW() { return getToken(SpadeParser.THROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThrowStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoStmtContext extends StmtContext {
		public NoStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public TerminalNode IF() { return getToken(SpadeParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchStmtContext extends StmtContext {
		public TerminalNode MATCH() { return getToken(SpadeParser.MATCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SpadeParser.ELSE, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public MatchStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public TerminalNode BREAK() { return getToken(SpadeParser.BREAK, 0); }
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoStmtContext extends StmtContext {
		public TerminalNode DO() { return getToken(SpadeParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(SpadeParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public DoStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StmtContext {
		public TerminalNode CONTINUE() { return getToken(SpadeParser.CONTINUE, 0); }
		public ContinueStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stmt);
		int _la;
		try {
			setState(563);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				match(IF);
				setState(485);
				expr(0);
				setState(486);
				body();
				setState(488);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(487);
					else_();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				match(WHILE);
				setState(491);
				expr(0);
				setState(492);
				body();
				setState(494);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(493);
					else_();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new DoStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
				match(DO);
				setState(497);
				block();
				setState(498);
				match(WHILE);
				setState(499);
				expr(0);
				setState(501);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(500);
					else_();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(503);
				match(FOR);
				setState(506);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(504);
					varDecl();
					}
					break;
				case 2:
					{
					setState(505);
					expr(0);
					}
					break;
				}
				setState(508);
				match(T__0);
				setState(509);
				expr(0);
				setState(510);
				match(T__0);
				setState(511);
				expr(0);
				setState(512);
				body();
				setState(514);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(513);
					else_();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ForeachStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(516);
				match(FOR);
				setState(517);
				match(IDENTIFIER);
				setState(518);
				match(IN);
				setState(519);
				postfix(0);
				setState(520);
				body();
				setState(522);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(521);
					else_();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new MatchStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(524);
				match(MATCH);
				setState(525);
				expr(0);
				setState(526);
				match(T__2);
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHEN) {
					{
					{
					setState(527);
					matchCase();
					}
					}
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(533);
					match(ELSE);
					setState(534);
					match(T__10);
					setState(535);
					stmts();
					}
				}

				setState(538);
				match(T__3);
				}
				break;
			case 7:
				_localctx = new ThrowStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(540);
				match(THROW);
				setState(541);
				expr(0);
				}
				break;
			case 8:
				_localctx = new TryStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(542);
				match(TRY);
				setState(543);
				block();
				setState(553);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(545); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(544);
						catchStmt();
						}
						}
						setState(547); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(549);
						finallyStmt();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(552);
					finallyStmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 9:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(555);
				match(CONTINUE);
				}
				break;
			case 10:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(556);
				match(BREAK);
				}
				break;
			case 11:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(557);
				match(RETURN);
				setState(558);
				stmts();
				}
				break;
			case 12:
				_localctx = new YieldStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(559);
				match(YIELD);
				setState(560);
				expr(0);
				}
				break;
			case 13:
				_localctx = new NoStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(561);
				match(T__20);
				}
				break;
			case 14:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(562);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestructDeclContext extends ParserRuleContext {
		public List<DestructContext> destruct() {
			return getRuleContexts(DestructContext.class);
		}
		public DestructContext destruct(int i) {
			return getRuleContext(DestructContext.class,i);
		}
		public DestructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructDecl; }
	}

	public final DestructDeclContext destructDecl() throws RecognitionException {
		DestructDeclContext _localctx = new DestructDeclContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_destructDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(T__21);
			setState(566);
			destruct();
			setState(571);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(567);
					match(T__4);
					setState(568);
					destruct();
					}
					} 
				}
				setState(573);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			}
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(574);
				match(T__4);
				}
			}

			setState(577);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestructContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SpadeParser.STAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TerminalNode INTEGER() { return getToken(SpadeParser.INTEGER, 0); }
		public DestructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destruct; }
	}

	public final DestructContext destruct() throws RecognitionException {
		DestructContext _localctx = new DestructContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_destruct);
		int _la;
		try {
			setState(590);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(579);
				match(STAR);
				setState(580);
				match(IDENTIFIER);
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(581);
					match(T__21);
					setState(583);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INTEGER) {
						{
						setState(582);
						match(INTEGER);
						}
					}

					setState(585);
					match(T__22);
					}
				}

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				match(IDENTIFIER);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				match(T__19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(T__2);
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1153071038180884344L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 4329100280781L) != 0)) {
				{
				setState(596);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(593);
					block();
					}
					break;
				case 2:
					{
					setState(594);
					declaration();
					}
					break;
				case 3:
					{
					setState(595);
					stmt();
					}
					break;
				}
				}
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(601);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchCaseContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SpadeParser.WHEN, 0); }
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode IF() { return getToken(SpadeParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MatchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchCase; }
	}

	public final MatchCaseContext matchCase() throws RecognitionException {
		MatchCaseContext _localctx = new MatchCaseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_matchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(WHEN);
			setState(604);
			items();
			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(605);
				match(IF);
				setState(606);
				expr(0);
				}
			}

			setState(609);
			match(T__10);
			setState(610);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchStmtContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(SpadeParser.CATCH, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode AS() { return getToken(SpadeParser.AS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public CatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStmt; }
	}

	public final CatchStmtContext catchStmt() throws RecognitionException {
		CatchStmtContext _localctx = new CatchStmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_catchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(CATCH);
			setState(613);
			typeList();
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(614);
				match(AS);
				setState(615);
				match(IDENTIFIER);
				}
			}

			setState(618);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyStmtContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(SpadeParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyStmt; }
	}

	public final FinallyStmtContext finallyStmt() throws RecognitionException {
		FinallyStmtContext _localctx = new FinallyStmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_finallyStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(FINALLY);
			setState(621);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_body);
		try {
			setState(628);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(623);
				match(T__8);
				setState(624);
				stmt();
				setState(625);
				sep();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(627);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(SpadeParser.ELSE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(ELSE);
			setState(631);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowerExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CastExprContext extends ExprContext {
		public Token safe;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS() { return getToken(SpadeParser.AS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SpadeParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(SpadeParser.DASH, 0); }
		public TermExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(SpadeParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TerminalNode LE() { return getToken(SpadeParser.LE, 0); }
		public TerminalNode EQ() { return getToken(SpadeParser.EQ, 0); }
		public TerminalNode NE() { return getToken(SpadeParser.NE, 0); }
		public TerminalNode GE() { return getToken(SpadeParser.GE, 0); }
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(SpadeParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SpadeParser.SLASH, 0); }
		public TerminalNode MODULUS() { return getToken(SpadeParser.MODULUS, 0); }
		public FactorExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElvisExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ElvisExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitXorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BitXorExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(SpadeParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(SpadeParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(SpadeParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(SpadeParser.GT, i);
		}
		public ShiftExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BitOrExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode BANG() { return getToken(SpadeParser.BANG, 0); }
		public TerminalNode TILDE() { return getToken(SpadeParser.TILDE, 0); }
		public TerminalNode DASH() { return getToken(SpadeParser.DASH, 0); }
		public TerminalNode PLUS() { return getToken(SpadeParser.PLUS, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(SpadeParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExprContext extends ExprContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitAndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BitAndExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ExprContext {
		public AssigneeListContext assigneeList() {
			return getRuleContext(AssigneeListContext.class,0);
		}
		public AssignOperatorContext assignOperator() {
			return getRuleContext(AssignOperatorContext.class,0);
		}
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IS() { return getToken(SpadeParser.IS, 0); }
		public TerminalNode IN() { return getToken(SpadeParser.IN, 0); }
		public TerminalNode NOT() { return getToken(SpadeParser.NOT, 0); }
		public ConditionalExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(SpadeParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 15L) != 0)) {
					{
					setState(634);
					((UnaryExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 15L) != 0)) ) {
						((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(637);
				postfix(0);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(638);
				match(NOT);
				setState(639);
				expr(6);
				}
				break;
			case 3:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(646);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__19:
				case CONST:
				case STAR:
				case REF:
				case IDENTIFIER:
					{
					setState(640);
					param();
					}
					break;
				case T__6:
					{
					setState(641);
					match(T__6);
					setState(643);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__19 || _la==CONST || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 1572865L) != 0)) {
						{
						setState(642);
						params();
						}
					}

					setState(645);
					match(T__7);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(648);
				match(T__10);
				setState(650);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(649);
					type(0);
					}
					break;
				}
				setState(654);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(652);
					block();
					}
					break;
				case 2:
					{
					setState(653);
					expr(0);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(656);
				assigneeList();
				setState(657);
				assignOperator();
				setState(658);
				items();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(729);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(727);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
					case 1:
						{
						_localctx = new ElvisExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(662);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(663);
						match(T__11);
						setState(664);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new PowerExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(665);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(666);
						match(T__12);
						setState(667);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new FactorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(668);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(669);
						((FactorExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 7L) != 0)) ) {
							((FactorExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(670);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new TermExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(671);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(672);
						((TermExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==DASH) ) {
							((TermExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(673);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ShiftExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(674);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(682);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
						case 1:
							{
							setState(675);
							match(LT);
							setState(676);
							match(LT);
							}
							break;
						case 2:
							{
							setState(677);
							match(GT);
							setState(678);
							match(GT);
							}
							break;
						case 3:
							{
							setState(679);
							match(GT);
							setState(680);
							match(GT);
							setState(681);
							match(GT);
							}
							break;
						}
						setState(684);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new BitAndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(685);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(686);
						match(T__16);
						setState(687);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new BitXorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(688);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(689);
						match(T__17);
						setState(690);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new BitOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(691);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(692);
						match(T__18);
						setState(693);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(694);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(695);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 63L) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(696);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ConditionalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(697);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(706);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(698);
							match(IS);
							setState(700);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
							case 1:
								{
								setState(699);
								match(NOT);
								}
								break;
							}
							}
							break;
						case IN:
						case NOT:
							{
							setState(703);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==NOT) {
								{
								setState(702);
								match(NOT);
								}
							}

							setState(705);
							match(IN);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(708);
						expr(8);
						}
						break;
					case 11:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(709);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(710);
						match(AND);
						setState(711);
						expr(6);
						}
						break;
					case 12:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(712);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(713);
						match(OR);
						setState(714);
						expr(5);
						}
						break;
					case 13:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(715);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(716);
						match(T__23);
						setState(717);
						expr(0);
						setState(718);
						match(T__8);
						setState(719);
						expr(4);
						}
						break;
					case 14:
						{
						_localctx = new CastExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(721);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(722);
						match(AS);
						setState(724);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__23) {
							{
							setState(723);
							((CastExprContext)_localctx).safe = match(T__23);
							}
						}

						setState(726);
						type(0);
						}
						break;
					}
					} 
				}
				setState(731);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssigneeListContext extends ParserRuleContext {
		public List<AssigneeContext> assignee() {
			return getRuleContexts(AssigneeContext.class);
		}
		public AssigneeContext assignee(int i) {
			return getRuleContext(AssigneeContext.class,i);
		}
		public AssigneeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigneeList; }
	}

	public final AssigneeListContext assigneeList() throws RecognitionException {
		AssigneeListContext _localctx = new AssigneeListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_assigneeList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			assignee();
			setState(737);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(733);
					match(T__4);
					setState(734);
					assignee();
					}
					} 
				}
				setState(739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
			}
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(740);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssigneeContext extends ParserRuleContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public DestructDeclContext destructDecl() {
			return getRuleContext(DestructDeclContext.class,0);
		}
		public AssigneeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignee; }
	}

	public final AssigneeContext assignee() throws RecognitionException {
		AssigneeContext _localctx = new AssigneeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignee);
		try {
			setState(745);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				postfix(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(744);
				destructDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignOperatorContext extends ParserRuleContext {
		public AssignOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOperator; }
	}

	public final AssignOperatorContext assignOperator() throws RecognitionException {
		AssignOperatorContext _localctx = new AssignOperatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 274844352576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixContext extends ParserRuleContext {
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	 
		public PostfixContext() { }
		public void copyFrom(PostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixPrimaryContext extends PostfixContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PostfixPrimaryContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixDotContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public PostfixDotContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixBlockContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PostfixBlockContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixGenericContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public PostfixGenericContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixCallContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public PostfixCallContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixIndexerContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public IndexerContext indexer() {
			return getRuleContext(IndexerContext.class,0);
		}
		public PostfixIndexerContext(PostfixContext ctx) { copyFrom(ctx); }
	}

	public final PostfixContext postfix() throws RecognitionException {
		return postfix(0);
	}

	private PostfixContext postfix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixContext _localctx = new PostfixContext(_ctx, _parentState);
		PostfixContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_postfix, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PostfixPrimaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(750);
			primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(778);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(776);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixDotContext(new PostfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(752);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(754);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__23) {
							{
							setState(753);
							match(T__23);
							}
						}

						setState(756);
						match(T__1);
						setState(757);
						match(IDENTIFIER);
						}
						break;
					case 2:
						{
						_localctx = new PostfixGenericContext(new PostfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(758);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(759);
						match(LT);
						setState(760);
						typeArgs();
						setState(761);
						match(GT);
						}
						break;
					case 3:
						{
						_localctx = new PostfixCallContext(new PostfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(763);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(764);
						match(T__6);
						setState(766);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
							{
							setState(765);
							args();
							}
						}

						setState(768);
						match(T__7);
						}
						break;
					case 4:
						{
						_localctx = new PostfixIndexerContext(new PostfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(769);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(770);
						match(T__21);
						setState(771);
						indexer();
						setState(772);
						match(T__22);
						}
						break;
					case 5:
						{
						_localctx = new PostfixBlockContext(new PostfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(774);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(775);
						block();
						}
						break;
					}
					} 
				}
				setState(780);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			arg();
			setState(786);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(782);
					match(T__4);
					setState(783);
					arg();
					}
					} 
				}
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			}
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(789);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(792);
				match(IDENTIFIER);
				setState(793);
				match(T__8);
				}
				break;
			}
			setState(798);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(796);
				expr(0);
				}
				break;
			case 2:
				{
				setState(797);
				match(T__19);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexerContext extends ParserRuleContext {
		public List<SliceContext> slice() {
			return getRuleContexts(SliceContext.class);
		}
		public SliceContext slice(int i) {
			return getRuleContext(SliceContext.class,i);
		}
		public IndexerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexer; }
	}

	public final IndexerContext indexer() throws RecognitionException {
		IndexerContext _localctx = new IndexerContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_indexer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			slice();
			setState(805);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(801);
					match(T__4);
					setState(802);
					slice();
					}
					} 
				}
				setState(807);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			}
			setState(809);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(808);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SliceContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_slice);
		int _la;
		try {
			setState(825);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(811);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(813);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
					{
					setState(812);
					expr(0);
					}
				}

				setState(815);
				match(T__8);
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
					{
					setState(816);
					expr(0);
					}
				}

				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(819);
					match(T__8);
					setState(821);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
						{
						setState(820);
						expr(0);
						}
					}

					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupExprContext extends PrimaryContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GroupExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisExprContext extends PrimaryContext {
		public TerminalNode THIS() { return getToken(SpadeParser.THIS, 0); }
		public ThisExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SuperExprContext extends PrimaryContext {
		public TerminalNode SUPER() { return getToken(SpadeParser.SUPER, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public SuperExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeExprContext extends PrimaryContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MapExprContext extends PrimaryContext {
		public EntriesContext entries() {
			return getRuleContext(EntriesContext.class,0);
		}
		public MapExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleExprContext extends PrimaryContext {
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public TupleExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BuilderExprContext extends PrimaryContext {
		public ObjectBuilderContext objectBuilder() {
			return getRuleContext(ObjectBuilderContext.class,0);
		}
		public BuilderExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends PrimaryContext {
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public ListExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetExprContext extends PrimaryContext {
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public SetExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantExprContext extends PrimaryContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExprContext(PrimaryContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_primary);
		int _la;
		try {
			setState(861);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				_localctx = new ConstantExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(827);
				constant();
				}
				break;
			case 2:
				_localctx = new BuilderExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(828);
				objectBuilder();
				}
				break;
			case 3:
				_localctx = new SuperExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(829);
				match(SUPER);
				setState(834);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(830);
					match(T__21);
					setState(831);
					reference();
					setState(832);
					match(T__22);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ThisExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(836);
				match(THIS);
				}
				break;
			case 5:
				_localctx = new GroupExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(837);
				match(T__6);
				{
				setState(838);
				expr(0);
				}
				setState(839);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new TupleExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(841);
				match(T__6);
				setState(843);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
					{
					setState(842);
					items();
					}
				}

				setState(845);
				match(T__7);
				}
				break;
			case 7:
				_localctx = new SetExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(846);
				match(T__2);
				setState(847);
				items();
				setState(848);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new MapExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(850);
				match(T__2);
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4194440L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 15615L) != 0)) {
					{
					setState(851);
					entries();
					}
				}

				setState(854);
				match(T__3);
				}
				break;
			case 9:
				_localctx = new ListExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(855);
				match(T__21);
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562949958664328L) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 16514207L) != 0)) {
					{
					setState(856);
					items();
					}
				}

				setState(859);
				match(T__22);
				}
				break;
			case 10:
				_localctx = new TypeExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(860);
				type(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SpadeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SpadeParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(SpadeParser.NULL, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_constant);
		try {
			setState(867);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(863);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(864);
				match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(865);
				match(NULL);
				}
				break;
			case IDENTIFIER:
			case INTEGER:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(866);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SpadeParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(SpadeParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(SpadeParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			_la = _input.LA(1);
			if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectBuilderContext extends ParserRuleContext {
		public TerminalNode OBJECT() { return getToken(SpadeParser.OBJECT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<MemberDeclContext> memberDecl() {
			return getRuleContexts(MemberDeclContext.class);
		}
		public MemberDeclContext memberDecl(int i) {
			return getRuleContext(MemberDeclContext.class,i);
		}
		public ObjectBuilderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectBuilder; }
	}

	public final ObjectBuilderContext objectBuilder() throws RecognitionException {
		ObjectBuilderContext _localctx = new ObjectBuilderContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_objectBuilder);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			match(OBJECT);
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(872);
				match(T__8);
				setState(873);
				type(0);
				}
			}

			setState(876);
			match(T__2);
			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574974212586865664L) != 0) || _la==AS || _la==IDENTIFIER) {
				{
				{
				setState(877);
				memberDecl();
				}
				}
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(883);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items; }
	}

	public final ItemsContext items() throws RecognitionException {
		ItemsContext _localctx = new ItemsContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_items);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			expr(0);
			setState(890);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(886);
					match(T__4);
					setState(887);
					expr(0);
					}
					} 
				}
				setState(892);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			}
			setState(894);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(893);
				match(T__4);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntriesContext extends ParserRuleContext {
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public EntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entries; }
	}

	public final EntriesContext entries() throws RecognitionException {
		EntriesContext _localctx = new EntriesContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_entries);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			entry();
			setState(901);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(897);
					match(T__4);
					setState(898);
					entry();
					}
					} 
				}
				setState(903);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(905);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(904);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntryContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			primary();
			setState(908);
			match(T__8);
			setState(909);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralTypeContext extends TypeContext {
		public TerminalNode TYPE() { return getToken(SpadeParser.TYPE, 0); }
		public LiteralTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeofTypeContext extends TypeContext {
		public TerminalNode TYPEOF() { return getToken(SpadeParser.TYPEOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeofTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullableTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NullableTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntersectionTypeContext extends TypeContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public IntersectionTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceTypeContext extends TypeContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LT() { return getToken(SpadeParser.LT, 0); }
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public TerminalNode GT() { return getToken(SpadeParser.GT, 0); }
		public ReferenceTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeContext extends TypeContext {
		public ParamTypesContext paramTypes() {
			return getRuleContext(ParamTypesContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectTypeContext extends TypeContext {
		public TerminalNode OBJECT() { return getToken(SpadeParser.OBJECT, 0); }
		public MemberTypeListContext memberTypeList() {
			return getRuleContext(MemberTypeListContext.class,0);
		}
		public ObjectTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnionTypeContext extends TypeContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public UnionTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new ReferenceTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(912);
				reference();
				setState(917);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
				case 1:
					{
					setState(913);
					match(LT);
					setState(914);
					typeArgs();
					setState(915);
					match(GT);
					}
					break;
				}
				}
				break;
			case T__6:
				{
				_localctx = new FunctionTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(919);
				match(T__6);
				setState(920);
				paramTypes();
				setState(921);
				match(T__7);
				setState(922);
				match(T__10);
				setState(923);
				type(4);
				}
				break;
			case TYPE:
				{
				_localctx = new LiteralTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(925);
				match(TYPE);
				}
				break;
			case OBJECT:
				{
				_localctx = new ObjectTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(926);
				match(OBJECT);
				setState(932);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
				case 1:
					{
					setState(927);
					match(T__2);
					setState(929);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIER) {
						{
						setState(928);
						memberTypeList();
						}
					}

					setState(931);
					match(T__3);
					}
					break;
				}
				}
				break;
			case TYPEOF:
				{
				_localctx = new TypeofTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(934);
				match(TYPEOF);
				setState(935);
				match(T__6);
				setState(936);
				expr(0);
				setState(937);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(951);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(949);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
					case 1:
						{
						_localctx = new IntersectionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(941);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(942);
						match(T__16);
						setState(943);
						type(8);
						}
						break;
					case 2:
						{
						_localctx = new UnionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(944);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(945);
						match(T__18);
						setState(946);
						type(7);
						}
						break;
					case 3:
						{
						_localctx = new NullableTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(947);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(948);
						match(T__23);
						}
						break;
					}
					} 
				}
				setState(953);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgsContext extends ParserRuleContext {
		public List<TypeArgContext> typeArg() {
			return getRuleContexts(TypeArgContext.class);
		}
		public TypeArgContext typeArg(int i) {
			return getRuleContext(TypeArgContext.class,i);
		}
		public TypeArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgs; }
	}

	public final TypeArgsContext typeArgs() throws RecognitionException {
		TypeArgsContext _localctx = new TypeArgsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_typeArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			typeArg();
			setState(959);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(955);
					match(T__4);
					setState(956);
					typeArg();
					}
					} 
				}
				setState(961);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(962);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OUT() { return getToken(SpadeParser.OUT, 0); }
		public TerminalNode IN() { return getToken(SpadeParser.IN, 0); }
		public TypeArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArg; }
	}

	public final TypeArgContext typeArg() throws RecognitionException {
		TypeArgContext _localctx = new TypeArgContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_typeArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN || _la==OUT) {
				{
				setState(965);
				_la = _input.LA(1);
				if ( !(_la==IN || _la==OUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(968);
			type(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamTypesContext extends ParserRuleContext {
		public List<ParamTypeContext> paramType() {
			return getRuleContexts(ParamTypeContext.class);
		}
		public ParamTypeContext paramType(int i) {
			return getRuleContext(ParamTypeContext.class,i);
		}
		public ParamTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramTypes; }
	}

	public final ParamTypesContext paramTypes() throws RecognitionException {
		ParamTypesContext _localctx = new ParamTypesContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_paramTypes);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			paramType();
			setState(975);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(971);
					match(T__4);
					setState(972);
					paramType();
					}
					} 
				}
				setState(977);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			}
			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(978);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STAR() { return getToken(SpadeParser.STAR, 0); }
		public ParamTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramType; }
	}

	public final ParamTypeContext paramType() throws RecognitionException {
		ParamTypeContext _localctx = new ParamTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_paramType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(981);
				match(STAR);
				}
			}

			setState(984);
			type(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_typeList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(986);
			type(0);
			setState(991);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(987);
					match(T__4);
					setState(988);
					type(0);
					}
					} 
				}
				setState(993);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			}
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(994);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberTypeListContext extends ParserRuleContext {
		public List<MemberTypeContext> memberType() {
			return getRuleContexts(MemberTypeContext.class);
		}
		public MemberTypeContext memberType(int i) {
			return getRuleContext(MemberTypeContext.class,i);
		}
		public MemberTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberTypeList; }
	}

	public final MemberTypeListContext memberTypeList() throws RecognitionException {
		MemberTypeListContext _localctx = new MemberTypeListContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_memberTypeList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			memberType();
			setState(1002);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(998);
					match(T__4);
					setState(999);
					memberType();
					}
					} 
				}
				setState(1004);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			setState(1006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(1005);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SpadeParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MemberTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberType; }
	}

	public final MemberTypeContext memberType() throws RecognitionException {
		MemberTypeContext _localctx = new MemberTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_memberType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			match(IDENTIFIER);
			setState(1011);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(1009);
				match(T__8);
				setState(1010);
				type(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 41:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 45:
			return postfix_sempred((PostfixContext)_localctx, predIndex);
		case 57:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 16);
		}
		return true;
	}
	private boolean postfix_sempred(PostfixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 5);
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		case 17:
			return precpred(_ctx, 2);
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 7);
		case 20:
			return precpred(_ctx, 6);
		case 21:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001n\u03f6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0001"+
		"\u0000\u0005\u0000\u0084\b\u0000\n\u0000\f\u0000\u0087\t\u0000\u0001\u0001"+
		"\u0003\u0001\u008a\b\u0001\u0001\u0001\u0005\u0001\u008d\b\u0001\n\u0001"+
		"\f\u0001\u0090\t\u0001\u0001\u0001\u0005\u0001\u0093\b\u0001\n\u0001\f"+
		"\u0001\u0096\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00a2\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00a9\b\u0004\n\u0004\f\u0004\u00ac\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00b7\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00bd\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u00c3\b\u0006\n\u0006\f\u0006\u00c6"+
		"\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00ca\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00cf\b\u0007\n\u0007\f\u0007\u00d2"+
		"\t\u0007\u0001\u0007\u0003\u0007\u00d5\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u00dc\b\b\u0001\b\u0003\b\u00df\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00e5\b\t\u0001\t\u0001\t\u0003\t\u00e9\b\t"+
		"\u0001\t\u0001\t\u0005\t\u00ed\b\t\n\t\f\t\u00f0\t\t\u0001\t\u0003\t\u00f3"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00f9\b\n\u0001\n\u0001\n"+
		"\u0005\n\u00fd\b\n\n\n\f\n\u0100\t\n\u0001\n\u0003\n\u0103\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0109\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u010d\b\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0111\b\u000b\n\u000b\f\u000b\u0114\t\u000b\u0001\u000b\u0003\u000b\u0117"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u011c\b\f\n\f\f\f\u011f\t\f\u0001"+
		"\f\u0003\f\u0122\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0129"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0130\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0135"+
		"\b\u000f\n\u000f\f\u000f\u0138\t\u000f\u0001\u000f\u0003\u000f\u013b\b"+
		"\u000f\u0001\u0010\u0003\u0010\u013e\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0143\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0147"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0150\b\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0003\u0012\u0155\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u015a\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0161\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0165"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u016a\b\u0013"+
		"\u0001\u0013\u0003\u0013\u016d\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0186\b\u0014\u0001\u0014\u0003\u0014"+
		"\u0189\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u018f\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0194\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0198\b\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u019f\b\u0016\n"+
		"\u0016\f\u0016\u01a2\t\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u01ae\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u01b3\b\u001a\u0003\u001a\u01b5\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0005\u001b\u01ba\b\u001b\n\u001b\f\u001b\u01bd\t\u001b\u0001"+
		"\u001b\u0003\u001b\u01c0\b\u001b\u0001\u001c\u0003\u001c\u01c3\b\u001c"+
		"\u0001\u001c\u0003\u001c\u01c6\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u01cb\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01cf\b"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u01d5"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01da\b\u001e"+
		"\u0001\u001e\u0003\u001e\u01dd\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0003\u001f\u01e3\b\u001f\u0001 \u0001 \u0001 \u0001 \u0003"+
		" \u01e9\b \u0001 \u0001 \u0001 \u0001 \u0003 \u01ef\b \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0003 \u01f6\b \u0001 \u0001 \u0001 \u0003 \u01fb\b \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0203\b \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0003 \u020b\b \u0001 \u0001 \u0001 \u0001 \u0005"+
		" \u0211\b \n \f \u0214\t \u0001 \u0001 \u0001 \u0003 \u0219\b \u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0004 \u0222\b \u000b \f \u0223"+
		"\u0001 \u0003 \u0227\b \u0001 \u0003 \u022a\b \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0003 \u0234\b \u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u023a\b!\n!\f!\u023d\t!\u0001!\u0003!\u0240\b!\u0001!\u0001!"+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0248\b\"\u0001\"\u0003\"\u024b"+
		"\b\"\u0001\"\u0001\"\u0003\"\u024f\b\"\u0001#\u0001#\u0001#\u0001#\u0005"+
		"#\u0255\b#\n#\f#\u0258\t#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u0260\b$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0003%\u0269"+
		"\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0003\'\u0275\b\'\u0001(\u0001(\u0001(\u0001)\u0001)\u0003)\u027c"+
		"\b)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0284\b)\u0001)\u0003"+
		")\u0287\b)\u0001)\u0001)\u0003)\u028b\b)\u0001)\u0001)\u0003)\u028f\b"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u0295\b)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u02ab\b)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u02bd\b)\u0001)\u0003)\u02c0\b)\u0001"+
		")\u0003)\u02c3\b)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u02d5"+
		"\b)\u0001)\u0005)\u02d8\b)\n)\f)\u02db\t)\u0001*\u0001*\u0001*\u0005*"+
		"\u02e0\b*\n*\f*\u02e3\t*\u0001*\u0003*\u02e6\b*\u0001+\u0001+\u0003+\u02ea"+
		"\b+\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u02f3\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003"+
		"-\u02ff\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0005"+
		"-\u0309\b-\n-\f-\u030c\t-\u0001.\u0001.\u0001.\u0005.\u0311\b.\n.\f.\u0314"+
		"\t.\u0001.\u0003.\u0317\b.\u0001/\u0001/\u0003/\u031b\b/\u0001/\u0001"+
		"/\u0003/\u031f\b/\u00010\u00010\u00010\u00050\u0324\b0\n0\f0\u0327\t0"+
		"\u00010\u00030\u032a\b0\u00011\u00011\u00031\u032e\b1\u00011\u00011\u0003"+
		"1\u0332\b1\u00011\u00011\u00031\u0336\b1\u00031\u0338\b1\u00031\u033a"+
		"\b1\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u0343\b2\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u034c\b2\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00032\u0355\b2\u00012\u00012\u0001"+
		"2\u00032\u035a\b2\u00012\u00012\u00032\u035e\b2\u00013\u00013\u00013\u0001"+
		"3\u00033\u0364\b3\u00014\u00014\u00015\u00015\u00015\u00035\u036b\b5\u0001"+
		"5\u00015\u00055\u036f\b5\n5\f5\u0372\t5\u00015\u00015\u00016\u00016\u0001"+
		"6\u00056\u0379\b6\n6\f6\u037c\t6\u00016\u00036\u037f\b6\u00017\u00017"+
		"\u00017\u00057\u0384\b7\n7\f7\u0387\t7\u00017\u00037\u038a\b7\u00018\u0001"+
		"8\u00018\u00018\u00019\u00019\u00019\u00019\u00019\u00019\u00039\u0396"+
		"\b9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00039\u03a2\b9\u00019\u00039\u03a5\b9\u00019\u00019\u00019\u00019\u0001"+
		"9\u00039\u03ac\b9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00059\u03b6\b9\n9\f9\u03b9\t9\u0001:\u0001:\u0001:\u0005:\u03be\b:"+
		"\n:\f:\u03c1\t:\u0001:\u0003:\u03c4\b:\u0001;\u0003;\u03c7\b;\u0001;\u0001"+
		";\u0001<\u0001<\u0001<\u0005<\u03ce\b<\n<\f<\u03d1\t<\u0001<\u0003<\u03d4"+
		"\b<\u0001=\u0003=\u03d7\b=\u0001=\u0001=\u0001>\u0001>\u0001>\u0005>\u03de"+
		"\b>\n>\f>\u03e1\t>\u0001>\u0003>\u03e4\b>\u0001?\u0001?\u0001?\u0005?"+
		"\u03e9\b?\n?\f?\u03ec\t?\u0001?\u0003?\u03ef\b?\u0001@\u0001@\u0001@\u0003"+
		"@\u03f4\b@\u0001@\u0000\u0003RZrA\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0000\u000b\u0002\u0000@@ee\u0001"+
		"\u00007:\u0002\u000011ff\u0002\u0000\u0014\u0014gg\u0001\u000012\u0001"+
		"\u0000TW\u0001\u0000QS\u0001\u0000TU\u0001\u0000KP\u0002\u0000\u0006\u0006"+
		"\u0019%\u0001\u0000gj\u0496\u0000\u0085\u0001\u0000\u0000\u0000\u0002"+
		"\u0089\u0001\u0000\u0000\u0000\u0004\u0099\u0001\u0000\u0000\u0000\u0006"+
		"\u009d\u0001\u0000\u0000\u0000\b\u00a5\u0001\u0000\u0000\u0000\n\u00ad"+
		"\u0001\u0000\u0000\u0000\f\u00b8\u0001\u0000\u0000\u0000\u000e\u00cb\u0001"+
		"\u0000\u0000\u0000\u0010\u00d6\u0001\u0000\u0000\u0000\u0012\u00e0\u0001"+
		"\u0000\u0000\u0000\u0014\u00f4\u0001\u0000\u0000\u0000\u0016\u0104\u0001"+
		"\u0000\u0000\u0000\u0018\u0118\u0001\u0000\u0000\u0000\u001a\u0123\u0001"+
		"\u0000\u0000\u0000\u001c\u012a\u0001\u0000\u0000\u0000\u001e\u0131\u0001"+
		"\u0000\u0000\u0000 \u013d\u0001\u0000\u0000\u0000\"\u0148\u0001\u0000"+
		"\u0000\u0000$\u0154\u0001\u0000\u0000\u0000&\u0160\u0001\u0000\u0000\u0000"+
		"(\u018e\u0001\u0000\u0000\u0000*\u0190\u0001\u0000\u0000\u0000,\u01a0"+
		"\u0001\u0000\u0000\u0000.\u01a3\u0001\u0000\u0000\u00000\u01a5\u0001\u0000"+
		"\u0000\u00002\u01ad\u0001\u0000\u0000\u00004\u01af\u0001\u0000\u0000\u0000"+
		"6\u01b6\u0001\u0000\u0000\u00008\u01c2\u0001\u0000\u0000\u0000:\u01d0"+
		"\u0001\u0000\u0000\u0000<\u01dc\u0001\u0000\u0000\u0000>\u01e2\u0001\u0000"+
		"\u0000\u0000@\u0233\u0001\u0000\u0000\u0000B\u0235\u0001\u0000\u0000\u0000"+
		"D\u024e\u0001\u0000\u0000\u0000F\u0250\u0001\u0000\u0000\u0000H\u025b"+
		"\u0001\u0000\u0000\u0000J\u0264\u0001\u0000\u0000\u0000L\u026c\u0001\u0000"+
		"\u0000\u0000N\u0274\u0001\u0000\u0000\u0000P\u0276\u0001\u0000\u0000\u0000"+
		"R\u0294\u0001\u0000\u0000\u0000T\u02dc\u0001\u0000\u0000\u0000V\u02e9"+
		"\u0001\u0000\u0000\u0000X\u02eb\u0001\u0000\u0000\u0000Z\u02ed\u0001\u0000"+
		"\u0000\u0000\\\u030d\u0001\u0000\u0000\u0000^\u031a\u0001\u0000\u0000"+
		"\u0000`\u0320\u0001\u0000\u0000\u0000b\u0339\u0001\u0000\u0000\u0000d"+
		"\u035d\u0001\u0000\u0000\u0000f\u0363\u0001\u0000\u0000\u0000h\u0365\u0001"+
		"\u0000\u0000\u0000j\u0367\u0001\u0000\u0000\u0000l\u0375\u0001\u0000\u0000"+
		"\u0000n\u0380\u0001\u0000\u0000\u0000p\u038b\u0001\u0000\u0000\u0000r"+
		"\u03ab\u0001\u0000\u0000\u0000t\u03ba\u0001\u0000\u0000\u0000v\u03c6\u0001"+
		"\u0000\u0000\u0000x\u03ca\u0001\u0000\u0000\u0000z\u03d6\u0001\u0000\u0000"+
		"\u0000|\u03da\u0001\u0000\u0000\u0000~\u03e5\u0001\u0000\u0000\u0000\u0080"+
		"\u03f0\u0001\u0000\u0000\u0000\u0082\u0084\u0005\u0001\u0000\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0001\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0003\u0004\u0002\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u008e\u0001\u0000\u0000\u0000\u008b"+
		"\u008d\u0003\u0006\u0003\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d"+
		"\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0094\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0091\u0093\u0003\n\u0005\u0000\u0092\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0097"+
		"\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0005\u0000\u0000\u0001\u0098\u0003\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0005&\u0000\u0000\u009a\u009b\u0003\b\u0004\u0000\u009b\u009c\u0003"+
		"\u0000\u0000\u0000\u009c\u0005\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\'\u0000\u0000\u009e\u00a1\u0003\b\u0004\u0000\u009f\u00a0\u0005X\u0000"+
		"\u0000\u00a0\u00a2\u0005g\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0003\u0000\u0000\u0000\u00a4\u0007\u0001\u0000\u0000\u0000"+
		"\u00a5\u00aa\u0005g\u0000\u0000\u00a6\u00a7\u0005\u0002\u0000\u0000\u00a7"+
		"\u00a9\u0005g\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\t\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b6\u0003,\u0016\u0000\u00ae\u00af\u0003:\u001d"+
		"\u0000\u00af\u00b0\u0003\u0000\u0000\u0000\u00b0\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b7\u00030\u0018\u0000\u00b2\u00b7\u0003\u0016\u000b\u0000"+
		"\u00b3\u00b7\u0003\u0014\n\u0000\u00b4\u00b7\u0003\f\u0006\u0000\u00b5"+
		"\u00b7\u0003\u0012\t\u0000\u00b6\u00ae\u0001\u0000\u0000\u0000\u00b6\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001\u0000\u0000\u0000\u00b6\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u000b\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0005+\u0000\u0000\u00b9\u00bc\u0005g\u0000\u0000\u00ba\u00bb\u0005*"+
		"\u0000\u0000\u00bb\u00bd\u0003\u0018\f\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c9\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005\u0003\u0000\u0000\u00bf\u00c0\u0003\u000e\u0007"+
		"\u0000\u00c0\u00c4\u0003\u0000\u0000\u0000\u00c1\u00c3\u0003\"\u0011\u0000"+
		"\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0005\u0004\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c9\u00be\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000"+
		"\u00ca\r\u0001\u0000\u0000\u0000\u00cb\u00d0\u0003\u0010\b\u0000\u00cc"+
		"\u00cd\u0005\u0005\u0000\u0000\u00cd\u00cf\u0003\u0010\b\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d5"+
		"\u0005\u0005\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u000f\u0001\u0000\u0000\u0000\u00d6\u00de"+
		"\u0005g\u0000\u0000\u00d7\u00d8\u0005\u0006\u0000\u0000\u00d8\u00df\u0003"+
		"R)\u0000\u00d9\u00db\u0005\u0007\u0000\u0000\u00da\u00dc\u0003\\.\u0000"+
		"\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00df\u0005\b\u0000\u0000\u00de"+
		"\u00d7\u0001\u0000\u0000\u0000\u00de\u00d9\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u0011\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005.\u0000\u0000\u00e1\u00e4\u0003\u001c\u000e\u0000\u00e2\u00e3"+
		"\u0005)\u0000\u0000\u00e3\u00e5\u0003\u001a\r\u0000\u00e4\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005*\u0000\u0000\u00e7\u00e9\u0003\u0018"+
		"\f\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9\u00f2\u0001\u0000\u0000\u0000\u00ea\u00ee\u0005\u0003\u0000"+
		"\u0000\u00eb\u00ed\u0003\"\u0011\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f3\u0005\u0004\u0000\u0000"+
		"\u00f2\u00ea\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f3\u0013\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005-\u0000\u0000\u00f5"+
		"\u00f8\u0003\u001c\u000e\u0000\u00f6\u00f7\u0005)\u0000\u0000\u00f7\u00f9"+
		"\u0003\u0018\f\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9\u0102\u0001\u0000\u0000\u0000\u00fa\u00fe\u0005"+
		"\u0003\u0000\u0000\u00fb\u00fd\u0003\"\u0011\u0000\u00fc\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0101\u0001\u0000"+
		"\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0103\u0005\u0004"+
		"\u0000\u0000\u0102\u00fa\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000"+
		"\u0000\u0000\u0103\u0015\u0001\u0000\u0000\u0000\u0104\u0105\u0005,\u0000"+
		"\u0000\u0105\u0108\u0003\u001c\u000e\u0000\u0106\u0107\u0005)\u0000\u0000"+
		"\u0107\u0109\u0003\u001a\r\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108"+
		"\u0109\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005*\u0000\u0000\u010b\u010d\u0003\u0018\f\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u0116"+
		"\u0001\u0000\u0000\u0000\u010e\u0112\u0005\u0003\u0000\u0000\u010f\u0111"+
		"\u0003\"\u0011\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0114\u0001"+
		"\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001"+
		"\u0000\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0005\u0004\u0000\u0000\u0116\u010e\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0017\u0001"+
		"\u0000\u0000\u0000\u0118\u011d\u0003\u001a\r\u0000\u0119\u011a\u0005\u0005"+
		"\u0000\u0000\u011a\u011c\u0003\u001a\r\u0000\u011b\u0119\u0001\u0000\u0000"+
		"\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000"+
		"\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0122\u0005\u0005\u0000"+
		"\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000"+
		"\u0000\u0122\u0019\u0001\u0000\u0000\u0000\u0123\u0128\u0003\b\u0004\u0000"+
		"\u0124\u0125\u0005P\u0000\u0000\u0125\u0126\u0003t:\u0000\u0126\u0127"+
		"\u0005K\u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128\u0124\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u001b\u0001"+
		"\u0000\u0000\u0000\u012a\u012f\u0005g\u0000\u0000\u012b\u012c\u0005P\u0000"+
		"\u0000\u012c\u012d\u0003\u001e\u000f\u0000\u012d\u012e\u0005K\u0000\u0000"+
		"\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u012b\u0001\u0000\u0000\u0000"+
		"\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u001d\u0001\u0000\u0000\u0000"+
		"\u0131\u0136\u0003 \u0010\u0000\u0132\u0133\u0005\u0005\u0000\u0000\u0133"+
		"\u0135\u0003 \u0010\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0138"+
		"\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0005\u0005\u0000\u0000\u013a\u0139"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u001f"+
		"\u0001\u0000\u0000\u0000\u013c\u013e\u0007\u0000\u0000\u0000\u013d\u013c"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f\u0142\u0005g\u0000\u0000\u0140\u0141\u0005"+
		"\t\u0000\u0000\u0141\u0143\u0003r9\u0000\u0142\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0005\u0006\u0000\u0000\u0145\u0147\u0003r9\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147"+
		"!\u0001\u0000\u0000\u0000\u0148\u014f\u0003,\u0016\u0000\u0149\u0150\u0003"+
		"$\u0012\u0000\u014a\u0150\u0003&\u0013\u0000\u014b\u0150\u0003*\u0015"+
		"\u0000\u014c\u0150\u0003\u0016\u000b\u0000\u014d\u0150\u0003\u0014\n\u0000"+
		"\u014e\u0150\u0003\f\u0006\u0000\u014f\u0149\u0001\u0000\u0000\u0000\u014f"+
		"\u014a\u0001\u0000\u0000\u0000\u014f\u014b\u0001\u0000\u0000\u0000\u014f"+
		"\u014c\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f"+
		"\u014e\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0003\u0000\u0000\u0000\u0152#\u0001\u0000\u0000\u0000\u0153\u0155"+
		"\u00051\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0154\u0155\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0159\u0003"+
		"<\u001e\u0000\u0157\u0158\u0005\u0006\u0000\u0000\u0158\u015a\u0003R)"+
		"\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000"+
		"\u0000\u015a%\u0001\u0000\u0000\u0000\u015b\u0161\u0005g\u0000\u0000\u015c"+
		"\u015d\u0005\n\u0000\u0000\u015d\u0161\u0003(\u0014\u0000\u015e\u015f"+
		"\u0005X\u0000\u0000\u015f\u0161\u0003r9\u0000\u0160\u015b\u0001\u0000"+
		"\u0000\u0000\u0160\u015c\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0164\u0005\u0007"+
		"\u0000\u0000\u0163\u0165\u00034\u001a\u0000\u0164\u0163\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000"+
		"\u0000\u0166\u0169\u0005\b\u0000\u0000\u0167\u0168\u0005\u000b\u0000\u0000"+
		"\u0168\u016a\u0003r9\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a"+
		"\u0001\u0000\u0000\u0000\u016a\u016c\u0001\u0000\u0000\u0000\u016b\u016d"+
		"\u00032\u0019\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016c\u016d\u0001"+
		"\u0000\u0000\u0000\u016d\'\u0001\u0000\u0000\u0000\u016e\u018f\u0005W"+
		"\u0000\u0000\u016f\u018f\u0005U\u0000\u0000\u0170\u018f\u0005V\u0000\u0000"+
		"\u0171\u018f\u0005T\u0000\u0000\u0172\u018f\u0005\f\u0000\u0000\u0173"+
		"\u018f\u0005\r\u0000\u0000\u0174\u018f\u0005S\u0000\u0000\u0175\u018f"+
		"\u0005R\u0000\u0000\u0176\u018f\u0005Q\u0000\u0000\u0177\u018f\u0005\u000e"+
		"\u0000\u0000\u0178\u018f\u0005\u000f\u0000\u0000\u0179\u018f\u0005\u0010"+
		"\u0000\u0000\u017a\u018f\u0005P\u0000\u0000\u017b\u018f\u0005O\u0000\u0000"+
		"\u017c\u018f\u0005N\u0000\u0000\u017d\u018f\u0005M\u0000\u0000\u017e\u018f"+
		"\u0005L\u0000\u0000\u017f\u018f\u0005K\u0000\u0000\u0180\u018f\u0005\u0011"+
		"\u0000\u0000\u0181\u018f\u0005\u0012\u0000\u0000\u0182\u018f\u0005\u0013"+
		"\u0000\u0000\u0183\u0185\u0005Y\u0000\u0000\u0184\u0186\u0005Z\u0000\u0000"+
		"\u0185\u0184\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000"+
		"\u0186\u018f\u0001\u0000\u0000\u0000\u0187\u0189\u0005Z\u0000\u0000\u0188"+
		"\u0187\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u0001\u0000\u0000\u0000\u018a\u018f\u0005@\u0000\u0000\u018b\u018f"+
		"\u0005Z\u0000\u0000\u018c\u018f\u0005[\u0000\u0000\u018d\u018f\u0005\\"+
		"\u0000\u0000\u018e\u016e\u0001\u0000\u0000\u0000\u018e\u016f\u0001\u0000"+
		"\u0000\u0000\u018e\u0170\u0001\u0000\u0000\u0000\u018e\u0171\u0001\u0000"+
		"\u0000\u0000\u018e\u0172\u0001\u0000\u0000\u0000\u018e\u0173\u0001\u0000"+
		"\u0000\u0000\u018e\u0174\u0001\u0000\u0000\u0000\u018e\u0175\u0001\u0000"+
		"\u0000\u0000\u018e\u0176\u0001\u0000\u0000\u0000\u018e\u0177\u0001\u0000"+
		"\u0000\u0000\u018e\u0178\u0001\u0000\u0000\u0000\u018e\u0179\u0001\u0000"+
		"\u0000\u0000\u018e\u017a\u0001\u0000\u0000\u0000\u018e\u017b\u0001\u0000"+
		"\u0000\u0000\u018e\u017c\u0001\u0000\u0000\u0000\u018e\u017d\u0001\u0000"+
		"\u0000\u0000\u018e\u017e\u0001\u0000\u0000\u0000\u018e\u017f\u0001\u0000"+
		"\u0000\u0000\u018e\u0180\u0001\u0000\u0000\u0000\u018e\u0181\u0001\u0000"+
		"\u0000\u0000\u018e\u0182\u0001\u0000\u0000\u0000\u018e\u0183\u0001\u0000"+
		"\u0000\u0000\u018e\u0188\u0001\u0000\u0000\u0000\u018e\u018b\u0001\u0000"+
		"\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018d\u0001\u0000"+
		"\u0000\u0000\u018f)\u0001\u0000\u0000\u0000\u0190\u0191\u0005/\u0000\u0000"+
		"\u0191\u0193\u0005\u0007\u0000\u0000\u0192\u0194\u00034\u001a\u0000\u0193"+
		"\u0192\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194"+
		"\u0195\u0001\u0000\u0000\u0000\u0195\u0197\u0005\b\u0000\u0000\u0196\u0198"+
		"\u00032\u0019\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0197\u0198\u0001"+
		"\u0000\u0000\u0000\u0198+\u0001\u0000\u0000\u0000\u0199\u019f\u00053\u0000"+
		"\u0000\u019a\u019f\u00054\u0000\u0000\u019b\u019f\u00055\u0000\u0000\u019c"+
		"\u019f\u00056\u0000\u0000\u019d\u019f\u0003.\u0017\u0000\u019e\u0199\u0001"+
		"\u0000\u0000\u0000\u019e\u019a\u0001\u0000\u0000\u0000\u019e\u019b\u0001"+
		"\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019d\u0001"+
		"\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000\u01a0\u019e\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1-\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a4\u0007\u0001"+
		"\u0000\u0000\u01a4/\u0001\u0000\u0000\u0000\u01a5\u01a6\u00050\u0000\u0000"+
		"\u01a6\u01a7\u0003&\u0013\u0000\u01a71\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0005\u0006\u0000\u0000\u01a9\u01aa\u0003@ \u0000\u01aa\u01ab\u0003\u0000"+
		"\u0000\u0000\u01ab\u01ae\u0001\u0000\u0000\u0000\u01ac\u01ae\u0003F#\u0000"+
		"\u01ad\u01a8\u0001\u0000\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ae3\u0001\u0000\u0000\u0000\u01af\u01b4\u00036\u001b\u0000\u01b0\u01b2"+
		"\u0005\u0013\u0000\u0000\u01b1\u01b3\u00036\u001b\u0000\u01b2\u01b1\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b5\u0001"+
		"\u0000\u0000\u0000\u01b4\u01b0\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001"+
		"\u0000\u0000\u0000\u01b55\u0001\u0000\u0000\u0000\u01b6\u01bb\u00038\u001c"+
		"\u0000\u01b7\u01b8\u0005\u0005\u0000\u0000\u01b8\u01ba\u00038\u001c\u0000"+
		"\u01b9\u01b7\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000"+
		"\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01be\u01c0\u0005\u0005\u0000\u0000\u01bf\u01be\u0001\u0000\u0000\u0000"+
		"\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c07\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c3\u0007\u0002\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c6\u0005S\u0000\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01ca"+
		"\u0007\u0003\u0000\u0000\u01c8\u01c9\u0005\t\u0000\u0000\u01c9\u01cb\u0003"+
		"r9\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000"+
		"\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01cd\u0005\u0006\u0000"+
		"\u0000\u01cd\u01cf\u0003R)\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce"+
		"\u01cf\u0001\u0000\u0000\u0000\u01cf9\u0001\u0000\u0000\u0000\u01d0\u01d1"+
		"\u0007\u0004\u0000\u0000\u01d1\u01d4\u0003<\u001e\u0000\u01d2\u01d3\u0005"+
		"\u0006\u0000\u0000\u01d3\u01d5\u0003R)\u0000\u01d4\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5;\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d9\u0005g\u0000\u0000\u01d7\u01d8\u0005\t\u0000\u0000\u01d8"+
		"\u01da\u0003r9\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01d9\u01da\u0001"+
		"\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000\u0000\u01db\u01dd\u0003"+
		"B!\u0000\u01dc\u01d6\u0001\u0000\u0000\u0000\u01dc\u01db\u0001\u0000\u0000"+
		"\u0000\u01dd=\u0001\u0000\u0000\u0000\u01de\u01df\u0003@ \u0000\u01df"+
		"\u01e0\u0003\u0000\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000\u0000\u01e1"+
		"\u01e3\u0003F#\u0000\u01e2\u01de\u0001\u0000\u0000\u0000\u01e2\u01e1\u0001"+
		"\u0000\u0000\u0000\u01e3?\u0001\u0000\u0000\u0000\u01e4\u01e5\u0005;\u0000"+
		"\u0000\u01e5\u01e6\u0003R)\u0000\u01e6\u01e8\u0003N\'\u0000\u01e7\u01e9"+
		"\u0003P(\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000"+
		"\u0000\u0000\u01e9\u0234\u0001\u0000\u0000\u0000\u01ea\u01eb\u0005=\u0000"+
		"\u0000\u01eb\u01ec\u0003R)\u0000\u01ec\u01ee\u0003N\'\u0000\u01ed\u01ef"+
		"\u0003P(\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000"+
		"\u0000\u0000\u01ef\u0234\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005>\u0000"+
		"\u0000\u01f1\u01f2\u0003F#\u0000\u01f2\u01f3\u0005=\u0000\u0000\u01f3"+
		"\u01f5\u0003R)\u0000\u01f4\u01f6\u0003P(\u0000\u01f5\u01f4\u0001\u0000"+
		"\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u0234\u0001\u0000"+
		"\u0000\u0000\u01f7\u01fa\u0005?\u0000\u0000\u01f8\u01fb\u0003:\u001d\u0000"+
		"\u01f9\u01fb\u0003R)\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01f9"+
		"\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fd"+
		"\u0005\u0001\u0000\u0000\u01fd\u01fe\u0003R)\u0000\u01fe\u01ff\u0005\u0001"+
		"\u0000\u0000\u01ff\u0200\u0003R)\u0000\u0200\u0202\u0003N\'\u0000\u0201"+
		"\u0203\u0003P(\u0000\u0202\u0201\u0001\u0000\u0000\u0000\u0202\u0203\u0001"+
		"\u0000\u0000\u0000\u0203\u0234\u0001\u0000\u0000\u0000\u0204\u0205\u0005"+
		"?\u0000\u0000\u0205\u0206\u0005g\u0000\u0000\u0206\u0207\u0005@\u0000"+
		"\u0000\u0207\u0208\u0003Z-\u0000\u0208\u020a\u0003N\'\u0000\u0209\u020b"+
		"\u0003P(\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b\u0234\u0001\u0000\u0000\u0000\u020c\u020d\u0005A\u0000"+
		"\u0000\u020d\u020e\u0003R)\u0000\u020e\u0212\u0005\u0003\u0000\u0000\u020f"+
		"\u0211\u0003H$\u0000\u0210\u020f\u0001\u0000\u0000\u0000\u0211\u0214\u0001"+
		"\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0213\u0001"+
		"\u0000\u0000\u0000\u0213\u0218\u0001\u0000\u0000\u0000\u0214\u0212\u0001"+
		"\u0000\u0000\u0000\u0215\u0216\u0005<\u0000\u0000\u0216\u0217\u0005\u000b"+
		"\u0000\u0000\u0217\u0219\u0003>\u001f\u0000\u0218\u0215\u0001\u0000\u0000"+
		"\u0000\u0218\u0219\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000"+
		"\u0000\u021a\u021b\u0005\u0004\u0000\u0000\u021b\u0234\u0001\u0000\u0000"+
		"\u0000\u021c\u021d\u0005C\u0000\u0000\u021d\u0234\u0003R)\u0000\u021e"+
		"\u021f\u0005D\u0000\u0000\u021f\u0229\u0003F#\u0000\u0220\u0222\u0003"+
		"J%\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000\u0000"+
		"\u0000\u0223\u0221\u0001\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000"+
		"\u0000\u0224\u0226\u0001\u0000\u0000\u0000\u0225\u0227\u0003L&\u0000\u0226"+
		"\u0225\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227"+
		"\u022a\u0001\u0000\u0000\u0000\u0228\u022a\u0003L&\u0000\u0229\u0221\u0001"+
		"\u0000\u0000\u0000\u0229\u0228\u0001\u0000\u0000\u0000\u022a\u0234\u0001"+
		"\u0000\u0000\u0000\u022b\u0234\u0005G\u0000\u0000\u022c\u0234\u0005H\u0000"+
		"\u0000\u022d\u022e\u0005I\u0000\u0000\u022e\u0234\u0003>\u001f\u0000\u022f"+
		"\u0230\u0005J\u0000\u0000\u0230\u0234\u0003R)\u0000\u0231\u0234\u0005"+
		"\u0015\u0000\u0000\u0232\u0234\u0003R)\u0000\u0233\u01e4\u0001\u0000\u0000"+
		"\u0000\u0233\u01ea\u0001\u0000\u0000\u0000\u0233\u01f0\u0001\u0000\u0000"+
		"\u0000\u0233\u01f7\u0001\u0000\u0000\u0000\u0233\u0204\u0001\u0000\u0000"+
		"\u0000\u0233\u020c\u0001\u0000\u0000\u0000\u0233\u021c\u0001\u0000\u0000"+
		"\u0000\u0233\u021e\u0001\u0000\u0000\u0000\u0233\u022b\u0001\u0000\u0000"+
		"\u0000\u0233\u022c\u0001\u0000\u0000\u0000\u0233\u022d\u0001\u0000\u0000"+
		"\u0000\u0233\u022f\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000"+
		"\u0000\u0233\u0232\u0001\u0000\u0000\u0000\u0234A\u0001\u0000\u0000\u0000"+
		"\u0235\u0236\u0005\u0016\u0000\u0000\u0236\u023b\u0003D\"\u0000\u0237"+
		"\u0238\u0005\u0005\u0000\u0000\u0238\u023a\u0003D\"\u0000\u0239\u0237"+
		"\u0001\u0000\u0000\u0000\u023a\u023d\u0001\u0000\u0000\u0000\u023b\u0239"+
		"\u0001\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c\u023f"+
		"\u0001\u0000\u0000\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023e\u0240"+
		"\u0005\u0005\u0000\u0000\u023f\u023e\u0001\u0000\u0000\u0000\u023f\u0240"+
		"\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000\u0000\u0000\u0241\u0242"+
		"\u0005\u0017\u0000\u0000\u0242C\u0001\u0000\u0000\u0000\u0243\u0244\u0005"+
		"S\u0000\u0000\u0244\u024a\u0005g\u0000\u0000\u0245\u0247\u0005\u0016\u0000"+
		"\u0000\u0246\u0248\u0005h\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000"+
		"\u0247\u0248\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000"+
		"\u0249\u024b\u0005\u0017\u0000\u0000\u024a\u0245\u0001\u0000\u0000\u0000"+
		"\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u024f\u0001\u0000\u0000\u0000"+
		"\u024c\u024f\u0005g\u0000\u0000\u024d\u024f\u0005\u0014\u0000\u0000\u024e"+
		"\u0243\u0001\u0000\u0000\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024e"+
		"\u024d\u0001\u0000\u0000\u0000\u024fE\u0001\u0000\u0000\u0000\u0250\u0256"+
		"\u0005\u0003\u0000\u0000\u0251\u0255\u0003F#\u0000\u0252\u0255\u0003\n"+
		"\u0005\u0000\u0253\u0255\u0003@ \u0000\u0254\u0251\u0001\u0000\u0000\u0000"+
		"\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0253\u0001\u0000\u0000\u0000"+
		"\u0255\u0258\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000"+
		"\u0256\u0257\u0001\u0000\u0000\u0000\u0257\u0259\u0001\u0000\u0000\u0000"+
		"\u0258\u0256\u0001\u0000\u0000\u0000\u0259\u025a\u0005\u0004\u0000\u0000"+
		"\u025aG\u0001\u0000\u0000\u0000\u025b\u025c\u0005B\u0000\u0000\u025c\u025f"+
		"\u0003l6\u0000\u025d\u025e\u0005;\u0000\u0000\u025e\u0260\u0003R)\u0000"+
		"\u025f\u025d\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000\u0000\u0000"+
		"\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0262\u0005\u000b\u0000\u0000"+
		"\u0262\u0263\u0003>\u001f\u0000\u0263I\u0001\u0000\u0000\u0000\u0264\u0265"+
		"\u0005E\u0000\u0000\u0265\u0268\u0003|>\u0000\u0266\u0267\u0005X\u0000"+
		"\u0000\u0267\u0269\u0005g\u0000\u0000\u0268\u0266\u0001\u0000\u0000\u0000"+
		"\u0268\u0269\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000"+
		"\u026a\u026b\u0003F#\u0000\u026bK\u0001\u0000\u0000\u0000\u026c\u026d"+
		"\u0005F\u0000\u0000\u026d\u026e\u0003F#\u0000\u026eM\u0001\u0000\u0000"+
		"\u0000\u026f\u0270\u0005\t\u0000\u0000\u0270\u0271\u0003@ \u0000\u0271"+
		"\u0272\u0003\u0000\u0000\u0000\u0272\u0275\u0001\u0000\u0000\u0000\u0273"+
		"\u0275\u0003F#\u0000\u0274\u026f\u0001\u0000\u0000\u0000\u0274\u0273\u0001"+
		"\u0000\u0000\u0000\u0275O\u0001\u0000\u0000\u0000\u0276\u0277\u0005<\u0000"+
		"\u0000\u0277\u0278\u0003N\'\u0000\u0278Q\u0001\u0000\u0000\u0000\u0279"+
		"\u027b\u0006)\uffff\uffff\u0000\u027a\u027c\u0007\u0005\u0000\u0000\u027b"+
		"\u027a\u0001\u0000\u0000\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027c"+
		"\u027d\u0001\u0000\u0000\u0000\u027d\u0295\u0003Z-\u0000\u027e\u027f\u0005"+
		"Z\u0000\u0000\u027f\u0295\u0003R)\u0006\u0280\u0287\u00038\u001c\u0000"+
		"\u0281\u0283\u0005\u0007\u0000\u0000\u0282\u0284\u00034\u001a\u0000\u0283"+
		"\u0282\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000\u0284"+
		"\u0285\u0001\u0000\u0000\u0000\u0285\u0287\u0005\b\u0000\u0000\u0286\u0280"+
		"\u0001\u0000\u0000\u0000\u0286\u0281\u0001\u0000\u0000\u0000\u0287\u0288"+
		"\u0001\u0000\u0000\u0000\u0288\u028a\u0005\u000b\u0000\u0000\u0289\u028b"+
		"\u0003r9\u0000\u028a\u0289\u0001\u0000\u0000\u0000\u028a\u028b\u0001\u0000"+
		"\u0000\u0000\u028b\u028e\u0001\u0000\u0000\u0000\u028c\u028f\u0003F#\u0000"+
		"\u028d\u028f\u0003R)\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028e\u028d"+
		"\u0001\u0000\u0000\u0000\u028f\u0295\u0001\u0000\u0000\u0000\u0290\u0291"+
		"\u0003T*\u0000\u0291\u0292\u0003X,\u0000\u0292\u0293\u0003l6\u0000\u0293"+
		"\u0295\u0001\u0000\u0000\u0000\u0294\u0279\u0001\u0000\u0000\u0000\u0294"+
		"\u027e\u0001\u0000\u0000\u0000\u0294\u0286\u0001\u0000\u0000\u0000\u0294"+
		"\u0290\u0001\u0000\u0000\u0000\u0295\u02d9\u0001\u0000\u0000\u0000\u0296"+
		"\u0297\n\u0011\u0000\u0000\u0297\u0298\u0005\f\u0000\u0000\u0298\u02d8"+
		"\u0003R)\u0012\u0299\u029a\n\u000f\u0000\u0000\u029a\u029b\u0005\r\u0000"+
		"\u0000\u029b\u02d8\u0003R)\u000f\u029c\u029d\n\u000e\u0000\u0000\u029d"+
		"\u029e\u0007\u0006\u0000\u0000\u029e\u02d8\u0003R)\u000f\u029f\u02a0\n"+
		"\r\u0000\u0000\u02a0\u02a1\u0007\u0007\u0000\u0000\u02a1\u02d8\u0003R"+
		")\u000e\u02a2\u02aa\n\f\u0000\u0000\u02a3\u02a4\u0005P\u0000\u0000\u02a4"+
		"\u02ab\u0005P\u0000\u0000\u02a5\u02a6\u0005K\u0000\u0000\u02a6\u02ab\u0005"+
		"K\u0000\u0000\u02a7\u02a8\u0005K\u0000\u0000\u02a8\u02a9\u0005K\u0000"+
		"\u0000\u02a9\u02ab\u0005K\u0000\u0000\u02aa\u02a3\u0001\u0000\u0000\u0000"+
		"\u02aa\u02a5\u0001\u0000\u0000\u0000\u02aa\u02a7\u0001\u0000\u0000\u0000"+
		"\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02d8\u0003R)\r\u02ad\u02ae"+
		"\n\u000b\u0000\u0000\u02ae\u02af\u0005\u0011\u0000\u0000\u02af\u02d8\u0003"+
		"R)\f\u02b0\u02b1\n\n\u0000\u0000\u02b1\u02b2\u0005\u0012\u0000\u0000\u02b2"+
		"\u02d8\u0003R)\u000b\u02b3\u02b4\n\t\u0000\u0000\u02b4\u02b5\u0005\u0013"+
		"\u0000\u0000\u02b5\u02d8\u0003R)\n\u02b6\u02b7\n\b\u0000\u0000\u02b7\u02b8"+
		"\u0007\b\u0000\u0000\u02b8\u02d8\u0003R)\t\u02b9\u02c2\n\u0007\u0000\u0000"+
		"\u02ba\u02bc\u0005Y\u0000\u0000\u02bb\u02bd\u0005Z\u0000\u0000\u02bc\u02bb"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bd\u02c3"+
		"\u0001\u0000\u0000\u0000\u02be\u02c0\u0005Z\u0000\u0000\u02bf\u02be\u0001"+
		"\u0000\u0000\u0000\u02bf\u02c0\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001"+
		"\u0000\u0000\u0000\u02c1\u02c3\u0005@\u0000\u0000\u02c2\u02ba\u0001\u0000"+
		"\u0000\u0000\u02c2\u02bf\u0001\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000"+
		"\u0000\u0000\u02c4\u02d8\u0003R)\b\u02c5\u02c6\n\u0005\u0000\u0000\u02c6"+
		"\u02c7\u0005[\u0000\u0000\u02c7\u02d8\u0003R)\u0006\u02c8\u02c9\n\u0004"+
		"\u0000\u0000\u02c9\u02ca\u0005\\\u0000\u0000\u02ca\u02d8\u0003R)\u0005"+
		"\u02cb\u02cc\n\u0003\u0000\u0000\u02cc\u02cd\u0005\u0018\u0000\u0000\u02cd"+
		"\u02ce\u0003R)\u0000\u02ce\u02cf\u0005\t\u0000\u0000\u02cf\u02d0\u0003"+
		"R)\u0004\u02d0\u02d8\u0001\u0000\u0000\u0000\u02d1\u02d2\n\u0010\u0000"+
		"\u0000\u02d2\u02d4\u0005X\u0000\u0000\u02d3\u02d5\u0005\u0018\u0000\u0000"+
		"\u02d4\u02d3\u0001\u0000\u0000\u0000\u02d4\u02d5\u0001\u0000\u0000\u0000"+
		"\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6\u02d8\u0003r9\u0000\u02d7\u0296"+
		"\u0001\u0000\u0000\u0000\u02d7\u0299\u0001\u0000\u0000\u0000\u02d7\u029c"+
		"\u0001\u0000\u0000\u0000\u02d7\u029f\u0001\u0000\u0000\u0000\u02d7\u02a2"+
		"\u0001\u0000\u0000\u0000\u02d7\u02ad\u0001\u0000\u0000\u0000\u02d7\u02b0"+
		"\u0001\u0000\u0000\u0000\u02d7\u02b3\u0001\u0000\u0000\u0000\u02d7\u02b6"+
		"\u0001\u0000\u0000\u0000\u02d7\u02b9\u0001\u0000\u0000\u0000\u02d7\u02c5"+
		"\u0001\u0000\u0000\u0000\u02d7\u02c8\u0001\u0000\u0000\u0000\u02d7\u02cb"+
		"\u0001\u0000\u0000\u0000\u02d7\u02d1\u0001\u0000\u0000\u0000\u02d8\u02db"+
		"\u0001\u0000\u0000\u0000\u02d9\u02d7\u0001\u0000\u0000\u0000\u02d9\u02da"+
		"\u0001\u0000\u0000\u0000\u02daS\u0001\u0000\u0000\u0000\u02db\u02d9\u0001"+
		"\u0000\u0000\u0000\u02dc\u02e1\u0003V+\u0000\u02dd\u02de\u0005\u0005\u0000"+
		"\u0000\u02de\u02e0\u0003V+\u0000\u02df\u02dd\u0001\u0000\u0000\u0000\u02e0"+
		"\u02e3\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000\u0000\u02e1"+
		"\u02e2\u0001\u0000\u0000\u0000\u02e2\u02e5\u0001\u0000\u0000\u0000\u02e3"+
		"\u02e1\u0001\u0000\u0000\u0000\u02e4\u02e6\u0005\u0005\u0000\u0000\u02e5"+
		"\u02e4\u0001\u0000\u0000\u0000\u02e5\u02e6\u0001\u0000\u0000\u0000\u02e6"+
		"U\u0001\u0000\u0000\u0000\u02e7\u02ea\u0003Z-\u0000\u02e8\u02ea\u0003"+
		"B!\u0000\u02e9\u02e7\u0001\u0000\u0000\u0000\u02e9\u02e8\u0001\u0000\u0000"+
		"\u0000\u02eaW\u0001\u0000\u0000\u0000\u02eb\u02ec\u0007\t\u0000\u0000"+
		"\u02ecY\u0001\u0000\u0000\u0000\u02ed\u02ee\u0006-\uffff\uffff\u0000\u02ee"+
		"\u02ef\u0003d2\u0000\u02ef\u030a\u0001\u0000\u0000\u0000\u02f0\u02f2\n"+
		"\u0005\u0000\u0000\u02f1\u02f3\u0005\u0018\u0000\u0000\u02f2\u02f1\u0001"+
		"\u0000\u0000\u0000\u02f2\u02f3\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001"+
		"\u0000\u0000\u0000\u02f4\u02f5\u0005\u0002\u0000\u0000\u02f5\u0309\u0005"+
		"g\u0000\u0000\u02f6\u02f7\n\u0004\u0000\u0000\u02f7\u02f8\u0005P\u0000"+
		"\u0000\u02f8\u02f9\u0003t:\u0000\u02f9\u02fa\u0005K\u0000\u0000\u02fa"+
		"\u0309\u0001\u0000\u0000\u0000\u02fb\u02fc\n\u0003\u0000\u0000\u02fc\u02fe"+
		"\u0005\u0007\u0000\u0000\u02fd\u02ff\u0003\\.\u0000\u02fe\u02fd\u0001"+
		"\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff\u0300\u0001"+
		"\u0000\u0000\u0000\u0300\u0309\u0005\b\u0000\u0000\u0301\u0302\n\u0002"+
		"\u0000\u0000\u0302\u0303\u0005\u0016\u0000\u0000\u0303\u0304\u0003`0\u0000"+
		"\u0304\u0305\u0005\u0017\u0000\u0000\u0305\u0309\u0001\u0000\u0000\u0000"+
		"\u0306\u0307\n\u0001\u0000\u0000\u0307\u0309\u0003F#\u0000\u0308\u02f0"+
		"\u0001\u0000\u0000\u0000\u0308\u02f6\u0001\u0000\u0000\u0000\u0308\u02fb"+
		"\u0001\u0000\u0000\u0000\u0308\u0301\u0001\u0000\u0000\u0000\u0308\u0306"+
		"\u0001\u0000\u0000\u0000\u0309\u030c\u0001\u0000\u0000\u0000\u030a\u0308"+
		"\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b[\u0001"+
		"\u0000\u0000\u0000\u030c\u030a\u0001\u0000\u0000\u0000\u030d\u0312\u0003"+
		"^/\u0000\u030e\u030f\u0005\u0005\u0000\u0000\u030f\u0311\u0003^/\u0000"+
		"\u0310\u030e\u0001\u0000\u0000\u0000\u0311\u0314\u0001\u0000\u0000\u0000"+
		"\u0312\u0310\u0001\u0000\u0000\u0000\u0312\u0313\u0001\u0000\u0000\u0000"+
		"\u0313\u0316\u0001\u0000\u0000\u0000\u0314\u0312\u0001\u0000\u0000\u0000"+
		"\u0315\u0317\u0005\u0005\u0000\u0000\u0316\u0315\u0001\u0000\u0000\u0000"+
		"\u0316\u0317\u0001\u0000\u0000\u0000\u0317]\u0001\u0000\u0000\u0000\u0318"+
		"\u0319\u0005g\u0000\u0000\u0319\u031b\u0005\t\u0000\u0000\u031a\u0318"+
		"\u0001\u0000\u0000\u0000\u031a\u031b\u0001\u0000\u0000\u0000\u031b\u031e"+
		"\u0001\u0000\u0000\u0000\u031c\u031f\u0003R)\u0000\u031d\u031f\u0005\u0014"+
		"\u0000\u0000\u031e\u031c\u0001\u0000\u0000\u0000\u031e\u031d\u0001\u0000"+
		"\u0000\u0000\u031f_\u0001\u0000\u0000\u0000\u0320\u0325\u0003b1\u0000"+
		"\u0321\u0322\u0005\u0005\u0000\u0000\u0322\u0324\u0003b1\u0000\u0323\u0321"+
		"\u0001\u0000\u0000\u0000\u0324\u0327\u0001\u0000\u0000\u0000\u0325\u0323"+
		"\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000\u0326\u0329"+
		"\u0001\u0000\u0000\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0328\u032a"+
		"\u0005\u0005\u0000\u0000\u0329\u0328\u0001\u0000\u0000\u0000\u0329\u032a"+
		"\u0001\u0000\u0000\u0000\u032aa\u0001\u0000\u0000\u0000\u032b\u033a\u0003"+
		"R)\u0000\u032c\u032e\u0003R)\u0000\u032d\u032c\u0001\u0000\u0000\u0000"+
		"\u032d\u032e\u0001\u0000\u0000\u0000\u032e\u032f\u0001\u0000\u0000\u0000"+
		"\u032f\u0331\u0005\t\u0000\u0000\u0330\u0332\u0003R)\u0000\u0331\u0330"+
		"\u0001\u0000\u0000\u0000\u0331\u0332\u0001\u0000\u0000\u0000\u0332\u0337"+
		"\u0001\u0000\u0000\u0000\u0333\u0335\u0005\t\u0000\u0000\u0334\u0336\u0003"+
		"R)\u0000\u0335\u0334\u0001\u0000\u0000\u0000\u0335\u0336\u0001\u0000\u0000"+
		"\u0000\u0336\u0338\u0001\u0000\u0000\u0000\u0337\u0333\u0001\u0000\u0000"+
		"\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338\u033a\u0001\u0000\u0000"+
		"\u0000\u0339\u032b\u0001\u0000\u0000\u0000\u0339\u032d\u0001\u0000\u0000"+
		"\u0000\u033ac\u0001\u0000\u0000\u0000\u033b\u035e\u0003f3\u0000\u033c"+
		"\u035e\u0003j5\u0000\u033d\u0342\u0005]\u0000\u0000\u033e\u033f\u0005"+
		"\u0016\u0000\u0000\u033f\u0340\u0003\b\u0004\u0000\u0340\u0341\u0005\u0017"+
		"\u0000\u0000\u0341\u0343\u0001\u0000\u0000\u0000\u0342\u033e\u0001\u0000"+
		"\u0000\u0000\u0342\u0343\u0001\u0000\u0000\u0000\u0343\u035e\u0001\u0000"+
		"\u0000\u0000\u0344\u035e\u0005^\u0000\u0000\u0345\u0346\u0005\u0007\u0000"+
		"\u0000\u0346\u0347\u0003R)\u0000\u0347\u0348\u0005\b\u0000\u0000\u0348"+
		"\u035e\u0001\u0000\u0000\u0000\u0349\u034b\u0005\u0007\u0000\u0000\u034a"+
		"\u034c\u0003l6\u0000\u034b\u034a\u0001\u0000\u0000\u0000\u034b\u034c\u0001"+
		"\u0000\u0000\u0000\u034c\u034d\u0001\u0000\u0000\u0000\u034d\u035e\u0005"+
		"\b\u0000\u0000\u034e\u034f\u0005\u0003\u0000\u0000\u034f\u0350\u0003l"+
		"6\u0000\u0350\u0351\u0005\u0004\u0000\u0000\u0351\u035e\u0001\u0000\u0000"+
		"\u0000\u0352\u0354\u0005\u0003\u0000\u0000\u0353\u0355\u0003n7\u0000\u0354"+
		"\u0353\u0001\u0000\u0000\u0000\u0354\u0355\u0001\u0000\u0000\u0000\u0355"+
		"\u0356\u0001\u0000\u0000\u0000\u0356\u035e\u0005\u0004\u0000\u0000\u0357"+
		"\u0359\u0005\u0016\u0000\u0000\u0358\u035a\u0003l6\u0000\u0359\u0358\u0001"+
		"\u0000\u0000\u0000\u0359\u035a\u0001\u0000\u0000\u0000\u035a\u035b\u0001"+
		"\u0000\u0000\u0000\u035b\u035e\u0005\u0017\u0000\u0000\u035c\u035e\u0003"+
		"r9\u0000\u035d\u033b\u0001\u0000\u0000\u0000\u035d\u033c\u0001\u0000\u0000"+
		"\u0000\u035d\u033d\u0001\u0000\u0000\u0000\u035d\u0344\u0001\u0000\u0000"+
		"\u0000\u035d\u0345\u0001\u0000\u0000\u0000\u035d\u0349\u0001\u0000\u0000"+
		"\u0000\u035d\u034e\u0001\u0000\u0000\u0000\u035d\u0352\u0001\u0000\u0000"+
		"\u0000\u035d\u0357\u0001\u0000\u0000\u0000\u035d\u035c\u0001\u0000\u0000"+
		"\u0000\u035ee\u0001\u0000\u0000\u0000\u035f\u0364\u0005_\u0000\u0000\u0360"+
		"\u0364\u0005`\u0000\u0000\u0361\u0364\u0005a\u0000\u0000\u0362\u0364\u0003"+
		"h4\u0000\u0363\u035f\u0001\u0000\u0000\u0000\u0363\u0360\u0001\u0000\u0000"+
		"\u0000\u0363\u0361\u0001\u0000\u0000\u0000\u0363\u0362\u0001\u0000\u0000"+
		"\u0000\u0364g\u0001\u0000\u0000\u0000\u0365\u0366\u0007\n\u0000\u0000"+
		"\u0366i\u0001\u0000\u0000\u0000\u0367\u036a\u0005b\u0000\u0000\u0368\u0369"+
		"\u0005\t\u0000\u0000\u0369\u036b\u0003r9\u0000\u036a\u0368\u0001\u0000"+
		"\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000"+
		"\u0000\u0000\u036c\u0370\u0005\u0003\u0000\u0000\u036d\u036f\u0003\"\u0011"+
		"\u0000\u036e\u036d\u0001\u0000\u0000\u0000\u036f\u0372\u0001\u0000\u0000"+
		"\u0000\u0370\u036e\u0001\u0000\u0000\u0000\u0370\u0371\u0001\u0000\u0000"+
		"\u0000\u0371\u0373\u0001\u0000\u0000\u0000\u0372\u0370\u0001\u0000\u0000"+
		"\u0000\u0373\u0374\u0005\u0004\u0000\u0000\u0374k\u0001\u0000\u0000\u0000"+
		"\u0375\u037a\u0003R)\u0000\u0376\u0377\u0005\u0005\u0000\u0000\u0377\u0379"+
		"\u0003R)\u0000\u0378\u0376\u0001\u0000\u0000\u0000\u0379\u037c\u0001\u0000"+
		"\u0000\u0000\u037a\u0378\u0001\u0000\u0000\u0000\u037a\u037b\u0001\u0000"+
		"\u0000\u0000\u037b\u037e\u0001\u0000\u0000\u0000\u037c\u037a\u0001\u0000"+
		"\u0000\u0000\u037d\u037f\u0005\u0005\u0000\u0000\u037e\u037d\u0001\u0000"+
		"\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037fm\u0001\u0000\u0000"+
		"\u0000\u0380\u0385\u0003p8\u0000\u0381\u0382\u0005\u0005\u0000\u0000\u0382"+
		"\u0384\u0003p8\u0000\u0383\u0381\u0001\u0000\u0000\u0000\u0384\u0387\u0001"+
		"\u0000\u0000\u0000\u0385\u0383\u0001\u0000\u0000\u0000\u0385\u0386\u0001"+
		"\u0000\u0000\u0000\u0386\u0389\u0001\u0000\u0000\u0000\u0387\u0385\u0001"+
		"\u0000\u0000\u0000\u0388\u038a\u0005\u0005\u0000\u0000\u0389\u0388\u0001"+
		"\u0000\u0000\u0000\u0389\u038a\u0001\u0000\u0000\u0000\u038ao\u0001\u0000"+
		"\u0000\u0000\u038b\u038c\u0003d2\u0000\u038c\u038d\u0005\t\u0000\u0000"+
		"\u038d\u038e\u0003R)\u0000\u038eq\u0001\u0000\u0000\u0000\u038f\u0390"+
		"\u00069\uffff\uffff\u0000\u0390\u0395\u0003\b\u0004\u0000\u0391\u0392"+
		"\u0005P\u0000\u0000\u0392\u0393\u0003t:\u0000\u0393\u0394\u0005K\u0000"+
		"\u0000\u0394\u0396\u0001\u0000\u0000\u0000\u0395\u0391\u0001\u0000\u0000"+
		"\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396\u03ac\u0001\u0000\u0000"+
		"\u0000\u0397\u0398\u0005\u0007\u0000\u0000\u0398\u0399\u0003x<\u0000\u0399"+
		"\u039a\u0005\b\u0000\u0000\u039a\u039b\u0005\u000b\u0000\u0000\u039b\u039c"+
		"\u0003r9\u0004\u039c\u03ac\u0001\u0000\u0000\u0000\u039d\u03ac\u0005c"+
		"\u0000\u0000\u039e\u03a4\u0005b\u0000\u0000\u039f\u03a1\u0005\u0003\u0000"+
		"\u0000\u03a0\u03a2\u0003~?\u0000\u03a1\u03a0\u0001\u0000\u0000\u0000\u03a1"+
		"\u03a2\u0001\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000\u03a3"+
		"\u03a5\u0005\u0004\u0000\u0000\u03a4\u039f\u0001\u0000\u0000\u0000\u03a4"+
		"\u03a5\u0001\u0000\u0000\u0000\u03a5\u03ac\u0001\u0000\u0000\u0000\u03a6"+
		"\u03a7\u0005d\u0000\u0000\u03a7\u03a8\u0005\u0007\u0000\u0000\u03a8\u03a9"+
		"\u0003R)\u0000\u03a9\u03aa\u0005\b\u0000\u0000\u03aa\u03ac\u0001\u0000"+
		"\u0000\u0000\u03ab\u038f\u0001\u0000\u0000\u0000\u03ab\u0397\u0001\u0000"+
		"\u0000\u0000\u03ab\u039d\u0001\u0000\u0000\u0000\u03ab\u039e\u0001\u0000"+
		"\u0000\u0000\u03ab\u03a6\u0001\u0000\u0000\u0000\u03ac\u03b7\u0001\u0000"+
		"\u0000\u0000\u03ad\u03ae\n\u0007\u0000\u0000\u03ae\u03af\u0005\u0011\u0000"+
		"\u0000\u03af\u03b6\u0003r9\b\u03b0\u03b1\n\u0006\u0000\u0000\u03b1\u03b2"+
		"\u0005\u0013\u0000\u0000\u03b2\u03b6\u0003r9\u0007\u03b3\u03b4\n\b\u0000"+
		"\u0000\u03b4\u03b6\u0005\u0018\u0000\u0000\u03b5\u03ad\u0001\u0000\u0000"+
		"\u0000\u03b5\u03b0\u0001\u0000\u0000\u0000\u03b5\u03b3\u0001\u0000\u0000"+
		"\u0000\u03b6\u03b9\u0001\u0000\u0000\u0000\u03b7\u03b5\u0001\u0000\u0000"+
		"\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8s\u0001\u0000\u0000\u0000"+
		"\u03b9\u03b7\u0001\u0000\u0000\u0000\u03ba\u03bf\u0003v;\u0000\u03bb\u03bc"+
		"\u0005\u0005\u0000\u0000\u03bc\u03be\u0003v;\u0000\u03bd\u03bb\u0001\u0000"+
		"\u0000\u0000\u03be\u03c1\u0001\u0000\u0000\u0000\u03bf\u03bd\u0001\u0000"+
		"\u0000\u0000\u03bf\u03c0\u0001\u0000\u0000\u0000\u03c0\u03c3\u0001\u0000"+
		"\u0000\u0000\u03c1\u03bf\u0001\u0000\u0000\u0000\u03c2\u03c4\u0005\u0005"+
		"\u0000\u0000\u03c3\u03c2\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000"+
		"\u0000\u0000\u03c4u\u0001\u0000\u0000\u0000\u03c5\u03c7\u0007\u0000\u0000"+
		"\u0000\u03c6\u03c5\u0001\u0000\u0000\u0000\u03c6\u03c7\u0001\u0000\u0000"+
		"\u0000\u03c7\u03c8\u0001\u0000\u0000\u0000\u03c8\u03c9\u0003r9\u0000\u03c9"+
		"w\u0001\u0000\u0000\u0000\u03ca\u03cf\u0003z=\u0000\u03cb\u03cc\u0005"+
		"\u0005\u0000\u0000\u03cc\u03ce\u0003z=\u0000\u03cd\u03cb\u0001\u0000\u0000"+
		"\u0000\u03ce\u03d1\u0001\u0000\u0000\u0000\u03cf\u03cd\u0001\u0000\u0000"+
		"\u0000\u03cf\u03d0\u0001\u0000\u0000\u0000\u03d0\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d1\u03cf\u0001\u0000\u0000\u0000\u03d2\u03d4\u0005\u0005\u0000"+
		"\u0000\u03d3\u03d2\u0001\u0000\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000"+
		"\u0000\u03d4y\u0001\u0000\u0000\u0000\u03d5\u03d7\u0005S\u0000\u0000\u03d6"+
		"\u03d5\u0001\u0000\u0000\u0000\u03d6\u03d7\u0001\u0000\u0000\u0000\u03d7"+
		"\u03d8\u0001\u0000\u0000\u0000\u03d8\u03d9\u0003r9\u0000\u03d9{\u0001"+
		"\u0000\u0000\u0000\u03da\u03df\u0003r9\u0000\u03db\u03dc\u0005\u0005\u0000"+
		"\u0000\u03dc\u03de\u0003r9\u0000\u03dd\u03db\u0001\u0000\u0000\u0000\u03de"+
		"\u03e1\u0001\u0000\u0000\u0000\u03df\u03dd\u0001\u0000\u0000\u0000\u03df"+
		"\u03e0\u0001\u0000\u0000\u0000\u03e0\u03e3\u0001\u0000\u0000\u0000\u03e1"+
		"\u03df\u0001\u0000\u0000\u0000\u03e2\u03e4\u0005\u0005\u0000\u0000\u03e3"+
		"\u03e2\u0001\u0000\u0000\u0000\u03e3\u03e4\u0001\u0000\u0000\u0000\u03e4"+
		"}\u0001\u0000\u0000\u0000\u03e5\u03ea\u0003\u0080@\u0000\u03e6\u03e7\u0005"+
		"\u0005\u0000\u0000\u03e7\u03e9\u0003\u0080@\u0000\u03e8\u03e6\u0001\u0000"+
		"\u0000\u0000\u03e9\u03ec\u0001\u0000\u0000\u0000\u03ea\u03e8\u0001\u0000"+
		"\u0000\u0000\u03ea\u03eb\u0001\u0000\u0000\u0000\u03eb\u03ee\u0001\u0000"+
		"\u0000\u0000\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ed\u03ef\u0005\u0005"+
		"\u0000\u0000\u03ee\u03ed\u0001\u0000\u0000\u0000\u03ee\u03ef\u0001\u0000"+
		"\u0000\u0000\u03ef\u007f\u0001\u0000\u0000\u0000\u03f0\u03f3\u0005g\u0000"+
		"\u0000\u03f1\u03f2\u0005\t\u0000\u0000\u03f2\u03f4\u0003r9\u0000\u03f3"+
		"\u03f1\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001\u0000\u0000\u0000\u03f4"+
		"\u0081\u0001\u0000\u0000\u0000\u008f\u0085\u0089\u008e\u0094\u00a1\u00aa"+
		"\u00b6\u00bc\u00c4\u00c9\u00d0\u00d4\u00db\u00de\u00e4\u00e8\u00ee\u00f2"+
		"\u00f8\u00fe\u0102\u0108\u010c\u0112\u0116\u011d\u0121\u0128\u012f\u0136"+
		"\u013a\u013d\u0142\u0146\u014f\u0154\u0159\u0160\u0164\u0169\u016c\u0185"+
		"\u0188\u018e\u0193\u0197\u019e\u01a0\u01ad\u01b2\u01b4\u01bb\u01bf\u01c2"+
		"\u01c5\u01ca\u01ce\u01d4\u01d9\u01dc\u01e2\u01e8\u01ee\u01f5\u01fa\u0202"+
		"\u020a\u0212\u0218\u0223\u0226\u0229\u0233\u023b\u023f\u0247\u024a\u024e"+
		"\u0254\u0256\u025f\u0268\u0274\u027b\u0283\u0286\u028a\u028e\u0294\u02aa"+
		"\u02bc\u02bf\u02c2\u02d4\u02d7\u02d9\u02e1\u02e5\u02e9\u02f2\u02fe\u0308"+
		"\u030a\u0312\u0316\u031a\u031e\u0325\u0329\u032d\u0331\u0335\u0337\u0339"+
		"\u0342\u034b\u0354\u0359\u035d\u0363\u036a\u0370\u037a\u037e\u0385\u0389"+
		"\u0395\u03a1\u03a4\u03ab\u03b5\u03b7\u03bf\u03c3\u03c6\u03cf\u03d3\u03d6"+
		"\u03df\u03e3\u03ea\u03ee\u03f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}