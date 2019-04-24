package handler;

import fastmath.FastMath;
import ui.UserInterface;
import parameters.ParameterList;

public class FastPowerHandler {
    private ParameterList parameterList;
    private UserInterface ui;

    public FastPowerHandler(ParameterList parameterList, UserInterface ui) {
        this.parameterList = parameterList;
        this.ui = ui;
    }

    public void run() {
        if (parameterList.count() == 0) {
            printHelp();
        } else {
            FastPowerValidator validator = new FastPowerValidator(parameterList);
            validator.validate();
            if (validator.isValid()) {
                ui.print("Pow(" + validator.getBase() + ", " + validator.getExponent() + ") = " +
                        FastMath.pow(validator.getBase(), validator.getExponent()));
            } else {
                ui.print(validator.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(FastPowerHelper.getHelp());
    }
}
