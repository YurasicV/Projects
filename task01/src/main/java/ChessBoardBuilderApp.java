import builder.BoardBuilder;
import builder.ChessBoardBuilder;
import console.Writer;
import parameters.ParameterList;

public class ChessBoardBuilderApp {
    public static void main(String[] args) {
        BoardBuilder boardBuilder = new ChessBoardBuilder(
                new ParameterList(args), new Writer());
        boardBuilder.run();
    }
}
