// Generated from C:/Users/mihnea.tudor/OneDrive - Universitatea Politehnica Bucuresti/ACS Cursuri/Anul 4/Semestrul 1/CPL Compilatoare/Homework/Tema 2/Schelet + checker - IntelliJ/Tema2/src/cool/parser/CoolParser.g4 by ANTLR 4.13.1

    package cool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, CLASS=2, ELSE=3, FALSE=4, FI=5, IF=6, IN=7, INHERITS=8, ISVOID=9, 
		LET=10, LOOP=11, POOL=12, THEN=13, WHILE=14, CASE=15, ESAC=16, NEW=17, 
		OF=18, NOT=19, TRUE=20, SEMICOLON=21, COLON=22, COMMA=23, AT=24, ASSIGN=25, 
		DOT=26, RESULTS=27, LPAREN=28, RPAREN=29, LBRACE=30, RBRACE=31, PLUS=32, 
		MINUS=33, STAR=34, SLASH=35, INVERSE=36, LT=37, LE=38, EQ=39, INT=40, 
		TYPE_ID=41, OBJECT_ID=42, STRING=43, SINGLE_LINE_COMMENT=44, MULTI_LINE_COMMENT=45, 
		ERR_UNOPENED_COMMENT=46, WS=47, INVALID_CHARACTER=48;
	public static final int
		RULE_program = 0, RULE_class = 1, RULE_feature = 2, RULE_method = 3, RULE_attribute = 4, 
		RULE_formal = 5, RULE_expr = 6, RULE_localVarDef = 7, RULE_caseBranch = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class", "feature", "method", "attribute", "formal", "expr", 
			"localVarDef", "caseBranch"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "';'", "':'", "','", 
			"'@'", "'<-'", "'.'", "'=>'", "'('", "')'", "'{'", "'}'", "'+'", "'-'", 
			"'*'", "'/'", "'~'", "'<'", "'<='", "'='", null, null, null, null, null, 
			null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ERROR", "CLASS", "ELSE", "FALSE", "FI", "IF", "IN", "INHERITS", 
			"ISVOID", "LET", "LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "NEW", 
			"OF", "NOT", "TRUE", "SEMICOLON", "COLON", "COMMA", "AT", "ASSIGN", "DOT", 
			"RESULTS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "PLUS", "MINUS", "STAR", 
			"SLASH", "INVERSE", "LT", "LE", "EQ", "INT", "TYPE_ID", "OBJECT_ID", 
			"STRING", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "ERR_UNOPENED_COMMENT", 
			"WS", "INVALID_CHARACTER"
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
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				class_();
				setState(19);
				match(SEMICOLON);
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(25);
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
	public static class ClassContext extends ParserRuleContext {
		public Token this_;
		public Token parent;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> TYPE_ID() { return getTokens(CoolParser.TYPE_ID); }
		public TerminalNode TYPE_ID(int i) {
			return getToken(CoolParser.TYPE_ID, i);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(CLASS);
			setState(28);
			((ClassContext)_localctx).this_ = match(TYPE_ID);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(29);
				match(INHERITS);
				setState(30);
				((ClassContext)_localctx).parent = match(TYPE_ID);
				}
			}

			setState(33);
			match(LBRACE);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_ID) {
				{
				{
				setState(34);
				feature();
				setState(35);
				match(SEMICOLON);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(RBRACE);
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
	public static class FeatureContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				attribute();
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
	public static class MethodContext extends ParserRuleContext {
		public FormalContext formal;
		public List<FormalContext> defs = new ArrayList<FormalContext>();
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(OBJECT_ID);
			setState(49);
			match(LPAREN);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OBJECT_ID) {
				{
				setState(50);
				((MethodContext)_localctx).formal = formal();
				((MethodContext)_localctx).defs.add(((MethodContext)_localctx).formal);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(51);
					match(COMMA);
					setState(52);
					((MethodContext)_localctx).formal = formal();
					((MethodContext)_localctx).defs.add(((MethodContext)_localctx).formal);
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(60);
			match(RPAREN);
			setState(61);
			match(COLON);
			setState(62);
			match(TYPE_ID);
			setState(63);
			match(LBRACE);
			setState(64);
			expr(0);
			setState(65);
			match(RBRACE);
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
	public static class AttributeContext extends ParserRuleContext {
		public ExprContext init;
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(OBJECT_ID);
			setState(68);
			match(COLON);
			setState(69);
			match(TYPE_ID);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(70);
				match(ASSIGN);
				setState(71);
				((AttributeContext)_localctx).init = expr(0);
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
	public static class FormalContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(OBJECT_ID);
			setState(75);
			match(COLON);
			setState(76);
			match(TYPE_ID);
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
	public static class NewContext extends ExprContext {
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusMinusContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public PlusMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvertContext extends ExprContext {
		public TerminalNode INVERSE() { return getToken(CoolParser.INVERSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InvertContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterInvert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitInvert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitInvert(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(CoolParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(CoolParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CoolParser.FALSE, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjValContext extends ExprContext {
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public ObjValContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterObjVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitObjVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitObjVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExprContext {
		public ExprContext cond;
		public ExprContext body;
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImplicitDispatchContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> params = new ArrayList<ExprContext>();
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ImplicitDispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterImplicitDispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitImplicitDispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitImplicitDispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CoolParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(CoolParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(CoolParser.SLASH, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public ParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsVoidContext extends ExprContext {
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsVoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIsVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIsVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIsVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitDispatchContext extends ExprContext {
		public ExprContext obj;
		public ExprContext expr;
		public List<ExprContext> params = new ArrayList<ExprContext>();
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AT() { return getToken(CoolParser.AT, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ExplicitDispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterExplicitDispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitExplicitDispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExplicitDispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanOpContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode EQ() { return getToken(CoolParser.EQ, 0); }
		public BooleanOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBooleanOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBooleanOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBooleanOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ExprContext {
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public LocalVarDefContext localVarDef;
		public List<LocalVarDefContext> defs = new ArrayList<LocalVarDefContext>();
		public ExprContext body;
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public List<LocalVarDefContext> localVarDef() {
			return getRuleContexts(LocalVarDefContext.class);
		}
		public LocalVarDefContext localVarDef(int i) {
			return getRuleContext(LocalVarDefContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public ExprContext cond;
		public ExprContext then;
		public ExprContext else_;
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ExprContext {
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public List<CaseBranchContext> caseBranch() {
			return getRuleContexts(CaseBranchContext.class);
		}
		public CaseBranchContext caseBranch(int i) {
			return getRuleContext(CaseBranchContext.class,i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ImplicitDispatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(79);
				match(OBJECT_ID);
				setState(80);
				match(LPAREN);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14363714569808L) != 0)) {
					{
					setState(81);
					((ImplicitDispatchContext)_localctx).expr = expr(0);
					((ImplicitDispatchContext)_localctx).params.add(((ImplicitDispatchContext)_localctx).expr);
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(82);
						match(COMMA);
						setState(83);
						((ImplicitDispatchContext)_localctx).expr = expr(0);
						((ImplicitDispatchContext)_localctx).params.add(((ImplicitDispatchContext)_localctx).expr);
						}
						}
						setState(88);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(91);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(IF);
				setState(93);
				((IfContext)_localctx).cond = expr(0);
				setState(94);
				match(THEN);
				setState(95);
				((IfContext)_localctx).then = expr(0);
				setState(96);
				match(ELSE);
				setState(97);
				((IfContext)_localctx).else_ = expr(0);
				setState(98);
				match(FI);
				}
				break;
			case 3:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(WHILE);
				setState(101);
				((WhileContext)_localctx).cond = expr(0);
				setState(102);
				match(LOOP);
				setState(103);
				((WhileContext)_localctx).body = expr(0);
				setState(104);
				match(POOL);
				}
				break;
			case 4:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(LBRACE);
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(107);
					expr(0);
					setState(108);
					match(SEMICOLON);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 14363714569808L) != 0) );
				setState(114);
				match(RBRACE);
				}
				break;
			case 5:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(LET);
				setState(117);
				((LetContext)_localctx).localVarDef = localVarDef();
				((LetContext)_localctx).defs.add(((LetContext)_localctx).localVarDef);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(118);
					match(COMMA);
					setState(119);
					((LetContext)_localctx).localVarDef = localVarDef();
					((LetContext)_localctx).defs.add(((LetContext)_localctx).localVarDef);
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(IN);
				setState(126);
				((LetContext)_localctx).body = expr(15);
				}
				break;
			case 6:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(CASE);
				setState(129);
				expr(0);
				setState(130);
				match(OF);
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					caseBranch();
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OBJECT_ID );
				setState(136);
				match(ESAC);
				}
				break;
			case 7:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(NEW);
				setState(139);
				match(TYPE_ID);
				}
				break;
			case 8:
				{
				_localctx = new InvertContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(INVERSE);
				setState(141);
				expr(12);
				}
				break;
			case 9:
				{
				_localctx = new IsVoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(ISVOID);
				setState(143);
				expr(11);
				}
				break;
			case 10:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(NOT);
				setState(145);
				expr(7);
				}
				break;
			case 11:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(OBJECT_ID);
				setState(147);
				match(ASSIGN);
				setState(148);
				expr(6);
				}
				break;
			case 12:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(LPAREN);
				setState(150);
				expr(0);
				setState(151);
				match(RPAREN);
				}
				break;
			case 13:
				{
				_localctx = new ObjValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(OBJECT_ID);
				}
				break;
			case 14:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(INT);
				}
				break;
			case 15:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(STRING);
				}
				break;
			case 16:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(187);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						((MulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(160);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						((MulDivContext)_localctx).right = expr(11);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusContext(new ExprContext(_parentctx, _parentState));
						((PlusMinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(163);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						((PlusMinusContext)_localctx).right = expr(10);
						}
						break;
					case 3:
						{
						_localctx = new BooleanOpContext(new ExprContext(_parentctx, _parentState));
						((BooleanOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(166);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 962072674304L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						((BooleanOpContext)_localctx).right = expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ExplicitDispatchContext(new ExprContext(_parentctx, _parentState));
						((ExplicitDispatchContext)_localctx).obj = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(169);
							match(AT);
							setState(170);
							match(TYPE_ID);
							}
						}

						setState(173);
						match(DOT);
						setState(174);
						match(OBJECT_ID);
						setState(175);
						match(LPAREN);
						setState(184);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14363714569808L) != 0)) {
							{
							setState(176);
							((ExplicitDispatchContext)_localctx).expr = expr(0);
							((ExplicitDispatchContext)_localctx).params.add(((ExplicitDispatchContext)_localctx).expr);
							setState(181);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(177);
								match(COMMA);
								setState(178);
								((ExplicitDispatchContext)_localctx).expr = expr(0);
								((ExplicitDispatchContext)_localctx).params.add(((ExplicitDispatchContext)_localctx).expr);
								}
								}
								setState(183);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(186);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	public static class LocalVarDefContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocalVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLocalVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLocalVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLocalVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDefContext localVarDef() throws RecognitionException {
		LocalVarDefContext _localctx = new LocalVarDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localVarDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(OBJECT_ID);
			setState(193);
			match(COLON);
			setState(194);
			match(TYPE_ID);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(195);
				match(ASSIGN);
				setState(196);
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
	public static class CaseBranchContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(CoolParser.OBJECT_ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE_ID() { return getToken(CoolParser.TYPE_ID, 0); }
		public TerminalNode RESULTS() { return getToken(CoolParser.RESULTS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CoolParser.SEMICOLON, 0); }
		public CaseBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCaseBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCaseBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCaseBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBranchContext caseBranch() throws RecognitionException {
		CaseBranchContext _localctx = new CaseBranchContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_caseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(OBJECT_ID);
			setState(200);
			match(COLON);
			setState(201);
			match(TYPE_ID);
			setState(202);
			match(RESULTS);
			setState(203);
			expr(0);
			setState(204);
			match(SEMICOLON);
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u00cf\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0016\b\u0000"+
		"\u000b\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002/\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"6\b\u0003\n\u0003\f\u00039\t\u0003\u0003\u0003;\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004I\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006U\b"+
		"\u0006\n\u0006\f\u0006X\t\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006o\b\u0006\u000b\u0006\f\u0006p\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006y\b\u0006\n\u0006\f\u0006"+
		"|\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006\u0085\b\u0006\u000b\u0006\f\u0006"+
		"\u0086\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009e\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00ac\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00b4\b\u0006\n\u0006\f\u0006\u00b7\t\u0006"+
		"\u0003\u0006\u00b9\b\u0006\u0001\u0006\u0005\u0006\u00bc\b\u0006\n\u0006"+
		"\f\u0006\u00bf\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00c6\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0000\u0001\f\t\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0000\u0004\u0002\u0000\u0004\u0004\u0014\u0014\u0001"+
		"\u0000\"#\u0001\u0000 !\u0001\u0000%\'\u00e8\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000"+
		"\u00060\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nJ\u0001\u0000"+
		"\u0000\u0000\f\u009d\u0001\u0000\u0000\u0000\u000e\u00c0\u0001\u0000\u0000"+
		"\u0000\u0010\u00c7\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001"+
		"\u0000\u0013\u0014\u0005\u0015\u0000\u0000\u0014\u0016\u0001\u0000\u0000"+
		"\u0000\u0015\u0012\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0000\u0000"+
		"\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0002\u0000"+
		"\u0000\u001c\u001f\u0005)\u0000\u0000\u001d\u001e\u0005\b\u0000\u0000"+
		"\u001e \u0005)\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f "+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\'\u0005\u001e\u0000"+
		"\u0000\"#\u0003\u0004\u0002\u0000#$\u0005\u0015\u0000\u0000$&\u0001\u0000"+
		"\u0000\u0000%\"\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000*+\u0005\u001f\u0000\u0000+\u0003\u0001\u0000"+
		"\u0000\u0000,/\u0003\u0006\u0003\u0000-/\u0003\b\u0004\u0000.,\u0001\u0000"+
		"\u0000\u0000.-\u0001\u0000\u0000\u0000/\u0005\u0001\u0000\u0000\u0000"+
		"01\u0005*\u0000\u00001:\u0005\u001c\u0000\u000027\u0003\n\u0005\u0000"+
		"34\u0005\u0017\u0000\u000046\u0003\n\u0005\u000053\u0001\u0000\u0000\u0000"+
		"69\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:2\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0005"+
		"\u001d\u0000\u0000=>\u0005\u0016\u0000\u0000>?\u0005)\u0000\u0000?@\u0005"+
		"\u001e\u0000\u0000@A\u0003\f\u0006\u0000AB\u0005\u001f\u0000\u0000B\u0007"+
		"\u0001\u0000\u0000\u0000CD\u0005*\u0000\u0000DE\u0005\u0016\u0000\u0000"+
		"EH\u0005)\u0000\u0000FG\u0005\u0019\u0000\u0000GI\u0003\f\u0006\u0000"+
		"HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\t\u0001\u0000\u0000"+
		"\u0000JK\u0005*\u0000\u0000KL\u0005\u0016\u0000\u0000LM\u0005)\u0000\u0000"+
		"M\u000b\u0001\u0000\u0000\u0000NO\u0006\u0006\uffff\uffff\u0000OP\u0005"+
		"*\u0000\u0000PY\u0005\u001c\u0000\u0000QV\u0003\f\u0006\u0000RS\u0005"+
		"\u0017\u0000\u0000SU\u0003\f\u0006\u0000TR\u0001\u0000\u0000\u0000UX\u0001"+
		"\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YQ\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u009e\u0005"+
		"\u001d\u0000\u0000\\]\u0005\u0006\u0000\u0000]^\u0003\f\u0006\u0000^_"+
		"\u0005\r\u0000\u0000_`\u0003\f\u0006\u0000`a\u0005\u0003\u0000\u0000a"+
		"b\u0003\f\u0006\u0000bc\u0005\u0005\u0000\u0000c\u009e\u0001\u0000\u0000"+
		"\u0000de\u0005\u000e\u0000\u0000ef\u0003\f\u0006\u0000fg\u0005\u000b\u0000"+
		"\u0000gh\u0003\f\u0006\u0000hi\u0005\f\u0000\u0000i\u009e\u0001\u0000"+
		"\u0000\u0000jn\u0005\u001e\u0000\u0000kl\u0003\f\u0006\u0000lm\u0005\u0015"+
		"\u0000\u0000mo\u0001\u0000\u0000\u0000nk\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rs\u0005\u001f\u0000\u0000s\u009e\u0001\u0000"+
		"\u0000\u0000tu\u0005\n\u0000\u0000uz\u0003\u000e\u0007\u0000vw\u0005\u0017"+
		"\u0000\u0000wy\u0003\u000e\u0007\u0000xv\u0001\u0000\u0000\u0000y|\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0007\u0000"+
		"\u0000~\u007f\u0003\f\u0006\u000f\u007f\u009e\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\u000f\u0000\u0000\u0081\u0082\u0003\f\u0006\u0000\u0082"+
		"\u0084\u0005\u0012\u0000\u0000\u0083\u0085\u0003\u0010\b\u0000\u0084\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0010\u0000\u0000\u0089\u009e"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u009e"+
		"\u0005)\u0000\u0000\u008c\u008d\u0005$\u0000\u0000\u008d\u009e\u0003\f"+
		"\u0006\f\u008e\u008f\u0005\t\u0000\u0000\u008f\u009e\u0003\f\u0006\u000b"+
		"\u0090\u0091\u0005\u0013\u0000\u0000\u0091\u009e\u0003\f\u0006\u0007\u0092"+
		"\u0093\u0005*\u0000\u0000\u0093\u0094\u0005\u0019\u0000\u0000\u0094\u009e"+
		"\u0003\f\u0006\u0006\u0095\u0096\u0005\u001c\u0000\u0000\u0096\u0097\u0003"+
		"\f\u0006\u0000\u0097\u0098\u0005\u001d\u0000\u0000\u0098\u009e\u0001\u0000"+
		"\u0000\u0000\u0099\u009e\u0005*\u0000\u0000\u009a\u009e\u0005(\u0000\u0000"+
		"\u009b\u009e\u0005+\u0000\u0000\u009c\u009e\u0007\u0000\u0000\u0000\u009d"+
		"N\u0001\u0000\u0000\u0000\u009d\\\u0001\u0000\u0000\u0000\u009dd\u0001"+
		"\u0000\u0000\u0000\u009dj\u0001\u0000\u0000\u0000\u009dt\u0001\u0000\u0000"+
		"\u0000\u009d\u0080\u0001\u0000\u0000\u0000\u009d\u008a\u0001\u0000\u0000"+
		"\u0000\u009d\u008c\u0001\u0000\u0000\u0000\u009d\u008e\u0001\u0000\u0000"+
		"\u0000\u009d\u0090\u0001\u0000\u0000\u0000\u009d\u0092\u0001\u0000\u0000"+
		"\u0000\u009d\u0095\u0001\u0000\u0000\u0000\u009d\u0099\u0001\u0000\u0000"+
		"\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00bd\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\n\n\u0000\u0000\u00a0\u00a1\u0007\u0001\u0000\u0000"+
		"\u00a1\u00bc\u0003\f\u0006\u000b\u00a2\u00a3\n\t\u0000\u0000\u00a3\u00a4"+
		"\u0007\u0002\u0000\u0000\u00a4\u00bc\u0003\f\u0006\n\u00a5\u00a6\n\b\u0000"+
		"\u0000\u00a6\u00a7\u0007\u0003\u0000\u0000\u00a7\u00bc\u0003\f\u0006\t"+
		"\u00a8\u00ab\n\u0014\u0000\u0000\u00a9\u00aa\u0005\u0018\u0000\u0000\u00aa"+
		"\u00ac\u0005)\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u001a\u0000\u0000\u00ae\u00af\u0005*\u0000\u0000\u00af\u00b8\u0005"+
		"\u001c\u0000\u0000\u00b0\u00b5\u0003\f\u0006\u0000\u00b1\u00b2\u0005\u0017"+
		"\u0000\u0000\u00b2\u00b4\u0003\f\u0006\u0000\u00b3\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bc\u0005\u001d\u0000\u0000\u00bb\u009f\u0001\u0000\u0000"+
		"\u0000\u00bb\u00a2\u0001\u0000\u0000\u0000\u00bb\u00a5\u0001\u0000\u0000"+
		"\u0000\u00bb\u00a8\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be\r\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005*\u0000\u0000\u00c1\u00c2\u0005\u0016\u0000\u0000\u00c2"+
		"\u00c5\u0005)\u0000\u0000\u00c3\u00c4\u0005\u0019\u0000\u0000\u00c4\u00c6"+
		"\u0003\f\u0006\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u000f\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		"*\u0000\u0000\u00c8\u00c9\u0005\u0016\u0000\u0000\u00c9\u00ca\u0005)\u0000"+
		"\u0000\u00ca\u00cb\u0005\u001b\u0000\u0000\u00cb\u00cc\u0003\f\u0006\u0000"+
		"\u00cc\u00cd\u0005\u0015\u0000\u0000\u00cd\u0011\u0001\u0000\u0000\u0000"+
		"\u0013\u0017\u001f\'.7:HVYpz\u0086\u009d\u00ab\u00b5\u00b8\u00bb\u00bd"+
		"\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}