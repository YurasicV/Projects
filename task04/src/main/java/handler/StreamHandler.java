package handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Base parent class to handle with StringBuilder input and output streams
 */
public class StreamHandler {
    private StringBuilder content;

    public StreamHandler() {
        content = new StringBuilder();
    }

    public void clear() {
        content.delete(0, content.length());
    }

    public void outputToStream(OutputStream out) throws IOException {
        out.write(content.toString().getBytes());
    }

    public void inputFromStream(InputStream in) throws IOException {
        int bytesAvailable = in.available();
        byte[] bytes = new byte[bytesAvailable];
        if (in.read(bytes, 0, bytesAvailable) != -1) {
            content.append((new String(bytes)));
        }
    }

    public int countOccurrences(String string)
    {
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void replaceAll(String search, String replace) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(content);
        int startIndex = 0;
        while(matcher.find(startIndex)){
            content.replace(matcher.start(), matcher.end(), replace);
            startIndex = matcher.start() + replace.length();
        }
    }
}
