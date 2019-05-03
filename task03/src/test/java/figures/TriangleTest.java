package figures;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getSquareCorrectTriangle() {
        Triangle triangle = new Triangle("Triangle", 3, 4, 5);
        assertEquals(6, triangle.getSquare(), 0);
    }

    @Test
    public void getSquareWrongTriangle() {
        Triangle triangle = new Triangle("Triangle", 2, 2, 5);
        assertEquals(0, triangle.getSquare(), 0);
    }

    @Test
    public void isExistsCorrectTriangle() {
        assertTrue(Triangle.isExists(5, 12, 13));
    }

    @Test
    public void isExistsWrongTriangle() {
        assertFalse(Triangle.isExists(5, 7, 15));
    }
}