package handler;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;

import static org.junit.Assert.*;

public class FastPowerParameterDataTest {
    private FastPowerParameterData fastPowerParameterDataMock = Mockito.mock(
            FastPowerParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getBase() {
        Whitebox.setInternalState(fastPowerParameterDataMock, "base", 1);
        assertEquals(1, fastPowerParameterDataMock.getBase());
    }

    @Test
    public void getExponent() {
        Whitebox.setInternalState(fastPowerParameterDataMock, "exponent", 1);
        assertEquals(1, fastPowerParameterDataMock.getExponent());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        FastPowerParameterData fastPowerParameterData = new FastPowerParameterData(
                new ParameterList(new String[] {"5", "6"}));
        fastPowerParameterData.convert();
        assertEquals(5, fastPowerParameterData.getBase());
        assertEquals(6, fastPowerParameterData.getExponent());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        FastPowerParameterData fastPowerParameterData = new FastPowerParameterData(
                new ParameterList(new String[] {"abc"}));
        fastPowerParameterData.convert();
    }
}