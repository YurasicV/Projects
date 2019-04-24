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
            ChessBoardValidator validator = new ChessBoardValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                ChessBoard chessBoard = new ChessBoard(
                        validator.getRows(),
                        validator.getCols());
                ui.print(chessBoard.toString());

            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(ChessBoardHelper.getHelp());
    }
}
