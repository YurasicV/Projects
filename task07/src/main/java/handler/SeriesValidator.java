package handler;

import parameters.ParameterList;
import parameters.Validator;

public class SeriesValidator extends Validator {
    private long number;

    SeriesValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidNumber();
    }

    long getNumber() {
        return number;
    }

    private boolean isValidNumber() {
        final int PARAM_INDEX = 0;
        message = "";
        try {
            number = Long.valueOf(getParameter(PARAM_INDEX).toString());
        } catch (Exception e) {
            message = "Invalid number!";
            return false;
        }
        if (number <= 0) {
            message = "Wrong natural number!";
            return false;
        }
        return true;
    }
}
