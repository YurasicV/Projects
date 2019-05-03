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
            FastPowerParameterData parameterData = new FastPowerParameterData(parameterList);
            if (parameterData.isValid()) {
                ui.print("Pow(" + parameterData.getBase() + ", " + parameterData.getExponent() + ") = " +
                        FastMath.pow(parameterData.getBase(), parameterData.getExponent()));
            } else {
                ui.print(parameterData.getMessage());
            }
        }
    }

    private void printHelp() {
        ui.print(FastPowerHelper.getHelp());
    }
}
