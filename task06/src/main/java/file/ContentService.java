package file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ContentService {
    private String errorMessage = "";

    public abstract Content read();

    public abstract boolean write(Content content);

    public String getErrorMessage() {
        return errorMessage;
    }

    protected void outputToStream(Content content, OutputStream out) throws IOException {
        if (content != null) {
            out.write(content.getData().getBytes());
        }
    }

    protected Content inputFromStream(InputStream in) throws IOException {
        Content content = null;
        int bytesAvailable = in.available();
        byte[] bytes = new byte[bytesAvailable];
        if (in.read(bytes, 0, bytesAvailable) != -1) {
            content = new Content(new String(bytes));
        }
        return content;
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
