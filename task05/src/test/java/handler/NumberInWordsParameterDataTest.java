package handler;

import converter.Locale;
import locale.RussianLocale;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;

import static org.junit.Assert.*;

public class NumberInWordsParameterDataTest {
    private NumberInWordsParameterData numberInWordsParameterDataMock = Mockito.mock(
            NumberInWordsParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getNumber() {
        Whitebox.setInternalState(numberInWordsParameterDataMock, "number", 1);
        assertEquals(1, numberInWordsParameterDataMock.getNumber());
    }

    @Test
    public void getLocale() {
        Locale locale = Mockito.mock(Locale.class);
        Whitebox.setInternalState(numberInWordsParameterDataMock, "locale", locale);
        assertEquals(locale, numberInWordsParameterDataMock.getLocale());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        NumberInWordsParameterData numberInWordsParameterData = new NumberInWordsParameterData(
                new ParameterList(new String[] {"5", "ru"}));
        numberInWordsParameterData.convert();
        assertEquals(5, numberInWordsParameterData.getNumber());
        assertEquals(RussianLocale.class,
                numberInWordsParameterData.getLocale().getClass());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        NumberInWordsParameterData numberInWordsParameterData = new NumberInWordsParameterData(
                new ParameterList(new String[] {"abc"}));
        numberInWordsParameterData.convert();
    }
}