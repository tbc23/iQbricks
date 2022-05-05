import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args)
    {
        try {
            QbricksLexer lexer = new QbricksLexer(CharStreams.fromFileName("qft.txt"));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            QbricksParser parser = new QbricksParser(stream);
            ParseTree tree = parser.program();
            ASTBuilder test = new ASTBuilder();
            AST ast = test.visit(tree);
            String val = new EvaluateVisitor().Visit((ProgramNode) ast);
            PrintWriter writer = new PrintWriter("translation.mlw");
            writer.write(val);
            writer.close();
            System.out.println("Translation successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
