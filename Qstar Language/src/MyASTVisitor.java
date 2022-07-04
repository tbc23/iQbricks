public abstract class MyASTVisitor <T> {

    public abstract T Visit(ProgramNode node);
    public abstract T Visit(MainNode node);
    public abstract T Visit(AuxNode node);
    public abstract T Visit(ParamsNode node);
    public abstract T Visit(PreNode node);
    public abstract T Visit(PosNode node);
    public abstract T Visit(BodyNode node);
    public abstract T Visit(CircNode node);
    public abstract T Visit(CircIds node);
    public abstract T Visit(AssertNode node);

    public abstract T Visit(ForNode node);
    public abstract T Visit(ForIter node);
    public abstract T Visit(ConjNode node);
    public abstract T Visit(InvariantNode node);
    public abstract T Visit(IfNode node);
    public abstract T Visit(IfCond node);
    public abstract T Visit(RetNode node);

    public T Visit(InstrNode node) {
        if (node instanceof ForNode)
            return Visit((ForNode) node);
        else if (node instanceof IfNode)
            return Visit((IfNode) node);
        else if (node instanceof ApplyNode)
            return Visit((ApplyNode) node);
        else if (node instanceof CtlNode)
            return Visit((CtlNode) node);
        else if (node instanceof ConjNode)
            return Visit((ConjNode) node);
        else return Visit((RetNode) node);
    }

    public abstract T Visit(FunApply node);
    public abstract T Visit(RevApply node);
    public abstract T Visit(HadApply node);
    public abstract T Visit(RxApply node);
    public abstract T Visit(RyApply node);
    public abstract T Visit(RzApply node);
    public abstract T Visit(XApply node);
    public abstract T Visit(YApply node);
    public abstract T Visit(ZApply node);
    public abstract T Visit(SApply node);
    public abstract T Visit(TApply node);
    public abstract T Visit(SwapApply node);
    public abstract T Visit(PhApply node);

    public abstract T Visit(WithCtlNode node);
    public abstract T Visit(CnotNode node);
    public abstract T Visit(ToffNode node);
    public abstract T Visit(FredNode node);

    public T Visit(CtlNode node) {
        if (node instanceof WithCtlNode)
            return Visit((WithCtlNode) node);
        else if (node instanceof CnotNode)
            return Visit((CnotNode) node);
        else if (node instanceof ToffNode)
            return Visit((ToffNode) node);
        else return Visit((FredNode) node);
    }

    public T Visit(ApplyNode node) {
        if (node instanceof FunApply)
            return Visit((FunApply) node);
        else if (node instanceof RevApply)
            return Visit((RevApply) node);
        else if (node instanceof HadApply)
            return Visit((HadApply) node);
        else if (node instanceof RxApply)
            return Visit((RxApply) node);
        else if (node instanceof RyApply)
            return Visit((RyApply) node);
        else if (node instanceof RzApply)
            return Visit((RzApply) node);
        else if (node instanceof XApply)
            return Visit((XApply) node);
        else if (node instanceof YApply)
            return Visit((YApply) node);
        else if (node instanceof ZApply)
            return Visit((ZApply) node);
        else if (node instanceof SApply)
            return Visit((SApply) node);
        else if (node instanceof TApply)
            return Visit((TApply) node);
        else if (node instanceof SwapApply)
            return Visit((SwapApply) node);
        else
            return Visit((PhApply) node);

    }

    public abstract T Visit(QregNode node);
    public abstract T Visit(RangeNode node);

    public abstract T Visit(EqualNode node);
    public abstract T Visit(GTNode node);
    public abstract T Visit(LTNode node);
    public abstract T Visit(GEQNode node);
    public abstract T Visit(LEQNode node);
    public abstract T Visit(NEqualNode node);

    public abstract T Visit(PowerNode node);
    public abstract T Visit(MulNode node);
    public abstract T Visit(DivNode node);
    public abstract T Visit(AddNode node);
    public abstract T Visit(SubNode node);
    public abstract T Visit(UnOpNode node);
    public abstract T Visit(LenNode node);
    public abstract T Visit(ParenNode node);
    public abstract T Visit(AtomNode node);

    public T Visit(TermNode node) {
       if (node instanceof PowerNode) {
           return Visit((PowerNode) node);
       } else if (node instanceof MulNode) {
           return Visit((MulNode) node);
       } else if (node instanceof DivNode) {
           return Visit((DivNode) node);
       } else if (node instanceof AddNode) {
           return Visit((AddNode) node);
       } else if (node instanceof SubNode) {
           return Visit((SubNode) node);
       } else if (node instanceof UnOpNode) {
           return Visit((UnOpNode) node);
       } else if (node instanceof LenNode) {
           return Visit((LenNode) node);
       } else if (node instanceof ParenNode) {
           return Visit((ParenNode) node);
       } else {
           return Visit((AtomNode) node);
       }
    }
    public T Visit(ExpressionNode node) {
        if (node instanceof EqualNode) {
            return Visit((EqualNode) node);
        } else if (node instanceof GTNode) {
            return Visit((GTNode) node);
        } else if (node instanceof LTNode) {
            return Visit((LTNode) node);
        } else if (node instanceof GEQNode) {
            return Visit((GEQNode) node);
        } else if (node instanceof LEQNode) {
            return Visit((LEQNode) node);
        } else if (node instanceof NEqualNode) {
            return Visit((NEqualNode) node);
        } else {
            return Visit((TermNode) node);
        }
    }

}
