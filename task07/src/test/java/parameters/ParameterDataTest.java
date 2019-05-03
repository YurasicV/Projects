package parameters;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;

public class ParameterDataTest {
    private ParameterData parameterData = Mockito.mock(
            ParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void isValidTrue() {
        Mockito.doCallRealMethod()
                .when(parameterData)
                .isValid();
        Whitebox.setInternalState(parameterData, "valid", true);
        assertTrue(parameterData.isValid());
    }

    @Test
    public void isValidFalse() {
        Mockito.doCallRealMethod()
                .when(parameterData)
                .isValid();
        Whitebox.setInternalState(parameterData, "valid", false);
        assertFalse(parameterData.isValid());
    }

    @Test
    public void getMessageNonEmpty() {
        Mockito.doCallRealMethod()
                .when(parameterData)
                .getMessage();
        Whitebox.setInternalState(parameterData, "message", "hello");
        assertEquals("hello", parameterData.getMessage());
    }

    @Test
    public void getMessageEmpty() {
        Mockito.doCallRealMethod()
                .when(parameterData)
                .getMessage();
        Whitebox.setInternalState(parameterData, "message", "");
        assertTrue(parameterData.getMessage().isEmpty());
    }

    @Test
    public void getParameterExisting() {
        Mockito.doCallRealMethod()
                .when(parameterData)
                .getParameter(Mockito.anyInt());
        Whitebox.setInternalState(parameterData, "parameterList",
                new ParameterList(new String[] {"param1", "param2"}));
        assertEquals("param1", parameterData.getParameter(0).toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getParameterNonExisting() {
        Whitebox.setInternalState(parameterData, "parameterList",
                new ParameterList(new String[] {"param1", "param2"}));
        Mockito.doCallRealMethod()
                .when(parameterData)
                .getParameter(Mockito.anyInt());
        parameterData.getParameter(2);
    }
}