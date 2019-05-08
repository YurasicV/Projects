package series;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FibSeriesTest {
    private long minValue;
    private long maxValue;
    private String expected;

    public FibSeriesTest(long minValue, long maxValue, String expected) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: generate({0}+{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {300, 1000, "377,610,987"},
                {700, 900, ""},
                {500, 300, ""}
        });
    }

    @Test
    public void generate() {
        assertEquals(expected, FibSeries.generate(minValue, maxValue));
    }
}