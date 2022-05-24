open ML_AST2
open ML_eval

let p = {
    id = "program";
aux = [

{
id = "diffusor";
circ = {
qregs= [{id="qr"; size=Num 0}; {id="aux"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Len "qr"}},Sequence (Apply {gate=X; qreg="qr"; range={starts=Num 0; ends=Len "qr"}},Sequence (WithControl{gate=Apply {gate=Z; qreg="qr"; range={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}}; ctls=["qr"; ]; range1={starts=Num 0; ends=Subtract (Len "qr", Num 1)}; tg="qr"; range2={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}}
,Sequence (Apply {gate=X; qreg="qr"; range={starts=Num 0; ends=Len "qr"}},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Len "qr"}})))));
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
qregs= [{id="qr"; size=Num 0}];
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
qregs= [{id="qr"; size=Num 0}];
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
qregs= [{id="qr"; size=Num 0}; {id="aux"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="aux"; range={starts=Num 0; ends=Len "aux"}},Sequence (Apply {gate=X; qreg="aux"; range={starts=Num 0; ends=Len "aux"}},Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract (Len "qr", Num 1)}})));
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
qregs= [{id="qr"; size=Num 4}; {id="aux"; size=Num 1}];
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

let run = run_program p ;;
print_endline run;;