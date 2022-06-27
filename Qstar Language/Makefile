debug=no
verbose=no

compile: ML_AST2.ml ML_eval.ml translation.ml
	@ocamlopt str.cmxa -o  program ML_AST2.ml ML_eval.ml translation.ml
	@./program

parser:
		@/home/tomas/.jdks/openjdk-17.0.2/bin/java -javaagent:/home/tomas/idea-IC-213.6777.52/lib/idea_rt.jar=35909:/home/tomas/idea-IC-213.6777.52/bin -Dfile.encoding=UTF-8 -classpath /home/tomas/Desktop/qstar/Qstar Language/out/production/Qbricks:/home/tomas/Downloads/antlr-runtime-4.9.3.jar Main


graphAVL: GraphAVL.c AVLTrees.c AVLTrees.h
	@gcc -w AVLTrees.c GraphAVL.c
	@./a.out

clean:
	@rm lex.yy.c
	@rm y.tab.h
	@rm y.tab.c
	@rm *.dot
	@rm *.png
	@rm *.vm

man:
	@more "Man.txt"