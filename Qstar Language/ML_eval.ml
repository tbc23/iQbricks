open ML_AST2

let rec power a = function
  | 0 -> 1
  | 1 -> a
  | n ->
    let b = power a (n / 2) in
    b * b * (if n mod 2 = 0 then 1 else a) ;;

let replace_circ s n =
    Str.global_replace (Str.regexp "circ") ("!c" ^ string_of_int n) s ;;

let rec run_assert a n =
    match a with
    | [] -> ""
    | [i] -> "assert" ^ (replace_circ i n) ^ ";\n"
    | h :: tl -> "assert" ^ (replace_circ h n) ^ ";\n" ^ run_assert tl n

let rec run_inv a n =
    match a with
    | [] -> ""
    | [i] -> "invariant" ^ (replace_circ i n) ^ "\n"
    | h :: tl -> "invariant" ^ (replace_circ h n) ^ "\n" ^ run_inv tl n

let rec run_requires = function
    | [] -> ""
    | [i] -> "requires" ^ i ^ "\n"
    | h :: tl -> "requires" ^ h ^ "\n" ^ run_requires tl

let rec run_ensures = function
    | [] -> ""
    | [i] -> "ensures" ^ i ^ "\n"
    | h :: tl -> "ensures" ^ h ^ "\n" ^ run_ensures tl



let rec run_expr = function
    | Plus (e, d) -> run_expr e ^ " + " ^ run_expr d
    | Subtract (e, d) -> run_expr e ^ " - " ^ run_expr d
    | Times (e, d) -> run_expr e ^ " * " ^ run_expr d
    | Divide (e, d) -> run_expr e ^ " / " ^ run_expr d
    | Power (e, d) -> "power " ^ (run_expr e) ^ (run_expr d)
    | Minus (e) -> "-" ^ run_expr e
(*    | Len (e) -> "size(" ^ e ^ ")"*)
    | Len (e) -> e (*^ "-1"*)
    | Sqrt (e) -> "sqrt (" ^ run_expr e ^ ")"
    | Num (e) -> string_of_int e
    | Var (e) -> e

let rec run_args = function
    | [] -> ""
    | [i] -> run_expr i ^ " n"
    | h :: tl -> (run_expr h) ^ " " ^ run_args tl

let run_qreg = function
    {qrid; size} ->
        if ((run_expr size)="0") then ""(*qrid ^ " = n"*)
        else "requires{"^ qrid ^ " = " ^ run_expr size ^ "}\n" ;;

let run_cond = function
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

let rec run_unitary_inv unit n =
    match unit with
    | Sequence (e, d) ->  (run_unitary_inv e n) ^ (run_unitary_inv d n)
    | Apply {gate; qreg; range; assertion} ->
        if (range.starts=range.ends) then
            "c" ^ string_of_int n ^ " := "
            ^ "(place" ^ run_gate gate
            ^ " (" ^ run_expr (range.starts) ^ ") n)"
            ^ " -- !c" ^ string_of_int n ^ ";\n"
            ^ run_assert assertion n
        else "let circ_aux = ref (m_skip n) in\n"
            ^ "for i=" ^ run_expr (range.starts) ^ " to (" ^ run_expr (range.ends)
            ^ ") do\n" ^ "invariant{width !c" ^ (string_of_int n) ^ "=n}\n"
            ^ "circ_aux := !circ_aux -- (place" ^ run_gate gate
            ^ " i n);\ndone;\n" ^ "c" ^ string_of_int n
            ^ " := !circ_aux -- !c" ^ string_of_int n ^ ";\n"
            ^ run_assert assertion n
    | MultiApply {gate; qreg1; range1; qreg2; range2; qreg3; range3; assertion} ->
        "c" ^ string_of_int n ^ " := ("
        ^ run_multigate gate ^ " (" ^ qreg1 ^ " " ^ run_range range1 ^ ")"
         ^ " (" ^ qreg2 ^ " " ^ run_range range2 ^ ")"
         ^ " (" ^ qreg3 ^ " " ^ run_range range3 ^ ")" ^
          ") -- !c" ^ string_of_int n ^ ";\n" ^ run_assert assertion n

    | WithControl {gate; ctls; range1; tg; range2; assertion} ->
        begin match gate with
        | Apply {gate; qreg; range; assertion} ->
            begin match gate with
                | Rz (a) ->
                    if (range.starts=range.ends) then
                        "c" ^ string_of_int n ^ " := "
                        ^ "(crz (" ^ run_expr range1.starts
                        ^ ") (" ^ run_expr range2.starts ^ ") (" ^ run_expr a ^ ") n) -- !c"
                        ^ string_of_int n ^";\n"
                    else(*not done*)
                        "let circ_aux = ref (m_skip n)\nin "
                        ^ "for ctl=" ^ run_expr (range.starts) ^ " to " ^ run_expr (range.ends)
                        ^ " do\n" ^ "circ_aux := !circ_aux -- " ^
                        "cont " ^ run_gate gate
                        ^ " ctl " ^ run_expr range2.starts ^ " n;\ndone;"
                | _ ->
                    if (range.starts=range.ends) then(*not done*)
                        "c" ^ string_of_int n ^ " := !c"
                        ^ string_of_int n ^ " -- ("
                        ^ "cont ((" ^ run_gate gate ^ " (" ^ run_expr (range.starts) ^ ") n)"
                        ^ " (" ^ run_expr range1.starts ^ ") (" ^ run_expr range2.starts ^ "))"
                        ^ ");\n"
                    else(*not done*)
                        "let circ_aux = ref (m_skip n)\nin "
                        ^ "for ctl=" ^ run_expr (range.starts) ^ " to " ^ run_expr (range.ends)
                        ^ " do\n" ^ "circ_aux := !circ_aux -- " ^
                        "cont ((" ^ run_gate gate ^ " (" ^ run_expr (range.starts) ^ ") n)"
                        ^ " ctl " ^ run_expr range2.starts ^ ")\ndone;"
            end
        | MultiApply {gate; qreg1; range1; qreg2; range2; qreg3; range3; assertion} ->
            ""
        | FUN {id; args} ->  ""
        | REV {id; args} -> ""
        | _ -> "\nError\n"
        end ^ run_assert assertion n
    | FUN {id; args} ->
        "c" ^ string_of_int n ^ " :="
        ^ "(" ^ id ^  " " ^ (run_args args) ^ ") -- !c"
        ^ string_of_int n ^ ";\n"
    | REV {id; args} ->
        "c" ^ string_of_int n ^ " :="
                ^ "(reverse (" ^ id ^ " " ^ (run_args args) ^ ")) -- !c"
                ^ string_of_int n ^ ";\n"

let rec run_unitary unit n =
    match unit with
    | Sequence (e, d) ->  (run_unitary d n) ^ (run_unitary e n)
    | Apply {gate; qreg; range; assertion} ->
        if (range.starts=range.ends) then
            "c" ^ string_of_int n ^ " := !c"
            ^ string_of_int n
            ^ " -- (place" ^ run_gate gate
            ^ " (" ^ run_expr (range.starts) ^ ") n);\n"
            ^ run_assert assertion n
        else "let circ_aux = ref (m_skip n) in\n"
            ^ "for i=" ^ run_expr (range.starts) ^ " to (" ^ run_expr (range.ends)
            ^ ") do\n" ^ "invariant{width !c" ^ (string_of_int n) ^ "=n}\n"
            ^ "circ_aux := !circ_aux -- (place" ^ run_gate gate
            ^ " i n);\ndone;\n" ^ "c" ^ string_of_int n ^ " := !c"
            ^ string_of_int n ^ " -- !circ_aux;\n" ^ run_assert assertion n
    | MultiApply {gate; qreg1; range1; qreg2; range2; qreg3; range3; assertion} ->
        "c" ^ string_of_int n ^ " := !c"
        ^ string_of_int n ^ " -- (" ^
         run_multigate gate ^ " (" ^ qreg1 ^ " " ^ run_range range1 ^ ")"
         ^ " (" ^ qreg2 ^ " " ^ run_range range2 ^ ")"
         ^ " (" ^ qreg3 ^ " " ^ run_range range3 ^ ")" ^
          ");\n" ^ run_assert assertion n

    | WithControl {gate; ctls; range1; tg; range2; assertion} ->
        begin match gate with
        | Apply {gate; qreg; range; assertion} ->
            begin match gate with
                | Rz (a) ->
                    if (range.starts=range.ends) then
                        "c" ^ string_of_int n ^ " := !c"
                        ^ string_of_int n ^ " -- ("
                        ^ "crz (" ^ run_expr range1.starts
                        ^ ") (" ^ run_expr range2.starts ^ ") ("
                        ^ run_expr a ^ ") n);\n"
                    else (*not done*)
                        "let circ_aux = ref (m_skip n)\nin "
                        ^ "for ctl=" ^ run_expr (range.starts) ^ " to "
                        ^ run_expr (range.ends)
                        ^ " do\n" ^ "circ_aux := !circ_aux -- " ^
                        "crz (" ^ run_expr (range.starts) ^ ") n)"
                        ^ " ctl " ^ run_expr range2.starts ^ ")\ndone;"
                | _ ->
                    if (range.starts=range.ends) then
                        "c" ^ string_of_int n ^ " := !c"
                        ^ string_of_int n ^ " -- "
                        ^ "cont " ^ run_gate gate
                        ^ " (" ^ run_expr range1.starts ^ ") (" ^ run_expr range2.starts ^ ")"
                        ^ " n;\n"
                    else
                        "let circ_aux = ref (m_skip n)\nin "
                        ^ "for ctl=" ^ run_expr (range.starts) ^ " to " ^ run_expr (range.ends)
                        ^ " do\n" ^ "circ_aux := !circ_aux -- " ^
                        "cont " ^ run_gate gate
                        ^ " ctl " ^ run_expr range2.starts ^ " n;\ndone;"
            end
        | MultiApply {gate; qreg1; range1; qreg2; range2; qreg3; range3; assertion} ->
            ""
        | FUN {id; args} ->  ""
        | REV {id; args} -> ""
        | _ -> "\nError\n"
        end ^ run_assert assertion n
    | FUN {id; args} ->
        "c" ^ string_of_int n ^ " := !c"
        ^ string_of_int n
        ^ " -- (" ^ id ^ " " ^ (run_args args) ^ ");\n"
    | REV {id; args} ->
        "c" ^ string_of_int n ^ " := !c"
        ^ string_of_int n
        ^ " -- (reverse (" ^ id ^ " " ^ (run_args args) ^ "));\n"

let run_iter = function
    {iterator; starts; ends} ->
        "for " ^ iterator ^ " = " ^ run_expr starts ^ " to (" ^ run_expr ends ^ ")";;

let run_conjugate gate n : string
    =
    match gate with
    | Apply {gate; qreg; range; assertion} ->
        if (range.starts=range.ends) then
            "c" ^ string_of_int n ^ " := !c"
            ^ string_of_int n
            ^ " -- (place" ^ run_gate gate
            ^ " (" ^ run_expr (range.starts) ^ ") n) -- !c"
            ^ string_of_int (n+1) ^ " -- reverse ("
            ^ "(place" ^ run_gate gate
            ^ " (" ^ run_expr (range.starts) ^ ") n));\n"
        else "let circ_aux = ref (m_skip n) in\n"
            ^ "for i=" ^ run_expr (range.starts) ^ " to (" ^ run_expr (range.ends)
            ^ ") do\n" ^ "invariant{width !c" ^ (string_of_int n) ^ "=n}\n"
            ^ "circ_aux := !circ_aux -- (place" ^ run_gate gate
            ^ " i n);\ndone;\n" ^ "c" ^ string_of_int n ^ " := !c"
            ^ string_of_int n ^ " -- !circ_aux -- !c"
            ^ string_of_int (n+1) ^" -- reverse (!circ_aux);\n" ^ run_assert assertion n
    | FUN {id; args} ->
            "c" ^ string_of_int n ^ " := !c"
            ^ string_of_int n
            ^ " -- (" ^ id ^ (run_args args) ^ ") -- !c"
            ^ string_of_int (n+1) ^ " -- reverse ("
            ^ "(" ^ id ^ (run_args args) ^ "));\n"
    | _ -> "Error"

let rec run_instr i n =
    match i with
    | Conjugated {gate; body; assertion} ->
        "let c" ^ string_of_int (n+1) ^ " = ref (m_skip n) in\n"
        ^ (get_conj_body body (n+1))
        ^ (run_conjugate gate n) ^ (run_assert assertion n)
    | For {iter; inv; body; assertion} ->
        "let c" ^ string_of_int (n+1) ^ " = ref (m_skip n) in\n"
        ^ run_iter iter ^ " do\n" ^
        begin if (n=0) then "invariant{width !c0=n}\n" else "" end
        ^ "invariant{width !c" ^ string_of_int (n+1) ^ "=n}\n"
        ^ run_inv inv (n+1)^  (*1->n+1*)
        (get_body body (n+1) "for") ^ (circ_looper_conj ((count_depth body)+1) n) ^
        (run_assert assertion n) ^ "\ndone;\n"
(*        ^ if (n+1=1) then "c" ^ string_of_int n ^ " := !c" ^ string_of_int n*)
(*        ^ " -- !c" ^ string_of_int (n+1) ^ ";\n" else ^ ""*)
    | If {cond; body; assertion} ->
        "if (" ^ run_cond cond ^ ") then\n" ^
        (get_body body (n+1) "if") ^
        (run_assert assertion n) ^ " \n"
        ^ "c" ^ string_of_int n ^ " := !c" ^ string_of_int n
        ^ " -- !c" ^ string_of_int (n+1) ^ ";\n"
    | IfElse {cond; ifbody; elsebody; assertion} ->
            "if (" ^ run_cond cond ^ ") then\n" ^
            (get_body ifbody (n+1) "if") ^
            " else \n" ^ "\n" ^ (get_body elsebody (n+1) "else")
            ^ "\n" ^ (run_assert assertion n) ^ "\n"
            ^ "c" ^ string_of_int n ^ " := !c" ^ string_of_int n
            ^ " -- !c" ^ string_of_int (n+1) ^ ";\n"
    | Unitary (unit) ->
        run_unitary unit n
    | Return (e) -> "" (*"return (!c0);\n"*)

and get_body body n id: string
    =
    match body with
    | [] -> ""
    | [i] -> begin match i with
             | Unitary (unit) -> run_unitary unit n (*^ circ_looper_conj n 0*)
             | _ -> run_instr i n end(*^ circ_looper_conj n 0 end*)
    | i :: tl ->
        match i with (*if instr is unitary, inverse sequence it at the end*)
        | Unitary (unit) ->
            if (n>0) then (* for when we have a unit inside a for/if/conj body *)
                get_body tl n id
                ^ run_unitary_inv unit (count_depth tl + 1)
            else if (count_depth tl > 0) then get_body tl n id (* for when we have a unit BEFORE a for/if/conj body *)
                ^ run_unitary_inv unit n
                else run_unitary unit n ^ get_body tl n id (* for when we have a unit AFTER a for/if/conj body *)
(*            ^ circ_looper_conj (count_depth tl) 0*)
        | _ -> run_instr i n ^ get_body tl n id

and get_conj_body body n : string
    =
    match body with
    | [] -> ""
    | [i] -> run_instr i n
    | i :: tl ->
            match i with (*if instr is unitary, inverse sequence it at the end*)
            | Unitary (unit) ->
                get_conj_body tl n
                ^ circ_looper_conj (1 + count_depth tl) n
                ^ run_unitary_inv unit (count_depth tl)
            | _ -> run_instr i n ^ get_conj_body tl n

and count_depth l : int
    = match l with
    | [] -> 0
    | [i] -> begin match i with
            | For _ -> 1
            | If _ -> 1
            | IfElse _ -> 1
(*            | Conjugated _ -> 1*)
            | _ -> 0 end
    | i :: tl -> begin match i with
                 | For _ -> 1 + count_depth tl
                 | If _ -> 1 + count_depth tl
                 | IfElse _ -> 1 + count_depth tl
(*                 | Conjugated _ -> 1 + count_depth tl*)
                 | _ -> count_depth tl end

and circ_looper n : string =
    match n with
    | 0 -> ""
    | _ -> "c" ^ string_of_int (n-1) ^ " := !c"
        ^ string_of_int (n-1) ^ " -- !c" ^ (string_of_int n) ^ ";\n"
        ^ circ_looper (n-1)

and circ_looper_conj n i : string =
    if (i!=0 || n==i) then ""
    else
        "c" ^ string_of_int (n-1) ^ " := !c"
        ^ string_of_int (n-1) ^ " -- !c" ^ (string_of_int n) ^ ";\n"
        ^ circ_looper_conj (n-1) i ;;

let rec sum_regs = function
    | [] -> ""
    | [i] -> i.qrid
    | i :: tl -> i.qrid ^ "+" ^ sum_regs tl ;;

let rec get_size = function
    | [] -> ""
    | [i] -> run_qreg i
    | i :: tl -> run_qreg i ^ get_size tl

let rec get_ids = function
    | [] -> ""
    | [i] -> i.qrid ^ " "
    | i :: ls -> i.qrid ^ " " ^ get_ids ls

let rec get_params_ints = function
    | [] -> ""
    | [i] -> begin match i.type_ with
            | Qreg -> i.id ^ " "
            | Int -> i.id ^ " "
            | _ -> "" end
    | i :: ls -> begin match i.type_ with
                 | Qreg -> i.id ^ " " ^ get_params_ints ls
                 | Int -> i.id ^ " " ^ get_params_ints ls
                 | _ -> "" ^ get_params_ints ls end

let rec get_params_circs = function
    | [] -> ""
    | [i] -> begin match i.type_ with
            | Circ -> i.id
            | _ -> "" end
    | i :: ls -> begin match i.type_ with
                 | Circ -> i.id ^ " " ^ get_params_circs ls
                 | _ -> "" ^ get_params_circs ls end

let rec contains_circs = function
    | [] -> false
    | [i] -> begin match i.type_ with
            | Circ -> true
            | _ -> false end
    | i :: ls -> begin match i.type_ with
                 | Circ -> true
                 | _ -> false || contains_circs ls end

let rec get_params_bools = function
    | [] -> ""
    | [i] -> begin match i.type_ with
            | Bool -> i.id
            | _ -> "" end
    | i :: ls -> begin match i.type_ with
                 | Bool -> i.id ^ " " ^ get_params_bools ls
                 | _ -> "" ^ get_params_bools ls end

let rec contains_bools = function
    | [] -> false
    | [i] -> begin match i.type_ with
            | Bool -> true
            | _ -> false end
    | i :: ls -> begin match i.type_ with
                 | Bool -> true
                 | _ -> false || contains_bools ls end

let run_circ = function
    {qregs; body} ->
        "=\nbegin\n" ^
        "let c0 = ref (m_skip n) in\n" ^  (get_body body 0 "circ")
        ^ "return !c0;\n";;

(*     (String.concat "" (List.map run_qreg qregs)) ^ (String.concat "\n" (List.map run_instr body)) ;;*)

let run_fun = function
    {id; circ; params; pre; pos} ->
        "let " ^ id
        ^ " (" ^ (get_params_ints params) ^ "n:int) " ^
        begin if (contains_circs params) then
        "(" ^ get_params_circs params ^ ": circuit) "
        else "" end ^
        begin if (contains_bools params) then
        "(" ^ get_params_bools params ^ ": boolean) "
        else "" end ^
        ": circuit\nrequires{0<n}\n" ^
        "requires{" ^ (sum_regs circ.qregs) ^ "=n}\n"
        ^ get_size circ.qregs
        ^ run_requires pre
        ^ run_circ circ
        ^ run_ensures pos ^ "end\n\n";;
(*        id ^ ":\n" ^ run_circ circ ^ (String.concat "" pre) ^ "\n" ^ String.concat "" pos ^ "\n\n";;*)

let rec run_imports = function
    | [] -> ""
    | [i] -> "use " ^ i ^ "." ^ String.capitalize_ascii i ^ "\n"
    | i :: tl -> "use " ^ i ^ "." ^ String.capitalize_ascii i ^ "\n" ^ run_imports tl

let run_program {id; imports; main; aux} =
        "module " ^ String.capitalize_ascii id ^ "\n\n"
        ^ (run_imports imports)
        ^ "use export binary.Bit_vector
use wired_circuits.Circuit_c
use export p_int.Int_comp
use ref.Ref
use qbricks.Circuit_macros
use int.Int
use reversion.Circuit_reverse
use wired_circuits.Qbricks_prim
use qbricks.Circuit_semantics
use int_expo.Int_Exponentiation
use unit_circle.Angle\n\n" ^
        (String.concat "" (List.map run_fun aux)) ^ run_fun main ^ "end\n";;
