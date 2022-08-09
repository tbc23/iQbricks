open ML_AST2
open ML_eval

let p = {
    id = "main";
aux = [];
imports = ["qft"; ];
main = {
 id = "main";
circ = {
qregs= [{qrid="qr"; size=Num 4}];
body = [
Unitary (WithControl{ctlgate=REV {id="qft"; args=[Var "qr"; ]}; ctls=[{iterator="qr"; starts=Num 0; ends=Num 0}; ]; tg={iterator="null"; starts=Var "null"; ends=Var "null"}; assertion=[]
}
);
For {
iter = {
iterator= "i";
starts = Num 0;
ends = Subtract(Var "qr", Num 1)
};
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