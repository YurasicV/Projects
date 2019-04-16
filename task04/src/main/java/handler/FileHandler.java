package handler;

import java.io.*;

/*
Class allows to input from or output to file
 */
public class FileHandler extends StreamHandler {
    private String errorMessage;

    public FileHandler() {
        errorMessage = "";
    }

    public boolean loadFromFile(String fileName) {
        boolean success = false;
        errorMessage = "";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            inputFromStream(fis);
            success = true;
        } catch (FileNotFoundException e) {
            errorMessage = "File " + fileName + " not found";
        } catch (IOException e) {
            errorMessage = "IO Error";
            e.printStackTrace();
        }
        return success;
    }

    public boolean saveToFile(String fileName) {
        boolean success = false;
        errorMessage = "";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            outputToStream(fos);
            success = true;
        } catch (IOException e) {
            errorMessage = "IO Error";
            e.printStackTrace();
        }
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
