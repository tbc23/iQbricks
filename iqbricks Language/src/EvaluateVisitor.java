import java.util.ArrayList;
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
                    id = \"""").append(node.getMain().getID()).append("\";\n");
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
            t.append("aux = [");

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
        // Check params for possible aux functions and remove them from undeclared functions
        if (node.getMain().getHasParams()) {
            for (SingleParam p : node.getMain().getParams().getPs()) {
                undeclared_funs.remove(p.getId());
            }
        }
        for (AuxNode n: node.getAuxList()){
            if (n.getHasParams()) {
                for (SingleParam p : n.getParams().getPs()) {
                    undeclared_funs.remove(p.getId());
                }
            }
        }
        // fill undeclared functions in ml ast
        t.append("imports = [");
        if(node.getImports().hasImports)
            t.append(Visit(node.getImports()));
        for (String s: undeclared_funs) {
            t.append("\"").append(s).append("\"; ");
        }
        t.append("];\n");

        // add main function
        t.append(main);
        t.append("""
            let () =
                   let run = run_program p in
                   let oc = open_out (p.id ^ ".mlw") in
                     Printf.fprintf oc "%s" run;
                     close_out oc;
                     print_endline "translation generated successfully";""");
        //return r+"end";
        return t.toString();
    }

    @Override
    public String Visit(ImportsNode node) {
        StringBuilder s = new StringBuilder();
        for (String i: node.getFiles()) {
            s.append("\"").append(i).append("\"; ");
        }
        return s.toString();
    }

    @Override
    public String Visit(MainNode node) {
        String r = "main = {\n id = \"" + node.getID() + "\";\n" +
                "circ = {\n" + Visit(node.getCirc()) + "}; \n"
                + "params = [";
        if (node.hasParams)
            r += Visit(node.getParams());
        r += "]; \n" + Visit(node.getPre()) + Visit(node.getPos()) +
                "}};;\n";

        return r;
    }

    @Override
    public String Visit(AuxNode node) {
        if (!auxIds.contains(node.getID())) auxIds.add(node.getID());
        String r = "{\nid = \"" + node.getID() + "\";\n" +
                "circ = {\n" + Visit(node.getCirc()) + "};\n"
                + "params = [";
        if (node.hasParams)
            r += Visit(node.getParams());
        r += "]; \n" + Visit(node.getPre()) + Visit(node.getPos()) +
                "}; \n";
        return r;
    }

    @Override
    public String Visit(ParamsNode node) {
        StringBuilder r = new StringBuilder();
        if (node.getPs()!=null) {
            for (SingleParam c : node.getPs()) {
                //r.append(c.getId()).append("; ");
                r.append("{id=\"").append(c.getId()).append("\"; ");
                r.append(" type_=").append(c.getType()).append("}; ");
            }
        }
        return r.toString();
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
        //System.out.println(printUnitaries(unitaries));
        if (r.toString().equals("body = [\n"))
            r.append(printUnitaries(unitaries)).append("];\n");
        else r.append("];\n");
        return r.toString();
    }

    @Override
    public String Visit(CircNode node) {
        String r;
        r = "qregs= ["+Visit(node.getIds())+"];\n"+
            Visit(node.getBody());//+"];\n";
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
    public String Visit(ConjNode node) {
        String body, s = printUnitaries(unitaries);
        s += "Conjugated {gate=";
        Visit(node.getApply());
        s += unitaries.get(unitaries.size()-1); // get last unitary in list
        unitaries.remove(unitaries.size()-1);
        s += ";\n ";
        body = Visit(node.getBody());
        s += body+ Visit(node.getAssertion()) + "};\n";
        unitaries.clear();
        return s;
    }

    @Override
    public String Visit(ForNode node) {
        String s,body;
        ForIter iter = node.getIter();
        circs.push("c"+circs.size());
        s = printUnitaries(unitaries);

        s += "For {\n" + Visit(iter)
            + Visit(node.getInvariant());
        body = Visit(node.getBody());
        if (diag) {
        }
        s += body + Visit(node.getAssertion()) + "};\n";
        unitaries.clear();
        //asserts.clear();
        return s;
    }

    @Override
    public String Visit(ForIter node) {
        String s,t,e,iterator=node.getIterator();
        String[] limits;
        t = "iter = {\n";
        if(node.getRange() && node.getIterQr()) {
            limits = Visit(node.getIterableQr()).split(";");
            s = limits[0];
            e = limits[1];
            t += "iterator= \"" + iterator + "\";\n"
                + "starts = " + s + ";\n"
                + "ends = " + e + "\n";
            // for i in range(qr)
        }
        else if (node.getRange() && !node.getIterQr()) {
            s = "Num 0";
            e = Visit(node.getIterableExpr());
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
                e = "Subtract(Var \"" + limits[0] + "\", Num 1)";
            }
            t += "iterator= \"" + iterator + "\";\n"
                    + "starts = " + s + ";\n"
                    + "ends = " + e + "\n";
        }
        else return "Can only iterate qreg or range operator\n";

        if (node.getIterQr())
            t += "};\nqr = \"" + node.getIterableQr().getId() + "\";\n";
        else t += "};\nqr = \" \";\n";
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
        String body, s;
        s = printUnitaries(unitaries);
        if(!node.getWithElse()) {
            s += "If {\ncond= " + Visit(node.getCond()) + ";\n";
            body = Visit(node.getIfBody());
            s += body + Visit(node.getAssertion()) + "};\n";
        }
        else {
            s += "IfElse {\ncond= " + Visit(node.getCond()) + ";\nif"
                    + Visit(node.getIfBody())
                    + "else" + Visit(node.getElseBody())
                    + Visit(node.getAssertion())
                    + "};\n";
        }
        unitaries.clear();
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
        String s;
        for(TermNode arg:node.getTermArgs()){
            args.append(Visit(arg)).append("; ");
        }
        if (!auxIds.contains(node.getFunID()))
            auxIds.add(0,node.getFunID());
        else {
            auxIds.remove(node.getFunID());
            auxIds.add(0, node.getFunID());
        }
        s = "FUN {id=\"" + node.getFunID() + "\"; args=["
            + args + "]}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RevApply node) {
        StringBuilder args = new StringBuilder();
        String s;
        for(TermNode arg:node.getTermArgs()){
            args.append(Visit(arg)).append("; ");
        }
        if (!auxIds.contains(node.getFunID()))
            auxIds.add(0,node.getFunID());
        else {
            auxIds.remove(node.getFunID());
            auxIds.add(0, node.getFunID());
        }
        s = "REV {id=\"" + node.getFunID() + "\"; args=["
                + args + "]}";
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(HadApply node) {
        String s,start,end,qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        String[] limits;
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=H; qreg=\"" + id +
                "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; " +
                Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            limits = qr.split(";");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=H; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=H; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RxApply node) {
        String s, start, end, qr= Visit(node.getQreg());
        String id = node.getQreg().getId();
        String[] limits;
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "
                    +Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            limits = qr.split(";");
            start = limits[0];
            end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=Rx ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RyApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "
                    +Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String[] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=Ry ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(RzApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Rz ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "
                    +Visit(node.getAssertion())+"}";
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
        }
        else {
            s = "Apply {gate=Rz ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(XApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=X; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(YApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = false;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=Y; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(ZApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=Z; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(SApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=S; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(TApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String [] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c"+circs.size());
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts="+start+
                    "; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=T; qreg=\"" + id +
                    "\"; range={starts="+qr+
                    "; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    public String Visit(SwapApply node) {
        String s, id1, id2, lqr, rqr;
        id1 = node.getLQreg().getId();
        id2 = node.getRQreg().getId();
        lqr = Visit(node.getLQreg());
        rqr = Visit(node.getRQreg());
        if (!(lqr.contains(";") || rqr.contains(";") || global_qrs.contains(lqr) || global_qrs.contains(rqr) )) {
            s = "MultiApply {gate=SWAP; " +
                    "regs=[{iterator=\"" + id1 +
                    "\"; starts=" + lqr +
                    "; ends=" + lqr
                    + "}; " + "{iterator=\"" + id2 +
                    "\"; starts=" + rqr +
                    "; ends=" + rqr
                    + "}]; " + Visit(node.getAssertion())+"}";
        }
        else return "Can only apply SWAP gate to two specific indexes\n";
        unitaries.add(s);
        return "";
    }

    @Override
    public String Visit(PhApply node) {
        String s, qr = Visit(node.getQreg());
        String id = node.getQreg().getId();
        diag = true;
        if (global_qrs.contains(qr)) {
            circs.push("c"+circs.size());
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id
                    + "\"; range={starts=Num 0; ends=Subtract(Len \""+id+"\", Num 1)}; "+Visit(node.getAssertion())+"}";
        }
        else if (qr.contains(";")) {
            String[] limits = qr.split(";");
            String start = limits[0];
            String end = limits[1];
            circs.push("c" + circs.size());
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    start+"; ends="+end+"}; "+Visit(node.getAssertion())+"}";
        }
        else {
            s = "Apply {gate=Ph ("+Visit(node.getAngle())
                    +"); qreg=\"" + id + "\"; range={starts="+
                    qr+"; ends="+qr+"}; "+Visit(node.getAssertion())+"}";
        }
        unitaries.add(s);
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(WithCtlNode node) {
        String[] limits;
        String id=null,start,end,range,target,target1,target2;
        StringBuilder s = new StringBuilder("WithControl{ctlgate=");
        if (node.getIsMulti()){
            Visit(node.getCtlMulti());
            s.append(unitaries.get(unitaries.size() - 1)); // get last unitary in list
            unitaries.remove(unitaries.size() - 1);
            id = "tg";
            target = "Num 0";
        }
        else {
            ApplyNode gate = node.getCtlGate();
            Visit(gate);
            s.append(unitaries.get(unitaries.size() - 1)); // get last unitary in list
            unitaries.remove(unitaries.size() - 1); // delete it since its not needed anymore
            if (gate instanceof FunApply) {
                target = "Var \"null\"";
            } else if (gate instanceof RevApply) {
                target = "Var \"null\"";
            } else if (gate instanceof HadApply) {
                target = Visit(((HadApply) gate).getQreg());
                id = ((HadApply) gate).getQreg().getId();
                diag = true;
            } else if (gate instanceof RxApply) {
                target = Visit(((RxApply) gate).getQreg());
                id = ((RxApply) gate).getQreg().getId();
                diag = false;
            } else if (gate instanceof RyApply) {
                target = Visit(((RyApply) gate).getQreg());
                id = ((RyApply) gate).getQreg().getId();
                diag = false;
            } else if (gate instanceof RzApply) {
                target = Visit(((RzApply) gate).getQreg());
                id = ((RzApply) gate).getQreg().getId();
                diag = true;
            } else if (gate instanceof XApply) {
                target = Visit(((XApply) gate).getQreg());
                id = ((XApply) gate).getQreg().getId();
                diag = false;
            } else if (gate instanceof YApply) {
                target = Visit(((YApply) gate).getQreg());
                id = ((YApply) gate).getQreg().getId();
                diag = false;
            } else if (gate instanceof ZApply) {
                target = Visit(((ZApply) gate).getQreg());
                id = ((ZApply) gate).getQreg().getId();
                diag = true;
            } else if (gate instanceof SwapApply) {
                target = Visit(((SwapApply) gate).getLQreg());
                id = ((SwapApply) gate).getLQreg().getId();
                diag = false;
            } else {
                target = Visit(((PhApply) gate).getQreg());
                id = ((PhApply) gate).getQreg().getId();
                diag = true;
            }
        }
        s.append("; ctls=[");
        for (QregNode n:node.getCtlArgs()){
            s.append("{iterator=\"").append(n.getId()).append("\"; ");
            range = Visit(n);
            if (range.contains(";")) {
                limits = range.split(";");
                start = limits[0]; end = limits[1];
            }
            else {
                start = range;
                end = range;
            }
            s.append("starts=").append(start);
            s.append("; ends=").append(end).append("}; ");
        }
        s.append("]; tg={iterator=\"").append(id).append("\"; ");
        if (global_qrs.contains(target)) {
            target1 = "Num 0";
            target2 = "Subtract(Len \""+id+"\", Num 1)";
        }
        else if (target.contains(";")) {
            limits = target.split(";");
            target1 = limits[0];
            target2 = limits[1];
        }
        else {
            target1 = target;
            target2 = target;
        }
        s.append("starts=").append(target1).append("; ends=").append(target2).append("}; ");
        s.append(Visit(node.getAssertion())).append("}\n");
//        if (controls.get(0).contains(";")) {
//            // this means it's NOT a qreg[term] or qreg
//            limits = controls.get(0).split(";");
//            start = limits[0]; end = limits[1];
//
//            s.append("]; range1={starts=").append(start).append("; ends=").append(end);
//            s.append("}; tg=\"").append(id).append("\"; range2={starts=");
//            s.append(target).append("; ends=").append(target).append("}; ").append(Visit(node.getAssertion())).append("}\n");
//            circs.push("c"+circs.size());
//            if (!diag) {
//            r = "let "+circs.peek()+" = ref"+aux+"\nin "
//                    + "let ref ctl = "+start+" \n"
//                    + "in while (ctl < "+end+") do\n"
//                    + "variant{"+end+" - ctl}\n"
//                    + "invariant{"+start+" <= ctl <= "+end+"}\n"
//                    + circs.peek()+":= cont !"+circs.peek()
//                    +" ctl ("+ target + ") n;\n"+Visit(node.getAssertion())
//                    + "ctl := ctl + 1\ndone;\n"
//                    + Visit(node.getAssertion());
//            } else {
//                /*
//                invariant{ true }
//                invariant{range !c2 = 0}
//                let ref aux = (cont (rz (n-i-1)) (i+1) (q) n) in
//                assert {forall x y i. 0<= i < width aux ->basis_ket aux x y i = x i};
//                c2:= seq_diag !c2 aux;
//                assert{true};
//                i := i + 1
//                done;
//                 */
//
//                r = "let "+circs.peek()+" = ref"+aux+"\nin "
//                        + "let ref ctl = "+start+" \n"
//                        + "in while (ctl < "+end+") do\n"
//                        + "variant{"+end+" - ctl}\n"
//                        + "invariant{"+start+" <= ctl <= "+end+"}\n"
//                        + "invariant{range !" + circs.peek() + " = 0}\n"
//                        + circs.peek()+":= cont_diag !"+circs.peek()
//                        +" ctl ("+ target + ") n;\n"+Visit(node.getAssertion())
//                        + "ctl := ctl + 1\ndone;\n"
//                        + Visit(node.getAssertion());
//            }
//
//            old = circs.pop();
//            r += circs.peek()+":= !"+circs.peek()+" -- !"+old+";\n";
//        } else {
//            qr = controls.get(0); // be careful here because a whole register can't be used as controls
////            s.append("]; range1={starts=").append(qr).append("; ends=").append(qr);
////            s.append("}; tg=\"").append(id).append("\"; range2={starts=");
////            s.append(target).append("; ends=").append(target).append("}; ").append(Visit(node.getAssertion())).append("}");
////            if (!diag) {
////                r = circs.peek()+":= !"+circs.peek()+" -- (cont"+aux+"("+qr
////                +") ("+ target + ") n);\n"+Visit(node.getAssertion());
////            } else {
////                r = circs.peek()+":= seq_diag !"+circs.peek()+" (cont_diag"+aux+"("+
////                    qr+") ("+ target + ") n);\n"+Visit(node.getAssertion());
////            }
//        }
        unitaries.add(s.toString());
        //asserts.add(node.getAssertion().getAssertions());
        return "";
    }

    @Override
    public String Visit(CnotNode node) {
        String s,ctl=node.getCtl().getId(),tg=node.getTarget().getId();
        String ctlqr = Visit(node.getCtl()), tgqr = Visit(node.getTarget());
        if (!(ctlqr.contains(";") || tgqr.contains(";") || global_qrs.contains(ctlqr) || global_qrs.contains(tgqr) )) {
            s = "MultiApply {gate=Cnot; regs=[{iterator=\""
                    + ctl + "\"; starts="+ ctlqr + "; ends=" + ctlqr
                    +"}; {iterator=\""+
                    tg + "\"; starts=" + tgqr + "; ends=" + tgqr
                    +"}]; " + Visit(node.getAssertion())+"}";
        }
        else return "Can only apply CNOT gate to two specific indexes\n";
        unitaries.add(s);
        return "";
    }

    @Override
    public String Visit(ToffNode node) {
        String s, id1=node.getCtl1().getId(), id2=node.getCtl2().getId();
        String id3=node.getTarget().getId();
        String ctlqr1 = Visit(node.getCtl1()), ctlqr2 = Visit(node.getCtl2()), tgqr = Visit(node.getTarget());
        if (!(ctlqr1.contains(";") || ctlqr2.contains(";") || tgqr.contains(";") || global_qrs.contains(ctlqr1) || global_qrs.contains(ctlqr2) || global_qrs.contains(tgqr) )) {
            s = "MultiApply {gate=Toff; " + "regs=[{iterator=\""
                    + id1 + "\"; starts=" + ctlqr1 + "; ends=" + ctlqr1
                    +"}; " + "{iterator=\""
                    + id2 + "\"; starts="+ ctlqr2 + "; ends=" + ctlqr2
                    +"}; " + "{iterator=\""
                    + id3 + "\"; starts="+ tgqr + "; ends=" + tgqr
                    +"}]; "
                    +Visit(node.getAssertion())+"}";
        }
        else return "Can only apply Toffoli gate to three specific indexes\n";
        unitaries.add(s);
        return "";
    }

    @Override
    public String Visit(FredNode node) {
        String s, id1=node.getCtl1().getId(), id2=node.getCtl2().getId();
        String id3=node.getTarget().getId();
        String ctlqr1 = Visit(node.getCtl1()), ctlqr2 = Visit(node.getCtl2()), tgqr = Visit(node.getTarget());
        if (!(ctlqr1.contains(";") || ctlqr2.contains(";") || tgqr.contains(";") || global_qrs.contains(ctlqr1) || global_qrs.contains(ctlqr2) || global_qrs.contains(tgqr) )) {
            s = "MultiApply {gate=Fred; " + "regs=[{iterator=\""
                    + id1 + "\"; starts=" + ctlqr1 + "; ends=" + ctlqr1
                    +"}; " + "{iterator=\""
                    + id2 + "\"; starts="+ ctlqr2 + "; ends=" + ctlqr2
                    +"}; " + "{iterator=\""
                    + id3 + "\"; starts="+ tgqr + "; ends=" + tgqr
                    +"}]; "
                    +Visit(node.getAssertion())+"}";
        }
        else return "Can only apply Fredkin gate to three specific indexes\n";
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
            else e = "Subtract ("+e+", Num 1)";
            r = s + ";" + e;
            //r = e;
        } else if (end==null) { //from
            s = Visit(start);
            e = "Subtract (Len \""+id+"\", Num 1)";
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
                e = "Subtract (Len \""+id+"\", Num 2)";
            }
            else e = "Subtract ("+e+", Num 1)";
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
