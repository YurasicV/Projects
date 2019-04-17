package builder;

import console.Writer;
import parameters.ParameterList;

public abstract class BoardBuilder {
    ParameterList parameterList;
    Writer writer;

    BoardBuilder(ParameterList parameterList, Writer writer) {
        this.parameterList = parameterList;
        this.writer = writer;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else if (isValidParameters()) {
            buildBoard();
        } else {
            printError();
        }
    }

    public abstract boolean isValidParameters();
    public abstract void buildBoard();
    public abstract void printHelp();
    public abstract void printError();
}
