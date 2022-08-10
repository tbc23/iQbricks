// Generated from /home/tomas/Desktop/qstar/Qstar Language/Qbricks.g4 by ANTLR 4.9.2

        import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QbricksParser}.
 */
public interface QbricksListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QbricksParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(QbricksParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link QbricksParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(QbricksParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link QbricksParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(QbricksParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QbricksParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(QbricksParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mainFun}
	 * labeled alternative in {@link QbricksParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMainFun(QbricksParser.MainFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mainFun}
	 * labeled alternative in {@link QbricksParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMainFun(QbricksParser.MainFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code auxFun}
	 * labeled alternative in {@link QbricksParser#aux}.
	 * @param ctx the parse tree
	 */
	void enterAuxFun(QbricksParser.AuxFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code auxFun}
	 * labeled alternative in {@link QbricksParser#aux}.
	 * @param ctx the parse tree
	 */
	void exitAuxFun(QbricksParser.AuxFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funParams}
	 * labeled alternative in {@link QbricksParser#params}.
	 * @param ctx the parse tree
	 */
	void enterFunParams(QbricksParser.FunParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funParams}
	 * labeled alternative in {@link QbricksParser#params}.
	 * @param ctx the parse tree
	 */
	void exitFunParams(QbricksParser.FunParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singlePar}
	 * labeled alternative in {@link QbricksParser#param}.
	 * @param ctx the parse tree
	 */
	void enterSinglePar(QbricksParser.SingleParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singlePar}
	 * labeled alternative in {@link QbricksParser#param}.
	 * @param ctx the parse tree
	 */
	void exitSinglePar(QbricksParser.SingleParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funArgs}
	 * labeled alternative in {@link QbricksParser#args}.
	 * @param ctx the parse tree
	 */
	void enterFunArgs(QbricksParser.FunArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funArgs}
	 * labeled alternative in {@link QbricksParser#args}.
	 * @param ctx the parse tree
	 */
	void exitFunArgs(QbricksParser.FunArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(QbricksParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(QbricksParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(QbricksParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(QbricksParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(QbricksParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(QbricksParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code circType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCircType(QbricksParser.CircTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code circType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCircType(QbricksParser.CircTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code qrType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void enterQrType(QbricksParser.QrTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code qrType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 */
	void exitQrType(QbricksParser.QrTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funId}
	 * labeled alternative in {@link QbricksParser#idFun}.
	 * @param ctx the parse tree
	 */
	void enterFunId(QbricksParser.FunIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funId}
	 * labeled alternative in {@link QbricksParser#idFun}.
	 * @param ctx the parse tree
	 */
	void exitFunId(QbricksParser.FunIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regCirc}
	 * labeled alternative in {@link QbricksParser#circ}.
	 * @param ctx the parse tree
	 */
	void enterRegCirc(QbricksParser.RegCircContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regCirc}
	 * labeled alternative in {@link QbricksParser#circ}.
	 * @param ctx the parse tree
	 */
	void exitRegCirc(QbricksParser.RegCircContext ctx);
	/**
	 * Enter a parse tree produced by the {@code qrList}
	 * labeled alternative in {@link QbricksParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterQrList(QbricksParser.QrListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code qrList}
	 * labeled alternative in {@link QbricksParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitQrList(QbricksParser.QrListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code qr}
	 * labeled alternative in {@link QbricksParser#qReg}.
	 * @param ctx the parse tree
	 */
	void enterQr(QbricksParser.QrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code qr}
	 * labeled alternative in {@link QbricksParser#qReg}.
	 * @param ctx the parse tree
	 */
	void exitQr(QbricksParser.QrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regBody}
	 * labeled alternative in {@link QbricksParser#body}.
	 * @param ctx the parse tree
	 */
	void enterRegBody(QbricksParser.RegBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regBody}
	 * labeled alternative in {@link QbricksParser#body}.
	 * @param ctx the parse tree
	 */
	void exitRegBody(QbricksParser.RegBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preSpec}
	 * labeled alternative in {@link QbricksParser#pre}.
	 * @param ctx the parse tree
	 */
	void enterPreSpec(QbricksParser.PreSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preSpec}
	 * labeled alternative in {@link QbricksParser#pre}.
	 * @param ctx the parse tree
	 */
	void exitPreSpec(QbricksParser.PreSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code posSpec}
	 * labeled alternative in {@link QbricksParser#pos}.
	 * @param ctx the parse tree
	 */
	void enterPosSpec(QbricksParser.PosSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code posSpec}
	 * labeled alternative in {@link QbricksParser#pos}.
	 * @param ctx the parse tree
	 */
	void exitPosSpec(QbricksParser.PosSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyAssert}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyAssert(QbricksParser.EmptyAssertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyAssert}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyAssert(QbricksParser.EmptyAssertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertSpec}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 */
	void enterAssertSpec(QbricksParser.AssertSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertSpec}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 */
	void exitAssertSpec(QbricksParser.AssertSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invSpec}
	 * labeled alternative in {@link QbricksParser#invariant}.
	 * @param ctx the parse tree
	 */
	void enterInvSpec(QbricksParser.InvSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invSpec}
	 * labeled alternative in {@link QbricksParser#invariant}.
	 * @param ctx the parse tree
	 */
	void exitInvSpec(QbricksParser.InvSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterRegInst(QbricksParser.RegInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitRegInst(QbricksParser.RegInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code retInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterRetInst(QbricksParser.RetInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitRetInst(QbricksParser.RetInstContext ctx);
	/**
	 * Enter a parse tree produced by {@link QbricksParser#conjugated}.
	 * @param ctx the parse tree
	 */
	void enterConjugated(QbricksParser.ConjugatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link QbricksParser#conjugated}.
	 * @param ctx the parse tree
	 */
	void exitConjugated(QbricksParser.ConjugatedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link QbricksParser#for_}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(QbricksParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link QbricksParser#for_}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(QbricksParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rangeIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 */
	void enterRangeIter(QbricksParser.RangeIterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rangeIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 */
	void exitRangeIter(QbricksParser.RangeIterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code qrIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 */
	void enterQrIter(QbricksParser.QrIterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code qrIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 */
	void exitQrIter(QbricksParser.QrIterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condIf}
	 * labeled alternative in {@link QbricksParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterCondIf(QbricksParser.CondIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condIf}
	 * labeled alternative in {@link QbricksParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitCondIf(QbricksParser.CondIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elsebody}
	 * labeled alternative in {@link QbricksParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElsebody(QbricksParser.ElsebodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elsebody}
	 * labeled alternative in {@link QbricksParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElsebody(QbricksParser.ElsebodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterFunApply(QbricksParser.FunApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitFunApply(QbricksParser.FunApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code revApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterRevApply(QbricksParser.RevApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code revApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitRevApply(QbricksParser.RevApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hadApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterHadApply(QbricksParser.HadApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hadApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitHadApply(QbricksParser.HadApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rzApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterRzApply(QbricksParser.RzApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rzApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitRzApply(QbricksParser.RzApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rxApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterRxApply(QbricksParser.RxApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rxApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitRxApply(QbricksParser.RxApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ryApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterRyApply(QbricksParser.RyApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ryApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitRyApply(QbricksParser.RyApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterXApply(QbricksParser.XApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitXApply(QbricksParser.XApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterYApply(QbricksParser.YApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitYApply(QbricksParser.YApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterZApply(QbricksParser.ZApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitZApply(QbricksParser.ZApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code swapApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterSwapApply(QbricksParser.SwapApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code swapApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitSwapApply(QbricksParser.SwapApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code phApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterPhApply(QbricksParser.PhApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code phApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitPhApply(QbricksParser.PhApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterTApply(QbricksParser.TApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitTApply(QbricksParser.TApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterSApply(QbricksParser.SApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitSApply(QbricksParser.SApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code angTerm}
	 * labeled alternative in {@link QbricksParser#ang}.
	 * @param ctx the parse tree
	 */
	void enterAngTerm(QbricksParser.AngTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code angTerm}
	 * labeled alternative in {@link QbricksParser#ang}.
	 * @param ctx the parse tree
	 */
	void exitAngTerm(QbricksParser.AngTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applyControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void enterApplyControl(QbricksParser.ApplyControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applyControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void exitApplyControl(QbricksParser.ApplyControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void enterMultiControl(QbricksParser.MultiControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void exitMultiControl(QbricksParser.MultiControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cnotControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void enterCnotControl(QbricksParser.CnotControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cnotControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void exitCnotControl(QbricksParser.CnotControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toffControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void enterToffControl(QbricksParser.ToffControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toffControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void exitToffControl(QbricksParser.ToffControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fredControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void enterFredControl(QbricksParser.FredControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fredControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 */
	void exitFredControl(QbricksParser.FredControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(QbricksParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(QbricksParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(QbricksParser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(QbricksParser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGtExpr(QbricksParser.GtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGtExpr(QbricksParser.GtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(QbricksParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(QbricksParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLeqExpr(QbricksParser.LeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLeqExpr(QbricksParser.LeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code geqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGeqExpr(QbricksParser.GeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code geqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGeqExpr(QbricksParser.GeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(QbricksParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(QbricksParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNeqExpr(QbricksParser.NeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNeqExpr(QbricksParser.NeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAddTerm(QbricksParser.AddTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAddTerm(QbricksParser.AddTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterUnaryTerm(QbricksParser.UnaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitUnaryTerm(QbricksParser.UnaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMulTerm(QbricksParser.MulTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMulTerm(QbricksParser.MulTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAtomTerm(QbricksParser.AtomTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAtomTerm(QbricksParser.AtomTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPowTerm(QbricksParser.PowTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPowTerm(QbricksParser.PowTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSubTerm(QbricksParser.SubTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSubTerm(QbricksParser.SubTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenTerm(QbricksParser.ParenTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenTerm(QbricksParser.ParenTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDivTerm(QbricksParser.DivTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDivTerm(QbricksParser.DivTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumAtom(QbricksParser.NumAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumAtom(QbricksParser.NumAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code piAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterPiAtom(QbricksParser.PiAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code piAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitPiAtom(QbricksParser.PiAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVarAtom(QbricksParser.VarAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVarAtom(QbricksParser.VarAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void enterNegUnary(QbricksParser.NegUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void exitNegUnary(QbricksParser.NegUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lenUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void enterLenUnary(QbricksParser.LenUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lenUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void exitLenUnary(QbricksParser.LenUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqrtUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void enterSqrtUnary(QbricksParser.SqrtUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqrtUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 */
	void exitSqrtUnary(QbricksParser.SqrtUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void enterTermRange(QbricksParser.TermRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void exitTermRange(QbricksParser.TermRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uptoRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void enterUptoRange(QbricksParser.UptoRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uptoRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void exitUptoRange(QbricksParser.UptoRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void enterFromRange(QbricksParser.FromRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void exitFromRange(QbricksParser.FromRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void enterIntervalRange(QbricksParser.IntervalRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 */
	void exitIntervalRange(QbricksParser.IntervalRangeContext ctx);
}