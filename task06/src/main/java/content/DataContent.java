package content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DataContent {
    private StringBuilder data;
    private String errorMessage;

    public DataContent() {
        data = new StringBuilder();
        errorMessage = "";
    }

    public abstract boolean load();

    public abstract boolean save();

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isContained(String string) {
        return data.toString().toUpperCase().contains(string.toUpperCase());
    }

    protected void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    protected void outputToStream(OutputStream out) throws IOException {
        out.write(data.toString().getBytes());
    }

    protected void inputFromStream(InputStream in) throws IOException {
        int bytesAvailable = in.available();
        byte[] bytes = new byte[bytesAvailable];
        if (in.read(bytes, 0, bytesAvailable) != -1) {
            data.append((new String(bytes)));
        }
    }
}
