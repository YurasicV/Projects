package content;

import java.io.*;

public class FileContent extends DataContent {
    private String fileName;

    public FileContent(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean load() {
        setErrorMessage("");
        try (FileInputStream fis = new FileInputStream(fileName)) {
            inputFromStream(fis);
        } catch (FileNotFoundException e) {
            setErrorMessage("File " + fileName + " not found");
            return false;
        } catch (IOException e) {
            setErrorMessage("IO Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean save() {
        setErrorMessage("");
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            outputToStream(fos);
        } catch (IOException e) {
            setErrorMessage("IO Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
