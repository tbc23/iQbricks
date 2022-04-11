import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateVisitor extends MyASTVisitor<String>{

    public Stack<String> circs = new Stack<>();
    public List<String> auxIds = new ArrayList<>();
    public List<String> global_qrs = new ArrayList<>();
    public Boolean diag = false;

    @Override
    public String Visit(ProgramNode node) {
        StringBuilder r = new StringBuilder();
        List<String> auxs = new ArrayList<>();
        List<String> undeclared_funs = new ArrayList<>();
        List<String> declared_funs = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        circs.push("c");
        String main = Visit(node.getMain());

        r.append("module ").append(node.getMain().getID().toUpperCase()).append("\n\n");
        if (!node.getAuxList().isEmpty()) {
            for (AuxNode c : node.getAuxList()) {
                auxs.add(Visit(c));
                declared_funs.add(c.getID());
            }
            // auxIds list can be checked for seeing if function
            // is declared in this file...
            // should be careful because auxIds contains IDs for every
            // function call -> if the size of auxIds is bigger than node.getAuxList():
            if (node.getAuxList().size() < auxIds.size()){
                for (String s : auxIds) {
                    if (!declared_funs.contains(s))  // check which functions to import
                        undeclared_funs.add(s);
                }
                for (String s: undeclared_funs) {
                    auxIds.remove(s);
                    r.append("use export ").append(s.toUpperCase()).append("\n");
                }
            }

            r.append("""

                use export binary.Bit_vector
                use wired_circuits.Circuit_c
                use export p_int.Int_comp
                use ref.Ref
                                        
                """); // make imports here
            for (AuxNode c : node.getAuxList())  // fill index list with final destination
                index.add(auxIds.indexOf(c.getID()));
            for (int n, i = 0; i < index.size(); ++i) {
                n = index.indexOf(i);
                r.append(auxs.get(n));
                // n will take the value of the aux funs index
                // e.g. index = [2,3,1,0]; auxs = [aux0,aux1,aux2,aux3];
                // aux functions will be appended on this order:
                // aux3->aux2->aux0->aux1
            }
        } else {
            undeclared_funs = auxIds;   // in case there are no aux functions, all auxIDS
                                        // will have to be imported
            for (String s: undeclared_funs) {
                r.append("use export ").append(s.toUpperCase()).append("\n");
            }
            r.append("""
                use export binary.Bit_vector
                use wired_circuits.Circuit_c
                use export p_int.Int_comp
                use ref.Ref
                                        
                """);
        }
        r.append(main);
        return r+"end";
    }

    @Override
    public String Visit(MainNode node) {
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        return "let main ("+Visit(node.getParams())+"n:int)"
                +": circuit\n"+
                "requires {n > 0}\n"+
                "requires {"+qregs+" = n}\n"+
                "requires "+ Visit(node.getPre())+
                "\nensures "+ Visit(node.getPos())+
                "\nensures {width result = n}"+
                "\nensures {range result = n}"
                +"\n=\n"+Visit(node.getCirc())+"\n";
    }

    @Override
    public String Visit(AuxNode node) {
        //circs.push("c");
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        String r;
        if (!auxIds.contains(node.getID())) auxIds.add(node.getID());
        r = "let " +node.getID()+ "("+Visit(node.getParams())+"n:int)"
                    +": circuit\n"+
                    "requires {n > 0}\n"+
                    "requires {"+qregs+" = n}\n"+
                    "requires "+ Visit(node.getPre())+
                    "\nensures "+ Visit(node.getPos())+
                    "\nensures {width result = n}"+
                    "\nensures {range result = n}"
                    +"\n=\n"+Visit(node.getCirc())+"\n";
        return r;
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
        StringBuilder r = new StringBuilder(Visit(node.getAssertion()));
        for(InstrNode c:node.getBodyInstr()){
            r.append(Visit(c));
        }
        return  r.toString();
    }

    @Override
    public String Visit(CircNode node) {

        return "begin\nlet "+circs.peek()+" = ref (m_skip n) in \n"
                +Visit(node.getBody())+"end\n";
    }

    @Override
    public String Visit(CircIds node) {
        StringBuilder qregs = new StringBuilder();
        String qr = Visit(node.getRegs().get(0));
        global_qrs.clear();
        qregs.append(qr);
        global_qrs.add(qr);
        if (node.getRegs().size()>1) {
            for (QregNode c : node.getRegs().subList(1, node.getRegs().size())) {
                qr = Visit(c);
                qregs.append("+").append(qr);
                global_qrs.add(qr);
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
        return r.toString();
    }

    @Override
    public String Visit(ForNode node) {
        String old, r,body;
        ForIter iter = node.getIter();
        String iterator = iter.getIterator();
        circs.push("c"+circs.size());
        r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                + Visit(node.getIter())
                + Visit(node.getInvariant());
        body = Visit(node.getBody());
        if (diag) r += "invariant{range !"+circs.peek()+" = 0}\n";
        r += body + iterator +" := " + iterator + " + 1\ndone;\n"
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
                    "in while (" + iterator + "<"
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
            limits = Visit(node.getIterableQr()).split(" ");
            if (limits.length>1) {
                s = limits[0];
                e = limits[1];
            }
            else {
                s = "0";
                e = limits[0];
            }
            r = "let ref " + iterator + " = 0\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
        }
        else return "Can only iterate qreg or range operator\n";

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
        return r.toString();
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
        StringBuilder args = new StringBuilder();
        String r;
        for(TermNode arg:node.getTermArgs()){
            args.append(Visit(arg)).append(" ");
        }
        if (!auxIds.contains(node.getFunID()))
            auxIds.add(0,node.getFunID());
        else {
            auxIds.remove(node.getFunID());
            auxIds.add(0, node.getFunID());
        }
        r = circs.peek()+":= !"+circs.peek()+" -- ("+node.getFunID()+" "+args+"n);\n"
                    + Visit(node.getAssertion());

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
        String r,old,start,end,qr = Visit(node.getQreg());
        String[] limits;
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= !"+circs.peek()
                    + " -- (place_hadamard i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            limits = qr.split(" ");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= !"+circs.peek()+" -- (place_hadamard i n);\n" + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= !"+circs.peek()+" -- (place_hadamard ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RxApply node) {
        String r, old, start, end, qr= Visit(node.getQreg());
        String[] limits;
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= !"+circs.peek()
                    +" -- (place (rx (" +Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            limits = qr.split(" ");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= !"+circs.peek()+" -- (place (rx (" +
                     Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= !"+circs.peek()+" -- (place (rx ("
                + Visit(node.getAngle())+")) ("
                + qr +") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RyApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= !"+circs.peek()
                    +" -- (place (ry (" + Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String[] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            r = "let " + circs.peek() + " = ref (m_skip n)\nin "
                    + "let ref i = " + start + "\n"
                    + "in while (i < " + end + ") do\n"
                    + "variant{" + end + " - i}\n"
                    + "invariant{" + start + " <= i <= " + end + "}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !" + circs.peek() + " = " + end + " - " + start + "}\n"
                    + circs.peek() + ":= !" + circs.peek()
                    +" -- (place (ry (" +Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= !"+circs.peek()+" -- (place (ry ("
                + Visit(node.getAngle())+")) ("
                + qr +") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(RzApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = 0}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= seq_diag !"+circs.peek()
                    + " (place (rz ("+ Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String[] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            r = "let " + circs.peek() + " = ref (m_skip n)\nin "
                    + "let ref i = " + start + "\n"
                    + "in while (i < " + end + ") do\n"
                    + "variant{" + end + " - i}\n"
                    + "invariant{" + start + " <= i <= " + end + "}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !" + circs.peek() + " = " + end + " - " + start + "}\n"
                    + circs.peek() + ":= seq_diag !" + circs.peek()
                    + " (place (rz ("+ Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= seq_diag !"+circs.peek()+" (place (rz ("
                + Visit(node.getAngle())+")) ("
                + qr +") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(XApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= !"+circs.peek() +" -- (place xx i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String [] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= !"+circs.peek()+" -- (place xx i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= !"+circs.peek()+" -- (place xx ("
                +qr+") n);\n" +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(YApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= !"+circs.peek() +" -- (place yy i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String [] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= !"+circs.peek()+" -- (place yy i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= !"+circs.peek()+" -- (place yy ("
                +qr+") n);\n" +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(ZApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = 0}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= seq_diag !" + circs.peek()+" (place zz i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String [] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= seq_diag !"+circs.peek()+" (place zz i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= seq_diag !"+circs.peek()+" (place zz ("
                +qr+") n);\n" +Visit(node.getAssertion());
        return r;    }

    @Override
    public String Visit(SApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = 0}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= seq_diag !" + circs.peek()+" (place s i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String [] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= seq_diag !"+circs.peek()+" (place s i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= seq_diag !"+circs.peek()+" (place s ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(TApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = 0}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= seq_diag !" + circs.peek()+" (place t i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String [] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= seq_diag !"+circs.peek()+" (place t i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= seq_diag !"+circs.peek()+" (place t ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        return r;
    }

    public String Visit(SwapApply node) {
        String r;
        diag = false;
        r = circs.peek()+":= !"+circs.peek()+" -- (swap ("
                + Visit(node.getLQreg())+") ("
                +Visit(node.getRQreg())+") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(PhApply node) {
        String r, old, qr = Visit(node.getQreg());
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = 0 \n"
                    + "in while (i < "+qr+") do\n"
                    + "variant{"+qr+" - i}\n"
                    + "invariant{0 <= i <= " +qr+"}\n"
                    + "invariant{range !"+circs.peek()+" = 0}\n"
                    + "invariant{width !"+circs.peek()+" = "+qr+"}\n"
                    + circs.peek()+":= seq_diag !"+circs.peek()
                    + " (place (phase (" + Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else if (qr.contains(" ")) {
            String[] limits = qr.split(" ");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            r = "let " + circs.peek() + " = ref (m_skip n)\nin "
                    + "let ref i = " + start + "\n"
                    + "in while (i < " + end + ") do\n"
                    + "variant{" + end + " - i}\n"
                    + "invariant{" + start + " <= i <= " + end + "}\n"
                    //+ "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !" + circs.peek() + " = " + end + " - " + start + "}\n"
                    + circs.peek() + ":= seq_diag !" + circs.peek()
                    + " (place (phase (" + Visit(node.getAngle())+")) i n);\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else r = circs.peek()+":= seq_diag !"+circs.peek()+" (place (phase ("
                + Visit(node.getAngle())+")) ("
                + qr +") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(WithCtlNode node) {
        List<String> controls = new ArrayList<>();
        String[] limits;
        String aux,angle,r,start,end,old,qr,target = null;
        ApplyNode gate = node.getCtlGate();
        if (gate instanceof FunApply) // not defined
            aux = ((FunApply) gate).getFunID()+(((FunApply) gate).getTermArgs());
        else if (gate instanceof RevApply) // not defined
            aux = ((RevApply) gate).getFunID()+(((RevApply) gate).getTermArgs());
        else if (gate instanceof HadApply) {
            target = Visit(((HadApply) gate).getQreg());
            aux = " hadamard ";
            diag = false;
        }
        else if (gate instanceof RxApply) {
            target = Visit(((RxApply) gate).getQreg());
            angle = Visit(((RxApply) gate).getAngle());
            aux = " (rx ("+ angle +")) ";
            diag = false;
        }
        else if (gate instanceof RyApply) {
            target = Visit(((RyApply) gate).getQreg());
            angle = Visit(((RyApply) gate).getAngle());
            aux = " (ry ("+ angle +")) ";
            diag = false;
        }
        else if (gate instanceof RzApply){
            target = Visit(((RzApply) gate).getQreg());
            angle = Visit(((RzApply) gate).getAngle());
            aux = " (rz ("+ angle +")) ";
            diag = true;
        }
        else if (gate instanceof XApply){
            target = Visit(((XApply) gate).getQreg());
            aux = " xx ";
            diag = false;
        }
        else if (gate instanceof YApply){
            target = Visit(((YApply) gate).getQreg());
            aux = " yy ";
            diag = false;
        }
        else if (gate instanceof ZApply){
            target = Visit(((ZApply) gate).getQreg());
            aux = " zz ";
            diag = true;
        }
        else if (gate instanceof SwapApply){
            target = Visit(((SwapApply) gate).getLQreg());
            aux = " swap "; //not yet defined
            diag = false;
        }
        else{
            target = Visit(((PhApply) gate).getQreg());
            angle = Visit(((PhApply) gate).getAngle());
            aux = " (phase ("+ angle +")) ";
            diag = true;
        }

        for (QregNode n:node.getCtlArgs()){
            controls.add(Visit(n));
        }
        if (controls.get(0).contains(" ")) {
            // this means it's NOT a qreg[term] or qreg
            limits = controls.get(0).split(" ");
            start = limits[0]; end = limits[1];

            circs.push("c"+circs.size());
            if (!diag) {
            r = "let "+circs.peek()+" = ref"+aux+"\nin "
                    + "let ref ctl = "+start+" \n"
                    + "in while (ctl < "+end+") do\n"
                    + "variant{"+end+" - ctl}\n"
                    + "invariant{"+start+" <= ctl <= "+end+"}\n"
                    + circs.peek()+":= cont !"+circs.peek()
                    +" ctl ("+ target + ") n;\n"+Visit(node.getAssertion())
                    + "ctl := ctl + 1\ndone;\n"
                    + Visit(node.getAssertion());
            } else {
                r = "let "+circs.peek()+" = ref"+aux+"\nin "
                        + "let ref ctl = "+start+" \n"
                        + "in while (ctl < "+end+") do\n"
                        + "variant{"+end+" - ctl}\n"
                        + "invariant{"+start+" <= ctl <= "+end+"}\n"
                        + "invariant{range !" + circs.peek() + " = 0}\n"
                        + circs.peek()+":= diag_cont !"+circs.peek()
                        +" ctl ("+ target + ") n;\n"+Visit(node.getAssertion())
                        + "ctl := ctl + 1\ndone;\n"
                        + Visit(node.getAssertion());
            }

            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        } else {
            qr = controls.get(0); // be careful here because a whole register can't be used as controls
            if (!diag) {
                r = circs.peek()+":= !"+circs.peek()+" -- cont"+aux+"("+qr
                +") ("+ target + ") n;\n"+Visit(node.getAssertion());
            } else r = circs.peek()+":= seq_diag !"+circs.peek()+" cont"+aux+"("+qr
                    +") ("+ target + ") n;\n"+Visit(node.getAssertion());
        }

        return r;
    }

    @Override
    public String Visit(CnotNode node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (cnot ("
                +Visit(node.getCtl())+") ("+Visit(node.getTarget())+") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(ToffNode node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (toffoli ("
                +Visit(node.getCtl1())+") ("+Visit(node.getCtl2())+") ("
                +Visit(node.getTarget())+") n);\n"
                +Visit(node.getAssertion());
        return r;
    }

    @Override
    public String Visit(FredNode node) {
        String r;
        r = circs.peek()+":= !"+circs.peek()+" -- (fredkin ("
                +Visit(node.getCtl1())+") ("+Visit(node.getCtl2())+") ("
                +Visit(node.getTarget())+") n);\n"
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
            //r = e;
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
