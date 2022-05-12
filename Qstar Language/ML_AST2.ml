type spec = {
     conds: string list
 }

type expr =
    | Plus of expr * expr        (* a + b *)
    | Subtract of expr * expr    (* a - b *)
    | Times of expr * expr       (* a * b *)
    | Divide of expr * expr      (* a / b *)
    | Power of expr * expr       (* a ^ b *)
    | Minus of expr
    | Len of string
    | Sqrt of expr
    | Num of int
    | Var of string              (* "x", "y", etc. *) ;;

type iter =
{
    iterator: string;
    starts: expr;
    ends: expr;
}

type qreg =
{
    id: string;
    size: expr;
}

type range =
{
    starts: expr;
    ends: expr;
}

type cond =
    | Eq of expr * expr         (* a == b *)
    | NEq of expr * expr        (* a != b *)
    | Gt of expr * expr         (* a > b *)
    | Lt of expr * expr         (* a < b *)
    | GEq of expr * expr        (* a >= b *)
    | LEq of expr * expr        (* a <= b *) ;;

type gate =
    | H | X | Y | Z | T | S
    | Rx of expr
    | Ry of expr
    | Rz of expr
    | Ph of expr ;;

type multigate =
    | Cnot | Toff | Fred | SWAP ;;

type unitary =
    | Sequence of unitary * unitary
    | Apply of {gate:gate; qreg:string; range:range}
    | MultiApply of {gate:multigate; qregs: string list}
    | WithControl of {gate:unitary; ctls: string list; range1:range; tg:string; range2:range}
    | FUN of {id:string; args: expr list}
    | REV of {id:string; args: expr list} ;;

type instruction =
    | For of {iter:iter; inv: string list; body:instruction list; assertion: string list}
    | If of {cond: cond; body:instruction list ; assertion: string list}
    | IfElse of {cond:cond; ifbody:instruction list; elsebody:instruction list; assertion:string list}
    | Unitary of unitary
    | Return of string ;;

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

