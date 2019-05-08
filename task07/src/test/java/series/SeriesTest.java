package series;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SeriesTest {
    private long number;
    private String expected;

    public SeriesTest(long number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: generate({0})={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {50, "1,2,3,4,5,6,7"},
                {100, "1,2,3,4,5,6,7,8,9,10"},
                {0, ""}
        });
    }

    @Test
    public void generate() {
        assertEquals(expected, Series.generate(number));
    }
}