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
    | H | X | Y | Z | SWAP | T | S
    | Cnot | Toff | Fred
    | Rx of string
    | Ry of string
    | Rz of string
    | Ph of string ;;

type unitary =
    | Sequence of unitary * unitary
    | Apply of {gate:gate; qregs:string list}
    | WithControl of {gate:gate; ctls:string list; tg:string}
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

let p (program) = {
    id = "program";
    main = {
        id="main";
        circ= {
            qregs= ["qr"];
            body= [Unitary (Apply {gate=H; qregs=["qr"]});
                    If {
                        cond= Gt (Var "a", Num 0);
                        body=[Unitary (Apply {gate=H; qregs=["qr"]})];
                        assertion=[]
                    };
                    For {
                        iter = {
                            iterator="i";
                            starts="0";
                            ends="n-1"
                        };
                        inv = [];
                        body= [
                            Unitary(WithControl{
                                gate= Rz "1";
                                ctls= ["i"];
                                tg= "n-1"
                            })
                        ];
                        assertion=[]
                    };
                    Return "c"]
        };
        params = [];
        pre = ["precond"];
        pos = ["poscond"];
    };
    aux = []
};;

