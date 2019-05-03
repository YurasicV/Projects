package file;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.*;

public class ContentServiceTest {
    private ContentService serviceMock = Mockito.mock(ContentService.class,
            Mockito.CALLS_REAL_METHODS);
    private String errorMessage = "Error Message";
    private String data = "Something";
    private Content content = new Content(data);

    @Test
    public void getErrorMessage() {
        Whitebox.setInternalState(serviceMock, "errorMessage", errorMessage);
        assertEquals(errorMessage, serviceMock.getErrorMessage());
    }

    @Test
    public void setErrorMessage() {
        serviceMock.setErrorMessage(errorMessage);
        assertEquals(errorMessage, serviceMock.getErrorMessage());
    }

    @Test
    public void outputToStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        serviceMock.outputToStream(content, baos);
        byte[] byteArray = baos.toByteArray();
        assertEquals(content.getData(), new String(byteArray));
    }

    @Test
    public void inputFromStream() throws IOException {
        String inputData = "0" + "\n0" + "\n0";
        Content inputContent = serviceMock.inputFromStream(new ByteArrayInputStream(inputData.getBytes()));
        assertEquals(inputData, inputContent.getData());
    }
}