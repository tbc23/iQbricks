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
		YGATE=30, ZGATE=31, SGATE=32, TGATE=33, PI=34, IN=35, IF=36, INT=37, DEF=38, 
		LEN=39, FOR=40, ROT=41, PHASE=42, PRE=43, POS=44, BOOL=45, QREG=46, CNOT=47, 
		SWAP=48, TOFF=49, FRED=50, SQRT=51, ELSE=52, CIRC=53, APPLY=54, FLOAT=55, 
		RANGE=56, RET=57, ASSERT=58, CONTROL=59, REVERSE=60, WITHCTL=61, WITHCJG=62, 
		INVARIANT=63, ID=64, NUM=65, FORMULA=66, COMM=67, SPACE=68;
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
			"SGATE", "TGATE", "PI", "IN", "IF", "INT", "DEF", "LEN", "FOR", "ROT", 
			"PHASE", "PRE", "POS", "BOOL", "QREG", "CNOT", "SWAP", "TOFF", "FRED", 
			"SQRT", "ELSE", "CIRC", "APPLY", "FLOAT", "RANGE", "RET", "ASSERT", "CONTROL", 
			"REVERSE", "WITHCTL", "WITHCJG", "INVARIANT", "ID", "NUM", "FORMULA", 
			"COMM", "SPACE"
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
			"'reverse'", "'with control'", "'with conjugated'", "'invariant'"
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
			"CONTROL", "REVERSE", "WITHCTL", "WITHCJG", "INVARIANT", "ID", "NUM", 
			"FORMULA", "COMM", "SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u01aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3"+
		"+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\3"+
		"9\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\3A\3A\7A\u0185\nA\fA\16A\u0188\13A\3B\6B\u018b\nB\rB"+
		"\16B\u018c\3C\3C\6C\u0191\nC\rC\16C\u0192\3C\3C\3D\3D\7D\u0199\nD\fD\16"+
		"D\u019c\13D\3D\3D\3E\5E\u01a1\nE\3E\3E\6E\u01a5\nE\rE\16E\u01a6\3E\3E"+
		"\2\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\3\2\b\4\2C"+
		"\\c|\6\2\62;C\\aac|\3\2\62;\5\2\f\f}}\177\177\3\2\f\f\4\2\13\13\"\"\2"+
		"\u01b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3"+
		"\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2"+
		"\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\3\u008b\3\2\2\2\5"+
		"\u008d\3\2\2\2\7\u008f\3\2\2\2\t\u0091\3\2\2\2\13\u0093\3\2\2\2\r\u0095"+
		"\3\2\2\2\17\u0097\3\2\2\2\21\u0099\3\2\2\2\23\u009b\3\2\2\2\25\u009d\3"+
		"\2\2\2\27\u009f\3\2\2\2\31\u00a1\3\2\2\2\33\u00a4\3\2\2\2\35\u00a7\3\2"+
		"\2\2\37\u00aa\3\2\2\2!\u00ad\3\2\2\2#\u00af\3\2\2\2%\u00b1\3\2\2\2\'\u00b3"+
		"\3\2\2\2)\u00b5\3\2\2\2+\u00b7\3\2\2\2-\u00b9\3\2\2\2/\u00bb\3\2\2\2\61"+
		"\u00be\3\2\2\2\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c6\3\2\2\29\u00c9"+
		"\3\2\2\2;\u00cc\3\2\2\2=\u00ce\3\2\2\2?\u00d0\3\2\2\2A\u00d2\3\2\2\2C"+
		"\u00d4\3\2\2\2E\u00d6\3\2\2\2G\u00d9\3\2\2\2I\u00dc\3\2\2\2K\u00df\3\2"+
		"\2\2M\u00e3\3\2\2\2O\u00e7\3\2\2\2Q\u00eb\3\2\2\2S\u00ef\3\2\2\2U\u00f3"+
		"\3\2\2\2W\u00f6\3\2\2\2Y\u00fa\3\2\2\2[\u00fe\3\2\2\2]\u0103\3\2\2\2_"+
		"\u0108\3\2\2\2a\u010d\3\2\2\2c\u0112\3\2\2\2e\u0117\3\2\2\2g\u011c\3\2"+
		"\2\2i\u0121\3\2\2\2k\u0126\3\2\2\2m\u012b\3\2\2\2o\u0131\3\2\2\2q\u0137"+
		"\3\2\2\2s\u013d\3\2\2\2u\u0144\3\2\2\2w\u014b\3\2\2\2y\u0153\3\2\2\2{"+
		"\u015b\3\2\2\2}\u0168\3\2\2\2\177\u0178\3\2\2\2\u0081\u0182\3\2\2\2\u0083"+
		"\u018a\3\2\2\2\u0085\u018e\3\2\2\2\u0087\u0196\3\2\2\2\u0089\u01a4\3\2"+
		"\2\2\u008b\u008c\7\60\2\2\u008c\4\3\2\2\2\u008d\u008e\7~\2\2\u008e\6\3"+
		"\2\2\2\u008f\u0090\7=\2\2\u0090\b\3\2\2\2\u0091\u0092\7<\2\2\u0092\n\3"+
		"\2\2\2\u0093\u0094\7.\2\2\u0094\f\3\2\2\2\u0095\u0096\7*\2\2\u0096\16"+
		"\3\2\2\2\u0097\u0098\7+\2\2\u0098\20\3\2\2\2\u0099\u009a\7]\2\2\u009a"+
		"\22\3\2\2\2\u009b\u009c\7_\2\2\u009c\24\3\2\2\2\u009d\u009e\7}\2\2\u009e"+
		"\26\3\2\2\2\u009f\u00a0\7\177\2\2\u00a0\30\3\2\2\2\u00a1\u00a2\7?\2\2"+
		"\u00a2\u00a3\7?\2\2\u00a3\32\3\2\2\2\u00a4\u00a5\7#\2\2\u00a5\u00a6\7"+
		"?\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00a9\7?\2\2\u00a9\36"+
		"\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7?\2\2\u00ac \3\2\2\2\u00ad\u00ae"+
		"\7@\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7>\2\2\u00b0$\3\2\2\2\u00b1\u00b2"+
		"\7-\2\2\u00b2&\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7"+
		",\2\2\u00b6*\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8,\3\2\2\2\u00b9\u00ba\7"+
		"`\2\2\u00ba.\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc\u00bd\7@\2\2\u00bd\60\3"+
		"\2\2\2\u00be\u00bf\7~\2\2\u00bf\u00c0\7~\2\2\u00c0\62\3\2\2\2\u00c1\u00c2"+
		"\7J\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7T\2\2\u00c4\u00c5\7\\\2\2\u00c5"+
		"\66\3\2\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8\7Z\2\2\u00c88\3\2\2\2\u00c9"+
		"\u00ca\7T\2\2\u00ca\u00cb\7[\2\2\u00cb:\3\2\2\2\u00cc\u00cd\7Z\2\2\u00cd"+
		"<\3\2\2\2\u00ce\u00cf\7[\2\2\u00cf>\3\2\2\2\u00d0\u00d1\7\\\2\2\u00d1"+
		"@\3\2\2\2\u00d2\u00d3\7U\2\2\u00d3B\3\2\2\2\u00d4\u00d5\7V\2\2\u00d5D"+
		"\3\2\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8\7k\2\2\u00d8F\3\2\2\2\u00d9\u00da"+
		"\7k\2\2\u00da\u00db\7p\2\2\u00dbH\3\2\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de"+
		"\7h\2\2\u00deJ\3\2\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2"+
		"\7v\2\2\u00e2L\3\2\2\2\u00e3\u00e4\7f\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6"+
		"\7h\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea"+
		"\7p\2\2\u00eaP\3\2\2\2\u00eb\u00ec\7h\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee"+
		"\7t\2\2\u00eeR\3\2\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2"+
		"\7v\2\2\u00f2T\3\2\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7j\2\2\u00f5V\3"+
		"\2\2\2\u00f6\u00f7\7r\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7g\2\2\u00f9"+
		"X\3\2\2\2\u00fa\u00fb\7r\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"Z\3\2\2\2\u00fe\u00ff\7d\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7q\2\2\u0101"+
		"\u0102\7n\2\2\u0102\\\3\2\2\2\u0103\u0104\7s\2\2\u0104\u0105\7t\2\2\u0105"+
		"\u0106\7g\2\2\u0106\u0107\7i\2\2\u0107^\3\2\2\2\u0108\u0109\7e\2\2\u0109"+
		"\u010a\7p\2\2\u010a\u010b\7q\2\2\u010b\u010c\7v\2\2\u010c`\3\2\2\2\u010d"+
		"\u010e\7u\2\2\u010e\u010f\7y\2\2\u010f\u0110\7c\2\2\u0110\u0111\7r\2\2"+
		"\u0111b\3\2\2\2\u0112\u0113\7v\2\2\u0113\u0114\7q\2\2\u0114\u0115\7h\2"+
		"\2\u0115\u0116\7h\2\2\u0116d\3\2\2\2\u0117\u0118\7h\2\2\u0118\u0119\7"+
		"t\2\2\u0119\u011a\7g\2\2\u011a\u011b\7f\2\2\u011bf\3\2\2\2\u011c\u011d"+
		"\7u\2\2\u011d\u011e\7s\2\2\u011e\u011f\7t\2\2\u011f\u0120\7v\2\2\u0120"+
		"h\3\2\2\2\u0121\u0122\7g\2\2\u0122\u0123\7n\2\2\u0123\u0124\7u\2\2\u0124"+
		"\u0125\7g\2\2\u0125j\3\2\2\2\u0126\u0127\7e\2\2\u0127\u0128\7k\2\2\u0128"+
		"\u0129\7t\2\2\u0129\u012a\7e\2\2\u012al\3\2\2\2\u012b\u012c\7c\2\2\u012c"+
		"\u012d\7r\2\2\u012d\u012e\7r\2\2\u012e\u012f\7n\2\2\u012f\u0130\7{\2\2"+
		"\u0130n\3\2\2\2\u0131\u0132\7h\2\2\u0132\u0133\7n\2\2\u0133\u0134\7q\2"+
		"\2\u0134\u0135\7c\2\2\u0135\u0136\7v\2\2\u0136p\3\2\2\2\u0137\u0138\7"+
		"t\2\2\u0138\u0139\7c\2\2\u0139\u013a\7p\2\2\u013a\u013b\7i\2\2\u013b\u013c"+
		"\7g\2\2\u013cr\3\2\2\2\u013d\u013e\7t\2\2\u013e\u013f\7g\2\2\u013f\u0140"+
		"\7v\2\2\u0140\u0141\7w\2\2\u0141\u0142\7t\2\2\u0142\u0143\7p\2\2\u0143"+
		"t\3\2\2\2\u0144\u0145\7c\2\2\u0145\u0146\7u\2\2\u0146\u0147\7u\2\2\u0147"+
		"\u0148\7g\2\2\u0148\u0149\7t\2\2\u0149\u014a\7v\2\2\u014av\3\2\2\2\u014b"+
		"\u014c\7e\2\2\u014c\u014d\7q\2\2\u014d\u014e\7p\2\2\u014e\u014f\7v\2\2"+
		"\u014f\u0150\7t\2\2\u0150\u0151\7q\2\2\u0151\u0152\7n\2\2\u0152x\3\2\2"+
		"\2\u0153\u0154\7t\2\2\u0154\u0155\7g\2\2\u0155\u0156\7x\2\2\u0156\u0157"+
		"\7g\2\2\u0157\u0158\7t\2\2\u0158\u0159\7u\2\2\u0159\u015a\7g\2\2\u015a"+
		"z\3\2\2\2\u015b\u015c\7y\2\2\u015c\u015d\7k\2\2\u015d\u015e\7v\2\2\u015e"+
		"\u015f\7j\2\2\u015f\u0160\7\"\2\2\u0160\u0161\7e\2\2\u0161\u0162\7q\2"+
		"\2\u0162\u0163\7p\2\2\u0163\u0164\7v\2\2\u0164\u0165\7t\2\2\u0165\u0166"+
		"\7q\2\2\u0166\u0167\7n\2\2\u0167|\3\2\2\2\u0168\u0169\7y\2\2\u0169\u016a"+
		"\7k\2\2\u016a\u016b\7v\2\2\u016b\u016c\7j\2\2\u016c\u016d\7\"\2\2\u016d"+
		"\u016e\7e\2\2\u016e\u016f\7q\2\2\u016f\u0170\7p\2\2\u0170\u0171\7l\2\2"+
		"\u0171\u0172\7w\2\2\u0172\u0173\7i\2\2\u0173\u0174\7c\2\2\u0174\u0175"+
		"\7v\2\2\u0175\u0176\7g\2\2\u0176\u0177\7f\2\2\u0177~\3\2\2\2\u0178\u0179"+
		"\7k\2\2\u0179\u017a\7p\2\2\u017a\u017b\7x\2\2\u017b\u017c\7c\2\2\u017c"+
		"\u017d\7t\2\2\u017d\u017e\7k\2\2\u017e\u017f\7c\2\2\u017f\u0180\7p\2\2"+
		"\u0180\u0181\7v\2\2\u0181\u0080\3\2\2\2\u0182\u0186\t\2\2\2\u0183\u0185"+
		"\t\3\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u0082\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018b\t\4"+
		"\2\2\u018a\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018d\u0084\3\2\2\2\u018e\u0190\5\25\13\2\u018f\u0191\n"+
		"\5\2\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\5\27\f\2\u0195\u0086\3"+
		"\2\2\2\u0196\u019a\7%\2\2\u0197\u0199\n\6\2\2\u0198\u0197\3\2\2\2\u0199"+
		"\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2"+
		"\2\2\u019c\u019a\3\2\2\2\u019d\u019e\bD\2\2\u019e\u0088\3\2\2\2\u019f"+
		"\u01a1\7\17\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3"+
		"\2\2\2\u01a2\u01a5\7\f\2\2\u01a3\u01a5\t\7\2\2\u01a4\u01a0\3\2\2\2\u01a4"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2"+
		"\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\bE\2\2\u01a9\u008a\3\2\2\2\n\2\u0186"+
		"\u018c\u0192\u019a\u01a0\u01a4\u01a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}