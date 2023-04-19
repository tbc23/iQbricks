import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.IOException;
import java.io.NotActiveException;
import java.rmi.NotBoundException;
import java.util.*;

public class ASTBuilder extends QbricksBaseVisitor<AST>{

    @Override
    public AST visitProgram(QbricksParser.ProgramContext ctx) {
        ProgramNode node = new ProgramNode();
        ImportsNode imports = new ImportsNode();
        MainNode main = (MainNode) visit(ctx.main());
        List<AuxNode> auxList = new ArrayList<>();
        AuxNode aux;
        if (ctx.imports()!=null)
            imports = (ImportsNode) visit(ctx.imports());
        for (int c = 0; c < ctx.aux().size(); ++c){
            aux = (AuxNode) visit(ctx.aux(c));
            auxList.add(aux);
        }
        node.setImports(imports);
        node.setMain(main);
        node.setAuxList(auxList);
        return node;
    }

    @Override public AST visitImports(QbricksParser.ImportsContext ctx) {
        ImportsNode node = new ImportsNode();
        List<String> files = new ArrayList<>();
        if(!ctx.isEmpty()){
            node.setHasImports(true);
            for (int i=0; i<ctx.ID().size(); i+=2){
                files.add(ctx.ID(i).getText());
            }
        }
        node.setFiles(files);
        return node;
    }


    @Override
    public AST visitMainFun(QbricksParser.MainFunContext ctx) {
        MainNode node = new MainNode();
        CircNode circ = (CircNode) visit(ctx.circ());
        PreNode pre = (PreNode) visit(ctx.pre());
        PosNode pos = (PosNode) visit(ctx.pos());

        ParamsNode pNode;
        if(ctx.getChildCount()>6) {
            pNode = (ParamsNode) visit(ctx.params());
            node.setHasParams(true);
        } else {
            pNode = null;
            node.setHasParams(false);
        }

        node.setID(ctx.idFun().getText());
        node.setCirc(circ);
        node.setParams(pNode);
        node.setPre(pre);
        node.setPos(pos);
        return node;
    }

    @Override public AST visitAuxFun(QbricksParser.AuxFunContext ctx) {
        AuxNode node = new AuxNode();
        CircNode circ = (CircNode) visit(ctx.circ());
        PreNode pre = (PreNode) visit(ctx.pre());
        PosNode pos = (PosNode) visit(ctx.pos());

        ParamsNode pNode;
        if(ctx.getChildCount()>6) {
            pNode = (ParamsNode) visit(ctx.params());
            node.setHasParams(true);
        } else {
            pNode = null;
            node.setHasParams(false);
        }

        node.setID(ctx.idFun().getText());
        node.setCirc(circ);
        node.setParams(pNode);
        node.setPre(pre);
        node.setPos(pos);
        return node;
    }

    @Override public AST visitRegBody(QbricksParser.RegBodyContext ctx) {
        BodyNode node = new BodyNode();
        InstrNode instr;
        List<InstrNode> nodeList = new ArrayList<>(); //list of instruction nodes

        for (int c = 0; c < ctx.instr().size(); ++c){
            instr = (InstrNode) visit(ctx.instr(c));
            nodeList.add(instr);
        }
        node.setBodyInstr(nodeList);
        node.setAssertion((AssertNode) visit(ctx.assert_()));
        return node;
    }

    @Override public AST visitRegInst(QbricksParser.RegInstContext ctx) {

        return visit(ctx.getChild(0));
    }

    @Override public AST visitRetInst(QbricksParser.RetInstContext ctx) {
        RetNode ret = new RetNode();
        ExpressionNode expr;
        if (ctx.getChildCount()==2) {
            expr = (ExpressionNode) visit(ctx.expr());
            ret.setArgs(expr);
            ret.setArgBool(true);
            //ret.setArgs(ctx.expr().getText());
        } else {
            ret.setArgs(null);
            ret.setArgBool(false);
        }
        //ret.printRet();
        return ret;
    }

    @Override public AST visitFunParams(QbricksParser.FunParamsContext ctx) {
        ParamsNode node = new ParamsNode();
        List<SingleParam> params = new ArrayList<>();
        //List <String> ps = new ArrayList<>();
        for (int c=0; c < ctx.param().size(); ++c){
            params.add((SingleParam) visit(ctx.param(c)));
          //  ps.add(ctx.param(c).getChild(0).getText()+" "+ctx.param(c).getChild(1).getText());
        }

        node.setPs(params); // list of strings is being used

        return node;
    }

    @Override public AST visitSinglePar(QbricksParser.SingleParContext ctx) {
        SingleParam node = new SingleParam();
        node.setParam(ctx.ptype.getText(),ctx.id.getText());
        return node;
    }


    @Override public AST visitPreSpec(QbricksParser.PreSpecContext ctx) {
        PreNode node = new PreNode();
        List<String> preconds = new ArrayList<>(); //list of preconds

        for (int c = 0; c < ctx.FORMULA().size(); c++){
            preconds.add(ctx.FORMULA(c).getText());
        }
        node.set(preconds);
       // pre.printPre();

        return node;
    }

    @Override public AST visitPosSpec(QbricksParser.PosSpecContext ctx) {
        PosNode node = new PosNode();
        List<String> posconds = new ArrayList<>(); //list of posconds

        for (int c = 0; c < ctx.FORMULA().size(); c++){
            posconds.add(ctx.FORMULA(c).getText());
        }
        node.set(posconds);
        //pos.printPos();

        return node;
    }

    @Override public AST visitInvSpec(QbricksParser.InvSpecContext ctx) {
        InvariantNode node = new InvariantNode();
        List<String> invariants = new ArrayList<>(); //list of invariants

        for (int c = 0; c < ctx.FORMULA().size(); c++){
            invariants.add(ctx.FORMULA(c).getText());
        }
        node.set(invariants);
        //pos.printPos();

        return node;
    }

    @Override public AST visitQr(QbricksParser.QrContext ctx) {
        QregNode qr = new QregNode();
        RangeNode range;
        if (ctx.getChildCount()>1) {
            range = (RangeNode) visit(ctx.size);
            qr.setHasRange(true);
        }
        else {
            range = null;
            qr.setHasRange(false);
        }
        qr.setRange(range);
        qr.setId(ctx.id.getText());
        return qr;
    }

    @Override public AST visitRegCirc(QbricksParser.RegCircContext ctx) {
        CircNode node = new CircNode();
        CircIds ids = new CircIds();
        List<QregNode> circQrs = new ArrayList<>(); //list of circ qrs

        BodyNode body = (BodyNode) visit(ctx.circbody);
        QregNode qr;

        ParseTree id_list = ctx.getChild(1);
        for (int c = 0; c < id_list.getChildCount(); c+=2){
            qr = (QregNode) visit(id_list.getChild(c));
            circQrs.add(qr);
        }
        ids.setRegs(circQrs);
        node.setIds(ids);
        node.setBody(body);
        return node;
    }

    @Override public AST visitAssertSpec(QbricksParser.AssertSpecContext ctx) {
        AssertNode node = new AssertNode();
        List<String> asserts = new ArrayList<>();

        for(int c = 0; c < ctx.FORMULA().size(); ++c){
            asserts.add(ctx.FORMULA(c).getText());
        }
        node.setAssertions(asserts);
        return node;
    }

    @Override public AST visitConjugated(QbricksParser.ConjugatedContext ctx) {
        ConjNode node = new ConjNode();
        BodyNode body = (BodyNode) visit(ctx.conjbody);
        ApplyNode apply = (ApplyNode) visit(ctx.applyinst);
        node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        node.setBody(body);
        node.setApply(apply);
        return node;
    }


    @Override public AST visitForLoop(QbricksParser.ForLoopContext ctx) {
        ForNode node = new ForNode();
        ForIter iter = new ForIter();
        node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));

        InvariantNode invariant = (InvariantNode) visit(ctx.inv);
        BodyNode body = (BodyNode) visit(ctx.forbody);
        ParseTree iterable = ctx.iteration;
        //System.out.println("For cycle:");
        iter.setIterator(ctx.var.getText());
        if(iterable.getChildCount() > 1) {
            iter.setIterable(visit(iterable.getChild(2)));
            iter.setRange(Boolean.TRUE);
        } else {
            iter.setIterable(visit(iterable.getChild(0)));
            iter.setRange(Boolean.FALSE);
        }

        node.setInvariant(invariant);
        node.setBody(body);
        node.setIter(iter);
        return node;
    }


    @Override public AST visitCondIf(QbricksParser.CondIfContext ctx) {
        IfNode node = new IfNode();
        IfCond cond = new IfCond();
        node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        BodyNode ifBody = (BodyNode) visit(ctx.ifbody);

        cond.setExpr((ExpressionNode) visit(ctx.cond));
        node.setCond(cond);
        node.setIfBody(ifBody);
        if(ctx.getChildCount()>5) {
            node.setElseBody((BodyNode) visit(ctx.elsebody));
            node.setWithElse(true);
        } else {
            node.setElseBody(null);
            node.setWithElse(false);
        }

        return node;
    }


    @Override public AST visitFunApply(QbricksParser.FunApplyContext ctx) {
        FunApply funApply = new FunApply();
        ParseTree args = ctx.fargs;
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            funApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            funApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));

        List<TermNode> termArgs = new ArrayList<>(); //list of term arguments
        if (ctx.getChildCount()>3) { //this has args
            TermNode arg = (TermNode) visit(args.getChild(0));
            termArgs.add(arg);
            if (args.getChildCount() > 1) {
                for (int c = 2; c < args.getChildCount(); c += 2) {
                    arg = (TermNode) visit(args.getChild(c));
                    termArgs.add(arg);
                }
            }
        }

        funApply.setFunID(ctx.fun.getText());
        funApply.setTermArgs(termArgs);

        return funApply;
    }

    @Override public AST visitRevApply(QbricksParser.RevApplyContext ctx) {
        RevApply revApply = new RevApply();
        ParseTree args = ctx.fargs;
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            revApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            revApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));

        List<TermNode> termArgs = new ArrayList<>(); //list of term arguments
        if (ctx.getChildCount()>6) { //has args
            TermNode arg = (TermNode) visit(args.getChild(0));
            termArgs.add(arg);
            if (args.getChildCount() > 1) {
                for (int c = 2; c < args.getChildCount(); c += 2) {
                    arg = (TermNode) visit(args.getChild(c));
                    termArgs.add(arg);
                }
            }
        }
        revApply.setFunID(ctx.fun.getText());
        revApply.setTermArgs(termArgs);
        return revApply;
    }

    @Override public AST visitHadApply(QbricksParser.HadApplyContext ctx) {
        HadApply hadApply = new HadApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            hadApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            hadApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        hadApply.setQreg(qr);
        //hadApply.print();
        return hadApply;
    }

    @Override public AST visitRzApply(QbricksParser.RzApplyContext ctx) {
        RzApply rzApply = new RzApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            rzApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            rzApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        TermNode angle = (TermNode) visit(ctx.angle);
        rzApply.setQreg(qr);
        rzApply.setAngle(angle);
        //rzApply.print();
        return rzApply;
    }

    @Override public AST visitRxApply(QbricksParser.RxApplyContext ctx) {
        RxApply rxApply = new RxApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            rxApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            rxApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        TermNode angle = (TermNode) visit(ctx.angle);
        rxApply.setQreg(qr);
        rxApply.setAngle(angle);
        //rxApply.print();
        return rxApply;
    }

    @Override public AST visitRyApply(QbricksParser.RyApplyContext ctx) {
        RyApply ryApply = new RyApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            ryApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            ryApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        TermNode angle = (TermNode) visit(ctx.angle);
        ryApply.setQreg(qr);
        ryApply.setAngle(angle);
        //ryApply.print();
        return ryApply;
    }

    @Override public AST visitXApply(QbricksParser.XApplyContext ctx) {
        XApply xApply = new XApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            xApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            xApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        xApply.setQreg(qr);
        //xApply.print();
        return xApply;
    }

    @Override public AST visitYApply(QbricksParser.YApplyContext ctx) {
        YApply yApply = new YApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            yApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            yApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        yApply.setQreg(qr);
        //yApply.print();
        return yApply;
    }

    @Override public AST visitZApply(QbricksParser.ZApplyContext ctx) {
        ZApply zApply = new ZApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            zApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            zApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        zApply.setQreg(qr);
        //zApply.print();
        return zApply;
    }

    @Override public AST visitSApply(QbricksParser.SApplyContext ctx) {
        SApply sApply = new SApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            sApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            sApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        sApply.setQreg(qr);
        //zApply.print();
        return sApply;
    }

    @Override public AST visitTApply(QbricksParser.TApplyContext ctx) {
        TApply tApply = new TApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            tApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            tApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        tApply.setQreg(qr);
        //zApply.print();
        return tApply;
    }

    @Override public AST visitSwapApply(QbricksParser.SwapApplyContext ctx) {
        SwapApply swap = new SwapApply();
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            swap.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            swap.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode left = (QregNode) visit(ctx.qrL);
        QregNode right = (QregNode) visit(ctx.qrR);
        swap.setQregs(left,right);
        //swap.print();
        return swap;
    }

    @Override public AST visitPhApply(QbricksParser.PhApplyContext ctx) {
        PhApply phApply = new PhApply();
        //System.out.println("?? "+ctx.getParent().getParent().getChild(1).getText());
        if(!ctx.getParent().getClass().getSimpleName().equals("ApplyControlContext")) {
            phApply.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            phApply.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode qr = (QregNode) visit(ctx.qr);
        TermNode angle = (TermNode) visit(ctx.angle);
        phApply.setQreg(qr);
        phApply.setAngle(angle);
        //phApply.print();
        return phApply;
    }

    @Override public AST visitApplyControl(QbricksParser.ApplyControlContext ctx) {
        WithCtlNode node = new WithCtlNode();
        //System.out.println("Here: "+ctx.getParent().getChild(1).getText());
        node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        ApplyNode gate = (ApplyNode) visit(ctx.ctlgate);
        ParseTree ctls = ctx.ctlqrs;
        QregNode qr = (QregNode) visit(ctls.getChild(0));
        List<QregNode> ctlNodes = new ArrayList<>(); //list of control qubits

        ctlNodes.add(qr);
        node.setCtlGate(gate);
        if (ctls.getChildCount() > 1) {
            for (int c = 2; c < ctls.getChildCount(); c += 2) {
                qr = (QregNode) visit(ctls.getChild(c));
                ctlNodes.add(qr);
            }
        }
        node.setCtlArgs(ctlNodes);
        return node;
    }

    @Override public AST visitMultiControl(QbricksParser.MultiControlContext ctx) {
        WithCtlNode node = new WithCtlNode();
        node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        CtlNode gate = (CtlNode) visit(ctx.ctlgate);
        ParseTree ctls = ctx.ctlqrs;
        QregNode qr = (QregNode) visit(ctls.getChild(0));

        List<QregNode> ctlNodes = new ArrayList<>(); //list of control qubits

        ctlNodes.add(qr);
        node.setCtlMulti(gate);
        if (ctls.getChildCount() > 1) {
            for (int c = 2; c < ctls.getChildCount(); c += 2) {
                qr = (QregNode) visit(ctls.getChild(c));
                ctlNodes.add(qr);
            }
        }
        node.setCtlArgs(ctlNodes);
        return node;
    }

    @Override public AST visitCnotControl(QbricksParser.CnotControlContext ctx) {
        CnotNode cnot = new CnotNode();
        if(!ctx.getParent().getClass().getSimpleName().equals("MultiControlContext")) {
            cnot.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            cnot.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode ctl = (QregNode) visit(ctx.ctlqr);
        QregNode target = (QregNode) visit(ctx.tqr);
        cnot.setQregs(ctl,target);
        return cnot;
    }

    @Override public AST visitFredControl(QbricksParser.FredControlContext ctx) {
        FredNode node = new FredNode();
        if(!ctx.getParent().getClass().getSimpleName().equals("MultiControlContext")) {
            node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            node.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode ctl1 = (QregNode) visit(ctx.ctl1);
        QregNode ctl2 = (QregNode) visit(ctx.ctl2);
        QregNode target = (QregNode) visit(ctx.tg);
        node.setQregs(ctl1,ctl2,target);
        return node;
    }

    @Override public AST visitToffControl(QbricksParser.ToffControlContext ctx) {
        ToffNode node = new ToffNode();
        if(!ctx.getParent().getClass().getSimpleName().equals("MultiControlContext")) {
            node.setAssertion((AssertNode) visit(ctx.getParent().getChild(1)));
        }
        else
            node.setAssertion((AssertNode) visit(ctx.getParent().getParent().getChild(1)));
        QregNode ctl1 = (QregNode) visit(ctx.ctl1);
        QregNode ctl2 = (QregNode) visit(ctx.ctl2);
        QregNode target = (QregNode) visit(ctx.tg);
        node.setQregs(ctl1,ctl2,target);
        return node;
    }

    @Override public AST visitTermRange(QbricksParser.TermRangeContext ctx) {
        RangeNode node = new RangeNode();
        TermNode term = (TermNode) visit(ctx.term());
        String id = ctx.getParent().getChild(0).getText();
        node.setIterator(id);
        node.set(term,term);
        return node;
    }

    @Override public AST visitUptoRange(QbricksParser.UptoRangeContext ctx) {
        // Start at 0 and go up until the value defined by "term"
        RangeNode node = new RangeNode();
        TermNode end = (TermNode) visit(ctx.term());
        String id = ctx.getParent().getChild(0).getText();
        node.setIterator(id);
        node.set(null,end);
        return node;
    }

    @Override public AST visitFromRange(QbricksParser.FromRangeContext ctx) {
        // Start at term and go up until the value defined by the qr size (how do I find it?)
        RangeNode node = new RangeNode();
        TermNode start = (TermNode) visit(ctx.term());
        String id = ctx.getParent().getChild(0).getText();
        node.setIterator(id);
        node.set(start,null);
        return node;
    }

    @Override public AST visitIntervalRange(QbricksParser.IntervalRangeContext ctx) {
        // Start at "term" and go up until the value defined by "term"

        RangeNode node = new RangeNode();
        TermNode start = (TermNode) visit(ctx.getChild(0));
        TermNode end = (TermNode) visit(ctx.getChild(3));
        String id = ctx.getParent().getChild(0).getText();
        node.setIterator(id);
        node.set(start,end);
        return node;
    }


// Expressions

    @Override public AST visitTermExpr(QbricksParser.TermExprContext ctx) {
        return visit(ctx.term());
    }


    @Override public AST visitEqExpr(QbricksParser.EqExprContext ctx) {
        InfixExpressionNode node = new EqualNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitNeqExpr(QbricksParser.NeqExprContext ctx) {
        InfixExpressionNode node = new NEqualNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitGeqExpr(QbricksParser.GeqExprContext ctx) {
        InfixExpressionNode node = new GEQNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitLeqExpr(QbricksParser.LeqExprContext ctx) {
        InfixExpressionNode node = new LEQNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitGtExpr(QbricksParser.GtExprContext ctx) {
        InfixExpressionNode node = new GTNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitLtExpr(QbricksParser.LtExprContext ctx) {
        InfixExpressionNode node = new LTNode();
        node.setLeft((ExpressionNode) visit(ctx.left));
        node.setRight((ExpressionNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitParenExpr(QbricksParser.ParenExprContext ctx) { return visit(ctx.expr()); }


    @Override public AST visitPowTerm(QbricksParser.PowTermContext ctx) {
        InfixTermNode node = new PowerNode();
        node.setLeft((TermNode) visit(ctx.left));
        node.setRight((TermNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitMulTerm(QbricksParser.MulTermContext ctx) {
        InfixTermNode node = new MulNode();
        node.setLeft((TermNode) visit(ctx.left));
        node.setRight((TermNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitDivTerm(QbricksParser.DivTermContext ctx) {
        InfixTermNode node = new DivNode();
        node.setLeft((TermNode) visit(ctx.left));
        node.setRight((TermNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitAddTerm(QbricksParser.AddTermContext ctx) {
        InfixTermNode node = new AddNode();
        node.setLeft((TermNode) visit(ctx.left));
        node.setRight((TermNode) visit(ctx.right));
        return node;
    }

    @Override public AST visitSubTerm(QbricksParser.SubTermContext ctx) {
        InfixTermNode node = new SubNode();
        node.setLeft((TermNode) visit(ctx.left));
        node.setRight((TermNode) visit(ctx.right));
        return node;
    }


    @Override public AST visitParenTerm(QbricksParser.ParenTermContext ctx) {
        ParenNode node = new ParenNode();
        node.setTerm((TermNode) visit(ctx.term()));
        return node;
    }

    @Override public AST visitUnaryTerm(QbricksParser.UnaryTermContext ctx) {
        return visit(ctx.unOp());
    }

    @Override public AST visitNegUnary(QbricksParser.NegUnaryContext ctx) {
        UnOpNode node = new UnOpNode();
        node.setOp("Minus ");   // char "-"
        node.setInnerTerm((TermNode) visit(ctx.term()));
        return node;
    }

    @Override public AST visitLenUnary(QbricksParser.LenUnaryContext ctx) {
        LenNode node = new LenNode();
        node.setQrTerm((QregNode) visit(ctx.qReg()));
        return node;
    }

    @Override public AST visitSqrtUnary(QbricksParser.SqrtUnaryContext ctx) {
        UnOpNode node = new UnOpNode();
        node.setOp(ctx.SQRT().getText());   // chars "sqrt"
        node.setInnerTerm((TermNode) visit(ctx.term()));
        return node;
    }

    @Override public AST visitAtomTerm(QbricksParser.AtomTermContext ctx) {
        return visit(ctx.atom());
    }

    @Override public AST visitNumAtom(QbricksParser.NumAtomContext ctx) {
        AtomNode node = new AtomNode();
        node.setValue("Num "+ctx.value.getText());
        node.setType("Num");

        return node;
    }

    @Override public AST visitPiAtom(QbricksParser.PiAtomContext ctx) {
        AtomNode node = new AtomNode();
        node.setValue("Num pi");
        node.setType("Num");
        return node;
    }

    @Override public AST visitVarAtom(QbricksParser.VarAtomContext ctx) {
        AtomNode node = new AtomNode();
        node.setValue("Var \""+ctx.var.getText()+"\"");
        node.setType("Var");
        return node;
    }


}


