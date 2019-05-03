package counter;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LuckyTicketCounterTest {
    private LuckyTicketCounter counterMock = Mockito.mock(LuckyTicketCounter.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void countAll() {
        Mockito.when(counterMock.isLucky(Mockito.any())).thenReturn(true);
        assertEquals(1000000, counterMock.count());
    }

    @Test
    public void countNone() {
        Mockito.when(counterMock.isLucky(Mockito.any())).thenReturn(false);
        assertEquals(0, counterMock.count());
    }
}