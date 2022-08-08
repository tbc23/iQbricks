open ML_AST2
open ML_eval

let p = {
    id = "grover";
aux = [
{
id = "diffusor";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Conjugated {gate=Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract(Len "qr", Num 1)}; assertion=[]
};
 body = [
Conjugated {gate=Apply {gate=X; qreg="qr"; range={starts=Num 0; ends=Subtract(Len "qr", Num 1)}; assertion=[]
};
 body = [
Unitary (WithControl{ctlgate=Apply {gate=Z; qreg="qr"; range={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}; assertion=["{true}"; ]
}; ctls=[{iterator="qr"; starts=Num 0; ends=Subtract (Len "qr", Num 2)}; ]; tg={iterator="qr"; starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}; assertion=["{true}"; ]
}
);
];
assertion=[]
};
];
assertion=[]
};
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

{
id = "grover_iter";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary(Sequence (FUN {id="diffusor"; args=[Var "qr"; Var "aux"; ]},FUN {id="oracle"; args=[]}));
Return "";
];
};
params = [{id="oracle";  type_=Circ}; {id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

{
id = "init";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="aux"; range={starts=Num 0; ends=Subtract(Len "aux", Num 1)}; assertion=["{true}"; ]
},Sequence (Apply {gate=X; qreg="aux"; range={starts=Num 0; ends=Subtract(Len "aux", Num 1)}; assertion=["{true}"; ]
},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract(Len "qr", Num 1)}; assertion=[]
})));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

];
imports = ["bruh"; ];
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
body = [
Unitary (FUN {id="grover_iter"; args=[Var "oracle"; Var "qr"; Var "aux"; ]});
];
assertion=[]
};
Return "";
];
}; 
params = [{id="oracle";  type_=Circ}; {id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; {id="iters";  type_=Int}; ]; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}};;
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;
         print_endline "translation.mlw generated";