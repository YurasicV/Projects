package handler;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;
import static org.junit.Assert.*;

public class SeriesParameterDataTest {
    private SeriesParameterData seriesParameterDataMock = Mockito.mock(
            SeriesParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getNumber() {
        Whitebox.setInternalState(seriesParameterDataMock, "number", 1);
        assertEquals(1, seriesParameterDataMock.getNumber());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        SeriesParameterData seriesParameterData = new SeriesParameterData(
                new ParameterList(new String[] {"5"}));
        seriesParameterData.convert();
        assertEquals(5, seriesParameterData.getNumber());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        SeriesParameterData seriesParameterData = new SeriesParameterData(
                new ParameterList(new String[] {"abc"}));
        seriesParameterData.convert();
    }
}