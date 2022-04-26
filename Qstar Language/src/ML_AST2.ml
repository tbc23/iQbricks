type atom =
    | Num of int
    | Var of string ;;

type qreg =
{
    id: string;
    range: int;
}

type spec = {
     conds: string list
 }

type iter =
{
    iterator: string;
    starts: int;
    ends: int;
}

type expr =
    | Plus of expr * expr        (* a + b *)
    | Subtract of expr * expr    (* a - b *)
    | Times of expr * expr       (* a * b *)
    | Divide of expr * expr      (* a / b *)
    | Power of expr * expr       (* a ^ b *)
    | Minus of expr
    | Len of qreg
    | Sqrt of expr
    | Var of atom              (* "x", "y", etc. *) ;;

type cond =
    | Eq of cond * cond         (* a == b *)
    | NEq of cond * cond        (* a != b *)
    | Gt of cond * cond         (* a > b *)
    | Lt of cond * cond         (* a < b *)
    | GEq of cond * cond        (* a >= b *)
    | LEq of cond * cond        (* a <= b *)
    | Expr of expr ;;

type gate =
    | H | X | Y | Z | SWAP | FUN | REV | T | S
    | Cnot | Toff | Fred
    | Rx of {ang:int}
    | Ry of {ang:int}
    | Rz of {ang:int}
    | Ph of {ang:int} ;;

type unitary =
    | Sequence of unitary * unitary
    | Apply of {gate:gate; qregs:qreg list}
    | WithControl of {gate:gate; ctls:qreg list; tg:qreg}
    | FUN of {id:string; args: string list}
    | REV of {id:string; args: string list};;

type instruction =
    | For of {iter:iter; inv: string list; body:instruction list; assertion: string list}
    | If of {cond: cond; body:instruction list ; assertion: string list}
    | IfElse of {cond:cond; ifbody:instruction list; elsebody:instruction list; assertion:string list}
    | Unitary of unitary
    | Return of string;;

type circ =
{
    qregs: qreg list;
    body: instruction list
}

type type_ = | Qreg | Circ | Int | Bool ;;

type param =
{
    id: string;
    type_: type_
}

type fun_ =
{
    id: string;
    circ: circ;
    params: param list;
    pre: string list;
    pos: string list
}

type program =
{
     id: string;
     main: fun_;
     aux: fun_ list;
}

let p (program) = {
    id = "program";
    main = {
        id="main";
        circ= {
            qregs= [{id="qr"; range=5}];
            body= [Unitary (Apply {gate=H; qregs=[{id="qr"; range=5}]});
                    If {cond= Gt {Var "a"; Num 0}; body=[Unitary (Apply {gate=H; qregs=[{id="qr"; range=5}]})]; assertion=[]};
                    Return "c"]
        };
        params = [];
        pre = ["precond"];
        pos = ["poscond"];
    };
    aux = []
}
