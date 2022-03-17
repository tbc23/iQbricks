// Generated from /home/tomas/Desktop/qstar/Qstar Language/Qbricks.g4 by ANTLR 4.9.2

        import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QbricksLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PT", "SB", "PTV", "TP", "VG", "OP", "CL", "ROP", "RCL", "COP", "CCL", 
			"EQ", "NEQ", "GEQ", "LEQ", "GT", "LT", "PLUS", "MINUS", "MUL", "DIV", 
			"POW", "ARROW", "BB", "HAD", "RZ", "RX", "RY", "XGATE", "YGATE", "ZGATE", 
			"PI", "IN", "IF", "INT", "DEF", "LEN", "FOR", "ROT", "PRE", "POS", "BOOL", 
			"QREG", "CNOT", "SWAP", "SQRT", "ELSE", "CIRC", "APPLY", "FLOAT", "PHASE", 
			"RANGE", "RET", "ASSERT", "CONTROL", "REVERSE", "WITHCTL", "INVARIANT", 
			"ID", "NUM", "FORMULA", "COMM", "SPACE"
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


	public QbricksLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Qbricks.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u0182\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\38\38\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\7<\u015d\n<\f<\16"+
		"<\u0160\13<\3=\6=\u0163\n=\r=\16=\u0164\3>\3>\6>\u0169\n>\r>\16>\u016a"+
		"\3>\3>\3?\3?\7?\u0171\n?\f?\16?\u0174\13?\3?\3?\3@\5@\u0179\n@\3@\3@\6"+
		"@\u017d\n@\r@\16@\u017e\3@\3@\2\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\7\4\2C\\"+
		"c|\6\2\62;C\\aac|\3\2\62;\3\2\f\f\4\2\13\13\"\"\2\u0188\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0083\3\2\2\2\7\u0085\3\2\2\2\t"+
		"\u0087\3\2\2\2\13\u0089\3\2\2\2\r\u008b\3\2\2\2\17\u008d\3\2\2\2\21\u008f"+
		"\3\2\2\2\23\u0091\3\2\2\2\25\u0093\3\2\2\2\27\u0095\3\2\2\2\31\u0097\3"+
		"\2\2\2\33\u009a\3\2\2\2\35\u009d\3\2\2\2\37\u00a0\3\2\2\2!\u00a3\3\2\2"+
		"\2#\u00a5\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ad"+
		"\3\2\2\2-\u00af\3\2\2\2/\u00b1\3\2\2\2\61\u00b4\3\2\2\2\63\u00b7\3\2\2"+
		"\2\65\u00b9\3\2\2\2\67\u00bc\3\2\2\29\u00bf\3\2\2\2;\u00c2\3\2\2\2=\u00c4"+
		"\3\2\2\2?\u00c6\3\2\2\2A\u00c8\3\2\2\2C\u00cb\3\2\2\2E\u00ce\3\2\2\2G"+
		"\u00d1\3\2\2\2I\u00d5\3\2\2\2K\u00d9\3\2\2\2M\u00dd\3\2\2\2O\u00e1\3\2"+
		"\2\2Q\u00e5\3\2\2\2S\u00e9\3\2\2\2U\u00ed\3\2\2\2W\u00f2\3\2\2\2Y\u00f7"+
		"\3\2\2\2[\u00fc\3\2\2\2]\u0101\3\2\2\2_\u0106\3\2\2\2a\u010b\3\2\2\2c"+
		"\u0110\3\2\2\2e\u0116\3\2\2\2g\u011c\3\2\2\2i\u011f\3\2\2\2k\u0125\3\2"+
		"\2\2m\u012c\3\2\2\2o\u0133\3\2\2\2q\u013b\3\2\2\2s\u0143\3\2\2\2u\u0150"+
		"\3\2\2\2w\u015a\3\2\2\2y\u0162\3\2\2\2{\u0166\3\2\2\2}\u016e\3\2\2\2\177"+
		"\u017c\3\2\2\2\u0081\u0082\7\60\2\2\u0082\4\3\2\2\2\u0083\u0084\7~\2\2"+
		"\u0084\6\3\2\2\2\u0085\u0086\7=\2\2\u0086\b\3\2\2\2\u0087\u0088\7<\2\2"+
		"\u0088\n\3\2\2\2\u0089\u008a\7.\2\2\u008a\f\3\2\2\2\u008b\u008c\7*\2\2"+
		"\u008c\16\3\2\2\2\u008d\u008e\7+\2\2\u008e\20\3\2\2\2\u008f\u0090\7]\2"+
		"\2\u0090\22\3\2\2\2\u0091\u0092\7_\2\2\u0092\24\3\2\2\2\u0093\u0094\7"+
		"}\2\2\u0094\26\3\2\2\2\u0095\u0096\7\177\2\2\u0096\30\3\2\2\2\u0097\u0098"+
		"\7?\2\2\u0098\u0099\7?\2\2\u0099\32\3\2\2\2\u009a\u009b\7#\2\2\u009b\u009c"+
		"\7?\2\2\u009c\34\3\2\2\2\u009d\u009e\7@\2\2\u009e\u009f\7?\2\2\u009f\36"+
		"\3\2\2\2\u00a0\u00a1\7>\2\2\u00a1\u00a2\7?\2\2\u00a2 \3\2\2\2\u00a3\u00a4"+
		"\7@\2\2\u00a4\"\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6$\3\2\2\2\u00a7\u00a8"+
		"\7-\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7/\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7"+
		",\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae,\3\2\2\2\u00af\u00b0\7"+
		"`\2\2\u00b0.\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2\u00b3\7@\2\2\u00b3\60\3"+
		"\2\2\2\u00b4\u00b5\7~\2\2\u00b5\u00b6\7~\2\2\u00b6\62\3\2\2\2\u00b7\u00b8"+
		"\7J\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\7T\2\2\u00ba\u00bb\7\\\2\2\u00bb"+
		"\66\3\2\2\2\u00bc\u00bd\7T\2\2\u00bd\u00be\7Z\2\2\u00be8\3\2\2\2\u00bf"+
		"\u00c0\7T\2\2\u00c0\u00c1\7[\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7Z\2\2\u00c3"+
		"<\3\2\2\2\u00c4\u00c5\7[\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7\\\2\2\u00c7"+
		"@\3\2\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7k\2\2\u00caB\3\2\2\2\u00cb\u00cc"+
		"\7k\2\2\u00cc\u00cd\7p\2\2\u00cdD\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0"+
		"\7h\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4"+
		"\7v\2\2\u00d4H\3\2\2\2\u00d5\u00d6\7f\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7h\2\2\u00d8J\3\2\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7g\2\2\u00db\u00dc"+
		"\7p\2\2\u00dcL\3\2\2\2\u00dd\u00de\7h\2\2\u00de\u00df\7q\2\2\u00df\u00e0"+
		"\7t\2\2\u00e0N\3\2\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7q\2\2\u00e3\u00e4"+
		"\7v\2\2\u00e4P\3\2\2\2\u00e5\u00e6\7r\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8"+
		"\7g\2\2\u00e8R\3\2\2\2\u00e9\u00ea\7r\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec"+
		"\7u\2\2\u00ecT\3\2\2\2\u00ed\u00ee\7d\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0"+
		"\7q\2\2\u00f0\u00f1\7n\2\2\u00f1V\3\2\2\2\u00f2\u00f3\7s\2\2\u00f3\u00f4"+
		"\7t\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7i\2\2\u00f6X\3\2\2\2\u00f7\u00f8"+
		"\7e\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7v\2\2\u00fb"+
		"Z\3\2\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7y\2\2\u00fe\u00ff\7c\2\2\u00ff"+
		"\u0100\7r\2\2\u0100\\\3\2\2\2\u0101\u0102\7u\2\2\u0102\u0103\7s\2\2\u0103"+
		"\u0104\7t\2\2\u0104\u0105\7v\2\2\u0105^\3\2\2\2\u0106\u0107\7g\2\2\u0107"+
		"\u0108\7n\2\2\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2\u010a`\3\2\2\2\u010b"+
		"\u010c\7e\2\2\u010c\u010d\7k\2\2\u010d\u010e\7t\2\2\u010e\u010f\7e\2\2"+
		"\u010fb\3\2\2\2\u0110\u0111\7c\2\2\u0111\u0112\7r\2\2\u0112\u0113\7r\2"+
		"\2\u0113\u0114\7n\2\2\u0114\u0115\7{\2\2\u0115d\3\2\2\2\u0116\u0117\7"+
		"h\2\2\u0117\u0118\7n\2\2\u0118\u0119\7q\2\2\u0119\u011a\7c\2\2\u011a\u011b"+
		"\7v\2\2\u011bf\3\2\2\2\u011c\u011d\7r\2\2\u011d\u011e\7j\2\2\u011eh\3"+
		"\2\2\2\u011f\u0120\7t\2\2\u0120\u0121\7c\2\2\u0121\u0122\7p\2\2\u0122"+
		"\u0123\7i\2\2\u0123\u0124\7g\2\2\u0124j\3\2\2\2\u0125\u0126\7t\2\2\u0126"+
		"\u0127\7g\2\2\u0127\u0128\7v\2\2\u0128\u0129\7w\2\2\u0129\u012a\7t\2\2"+
		"\u012a\u012b\7p\2\2\u012bl\3\2\2\2\u012c\u012d\7c\2\2\u012d\u012e\7u\2"+
		"\2\u012e\u012f\7u\2\2\u012f\u0130\7g\2\2\u0130\u0131\7t\2\2\u0131\u0132"+
		"\7v\2\2\u0132n\3\2\2\2\u0133\u0134\7e\2\2\u0134\u0135\7q\2\2\u0135\u0136"+
		"\7p\2\2\u0136\u0137\7v\2\2\u0137\u0138\7t\2\2\u0138\u0139\7q\2\2\u0139"+
		"\u013a\7n\2\2\u013ap\3\2\2\2\u013b\u013c\7t\2\2\u013c\u013d\7g\2\2\u013d"+
		"\u013e\7x\2\2\u013e\u013f\7g\2\2\u013f\u0140\7t\2\2\u0140\u0141\7u\2\2"+
		"\u0141\u0142\7g\2\2\u0142r\3\2\2\2\u0143\u0144\7y\2\2\u0144\u0145\7k\2"+
		"\2\u0145\u0146\7v\2\2\u0146\u0147\7j\2\2\u0147\u0148\7\"\2\2\u0148\u0149"+
		"\7e\2\2\u0149\u014a\7q\2\2\u014a\u014b\7p\2\2\u014b\u014c\7v\2\2\u014c"+
		"\u014d\7t\2\2\u014d\u014e\7q\2\2\u014e\u014f\7n\2\2\u014ft\3\2\2\2\u0150"+
		"\u0151\7k\2\2\u0151\u0152\7p\2\2\u0152\u0153\7x\2\2\u0153\u0154\7c\2\2"+
		"\u0154\u0155\7t\2\2\u0155\u0156\7k\2\2\u0156\u0157\7c\2\2\u0157\u0158"+
		"\7p\2\2\u0158\u0159\7v\2\2\u0159v\3\2\2\2\u015a\u015e\t\2\2\2\u015b\u015d"+
		"\t\3\2\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015fx\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\t\4\2\2"+
		"\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165"+
		"\3\2\2\2\u0165z\3\2\2\2\u0166\u0168\5\25\13\2\u0167\u0169\n\5\2\2\u0168"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016d\5\27\f\2\u016d|\3\2\2\2\u016e\u0172"+
		"\7%\2\2\u016f\u0171\n\5\2\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0175\u0176\b?\2\2\u0176~\3\2\2\2\u0177\u0179\7\17\2\2\u0178\u0177"+
		"\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017d\7\f\2\2\u017b"+
		"\u017d\t\6\2\2\u017c\u0178\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2"+
		"\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0181\b@\2\2\u0181\u0080\3\2\2\2\n\2\u015e\u0164\u016a\u0172\u0178\u017c"+
		"\u017e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}