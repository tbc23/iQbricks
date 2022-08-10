// Generated from /home/tomas/Desktop/qstar/Qstar Language/Qbricks.g4 by ANTLR 4.9.2

        import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QbricksParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QbricksVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QbricksParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(QbricksParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link QbricksParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(QbricksParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mainFun}
	 * labeled alternative in {@link QbricksParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFun(QbricksParser.MainFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code auxFun}
	 * labeled alternative in {@link QbricksParser#aux}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuxFun(QbricksParser.AuxFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funParams}
	 * labeled alternative in {@link QbricksParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunParams(QbricksParser.FunParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singlePar}
	 * labeled alternative in {@link QbricksParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePar(QbricksParser.SingleParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funArgs}
	 * labeled alternative in {@link QbricksParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunArgs(QbricksParser.FunArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(QbricksParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(QbricksParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(QbricksParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code circType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircType(QbricksParser.CircTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qrType}
	 * labeled alternative in {@link QbricksParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQrType(QbricksParser.QrTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funId}
	 * labeled alternative in {@link QbricksParser#idFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunId(QbricksParser.FunIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regCirc}
	 * labeled alternative in {@link QbricksParser#circ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegCirc(QbricksParser.RegCircContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qrList}
	 * labeled alternative in {@link QbricksParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQrList(QbricksParser.QrListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qr}
	 * labeled alternative in {@link QbricksParser#qReg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQr(QbricksParser.QrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regBody}
	 * labeled alternative in {@link QbricksParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegBody(QbricksParser.RegBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preSpec}
	 * labeled alternative in {@link QbricksParser#pre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreSpec(QbricksParser.PreSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code posSpec}
	 * labeled alternative in {@link QbricksParser#pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosSpec(QbricksParser.PosSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyAssert}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyAssert(QbricksParser.EmptyAssertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assertSpec}
	 * labeled alternative in {@link QbricksParser#assert_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertSpec(QbricksParser.AssertSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invSpec}
	 * labeled alternative in {@link QbricksParser#invariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvSpec(QbricksParser.InvSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegInst(QbricksParser.RegInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code retInst}
	 * labeled alternative in {@link QbricksParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetInst(QbricksParser.RetInstContext ctx);
	/**
	 * Visit a parse tree produced by {@link QbricksParser#conjugated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjugated(QbricksParser.ConjugatedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link QbricksParser#for_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(QbricksParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeIter(QbricksParser.RangeIterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qrIter}
	 * labeled alternative in {@link QbricksParser#iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQrIter(QbricksParser.QrIterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condIf}
	 * labeled alternative in {@link QbricksParser#if_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondIf(QbricksParser.CondIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elsebody}
	 * labeled alternative in {@link QbricksParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsebody(QbricksParser.ElsebodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunApply(QbricksParser.FunApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code revApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevApply(QbricksParser.RevApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hadApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHadApply(QbricksParser.HadApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rzApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRzApply(QbricksParser.RzApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rxApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRxApply(QbricksParser.RxApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ryApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRyApply(QbricksParser.RyApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXApply(QbricksParser.XApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYApply(QbricksParser.YApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZApply(QbricksParser.ZApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code swapApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwapApply(QbricksParser.SwapApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code phApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhApply(QbricksParser.PhApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTApply(QbricksParser.TApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sApply}
	 * labeled alternative in {@link QbricksParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSApply(QbricksParser.SApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code angTerm}
	 * labeled alternative in {@link QbricksParser#ang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngTerm(QbricksParser.AngTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code applyControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyControl(QbricksParser.ApplyControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiControl(QbricksParser.MultiControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cnotControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCnotControl(QbricksParser.CnotControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toffControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToffControl(QbricksParser.ToffControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fredControl}
	 * labeled alternative in {@link QbricksParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFredControl(QbricksParser.FredControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(QbricksParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpr(QbricksParser.LtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtExpr(QbricksParser.GtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermExpr(QbricksParser.TermExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeqExpr(QbricksParser.LeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeqExpr(QbricksParser.GeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(QbricksParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link QbricksParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqExpr(QbricksParser.NeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddTerm(QbricksParser.AddTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryTerm(QbricksParser.UnaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulTerm(QbricksParser.MulTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomTerm(QbricksParser.AtomTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowTerm(QbricksParser.PowTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTerm(QbricksParser.SubTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTerm(QbricksParser.ParenTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divTerm}
	 * labeled alternative in {@link QbricksParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivTerm(QbricksParser.DivTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumAtom(QbricksParser.NumAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code piAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiAtom(QbricksParser.PiAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAtom}
	 * labeled alternative in {@link QbricksParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAtom(QbricksParser.VarAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegUnary(QbricksParser.NegUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lenUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenUnary(QbricksParser.LenUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqrtUnary}
	 * labeled alternative in {@link QbricksParser#unOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtUnary(QbricksParser.SqrtUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermRange(QbricksParser.TermRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uptoRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUptoRange(QbricksParser.UptoRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromRange(QbricksParser.FromRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalRange}
	 * labeled alternative in {@link QbricksParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalRange(QbricksParser.IntervalRangeContext ctx);
}