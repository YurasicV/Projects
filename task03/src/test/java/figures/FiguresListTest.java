package figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class FiguresListTest {
    private FiguresList figuresList;
    private Figure figureMock = Mockito.mock(Figure.class, Mockito.CALLS_REAL_METHODS);
    private Figure anotherFigureMock = Mockito.mock(Figure.class);

    @Before
    public void setUp() throws Exception {
        figuresList = new FiguresList();
        Mockito.when(figureMock.getSquare()).thenReturn(4.0);
        Mockito.when(anotherFigureMock.getSquare()).thenReturn(9.0);
        Whitebox.setInternalState(figureMock, "name", "Figure");
    }

    @After
    public void tearDown() throws Exception {
        FiguresList figuresList = null;
    }

    @Test
    public void addFigure() {
        figuresList.addFigure(figureMock);

        LinkedList<Figure> list = (LinkedList<Figure>) Whitebox.getInternalState(figuresList, "list");
        assertEquals(1, list.size());
        assertEquals(figureMock, list.getLast());
    }

    @Test
    public void toStringTest() {
        figuresList.addFigure(figureMock);
        assertEquals("======= List =======\n[Figure]: 4.0 cm2\n", figuresList.toString());
    }

    @Test
    public void sortBySquareDesc() {
        figuresList.addFigure(figureMock);
        figuresList.addFigure(anotherFigureMock);

        figuresList.sortBySquareDesc();

        LinkedList<Figure> list = (LinkedList<Figure>) Whitebox.getInternalState(figuresList, "list");
        assertEquals(figureMock, list.getLast());
        assertEquals(anotherFigureMock, list.getFirst());
    }
}