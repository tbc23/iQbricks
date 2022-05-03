type qreg =
{
    id: string;
(*    range: int;*)
}

type spec = {
     conds: string list
 }

type iter =
{
    iterator: string;
    starts: string;
    ends: string;
}

type range =
{
    starts: string;
    ends: string;
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

type cond =
    | Eq of expr * expr         (* a == b *)
    | NEq of expr * expr        (* a != b *)
    | Gt of expr * expr         (* a > b *)
    | Lt of expr * expr         (* a < b *)
    | GEq of expr * expr        (* a >= b *)
    | LEq of expr * expr        (* a <= b *) ;;

type gate =
    | H | X | Y | Z | T | S
    | Rx of string
    | Ry of string
    | Rz of string
    | Ph of string ;;

type multigate =
    | Cnot | Toff | Fred | SWAP ;;

type unitary =
    | Sequence of unitary * unitary
    | Apply of {gate:gate; qreg:string; range:range}
    | MultiApply of {gate:multigate; ctls: string list; tg:string}
    | WithControl of {gate:gate; ctls: string list; tg:string}
    | FUN of {id:string; args: string list}
    | REV of {id:string; args: string list} ;;

type instruction =
    | For of {iter:iter; inv: string list; body:instruction list; assertion: string list}
    | If of {cond: cond; body:instruction list ; assertion: string list}
    | IfElse of {cond:cond; ifbody:instruction list; elsebody:instruction list; assertion:string list}
    | Unitary of unitary
    | Return of string;;

type circ =
{
    qregs: string list;
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

