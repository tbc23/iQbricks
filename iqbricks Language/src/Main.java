import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args)
    {
        try {
            QbricksLexer lexer = new QbricksLexer(CharStreams.fromFileName("iqbricks Language/grover.txt"));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            QbricksParser parser = new QbricksParser(stream);
            ParseTree tree = parser.program();
            ASTBuilder builder = new ASTBuilder();
            AST ast = builder.visit(tree);
            String val = new EvaluateVisitor().Visit((ProgramNode) ast);
            PrintWriter writer = new PrintWriter("ocaml_ast.ml");
            writer.write(val);
            writer.close();
            System.out.println("Translation successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
