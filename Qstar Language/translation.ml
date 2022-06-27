open ML_AST2
open ML_eval

let p = {
    id = "program";
aux = [

{
id = "diffusor";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Len "qr"}; assertion=[]
},Sequence (Apply {gate=X; qreg="qr"; range={starts=Num 0; ends=Len "qr"}; assertion=[]
},Sequence (WithControl{gate=Apply {gate=Z; qreg="qr"; range={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}; assertion=["{true}"; ]
}; ctls=["qr"; ]; range1={starts=Num 0; ends=Subtract (Len "qr", Num 1)}; tg="qr"; range2={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}; assertion=["{true}"; ]
}
,Sequence (Apply {gate=X; qreg="qr"; range={starts=Num 0; ends=Len "qr"}; assertion=["{true}"; ]
},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Len "qr"}; assertion=[]
})))));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ];
pre = ["{true}"; ];
pos = ["{true}"; ];
};

{
id = "oracle";
circ = {
qregs= [{qrid="qr"; size=Num 0}];
body = [
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
qregs= [{qrid="qr"; size=Num 0}];
body = [
Unitary(Sequence (FUN {id="diffusor"; args=[Var "qr"; Var "aux"; ]},FUN {id="oracle"; args=[Var "qr"; Var "aux"; ]}));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; ];
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
},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract (Len "qr", Num 1)}; assertion=[]
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
qregs= [{qrid="qr"; size=Num 4}; {qrid="aux"; size=Num 1}];
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
Unitary (FUN {id="grover_iter"; args=[Var "qr"; Var "aux"; ]});
];
assertion=[]
};
Return "";
];
};
params = [{id="qr";  type_=Qreg}; {id="aux";  type_=Qreg}; {id="iters";  type_=Int}; ];
pre = ["{true}"; ];
pos = ["{true}"; ];
}};;
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;
         print_endline "translation.mlw generated";