package series;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeriesTest {

    @Test
    public void generateMethod1() {
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", Series.generateMethod1(50));
    }

    @Test
    public void generateMethod1None() {
        assertEquals("[]", Series.generateMethod1(0));
    }


    @Test
    public void generateMethod2() {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Series.generateMethod2(100));
    }

    @Test
    public void generateMethod2None() {
        assertEquals("[]", Series.generateMethod2(0));
    }
}