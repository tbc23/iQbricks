import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateVisitor extends MyASTVisitor<String>{

    public Stack<String> circs = new Stack<>();
    // public String size = "";

    @Override
    public String Visit(ProgramNode node) {
        StringBuilder r = new StringBuilder();
        r.append(Visit(node.getMain()));
        for (AuxNode c: node.getAuxList()){
            r.append(Visit(c));
        }
        return r+"end";
    }

    @Override
    public String Visit(MainNode node) {
        circs.push("c");
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        return "module " + node.getID().toUpperCase() +
                """

                        use export binary.Bit_vector
                        use wired_circuits.Circuit_c
                        use export p_int.Int_comp
                        use ref.Ref
                        
                        """ +
                "let main (n:int)"
                +": circuit\n"+
                "requires {n > 0}\n"+
                "requires {"+qregs+" = n}\n"+
                "requires "+ Visit(node.getPre())+
                "\nensures "+ Visit(node.getPos())+
                "\nensures {width result = n}"+
                "\nensures {range result = n}"
                +"\n=\n"+Visit(node.getCirc())+"\n";
        /*if(node.getHasParams())
            return "Main function id: "+node.getID()+
                    "\nmain parameters: "+Visit(node.getParams())+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\nmain circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos());
        else return "Main function id: "+node.getID()+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\nmain circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos())+"\n";*/
    }

    @Override
    public String Visit(AuxNode node) {
        //circs.push("c");
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        return "let " +node.getID()+ "(n:int)"
                    +": circuit\n"+
                    "requires {n > 0}\n"+
                    "requires {"+qregs+" = n}\n"+
                    "requires "+ Visit(node.getPre())+
                    "\nensures "+ Visit(node.getPos())+
                    "\nensures {width result = n}\n"+
                    "\nensures {range result = n}\n"
                    +"\n=\n"+Visit(node.getCirc())+"\n";
        /*if(node.getHasParams())
            return "Aux function id: "+node.getID()+
                    "\n"+node.getID()+" parameters: "+Visit(node.getParams())+
                    "\npre-condition:"+Visit(node.getPre())+
                    "\n"+node.getID()+" circ: "+Visit(node.getCirc())+
                    "\npos-condition:"+Visit(node.getPos());
        else return "Main function id: "+node.getID()+
                "\npre-condition:"+Visit(node.getPre())+
                "\n"+node.getID()+" circ: "+Visit(node.getCirc())+
                "\npos-condition:"+Visit(node.getPos())+"\n";*/
    }

    @Override
    public String Visit(ParamsNode node) {
        StringBuilder r = new StringBuilder();
        for (SingleParam c: node.getPs()) {
            r.append(c.getId()).append(" ");
        }
        return r.toString();
    }

    @Override
    public String Visit(PreNode node) {
        StringBuilder r = new StringBuilder();
        for (String c: node.get()){
            r.append(c);
        }
        return r.toString();
    }

    @Override
    public String Visit(PosNode node) {
        StringBuilder r = new StringBuilder();
        for (String c: node.get()){
            r.append(c);
        }
        return r.toString();
    }

    @Override
    public String Visit(BodyNode node) {
        //List<String> instrs = new ArrayList<>();
        StringBuilder r = new StringBuilder(Visit(node.getAssertion()));
        for(InstrNode c:node.getBodyInstr()){
            r.append(Visit(c));
            //instrs.add(Visit(c));
        }
        return  r.toString();
                //+ Arrays.toString(instrs.toArray())+"\n}";
    }

    @Override
    public String Visit(CircNode node) {

        return "begin\nlet "+circs.peek()+" = ref (m_skip n) in \n"
                +Visit(node.getBody())+"end\n";
    }

    @Override
    public String Visit(CircIds node) {
        StringBuilder qregs = new StringBuilder();
        qregs.append(Visit(node.getRegs().get(0)));
        if (node.getRegs().size()>1) {
            for (QregNode c : node.getRegs().subList(1, node.getRegs().size())) {
                qregs.append("+").append(Visit(c));
            }
        }
        return qregs.toString();
    }

    @Override
    public String Visit(AssertNode node) {
        StringBuilder r = new StringBuilder();
        if (node!=null) {
            for (String c : node.getAssertions())
                r.append("assert").append(c).append(";\n");
        }
        //else r.append("");
        return r.toString();
    }

    @Override
    public String Visit(ForNode node) {
        String old, r;
        ForIter iter = node.getIter();
        String iterator = iter.getIterator();
        circs.push("c"+circs.size());
        r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                + Visit(node.getIter())
                + Visit(node.getInvariant())
                + Visit(node.getBody())
                + iterator +" := !" + iterator + " + 1\ndone;\n"
                + Visit(node.getAssertion());
        old = circs.pop();
        r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        return r;
    }

    @Override
    public String Visit(ForIter node) {
        String r,s,e,iterator=node.getIterator();
        String[] limits;
        if(node.getRange() && node.getIterQr()) {
            limits = Visit(node.getIterableQr()).split(" ");
            s = limits[0];
            e = limits[1];
            r = "let ref " + iterator + " = "+s+"\n" +
                    "in while (!" + iterator + "<"
                    + e +") do\n";
            // for i in range(qr)
        }
        else if (node.getRange() && !node.getIterQr()) {
            s = "0";
            e = Visit(node.getIterableExpr());
            r = "let ref " + iterator + " = 0\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
            // for i in range(expr)
        }
        else if(node.getIterQr()){
            s = "0";
            e = Visit(node.getIterableQr());
            r = "let ref " + iterator + " = 0\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
            //return "variable "+iterator+" iterating "+ Visit(node.getIterableQr());
        }
        else return "Can only iterate qreg or range operator\n";
            //return "variable "+iterator+" iterating "+Visit(node.getIterableExpr());
        r +=    "variant{"+e+" - "+iterator+"}\n" +
                "invariant{"+s+" <= "+iterator+" <= "+e+"}\n"+
                "invariant{width !"+circs.peek()+" = n}\n";
        return r;
    }

    @Override
    public String Visit(InvariantNode node) {
        StringBuilder r = new StringBuilder();
        if (node!=null) {
            for (String c : node.get())
                r.append("invariant").append(c).append("\n");
        }
        //else r.append("");
        return r.toString();
        //return Arrays.toString(node.get().toArray());
    }

    @Override
    public String Visit(IfNode node) {
        String old, r;
        circs.push("c"+circs.size());
        if(!node.getWithElse())
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "+
                    "if ("+Visit(node.getCond())+")\nthen begin\n"+
                    Visit(node.getAssertion())+ Visit(node.getIfBody())+"end\n";
        else r = "let "+circs.peek()+" = ref (m_skip n)\nin "+
                "if ("+Visit(node.getCond())+")\nthen begin\n"+
                Visit(node.getAssertion())+ Visit(node.getIfBody())+"end\n"+"else begin\n"+
                Visit(node.getElseBody())+"end\n";
        old = circs.pop();
        r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        return r;
    }

    @Override
    public String Visit(IfCond node) {
        return Visit(node.getExpr());
    }

    @Override
    public String Visit(RetNode node) {
        if(node.getArgBool())
            return "return "+ Visit(node.getArgs());
        else return "return (!"+circs.peek()+")\n";
    }

    @Override
    public String Visit(FunApply node) {
        List<String> args = new ArrayList<>();
        for(TermNode arg:node.getTermArgs()){
            args.add(Visit(arg));
        }
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- "+node.getFunID()+"(n);\n"
            + Visit(node.getAssertion());
        /*return "Function apply: "+node.getFunID() + Arrays.toString(args.toArray())
                + " assertion: "+Visit(node.getAssertion())+"\n";*/
        return r;
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
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place_hadamard "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RxApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place (rx "
                + Visit(node.getAngle())+") "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RyApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place (ry "
                + Visit(node.getAngle())+") "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RzApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place (rz "
                + Visit(node.getAngle())+") "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(XApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place xx "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(YApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place yy "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;    }

    @Override
    public String Visit(ZApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place zz "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;    }

    @Override
    public String Visit(SwapApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place (swap "
                + Visit(node.getLQreg())+" "
                +Visit(node.getRQreg())+") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(PhApply node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (place (phase "
                + Visit(node.getAngle())+") "
                +Visit(node.getQreg())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(WithCtlNode node) {
        List<String> controls = new ArrayList<>();
        String aux,angle,r,old,target = null;
        ApplyNode gate = node.getCtlGate();
        if (gate instanceof FunApply) // not defined
            aux = ((FunApply) gate).getFunID()+(((FunApply) gate).getTermArgs());
        else if (gate instanceof RevApply) // not defined
            aux = ((RevApply) gate).getFunID()+(((RevApply) gate).getTermArgs());
        else if (gate instanceof HadApply) {
            target = Visit(((HadApply) gate).getQreg());
            aux = " hadamard ";
        }
        else if (gate instanceof RxApply) {
            target = Visit(((RxApply) gate).getQreg());
            angle = Visit(((RxApply) gate).getAngle());
            aux = " (rx "+ angle +") ";
        }
        else if (gate instanceof RyApply) {
            target = Visit(((RyApply) gate).getQreg());
            angle = Visit(((RyApply) gate).getAngle());
            aux = " (ry "+ angle +") ";
        }
        else if (gate instanceof RzApply){
            target = Visit(((RzApply) gate).getQreg());
            angle = Visit(((RzApply) gate).getAngle());
            aux = " (rz "+ angle +") ";
        }
        else if (gate instanceof XApply){
            target = Visit(((XApply) gate).getQreg());
            aux = " xx ";
        }
        else if (gate instanceof YApply){
            target = Visit(((YApply) gate).getQreg());
            aux = " yy ";
        }
        else if (gate instanceof ZApply){
            target = Visit(((ZApply) gate).getQreg());
            aux = " zz ";
        }
        else if (gate instanceof SwapApply){
            target = Visit(((SwapApply) gate).getLQreg());
            aux = " swap "; //not yet defined
        }
        else{
            target = Visit(((PhApply) gate).getQreg());
            angle = Visit(((PhApply) gate).getAngle());
            aux = " (phase "+ angle +") ";
        }
        for (QregNode qr:node.getCtlArgs()){
            controls.add(Visit(qr));
        }
        // has to be done in a loop for iterating the controls
        // but how to know which controls must be applied in the loop??
        // do single intructions with each control instead?
        /*circs.push("c"+circs.size());
        r = "let "+circs.peek()+" = ref (m_skip n)\nin\n"
                + "let ctl = ref 0\n"
                + "in while (!ctl < "+controls.size()+") do\n"
                +
                + iterator +" := !" + iterator + " + 1\ndone;\n"
                + Visit(node.getAssertion());
        old = circs.pop();
        r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";*/

        r = circs.peek()+":= !"+circs.peek()+" -- cont"+aux+controls.get(0)
            +" "+ target + " n;\n"+Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(CnotNode node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (cnot "
                +Visit(node.getCtl())+" "+Visit(node.getTarget())+" n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(QregNode node) {
        if (!node.hasRange())
            return node.getId();
        else return Visit(node.getRange());
    }

    @Override
    public String Visit(RangeNode node) {
        // List<String> iterList = new ArrayList<>();
        String r, s, e;
        TermNode start = node.getStart();
        TermNode end = node.getEnd();
        if (start==null){ // upTo
            s = "0";
            e = Visit(end);
            if (e.equals("-1")) {
                e = "n-1";
            }
            r = s + " " + e;
        } else if (end==null) { //from
            s = Visit(start);
            e = "n";
            r = s + " " + e;
        } else if (start.equals(end)){ //term
            s = Visit(start);
            if (s.equals("-1")) {
                s = "n-1";
            }
            r = s;
        } else { //interval
            s = Visit(start);
            e = Visit(end);
            if (e.equals("-1")) {
                e = "n-1";
            }
            r = s + " " + e;
        }
        return r;
    }

    @Override
    public String Visit(EqualNode node) {
        return Visit(node.getLeft()) + "=" + Visit(node.getRight());
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
        return "power " +Visit(node.getLeft()) +" "+ Visit(node.getRight());
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
        String r;
        if (node.getOp().equals("sqrt"))
            r = node.getOp() + "("+Visit(node.getInnerTerm())+")";
        else r = node.getOp() + Visit(node.getInnerTerm());
        return r;
    }

    @Override
    public String Visit(LenNode node) {
        return "n";
        //return  Visit(node.getQrTerm());
    }

    @Override
    public String Visit(ParenNode node) {
        return "(" + Visit(node.getTerm()) + ")";
    }

    @Override
    public String Visit(AtomNode node) {
        return node.getValue();
    }

}
