import java.util.*;

public abstract class AST {}

class ProgramNode extends AST {
    private ImportsNode imports;
    private MainNode main;
    private List<AuxNode> auxList;

    public ImportsNode getImports() { return imports; }
    public void setImports(ImportsNode imports) { this.imports = imports; }

    public MainNode getMain() { return main; }
    public List<AuxNode> getAuxList() { return auxList; }

    public void setMain(MainNode main) { this.main = main; }
    public void setAuxList(List<AuxNode> auxList) { this.auxList = auxList; }
}

class ImportsNode extends ProgramNode {
    private List<String> files;
    public boolean hasImports;

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setHasImports(boolean hasImports) {
        this.hasImports = hasImports;
    }
}

class MainNode extends ProgramNode {
    private String id;
    private CircNode circ;
    private ParamsNode params;
    private PreNode pre;
    private PosNode pos;
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
}

class AuxNode extends ProgramNode {
    private String id;
    private CircNode circ;
    private ParamsNode params;
    private PreNode pre;
    private PosNode pos;
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

}

class PreNode extends MainNode {
    private List<String> conds;
    public List<String> get() { return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
}

class PosNode extends MainNode {
    private List<String> conds;
    public List<String> get() { return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
}

class ParamsNode extends MainNode {
    private List<SingleParam> params;
    public List<SingleParam> getPs() { return params; }
    public void setPs(List<SingleParam> params) {
        this.params = params;
    }
}

class SingleParam extends ParamsNode {
    private String type;
    private String id;
    public void setParam (String type, String id){
        this.type = type;
        this.id = id;
    }

    public String getId() { return id; }

    public String getType() {
        return type.substring(0,1).toUpperCase()+type.substring(1);
    }
}

class CircNode extends MainNode {
    private CircIds ids;
    private BodyNode body;

    public CircIds getIds() { return ids; }
    public BodyNode getBody() { return body; }

    public void setIds(CircIds ids) { this.ids = ids; }
    public void setBody(BodyNode body) { this.body = body; }
}

class CircIds extends CircNode {
    private List<QregNode> regs;
    public List<QregNode> getRegs (){ return regs; }
    public void setRegs(List<QregNode> newRegs) { this.regs = newRegs; }
}

class BodyNode extends CircNode {
    private List<InstrNode> bodyInstr;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public List<InstrNode> getBodyInstr() { return bodyInstr; }

    public void setBodyInstr(List<InstrNode> bodyInstr) {
        this.bodyInstr = bodyInstr;
    }

}

class AssertNode extends BodyNode {
    private List<String> assertions;
    public List<String> getAssertions() { return assertions; }

    public void setAssertions(List<String> assertions) {
        this.assertions = assertions;
    }
}

class InstrNode extends BodyNode { }

class ConjNode extends InstrNode {
    private BodyNode body;
    private ApplyNode apply;
    private AssertNode assertion;

    public BodyNode getBody() { return body; }
    public ApplyNode getApply() { return apply; }
    public AssertNode getAssertion() { return assertion; }

    public void setApply(ApplyNode apply) { this.apply = apply; }
    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public void setBody(BodyNode body) { this.body = body; }
}

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
    private TermNode iterableExpr;
    private QregNode iterableQr;
    private Boolean range;
    private Boolean iterQr;

    public String getIterator () { return iterator; }
    public Boolean getRange() { return range; }
    public TermNode getIterableExpr (){
        return iterableExpr;
    }
    public QregNode getIterableQr (){
        return iterableQr;
    }
    public Boolean getIterQr() { return iterQr; }
    public void setIterator (String niter) { this.iterator = niter; }
    public void setRange (Boolean cond) { this.range = cond; }
    public void setIterable(AST iterable){
        if (iterable instanceof TermNode) {
            this.iterableExpr = (TermNode) iterable;
            iterQr = false;
        } else {
            this.iterableQr = (QregNode) iterable;
            iterQr = true;
        }
    }
}

class InvariantNode extends ForNode {
    private List<String> conds;
    public List<String> get(){ return conds; }
    public void set(List<String> newConds){ this.conds = newConds; }
}

class IfNode extends InstrNode {
    private IfCond cond;
    private BodyNode ifBody;
    private BodyNode elseBody;
    private Boolean withElse;
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
}

////////////////// Gate-Apply Nodes //////////////////

class ApplyNode extends InstrNode {}

class FunApply extends ApplyNode {
    private String funID;
    private List<TermNode> termArgs;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public String getFunID () {
        return funID;
    }
    public List<TermNode> getTermArgs() {
        return termArgs;
    }
    public void setFunID (String id) {
        this.funID = id;
    }
    public void setTermArgs(List<TermNode> termArgs) {
        this.termArgs = termArgs;
    }
}

class RevApply extends ApplyNode {
    private String funID;
    private List<TermNode> termArgs;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }

    public String getFunID () {
        return funID;
    }

    public List<TermNode> getTermArgs() {
        return termArgs;
    }
    public void setFunID (String id) {
        this.funID = id;
    }
    public void setTermArgs(List<TermNode> termArgs) {
        this.termArgs = termArgs;
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
}

class TApply extends ApplyNode {
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
}

class SApply extends ApplyNode {
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
}

class CtlNode extends InstrNode {}

class WithCtlNode extends CtlNode {
    private List<QregNode> ctlArgs;
    private ApplyNode ctlGate;
    private CtlNode ctlMulti;
    private AssertNode assertion;
    private Boolean isMulti;

    public AssertNode getAssertion() { return assertion; }
    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public Boolean getIsMulti() { return isMulti; }
    public List<QregNode> getCtlArgs() {
        return ctlArgs;
    }
    public ApplyNode getCtlGate() {
        return ctlGate;
    }
    public CtlNode getCtlMulti() { return ctlMulti; }

    public void setCtlArgs(List<QregNode> ctlArgs) {
        this.ctlArgs = ctlArgs;
    }
    public void setCtlGate(ApplyNode ctlGate) {
        this.isMulti = false;
        this.ctlGate = ctlGate;
    }
    public void setCtlMulti(CtlNode ctlMulti) {
        this.isMulti = true;
        this.ctlMulti = ctlMulti;
    }
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
}

class ToffNode extends CtlNode {
    private QregNode ctl1;
    private QregNode ctl2;
    private QregNode target;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getCtl1 (){
        return ctl1;
    }
    public QregNode getCtl2 (){
        return ctl2;
    }
    public QregNode getTarget (){
        return target;
    }
    public void setQregs(QregNode ctl1, QregNode ctl2, QregNode ntarget) {
        this.ctl1 = ctl1;
        this.ctl2 = ctl2;
        this.target = ntarget;
    }
}

class FredNode extends CtlNode {
    private QregNode ctl1;
    private QregNode ctl2;
    private QregNode target;
    private AssertNode assertion;

    public AssertNode getAssertion() { return assertion; }

    public void setAssertion(AssertNode assertion) { this.assertion = assertion; }
    public QregNode getCtl1 (){
        return ctl1;
    }
    public QregNode getCtl2 (){
        return ctl2;
    }
    public QregNode getTarget (){
        return target;
    }
    public void setQregs(QregNode ctl1, QregNode ctl2, QregNode ntarget) {
        this.ctl1 = ctl1;
        this.ctl2 = ctl2;
        this.target = ntarget;
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

}

////////////////// Expression Nodes //////////////////

class ExpressionNode extends AST {}

class InfixExpressionNode extends ExpressionNode {
    private ExpressionNode Left;
    private ExpressionNode Right;
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

class InfixTermNode extends TermNode {
    private TermNode Left;
    private TermNode Right;
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
    private TermNode InnerTerm;
    private String op;
    public TermNode getInnerTerm () { return InnerTerm; }
    public String getOp () { return op; }
    public void setInnerTerm (TermNode Value) { this.InnerTerm = Value; }
    public void setOp(String op) { this.op = op; }
}

class LenNode extends TermNode {
    private QregNode QrTerm;
    public void setQrTerm(QregNode qrTerm) { this.QrTerm = qrTerm; }
    public QregNode getQrTerm() { return QrTerm; }
}

class ParenNode extends TermNode {
    private TermNode term;
    public TermNode getTerm() { return term; }
    public void setTerm(TermNode term) { this.term = term; }
}

class AtomNode extends TermNode {
    private String Value;
    private String Type;
    public String getType() { return Type; }
    public String getValue() { return Value; }
    public void setType(String Type) { this.Type = Type;}
    public void setValue(String value) { this.Value = value; }
}

class QregNode extends AST {
    private RangeNode range;
    private Boolean has_range;
    private String id;

    public RangeNode getRange() { return range; }
    public Boolean hasRange() { return has_range; }
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
    public void setHasRange(Boolean b) { this.has_range = b;}
    public void setRange(RangeNode range) { this.range = range; }
}

class RangeNode extends QregNode {
    private String iterator;
    private TermNode start;
    private TermNode end;

    public String getIterator() { return iterator; }

    public TermNode getStart() { return start; }

    public TermNode getEnd() { return end; }

    public void setIterator(String iterator) { this.iterator = iterator; }

    public void set (TermNode start, TermNode end) {
        this.start = start;
        this.end = end;
    }

}



