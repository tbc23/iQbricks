open ML_AST2
open ML_eval

let p = {
    id = "program";
aux = [];
main = {
 id = "qft";
circ = {
qregs= [{qrid="qr"; size=Num 0}];
body = [
For {
iter = {
iterator= "q";
starts = Num 0;
ends = Subtract (Len "qr", Num 1)
};
inv = ["{range circ = q}"; "{forall x y i. 0<= i < n -> basis_ket circ x y i = if 0<= i < q then y i else x i}"; "{forall x y. ang_ind circ x y = (ind_isum(fun k -> (ind_isum (fun l -> x l * y k * power 2 (n-l - 1+k)) k n))0 q) /./ n}"; ];
body = [
Unitary (Apply {gate=H; qreg="qr"; range={starts=Var "q"; ends=Var "q"}; assertion=["{width circ = n}"; "{forall x y: int->int. forall i:int. 0<=i<n ->basis_ket circ x y i = if i = q then y 0 else x i}"; "{forall x y. ang_ind circ x y = (ind_isum (fun l -> x l * y 0 * power 2 (n-l - 1+ q)) q n) /./ n}"; ]
});
For {
iter = {
iterator= "i";
starts = Plus (Var "q",Num 1);
ends = Subtract (Len "qr", Num 1)
};
inv = ["{range circ = 0}"; "{forall x y i. 0<= i < n -> basis_ket circ x y i = x i}"; "{forall x y. ang_ind circ x y = (ind_isum (fun l -> x l * x q * power 2 (n- l -1+ q)) (q+1) i) /./n}"; ];
body=[
Unitary (WithControl{gate=Apply {gate=Rz (Subtract (Var "i",Var "q")); qreg="qr"; range={starts=Var "q"; ends=Var "q"}; assertion=[]
}; ctls=["qr"; ]; range1={starts=Plus (Var "i",Num 1); ends=Plus (Var "i",Num 1)}; tg="qr"; range2={starts=Var "q"; ends=Var "q"}; assertion=[]
});
];
assertion=[]
};
];
assertion=[]
};
Return "";
];
}; 
params = [{id="qr";  type_=Qreg}; ]; 
pre = ["{true}"; ];
pos = ["{width result = n}"; "{range result = n}"; "{forall x y i. 0<= i < n -> basis_ket result x y i = y i}"; "{forall x y. ang_ind result x y  = (ind_isum(fun k -> (ind_isum (fun l -> x l * y k * power 2 (n-l - 1+k)) k n))0 n) /./ n}"; ];
}};;
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;
         print_endline "translation.mlw generated";