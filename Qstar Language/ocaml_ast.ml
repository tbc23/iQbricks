open ML_AST2
open ML_eval

let p = {
    id = "program";
aux = [

{
id = "grover_iter";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary(Sequence (FUN {id="diffusor"; args=[Var "qr"; Var "aux"; ]},FUN {id="oracle"; args=[Var "qr"; ]}));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; {id="oracle";  type_=Circ}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

{
id = "init";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="aux"; range={starts=Num 0; ends=Len "aux"}; assertion=["{true}"; ]
},Sequence (Apply {gate=X; qreg="aux"; range={starts=Num 0; ends=Len "aux"}; assertion=["{true}"; ]
},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract (Len "qr", Num 2)}; assertion=[]
})));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

];
main = {
 id = "grover";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary (FUN {id="init"; args=[Var "qr"; Var "aux"; ]});
For {
iter = {
iterator= "i";
starts = Num 0;
ends = Var "iters"
};
inv = ["{true}"; ];
body=[
Unitary (FUN {id="grover_iter"; args=[Var "qr"; Var "aux"; Var "oracle"; ]});
];
assertion=[]
};
Return "";
];
}; 
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; {id="iters";  type_=Int}; {id="oracle";  type_=Circ}; ]; 
pre = ["{iters=2}"; ];
pos = ["{true}"; ];
}};;
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;
         print_endline "translation.mlw generated";