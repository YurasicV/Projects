package converter;

import locale.RussianLocale;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberInWordsConverterTest {
    private Locale locale = new RussianLocale();

    @Test
    public void convertBigNumber() {
        long bigNumber = 123456789;
        String bigNumberInWords = "сто двадцать три миллиона " +
                "четыреста пятьдесят шесть тысяч семьсот восемьдесят девять";
        String numberInWords = NumberInWordsConverter.convert(bigNumber, locale);
        assertEquals(bigNumberInWords, numberInWords);
    }

    @Test
    public void convertZero() {
        String numberInWords = NumberInWordsConverter.convert(0, locale);
        assertEquals("ноль", numberInWords);
    }

    @Test
    public void convertIncorrectNumber() {
        String numberInWords = NumberInWordsConverter.convert(-100, locale);
        assertEquals("", numberInWords);
    }
}