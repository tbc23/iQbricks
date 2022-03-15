// Generated from /home/tomas/Desktop/qstar/Qstar Language/Qbricks.g4 by ANTLR 4.9.2

        import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QbricksParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PT=1, SB=2, PTV=3, TP=4, VG=5, OP=6, CL=7, ROP=8, RCL=9, COP=10, CCL=11, 
		EQ=12, NEQ=13, GEQ=14, LEQ=15, GT=16, LT=17, PLUS=18, MINUS=19, MUL=20, 
		DIV=21, POW=22, ARROW=23, BB=24, HAD=25, RZ=26, RX=27, RY=28, XGATE=29, 
		YGATE=30, ZGATE=31, PI=32, IN=33, IF=34, INT=35, DEF=36, LEN=37, FOR=38, 
		ROT=39, PRE=40, POS=41, BOOL=42, QREG=43, CNOT=44, SWAP=45, SQRT=46, ELSE=47, 
		CIRC=48, APPLY=49, FLOAT=50, PHASE=51, RANGE=52, RET=53, ASSERT=54, CONTROL=55, 
		REVERSE=56, WITHCTL=57, INVARIANT=58, ID=59, NUM=60, FORMULA=61, COMM=62, 
		SPACE=63;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_aux = 2, RULE_params = 3, RULE_param = 4, 
		RULE_args = 5, RULE_type = 6, RULE_idFun = 7, RULE_circ = 8, RULE_id_list = 9, 
		RULE_qReg = 10, RULE_body = 11, RULE_pre = 12, RULE_pos = 13, RULE_assert_ = 14, 
		RULE_invariant = 15, RULE_instr = 16, RULE_for_ = 17, RULE_iter = 18, 
		RULE_if_ = 19, RULE_else_ = 20, RULE_apply = 21, RULE_ang = 22, RULE_control = 23, 
		RULE_expr = 24, RULE_term = 25, RULE_atom = 26, RULE_unOp = 27, RULE_range = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "aux", "params", "param", "args", "type", "idFun", 
			"circ", "id_list", "qReg", "body", "pre", "pos", "assert_", "invariant", 
			"instr", "for_", "iter", "if_", "else_", "apply", "ang", "control", "expr", 
			"term", "atom", "unOp", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'|'", "';'", "':'", "','", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", 
			"'*'", "'/'", "'^'", "'->'", "'||'", "'H'", "'RZ'", "'RX'", "'RY'", "'X'", 
			"'Y'", "'Z'", "'pi'", "'in'", "'if'", "'int'", "'def'", "'len'", "'for'", 
			"'rot'", "'pre'", "'pos'", "'bool'", "'qreg'", "'cnot'", "'swap'", "'sqrt'", 
			"'else'", "'circ'", "'apply'", "'float'", "'ph'", "'range'", "'return'", 
			"'assert'", "'control'", "'reverse'", "'with control'", "'invariant'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PT", "SB", "PTV", "TP", "VG", "OP", "CL", "ROP", "RCL", "COP", 
			"CCL", "EQ", "NEQ", "GEQ", "LEQ", "GT", "LT", "PLUS", "MINUS", "MUL", 
			"DIV", "POW", "ARROW", "BB", "HAD", "RZ", "RX", "RY", "XGATE", "YGATE", 
			"ZGATE", "PI", "IN", "IF", "INT", "DEF", "LEN", "FOR", "ROT", "PRE", 
			"POS", "BOOL", "QREG", "CNOT", "SWAP", "SQRT", "ELSE", "CIRC", "APPLY", 
			"FLOAT", "PHASE", "RANGE", "RET", "ASSERT", "CONTROL", "REVERSE", "WITHCTL", 
			"INVARIANT", "ID", "NUM", "FORMULA", "COMM", "SPACE"
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
	public String getGrammarFileName() { return "Qbricks.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QbricksParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<AuxContext> aux() {
			return getRuleContexts(AuxContext.class);
		}
		public AuxContext aux(int i) {
			return getRuleContext(AuxContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(58);
			main();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SB) {
				{
				{
				setState(59);
				aux();
				}
				}
				setState(64);
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

	public static class MainContext extends ParserRuleContext {
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	 
		public MainContext() { }
		public void copyFrom(MainContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainFunContext extends MainContext {
		public List<TerminalNode> BB() { return getTokens(QbricksParser.BB); }
		public TerminalNode BB(int i) {
			return getToken(QbricksParser.BB, i);
		}
		public IdFunContext idFun() {
			return getRuleContext(IdFunContext.class,0);
		}
		public PreContext pre() {
			return getRuleContext(PreContext.class,0);
		}
		public CircContext circ() {
			return getRuleContext(CircContext.class,0);
		}
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MainFunContext(MainContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterMainFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitMainFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitMainFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			_localctx = new MainFunContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(BB);
			setState(66);
			idFun();
			setState(67);
			match(BB);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(68);
				params();
				}
			}

			setState(71);
			pre();
			setState(72);
			circ();
			setState(73);
			pos();
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

	public static class AuxContext extends ParserRuleContext {
		public AuxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aux; }
	 
		public AuxContext() { }
		public void copyFrom(AuxContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AuxFunContext extends AuxContext {
		public List<TerminalNode> SB() { return getTokens(QbricksParser.SB); }
		public TerminalNode SB(int i) {
			return getToken(QbricksParser.SB, i);
		}
		public IdFunContext idFun() {
			return getRuleContext(IdFunContext.class,0);
		}
		public PreContext pre() {
			return getRuleContext(PreContext.class,0);
		}
		public CircContext circ() {
			return getRuleContext(CircContext.class,0);
		}
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public AuxFunContext(AuxContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterAuxFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitAuxFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitAuxFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuxContext aux() throws RecognitionException {
		AuxContext _localctx = new AuxContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aux);
		int _la;
		try {
			_localctx = new AuxFunContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(SB);
			setState(76);
			idFun();
			setState(77);
			match(SB);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(78);
				params();
				}
			}

			setState(81);
			pre();
			setState(82);
			circ();
			setState(83);
			pos();
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

	public static class ParamsContext extends ParserRuleContext {
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunParamsContext extends ParamsContext {
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public FunParamsContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFunParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFunParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFunParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			_localctx = new FunParamsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(OP);
			setState(86);
			param();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(87);
				match(VG);
				setState(88);
				param();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(CL);
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

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleParContext extends ParamContext {
		public TypeContext ptype;
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(QbricksParser.ID, 0); }
		public SingleParContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterSinglePar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitSinglePar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitSinglePar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			_localctx = new SingleParContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((SingleParContext)_localctx).ptype = type();
			setState(97);
			((SingleParContext)_localctx).id = match(ID);
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

	public static class ArgsContext extends ParserRuleContext {
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	 
		public ArgsContext() { }
		public void copyFrom(ArgsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunArgsContext extends ArgsContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public FunArgsContext(ArgsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFunArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFunArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFunArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_args);
		int _la;
		try {
			_localctx = new FunArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			term(0);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(100);
				match(VG);
				setState(101);
				term(0);
				}
				}
				setState(106);
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
	public static class FloatTypeContext extends TypeContext {
		public TerminalNode FLOAT() { return getToken(QbricksParser.FLOAT, 0); }
		public FloatTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFloatType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFloatType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(QbricksParser.INT, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CircTypeContext extends TypeContext {
		public TerminalNode CIRC() { return getToken(QbricksParser.CIRC, 0); }
		public CircTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterCircType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitCircType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitCircType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QrTypeContext extends TypeContext {
		public TerminalNode QREG() { return getToken(QbricksParser.QREG, 0); }
		public QrTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterQrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitQrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitQrType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(QbricksParser.BOOL, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(FLOAT);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(BOOL);
				}
				break;
			case CIRC:
				_localctx = new CircTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(CIRC);
				}
				break;
			case QREG:
				_localctx = new QrTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(QREG);
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

	public static class IdFunContext extends ParserRuleContext {
		public IdFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idFun; }
	 
		public IdFunContext() { }
		public void copyFrom(IdFunContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunIdContext extends IdFunContext {
		public TerminalNode ID() { return getToken(QbricksParser.ID, 0); }
		public FunIdContext(IdFunContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFunId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFunId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFunId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdFunContext idFun() throws RecognitionException {
		IdFunContext _localctx = new IdFunContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_idFun);
		try {
			_localctx = new FunIdContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
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

	public static class CircContext extends ParserRuleContext {
		public CircContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circ; }
	 
		public CircContext() { }
		public void copyFrom(CircContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RegCircContext extends CircContext {
		public BodyContext circbody;
		public TerminalNode CIRC() { return getToken(QbricksParser.CIRC, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(QbricksParser.ARROW, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public RegCircContext(CircContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRegCirc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRegCirc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRegCirc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CircContext circ() throws RecognitionException {
		CircContext _localctx = new CircContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_circ);
		int _la;
		try {
			_localctx = new RegCircContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(CIRC);
			setState(117);
			id_list();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(118);
				match(ARROW);
				setState(119);
				((RegCircContext)_localctx).circbody = body();
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

	public static class Id_listContext extends ParserRuleContext {
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
	 
		public Id_listContext() { }
		public void copyFrom(Id_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QrListContext extends Id_listContext {
		public List<QRegContext> qReg() {
			return getRuleContexts(QRegContext.class);
		}
		public QRegContext qReg(int i) {
			return getRuleContext(QRegContext.class,i);
		}
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public QrListContext(Id_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterQrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitQrList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitQrList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_id_list);
		int _la;
		try {
			_localctx = new QrListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			qReg();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(123);
				match(VG);
				setState(124);
				qReg();
				}
				}
				setState(129);
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

	public static class QRegContext extends ParserRuleContext {
		public QRegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qReg; }
	 
		public QRegContext() { }
		public void copyFrom(QRegContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QrContext extends QRegContext {
		public Token id;
		public RangeContext size;
		public TerminalNode ID() { return getToken(QbricksParser.ID, 0); }
		public TerminalNode ROP() { return getToken(QbricksParser.ROP, 0); }
		public TerminalNode RCL() { return getToken(QbricksParser.RCL, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public QrContext(QRegContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterQr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitQr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitQr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QRegContext qReg() throws RecognitionException {
		QRegContext _localctx = new QRegContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qReg);
		int _la;
		try {
			_localctx = new QrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((QrContext)_localctx).id = match(ID);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROP) {
				{
				setState(131);
				match(ROP);
				setState(132);
				((QrContext)_localctx).size = range();
				setState(133);
				match(RCL);
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

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	 
		public BodyContext() { }
		public void copyFrom(BodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RegBodyContext extends BodyContext {
		public Assert_Context assert_() {
			return getRuleContext(Assert_Context.class,0);
		}
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public RegBodyContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRegBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRegBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRegBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_body);
		int _la;
		try {
			_localctx = new RegBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			assert_();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HAD) | (1L << RZ) | (1L << RX) | (1L << RY) | (1L << XGATE) | (1L << YGATE) | (1L << ZGATE) | (1L << IF) | (1L << FOR) | (1L << CNOT) | (1L << SWAP) | (1L << PHASE) | (1L << RET) | (1L << REVERSE) | (1L << WITHCTL) | (1L << ID))) != 0)) {
				{
				{
				setState(138);
				instr();
				}
				}
				setState(143);
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

	public static class PreContext extends ParserRuleContext {
		public PreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre; }
	 
		public PreContext() { }
		public void copyFrom(PreContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PreSpecContext extends PreContext {
		public TerminalNode PRE() { return getToken(QbricksParser.PRE, 0); }
		public List<TerminalNode> FORMULA() { return getTokens(QbricksParser.FORMULA); }
		public TerminalNode FORMULA(int i) {
			return getToken(QbricksParser.FORMULA, i);
		}
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public PreSpecContext(PreContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterPreSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitPreSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitPreSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreContext pre() throws RecognitionException {
		PreContext _localctx = new PreContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pre);
		int _la;
		try {
			_localctx = new PreSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(PRE);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(145);
				match(COP);
				}
			}

			setState(148);
			match(FORMULA);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(149);
				match(VG);
				setState(150);
				match(FORMULA);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CCL) {
				{
				setState(156);
				match(CCL);
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

	public static class PosContext extends ParserRuleContext {
		public PosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos; }
	 
		public PosContext() { }
		public void copyFrom(PosContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PosSpecContext extends PosContext {
		public TerminalNode POS() { return getToken(QbricksParser.POS, 0); }
		public List<TerminalNode> FORMULA() { return getTokens(QbricksParser.FORMULA); }
		public TerminalNode FORMULA(int i) {
			return getToken(QbricksParser.FORMULA, i);
		}
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public PosSpecContext(PosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterPosSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitPosSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitPosSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosContext pos() throws RecognitionException {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pos);
		int _la;
		try {
			_localctx = new PosSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(POS);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(160);
				match(COP);
				}
			}

			setState(163);
			match(FORMULA);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(164);
				match(VG);
				setState(165);
				match(FORMULA);
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CCL) {
				{
				setState(171);
				match(CCL);
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

	public static class Assert_Context extends ParserRuleContext {
		public Assert_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_; }
	 
		public Assert_Context() { }
		public void copyFrom(Assert_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssertSpecContext extends Assert_Context {
		public TerminalNode ASSERT() { return getToken(QbricksParser.ASSERT, 0); }
		public List<TerminalNode> FORMULA() { return getTokens(QbricksParser.FORMULA); }
		public TerminalNode FORMULA(int i) {
			return getToken(QbricksParser.FORMULA, i);
		}
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public AssertSpecContext(Assert_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterAssertSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitAssertSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitAssertSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyAssertContext extends Assert_Context {
		public EmptyAssertContext(Assert_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterEmptyAssert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitEmptyAssert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitEmptyAssert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assert_Context assert_() throws RecognitionException {
		Assert_Context _localctx = new Assert_Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_assert_);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CCL:
			case HAD:
			case RZ:
			case RX:
			case RY:
			case XGATE:
			case YGATE:
			case ZGATE:
			case IF:
			case FOR:
			case POS:
			case CNOT:
			case SWAP:
			case PHASE:
			case RET:
			case REVERSE:
			case WITHCTL:
			case ID:
				_localctx = new EmptyAssertContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ASSERT:
				_localctx = new AssertSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(ASSERT);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COP) {
					{
					setState(176);
					match(COP);
					}
				}

				setState(179);
				match(FORMULA);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VG) {
					{
					{
					setState(180);
					match(VG);
					setState(181);
					match(FORMULA);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(187);
					match(CCL);
					}
					break;
				}
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

	public static class InvariantContext extends ParserRuleContext {
		public InvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
	 
		public InvariantContext() { }
		public void copyFrom(InvariantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InvSpecContext extends InvariantContext {
		public TerminalNode INVARIANT() { return getToken(QbricksParser.INVARIANT, 0); }
		public List<TerminalNode> FORMULA() { return getTokens(QbricksParser.FORMULA); }
		public TerminalNode FORMULA(int i) {
			return getToken(QbricksParser.FORMULA, i);
		}
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public InvSpecContext(InvariantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterInvSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitInvSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitInvSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_invariant);
		int _la;
		try {
			_localctx = new InvSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(INVARIANT);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(193);
				match(COP);
				}
			}

			setState(196);
			match(FORMULA);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(197);
				match(VG);
				setState(198);
				match(FORMULA);
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(204);
				match(CCL);
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

	public static class InstrContext extends ParserRuleContext {
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
	 
		public InstrContext() { }
		public void copyFrom(InstrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetInstContext extends InstrContext {
		public TerminalNode RET() { return getToken(QbricksParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetInstContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRetInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRetInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRetInst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegInstContext extends InstrContext {
		public For_Context forinst;
		public If_Context ifinst;
		public ApplyContext applyinst;
		public ControlContext ctlinst;
		public Assert_Context assert_() {
			return getRuleContext(Assert_Context.class,0);
		}
		public For_Context for_() {
			return getRuleContext(For_Context.class,0);
		}
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public ControlContext control() {
			return getRuleContext(ControlContext.class,0);
		}
		public RegInstContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRegInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRegInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRegInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_instr);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HAD:
			case RZ:
			case RX:
			case RY:
			case XGATE:
			case YGATE:
			case ZGATE:
			case IF:
			case FOR:
			case CNOT:
			case SWAP:
			case PHASE:
			case REVERSE:
			case WITHCTL:
			case ID:
				_localctx = new RegInstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(207);
					((RegInstContext)_localctx).forinst = for_();
					}
					break;
				case IF:
					{
					setState(208);
					((RegInstContext)_localctx).ifinst = if_();
					}
					break;
				case HAD:
				case RZ:
				case RX:
				case RY:
				case XGATE:
				case YGATE:
				case ZGATE:
				case SWAP:
				case PHASE:
				case REVERSE:
				case ID:
					{
					setState(209);
					((RegInstContext)_localctx).applyinst = apply();
					}
					break;
				case CNOT:
				case WITHCTL:
					{
					setState(210);
					((RegInstContext)_localctx).ctlinst = control();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				assert_();
				}
				break;
			case RET:
				_localctx = new RetInstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(RET);
				setState(217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(216);
					expr(0);
					}
					break;
				}
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

	public static class For_Context extends ParserRuleContext {
		public For_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_; }
	 
		public For_Context() { }
		public void copyFrom(For_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForLoopContext extends For_Context {
		public Token var;
		public IterContext iteration;
		public InvariantContext inv;
		public BodyContext forbody;
		public TerminalNode FOR() { return getToken(QbricksParser.FOR, 0); }
		public TerminalNode IN() { return getToken(QbricksParser.IN, 0); }
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public TerminalNode ID() { return getToken(QbricksParser.ID, 0); }
		public IterContext iter() {
			return getRuleContext(IterContext.class,0);
		}
		public InvariantContext invariant() {
			return getRuleContext(InvariantContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ForLoopContext(For_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_Context for_() throws RecognitionException {
		For_Context _localctx = new For_Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_for_);
		try {
			_localctx = new ForLoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(FOR);
			setState(222);
			((ForLoopContext)_localctx).var = match(ID);
			setState(223);
			match(IN);
			setState(224);
			((ForLoopContext)_localctx).iteration = iter();
			setState(225);
			match(COP);
			setState(226);
			((ForLoopContext)_localctx).inv = invariant();
			setState(227);
			((ForLoopContext)_localctx).forbody = body();
			setState(228);
			match(CCL);
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

	public static class IterContext extends ParserRuleContext {
		public IterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iter; }
	 
		public IterContext() { }
		public void copyFrom(IterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QrIterContext extends IterContext {
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public QrIterContext(IterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterQrIter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitQrIter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitQrIter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RangeIterContext extends IterContext {
		public ExprContext expvalue;
		public QRegContext qrvalue;
		public TerminalNode RANGE() { return getToken(QbricksParser.RANGE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public RangeIterContext(IterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRangeIter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRangeIter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRangeIter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterContext iter() throws RecognitionException {
		IterContext _localctx = new IterContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_iter);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RANGE:
				_localctx = new RangeIterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(RANGE);
				setState(231);
				match(OP);
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(232);
					((RangeIterContext)_localctx).expvalue = expr(0);
					}
					break;
				case 2:
					{
					setState(233);
					((RangeIterContext)_localctx).qrvalue = qReg();
					}
					break;
				}
				setState(236);
				match(CL);
				}
				break;
			case ID:
				_localctx = new QrIterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				qReg();
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

	public static class If_Context extends ParserRuleContext {
		public If_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_; }
	 
		public If_Context() { }
		public void copyFrom(If_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondIfContext extends If_Context {
		public ExprContext cond;
		public BodyContext ifbody;
		public Else_Context elsebody;
		public TerminalNode IF() { return getToken(QbricksParser.IF, 0); }
		public List<TerminalNode> COP() { return getTokens(QbricksParser.COP); }
		public TerminalNode COP(int i) {
			return getToken(QbricksParser.COP, i);
		}
		public List<TerminalNode> CCL() { return getTokens(QbricksParser.CCL); }
		public TerminalNode CCL(int i) {
			return getToken(QbricksParser.CCL, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(QbricksParser.ELSE, 0); }
		public Else_Context else_() {
			return getRuleContext(Else_Context.class,0);
		}
		public CondIfContext(If_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterCondIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitCondIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitCondIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_);
		int _la;
		try {
			_localctx = new CondIfContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(IF);
			setState(242);
			((CondIfContext)_localctx).cond = expr(0);
			setState(243);
			match(COP);
			setState(244);
			((CondIfContext)_localctx).ifbody = body();
			setState(245);
			match(CCL);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(246);
				match(ELSE);
				setState(247);
				match(COP);
				setState(248);
				((CondIfContext)_localctx).elsebody = else_();
				setState(249);
				match(CCL);
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

	public static class Else_Context extends ParserRuleContext {
		public Else_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_; }
	 
		public Else_Context() { }
		public void copyFrom(Else_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ElsebodyContext extends Else_Context {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElsebodyContext(Else_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterElsebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitElsebody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitElsebody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_else_);
		try {
			_localctx = new ElsebodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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

	public static class ApplyContext extends ParserRuleContext {
		public ApplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apply; }
	 
		public ApplyContext() { }
		public void copyFrom(ApplyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HadApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode HAD() { return getToken(QbricksParser.HAD, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public HadApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterHadApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitHadApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitHadApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunApplyContext extends ApplyContext {
		public IdFunContext fun;
		public ArgsContext fargs;
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public IdFunContext idFun() {
			return getRuleContext(IdFunContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFunApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFunApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFunApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode ZGATE() { return getToken(QbricksParser.ZGATE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public ZApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterZApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitZApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitZApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RevApplyContext extends ApplyContext {
		public IdFunContext fun;
		public ArgsContext fargs;
		public TerminalNode REVERSE() { return getToken(QbricksParser.REVERSE, 0); }
		public List<TerminalNode> OP() { return getTokens(QbricksParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(QbricksParser.OP, i);
		}
		public List<TerminalNode> CL() { return getTokens(QbricksParser.CL); }
		public TerminalNode CL(int i) {
			return getToken(QbricksParser.CL, i);
		}
		public IdFunContext idFun() {
			return getRuleContext(IdFunContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public RevApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRevApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRevApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRevApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwapApplyContext extends ApplyContext {
		public QRegContext qrL;
		public QRegContext qrR;
		public TerminalNode SWAP() { return getToken(QbricksParser.SWAP, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public List<QRegContext> qReg() {
			return getRuleContexts(QRegContext.class);
		}
		public QRegContext qReg(int i) {
			return getRuleContext(QRegContext.class,i);
		}
		public SwapApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterSwapApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitSwapApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitSwapApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class YApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode YGATE() { return getToken(QbricksParser.YGATE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public YApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterYApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitYApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitYApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RzApplyContext extends ApplyContext {
		public AngContext angle;
		public QRegContext qr;
		public TerminalNode RZ() { return getToken(QbricksParser.RZ, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public AngContext ang() {
			return getRuleContext(AngContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public RzApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRzApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRzApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRzApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode XGATE() { return getToken(QbricksParser.XGATE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public XApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterXApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitXApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitXApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RxApplyContext extends ApplyContext {
		public AngContext angle;
		public QRegContext qr;
		public TerminalNode RX() { return getToken(QbricksParser.RX, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public AngContext ang() {
			return getRuleContext(AngContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public RxApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRxApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRxApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRxApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PhApplyContext extends ApplyContext {
		public AngContext angle;
		public QRegContext qr;
		public TerminalNode PHASE() { return getToken(QbricksParser.PHASE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public AngContext ang() {
			return getRuleContext(AngContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public PhApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterPhApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitPhApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitPhApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RyApplyContext extends ApplyContext {
		public AngContext angle;
		public QRegContext qr;
		public TerminalNode RY() { return getToken(QbricksParser.RY, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public AngContext ang() {
			return getRuleContext(AngContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public RyApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterRyApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitRyApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitRyApply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplyContext apply() throws RecognitionException {
		ApplyContext _localctx = new ApplyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_apply);
		try {
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FunApplyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				((FunApplyContext)_localctx).fun = idFun();
				setState(256);
				match(OP);
				setState(257);
				((FunApplyContext)_localctx).fargs = args();
				setState(258);
				match(CL);
				}
				break;
			case REVERSE:
				_localctx = new RevApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(REVERSE);
				setState(261);
				match(OP);
				setState(262);
				((RevApplyContext)_localctx).fun = idFun();
				setState(263);
				match(OP);
				setState(264);
				((RevApplyContext)_localctx).fargs = args();
				setState(265);
				match(CL);
				setState(266);
				match(CL);
				}
				break;
			case HAD:
				_localctx = new HadApplyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				match(HAD);
				setState(269);
				match(OP);
				setState(270);
				((HadApplyContext)_localctx).qr = qReg();
				setState(271);
				match(CL);
				}
				break;
			case RZ:
				_localctx = new RzApplyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(273);
				match(RZ);
				setState(274);
				match(OP);
				setState(275);
				((RzApplyContext)_localctx).angle = ang();
				setState(276);
				match(VG);
				setState(277);
				((RzApplyContext)_localctx).qr = qReg();
				setState(278);
				match(CL);
				}
				break;
			case RX:
				_localctx = new RxApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(280);
				match(RX);
				setState(281);
				match(OP);
				setState(282);
				((RxApplyContext)_localctx).angle = ang();
				setState(283);
				match(VG);
				setState(284);
				((RxApplyContext)_localctx).qr = qReg();
				setState(285);
				match(CL);
				}
				break;
			case RY:
				_localctx = new RyApplyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(287);
				match(RY);
				setState(288);
				match(OP);
				setState(289);
				((RyApplyContext)_localctx).angle = ang();
				setState(290);
				match(VG);
				setState(291);
				((RyApplyContext)_localctx).qr = qReg();
				setState(292);
				match(CL);
				}
				break;
			case XGATE:
				_localctx = new XApplyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(294);
				match(XGATE);
				setState(295);
				match(OP);
				setState(296);
				((XApplyContext)_localctx).qr = qReg();
				setState(297);
				match(CL);
				}
				break;
			case YGATE:
				_localctx = new YApplyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(299);
				match(YGATE);
				setState(300);
				match(OP);
				setState(301);
				((YApplyContext)_localctx).qr = qReg();
				setState(302);
				match(CL);
				}
				break;
			case ZGATE:
				_localctx = new ZApplyContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(304);
				match(ZGATE);
				setState(305);
				match(OP);
				setState(306);
				((ZApplyContext)_localctx).qr = qReg();
				setState(307);
				match(CL);
				}
				break;
			case SWAP:
				_localctx = new SwapApplyContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(309);
				match(SWAP);
				setState(310);
				match(OP);
				setState(311);
				((SwapApplyContext)_localctx).qrL = qReg();
				setState(312);
				match(VG);
				setState(313);
				((SwapApplyContext)_localctx).qrR = qReg();
				setState(314);
				match(CL);
				}
				break;
			case PHASE:
				_localctx = new PhApplyContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(316);
				match(PHASE);
				setState(317);
				match(OP);
				setState(318);
				((PhApplyContext)_localctx).angle = ang();
				setState(319);
				match(VG);
				setState(320);
				((PhApplyContext)_localctx).qr = qReg();
				setState(321);
				match(CL);
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

	public static class AngContext extends ParserRuleContext {
		public AngContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ang; }
	 
		public AngContext() { }
		public void copyFrom(AngContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AngTermContext extends AngContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AngTermContext(AngContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterAngTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitAngTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitAngTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngContext ang() throws RecognitionException {
		AngContext _localctx = new AngContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ang);
		try {
			_localctx = new AngTermContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			term(0);
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

	public static class ControlContext extends ParserRuleContext {
		public ControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control; }
	 
		public ControlContext() { }
		public void copyFrom(ControlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApplyControlContext extends ControlContext {
		public Id_listContext ctlqrs;
		public ApplyContext ctlgate;
		public TerminalNode WITHCTL() { return getToken(QbricksParser.WITHCTL, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public ApplyControlContext(ControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterApplyControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitApplyControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitApplyControl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CnotControlContext extends ControlContext {
		public QRegContext ctlqr;
		public QRegContext tqr;
		public TerminalNode CNOT() { return getToken(QbricksParser.CNOT, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode VG() { return getToken(QbricksParser.VG, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public List<QRegContext> qReg() {
			return getRuleContexts(QRegContext.class);
		}
		public QRegContext qReg(int i) {
			return getRuleContext(QRegContext.class,i);
		}
		public CnotControlContext(ControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterCnotControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitCnotControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitCnotControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlContext control() throws RecognitionException {
		ControlContext _localctx = new ControlContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_control);
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WITHCTL:
				_localctx = new ApplyControlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(WITHCTL);
				setState(328);
				((ApplyControlContext)_localctx).ctlqrs = id_list();
				setState(329);
				match(OP);
				setState(330);
				((ApplyControlContext)_localctx).ctlgate = apply();
				setState(331);
				match(CL);
				}
				break;
			case CNOT:
				_localctx = new CnotControlContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(CNOT);
				setState(334);
				match(OP);
				setState(335);
				((CnotControlContext)_localctx).ctlqr = qReg();
				setState(336);
				match(VG);
				setState(337);
				((CnotControlContext)_localctx).tqr = qReg();
				setState(338);
				match(CL);
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
	public static class EqExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(QbricksParser.EQ, 0); }
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(QbricksParser.LT, 0); }
		public LtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterLtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitLtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitLtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(QbricksParser.GT, 0); }
		public GtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterGtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitGtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitGtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermExprContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterTermExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitTermExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitTermExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeqExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(QbricksParser.LEQ, 0); }
		public LeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterLeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitLeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitLeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GeqExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GEQ() { return getToken(QbricksParser.GEQ, 0); }
		public GeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterGeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitGeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitGeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NeqExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(QbricksParser.NEQ, 0); }
		public NeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterNeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitNeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitNeqExpr(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new TermExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(343);
				term(0);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344);
				match(OP);
				setState(345);
				expr(0);
				setState(346);
				match(CL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(368);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						((EqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(350);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(351);
						((EqExprContext)_localctx).op = match(EQ);
						setState(352);
						((EqExprContext)_localctx).right = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new GtExprContext(new ExprContext(_parentctx, _parentState));
						((GtExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(353);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(354);
						((GtExprContext)_localctx).op = match(GT);
						setState(355);
						((GtExprContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new LtExprContext(new ExprContext(_parentctx, _parentState));
						((LtExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(357);
						((LtExprContext)_localctx).op = match(LT);
						setState(358);
						((LtExprContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new GeqExprContext(new ExprContext(_parentctx, _parentState));
						((GeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(359);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(360);
						((GeqExprContext)_localctx).op = match(GEQ);
						setState(361);
						((GeqExprContext)_localctx).right = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new LeqExprContext(new ExprContext(_parentctx, _parentState));
						((LeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(362);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(363);
						((LeqExprContext)_localctx).op = match(LEQ);
						setState(364);
						((LeqExprContext)_localctx).right = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new NeqExprContext(new ExprContext(_parentctx, _parentState));
						((NeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(365);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(366);
						((NeqExprContext)_localctx).op = match(NEQ);
						setState(367);
						((NeqExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddTermContext extends TermContext {
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(QbricksParser.PLUS, 0); }
		public AddTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterAddTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitAddTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitAddTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryTermContext extends TermContext {
		public UnOpContext unOp() {
			return getRuleContext(UnOpContext.class,0);
		}
		public UnaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterUnaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitUnaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitUnaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulTermContext extends TermContext {
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode MUL() { return getToken(QbricksParser.MUL, 0); }
		public MulTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterMulTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitMulTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitMulTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomTermContext extends TermContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterAtomTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitAtomTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitAtomTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowTermContext extends TermContext {
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode POW() { return getToken(QbricksParser.POW, 0); }
		public PowTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterPowTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitPowTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitPowTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubTermContext extends TermContext {
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(QbricksParser.MINUS, 0); }
		public SubTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterSubTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitSubTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitSubTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenTermContext extends TermContext {
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ParenTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterParenTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitParenTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitParenTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivTermContext extends TermContext {
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode DIV() { return getToken(QbricksParser.DIV, 0); }
		public DivTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterDivTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitDivTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitDivTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PI:
			case ID:
			case NUM:
				{
				_localctx = new AtomTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(374);
				atom();
				}
				break;
			case OP:
				{
				_localctx = new ParenTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375);
				match(OP);
				setState(376);
				term(0);
				setState(377);
				match(CL);
				}
				break;
			case MINUS:
			case LEN:
			case SQRT:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(379);
				unOp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(399);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(397);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new PowTermContext(new TermContext(_parentctx, _parentState));
						((PowTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(382);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(383);
						((PowTermContext)_localctx).op = match(POW);
						setState(384);
						((PowTermContext)_localctx).right = term(8);
						}
						break;
					case 2:
						{
						_localctx = new MulTermContext(new TermContext(_parentctx, _parentState));
						((MulTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(385);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(386);
						((MulTermContext)_localctx).op = match(MUL);
						setState(387);
						((MulTermContext)_localctx).right = term(7);
						}
						break;
					case 3:
						{
						_localctx = new DivTermContext(new TermContext(_parentctx, _parentState));
						((DivTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(388);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(389);
						((DivTermContext)_localctx).op = match(DIV);
						setState(390);
						((DivTermContext)_localctx).right = term(6);
						}
						break;
					case 4:
						{
						_localctx = new AddTermContext(new TermContext(_parentctx, _parentState));
						((AddTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(391);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(392);
						((AddTermContext)_localctx).op = match(PLUS);
						setState(393);
						((AddTermContext)_localctx).right = term(5);
						}
						break;
					case 5:
						{
						_localctx = new SubTermContext(new TermContext(_parentctx, _parentState));
						((SubTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(394);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(395);
						((SubTermContext)_localctx).op = match(MINUS);
						setState(396);
						((SubTermContext)_localctx).right = term(4);
						}
						break;
					}
					} 
				}
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAtomContext extends AtomContext {
		public Token var;
		public TerminalNode ID() { return getToken(QbricksParser.ID, 0); }
		public VarAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterVarAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitVarAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitVarAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumAtomContext extends AtomContext {
		public Token value;
		public TerminalNode NUM() { return getToken(QbricksParser.NUM, 0); }
		public NumAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterNumAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitNumAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitNumAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PiAtomContext extends AtomContext {
		public Token pi;
		public TerminalNode PI() { return getToken(QbricksParser.PI, 0); }
		public PiAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterPiAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitPiAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitPiAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_atom);
		try {
			setState(405);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				((NumAtomContext)_localctx).value = match(NUM);
				}
				break;
			case PI:
				_localctx = new PiAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				((PiAtomContext)_localctx).pi = match(PI);
				}
				break;
			case ID:
				_localctx = new VarAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(404);
				((VarAtomContext)_localctx).var = match(ID);
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

	public static class UnOpContext extends ParserRuleContext {
		public UnOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOp; }
	 
		public UnOpContext() { }
		public void copyFrom(UnOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LenUnaryContext extends UnOpContext {
		public TerminalNode LEN() { return getToken(QbricksParser.LEN, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public LenUnaryContext(UnOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterLenUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitLenUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitLenUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqrtUnaryContext extends UnOpContext {
		public TermContext value;
		public TerminalNode SQRT() { return getToken(QbricksParser.SQRT, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SqrtUnaryContext(UnOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterSqrtUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitSqrtUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitSqrtUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegUnaryContext extends UnOpContext {
		public TerminalNode MINUS() { return getToken(QbricksParser.MINUS, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NegUnaryContext(UnOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterNegUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitNegUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitNegUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnOpContext unOp() throws RecognitionException {
		UnOpContext _localctx = new UnOpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unOp);
		try {
			setState(419);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new NegUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				match(MINUS);
				setState(408);
				term(0);
				}
				break;
			case LEN:
				_localctx = new LenUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				match(LEN);
				setState(410);
				match(OP);
				setState(411);
				qReg();
				setState(412);
				match(CL);
				}
				break;
			case SQRT:
				_localctx = new SqrtUnaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				match(SQRT);
				setState(415);
				match(OP);
				setState(416);
				((SqrtUnaryContext)_localctx).value = term(0);
				setState(417);
				match(CL);
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

	public static class RangeContext extends ParserRuleContext {
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
	 
		public RangeContext() { }
		public void copyFrom(RangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermRangeContext extends RangeContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermRangeContext(RangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterTermRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitTermRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitTermRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalRangeContext extends RangeContext {
		public TermContext start;
		public TermContext end;
		public List<TerminalNode> PT() { return getTokens(QbricksParser.PT); }
		public TerminalNode PT(int i) {
			return getToken(QbricksParser.PT, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IntervalRangeContext(RangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterIntervalRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitIntervalRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitIntervalRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FromRangeContext extends RangeContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode TP() { return getToken(QbricksParser.TP, 0); }
		public FromRangeContext(RangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterFromRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitFromRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitFromRange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UptoRangeContext extends RangeContext {
		public TerminalNode TP() { return getToken(QbricksParser.TP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UptoRangeContext(RangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).enterUptoRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QbricksListener ) ((QbricksListener)listener).exitUptoRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QbricksVisitor ) return ((QbricksVisitor<? extends T>)visitor).visitUptoRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_range);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new TermRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				term(0);
				}
				break;
			case 2:
				_localctx = new UptoRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(TP);
				setState(423);
				term(0);
				}
				break;
			case 3:
				_localctx = new FromRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				term(0);
				setState(425);
				match(TP);
				}
				break;
			case 4:
				_localctx = new IntervalRangeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				((IntervalRangeContext)_localctx).start = term(0);
				setState(428);
				match(PT);
				setState(429);
				match(PT);
				setState(430);
				((IntervalRangeContext)_localctx).end = term(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 25:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u01b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\7\2?\n\2\f"+
		"\2\16\2B\13\2\3\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\5\4R\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\\\n\5\f\5\16\5_\13\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\b\3\b\3\b\3\b\3"+
		"\b\5\bs\n\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n{\n\n\3\13\3\13\3\13\7\13\u0080"+
		"\n\13\f\13\16\13\u0083\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u008a\n\f\3\r\3\r"+
		"\7\r\u008e\n\r\f\r\16\r\u0091\13\r\3\16\3\16\5\16\u0095\n\16\3\16\3\16"+
		"\3\16\7\16\u009a\n\16\f\16\16\16\u009d\13\16\3\16\5\16\u00a0\n\16\3\17"+
		"\3\17\5\17\u00a4\n\17\3\17\3\17\3\17\7\17\u00a9\n\17\f\17\16\17\u00ac"+
		"\13\17\3\17\5\17\u00af\n\17\3\20\3\20\3\20\5\20\u00b4\n\20\3\20\3\20\3"+
		"\20\7\20\u00b9\n\20\f\20\16\20\u00bc\13\20\3\20\5\20\u00bf\n\20\5\20\u00c1"+
		"\n\20\3\21\3\21\5\21\u00c5\n\21\3\21\3\21\3\21\7\21\u00ca\n\21\f\21\16"+
		"\21\u00cd\13\21\3\21\5\21\u00d0\n\21\3\22\3\22\3\22\3\22\5\22\u00d6\n"+
		"\22\3\22\3\22\3\22\3\22\5\22\u00dc\n\22\5\22\u00de\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00ed\n\24\3\24"+
		"\3\24\3\24\5\24\u00f2\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u00fe\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0146\n\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0157\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u015f\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0173\n\32\f\32"+
		"\16\32\u0176\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u017f\n\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0190\n\33\f\33\16\33\u0193\13\33\3\34\3\34\3\34\5\34\u0198"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u01a6\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u01b3\n\36\3\36\2\4\62\64\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(*,.\60\62\64\668:\2\2\2\u01d9\2<\3\2\2\2\4C\3\2\2\2\6M\3\2\2\2\b"+
		"W\3\2\2\2\nb\3\2\2\2\fe\3\2\2\2\16r\3\2\2\2\20t\3\2\2\2\22v\3\2\2\2\24"+
		"|\3\2\2\2\26\u0084\3\2\2\2\30\u008b\3\2\2\2\32\u0092\3\2\2\2\34\u00a1"+
		"\3\2\2\2\36\u00c0\3\2\2\2 \u00c2\3\2\2\2\"\u00dd\3\2\2\2$\u00df\3\2\2"+
		"\2&\u00f1\3\2\2\2(\u00f3\3\2\2\2*\u00ff\3\2\2\2,\u0145\3\2\2\2.\u0147"+
		"\3\2\2\2\60\u0156\3\2\2\2\62\u015e\3\2\2\2\64\u017e\3\2\2\2\66\u0197\3"+
		"\2\2\28\u01a5\3\2\2\2:\u01b2\3\2\2\2<@\5\4\3\2=?\5\6\4\2>=\3\2\2\2?B\3"+
		"\2\2\2@>\3\2\2\2@A\3\2\2\2A\3\3\2\2\2B@\3\2\2\2CD\7\32\2\2DE\5\20\t\2"+
		"EG\7\32\2\2FH\5\b\5\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\5\32\16\2JK\5\22"+
		"\n\2KL\5\34\17\2L\5\3\2\2\2MN\7\4\2\2NO\5\20\t\2OQ\7\4\2\2PR\5\b\5\2Q"+
		"P\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\5\32\16\2TU\5\22\n\2UV\5\34\17\2V\7\3"+
		"\2\2\2WX\7\b\2\2X]\5\n\6\2YZ\7\7\2\2Z\\\5\n\6\2[Y\3\2\2\2\\_\3\2\2\2]"+
		"[\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\t\2\2a\t\3\2\2\2bc\5\16\b"+
		"\2cd\7=\2\2d\13\3\2\2\2ej\5\64\33\2fg\7\7\2\2gi\5\64\33\2hf\3\2\2\2il"+
		"\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\r\3\2\2\2lj\3\2\2\2ms\7%\2\2ns\7\64\2\2"+
		"os\7,\2\2ps\7\62\2\2qs\7-\2\2rm\3\2\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2"+
		"rq\3\2\2\2s\17\3\2\2\2tu\7=\2\2u\21\3\2\2\2vw\7\62\2\2wz\5\24\13\2xy\7"+
		"\31\2\2y{\5\30\r\2zx\3\2\2\2z{\3\2\2\2{\23\3\2\2\2|\u0081\5\26\f\2}~\7"+
		"\7\2\2~\u0080\5\26\f\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0089"+
		"\7=\2\2\u0085\u0086\7\n\2\2\u0086\u0087\5:\36\2\u0087\u0088\7\13\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u008a\3\2\2\2\u008a\27\3\2\2"+
		"\2\u008b\u008f\5\36\20\2\u008c\u008e\5\"\22\2\u008d\u008c\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\31\3\2\2"+
		"\2\u0091\u008f\3\2\2\2\u0092\u0094\7*\2\2\u0093\u0095\7\f\2\2\u0094\u0093"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009b\7?\2\2\u0097"+
		"\u0098\7\7\2\2\u0098\u009a\7?\2\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u00a0\7\r\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\33\3\2\2\2\u00a1\u00a3\7+\2\2\u00a2\u00a4\7\f\2\2\u00a3\u00a2"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00aa\7?\2\2\u00a6"+
		"\u00a7\7\7\2\2\u00a7\u00a9\7?\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00af\7\r\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\35\3\2\2\2\u00b0\u00c1\3\2\2\2\u00b1\u00b3\78\2\2\u00b2\u00b4"+
		"\7\f\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00ba\7?\2\2\u00b6\u00b7\7\7\2\2\u00b7\u00b9\7?\2\2\u00b8\u00b6\3\2\2"+
		"\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00bf\7\r\2\2\u00be\u00bd\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00b0\3\2\2\2\u00c0\u00b1\3\2"+
		"\2\2\u00c1\37\3\2\2\2\u00c2\u00c4\7<\2\2\u00c3\u00c5\7\f\2\2\u00c4\u00c3"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00cb\7?\2\2\u00c7"+
		"\u00c8\7\7\2\2\u00c8\u00ca\7?\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00d0\7\r\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0!\3\2\2\2\u00d1\u00d6\5$\23\2\u00d2\u00d6\5(\25\2\u00d3\u00d6"+
		"\5,\27\2\u00d4\u00d6\5\60\31\2\u00d5\u00d1\3\2\2\2\u00d5\u00d2\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8"+
		"\5\36\20\2\u00d8\u00de\3\2\2\2\u00d9\u00db\7\67\2\2\u00da\u00dc\5\62\32"+
		"\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d5"+
		"\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de#\3\2\2\2\u00df\u00e0\7(\2\2\u00e0\u00e1"+
		"\7=\2\2\u00e1\u00e2\7#\2\2\u00e2\u00e3\5&\24\2\u00e3\u00e4\7\f\2\2\u00e4"+
		"\u00e5\5 \21\2\u00e5\u00e6\5\30\r\2\u00e6\u00e7\7\r\2\2\u00e7%\3\2\2\2"+
		"\u00e8\u00e9\7\66\2\2\u00e9\u00ec\7\b\2\2\u00ea\u00ed\5\62\32\2\u00eb"+
		"\u00ed\5\26\f\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3"+
		"\2\2\2\u00ee\u00ef\7\t\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00f2\5\26\f\2\u00f1"+
		"\u00e8\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\'\3\2\2\2\u00f3\u00f4\7$\2\2"+
		"\u00f4\u00f5\5\62\32\2\u00f5\u00f6\7\f\2\2\u00f6\u00f7\5\30\r\2\u00f7"+
		"\u00fd\7\r\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fa\7\f\2\2\u00fa\u00fb\5"+
		"*\26\2\u00fb\u00fc\7\r\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe)\3\2\2\2\u00ff\u0100\5\30\r\2\u0100+\3\2\2\2\u0101"+
		"\u0102\5\20\t\2\u0102\u0103\7\b\2\2\u0103\u0104\5\f\7\2\u0104\u0105\7"+
		"\t\2\2\u0105\u0146\3\2\2\2\u0106\u0107\7:\2\2\u0107\u0108\7\b\2\2\u0108"+
		"\u0109\5\20\t\2\u0109\u010a\7\b\2\2\u010a\u010b\5\f\7\2\u010b\u010c\7"+
		"\t\2\2\u010c\u010d\7\t\2\2\u010d\u0146\3\2\2\2\u010e\u010f\7\33\2\2\u010f"+
		"\u0110\7\b\2\2\u0110\u0111\5\26\f\2\u0111\u0112\7\t\2\2\u0112\u0146\3"+
		"\2\2\2\u0113\u0114\7\34\2\2\u0114\u0115\7\b\2\2\u0115\u0116\5.\30\2\u0116"+
		"\u0117\7\7\2\2\u0117\u0118\5\26\f\2\u0118\u0119\7\t\2\2\u0119\u0146\3"+
		"\2\2\2\u011a\u011b\7\35\2\2\u011b\u011c\7\b\2\2\u011c\u011d\5.\30\2\u011d"+
		"\u011e\7\7\2\2\u011e\u011f\5\26\f\2\u011f\u0120\7\t\2\2\u0120\u0146\3"+
		"\2\2\2\u0121\u0122\7\36\2\2\u0122\u0123\7\b\2\2\u0123\u0124\5.\30\2\u0124"+
		"\u0125\7\7\2\2\u0125\u0126\5\26\f\2\u0126\u0127\7\t\2\2\u0127\u0146\3"+
		"\2\2\2\u0128\u0129\7\37\2\2\u0129\u012a\7\b\2\2\u012a\u012b\5\26\f\2\u012b"+
		"\u012c\7\t\2\2\u012c\u0146\3\2\2\2\u012d\u012e\7 \2\2\u012e\u012f\7\b"+
		"\2\2\u012f\u0130\5\26\f\2\u0130\u0131\7\t\2\2\u0131\u0146\3\2\2\2\u0132"+
		"\u0133\7!\2\2\u0133\u0134\7\b\2\2\u0134\u0135\5\26\f\2\u0135\u0136\7\t"+
		"\2\2\u0136\u0146\3\2\2\2\u0137\u0138\7/\2\2\u0138\u0139\7\b\2\2\u0139"+
		"\u013a\5\26\f\2\u013a\u013b\7\7\2\2\u013b\u013c\5\26\f\2\u013c\u013d\7"+
		"\t\2\2\u013d\u0146\3\2\2\2\u013e\u013f\7\65\2\2\u013f\u0140\7\b\2\2\u0140"+
		"\u0141\5.\30\2\u0141\u0142\7\7\2\2\u0142\u0143\5\26\f\2\u0143\u0144\7"+
		"\t\2\2\u0144\u0146\3\2\2\2\u0145\u0101\3\2\2\2\u0145\u0106\3\2\2\2\u0145"+
		"\u010e\3\2\2\2\u0145\u0113\3\2\2\2\u0145\u011a\3\2\2\2\u0145\u0121\3\2"+
		"\2\2\u0145\u0128\3\2\2\2\u0145\u012d\3\2\2\2\u0145\u0132\3\2\2\2\u0145"+
		"\u0137\3\2\2\2\u0145\u013e\3\2\2\2\u0146-\3\2\2\2\u0147\u0148\5\64\33"+
		"\2\u0148/\3\2\2\2\u0149\u014a\7;\2\2\u014a\u014b\5\24\13\2\u014b\u014c"+
		"\7\b\2\2\u014c\u014d\5,\27\2\u014d\u014e\7\t\2\2\u014e\u0157\3\2\2\2\u014f"+
		"\u0150\7.\2\2\u0150\u0151\7\b\2\2\u0151\u0152\5\26\f\2\u0152\u0153\7\7"+
		"\2\2\u0153\u0154\5\26\f\2\u0154\u0155\7\t\2\2\u0155\u0157\3\2\2\2\u0156"+
		"\u0149\3\2\2\2\u0156\u014f\3\2\2\2\u0157\61\3\2\2\2\u0158\u0159\b\32\1"+
		"\2\u0159\u015f\5\64\33\2\u015a\u015b\7\b\2\2\u015b\u015c\5\62\32\2\u015c"+
		"\u015d\7\t\2\2\u015d\u015f\3\2\2\2\u015e\u0158\3\2\2\2\u015e\u015a\3\2"+
		"\2\2\u015f\u0174\3\2\2\2\u0160\u0161\f\t\2\2\u0161\u0162\7\16\2\2\u0162"+
		"\u0173\5\62\32\n\u0163\u0164\f\b\2\2\u0164\u0165\7\22\2\2\u0165\u0173"+
		"\5\62\32\t\u0166\u0167\f\7\2\2\u0167\u0168\7\23\2\2\u0168\u0173\5\62\32"+
		"\b\u0169\u016a\f\6\2\2\u016a\u016b\7\20\2\2\u016b\u0173\5\62\32\7\u016c"+
		"\u016d\f\5\2\2\u016d\u016e\7\21\2\2\u016e\u0173\5\62\32\6\u016f\u0170"+
		"\f\4\2\2\u0170\u0171\7\17\2\2\u0171\u0173\5\62\32\5\u0172\u0160\3\2\2"+
		"\2\u0172\u0163\3\2\2\2\u0172\u0166\3\2\2\2\u0172\u0169\3\2\2\2\u0172\u016c"+
		"\3\2\2\2\u0172\u016f\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\63\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\b\33\1"+
		"\2\u0178\u017f\5\66\34\2\u0179\u017a\7\b\2\2\u017a\u017b\5\64\33\2\u017b"+
		"\u017c\7\t\2\2\u017c\u017f\3\2\2\2\u017d\u017f\58\35\2\u017e\u0177\3\2"+
		"\2\2\u017e\u0179\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u0191\3\2\2\2\u0180"+
		"\u0181\f\t\2\2\u0181\u0182\7\30\2\2\u0182\u0190\5\64\33\n\u0183\u0184"+
		"\f\b\2\2\u0184\u0185\7\26\2\2\u0185\u0190\5\64\33\t\u0186\u0187\f\7\2"+
		"\2\u0187\u0188\7\27\2\2\u0188\u0190\5\64\33\b\u0189\u018a\f\6\2\2\u018a"+
		"\u018b\7\24\2\2\u018b\u0190\5\64\33\7\u018c\u018d\f\5\2\2\u018d\u018e"+
		"\7\25\2\2\u018e\u0190\5\64\33\6\u018f\u0180\3\2\2\2\u018f\u0183\3\2\2"+
		"\2\u018f\u0186\3\2\2\2\u018f\u0189\3\2\2\2\u018f\u018c\3\2\2\2\u0190\u0193"+
		"\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\65\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194\u0198\7>\2\2\u0195\u0198\7\"\2\2\u0196\u0198\7=\2"+
		"\2\u0197\u0194\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198\67"+
		"\3\2\2\2\u0199\u019a\7\25\2\2\u019a\u01a6\5\64\33\2\u019b\u019c\7\'\2"+
		"\2\u019c\u019d\7\b\2\2\u019d\u019e\5\26\f\2\u019e\u019f\7\t\2\2\u019f"+
		"\u01a6\3\2\2\2\u01a0\u01a1\7\60\2\2\u01a1\u01a2\7\b\2\2\u01a2\u01a3\5"+
		"\64\33\2\u01a3\u01a4\7\t\2\2\u01a4\u01a6\3\2\2\2\u01a5\u0199\3\2\2\2\u01a5"+
		"\u019b\3\2\2\2\u01a5\u01a0\3\2\2\2\u01a69\3\2\2\2\u01a7\u01b3\5\64\33"+
		"\2\u01a8\u01a9\7\6\2\2\u01a9\u01b3\5\64\33\2\u01aa\u01ab\5\64\33\2\u01ab"+
		"\u01ac\7\6\2\2\u01ac\u01b3\3\2\2\2\u01ad\u01ae\5\64\33\2\u01ae\u01af\7"+
		"\3\2\2\u01af\u01b0\7\3\2\2\u01b0\u01b1\5\64\33\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u01a7\3\2\2\2\u01b2\u01a8\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b2\u01ad\3\2"+
		"\2\2\u01b3;\3\2\2\2*@GQ]jrz\u0081\u0089\u008f\u0094\u009b\u009f\u00a3"+
		"\u00aa\u00ae\u00b3\u00ba\u00be\u00c0\u00c4\u00cb\u00cf\u00d5\u00db\u00dd"+
		"\u00ec\u00f1\u00fd\u0145\u0156\u015e\u0172\u0174\u017e\u018f\u0191\u0197"+
		"\u01a5\u01b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}