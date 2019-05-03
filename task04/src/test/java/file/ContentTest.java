package file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContentTest {
    private String data = "It rained. It was rainy day.";
    private Content content;

    @Before
    public void setUp() throws Exception {
        content = new Content(data);
    }

    @After
    public void tearDown() throws Exception {
        content = null;
    }

    @Test
    public void getData() {
        assertEquals(data, content.getData());
    }

    @Test
    public void setData() {
        String anotherData = "Another data";
        content.setData(anotherData);
        assertEquals(anotherData, content.getData());
    }

    @Test
    public void countOccurrences() {
        assertEquals(2, content.countOccurrences("rain"));
    }

    @Test
    public void countOccurrencesNone() {
        assertEquals(0, content.countOccurrences("snow"));
    }

    @Test
    public void replaceAll() {
        content.replaceAll("rain", "snow");
        assertEquals("It snowed. It was snowy day.", content.getData());
    }

    @Test
    public void replaceAllNone() {
        content.replaceAll("sun", "snow");
        assertEquals(data, content.getData());
    }
}