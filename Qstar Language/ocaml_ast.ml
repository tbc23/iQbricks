open ML_AST2
open ML_eval

let p = {
    id = "main";
aux = [];
imports = [];
main = {
 id = "main";
circ = {
qregs= [{qrid="qr"; size=Num 4}];
body = [
Unitary (WithControl{ctlgate=MultiApply {gate=Toff; regs=[{iterator="qr"; starts=Num 1; ends=Num 1}; {iterator="qr"; starts=Num 2; ends=Num 2}; {iterator="qr"; starts=Num 3; ends=Num 3}]; assertion=[]
}; ctls=[{iterator="qr"; starts=Num 0; ends=Num 0}; ]; tg={iterator="tg"; starts=Num 0; ends=Num 0}; assertion=[]
}
);
For {
iter = {
iterator= "i";
starts = Num 0;
ends = Subtract (Len "qr", Num 2)
};
qr = "qr";
inv = ["{true}"; ];
body = [
Unitary(Sequence (Apply {gate=X; qreg="qr"; range={starts=Var "i"; ends=Var "i"}; assertion=[]
},Apply {gate=Y; qreg="qr"; range={starts=Var "i"; ends=Var "i"}; assertion=[]
}));
];
assertion=[]
};
Unitary (Apply {gate=Z; qreg="qr"; range={starts=Num 0; ends=Num 0}; assertion=[]
});
Return "";
];
}; 
params = [{id="qr";  type_=Qreg}; ]; 
pre = ["{n>0}"; ];
pos = ["{vazio}"; ];
}};;
let () =
       let run = run_program p in
       let oc = open_out "translation.mlw" in
         Printf.fprintf oc "%s" run;
         close_out oc;
         print_endline "translation.mlw generated";