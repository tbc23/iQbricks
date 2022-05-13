open ML_AST2
open ML_eval

let p = {
    id = "program";
aux = [

{
id = "oracle";
circ = {
qregs= [{id="qr"; size=Num 0}];
body = [
For {
iter = {
iterator= "q";
starts = Num 0;
ends = Subtract (Len "qr", Num 1)
};
inv = ["{true}"; ];
body=[
Unitary (MultiApply {gate=Cnot; qreg1="qr"; range1={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}; qreg2="qr"; range2={starts=Var "q"; ends=Var "q"}; qreg3="NONE"; range3={starts=Num 0; ends=Num 0}});
];
assertion=["{ true }"; ]
};
];
};
params = [{id="qr";  type_=Qreg}; ];
pre = ["{n > 0}"; ];
pos = ["{true}"; ];
};

];
main = {
 id = "dj";
circ = {
qregs= [{id="qr"; size=Num 0}];
body = [
Unitary(Sequence (Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract (Len "qr", Num 1)}},Sequence (FUN {id="oracle"; args=[Var "qr"; ]},Sequence (Apply {gate=H; qreg="qr"; range={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}},Sequence (Apply {gate=H; qreg="qr"; range={starts=Num 0; ends=Subtract (Len "qr", Num 1)}},Apply {gate=X; qreg="qr"; range={starts=Subtract (Len "qr", Num 1); ends=Subtract (Len "qr", Num 1)}})))));
Return "";
];
};
params = [{id="qr";  type_=Qreg}; ];
pre = ["{n > 0}"; ];
pos = ["{true}"; ];
}};;

let run = run_program p ;;
print_endline run;;