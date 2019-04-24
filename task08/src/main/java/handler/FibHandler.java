package handler;

import series.FibSeries;
import ui.UserInterface;
import parameters.ParameterList;

public class FibHandler {
    private ParameterList parameterList;
    private UserInterface ui;

    public FibHandler(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else {
            FibValidator validator = new FibValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                ui.print(FibSeries.generate(
                        validator.getMinValue(),
                        validator.getMaxValue()));
            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(FibHelper.getHelp());
    }
}
