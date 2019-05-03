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
            FibParameterData parameterData = new FibParameterData(parameterList);
            if (parameterData.isValid()) {
                ui.print(FibSeries.generate(
                        parameterData.getMinValue(),
                        parameterData.getMaxValue()));
            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(FibHelper.getHelp());
    }
}
