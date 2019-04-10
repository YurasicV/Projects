/*
Chess board class
 */
public class ChessBoard {
    private int rows;
    private int cols;

    public ChessBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    // method outputs chess board to the console
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
