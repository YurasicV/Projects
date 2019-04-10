/*
Class outputs chess board to the console
with size specified by parameters
 */
public class ChessBoardOutput {
    public static void main(String[] args) {
        if (isParamValid(args)) {
            ChessBoard chessBoard = new ChessBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            chessBoard.print();
        }
    }

    // method checks parameters
    private static boolean isParamValid(String[] args) {
        if (args.length == 0) {
            System.out.println("You must specify two integer parameters: rows and cols number");
            return false;
        } else if (args.length != 2) {
            System.out.println("Wrong number of parameters");
            return false;
        } else if (!isInteger(args[0])) {
            System.out.println("First parameter must be integer (rows number)");
            return false;
        } else if (!isInteger(args[1])) {
            System.out.println("Second parameter must be integer (cols number)");
            return false;
        }
        return true;
    }

    // method checks can string be transformed to integer
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
