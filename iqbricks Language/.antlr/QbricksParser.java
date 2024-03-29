// Generated from /home/tbc23/Desktop/iQbricks/iqbricks Language/Qbricks.g4 by ANTLR 4.9.2

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
		YGATE=30, ZGATE=31, SGATE=32, TGATE=33, PI=34, IN=35, IF=36, INT=37, DEF=38, 
		LEN=39, FOR=40, ROT=41, PHASE=42, PRE=43, POS=44, BOOL=45, QREG=46, CNOT=47, 
		SWAP=48, TOFF=49, FRED=50, SQRT=51, ELSE=52, CIRC=53, APPLY=54, FLOAT=55, 
		RANGE=56, RET=57, ASSERT=58, CONTROL=59, REVERSE=60, WITHCTL=61, WITHCJG=62, 
		INVARIANT=63, IMPORT=64, ID=65, NUM=66, FORMULA=67, COMM=68, SPACE=69;
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_main = 2, RULE_aux = 3, RULE_params = 4, 
		RULE_param = 5, RULE_args = 6, RULE_type = 7, RULE_idFun = 8, RULE_circ = 9, 
		RULE_id_list = 10, RULE_qReg = 11, RULE_body = 12, RULE_pre = 13, RULE_pos = 14, 
		RULE_assert_ = 15, RULE_invariant = 16, RULE_instr = 17, RULE_conjugated = 18, 
		RULE_for_ = 19, RULE_iter = 20, RULE_if_ = 21, RULE_else_ = 22, RULE_apply = 23, 
		RULE_ang = 24, RULE_control = 25, RULE_expr = 26, RULE_term = 27, RULE_atom = 28, 
		RULE_unOp = 29, RULE_range = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "imports", "main", "aux", "params", "param", "args", "type", 
			"idFun", "circ", "id_list", "qReg", "body", "pre", "pos", "assert_", 
			"invariant", "instr", "conjugated", "for_", "iter", "if_", "else_", "apply", 
			"ang", "control", "expr", "term", "atom", "unOp", "range"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'|'", "';'", "':'", "','", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", 
			"'*'", "'/'", "'^'", "'->'", "'||'", "'H'", "'RZ'", "'RX'", "'RY'", "'X'", 
			"'Y'", "'Z'", "'S'", "'T'", "'pi'", "'in'", "'if'", "'int'", "'def'", 
			"'len'", "'for'", "'rot'", "'ph'", "'pre'", "'pos'", "'bool'", "'qreg'", 
			"'cnot'", "'swap'", "'toff'", "'fred'", "'sqrt'", "'else'", "'circ'", 
			"'apply'", "'float'", "'range'", "'return'", "'assert'", "'control'", 
			"'reverse'", "'with control'", "'with conjugated'", "'invariant'", "'import'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PT", "SB", "PTV", "TP", "VG", "OP", "CL", "ROP", "RCL", "COP", 
			"CCL", "EQ", "NEQ", "GEQ", "LEQ", "GT", "LT", "PLUS", "MINUS", "MUL", 
			"DIV", "POW", "ARROW", "BB", "HAD", "RZ", "RX", "RY", "XGATE", "YGATE", 
			"ZGATE", "SGATE", "TGATE", "PI", "IN", "IF", "INT", "DEF", "LEN", "FOR", 
			"ROT", "PHASE", "PRE", "POS", "BOOL", "QREG", "CNOT", "SWAP", "TOFF", 
			"FRED", "SQRT", "ELSE", "CIRC", "APPLY", "FLOAT", "RANGE", "RET", "ASSERT", 
			"CONTROL", "REVERSE", "WITHCTL", "WITHCJG", "INVARIANT", "IMPORT", "ID", 
			"NUM", "FORMULA", "COMM", "SPACE"
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
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORT) {
				{
				setState(62);
				imports();
				}
			}

			setState(65);
			main();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SB) {
				{
				{
				setState(66);
				aux();
				}
				}
				setState(71);
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

	public static class ImportsContext extends ParserRuleContext {
		public Token file;
		public List<TerminalNode> IMPORT() { return getTokens(QbricksParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(QbricksParser.IMPORT, i);
		}
		public List<TerminalNode> ID() { return getTokens(QbricksParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QbricksParser.ID, i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				match(IMPORT);
				setState(73);
				((ImportsContext)_localctx).file = match(ID);
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
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
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		int _la;
		try {
			_localctx = new MainFunContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(BB);
			setState(79);
			idFun();
			setState(80);
			match(BB);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(81);
				params();
				}
			}

			setState(84);
			pre();
			setState(85);
			circ();
			setState(86);
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
	}

	public final AuxContext aux() throws RecognitionException {
		AuxContext _localctx = new AuxContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aux);
		int _la;
		try {
			_localctx = new AuxFunContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(SB);
			setState(89);
			idFun();
			setState(90);
			match(SB);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(91);
				params();
				}
			}

			setState(94);
			pre();
			setState(95);
			circ();
			setState(96);
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
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			_localctx = new FunParamsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(OP);
			setState(99);
			param();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(100);
				match(VG);
				setState(101);
				param();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
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
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			_localctx = new SingleParContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			((SingleParContext)_localctx).ptype = type();
			setState(110);
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
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			_localctx = new FunArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			term(0);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(113);
				match(VG);
				setState(114);
				term(0);
				}
				}
				setState(119);
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
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(QbricksParser.INT, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class CircTypeContext extends TypeContext {
		public TerminalNode CIRC() { return getToken(QbricksParser.CIRC, 0); }
		public CircTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class QrTypeContext extends TypeContext {
		public TerminalNode QREG() { return getToken(QbricksParser.QREG, 0); }
		public QrTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(QbricksParser.BOOL, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(FLOAT);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(BOOL);
				}
				break;
			case CIRC:
				_localctx = new CircTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(CIRC);
				}
				break;
			case QREG:
				_localctx = new QrTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
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
	}

	public final IdFunContext idFun() throws RecognitionException {
		IdFunContext _localctx = new IdFunContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_idFun);
		try {
			_localctx = new FunIdContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
	}

	public final CircContext circ() throws RecognitionException {
		CircContext _localctx = new CircContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_circ);
		int _la;
		try {
			_localctx = new RegCircContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(CIRC);
			setState(130);
			id_list();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(131);
				match(ARROW);
				setState(132);
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
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id_list);
		int _la;
		try {
			_localctx = new QrListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			qReg();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(136);
				match(VG);
				setState(137);
				qReg();
				}
				}
				setState(142);
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
	}

	public final QRegContext qReg() throws RecognitionException {
		QRegContext _localctx = new QRegContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_qReg);
		int _la;
		try {
			_localctx = new QrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((QrContext)_localctx).id = match(ID);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ROP) {
				{
				setState(144);
				match(ROP);
				setState(145);
				((QrContext)_localctx).size = range();
				setState(146);
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
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			_localctx = new RegBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			assert_();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (HAD - 25)) | (1L << (RZ - 25)) | (1L << (RX - 25)) | (1L << (RY - 25)) | (1L << (XGATE - 25)) | (1L << (YGATE - 25)) | (1L << (ZGATE - 25)) | (1L << (SGATE - 25)) | (1L << (TGATE - 25)) | (1L << (IF - 25)) | (1L << (FOR - 25)) | (1L << (PHASE - 25)) | (1L << (CNOT - 25)) | (1L << (SWAP - 25)) | (1L << (TOFF - 25)) | (1L << (FRED - 25)) | (1L << (RET - 25)) | (1L << (REVERSE - 25)) | (1L << (WITHCTL - 25)) | (1L << (WITHCJG - 25)) | (1L << (ID - 25)))) != 0)) {
				{
				{
				setState(151);
				instr();
				}
				}
				setState(156);
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
	}

	public final PreContext pre() throws RecognitionException {
		PreContext _localctx = new PreContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pre);
		int _la;
		try {
			_localctx = new PreSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(PRE);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(158);
				match(COP);
				}
			}

			setState(161);
			match(FORMULA);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(162);
				match(VG);
				setState(163);
				match(FORMULA);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CCL) {
				{
				setState(169);
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
	}

	public final PosContext pos() throws RecognitionException {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pos);
		int _la;
		try {
			_localctx = new PosSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(POS);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(173);
				match(COP);
				}
			}

			setState(176);
			match(FORMULA);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(177);
				match(VG);
				setState(178);
				match(FORMULA);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CCL) {
				{
				setState(184);
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
	}
	public static class EmptyAssertContext extends Assert_Context {
		public EmptyAssertContext(Assert_Context ctx) { copyFrom(ctx); }
	}

	public final Assert_Context assert_() throws RecognitionException {
		Assert_Context _localctx = new Assert_Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_assert_);
		int _la;
		try {
			setState(203);
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
			case SGATE:
			case TGATE:
			case IF:
			case FOR:
			case PHASE:
			case POS:
			case CNOT:
			case SWAP:
			case TOFF:
			case FRED:
			case RET:
			case REVERSE:
			case WITHCTL:
			case WITHCJG:
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
				setState(188);
				match(ASSERT);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COP) {
					{
					setState(189);
					match(COP);
					}
				}

				setState(192);
				match(FORMULA);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VG) {
					{
					{
					setState(193);
					match(VG);
					setState(194);
					match(FORMULA);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(200);
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
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_invariant);
		int _la;
		try {
			_localctx = new InvSpecContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(INVARIANT);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COP) {
				{
				setState(206);
				match(COP);
				}
			}

			setState(209);
			match(FORMULA);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VG) {
				{
				{
				setState(210);
				match(VG);
				setState(211);
				match(FORMULA);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(217);
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
	}
	public static class RegInstContext extends InstrContext {
		public For_Context forinst;
		public If_Context ifinst;
		public ApplyContext applyinst;
		public ControlContext ctlinst;
		public ConjugatedContext conjinst;
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
		public ConjugatedContext conjugated() {
			return getRuleContext(ConjugatedContext.class,0);
		}
		public RegInstContext(InstrContext ctx) { copyFrom(ctx); }
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_instr);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HAD:
			case RZ:
			case RX:
			case RY:
			case XGATE:
			case YGATE:
			case ZGATE:
			case SGATE:
			case TGATE:
			case IF:
			case FOR:
			case PHASE:
			case CNOT:
			case SWAP:
			case TOFF:
			case FRED:
			case REVERSE:
			case WITHCTL:
			case WITHCJG:
			case ID:
				_localctx = new RegInstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FOR:
					{
					setState(220);
					((RegInstContext)_localctx).forinst = for_();
					}
					break;
				case IF:
					{
					setState(221);
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
				case SGATE:
				case TGATE:
				case PHASE:
				case SWAP:
				case REVERSE:
				case ID:
					{
					setState(222);
					((RegInstContext)_localctx).applyinst = apply();
					}
					break;
				case CNOT:
				case TOFF:
				case FRED:
				case WITHCTL:
					{
					setState(223);
					((RegInstContext)_localctx).ctlinst = control();
					}
					break;
				case WITHCJG:
					{
					setState(224);
					((RegInstContext)_localctx).conjinst = conjugated();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(227);
				assert_();
				}
				break;
			case RET:
				_localctx = new RetInstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(RET);
				setState(231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(230);
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

	public static class ConjugatedContext extends ParserRuleContext {
		public ApplyContext applyinst;
		public BodyContext conjbody;
		public TerminalNode WITHCJG() { return getToken(QbricksParser.WITHCJG, 0); }
		public TerminalNode COP() { return getToken(QbricksParser.COP, 0); }
		public TerminalNode CCL() { return getToken(QbricksParser.CCL, 0); }
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ConjugatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjugated; }
	}

	public final ConjugatedContext conjugated() throws RecognitionException {
		ConjugatedContext _localctx = new ConjugatedContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conjugated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(WITHCJG);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP) {
				{
				setState(236);
				match(OP);
				}
			}

			setState(239);
			((ConjugatedContext)_localctx).applyinst = apply();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CL) {
				{
				setState(240);
				match(CL);
				}
			}

			setState(243);
			match(COP);
			setState(244);
			((ConjugatedContext)_localctx).conjbody = body();
			setState(245);
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
	}

	public final For_Context for_() throws RecognitionException {
		For_Context _localctx = new For_Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_);
		try {
			_localctx = new ForLoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(FOR);
			setState(248);
			((ForLoopContext)_localctx).var = match(ID);
			setState(249);
			match(IN);
			setState(250);
			((ForLoopContext)_localctx).iteration = iter();
			setState(251);
			match(COP);
			setState(252);
			((ForLoopContext)_localctx).inv = invariant();
			setState(253);
			((ForLoopContext)_localctx).forbody = body();
			setState(254);
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
	}
	public static class RangeIterContext extends IterContext {
		public TermContext expvalue;
		public QRegContext qrvalue;
		public TerminalNode RANGE() { return getToken(QbricksParser.RANGE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public RangeIterContext(IterContext ctx) { copyFrom(ctx); }
	}

	public final IterContext iter() throws RecognitionException {
		IterContext _localctx = new IterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_iter);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RANGE:
				_localctx = new RangeIterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(RANGE);
				setState(257);
				match(OP);
				setState(260);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(258);
					((RangeIterContext)_localctx).expvalue = term(0);
					}
					break;
				case 2:
					{
					setState(259);
					((RangeIterContext)_localctx).qrvalue = qReg();
					}
					break;
				}
				setState(262);
				match(CL);
				}
				break;
			case ID:
				_localctx = new QrIterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
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
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_if_);
		int _la;
		try {
			_localctx = new CondIfContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(IF);
			setState(268);
			((CondIfContext)_localctx).cond = expr(0);
			setState(269);
			match(COP);
			setState(270);
			((CondIfContext)_localctx).ifbody = body();
			setState(271);
			match(CCL);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(272);
				match(ELSE);
				setState(273);
				match(COP);
				setState(274);
				((CondIfContext)_localctx).elsebody = else_();
				setState(275);
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
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_else_);
		try {
			_localctx = new ElsebodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
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
	}
	public static class TApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode TGATE() { return getToken(QbricksParser.TGATE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public TApplyContext(ApplyContext ctx) { copyFrom(ctx); }
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
	}
	public static class SApplyContext extends ApplyContext {
		public QRegContext qr;
		public TerminalNode SGATE() { return getToken(QbricksParser.SGATE, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public QRegContext qReg() {
			return getRuleContext(QRegContext.class,0);
		}
		public SApplyContext(ApplyContext ctx) { copyFrom(ctx); }
	}

	public final ApplyContext apply() throws RecognitionException {
		ApplyContext _localctx = new ApplyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_apply);
		int _la;
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FunApplyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				((FunApplyContext)_localctx).fun = idFun();
				setState(282);
				match(OP);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (OP - 6)) | (1L << (MINUS - 6)) | (1L << (PI - 6)) | (1L << (LEN - 6)) | (1L << (SQRT - 6)) | (1L << (ID - 6)) | (1L << (NUM - 6)))) != 0)) {
					{
					setState(283);
					((FunApplyContext)_localctx).fargs = args();
					}
				}

				setState(286);
				match(CL);
				}
				break;
			case REVERSE:
				_localctx = new RevApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(REVERSE);
				setState(289);
				match(OP);
				setState(290);
				((RevApplyContext)_localctx).fun = idFun();
				setState(291);
				match(OP);
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (OP - 6)) | (1L << (MINUS - 6)) | (1L << (PI - 6)) | (1L << (LEN - 6)) | (1L << (SQRT - 6)) | (1L << (ID - 6)) | (1L << (NUM - 6)))) != 0)) {
					{
					setState(292);
					((RevApplyContext)_localctx).fargs = args();
					}
				}

				setState(295);
				match(CL);
				setState(296);
				match(CL);
				}
				break;
			case HAD:
				_localctx = new HadApplyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(HAD);
				setState(299);
				match(OP);
				setState(300);
				((HadApplyContext)_localctx).qr = qReg();
				setState(301);
				match(CL);
				}
				break;
			case RZ:
				_localctx = new RzApplyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				match(RZ);
				setState(304);
				match(OP);
				setState(305);
				((RzApplyContext)_localctx).angle = ang();
				setState(306);
				match(VG);
				setState(307);
				((RzApplyContext)_localctx).qr = qReg();
				setState(308);
				match(CL);
				}
				break;
			case RX:
				_localctx = new RxApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(RX);
				setState(311);
				match(OP);
				setState(312);
				((RxApplyContext)_localctx).angle = ang();
				setState(313);
				match(VG);
				setState(314);
				((RxApplyContext)_localctx).qr = qReg();
				setState(315);
				match(CL);
				}
				break;
			case RY:
				_localctx = new RyApplyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(317);
				match(RY);
				setState(318);
				match(OP);
				setState(319);
				((RyApplyContext)_localctx).angle = ang();
				setState(320);
				match(VG);
				setState(321);
				((RyApplyContext)_localctx).qr = qReg();
				setState(322);
				match(CL);
				}
				break;
			case XGATE:
				_localctx = new XApplyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(324);
				match(XGATE);
				setState(325);
				match(OP);
				setState(326);
				((XApplyContext)_localctx).qr = qReg();
				setState(327);
				match(CL);
				}
				break;
			case YGATE:
				_localctx = new YApplyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(329);
				match(YGATE);
				setState(330);
				match(OP);
				setState(331);
				((YApplyContext)_localctx).qr = qReg();
				setState(332);
				match(CL);
				}
				break;
			case ZGATE:
				_localctx = new ZApplyContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(334);
				match(ZGATE);
				setState(335);
				match(OP);
				setState(336);
				((ZApplyContext)_localctx).qr = qReg();
				setState(337);
				match(CL);
				}
				break;
			case SWAP:
				_localctx = new SwapApplyContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(339);
				match(SWAP);
				setState(340);
				match(OP);
				setState(341);
				((SwapApplyContext)_localctx).qrL = qReg();
				setState(342);
				match(VG);
				setState(343);
				((SwapApplyContext)_localctx).qrR = qReg();
				setState(344);
				match(CL);
				}
				break;
			case PHASE:
				_localctx = new PhApplyContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(346);
				match(PHASE);
				setState(347);
				match(OP);
				setState(348);
				((PhApplyContext)_localctx).angle = ang();
				setState(349);
				match(VG);
				setState(350);
				((PhApplyContext)_localctx).qr = qReg();
				setState(351);
				match(CL);
				}
				break;
			case TGATE:
				_localctx = new TApplyContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(353);
				match(TGATE);
				setState(354);
				match(OP);
				setState(355);
				((TApplyContext)_localctx).qr = qReg();
				setState(356);
				match(CL);
				}
				break;
			case SGATE:
				_localctx = new SApplyContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(358);
				match(SGATE);
				setState(359);
				match(OP);
				setState(360);
				((SApplyContext)_localctx).qr = qReg();
				setState(361);
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
	}

	public final AngContext ang() throws RecognitionException {
		AngContext _localctx = new AngContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ang);
		try {
			_localctx = new AngTermContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
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
	}
	public static class MultiControlContext extends ControlContext {
		public Id_listContext ctlqrs;
		public ControlContext ctlgate;
		public TerminalNode WITHCTL() { return getToken(QbricksParser.WITHCTL, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public ControlContext control() {
			return getRuleContext(ControlContext.class,0);
		}
		public MultiControlContext(ControlContext ctx) { copyFrom(ctx); }
	}
	public static class ToffControlContext extends ControlContext {
		public QRegContext ctl1;
		public QRegContext ctl2;
		public QRegContext tg;
		public TerminalNode TOFF() { return getToken(QbricksParser.TOFF, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public List<QRegContext> qReg() {
			return getRuleContexts(QRegContext.class);
		}
		public QRegContext qReg(int i) {
			return getRuleContext(QRegContext.class,i);
		}
		public ToffControlContext(ControlContext ctx) { copyFrom(ctx); }
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
	}
	public static class FredControlContext extends ControlContext {
		public QRegContext ctl1;
		public QRegContext ctl2;
		public QRegContext tg;
		public TerminalNode FRED() { return getToken(QbricksParser.FRED, 0); }
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public List<TerminalNode> VG() { return getTokens(QbricksParser.VG); }
		public TerminalNode VG(int i) {
			return getToken(QbricksParser.VG, i);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public List<QRegContext> qReg() {
			return getRuleContexts(QRegContext.class);
		}
		public QRegContext qReg(int i) {
			return getRuleContext(QRegContext.class,i);
		}
		public FredControlContext(ControlContext ctx) { copyFrom(ctx); }
	}

	public final ControlContext control() throws RecognitionException {
		ControlContext _localctx = new ControlContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_control);
		try {
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new ApplyControlContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(WITHCTL);
				setState(368);
				((ApplyControlContext)_localctx).ctlqrs = id_list();
				setState(369);
				match(OP);
				setState(370);
				((ApplyControlContext)_localctx).ctlgate = apply();
				setState(371);
				match(CL);
				}
				break;
			case 2:
				_localctx = new MultiControlContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(WITHCTL);
				setState(374);
				((MultiControlContext)_localctx).ctlqrs = id_list();
				setState(375);
				match(OP);
				setState(376);
				((MultiControlContext)_localctx).ctlgate = control();
				setState(377);
				match(CL);
				}
				break;
			case 3:
				_localctx = new CnotControlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(379);
				match(CNOT);
				setState(380);
				match(OP);
				setState(381);
				((CnotControlContext)_localctx).ctlqr = qReg();
				setState(382);
				match(VG);
				setState(383);
				((CnotControlContext)_localctx).tqr = qReg();
				setState(384);
				match(CL);
				}
				break;
			case 4:
				_localctx = new ToffControlContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(386);
				match(TOFF);
				setState(387);
				match(OP);
				setState(388);
				((ToffControlContext)_localctx).ctl1 = qReg();
				setState(389);
				match(VG);
				setState(390);
				((ToffControlContext)_localctx).ctl2 = qReg();
				setState(391);
				match(VG);
				setState(392);
				((ToffControlContext)_localctx).tg = qReg();
				setState(393);
				match(CL);
				}
				break;
			case 5:
				_localctx = new FredControlContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(395);
				match(FRED);
				setState(396);
				match(OP);
				setState(397);
				((FredControlContext)_localctx).ctl1 = qReg();
				setState(398);
				match(VG);
				setState(399);
				((FredControlContext)_localctx).ctl2 = qReg();
				setState(400);
				match(VG);
				setState(401);
				((FredControlContext)_localctx).tg = qReg();
				setState(402);
				match(CL);
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
	}
	public static class TermExprContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new TermExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(407);
				term(0);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408);
				match(OP);
				setState(409);
				expr(0);
				setState(410);
				match(CL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(434);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(432);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						((EqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(414);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(415);
						((EqExprContext)_localctx).op = match(EQ);
						setState(416);
						((EqExprContext)_localctx).right = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new GtExprContext(new ExprContext(_parentctx, _parentState));
						((GtExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(417);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(418);
						((GtExprContext)_localctx).op = match(GT);
						setState(419);
						((GtExprContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new LtExprContext(new ExprContext(_parentctx, _parentState));
						((LtExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(420);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(421);
						((LtExprContext)_localctx).op = match(LT);
						setState(422);
						((LtExprContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new GeqExprContext(new ExprContext(_parentctx, _parentState));
						((GeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(423);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(424);
						((GeqExprContext)_localctx).op = match(GEQ);
						setState(425);
						((GeqExprContext)_localctx).right = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new LeqExprContext(new ExprContext(_parentctx, _parentState));
						((LeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(426);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(427);
						((LeqExprContext)_localctx).op = match(LEQ);
						setState(428);
						((LeqExprContext)_localctx).right = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new NeqExprContext(new ExprContext(_parentctx, _parentState));
						((NeqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(429);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(430);
						((NeqExprContext)_localctx).op = match(NEQ);
						setState(431);
						((NeqExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(436);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
	}
	public static class UnaryTermContext extends TermContext {
		public UnOpContext unOp() {
			return getRuleContext(UnOpContext.class,0);
		}
		public UnaryTermContext(TermContext ctx) { copyFrom(ctx); }
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
	}
	public static class AtomTermContext extends TermContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomTermContext(TermContext ctx) { copyFrom(ctx); }
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
	}
	public static class ParenTermContext extends TermContext {
		public TerminalNode OP() { return getToken(QbricksParser.OP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode CL() { return getToken(QbricksParser.CL, 0); }
		public ParenTermContext(TermContext ctx) { copyFrom(ctx); }
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
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PI:
			case ID:
			case NUM:
				{
				_localctx = new AtomTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(438);
				atom();
				}
				break;
			case OP:
				{
				_localctx = new ParenTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(439);
				match(OP);
				setState(440);
				term(0);
				setState(441);
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
				setState(443);
				unOp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(461);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new PowTermContext(new TermContext(_parentctx, _parentState));
						((PowTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(446);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(447);
						((PowTermContext)_localctx).op = match(POW);
						setState(448);
						((PowTermContext)_localctx).right = term(8);
						}
						break;
					case 2:
						{
						_localctx = new MulTermContext(new TermContext(_parentctx, _parentState));
						((MulTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(449);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(450);
						((MulTermContext)_localctx).op = match(MUL);
						setState(451);
						((MulTermContext)_localctx).right = term(7);
						}
						break;
					case 3:
						{
						_localctx = new DivTermContext(new TermContext(_parentctx, _parentState));
						((DivTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(452);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(453);
						((DivTermContext)_localctx).op = match(DIV);
						setState(454);
						((DivTermContext)_localctx).right = term(6);
						}
						break;
					case 4:
						{
						_localctx = new AddTermContext(new TermContext(_parentctx, _parentState));
						((AddTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(455);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(456);
						((AddTermContext)_localctx).op = match(PLUS);
						setState(457);
						((AddTermContext)_localctx).right = term(5);
						}
						break;
					case 5:
						{
						_localctx = new SubTermContext(new TermContext(_parentctx, _parentState));
						((SubTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(458);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(459);
						((SubTermContext)_localctx).op = match(MINUS);
						setState(460);
						((SubTermContext)_localctx).right = term(4);
						}
						break;
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
	}
	public static class NumAtomContext extends AtomContext {
		public Token value;
		public TerminalNode NUM() { return getToken(QbricksParser.NUM, 0); }
		public NumAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class PiAtomContext extends AtomContext {
		public Token pi;
		public TerminalNode PI() { return getToken(QbricksParser.PI, 0); }
		public PiAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_atom);
		try {
			setState(469);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				((NumAtomContext)_localctx).value = match(NUM);
				}
				break;
			case PI:
				_localctx = new PiAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				((PiAtomContext)_localctx).pi = match(PI);
				}
				break;
			case ID:
				_localctx = new VarAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(468);
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
	}
	public static class NegUnaryContext extends UnOpContext {
		public TerminalNode MINUS() { return getToken(QbricksParser.MINUS, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NegUnaryContext(UnOpContext ctx) { copyFrom(ctx); }
	}

	public final UnOpContext unOp() throws RecognitionException {
		UnOpContext _localctx = new UnOpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unOp);
		try {
			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new NegUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				match(MINUS);
				setState(472);
				term(0);
				}
				break;
			case LEN:
				_localctx = new LenUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				match(LEN);
				setState(474);
				match(OP);
				setState(475);
				qReg();
				setState(476);
				match(CL);
				}
				break;
			case SQRT:
				_localctx = new SqrtUnaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				match(SQRT);
				setState(479);
				match(OP);
				setState(480);
				((SqrtUnaryContext)_localctx).value = term(0);
				setState(481);
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
	}
	public static class FromRangeContext extends RangeContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode TP() { return getToken(QbricksParser.TP, 0); }
		public FromRangeContext(RangeContext ctx) { copyFrom(ctx); }
	}
	public static class UptoRangeContext extends RangeContext {
		public TerminalNode TP() { return getToken(QbricksParser.TP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UptoRangeContext(RangeContext ctx) { copyFrom(ctx); }
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_range);
		try {
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new TermRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				term(0);
				}
				break;
			case 2:
				_localctx = new UptoRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				match(TP);
				setState(487);
				term(0);
				}
				break;
			case 3:
				_localctx = new FromRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(488);
				term(0);
				setState(489);
				match(TP);
				}
				break;
			case 4:
				_localctx = new IntervalRangeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(491);
				((IntervalRangeContext)_localctx).start = term(0);
				setState(492);
				match(PT);
				setState(493);
				match(PT);
				setState(494);
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
		case 26:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 27:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u01f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\5\2B\n\2\3\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\3\3\3\6\3M\n\3\r\3\16\3N\3"+
		"\4\3\4\3\4\3\4\5\4U\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5_\n\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\7\bv\n\b\f\b\16\by\13\b\3\t\3\t\3\t\3\t\3\t\5\t\u0080\n\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\7\f\u008d\n\f"+
		"\f\f\16\f\u0090\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u0097\n\r\3\16\3\16\7\16"+
		"\u009b\n\16\f\16\16\16\u009e\13\16\3\17\3\17\5\17\u00a2\n\17\3\17\3\17"+
		"\3\17\7\17\u00a7\n\17\f\17\16\17\u00aa\13\17\3\17\5\17\u00ad\n\17\3\20"+
		"\3\20\5\20\u00b1\n\20\3\20\3\20\3\20\7\20\u00b6\n\20\f\20\16\20\u00b9"+
		"\13\20\3\20\5\20\u00bc\n\20\3\21\3\21\3\21\5\21\u00c1\n\21\3\21\3\21\3"+
		"\21\7\21\u00c6\n\21\f\21\16\21\u00c9\13\21\3\21\5\21\u00cc\n\21\5\21\u00ce"+
		"\n\21\3\22\3\22\5\22\u00d2\n\22\3\22\3\22\3\22\7\22\u00d7\n\22\f\22\16"+
		"\22\u00da\13\22\3\22\5\22\u00dd\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00e4"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u00ea\n\23\5\23\u00ec\n\23\3\24\3\24\5"+
		"\24\u00f0\n\24\3\24\3\24\5\24\u00f4\n\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u0107\n\26"+
		"\3\26\3\26\3\26\5\26\u010c\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u0118\n\27\3\30\3\30\3\31\3\31\3\31\5\31\u011f\n\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0128\n\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u016e\n\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0197\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u019f\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u01b3\n\34\f\34"+
		"\16\34\u01b6\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01bf\n\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\7\35\u01d0\n\35\f\35\16\35\u01d3\13\35\3\36\3\36\3\36\5\36\u01d8"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u01e6\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01f3\n \3 \2\4\668!\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\2\2\u0223"+
		"\2A\3\2\2\2\4L\3\2\2\2\6P\3\2\2\2\bZ\3\2\2\2\nd\3\2\2\2\fo\3\2\2\2\16"+
		"r\3\2\2\2\20\177\3\2\2\2\22\u0081\3\2\2\2\24\u0083\3\2\2\2\26\u0089\3"+
		"\2\2\2\30\u0091\3\2\2\2\32\u0098\3\2\2\2\34\u009f\3\2\2\2\36\u00ae\3\2"+
		"\2\2 \u00cd\3\2\2\2\"\u00cf\3\2\2\2$\u00eb\3\2\2\2&\u00ed\3\2\2\2(\u00f9"+
		"\3\2\2\2*\u010b\3\2\2\2,\u010d\3\2\2\2.\u0119\3\2\2\2\60\u016d\3\2\2\2"+
		"\62\u016f\3\2\2\2\64\u0196\3\2\2\2\66\u019e\3\2\2\28\u01be\3\2\2\2:\u01d7"+
		"\3\2\2\2<\u01e5\3\2\2\2>\u01f2\3\2\2\2@B\5\4\3\2A@\3\2\2\2AB\3\2\2\2B"+
		"C\3\2\2\2CG\5\6\4\2DF\5\b\5\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2"+
		"H\3\3\2\2\2IG\3\2\2\2JK\7B\2\2KM\7C\2\2LJ\3\2\2\2MN\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2O\5\3\2\2\2PQ\7\32\2\2QR\5\22\n\2RT\7\32\2\2SU\5\n\6\2TS\3\2"+
		"\2\2TU\3\2\2\2UV\3\2\2\2VW\5\34\17\2WX\5\24\13\2XY\5\36\20\2Y\7\3\2\2"+
		"\2Z[\7\4\2\2[\\\5\22\n\2\\^\7\4\2\2]_\5\n\6\2^]\3\2\2\2^_\3\2\2\2_`\3"+
		"\2\2\2`a\5\34\17\2ab\5\24\13\2bc\5\36\20\2c\t\3\2\2\2de\7\b\2\2ej\5\f"+
		"\7\2fg\7\7\2\2gi\5\f\7\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2lj\3\2\2\2mn\7\t\2\2n\13\3\2\2\2op\5\20\t\2pq\7C\2\2q\r\3\2\2\2rw"+
		"\58\35\2st\7\7\2\2tv\58\35\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x"+
		"\17\3\2\2\2yw\3\2\2\2z\u0080\7\'\2\2{\u0080\79\2\2|\u0080\7/\2\2}\u0080"+
		"\7\67\2\2~\u0080\7\60\2\2\177z\3\2\2\2\177{\3\2\2\2\177|\3\2\2\2\177}"+
		"\3\2\2\2\177~\3\2\2\2\u0080\21\3\2\2\2\u0081\u0082\7C\2\2\u0082\23\3\2"+
		"\2\2\u0083\u0084\7\67\2\2\u0084\u0087\5\26\f\2\u0085\u0086\7\31\2\2\u0086"+
		"\u0088\5\32\16\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\25\3\2"+
		"\2\2\u0089\u008e\5\30\r\2\u008a\u008b\7\7\2\2\u008b\u008d\5\30\r\2\u008c"+
		"\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\27\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0096\7C\2\2\u0092\u0093"+
		"\7\n\2\2\u0093\u0094\5> \2\u0094\u0095\7\13\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0092\3\2\2\2\u0096\u0097\3\2\2\2\u0097\31\3\2\2\2\u0098\u009c\5 \21"+
		"\2\u0099\u009b\5$\23\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\33\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a1\7-\2\2\u00a0\u00a2\7\f\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a8\7E\2\2\u00a4\u00a5\7\7\2\2\u00a5"+
		"\u00a7\7E\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\7\r\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\35\3\2\2"+
		"\2\u00ae\u00b0\7.\2\2\u00af\u00b1\7\f\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b7\7E\2\2\u00b3\u00b4\7\7\2\2\u00b4"+
		"\u00b6\7E\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bc\7\r\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\37\3\2\2"+
		"\2\u00bd\u00ce\3\2\2\2\u00be\u00c0\7<\2\2\u00bf\u00c1\7\f\2\2\u00c0\u00bf"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c7\7E\2\2\u00c3"+
		"\u00c4\7\7\2\2\u00c4\u00c6\7E\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cc\7\r\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00bd\3\2\2\2\u00cd\u00be\3\2\2\2\u00ce"+
		"!\3\2\2\2\u00cf\u00d1\7A\2\2\u00d0\u00d2\7\f\2\2\u00d1\u00d0\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d8\7E\2\2\u00d4\u00d5\7\7"+
		"\2\2\u00d5\u00d7\7E\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00db\u00dd\7\r\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"#\3\2\2\2\u00de\u00e4\5(\25\2\u00df\u00e4\5,\27\2\u00e0\u00e4\5\60\31"+
		"\2\u00e1\u00e4\5\64\33\2\u00e2\u00e4\5&\24\2\u00e3\u00de\3\2\2\2\u00e3"+
		"\u00df\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\5 \21\2\u00e6\u00ec\3\2\2\2\u00e7"+
		"\u00e9\7;\2\2\u00e8\u00ea\5\66\34\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00e7\3\2\2\2\u00ec"+
		"%\3\2\2\2\u00ed\u00ef\7@\2\2\u00ee\u00f0\7\b\2\2\u00ef\u00ee\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\5\60\31\2\u00f2\u00f4\7"+
		"\t\2\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\7\f\2\2\u00f6\u00f7\5\32\16\2\u00f7\u00f8\7\r\2\2\u00f8\'\3\2\2"+
		"\2\u00f9\u00fa\7*\2\2\u00fa\u00fb\7C\2\2\u00fb\u00fc\7%\2\2\u00fc\u00fd"+
		"\5*\26\2\u00fd\u00fe\7\f\2\2\u00fe\u00ff\5\"\22\2\u00ff\u0100\5\32\16"+
		"\2\u0100\u0101\7\r\2\2\u0101)\3\2\2\2\u0102\u0103\7:\2\2\u0103\u0106\7"+
		"\b\2\2\u0104\u0107\58\35\2\u0105\u0107\5\30\r\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\t\2\2\u0109\u010c\3\2"+
		"\2\2\u010a\u010c\5\30\r\2\u010b\u0102\3\2\2\2\u010b\u010a\3\2\2\2\u010c"+
		"+\3\2\2\2\u010d\u010e\7&\2\2\u010e\u010f\5\66\34\2\u010f\u0110\7\f\2\2"+
		"\u0110\u0111\5\32\16\2\u0111\u0117\7\r\2\2\u0112\u0113\7\66\2\2\u0113"+
		"\u0114\7\f\2\2\u0114\u0115\5.\30\2\u0115\u0116\7\r\2\2\u0116\u0118\3\2"+
		"\2\2\u0117\u0112\3\2\2\2\u0117\u0118\3\2\2\2\u0118-\3\2\2\2\u0119\u011a"+
		"\5\32\16\2\u011a/\3\2\2\2\u011b\u011c\5\22\n\2\u011c\u011e\7\b\2\2\u011d"+
		"\u011f\5\16\b\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3"+
		"\2\2\2\u0120\u0121\7\t\2\2\u0121\u016e\3\2\2\2\u0122\u0123\7>\2\2\u0123"+
		"\u0124\7\b\2\2\u0124\u0125\5\22\n\2\u0125\u0127\7\b\2\2\u0126\u0128\5"+
		"\16\b\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\7\t\2\2\u012a\u012b\7\t\2\2\u012b\u016e\3\2\2\2\u012c\u012d\7\33"+
		"\2\2\u012d\u012e\7\b\2\2\u012e\u012f\5\30\r\2\u012f\u0130\7\t\2\2\u0130"+
		"\u016e\3\2\2\2\u0131\u0132\7\34\2\2\u0132\u0133\7\b\2\2\u0133\u0134\5"+
		"\62\32\2\u0134\u0135\7\7\2\2\u0135\u0136\5\30\r\2\u0136\u0137\7\t\2\2"+
		"\u0137\u016e\3\2\2\2\u0138\u0139\7\35\2\2\u0139\u013a\7\b\2\2\u013a\u013b"+
		"\5\62\32\2\u013b\u013c\7\7\2\2\u013c\u013d\5\30\r\2\u013d\u013e\7\t\2"+
		"\2\u013e\u016e\3\2\2\2\u013f\u0140\7\36\2\2\u0140\u0141\7\b\2\2\u0141"+
		"\u0142\5\62\32\2\u0142\u0143\7\7\2\2\u0143\u0144\5\30\r\2\u0144\u0145"+
		"\7\t\2\2\u0145\u016e\3\2\2\2\u0146\u0147\7\37\2\2\u0147\u0148\7\b\2\2"+
		"\u0148\u0149\5\30\r\2\u0149\u014a\7\t\2\2\u014a\u016e\3\2\2\2\u014b\u014c"+
		"\7 \2\2\u014c\u014d\7\b\2\2\u014d\u014e\5\30\r\2\u014e\u014f\7\t\2\2\u014f"+
		"\u016e\3\2\2\2\u0150\u0151\7!\2\2\u0151\u0152\7\b\2\2\u0152\u0153\5\30"+
		"\r\2\u0153\u0154\7\t\2\2\u0154\u016e\3\2\2\2\u0155\u0156\7\62\2\2\u0156"+
		"\u0157\7\b\2\2\u0157\u0158\5\30\r\2\u0158\u0159\7\7\2\2\u0159\u015a\5"+
		"\30\r\2\u015a\u015b\7\t\2\2\u015b\u016e\3\2\2\2\u015c\u015d\7,\2\2\u015d"+
		"\u015e\7\b\2\2\u015e\u015f\5\62\32\2\u015f\u0160\7\7\2\2\u0160\u0161\5"+
		"\30\r\2\u0161\u0162\7\t\2\2\u0162\u016e\3\2\2\2\u0163\u0164\7#\2\2\u0164"+
		"\u0165\7\b\2\2\u0165\u0166\5\30\r\2\u0166\u0167\7\t\2\2\u0167\u016e\3"+
		"\2\2\2\u0168\u0169\7\"\2\2\u0169\u016a\7\b\2\2\u016a\u016b\5\30\r\2\u016b"+
		"\u016c\7\t\2\2\u016c\u016e\3\2\2\2\u016d\u011b\3\2\2\2\u016d\u0122\3\2"+
		"\2\2\u016d\u012c\3\2\2\2\u016d\u0131\3\2\2\2\u016d\u0138\3\2\2\2\u016d"+
		"\u013f\3\2\2\2\u016d\u0146\3\2\2\2\u016d\u014b\3\2\2\2\u016d\u0150\3\2"+
		"\2\2\u016d\u0155\3\2\2\2\u016d\u015c\3\2\2\2\u016d\u0163\3\2\2\2\u016d"+
		"\u0168\3\2\2\2\u016e\61\3\2\2\2\u016f\u0170\58\35\2\u0170\63\3\2\2\2\u0171"+
		"\u0172\7?\2\2\u0172\u0173\5\26\f\2\u0173\u0174\7\b\2\2\u0174\u0175\5\60"+
		"\31\2\u0175\u0176\7\t\2\2\u0176\u0197\3\2\2\2\u0177\u0178\7?\2\2\u0178"+
		"\u0179\5\26\f\2\u0179\u017a\7\b\2\2\u017a\u017b\5\64\33\2\u017b\u017c"+
		"\7\t\2\2\u017c\u0197\3\2\2\2\u017d\u017e\7\61\2\2\u017e\u017f\7\b\2\2"+
		"\u017f\u0180\5\30\r\2\u0180\u0181\7\7\2\2\u0181\u0182\5\30\r\2\u0182\u0183"+
		"\7\t\2\2\u0183\u0197\3\2\2\2\u0184\u0185\7\63\2\2\u0185\u0186\7\b\2\2"+
		"\u0186\u0187\5\30\r\2\u0187\u0188\7\7\2\2\u0188\u0189\5\30\r\2\u0189\u018a"+
		"\7\7\2\2\u018a\u018b\5\30\r\2\u018b\u018c\7\t\2\2\u018c\u0197\3\2\2\2"+
		"\u018d\u018e\7\64\2\2\u018e\u018f\7\b\2\2\u018f\u0190\5\30\r\2\u0190\u0191"+
		"\7\7\2\2\u0191\u0192\5\30\r\2\u0192\u0193\7\7\2\2\u0193\u0194\5\30\r\2"+
		"\u0194\u0195\7\t\2\2\u0195\u0197\3\2\2\2\u0196\u0171\3\2\2\2\u0196\u0177"+
		"\3\2\2\2\u0196\u017d\3\2\2\2\u0196\u0184\3\2\2\2\u0196\u018d\3\2\2\2\u0197"+
		"\65\3\2\2\2\u0198\u0199\b\34\1\2\u0199\u019f\58\35\2\u019a\u019b\7\b\2"+
		"\2\u019b\u019c\5\66\34\2\u019c\u019d\7\t\2\2\u019d\u019f\3\2\2\2\u019e"+
		"\u0198\3\2\2\2\u019e\u019a\3\2\2\2\u019f\u01b4\3\2\2\2\u01a0\u01a1\f\t"+
		"\2\2\u01a1\u01a2\7\16\2\2\u01a2\u01b3\5\66\34\n\u01a3\u01a4\f\b\2\2\u01a4"+
		"\u01a5\7\22\2\2\u01a5\u01b3\5\66\34\t\u01a6\u01a7\f\7\2\2\u01a7\u01a8"+
		"\7\23\2\2\u01a8\u01b3\5\66\34\b\u01a9\u01aa\f\6\2\2\u01aa\u01ab\7\20\2"+
		"\2\u01ab\u01b3\5\66\34\7\u01ac\u01ad\f\5\2\2\u01ad\u01ae\7\21\2\2\u01ae"+
		"\u01b3\5\66\34\6\u01af\u01b0\f\4\2\2\u01b0\u01b1\7\17\2\2\u01b1\u01b3"+
		"\5\66\34\5\u01b2\u01a0\3\2\2\2\u01b2\u01a3\3\2\2\2\u01b2\u01a6\3\2\2\2"+
		"\u01b2\u01a9\3\2\2\2\u01b2\u01ac\3\2\2\2\u01b2\u01af\3\2\2\2\u01b3\u01b6"+
		"\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\67\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01b8\b\35\1\2\u01b8\u01bf\5:\36\2\u01b9\u01ba\7"+
		"\b\2\2\u01ba\u01bb\58\35\2\u01bb\u01bc\7\t\2\2\u01bc\u01bf\3\2\2\2\u01bd"+
		"\u01bf\5<\37\2\u01be\u01b7\3\2\2\2\u01be\u01b9\3\2\2\2\u01be\u01bd\3\2"+
		"\2\2\u01bf\u01d1\3\2\2\2\u01c0\u01c1\f\t\2\2\u01c1\u01c2\7\30\2\2\u01c2"+
		"\u01d0\58\35\n\u01c3\u01c4\f\b\2\2\u01c4\u01c5\7\26\2\2\u01c5\u01d0\5"+
		"8\35\t\u01c6\u01c7\f\7\2\2\u01c7\u01c8\7\27\2\2\u01c8\u01d0\58\35\b\u01c9"+
		"\u01ca\f\6\2\2\u01ca\u01cb\7\24\2\2\u01cb\u01d0\58\35\7\u01cc\u01cd\f"+
		"\5\2\2\u01cd\u01ce\7\25\2\2\u01ce\u01d0\58\35\6\u01cf\u01c0\3\2\2\2\u01cf"+
		"\u01c3\3\2\2\2\u01cf\u01c6\3\2\2\2\u01cf\u01c9\3\2\2\2\u01cf\u01cc\3\2"+
		"\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"9\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d8\7D\2\2\u01d5\u01d8\7$\2\2\u01d6"+
		"\u01d8\7C\2\2\u01d7\u01d4\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2"+
		"\2\2\u01d8;\3\2\2\2\u01d9\u01da\7\25\2\2\u01da\u01e6\58\35\2\u01db\u01dc"+
		"\7)\2\2\u01dc\u01dd\7\b\2\2\u01dd\u01de\5\30\r\2\u01de\u01df\7\t\2\2\u01df"+
		"\u01e6\3\2\2\2\u01e0\u01e1\7\65\2\2\u01e1\u01e2\7\b\2\2\u01e2\u01e3\5"+
		"8\35\2\u01e3\u01e4\7\t\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01d9\3\2\2\2\u01e5"+
		"\u01db\3\2\2\2\u01e5\u01e0\3\2\2\2\u01e6=\3\2\2\2\u01e7\u01f3\58\35\2"+
		"\u01e8\u01e9\7\6\2\2\u01e9\u01f3\58\35\2\u01ea\u01eb\58\35\2\u01eb\u01ec"+
		"\7\6\2\2\u01ec\u01f3\3\2\2\2\u01ed\u01ee\58\35\2\u01ee\u01ef\7\3\2\2\u01ef"+
		"\u01f0\7\3\2\2\u01f0\u01f1\58\35\2\u01f1\u01f3\3\2\2\2\u01f2\u01e7\3\2"+
		"\2\2\u01f2\u01e8\3\2\2\2\u01f2\u01ea\3\2\2\2\u01f2\u01ed\3\2\2\2\u01f3"+
		"?\3\2\2\2\60AGNT^jw\177\u0087\u008e\u0096\u009c\u00a1\u00a8\u00ac\u00b0"+
		"\u00b7\u00bb\u00c0\u00c7\u00cb\u00cd\u00d1\u00d8\u00dc\u00e3\u00e9\u00eb"+
		"\u00ef\u00f3\u0106\u010b\u0117\u011e\u0127\u016d\u0196\u019e\u01b2\u01b4"+
		"\u01be\u01cf\u01d1\u01d7\u01e5\u01f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}