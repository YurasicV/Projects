package handler;

import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class FibParameterData extends ParameterData {
    private long minValue;
    private long maxValue;

    FibParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertValues();
    }

    long getMinValue() {
        return minValue;
    }

    long getMaxValue() {
        return maxValue;
    }

    private void convertValues() throws ParameterConversionException {
        final int PARAM_MIN_INDEX = 0;
        final int PARAM_MAX_INDEX = 1;
        try {
            minValue = Long.valueOf(getParameter(PARAM_MIN_INDEX).toString());
            maxValue = Long.valueOf(getParameter(PARAM_MAX_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid parameters!");
        }
        if (minValue <= 0 || maxValue < 0 || minValue > maxValue) {
            throw new ParameterConversionException("Wrong range numbers!");
        }
    }
}
