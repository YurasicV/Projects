package counter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuckyTicketPiterCounterTest {
    private LuckyTicketPiterCounter counter = new LuckyTicketPiterCounter();

    @Test
    public void count() {
        assertEquals(55252, counter.count());
    }

    @Test
    public void isLuckyTrue() {
        assertTrue(counter.isLucky(new int[] {2,5,5,1,8,9}));
    }

    @Test
    public void isLuckyFalse() {
        assertFalse(counter.isLucky(new int[] {4,8,6,5,2,3}));
    }
}