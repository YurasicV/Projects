package builder;

import chessboard.ChessBoard;
import console.Writer;
import parameters.ParameterList;

public class ChessBoardBuilder {
    private ParameterList parameterList;
    private Writer writer;

    public ChessBoardBuilder(ParameterList parameterList, Writer writer) {
        this.parameterList = parameterList;
        this.writer = writer;
    }

    public void run() {
        if (parameterList.count() == 0) {
            writer.print(ChessBoardBuilderHelper.getHelp());
        } else if (isValidParameters()) {
            parameterList.init();
            ChessBoard chessBoard = new ChessBoard(
                    parameterList.getNextParameter().toInteger(),
                    parameterList.getNextParameter().toInteger());
            writer.print(chessBoard);
        } else {
            writer.print("Wrong parameters!");
        }
    }

    private boolean isValidParameters() {
        parameterList.init();
        try {
            return (parameterList.getNextParameter().toInteger() > 0 &&
                    parameterList.getNextParameter().toInteger() > 0);
        } catch (Exception e) {
            return false;
        }
    }
}
