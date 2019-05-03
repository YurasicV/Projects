package chessboard;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardTest {

    @Test
    public void toStringTest() {
        ChessBoard chessBoard = new ChessBoard(2, 3);
        assertEquals("* *\n * \n", chessBoard.toString());
    }
}