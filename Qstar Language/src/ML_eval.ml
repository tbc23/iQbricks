open ML_AST2

let rec power a = function
  | 0 -> 1
  | 1 -> a
  | n ->
    let b = power a (n / 2) in
    b * b * (if n mod 2 = 0 then 1 else a) ;;

let rec run_expr = function
    | Plus (e, d) -> run_expr e ^ " + " ^ run_expr d
    | Subtract (e, d) -> run_expr e ^ " - " ^ run_expr d
    | Times (e, d) -> run_expr e ^ " * " ^ run_expr d
    | Divide (e, d) -> run_expr e ^ " / " ^ run_expr d
    | Power (e, d) -> "power " ^ (run_expr e) ^ (run_expr d)
    | Minus (e) -> "-" ^ run_expr e
    | Len (e) -> "size(" ^ e ^ ")"
    | Sqrt (e) -> "sqrt (" ^ run_expr e ^ ")"
    | Num (e) -> string_of_int e
    | Var (e) -> e

let run_qreg = function
    {id; size} -> "id: " ^ id ^ " | size: " ^ run_expr size ^ "\n"

and run_cond = function
    | Eq (e, d) -> run_expr e ^ " = " ^ run_expr d
    | NEq (e, d) -> run_expr e ^ " <> " ^ run_expr d
    | GEq (e, d) -> run_expr e ^ " >= " ^ run_expr d
    | LEq (e, d) -> run_expr e ^ " <= " ^ run_expr d
    | Gt (e, d) -> run_expr e ^ " > " ^ run_expr d
    | Lt (e, d) -> run_expr e ^ " < " ^ run_expr d

let run_gate = function
    | H -> "hadamard" | T -> "t" | S -> "s"
    | X -> "xx" | Y -> "yy" | Z -> "zz"
    | Rx (a) -> "rx " ^ "(" ^ run_expr a ^ ")"
    | Ry (a) -> "ry " ^ "(" ^ run_expr a ^ ")"
    | Rz (a) -> "rz " ^ "(" ^ run_expr a ^ ")"
    | Ph (a) -> "phase " ^ "(" ^ run_expr a ^ ")"

let run_multigate = function
    | Cnot -> "cnot " | Toff -> "toffoli "
    | Fred -> "fredkin " | SWAP -> "swap "

let run_range = function
    {starts; ends} ->
        if (starts=ends) then "[" ^ run_expr starts ^ "]"
        else "[" ^ run_expr starts ^ " to " ^ run_expr ends ^ "]"

let rec run_unitary = function
(*    | Sequence (e, d) -> "seq " ^ run_unitary e ^ run_unitary d*)
    | Apply {gate; qreg; range} ->
        run_gate gate ^ " " ^ qreg ^ " " ^ run_range range
    | MultiApply {gate; qregs} ->
        run_multigate gate ^ (String.concat "" qregs)
    | WithControl {gate; ctls; range; tg} ->
        "ctl (" ^ run_gate gate ^ ") (" ^ (String.concat " " ctls) ^ " "
        ^ run_range range ^ ") " ^ run_expr tg
    | FUN {id; args} ->
        id ^ " " ^ String.concat " " (List.map run_expr args)
    | REV {id; args} ->
        "reverse" ^ id ^ " " ^ String.concat " " (List.map run_expr args)


(*for variable = start_value to end_value do
  expression
done*)

let run_iter = function
    {iterator; starts; ends} ->
        "for " ^ iterator ^ " = " ^ run_expr starts ^ " to " ^ run_expr ends ;;


let rec run_instr = function
    | For {iter; inv; body; assertion} ->
        run_iter iter ^ " do " ^
        (String.concat "\n" (List.map run_instr body)) ^
        (String.concat "\n" assertion) ^ " done \n"
    | If {cond; body; assertion} ->
        "if (" ^ run_cond cond ^ ") then " ^
        (String.concat "\n" (List.map run_instr body)) ^
        (String.concat "\n"  assertion) ^ " \n"
    | IfElse {cond; ifbody; elsebody; assertion} ->
            "if (" ^ run_cond cond ^ ") then " ^
            (String.concat "\n" (List.map run_instr ifbody)) ^
            " else \n" ^ (String.concat "\n" (List.map run_instr elsebody))
    | Unitary (unit) -> run_unitary unit
    | Return (e) -> "return\n" ;;

let run_circ = function (*dont forget to visit the qrs*)
    {qregs; body} ->
     (String.concat "" (List.map run_qreg qregs)) ^ (String.concat "\n" (List.map run_instr body)) ;;

let run_fun = function
    {id; circ; params; pre; pos} ->
        id ^ ":\n" ^ run_circ circ ^ (String.concat "" pre) ^ "\n" ^ String.concat "" pos ^ "\n\n";;

let run_program {id; main; aux} =
     run_fun main ^ (String.concat "" (List.map run_fun aux));;

(*let p = {
    id = "program";
    main = {
        id="main";
        circ= {
            qregs= [{id="qr"; size=Num 0}];
            body= [Unitary (Apply {gate=H; qreg="qr"; range={starts=Var "i"; ends=Var "i"}});
                    If {
                        cond= Gt (Var "a", Num 0);
                        body=[Unitary (Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Var "n"}})];
                        assertion=[]
                    };
                    For {
                        iter = {
                            iterator="i";
                            starts=Num 0;
                            ends=Var "n-1"
                        };
                        inv = [];
                        body= [
                            Unitary(WithControl{
                                gate= Rz (Num 1);
                                ctls= ["i"];
                                tg= "n-1"
                            })
                        ];
                        assertion=[]
                    };
                    Return "c"]
        };
        params = [{id="n"; type_=Int}; ];
        pre = ["precond"];
        pos = ["postcond"];
    };
    aux = []
};;*)

let p2 = {
    id = "program";
aux = [];
main = {
 id = "qft";
circ = {
qregs= [{id="qr"; size=Num 0}];
body = [
For {
iter = {
iterator= "q";
starts = Num 0;
ends = Len "qr"
};
inv = ["{ true }"; ];
body = [
Unitary (Apply {gate=H; qreg="qr"; range={starts=Var "q"; ends=Var "q"}});
For {
iter = {
iterator= "i";
starts = Var "q";
ends = Subtract (Len "qr", Num 1)
};
inv = ["{ true }"; ];
body = [
Unitary(WithControl{gate= Rz (Subtract (Subtract (Var "n",Var "i"),Num 1)); ctls=["qr"; ]; range={starts=Plus (Var "i",Num 1); ends=Plus (Var "i",Num 1)}; tg=Var "q"});
];
assertion=[]
};
];
assertion=["{true}"; ]
};
Return "";
];
};
params = [{id="qr";  type_=Qreg}; ];
pre = ["{true}"; ];
pos = ["{true}"; ];
}};;

let run = run_program p2 ;;
print_endline run;;

