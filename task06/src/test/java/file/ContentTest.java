package file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContentTest {
    private String data = "Something to read";
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
        content.setData("Another data");
        assertEquals("Another data", content.getData());
    }

    @Test
    public void containsTrue() {
        assertTrue(content.contains("thing"));
    }

    @Test
    public void containsFalse() {
        assertFalse(content.contains("other"));
    }
}