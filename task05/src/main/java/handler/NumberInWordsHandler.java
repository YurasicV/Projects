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
            NumberInWordsValidator validator = new NumberInWordsValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                ui.print(NumberInWordsConverter.convert(
                        validator.getNumber(),
                        validator.getLocale()));
            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(NumberInWordsHelper.getHelp());
    }
}
