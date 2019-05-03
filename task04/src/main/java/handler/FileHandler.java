package handler;

import file.Content;
import file.ContentService;
import file.FileContentService;
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
            FileHandlerParameterData parameterData = new FileHandlerParameterData(parameterList);
            if (parameterData.isValid()) {
                processing(parameterData);
            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void processing(FileHandlerParameterData parameterData) {
        String fileName = parameterData.getFileName();
        ContentService contentService = new FileContentService(fileName);
        Content content = contentService.read();
        if (content == null) {
            ui.print(contentService.getErrorMessage());
            return;
        }
        String search = parameterData.getSearch();
        String replace = parameterData.getReplace();
        if (replace.isEmpty()) {
            ui.print("String \"" + search + "\" has " +
                    content.countOccurrences(search) + " occurences");
        } else {
            content.replaceAll(search, replace);
            ui.print("String \"" + search + "\" has been replaced to " +
                    replace);
            if (!contentService.write(content)) {
                ui.print(contentService.getErrorMessage());
            }
        }
    }
}
