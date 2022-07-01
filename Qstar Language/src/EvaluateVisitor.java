import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateVisitor extends MyASTVisitor<String>{

    public Stack<String> circs = new Stack<>();
    public List<String> auxIds = new ArrayList<>();
    public List<String> global_qrs = new ArrayList<>();
    public Boolean diag = false;
    public List<String> unitaries = new ArrayList<>();
    public List<List<String>> asserts = new ArrayList<>();

    public String printUnitaries (List<String> l) {
        String old, s="";
        if (!l.isEmpty()) {
            if (l.size() < 2)
                s = "Unitary ("+l.get(0)+");\n";
            else {
                s = "Sequence ("+l.get(1)+","+l.get(0)+")";
                for (int i = 2; l.size()>i; i++){
                    old = s;
                    s = "Sequence (" + l.get(i) + "," + old + ")";
                } s = "Unitary("+s+");\n";
            }
        }
        return s;
    }

    @Override
    public String Visit(ProgramNode node) {
        StringBuilder r = new StringBuilder();
        StringBuilder t = new StringBuilder();
        List<String> auxs = new ArrayList<>();
        List<String> undeclared_funs = new ArrayList<>();
        List<String> declared_funs = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        circs.push("c");
        String main = Visit(node.getMain());
        t.append("""
                open ML_AST2
                open ML_eval
                                
                let p = {
                    id = "program";
                """);
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
            t.append("aux = [\n");

            for (AuxNode c : node.getAuxList())  // fill index list with final destination
                index.add(auxIds.indexOf(c.getID()));
            for (int n, i = 0; i < index.size(); ++i) {
                n = index.indexOf(i);
                r.append(auxs.get(n));
                t.append("\n").append(auxs.get(n));
                // n will take the value of the aux funs index
                // e.g. index = [2,3,1,0]; auxs = [aux0,aux1,aux2,aux3];
                // aux functions will be appended on this order:
                // aux3->aux2->aux0->aux1
            }
            t.append("\n];\n");
        } else {
            undeclared_funs = auxIds;   // in case there are no aux functions, all auxIDS
                                        // will have to be imported
            for (String s: undeclared_funs) {
                r.append("use export ").append(s.toUpperCase()).append("\n");
            }
            t.append("aux = [];\n");
        }

        t.append(main);
        t.append("""
            let () =
                   let run = run_program p in
                   let oc = open_out "translation.mlw" in
                     Printf.fprintf oc "%s" run;
                     close_out oc;
                     print_endline "translation.mlw generated";""");
        //return r+"end";
        return t.toString();
    }

    @Override
    public String Visit(MainNode node) {
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        String r = "main = {\n id = \"" + node.getID() + "\";\n" +
                "circ = {\n" + Visit(node.getCirc()) + "};\n" +
                Visit(node.getParams()) +
                Visit(node.getPre()) + Visit(node.getPos()) +
                "}};;\n";

        return r;
    }

    @Override
    public String Visit(AuxNode node) {
        //circs.push("c");
        CircNode circ = node.getCirc();
        String qregs = Visit(circ.getIds());
        String s;
        if (!auxIds.contains(node.getID())) auxIds.add(node.getID());
        String r = "{\nid = \"" + node.getID() + "\";\n" +
                "circ = {\n" + Visit(node.getCirc()) + "};\n" +
                Visit(node.getParams()) +
                Visit(node.getPre()) + Visit(node.getPos()) +
                "};\n";

        return r;
    }

    @Override
    public String Visit(ParamsNode node) {
        StringBuilder r = new StringBuilder();
        r.append("params = [");
        for (SingleParam c: node.getPs()) {
            //r.append(c.getId()).append("; ");
            r.append("{id=\"").append(c.getId()).append("\"; ");
            r.append(" type_=").append(c.getType()).append("}; ");
        }
        return r+"];\n";
    }

    @Override
    public String Visit(PreNode node) {
        StringBuilder r = new StringBuilder();
        r.append("pre = [");
        for (String c: node.get()){
            r.append("\"").append(c).append("\"; ");
        }
        return r+"];\n";
    }

    @Override
    public String Visit(PosNode node) {
        StringBuilder r = new StringBuilder();
        r.append("pos = [");
        for (String c: node.get()){
            r.append("\"").append(c).append("\"; ");
        }
        return r+"];\n";
    }

    @Override
    public String Visit(BodyNode node) {
        StringBuilder r = new StringBuilder("body = [\n");
        unitaries.clear();
        //asserts.clear();
        for(InstrNode c:node.getBodyInstr()){
            r.append(Visit(c));
        }
        //System.out.println(unitaries);
        return r.toString();
    }

    @Override
    public String Visit(CircNode node) {
        String r;
        r = "qregs= ["+Visit(node.getIds())+"];\n"+
            Visit(node.getBody())+"];\n";
        return r;
    }

    @Override
    public String Visit(CircIds node) {
        StringBuilder qregs = new StringBuilder();
        String size, qr = node.getRegs().get(0).getId();
        if (node.getRegs().get(0).hasRange())
            size = Visit(node.getRegs().get(0).getRange());
        else size = "Num 0";
        global_qrs.clear();
        qregs.append("{qrid=\"").append(qr).append("\"; ");
        qregs.append("size=").append(size).append("}");
        global_qrs.add(qr);
        if (node.getRegs().size()>1) {
            for (QregNode c : node.getRegs().subList(1, node.getRegs().size())) {
                qr = c.getId();
                qregs.append("; {qrid=\"").append(qr).append("\"; ");
                if (c.hasRange())
                    size = Visit(c.getRange());
                else size = "Num 0";
                qregs.append("size=").append(size).append("}");
                //qregs.append("+").append(qr);
                global_qrs.add(qr);
            }
        }
        return qregs.toString();
    }

    @Override
    public String Visit(AssertNode node) {
        StringBuilder r = new StringBuilder();
        r.append("assertion=[");
        if (node!=null) {
            for (String c : node.getAssertions())
                r.append("\"").append(c).append("\"; ");
        }
        return r+"]\n";
    }

    @Override
    public String Visit(ForNode node) {
        String old, r,s,body;
        ForIter iter = node.getIter();
        String iterator = iter.getIterator();
        circs.push("c"+circs.size());
        s = printUnitaries(unitaries);

        s += "For {\n" + Visit(node.getIter())
            + Visit(node.getInvariant());
        r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                + Visit(node.getIter())
                + Visit(node.getInvariant());
        body = Visit(node.getBody());
        if (diag) {
            r += "invariant{range !"+circs.peek()+" = 0}\n";
                //+"invariant{forall x y i. 0<= i < width !"+circs.peek()
                //    +"->basis_ket !"+circs.peek()+"x y i = x i}\n";
        }
        r += body + iterator +" := " + iterator + " + 1\ndone;\n"
                + Visit(node.getAssertion());
        if (body.equals("body = [\n"))
            s += "body=[\n" + printUnitaries(unitaries) + "];\n" + Visit(node.getAssertion()) + "};\n";
        else s += body + printUnitaries(unitaries)
                +"];\n" + Visit(node.getAssertion()) + "};\n";
        old = circs.pop();
        r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        unitaries.clear();
        //asserts.clear();
        return s;
    }

    @Override
    public String Visit(ForIter node) {
        String r,s,t,e,iterator=node.getIterator();
        String[] limits;
        t = "iter = {\n";
        if(node.getRange() && node.getIterQr()) {
            limits = Visit(node.getIterableQr()).split(";");
            s = limits[0];
            e = limits[1];
            r = "let ref " + iterator + " = "+s+"\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
            t += "iterator= \"" + iterator + "\";\n"
                + "starts = " + s + ";\n"
                + "ends = " + e + "\n";
            // for i in range(qr)
        }
        else if (node.getRange() && !node.getIterQr()) {
            s = "Num 0";
            e = Visit(node.getIterableExpr());
            r = "let ref " + iterator + " = 0\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
            t += "iterator= \"" + iterator + "\";\n"
                    + "starts = " + s + ";\n"
                    + "ends = " + e + "\n";
            // for i in range(expr)
        }
        else if(node.getIterQr()){
            limits = Visit(node.getIterableQr()).split(";");
            if (limits.length>1) {
                s = limits[0];
                e = limits[1];
            }
            else {
                s = "Num 0";
                e = "Var \"" + limits[0] + "\"";
            }
            r = "let ref " + iterator + " = 0\n" +
                    "in while (" + iterator + "<"
                    + e +") do\n";
            t += "iterator= \"" + iterator + "\";\n"
                    + "starts = " + s + ";\n"
                    + "ends = " + e + "\n";
        }
        else return "Can only iterate qreg or range operator\n";

        r +=    "variant{"+e+" - "+iterator+"}\n" +
                "invariant{"+s+" <= "+iterator+" <= "+e+"}\n"+
                "invariant{width !"+circs.peek()+" = n}\n";
        t += "};\n";
        return t;
    }

    @Override
    public String Visit(InvariantNode node) {
        StringBuilder r = new StringBuilder("inv = [");
        if (node!=null) {
            for (String c : node.get())
                r.append("\"").append(c).append("\"; ");
        }
        return r+"];\n";
    }

    @Override
    public String Visit(IfNode node) {
        String old, r,s;
        circs.push("c"+circs.size());
        s = printUnitaries(unitaries);
        String body;
        if(!node.getWithElse()) {
            s += "If {\ncond= " + Visit(node.getCond()) + ";\n";
            body = Visit(node.getIfBody());
            if (body.equals("body = [\n"))
                s += "body=[\n" + printUnitaries(unitaries) + "];\n" + Visit(node.getAssertion()) + "};\n";
            else s += body +"];\n" + Visit(node.getAssertion()) + "};\n";
            r = "let " + circs.peek() + " = ref (m_skip n)\nin " +
                    "if (" + Visit(node.getCond()) + ")\nthen begin\n" +
                    Visit(node.getAssertion()) + Visit(node.getIfBody()) + "end\n";
        }
        else {
            s += "IfElse {\ncond= " + Visit(node.getCond()) + ";\nif"
                    + Visit(node.getIfBody()) + printUnitaries(unitaries)
                    + "else" + Visit(node.getElseBody()) + printUnitaries(unitaries)
                    + Visit(node.getAssertion())
                    + "};\n";
            r = "let " + circs.peek() + " = ref (m_skip n)\nin " +
                    "if (" + Visit(node.getCond()) + ")\nthen begin\n" +
                    Visit(node.getAssertion()) + Visit(node.getIfBody()) + "end\n" + "else begin\n" +
                    Visit(node.getElseBody()) + "end\n";
        }
        old = circs.pop();
        r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        unitaries.clear();
        //asserts.clear();
        return s;
    }

    @Override
    public String Visit(IfCond node) {
        return Visit(node.getExpr());
    }

    @Override
    public String Visit(RetNode node) {
        String s = printUnitaries(unitaries);
        if(node.getArgBool())
            return s+"Return \""+ Visit(node.getArgs())+"\";\n";
        else return s+"Return \"\";\n";
    }

    @Override
    public String Visit(FunApply node) {
        StringBuilder args = new StringBuilder();
        String r,s;
        for(TermNode arg:node.getTermArgs()){
            args.append(Visit(arg)).append("; ");
        }
        if (!auxIds.contains(node.getFunID()))
            auxIds.add(0,node.getFunID());
        else {
            auxIds.remove(node.getFunID());
            auxIds.add(0, node.getFunID());
        }
        r = circs.peek()+":= !"+circs.peek()+" -- ("+node.getFunID()+" "+args+"n);\n"
                    + Visit(node.getAssertion());
        s = "FUN {id=\"" + node.getFunID() + "\"; args=["
            + args + "]}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RevApply node) {
        StringBuilder args = new StringBuilder();
        String r,s;
        for(TermNode arg:node.getTermArgs()){
            args.append(Visit(arg)).append("; ");
        }
        if (!auxIds.contains(node.getFunID()))
            auxIds.add(0,node.getFunID());
        else {
            auxIds.remove(node.getFunID());
            auxIds.add(0, node.getFunID());
        }
        r = circs.peek()+":= !"+circs.peek()+" -- ("+node.getFunID()+" "+args+"n);\n"
                + Visit(node.getAssertion());
        s = "REV {id=\"" + node.getFunID() + "\"; args=["
                + args + "]}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(HadApply node) {
        String r,s,old,start,end,qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        String[] limits;
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=H; qreg=\"" + id +
                "\"; range={starts=Num 0; ends=Len \""+id+"\"}; " +
                Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            limits = qr.split(";");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=H; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=H; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= !"+circs.peek()+" -- (place_hadamard ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RxApply node) {
        String r, s, old, start, end, qr= Visit(node.getQreg());
        String id = node.getQreg().getId();
        String[] limits;
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "
                    +Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            limits = qr.split(";");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= !"+circs.peek()+" -- (place (rx ("
                    + Visit(node.getAngle())+")) ("
                    + qr +") n);\n"
                    +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RyApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "
                    +Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String[] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= !"+circs.peek()+" -- (place (ry ("
                    + Visit(node.getAngle())+")) ("
                    + qr +") n);\n"
                    +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RzApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Rz ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "
                    +Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String[] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            s = "Apply {gate=Rz ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "
                    +Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Rz ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= seq_diag !"+circs.peek()+" (place (rz ("
                    + Visit(node.getAngle())+")) ("
                    + qr +") n);\n"
                    +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(XApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= !"+circs.peek()+" -- (place xx ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(YApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= !"+circs.peek()+" -- (place yy ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(ZApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= seq_diag !"+circs.peek()+" (place zz ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(SApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
            r = "let "+circs.peek()+" = ref (m_skip n)\nin "
                    + "let ref i = "+start+"\n"
                    + "in while (i < "+end+") do\n"
                    + "variant{"+end+" - i}\n"
                    + "invariant{"+start+" <= i <= " +end+"}\n"
                    + "invariant{range !"+circs.peek()+" = i}\n"
                    + "invariant{width !"+circs.peek()+" = "+end+" - "+start+"}\n"
                    + circs.peek()+":= seq_diag (!"+circs.peek()+" (place s i n));\n"
                    + "i := i + 1\ndone;\n"
                    + Visit(node.getAssertion());
            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        }
        else {
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= seq_diag !"+circs.peek()+" (place s ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(TApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= seq_diag !"+circs.peek()+" (place t ("
                    +qr+") n);\n" +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    public String Visit(SwapApply node) {
        String r,s, id1=node.getLQreg().getId(), id2=node.getRQreg().getId();
        diag = false;
        s = "MultiApply {gate=SWAP; qreg1=\""+ id1 +
                "\"; range1={starts="+
                Visit(node.getLQreg()) +
                "; ends=" + Visit(node.getLQreg())
                +"}; qreg2=\""+ id2 +
                "\"; range2={starts="+
                Visit(node.getRQreg()) +
                "; ends=" + Visit(node.getRQreg())
                +"}; qreg3=\"NONE\"; range3={starts=Num 0; ends=Num 0}; "+Visit(node.getAssertion())+"}";
        r = circs.peek()+":= !"+circs.peek()+" -- (swap ("
                + Visit(node.getLQreg())+") ("
                +Visit(node.getRQreg())+") n);\n"
                +Visit(node.getAssertion());
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(PhApply node) {
        String r, s, old, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Len \""+id+"\"}; "+Visit(node.getAssertion())+"}";
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
        else if (qr.contains(";")) {
            String[] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
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
        else {
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
            r = circs.peek()+":= seq_diag !"+circs.peek()+" (place (phase ("
                    + Visit(node.getAngle())+")) ("
                    + qr +") n);\n"
                    +Visit(node.getAssertion());
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(WithCtlNode node) {
        List<String> controls = new ArrayList<>();
        String[] limits, ls;
        String aux,angle,id = null,r,start,end,old,qr,target=null;
        StringBuilder s;
        ApplyNode gate = node.getCtlGate();
        s = new StringBuilder("WithControl{gate=");
        /*ls = Visit(node.getCtlGate()).split("Unitary ");
        s.append(ls[1]);*/
        Visit(node.getCtlGate());
        s.append(unitaries.get(unitaries.size()-1)); // get last unitary in list
        unitaries.remove(unitaries.size()-1); // delete it since its not needed anymore
        if (gate instanceof FunApply) // not defined
            aux = ((FunApply) gate).getFunID()+(((FunApply) gate).getTermArgs());
        else if (gate instanceof RevApply) // not defined
            aux = ((RevApply) gate).getFunID()+(((RevApply) gate).getTermArgs());
        else if (gate instanceof HadApply) {
            target = Visit(((HadApply) gate).getQreg());
            id = ((HadApply) gate).getQreg().getId();
            aux = " hadamard ";
            aux = " H; ";
            diag = true;
        }
        else if (gate instanceof RxApply) {
            target = Visit(((RxApply) gate).getQreg());
            angle = Visit(((RxApply) gate).getAngle());
            id = ((RxApply) gate).getQreg().getId();
            aux = " (rx ("+ angle +")) ";
            aux = " Rx ("+ angle +"); ";
            diag = false;
        }
        else if (gate instanceof RyApply) {
            target = Visit(((RyApply) gate).getQreg());
            angle = Visit(((RyApply) gate).getAngle());
            id = ((RyApply) gate).getQreg().getId();
            aux = " (ry ("+ angle +")) ";
            aux = " Ry ("+ angle +"); ";
            diag = false;
        }
        else if (gate instanceof RzApply){
            target = Visit(((RzApply) gate).getQreg());
            angle = Visit(((RzApply) gate).getAngle());
            id = ((RzApply) gate).getQreg().getId();
            aux = " (rz ("+ angle +")) ";
            aux = " Rz ("+ angle +"); ";
            diag = true;
        }
        else if (gate instanceof XApply){
            target = Visit(((XApply) gate).getQreg());
            id = ((XApply) gate).getQreg().getId();
            aux = " xx ";
            aux = " X; ";
            diag = false;
        }
        else if (gate instanceof YApply){
            target = Visit(((YApply) gate).getQreg());
            id = ((YApply) gate).getQreg().getId();
            aux = " yy ";
            aux = " Y; ";
            diag = false;
        }
        else if (gate instanceof ZApply){
            target = Visit(((ZApply) gate).getQreg());
            id = ((ZApply) gate).getQreg().getId();
            aux = " zz ";
            aux = " Z; ";
            diag = true;
        }
        else if (gate instanceof SwapApply){
            target = Visit(((SwapApply) gate).getLQreg());
            id = ((SwapApply) gate).getLQreg().getId();
            aux = " swap "; //not yet defined
            diag = false;
        }
        else{
            target = Visit(((PhApply) gate).getQreg());
            angle = Visit(((PhApply) gate).getAngle());
            id = ((PhApply) gate).getQreg().getId();
            aux = " (phase ("+ angle +")) ";
            aux = " Ph ("+ angle +"); ";
            diag = true;
        }
        s.append("; ctls=[");
        for (QregNode n:node.getCtlArgs()){
            controls.add(Visit(n));
            s.append("\"").append(n.getId()).append("\"; ");
        }
        if (controls.get(0).contains(";")) {
            // this means it's NOT a qreg[term] or qreg
            limits = controls.get(0).split(";");
            start = limits[0]; end = limits[1];
            s.append("]; range1={starts=").append(start).append("; ends=").append(end);
            s.append("}; tg=\"").append(id).append("\"; range2={starts=");
            s.append(target).append("; ends=").append(target).append("}; ").append(Visit(node.getAssertion())).append("}\n");
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
                /*
                invariant{ true }
                invariant{range !c2 = 0}
                let ref aux = (cont (rz (n-i-1)) (i+1) (q) n) in
                assert {forall x y i. 0<= i < width aux ->basis_ket aux x y i = x i};
                c2:= seq_diag !c2 aux;
                assert{true};
                i := i + 1
                done;
                 */

                r = "let "+circs.peek()+" = ref"+aux+"\nin "
                        + "let ref ctl = "+start+" \n"
                        + "in while (ctl < "+end+") do\n"
                        + "variant{"+end+" - ctl}\n"
                        + "invariant{"+start+" <= ctl <= "+end+"}\n"
                        + "invariant{range !" + circs.peek() + " = 0}\n"
                        + circs.peek()+":= cont_diag !"+circs.peek()
                        +" ctl ("+ target + ") n;\n"+Visit(node.getAssertion())
                        + "ctl := ctl + 1\ndone;\n"
                        + Visit(node.getAssertion());
            }

            old = circs.pop();
            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
        } else {
            qr = controls.get(0); // be careful here because a whole register can't be used as controls
            s.append("]; range1={starts=").append(qr).append("; ends=").append(qr);
            s.append("}; tg=\"").append(id).append("\"; range2={starts=");
            s.append(target).append("; ends=").append(target).append("}; ").append(Visit(node.getAssertion())).append("}");
            if (!diag) {
                r = circs.peek()+":= !"+circs.peek()+" -- (cont"+aux+"("+qr
                +") ("+ target + ") n);\n"+Visit(node.getAssertion());
            } else {
                r = circs.peek()+":= seq_diag !"+circs.peek()+" (cont_diag"+aux+"("+
                    qr+") ("+ target + ") n);\n"+Visit(node.getAssertion());
            }
        }
        unitaries.add(s.toString());
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(CnotNode node) {
        String s,ctl=node.getCtl().getId(),tg=node.getTarget().getId();
        s = "MultiApply {gate=Cnot; qreg1=\""+ ctl +
                "\"; range1={starts="+
                Visit(node.getCtl()) +
                "; ends=" + Visit(node.getCtl())
                +"}; qreg2=\""+ tg +
                "\"; range2={starts="+
                Visit(node.getTarget()) +
                "; ends=" + Visit(node.getTarget())
                +"}; qreg3=\"NONE\"; range3={starts=Num 0; ends=Num 0}; "+Visit(node.getAssertion())+"}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(ToffNode node) {
        String s, id1=node.getCtl1().getId(), id2=node.getCtl2().getId();
        String id3=node.getTarget().getId();
        s = "MultiApply {gate=Toff; qreg1=\""+ id1 +
                "\"; range1={starts="+
                Visit(node.getCtl1()) +
                "; ends=" + Visit(node.getCtl1())
                +"}; qreg2=\""+ id2 +
                "\"; range2={starts="+
                Visit(node.getCtl2()) +
                "; ends=" + Visit(node.getCtl2())
                +"}; qreg3=\"" + id3 +
                "\"; range3={starts=" +
                Visit(node.getTarget()) +
                "; ends=" + Visit(node.getTarget())+ "}; "+Visit(node.getAssertion())+"}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(FredNode node) {
        String s, id1=node.getCtl1().getId(), id2=node.getCtl2().getId();
        String id3=node.getTarget().getId();
        s = "MultiApply {gate=Fred; qreg1=\""+ id1 +
                "\"; range1={starts="+
                Visit(node.getCtl1()) +
                "; ends=" + Visit(node.getCtl1())
                +"}; qreg2=\""+ id2 +
                "\"; range2={starts="+
                Visit(node.getCtl2()) +
                "; ends=" + Visit(node.getCtl2())
                +"}; qreg3=\"" + id3 +
                "\"; range3={starts=" +
                Visit(node.getTarget()) +
                "; ends=" + Visit(node.getTarget())+ "}; "+Visit(node.getAssertion())+"}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
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
        String r, s, e, id=node.getIterator();
        TermNode start = node.getStart();
        TermNode end = node.getEnd();
        if (start==null){ // upTo
            s = "Num 0";
            e = Visit(end);
            if (e.equals("Minus (Num 1)")) {
                e = "Subtract (Len \""+id+"\", Num 2)";
            }
            r = s + ";" + e;
            //r = e;
        } else if (end==null) { //from
            s = Visit(start);
            e = "Var \"n\"";
            r = s + ";" + e;
        } else if (start.equals(end)){ //term
            s = Visit(start);
            if (s.equals("Minus (Num 1)")) {
                s = "Subtract (Len \""+id+"\", Num 1)";
            }
            r = s;
        } else { //interval
            s = Visit(start);
            e = Visit(end);
            if (e.equals("Minus (Num 1)")) {
                e = "Subtract (Len \""+id+"\", Num 1)";
            }
            r = s + ";" + e;
        }
        return r;
    }

    @Override
    public String Visit(EqualNode node) {
        return "Eq ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(GTNode node) {
        return "Gt ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(LTNode node) {
        return "Lt ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(GEQNode node) {
        return "GEq ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(LEQNode node) {
        return "LEq ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(NEqualNode node) {
        return "NEq ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(PowerNode node) {
        return "Power ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(MulNode node) {
        return "Times ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(DivNode node) {
        return "Divide ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(AddNode node) {
        return "Plus ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(SubNode node) {
        return "Subtract ("+Visit(node.getLeft()) + "," + Visit(node.getRight())+")";
    }

    @Override
    public String Visit(UnOpNode node) {
        String r;
        if (node.getOp().equals("sqrt"))
            r = "Sqrt " + "("+Visit(node.getInnerTerm())+")";
        else r = node.getOp() + "(" + Visit(node.getInnerTerm())+")";
        return r;
    }

    @Override
    public String Visit(LenNode node) {
        return "Subtract (Len \""+Visit(node.getQrTerm())+"\", Num 1)";
        //return  Visit(node.getQrTerm());
    }

    @Override
    public String Visit(ParenNode node) {
        return Visit(node.getTerm());
    }

    @Override
    public String Visit(AtomNode node) {
        return node.getValue();
    }

}
