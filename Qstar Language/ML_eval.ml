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
    {id; size} -> "id: " ^ id ^ " | size: " ^ run_expr size

and run_cond = function
    | Eq (e, d) -> run_expr e ^ " = " ^ run_expr d
    | NEq (e, d) -> run_expr e ^ " <> " ^ run_expr d
    | GEq (e, d) -> run_expr e ^ " >= " ^ run_expr d
    | LEq (e, d) -> run_expr e ^ " <= " ^ run_expr d
    | Gt (e, d) -> run_expr e ^ " > " ^ run_expr d
    | Lt (e, d) -> run_expr e ^ " < " ^ run_expr d

let run_gate = function
    | H -> "_hadamard" | T -> " t" | S -> " s"
    | X -> " xx" | Y -> " yy" | Z -> " zz"
    | Rx (a) -> " (rx " ^ "(" ^ run_expr a ^ "))"
    | Ry (a) -> " (ry " ^ "(" ^ run_expr a ^ "))"
    | Rz (a) -> " (rz " ^ "(" ^ run_expr a ^ "))"
    | Ph (a) -> " (phase " ^ "(" ^ run_expr a ^ "))"

let run_multigate = function
    | Cnot -> "cnot " | Toff -> "toffoli "
    | Fred -> "fredkin " | SWAP -> "swap "

let run_range = function
    {starts; ends} ->
        if (starts=ends) then "[" ^ run_expr starts ^ "]"
        else "[" ^ run_expr starts ^ " to " ^ run_expr ends ^ "]"

let rec run_unitary = function
    | Sequence (e, d) ->  "(" ^ run_unitary e ^ ") -- (" ^ run_unitary d ^ ")"
    | Apply {gate; qreg; range} ->
        if (range.starts=range.ends) then
        "place" ^ run_gate gate ^ " (" ^ qreg ^ " " ^ run_expr (range.starts) ^ " n)"
        else "!circ_aux in let circ_aux = ref (m_skip n)\nin "
        ^ "for i=" ^ run_expr (range.starts) ^ " to " ^ run_expr (range.ends)
        ^ " do\n" ^ "circ_aux := !circ_aux -- " ^
        "place" ^ run_gate gate ^ " (" ^ qreg ^ " " ^ "i n)\ndone;"
    | MultiApply {gate; qreg1; range1; qreg2; range2; qreg3; range3} ->
        run_multigate gate ^ " (" ^ qreg1 ^ " " ^ run_range range1 ^ ")"^ " (" ^ qreg2 ^ " " ^ run_range range2 ^ ")"^ " (" ^ qreg3 ^ " " ^ run_range range3 ^ ")"
    | WithControl {gate; ctls; range1; tg; range2} ->
        "cont ((" ^ run_unitary gate ^ ") (" ^ (String.concat " " ctls) ^ " "
        ^ run_range range1 ^ ") " ^ tg ^ run_range range2 ^ ")"
    | FUN {id; args} ->
        id ^ " (" ^ String.concat " " (List.map run_expr args) ^ ")"
    | REV {id; args} ->
        "reverse (" ^ id ^ " (" ^ String.concat " " (List.map run_expr args) ^ ")"


(*for variable = start_value to end_value do
  expression
done*)

let run_iter = function
    {iterator; starts; ends} ->
        "for " ^ iterator ^ " = " ^ run_expr starts ^ " to " ^ run_expr ends ;;


let rec run_instr i n =
    match i with
    | For {iter; inv; body; assertion} ->
        "let c" ^ string_of_int (n+1) ^ " = ref (m_skip n) in\n" ^
        run_iter iter ^ " do\n" ^
        (aux body (n+1)) ^
        (String.concat "\n" assertion) ^ "\ndone;\n"
        ^ "c" ^ string_of_int n ^ " := !c" ^ string_of_int n
        ^ " -- !c" ^ string_of_int (n+1) ^ ";\n"
    | If {cond; body; assertion} ->
        "if (" ^ run_cond cond ^ ") then\n" ^
        (aux body (n+1)) ^
        (String.concat "\n"  assertion) ^ " \n"
    | IfElse {cond; ifbody; elsebody; assertion} ->
            "if (" ^ run_cond cond ^ ") then\n" ^
            (aux ifbody (n+1)) ^
            " else \n" ^ "\n" ^ (aux elsebody (n+2))
            ^ "\n" ^ (String.concat "\n"  assertion) ^ "\n"
    | Unitary (unit) ->
        "c" ^ string_of_int n ^ " := !c"
        ^ string_of_int n ^ " -- (" ^ run_unitary unit ^ ");\n"
    | Return (e) -> "return (!c0)\n"

and aux body n : string
    =
    match body with
    | [] -> ""
    | [i] -> run_instr i n
    | i :: tl -> run_instr i n ^ aux tl n ;;


let run_circ = function
    {qregs; body} ->
        " (" ^ (String.concat "" (List.map run_qreg qregs)) ^ "): circuit\n=\nbegin\n" ^
        "let c0 = ref (m_skip n) in\n" ^  aux body 0 ^ "end\n";;

(*     (String.concat "" (List.map run_qreg qregs)) ^ (String.concat "\n" (List.map run_instr body)) ;;*)

let run_fun = function
    {id; circ; params; pre; pos} ->
        "let " ^ id
        ^ run_circ circ
        ^ "assert" ^ (String.concat "" pre)
        ^ "\nassert" ^ (String.concat "" pos) ^ "\n\n";;
(*        id ^ ":\n" ^ run_circ circ ^ (String.concat "" pre) ^ "\n" ^ String.concat "" pos ^ "\n\n";;*)

let run_program {id; main; aux} =
     (String.concat "" (List.map run_fun aux)) ^ run_fun main ;;

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

