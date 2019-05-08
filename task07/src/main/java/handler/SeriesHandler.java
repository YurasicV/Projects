package handler;

import series.Series;
import ui.UserInterface;
import parameters.ParameterList;

public class SeriesHandler {
    private ParameterList parameterList;
    private UserInterface ui;

    public SeriesHandler(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else {
            SeriesParameterData parameterData = new SeriesParameterData(parameterList);
            if (parameterData.isValid()) {
                ui.print(Series.generate(parameterData.getNumber()));
            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(SeriesHelper.getHelp());
    }
}
