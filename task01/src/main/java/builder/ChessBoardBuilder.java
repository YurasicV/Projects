package builder;

import chessboard.ChessBoard;
import ui.UserInterface;
import parameters.ParameterList;

public class ChessBoardBuilder{
    private ParameterList parameterList;
    private UserInterface ui;

    public ChessBoardBuilder(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else {
            ChessBoardParameterData parameterData = new ChessBoardParameterData(parameterList);
            if (parameterData.isValid()) {
                ChessBoard chessBoard = new ChessBoard(
                        parameterData.getRows(),
                        parameterData.getCols());
                ui.print(chessBoard.toString());

            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(ChessBoardHelper.getHelp());
    }
}
