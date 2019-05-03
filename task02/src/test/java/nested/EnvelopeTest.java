package nested;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnvelopeTest {
    private final int number = 1;
    private final double sizeA = 3.0;
    private final double sizeB = 5.0;
    private Envelope envelope = new Envelope(number, sizeA, sizeB);

    @Test
    public void getSizeA() {
        assertEquals(sizeA, envelope.getSizeA(), 0);
    }

    @Test
    public void getSizeB() {
        assertEquals(sizeB, envelope.getSizeB(), 0);
    }

    @Test
    public void toStringTest() {
        assertEquals("Envelope " + number, envelope.toString());
    }

    @Test
    public void isNestedToTestInSize() {
        Envelope anotherEnvelope = new Envelope(2, 2.0, 4.0);
        assertTrue(anotherEnvelope.isNestedTo(envelope));
    }

    @Test
    public void isNestedToTestInRotation() {
        Envelope anotherEnvelope = new Envelope(2, 5.5, 0.5);
        assertTrue(anotherEnvelope.isNestedTo(envelope));
    }
}