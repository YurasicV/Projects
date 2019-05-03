package file;

import java.io.*;

public class FileContentService extends ContentService {
    private String fileName;

    public FileContentService(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Content read() {
        setErrorMessage("");
        try (FileInputStream fis = new FileInputStream(fileName)) {
            return inputFromStream(fis);
        } catch (FileNotFoundException e) {
            setErrorMessage("File " + fileName + " not found");
        } catch (IOException e) {
            e.printStackTrace();
            setErrorMessage("IO Error");
        }
        return null;
    }

    @Override
    public boolean write(Content content) {
        setErrorMessage("");
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            outputToStream(content, fos);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            setErrorMessage("IO Error");
        }
        return false;
    }
}
