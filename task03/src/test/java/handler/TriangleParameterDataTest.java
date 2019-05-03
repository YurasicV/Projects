package handler;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;

import static org.junit.Assert.*;

public class TriangleParameterDataTest {
    private TriangleParameterData triangleParameterDataMock = Mockito.mock(
            TriangleParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getName() {
        Whitebox.setInternalState(triangleParameterDataMock, "name", "triangle");
        assertEquals("triangle", triangleParameterDataMock.getName());
    }

    @Test
    public void getSizeA() {
        Whitebox.setInternalState(triangleParameterDataMock, "sizeA", 1.0);
        assertEquals(1.0, triangleParameterDataMock.getSizeA(), 0);
    }

    @Test
    public void getSizeB() {
        Whitebox.setInternalState(triangleParameterDataMock, "sizeB", 1.0);
        assertEquals(1.0, triangleParameterDataMock.getSizeB(), 0);
    }

    @Test
    public void getSizeC() {
        Whitebox.setInternalState(triangleParameterDataMock, "sizeC", 1.0);
        assertEquals(1.0, triangleParameterDataMock.getSizeC(), 0);
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        TriangleParameterData triangleParameterData = new TriangleParameterData(
                new ParameterList(new String[] {"triangle", "3", "4", "5"}));
        triangleParameterData.convert();
        assertEquals("triangle", triangleParameterData.getName());
        assertEquals(3.0, triangleParameterData.getSizeA(), 0.0);
        assertEquals(4.0, triangleParameterData.getSizeB(), 0.0);
        assertEquals(5.0, triangleParameterData.getSizeC(), 0.0);
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        TriangleParameterData triangleParameterData = new TriangleParameterData(
                new ParameterList(new String[] {"abc"}));
        triangleParameterData.convert();
    }
}