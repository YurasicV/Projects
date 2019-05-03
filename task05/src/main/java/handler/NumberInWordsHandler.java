package handler;

import converter.NumberInWordsConverter;
import ui.UserInterface;
import parameters.ParameterList;

public class NumberInWordsHandler {
    private ParameterList parameterList;
    private UserInterface ui;

    public NumberInWordsHandler(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else {
            NumberInWordsParameterData parameterData = new NumberInWordsParameterData(parameterList);
            if (parameterData.isValid()) {
                ui.print(NumberInWordsConverter.convert(
                        parameterData.getNumber(),
                        parameterData.getLocale()));
            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(NumberInWordsHelper.getHelp());
    }
}
