import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        try {
            QbricksLexer lexer = new QbricksLexer(CharStreams.fromFileName("test2.txt"));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            QbricksParser parser = new QbricksParser(stream);
            ParseTree tree = parser.program();
            ASTBuilder test = new ASTBuilder();
            AST ast = test.visit(tree);
            String val = new EvaluateVisitor().Visit((ProgramNode) ast);
            System.out.println("\n\n"+val);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
