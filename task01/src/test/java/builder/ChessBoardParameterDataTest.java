package builder;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;

import static org.junit.Assert.*;

public class ChessBoardParameterDataTest {
    private ChessBoardParameterData chessBoardParameterDataMock = Mockito.mock(
            ChessBoardParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getRows() {
        Whitebox.setInternalState(chessBoardParameterDataMock, "rows", 1);
        assertEquals(1, chessBoardParameterDataMock.getRows());
    }

    @Test
    public void getCols() {
        Whitebox.setInternalState(chessBoardParameterDataMock, "cols", 1);
        assertEquals(1, chessBoardParameterDataMock.getCols());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        ChessBoardParameterData chessBoardParameterData = new ChessBoardParameterData(
                new ParameterList(new String[] {"5", "6"}));
        chessBoardParameterData.convert();
        assertEquals(5, chessBoardParameterData.getRows());
        assertEquals(6, chessBoardParameterData.getCols());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        ChessBoardParameterData chessBoardParameterData = new ChessBoardParameterData(
                new ParameterList(new String[] {"abc"}));
        chessBoardParameterData.convert();
    }
}