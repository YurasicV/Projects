package parameters;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParameterTest {

    @Test
    public void toStringNonEmpty() {
        assertEquals("param", new Parameter("param").toString());
    }

    @Test
    public void toStringEmpty() {
        assertTrue(new Parameter("").toString().isEmpty());
    }
}