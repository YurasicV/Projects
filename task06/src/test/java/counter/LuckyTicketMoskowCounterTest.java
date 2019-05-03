package counter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuckyTicketMoskowCounterTest {
    private LuckyTicketMoskowCounter counter = new LuckyTicketMoskowCounter();

    @Test
    public void count() {
        assertEquals(55252, counter.count());
    }

    @Test
    public void isLuckyTrue() {
        assertTrue(counter.isLucky(new int[] {2,5,8,5,1,9}));
    }

    @Test
    public void isLuckyFalse() {
        assertFalse(counter.isLucky(new int[] {4,8,6,5,2,3}));
    }
}