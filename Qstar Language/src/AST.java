import java.util.*;

public abstract class AST {}

class ProgramNode extends AST {
    public MainNode main;
    public List<AuxNode> auxList;

    public MainNode getMain() { return main; }
    public List<AuxNode> getAuxList() { return auxList; }

    public void setMain(MainNode main) { this.main = main; }
    public void setAuxList(List<AuxNode> auxList) { this.auxList = auxList; }
}

class MainNode extends ProgramNode {
    private String id;
    public CircNode circ;
    public ParamsNode params;
    public PreNode pre;
    public PosNode pos;
    public Boolean hasParams;

    public String getID() { return id; }
    public CircNode getCirc() { return circ; }
    public ParamsNode getParams() { return params; }
    public PosNode getPos() { return pos; }
    public PreNode getPre() { return pre; }
    public Boolean getHasParams() { return hasParams; }

    public void setID(String newID) { this.id = newID; }
    public void setCirc(CircNode circ) { this.circ = circ; }
    public void setParams(ParamsNode params) { this.params = params; }
    public void setPre(PreNode pre) { this.pre = pre; }
    public void setPos(PosNode pos) { this.pos = pos; }

    public void setHasParams(Boolean hasParams) { this.hasParams = hasParams; }

    public void printID(){
        System.out.println("Function name: "  + id);
    }
}

class AuxNode extends ProgramNode {
    private String id;
    public CircNode circ;
    public ParamsNode params;
    public PreNode pre;
    public PosNode pos;
    public Boolean hasParams;

    public String getID() { return id; }
    public CircNode getCirc() { return circ; }
    public ParamsNode getParams() { return params; }
    public PosNode getPos() { return pos; }
    public PreNode getPre() { return pre; }
    public Boolean getHasParams() { return hasParams; }

    public void setID(String newID) { this.id = newID; }
    public void setCirc(CircNode circ) { this.circ = circ; }
    public void setParams(ParamsNode params) { this.params = params; }
    public void setPre(PreNode pre) { this.pre = pre; }
    public void setPos(PosNode pos) { this.pos = pos; }

    public void setHasParams(Boolean hasParams) { this.hasParams = hasParams; }

    public void printID(){
        System.out.println("Function name: "  + id);
    }
}

class PreNode extends MainNode {
    private List<String> conds;
    public List<String> get() { return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
    public void printPre(){
        System.out.println("Pre-condition: "  + Arrays.toString(conds.toArray()));
    }
}

class PosNode extends MainNode {
    private List<String> conds;
    public List<String> get(){ return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
    public void printPos(){
        System.out.println("Post-condition: "  + Arrays.toString(conds.toArray()) + "\n");
    }
}

class ParamsNode extends MainNode {
    private HashMap<String,String> params;
    private List<String> ps;

    public List<String> getPs() { return ps; }

    public HashMap<String,String> get(){
        return params;
    }

    public void setPs(List<String> ps) { this.ps = ps; }

    public void set(HashMap<String,String> cparams){
        this.params = cparams;
    }
    public void printParams(int np) {
        if (params.size()==np) {
            System.out.print("Function parameters: ");
            for (String id : params.keySet()) {
                String type = params.get(id);
                System.out.print(type + " " + id + " | ");
            }
            System.out.print("\n");
        }
    }
}

class CircNode extends ProgramNode {
    private CircIds ids;
    private BodyNode body;
    private boolean circBody;

    public CircIds getIds() { return ids; }
    public BodyNode getBody() { return body; }
    public boolean isCircBody() { return circBody;}

    public void setIds(CircIds ids) { this.ids = ids; }
    public void setBody(BodyNode body) { this.body = body; }
    public void setCircBody(boolean circBody) { this.circBody = circBody; }
}

class CircIds extends CircNode {
    private List<QregNode> regs;
    public List<QregNode> getRegs (){ return regs; }
    public void setRegs(List<QregNode> newRegs) { this.regs = newRegs; }
    public void printRegs(){
        //System.out.println("Circuit registers: "  + Arrays.toString(regs.toArray()));
    }
}

// Onde encaixar os bodyNodes de cada instruction? Fazer cada um dos bodies individualmente?
// e.g. IfBody, ElseBody, ForBody, etc

class BodyNode extends CircNode {
    private String bodyID;
    private List<InstrNode> bodyInstr;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public String getID() { return bodyID; }

    public List<InstrNode> getBodyInstr() { return bodyInstr; }

    public void setID(String newID) { this.bodyID = newID; }

    public void setBodyInstr(List<InstrNode> bodyInstr) {
        this.bodyInstr = bodyInstr;
    }

    public void print() { System.out.println("circ's body:"); }
}

class AssertNode extends BodyNode {
    private List<String> assertions;
    public List<String> getAssertions() { return assertions; }

    public void setAssertions(List<String> assertions) {
        this.assertions = assertions;
    }
}

class InstrNode extends BodyNode { }

class ForNode extends InstrNode {
    private InvariantNode invariant;
    private ForIter iter;
    private BodyNode body;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public InvariantNode getInvariant() { return invariant; }
    public ForIter getIter() { return iter; }
    public BodyNode getBody() { return body; }

    public void setInvariant(InvariantNode invariant) { this.invariant = invariant; }
    public void setIter(ForIter iter) { this.iter = iter; }
    public void setBody(BodyNode body) { this.body = body; }
}

class ForIter extends ForNode {
    private String iterator;
    private ExpressionNode iterableExpr;
    private QregNode iterableQr;
    private Boolean range;
    private Boolean iterQr;

    public String getIterator () { return iterator; }
    public Boolean getRange() { return range; }
    public ExpressionNode getIterableExpr (){
        return iterableExpr;
    }
    public QregNode getIterableQr (){
        return iterableQr;
    }
    public Boolean getIterQr() { return iterQr; }
    public void setIterator (String niter) { this.iterator = niter; }
    public void setRange (Boolean cond) { this.range = cond; }
    public void setIterable(AST iterable){
        if (iterable instanceof ExpressionNode) {
            this.iterableExpr = (ExpressionNode) iterable;
            iterQr = false;
        } else {
            this.iterableQr = (QregNode) iterable;
            iterQr = true;
        }
    }

    public void printForIter () {
        //if (range) System.out.println("\tVariable "+iterator+" iterating in range "+iterable);
        //else System.out.println("\tVariable "+iterator+" iterating "+iterable);
    }
}

class InvariantNode extends ForNode {
    private List<String> conds;
    public List<String> get(){ return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
    public void printPos(){
        System.out.println("Invariant: "  + Arrays.toString(conds.toArray()) + "\n");
    }
}

class IfNode extends InstrNode {
    public IfCond cond;
    public BodyNode ifBody;
    public BodyNode elseBody;
    public Boolean withElse;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public IfCond getCond() { return cond; }
    public BodyNode getIfBody() { return ifBody; }
    public BodyNode getElseBody() { return elseBody; }
    public Boolean getWithElse() { return withElse; }

    public void setCond(IfCond cond) { this.cond = cond; }
    public void setIfBody(BodyNode body) { this.ifBody = body; }
    public void setElseBody(BodyNode elseBody) { this.elseBody = elseBody; }
    public void setWithElse(Boolean withElse) { this.withElse = withElse; }
}

class IfCond extends IfNode {
    private ExpressionNode cond;
    public ExpressionNode getExpr() {
        return cond;
    }
    public void setExpr (ExpressionNode ncond) {
        this.cond = ncond;
    }
    public void printCond () { System.out.println("\tIf condition: "+cond); }
}


class ApplyNode extends InstrNode {}

class FunApply extends ApplyNode {
    private String funID;
    private List<String> args;
    public List<TermNode> termArgs;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public String getFunID () {
        return funID;
    }
    public List<String> getArgs () {
        return args;
    }
    public List<TermNode> getTermArgs() {
        return termArgs;
    }
    public void setFunID (String id) {
        this.funID = id;
    }
    public void setArgs(List<String> args) {
        this.args = args;
    }
    public void setTermArgs(List<TermNode> termArgs) {
        this.termArgs = termArgs;
    }

    public void print(){
        System.out.println("Function apply: "+funID+Arrays.toString(args.toArray()));
    }
}

class RevApply extends ApplyNode {
    private String funID;
    private List<String> args;
    public List<TermNode> termArgs;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public String getFunID () {
        return funID;
    }
    public List<String> getArgs () {
        return args;
    }
    public List<TermNode> getTermArgs() {
        return termArgs;
    }
    public void setFunID (String id) {
        this.funID = id;
    }
    public void setArgs(List<String> args) {
        this.args = args;
    }
    public void setTermArgs(List<TermNode> termArgs) {
        this.termArgs = termArgs;
    }
    public void print(){
        System.out.println("Reverse function apply: "+funID+Arrays.toString(args.toArray()));
    }
}

class HadApply extends ApplyNode {
    private QregNode qreg;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void print() { System.out.println("Hadamard apply to: "+qreg); }
}

class RzApply extends ApplyNode {
    private QregNode qreg;
    private TermNode angle;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public TermNode getAngle (){
        return angle;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void setAngle (TermNode nangle) {
        this.angle = nangle;
    }
    public void print() { System.out.println("RZ apply to: "+qreg+" with angle "+angle); }
}

class RxApply extends ApplyNode {
    private QregNode qreg;
    private TermNode angle;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public TermNode getAngle (){
        return angle;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void setAngle (TermNode nangle) {
        this.angle = nangle;
    }
    public void print() { System.out.println("RX apply to: "+qreg+" with angle "+angle); }
}

class RyApply extends ApplyNode {
    private QregNode qreg;
    private TermNode angle;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public TermNode getAngle (){
        return angle;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void setAngle (TermNode nangle) {
        this.angle = nangle;
    }
    public void print() { System.out.println("RY apply to: "+qreg+" with angle "+angle); }
}

class XApply extends ApplyNode {
    private QregNode qreg;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void print() { System.out.println("X gate apply to: "+qreg); }
}

class YApply extends ApplyNode {
    private QregNode qreg;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void print() { System.out.println("Y gate apply to: "+qreg); }
}

class ZApply extends ApplyNode {
    private QregNode qreg;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void print() { System.out.println("Z gate apply to: "+qreg); }
}

class SwapApply extends ApplyNode {
    private QregNode qleft;
    private QregNode qright;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getLQreg (){
        return qleft;
    }
    public QregNode getRQreg (){
        return qright;
    }
    public void setQregs(QregNode lqreg, QregNode rqreg) {
        this.qleft = lqreg;
        this.qright = rqreg;
    }
    public void print() { System.out.println("SWAP gate apply to qregs: "+qleft+" and "+qright); }
}

class PhApply extends ApplyNode {
    private QregNode qreg;
    private TermNode angle;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getQreg (){
        return qreg;
    }
    public TermNode getAngle (){
        return angle;
    }
    public void setQreg(QregNode nqreg) {
        this.qreg = nqreg;
    }
    public void setAngle (TermNode nangle) {
        this.angle = nangle;
    }
    public void print() { System.out.println("Phase-gate apply to: "+qreg+" with angle "+angle); }
}

class CtlNode extends InstrNode {}

class WithCtlNode extends CtlNode {
    private List<QregNode> ctlArgs;
    public ApplyNode ctlGate;
    public AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public List<QregNode> getCtlArgs() {
        return ctlArgs;
    }

    public ApplyNode getCtlGate() {
        return ctlGate;
    }

    public void setCtlArgs(List<QregNode> ctlArgs) {
        this.ctlArgs = ctlArgs;
    }

    public void setCtlGate(ApplyNode ctlGate) {
        this.ctlGate = ctlGate;
    }

    public void print() { System.out.println("With-control gate with controls "+Arrays.toString(this.ctlArgs.toArray())+" and target "); }
}

class CnotNode extends CtlNode {
    private QregNode ctl;
    private QregNode target;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getCtl (){
        return ctl;
    }
    public QregNode getTarget (){
        return target;
    }
    public void setQregs(QregNode nctl, QregNode ntarget) {
        this.ctl = nctl;
        this.target = ntarget;
    }
    public void print () {
        System.out.println("CNOT gate with control "+ctl+" and target "+target);
    }
}

class RetNode extends InstrNode {
    private ExpressionNode args;
    private Boolean argBool;
    public ExpressionNode getArgs() {
        return args;
    }

    public Boolean getArgBool() { return argBool; }

    public void setArgs(ExpressionNode args) {
        this.args = args;
    }

    public void setArgBool(Boolean argBool) { this.argBool = argBool; }

    /*public void printRet() {
        if(!Objects.equals(args, "")) System.out.println("return " + args);
        else System.out.println("Empty return");
    }*/
}

////////////////// Expression Nodes //////////////////

class ExpressionNode extends AST {}

abstract class InfixExpressionNode extends ExpressionNode {
    public ExpressionNode Left;
    public ExpressionNode Right;
    public ExpressionNode getLeft () { return Left; }
    public ExpressionNode getRight () { return Right; }
    public void setLeft (ExpressionNode Left) { this.Left = Left; }
    public void setRight (ExpressionNode Right) { this.Right = Right; }
}

class EqualNode extends InfixExpressionNode {}

class GTNode extends InfixExpressionNode {}

class LTNode extends InfixExpressionNode {}

class GEQNode extends InfixExpressionNode {}

class LEQNode extends InfixExpressionNode {}

class NEqualNode extends InfixExpressionNode {}

class TermNode extends ExpressionNode {}

abstract class InfixTermNode extends TermNode {
    public TermNode Left;
    public TermNode Right;
    public TermNode getLeft () { return Left; }
    public TermNode getRight () { return Right; }
    public void setLeft (TermNode Left) { this.Left = Left; }
    public void setRight (TermNode Right) { this.Right = Right; }
}

class PowerNode extends InfixTermNode {}

class MulNode extends InfixTermNode {}

class DivNode extends InfixTermNode {}

class AddNode extends InfixTermNode {}

class SubNode extends InfixTermNode {}

class UnOpNode extends TermNode {
    public TermNode InnerTerm;

    public String op;
    public TermNode getInnerTerm () { return InnerTerm; }
    public String getOp () { return op; }
    public void setInnerTerm (TermNode Value) { this.InnerTerm = Value; }

    public void setOp(String op) { this.op = op; }
    public void print() { System.out.println(op + InnerTerm); }
}

class LenNode extends TermNode {
    public QregNode QrTerm;
    public void setQrTerm(QregNode qrTerm) { this.QrTerm = qrTerm; }

    public QregNode getQrTerm() { return QrTerm; }
}

class AtomNode extends TermNode {
    public String Value;
    public String getValue() { return Value; }
    public void setValue(String value) { Value = value; }
    public void print () { System.out.println(Value); }
}

class QregNode extends AST {
    public RangeNode range;
    public Boolean c;
    public String id;

    public RangeNode getRange() { return range; }
    public Boolean hasRange() { return c; }
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public void setHasRange(Boolean b) { this.c = b;}
    public void setRange(RangeNode range) { this.range = range; }
}

class RangeNode extends QregNode {
    public TermNode start;
    public TermNode end;

    public TermNode getStart() { return start; }

    public TermNode getEnd() { return end; }

    public void set (TermNode start, TermNode end) {
        this.start = start;
        this.end = end;
    }

}



