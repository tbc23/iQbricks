import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
public class EvaluateVisitor2 extends MyASTVisitor<String>{
    @Override
    public String Visit(ProgramNode node) {
        List<String> auxs = new ArrayList<>();
        for (AuxNode c: node.getAuxList()){
            auxs.add(Visit(c));
        }
        return Visit(node.getMain())+Arrays.toString(auxs.toArray());
    }

    @Override
    public String Visit(MainNode node) {
        if(node.getHasParams())
            return "Main function id: "+node.getID()+
                    "\nmain parameters: "+Visit(node.getParams())+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\nmain circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos());
        else return "Main function id: "+node.getID()+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\nmain circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos())+"\n";
    }

    @Override
    public String Visit(AuxNode node) {
        if(node.getHasParams())
            return "Aux function id: "+node.getID()+
                    "\n"+node.getID()+" parameters: "+Visit(node.getParams())+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\n"+node.getID()+" circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos());
        else return "Main function id: "+node.getID()+
                "\npre-condition:"+Visit(node.getPre())+
                "\n"+node.getID()+" circ: "+Visit(node.getCirc())+
                "\npos-condition:"+Visit(node.getPos())+"\n";
    }

    @Override
    public String Visit(ParamsNode node) {
        return Arrays.toString(node.getPs().toArray());
    }

    @Override
    public String Visit(PreNode node) {
        return Arrays.toString(node.get().toArray());
    }

    @Override
    public String Visit(PosNode node) {
        return Arrays.toString(node.get().toArray())+"\n\n";
    }

    @Override
    public String Visit(BodyNode node) {
        List<String> instrs = new ArrayList<>();
        for(InstrNode c:node.getBodyInstr()){
            instrs.add(Visit(c));
        }
        return "body assertion: "+Visit(node.getAssertion())+"\nbody instructions {\n"
                + Arrays.toString(instrs.toArray())+"\n}";
    }

    @Override
    public String Visit(CircNode node) {

        return "circ registers: "+Visit(node.getIds())+
                "\ncirc body:\n"+Visit(node.getBody());
    }

    @Override
    public String Visit(CircIds node) {
        List<String> qregs = new ArrayList<>();
        for(QregNode c:node.getRegs()){
            qregs.add(Visit(c));
        }
        return Arrays.toString(qregs.toArray());
    }

    @Override
    public String Visit(AssertNode node) {
        if (node!=null)
            return Arrays.toString(node.getAssertions().toArray());
        else return "";
    }

    @Override
    public String Visit(ForNode node) {
        return "for instruction with "+Visit(node.getIter())+'\n'+
                "invariant: "+Visit(node.getInvariant())+"\n"
                + "for's body:\n"+Visit(node.getBody())+
                "for's assertion: "+Visit(node.getAssertion());
    }

    @Override
    public String Visit(ForIter node) {
        if(node.getRange() && node.getIterQr())
            return "variable "+node.getIterator()+" iterating in range "+
                    Visit(node.getIterableQr()); // for i in range(expr)
        else if (node.getRange() && !node.getIterQr())
            return "variable "+node.getIterator()+" iterating in range "+
                    Visit(node.getIterableExpr()); // for i in range(qr)
        else if(node.getIterQr())
            return "variable "+node.getIterator()+" iterating "+
                Visit(node.getIterableQr());
        else return "variable "+node.getIterator()+" iterating "+
                    Visit(node.getIterableExpr());
    }

    @Override
    public String Visit(InvariantNode node) {
        return Arrays.toString(node.get().toArray());
    }

    @Override
    public String Visit(IfNode node) {
        if(!node.getWithElse())
            return "if instruction with condition: "+Visit(node.getCond())+"\n"+
                "if's body:\n"+Visit(node.getIfBody())+"if's assertion: "+
                    Visit(node.getAssertion());
        else return "if instruction with condition: "+Visit(node.getCond())+"\n"+
                "if's body:\n"+Visit(node.getIfBody())+"\nelse's body:\n"+
                Visit(node.getElseBody())+"if's assertion: "+
                Visit(node.getAssertion());
    }

    @Override
    public String Visit(IfCond node) {
        return Visit(node.getExpr());
    }

    @Override
    public String Visit(RetNode node) {
        if(node.getArgBool())
            return "return "+ Visit(node.getArgs());
        else return "empty return\n";
    }

    @Override
    public String Visit(FunApply node) {
        List<String> args = new ArrayList<>();
        for(TermNode arg:node.getTermArgs()){
            args.add(Visit(arg));
        }
        return "Function apply: "+node.getFunID() + Arrays.toString(args.toArray())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(RevApply node) {
        List<String> args = new ArrayList<>();
        for(TermNode arg:node.getTermArgs()){
            args.add(Visit(arg));
        }
        return "Reverse Function apply: "+node.getFunID() + Arrays.toString(args.toArray())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(HadApply node) {
        return
                "Hadamard apply to: "+Visit(node.getQreg())
                        + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(RxApply node) {

        return "Rx apply to: "+Visit(node.getQreg())+" with angle "+Visit(node.getAngle())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(RyApply node) {

        return "Ry apply to: "+Visit(node.getQreg())+" with angle "+Visit(node.getAngle())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(RzApply node) {

        return "Rz apply to: "+Visit(node.getQreg())+" with angle "+Visit(node.getAngle())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(XApply node) {

        return "X apply to: "+Visit(node.getQreg())+ " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(YApply node) {

        return "Y apply to: "+Visit(node.getQreg())+ " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(ZApply node) {

        return "Z apply to: "+Visit(node.getQreg())+ " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(SwapApply node) {

        return "Swap apply to: "+Visit(node.getLQreg())+" and "+Visit(node.getRQreg())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(PhApply node) {
        return "Ph apply to: "+Visit(node.getQreg())+" with angle "+Visit(node.getAngle())
                + " assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(WithCtlNode node) {
        List<String> controls = new ArrayList<>();
        for (QregNode qr:node.getCtlArgs()){
            controls.add(Visit(qr));
        }
        return "multi-control(controls:"+Arrays.toString(controls.toArray())+","+Visit(node.getCtlGate())
                + ") assertion: "+Visit(node.getAssertion())+"\n";
    }

    @Override
    public String Visit(CnotNode node) {

        return "cnot("+Visit(node.getCtl())+","+Visit(node.getTarget())+")\n"
                + " assertion: "+Visit(node.getAssertion());
    }

    @Override
    public String Visit(QregNode node) {
        if (!node.hasRange())
            return node.getId();
        else return node.getId()+Visit(node.getRange());
    }

    @Override
    public String Visit(RangeNode node) {
        List<Integer> iterList = new ArrayList<>();
        String r, s, e;
        TermNode start = node.getStart();
        TermNode end = node.getEnd();
        if (start==null){ // upTo
            s = Visit(end);
            r = "[0,..."+s+"]";
        } else if (end==null) { //from
            s = Visit(start);
            r = "["+s+",...,N]";
        } else if (start.equals(end)){ //term
            s = Visit(start);
            r = "["+s+"]";
        } else { //interval
            s = Visit(start);
            e = Visit(end);
            r = "["+s+",...,"+e+"]";
        }
            return r;
    }

    @Override
    public String Visit(EqualNode node) {
        return Visit(node.getLeft()) + "==" + Visit(node.getRight());
    }

    @Override
    public String Visit(GTNode node) {
        return Visit(node.getLeft()) + ">" + Visit(node.getRight());
    }

    @Override
    public String Visit(LTNode node) {
        return Visit(node.getLeft()) + "<" + Visit(node.getRight());
    }

    @Override
    public String Visit(GEQNode node) {
        return Visit(node.getLeft()) + ">=" + Visit(node.getRight());
    }

    @Override
    public String Visit(LEQNode node) {
        return Visit(node.getLeft()) + "<=" + Visit(node.getRight());
    }

    @Override
    public String Visit(NEqualNode node) {
        return Visit(node.getLeft()) + "!=" + Visit(node.getRight());
    }

    @Override
    public String Visit(PowerNode node) {
        return Visit(node.getLeft()) + "^" + Visit(node.getRight());
    }

    @Override
    public String Visit(MulNode node) {
        return Visit(node.getLeft()) + "*" + Visit(node.getRight());
    }

    @Override
    public String Visit(DivNode node) {
        return Visit(node.getLeft()) + "/" + Visit(node.getRight());
    }

    @Override
    public String Visit(AddNode node) {
        return Visit(node.getLeft()) + "+" + Visit(node.getRight());
    }

    @Override
    public String Visit(SubNode node) {
        return Visit(node.getLeft()) + "-" + Visit(node.getRight());
    }

    @Override
    public String Visit(UnOpNode node) {
        return node.getOp() +"("+ Visit(node.getInnerTerm())+")";
    }

    @Override
    public String Visit(LenNode node) {
        return "length("+ Visit(node.getQrTerm())+")";
    }

    @Override
    public String Visit(AtomNode node) {
        return node.getValue();
    }

}*/

