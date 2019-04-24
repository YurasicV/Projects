import builder.ChessBoardBuilder;
import ui.ConsoleInterface;
import parameters.ParameterList;

public class ChessBoardBuilderApp {
    public static void main(String[] args) {
        ChessBoardBuilder chessBoardBuilder = new ChessBoardBuilder(
                new ParameterList(args),
                new ConsoleInterface());
        chessBoardBuilder.run();
    }
}
