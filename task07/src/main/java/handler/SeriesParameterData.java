package handler;

import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class SeriesParameterData extends ParameterData {
    private long number;

    SeriesParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertNumber();
    }

    long getNumber() {
        return number;
    }

    private void convertNumber() throws ParameterConversionException {
        final int PARAM_INDEX = 0;
        try {
            number = Long.valueOf(getParameter(PARAM_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid number!");
        }
        if (number <= 0) {
            throw  new ParameterConversionException("Wrong natural number!");
        }
    }
}
