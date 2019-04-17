package builder;

import chessboard.ChessBoard;
import console.Writer;
import parameters.ParameterList;

public class ChessBoardBuilder extends BoardBuilder {
    public ChessBoardBuilder(ParameterList parameterList, Writer writer) {
        super(parameterList, writer);
    }

    public void buildBoard() {
        parameterList.init();
        ChessBoard chessBoard = new ChessBoard(
                parameterList.getNextParameter().toInteger(),
                parameterList.getNextParameter().toInteger());
        writer.print(chessBoard);
    }

    public boolean isValidParameters() {
        parameterList.init();
        try {
            return (parameterList.getNextParameter().toInteger() > 0 &&
                    parameterList.getNextParameter().toInteger() > 0);
        } catch (Exception e) {
            return false;
        }
    }

    public void printHelp() {
        writer.print(ChessBoardBuilderHelper.getHelp());
    }

    public void printError() {
        writer.print("Wrong parameters!");
    }
}
