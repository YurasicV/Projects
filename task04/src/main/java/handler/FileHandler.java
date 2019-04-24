package handler;

import content.FileContent;
import ui.UserInterface;
import parameters.ParameterList;

public class FileHandler {
    private ParameterList parameterList;
    private UserInterface ui;

    public FileHandler(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            ui.print(FileHandlerHelper.getHelp());
        } else {
            FileHandlerValidator validator = new FileHandlerValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                processing(validator);
            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void processing(FileHandlerValidator validator) {
        String fileName = validator.getFileName();
        FileContent content = new FileContent(fileName);
        if (!content.load()) {
            ui.print(content.getErrorMessage());
            return;
        }
        String search = validator.getSearch();
        String replace = validator.getReplace();
        if (replace.isEmpty()) {
            ui.print("String \"" + search + "\" has " +
                    content.countOccurrences(search) + " occurences");
        } else {
            content.replaceAll(search, replace);
            ui.print("String \"" + search + "\" has been replaced to " +
                    replace);
            if (!content.save()) {
                ui.print(content.getErrorMessage());
            }
        }
    }
}
