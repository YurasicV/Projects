package converter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;

public class LocaleTest {
    private Locale locale = Mockito.mock(Locale.class, Mockito.CALLS_REAL_METHODS);
    private String[][] digit1;
    private String[] digit10;
    private String[] digit11;
    private String[] digit100;
    private String[][] triads;

    @Before
    public void setUp() throws Exception {
        digit1 = new String[][] {
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
        };
        digit10 = new String[] {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety"};
        digit11 = new String[] {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        digit100 = new String[] {"", "one hundred", "two hundred", "three hundred", "four hundred",
                "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
        triads = new String[][] {
                {"", "", "", "0"},
                {"thousand", "thousand", "thousand", "1"},
                {"million", "million", "million", "0"},
                {"billion", "billion", "billion", "0"},
                {"trillion", "trillion", "trillion", "0"},
        };
    }

    @After
    public void tearDown() throws Exception {
        digit1 = null;
        digit10 = null;
        digit11 = null;
        digit100 = null;
        triads = null;
    }

    @Test
    public void get1() {
        Whitebox.setInternalState(locale, "digit1", digit1);
        assertEquals("four", locale.get1(4, 0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get1Null() {
        Whitebox.setInternalState(locale, "digit1", digit1);
        locale.get1(10, 0);
    }


    @Test
    public void get10() {
        Whitebox.setInternalState(locale, "digit10", digit10);
        assertEquals("fifty", locale.get10(5));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get10Null() {
        Whitebox.setInternalState(locale, "digit10", digit10);
        locale.get10(10);
    }

    @Test
    public void get11() {
        Whitebox.setInternalState(locale, "digit11", digit11);
        assertEquals("sixteen", locale.get11(6));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get11Null() {
        Whitebox.setInternalState(locale, "digit11", digit11);
        locale.get11(10);
    }

    @Test
    public void get100() {
        Whitebox.setInternalState(locale, "digit100", digit100);
        assertEquals("seven hundred", locale.get100(7));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get100Null() {
        Whitebox.setInternalState(locale, "digit100", digit100);
        locale.get100(10);
    }

    @Test
    public void getTriad() {
        Whitebox.setInternalState(locale, "triads", triads);
        assertEquals("trillion", locale.getTriad(8, 4));
    }

    @Test
    public void getTriadGender() {
        Whitebox.setInternalState(locale, "triads", triads);
        assertEquals(0, locale.getTriadGender(4));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTriadGenderNull() {
        Whitebox.setInternalState(locale, "triads", triads);
        locale.getTriadGender(10);
    }

    @Test
    public void setDigit1() {
        locale.setDigit1(digit1);
        assertEquals("one", locale.get1(1, 0));
    }

    @Test
    public void setDigit10() {
        locale.setDigit10(digit10);
        assertEquals("twenty", locale.get10(2));
    }

    @Test
    public void setDigit11() {
        locale.setDigit11(digit11);
        assertEquals("thirteen", locale.get11(3));
    }

    @Test
    public void setDigit100() {
        locale.setDigit100(digit100);
        assertEquals("four hundred", locale.get100(4));
    }

    @Test
    public void setTriads() {
        locale.setTriads(triads);
        assertEquals("billion", locale.getTriad(5, 3));
    }
}