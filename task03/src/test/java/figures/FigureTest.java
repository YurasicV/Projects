package figures;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;

public class FigureTest {
    private Figure figureMock = Mockito.mock(
            Figure.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void toStringTest() {
        Mockito.doCallRealMethod()
                .when(figureMock)
                .toString();
        Mockito.when(figureMock.getSquare())
                .thenReturn(4.0);
        Whitebox.setInternalState(figureMock, "name", "Figure");
        assertEquals("[Figure]: 4.0 cm2", figureMock.toString());
    }
}