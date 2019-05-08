package fastmath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FastMathTest {
    private long base;
    private long exponent;
    private long expected;

    public FastMathTest(long base, long exponent, long expected) {
        this.base = base;
        this.exponent = exponent;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: pow({0},{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {5, 5, 3125},
                {3, 6, 729},
                {4, 0, 1},
                {-6, 3, -216}
        });
    }

    @Test
    public void pow() {
        assertEquals(expected, FastMath.pow(base, exponent));
    }
}