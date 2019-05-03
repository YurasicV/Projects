package handler;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import parameters.ParameterConversionException;
import parameters.ParameterList;

import static org.junit.Assert.*;

public class FileHandlerParameterDataTest {
    private FileHandlerParameterData fileHandlerParameterDataMock = Mockito.mock(
            FileHandlerParameterData.class,
            Mockito.CALLS_REAL_METHODS);

    @Test
    public void getFileName() {
        Whitebox.setInternalState(fileHandlerParameterDataMock, "fileName", "noname.txt");
        assertEquals("noname.txt", fileHandlerParameterDataMock.getFileName());
    }

    @Test
    public void getSearch() {
        Whitebox.setInternalState(fileHandlerParameterDataMock, "search", "Search string");
        assertEquals("Search string", fileHandlerParameterDataMock.getSearch());
    }

    @Test
    public void getReplace() {
        Whitebox.setInternalState(fileHandlerParameterDataMock, "replace", "New string");
        assertEquals("New string", fileHandlerParameterDataMock.getReplace());
    }

    @Test
    public void convertWithCorrectParameters() throws ParameterConversionException {
        FileHandlerParameterData fileHandlerParameterData = new FileHandlerParameterData(
                new ParameterList(new String[] {"readme.txt", "Jack", "Henry"}));
        fileHandlerParameterData.convert();
        assertEquals("readme.txt", fileHandlerParameterData.getFileName());
        assertEquals("Jack", fileHandlerParameterData.getSearch());
        assertEquals("Henry", fileHandlerParameterData.getReplace());
    }

    @Test (expected = ParameterConversionException.class)
    public void convertWithIncorrectParameters() throws ParameterConversionException {
        FileHandlerParameterData fileHandlerParameterData = new FileHandlerParameterData(
                new ParameterList(new String[] {"abc"}));
        fileHandlerParameterData.convert();
    }
}