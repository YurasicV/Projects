package handler;

import parameters.ParameterList;
import parameters.Validator;

public class FibValidator extends Validator {
    private long minValue;
    private long maxValue;

    FibValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidValues();
    }

    long getMinValue() {
        return minValue;
    }

    long getMaxValue() {
        return maxValue;
    }

    private boolean isValidValues() {
        final int PARAM_MIN_INDEX = 0;
        final int PARAM_MAX_INDEX = 1;
        message = "";
        try {
            minValue = Long.valueOf(getParameter(PARAM_MIN_INDEX).toString());
            maxValue = Long.valueOf(getParameter(PARAM_MAX_INDEX).toString());
        } catch (Exception e) {
            message = "Invalid parameters!";
            return false;
        }
        if (minValue <= 0 || maxValue < 0 || minValue > maxValue) {
            message = "Wrong range numbers!";
            return false;
        }
        return true;
    }
}
