package series;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibSeriesTest {

    @Test
    public void generateSomeValues() {
        assertEquals("[377, 610, 987]", FibSeries.generate(300, 1000));
    }

    @Test
    public void generateNone() {
        assertEquals("[]", FibSeries.generate(700, 900));
    }

    @Test
    public void generateIncorrectInterval() {
        assertEquals("[]", FibSeries.generate(500, 300));
    }
}