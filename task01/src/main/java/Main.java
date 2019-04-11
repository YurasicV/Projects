import publisher.Publisher;
import validator.Validator;
import chessboard.ChessBoard;

/*
Class outputs chess board to the console
with size specified by parameters
 */
public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        if (validator.isValidate(args)) {
            ChessBoard chessBoard = new ChessBoard(validator.getParam1(), validator.getParam2());
            Publisher.print(chessBoard);
        } else {
            Publisher.print(validator.getCheckStatusMessage());
        }
    }
}
