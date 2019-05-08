package chessboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ChessBoardTest {
    private int rows;
    private int cols;
    private String expected;

    public ChessBoardTest(int rows, int cols, String expected) {
        this.rows = rows;
        this.cols = cols;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Chessboard({0},{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {2, 3, "* *\n * \n"},
                {3, 4, "* * \n * *\n* * \n"},
                {0, 0, ""}
        });
    }

    @Test
    public void toStringTest() {
        ChessBoard chessBoard = new ChessBoard(rows, cols);
        assertEquals(expected, chessBoard.toString());
    }
}