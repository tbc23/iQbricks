open ML_AST2
open ML_eval

let p = {
    id = "grover_cz";
aux = [
{
id = "oracle_cz";
circ = {
qregs= [{qrid="qr"; size=Num 0}];
body = [
Unitary (WithControl{ctlgate=Apply {gate=Rz (Num 1); qreg="qr"; range={starts=Num 1; ends=Num 1}; assertion=["{true}"; ]
}; ctls=[{iterator="qr"; starts=Num 0; ends=Num 0}; ]; tg={iterator="qr"; starts=Num 1; ends=Num 1}; assertion=["{true}"; ]
}
);
];
};
params = []; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

{
id = "oracle_2";
circ = {
qregs= [{qrid="qr"; size=Num 0}];
body = [
Unitary (WithControl{ctlgate=Apply {gate=Rz (Num 1); qreg="qr"; range={starts=Num 0; ends=Num 0}; assertion=["{true}"; ]
}; ctls=[{iterator="qr"; starts=Num 1; ends=Num 1}; ]; tg={iterator="qr"; starts=Num 0; ends=Num 0}; assertion=["{true}"; ]
}
);
];
};
params = []; 
pre = ["{true}"; ];
pos = ["{true}"; ];
}; 

];
imports = ["grover"; ];
main = {
 id = "grover_cz";
circ = {
qregs= [{qrid="qr"; size=Num 0}; {qrid="aux"; size=Num 0}];
body = [
Unitary (FUN {id="grover"; args=[Var "oracle_cz"; Var "qr"; Var "aux"; Var "iters"; ]});
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