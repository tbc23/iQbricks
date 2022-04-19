module AST

type program =
{
    id: string;
    main: fun_;
    aux: fun_ list;
}

type fun_ =
{
    id: string;
    circ: circ;
    params: param list;
    pre: spec;
    pos: spec;
}

type spec = {
    conds: string list;
}

type param =
{
    id: string;
    type_: | Qreg | Circ | Int | Bool;
}

type circ =
{
    qregs: qreg list;
    body: body;
}

type body =
{
    instructions: instruction list;
    assertion: spec;
}

type instruction =
    | For of (iter, inv: spec, body, assertion: spec)
    | If of (cond: expr, body , assertion: spec)
    | IfElse of (cond:expr, ifbody:body, elsebody:body, assertion:spec)
    | Apply of (gate, qreg list)
    | Control of (control, ctls:qreg list, tg:qreg)
    | Return of expr;;

type gate =
    | H | X | Y | Z | SWAP | FUN | REV | T | S |
    | Rx of ang: int
    | Ry of ang: int
    | Rz of ang: int
    | Ph of ang: int;;

type control =
    | Cnot | Toff | Fred
    | WithCtl of gate;;

type qreg =
{
    id: string;
    range: int;
}

type cond =
    | Eq of cond * cond         (* a == b *)
    | NEq of cond * cond        (* a != b *)
    | Gt of cond * cond         (* a > b *)
    | Lt of cond * cond         (* a < b *)
    | GEq of cond * cond        (* a >= b *)
    | LEq of cond * cond        (* a <= b *)
    | expr ;;

type expr =
    | Plus of expr * expr        (* a + b *)
    | Minus of expr * expr       (* a - b *)
    | Times of expr * expr       (* a * b *)
    | Divide of expr * expr      (* a / b *)
    | Power of expr * expr       (* a ^ b *)
    | UnOp of unop
    | Var of atom              (* "x", "y", etc. *);;

type atom =
    | Num of int
    | Var of string ;;

type unop =
    | Minus of expr
    | Len of qreg
    | Sqrt of expr ;;
