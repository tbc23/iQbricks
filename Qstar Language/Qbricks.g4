grammar Qbricks;


@header{
        import java.util.*;
}

program :
        (imports)? main (aux)* // a program is defined by a main and (0 or more) aux functions
        ;

imports:
        (IMPORT file=ID)+
        ;

main    :
        BB idFun BB (params)? pre circ pos      #mainFun
        ;

aux     :
        SB idFun SB (params)? pre circ pos      #auxFun
        ;

params  :
        OP param (VG param)* CL     #funParams
        ;

param   :
        ptype=type id=ID             #singlePar
        ;

args    :
        term (VG term)*     #funArgs
        ;

type    :
        INT         #intType
        | FLOAT     #floatType
        | BOOL      #boolType
        | CIRC      #circType
        | QREG      #qrType
        ;

idFun   : 
        ID       #funId
        ;

circ    :
        CIRC id_list (ARROW circbody=body)?      #regCirc
        ;

id_list :
        qReg (VG qReg)*                 #qrList
        ;

qReg    :
        id=ID (ROP size=range RCL)?     #qr
        ;

body    :
        assert_ (instr)*                #regBody
        ;

pre     :
        PRE COP? FORMULA (VG FORMULA)* CCL?             #preSpec
        ;

pos     :
        POS COP? FORMULA (VG FORMULA)* CCL?             #posSpec
        ;

assert_ :                                               #emptyAssert
        | ASSERT COP? FORMULA (VG FORMULA)* CCL?        #assertSpec
        ;

invariant :
        INVARIANT COP? FORMULA (VG FORMULA)* CCL?       #invSpec
        ;

instr :
        (forinst=for_ | ifinst=if_ | applyinst=apply | ctlinst=control | conjinst=conjugated) assert_     #regInst
        | RET (expr)?                                                               #retInst
        ;

conjugated :
        WITHCJG OP? applyinst=apply CL? COP conjbody=body CCL
        ;

for_ : 
        FOR var=ID IN iteration=iter COP inv=invariant forbody=body CCL     #forLoop
        ;

iter    :
        RANGE OP (expvalue=expr | qrvalue=qReg) CL      #rangeIter
        | qReg                                          #qrIter
        ;

if_ :
        IF cond=expr
        COP ifbody=body CCL
        (ELSE COP elsebody=else_ CCL)?   #condIf
        ;

else_:
        body            #elsebody
        ;

apply   :
        fun=idFun OP (fargs=args)? CL                   #funApply
        | REVERSE OP fun=idFun OP (fargs=args)? CL CL   #revApply
        | HAD OP qr=qReg CL                             #hadApply
        | RZ OP angle=ang VG qr=qReg CL                 #rzApply
        | RX OP angle=ang VG qr=qReg CL                 #rxApply
        | RY OP angle=ang VG qr=qReg CL                 #ryApply
        | XGATE OP qr=qReg CL                           #xApply
        | YGATE OP qr=qReg CL                           #yApply
        | ZGATE OP qr=qReg CL                           #zApply
        | SWAP OP qrL=qReg VG qrR=qReg CL               #swapApply
        | PHASE OP angle=ang VG qr=qReg CL              #phApply
        | TGATE OP qr=qReg CL                           #tApply
        | SGATE OP qr=qReg CL                           #sApply
        ;

ang     :
        term        #angTerm
        ;


control : // add here a multiControl rule!!!!
        WITHCTL ctlqrs=id_list OP ctlgate=apply CL      #applyControl      // with control qreg[-1] (RX(ang,qreg[q]))
        | CNOT OP ctlqr=qReg VG tqr=qReg CL             #cnotControl       // cnot(target_qubit,control_qubit)
        | TOFF OP ctl1=qReg VG ctl2=qReg VG tg=qReg CL  #toffControl
        | FRED OP ctl1=qReg VG ctl2=qReg VG tg=qReg CL  #fredControl
        ;

expr   :
        term                                #termExpr
        | left=expr op=EQ right=expr        #eqExpr
        | left=expr op=GT right=expr        #gtExpr
        | left=expr op=LT right=expr        #ltExpr
        | left=expr op=GEQ right=expr       #geqExpr
        | left=expr op=LEQ right=expr       #leqExpr
        | left=expr op=NEQ right=expr       #neqExpr
        | OP expr CL                        #parenExpr
        ;

term :
        atom                                    #atomTerm
        | left=term op=POW right=term           #powTerm
        | left=term op=MUL right=term           #mulTerm
        | left=term op=DIV right=term           #divTerm
        | left=term op=PLUS right=term          #addTerm
        | left=term op=MINUS right=term         #subTerm
        | OP term CL                            #parenTerm
        | unOp                                  #unaryTerm
        ;

atom    :
        value = NUM     #numAtom
        | pi = PI         #piAtom
        | var = ID        #varAtom
        ;

unOp    :
        MINUS term                  #negUnary
        | LEN OP qReg CL            #lenUnary
        | SQRT OP value=term CL     #sqrtUnary
        ;

range   :
        term                                            #termRange
        | TP term                                       #uptoRange
        | term TP                                       #fromRange
        | start=term PT PT end=term                     #intervalRange
        ;


// Analisador Lexico
PT   : '.' ;
SB   : '|' ;
PTV  : ';' ;
TP   : ':' ;
VG   : ',' ;
OP   : '(' ;
CL   : ')' ;
ROP  : '[' ;
RCL  : ']' ;
COP  : '{' ;
CCL  : '}' ;
EQ   : '==';
NEQ  : '!=';
GEQ  : '>=';
LEQ  : '<=';
GT   : '>' ;
LT   : '<' ;
PLUS : '+' ;
MINUS: '-' ;
MUL  : '*' ;
DIV  : '/' ;
POW  : '^' ;
ARROW: '->';
BB   : '||';


HAD  : 'H' ;
RZ   : 'RZ';
RX   : 'RX';
RY   : 'RY';
XGATE: 'X' ;
YGATE: 'Y' ;
ZGATE: 'Z' ;
SGATE: 'S' ;
TGATE: 'T' ;
PI   : 'pi';
IN   : 'in';
IF   : 'if';
INT  : 'int';
DEF  : 'def';
LEN  : 'len';
FOR  : 'for';
ROT  : 'rot';
PHASE: 'ph' ;
PRE  : 'pre';
POS  : 'pos';
BOOL : 'bool';
QREG : 'qreg';
CNOT : 'cnot';
SWAP : 'swap';
TOFF : 'toff';
FRED : 'fred';
SQRT : 'sqrt';
ELSE : 'else';
CIRC : 'circ';
APPLY: 'apply';
FLOAT: 'float';

RANGE: 'range';
RET  : 'return';
ASSERT : 'assert';
CONTROL: 'control';
REVERSE: 'reverse';
WITHCTL: 'with control';
WITHCJG: 'with conjugated';

INVARIANT : 'invariant';
IMPORT : 'import';

ID : [a-zA-Z][a-zA-Z_0-9]* ;
NUM : [0-9]+ ;
FORMULA : COP ~[{}\n]+ CCL ;


COMM : '#' ~[\n]* -> skip ;
SPACE : ('\r'? '\n' | ' ' | '\t')+ -> skip ;
