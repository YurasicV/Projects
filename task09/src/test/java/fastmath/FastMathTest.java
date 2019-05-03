package fastmath;

import org.junit.Test;
import static org.junit.Assert.*;

public class FastMathTest {
    @Test
    public void powOddExponent() {
        assertEquals(3125, FastMath.pow(5, 5));
    }

    @Test
    public void powEvenExponent() {
        assertEquals(729, FastMath.pow(3, 6));
    }

    @Test
    public void powZeroExponent() {
        assertEquals(1, FastMath.pow(4, 0));
    }

    @Test
    public void powNegativeBase() {
        assertEquals(-216, FastMath.pow(-6, 3));
    }
}