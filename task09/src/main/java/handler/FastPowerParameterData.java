package handler;

import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class FastPowerParameterData extends ParameterData {
    private long base;
    private long exponent;

    FastPowerParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertBaseAndExponent();
    }

    long getBase() {
        return base;
    }

    long getExponent() {
        return exponent;
    }

    private void convertBaseAndExponent() throws ParameterConversionException {
        final int PARAM_BASE_INDEX = 0;
        final int PARAM_EXPONENT_INDEX = 1;
        try {
            base = Long.valueOf(getParameter(PARAM_BASE_INDEX).toString());
            exponent = Long.valueOf(getParameter(PARAM_EXPONENT_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid base or exponent number!");
        }
        if (base <= 0 || exponent <= 0) {
            throw new ParameterConversionException("Base and exponent numbers must be positive!");
        }
    }
}
