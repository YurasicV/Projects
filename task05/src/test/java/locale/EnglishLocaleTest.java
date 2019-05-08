package locale;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnglishLocaleTest {
    private EnglishLocale locale = new EnglishLocale();

    @Test
    public void get1() {
        assertEquals("four", locale.get1(4, 0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get1Null() {
        locale.get1(10, 0);
    }

    @Test
    public void get10() {
        assertEquals("fifty", locale.get10(5));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get10Null() {
        locale.get10(10);
    }

    @Test
    public void get11() {
        assertEquals("sixteen", locale.get11(6));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get11Null() {
        locale.get11(10);
    }

    @Test
    public void get100() {
        assertEquals("seven hundred", locale.get100(7));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get100Null() {
        locale.get100(10);
    }

    @Test
    public void getTriad() {
        assertEquals("trillion", locale.getTriad(8, 4));
    }

    @Test
    public void getTriadGender() {
        assertEquals(0, locale.getTriadGender(4));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTriadGenderNull() {
        locale.getTriadGender(10);
    }
}