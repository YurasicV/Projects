package parser;

import console.Writer;
import handler.FileHandler;
import parameters.ParameterList;

public class FileParser {
    private ParameterList parameterList;
    private FileHandler fileHandler;
    private Writer writer;

    public FileParser(ParameterList parameterList, FileHandler fileHandler,
                      Writer writer) {
        this.parameterList = parameterList;
        this.fileHandler = fileHandler;
        this.writer = writer;
    }

    public void run() {
        final int PARAM_COUNT_MODE_1 = 2;
        final int PARAM_COUNT_MODE_2 = 3;
        int parameterCount = parameterList.count();
        if (parameterCount == PARAM_COUNT_MODE_1) {
            runMode1();
        } else if (parameterCount == PARAM_COUNT_MODE_2) {
            runMode2();
        } else {
            writer.print(FileParserHelper.getHelp());
        }
    }

    private void runMode1() {
        parameterList.init();
        String fileName = parameterList.getNextParameter().toString();
        String search = parameterList.getNextParameter().toString();
        if (handle(fileHandler.loadFromFile(fileName))) {
            writer.print("String \"" + search + "\" has " +
                    fileHandler.countOccurrences(search) + " occurences");
            handle(fileHandler.saveToFile(fileName));
        }
    }

    private void runMode2() {
        parameterList.init();
        String fileName = parameterList.getNextParameter().toString();
        String search = parameterList.getNextParameter().toString();
        String replace = parameterList.getNextParameter().toString();
        if (handle(fileHandler.loadFromFile(fileName))) {
            fileHandler.replaceAll(search, replace);
            writer.print("String \"" + search + "\" has been replaced to " +
                    replace);
            handle(fileHandler.saveToFile(fileName));
        }
    }

    private boolean handle(boolean state) {
        if (!state) {
            writer.print(fileHandler.getErrorMessage());
        }
        return state;
    }
}
