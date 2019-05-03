package handler;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;
import static org.junit.Assert.*;

public class FibParameterDataTest {
    private FibParameterData fibParameterDataMock = Mockito.mock(
            FibParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getMinValue() {
        Whitebox.setInternalState(fibParameterDataMock, "minValue", 1);
        assertEquals(1, fibParameterDataMock.getMinValue());
    }

    @Test
    public void getMaxValue() {
        Whitebox.setInternalState(fibParameterDataMock, "maxValue", 1);
        assertEquals(1, fibParameterDataMock.getMaxValue());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        FibParameterData fibParameterData = new FibParameterData(
                new ParameterList(new String[] {"5", "10"}));
        fibParameterData.convert();
        assertEquals(5, fibParameterData.getMinValue());
        assertEquals(10, fibParameterData.getMaxValue());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        FibParameterData fibParameterData = new FibParameterData(
                new ParameterList(new String[] {"abc"}));
        fibParameterData.convert();
    }
}