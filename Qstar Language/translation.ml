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
body=[
Unitary (WithControl{gate=Apply {gate=Rz (Subtract (Subtract (Var "n",Var "i"),Num 1)); qreg="qr"; range={starts=Var "q"; ends=Var "q"}}; ctls=["qr"; ]; range1={starts=Plus (Var "i",Num 1); ends=Plus (Var "i",Num 1)}; tg="qr"; range2={starts=Var "q"; ends=Var "q"}});
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
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;