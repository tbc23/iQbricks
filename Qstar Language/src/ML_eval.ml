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
    | Len (e) -> e
    | Sqrt (e) -> "sqrt " ^ (run_expr e)
    | Num (e) -> string_of_int e
    | Var (e) -> e

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
    | Rx (a) -> "rx " ^ a | Ry (a) -> "ry " ^ a | Rz (a) -> "rz " ^ a
    | Ph (a) -> "phase " ^ a
    | Cnot -> "cnot" | Toff -> "toffoli" | Fred -> "fredkin"
    | SWAP -> "swap"

let rec run_unitary = function
    | Sequence (e, d) -> "seq " ^ run_unitary e ^ run_unitary d
    | Apply {gate; qregs} -> run_gate gate ^ " " ^ String.concat " " qregs
    | WithControl {gate; ctls; tg} ->
        "ctl (" ^ run_gate gate ^ ") " ^ (String.concat " " ctls) ^ " " ^ tg
    | FUN {id; args} -> id ^ " " ^ String.concat " " args
    | REV {id; args} -> "reverse" ^ id ^ " " ^ String.concat " " args


(*for variable = start_value to end_value do
  expression
done*)

let run_iter = function
    {iterator; starts; ends} ->
        "for " ^ iterator ^ " = " ^ starts ^ " to " ^ ends ;;


let rec run_instr = function
    | For {iter; inv; body; assertion} ->
        run_iter iter ^ " do " ^
        (String.concat "\n" (List.map run_instr body)) ^
        (String.concat "\n" assertion) ^ " done \n"
    | If {cond; body; assertion} ->
        "if (" ^ run_cond cond ^ ") then " ^
        (String.concat "\n" (List.map run_instr body)) ^
        (String.concat "\n"  assertion) ^ " done \n"
    | IfElse {cond; ifbody; elsebody; assertion} ->
            "if (" ^ run_cond cond ^ ") then " ^
            (String.concat "\n" (List.map run_instr ifbody)) ^
            " else \n" ^ (String.concat "\n" (List.map run_instr elsebody))
    | Unitary (unit) -> run_unitary unit
    | Return (e) -> "return\n" ;;

let run_circ = function (*dont forget to visit the qrs*)
    {qregs; body} -> (String.concat "\n" (List.map run_instr body)) ;;

let run_fun = function
    {id; circ; params; pre; pos} ->
        run_circ circ ^ (String.concat "\n" pre) ^ String.concat "\n" pos ;;

let run_program {id; main; aux} =
     run_fun main ^ (String.concat "\n" (List.map run_fun aux));;

let p = {
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

let run = run_program p ;;
print_endline run;;

