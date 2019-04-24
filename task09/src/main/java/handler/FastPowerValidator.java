package handler;

import parameters.ParameterList;
import parameters.Validator;

public class FastPowerValidator extends Validator {
    private long base;
    private long exponent;

    FastPowerValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidBaseAndExponent();
    }

    long getBase() {
        return base;
    }

    long getExponent() {
        return exponent;
    }

    private boolean isValidBaseAndExponent() {
        final int PARAM_BASE_INDEX = 0;
        final int PARAM_EXPONENT_INDEX = 0;
        message = "";
        try {
            base = Long.valueOf(getParameter(PARAM_BASE_INDEX).toString());
            exponent = Long.valueOf(getParameter(PARAM_EXPONENT_INDEX).toString());
        } catch (Exception e) {
            message = "Invalid base or exponent number!";
            return false;
        }
        if (base <= 0 || exponent <= 0) {
            message = "Base and exponent numbers must be positive!";
            return false;
        }
        return true;
    }
}
