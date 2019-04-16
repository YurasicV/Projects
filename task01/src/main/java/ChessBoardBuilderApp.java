import builder.ChessBoardBuilder;
import console.Writer;
import parameters.ParameterList;

/*
Class outputs chess board to the console
with size specified by parameters
 */
public class ChessBoardBuilderApp {
    public static void main(String[] args) {
        ChessBoardBuilder chessBoardBuilder = new ChessBoardBuilder(
                new ParameterList(args), new Writer());
        chessBoardBuilder.run();
    }
}
