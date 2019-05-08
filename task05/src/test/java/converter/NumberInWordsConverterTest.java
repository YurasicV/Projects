package converter;

import locale.RussianLocale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberInWordsConverterTest {
    private Locale locale = new RussianLocale();
    private long number;
    private String expected;

    public NumberInWordsConverterTest(long number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: convert({0})={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {123456789, "сто двадцать три миллиона четыреста пятьдесят шесть тысяч" +
                        " семьсот восемьдесят девять"},
                {5376271, "пять миллионов триста семьдесят шесть тысяч двести семьдесят один"},
                {4563, "четыре тысячи пятьсот шестьдесят три"},
                {716, "семьсот шестнадцать"},
                {52, "пятьдесят два"},
                {0, "ноль"},
                {-30, ""}
        });
    }

    @Test
    public void convert() {
        assertEquals(expected, NumberInWordsConverter.convert(number, locale));
    }
}