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
            SeriesValidator validator = new SeriesValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
//                ui.print(Series.generate(validator.getNumber()));
                ui.print(Series.generate(validator.getNumber(), (i, n) -> i * i <= n));
//                ui.print(Series.generate((long)Math.sqrt(validator.getNumber()), (i, n) -> i <= n));
            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(SeriesHelper.getHelp());
    }
}
