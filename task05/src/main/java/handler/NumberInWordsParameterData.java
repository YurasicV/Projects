package handler;

import converter.Locale;
import converter.LocaleEnum;
import parameters.ParameterConversionException;
import parameters.ParameterData;
import parameters.ParameterList;

public class NumberInWordsParameterData extends ParameterData {
    private long number;
    private Locale locale;

    NumberInWordsParameterData(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    protected void convert() throws ParameterConversionException {
        convertNumber();
        convertLocale();
    }

    long getNumber() {
        return number;
    }

    Locale getLocale() {
        return locale;
    }

    private void convertNumber() throws ParameterConversionException {
        final int PARAM_INDEX = 0;
        try {
            number = Long.valueOf(getParameter(PARAM_INDEX).toString());
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid number!");
        }
        if (number < 0) {
            throw new ParameterConversionException("Non-negative integer number must specified!");
        }
    }

    private void convertLocale() throws ParameterConversionException {
        final int PARAM_INDEX = 1;
        try {
            locale = LocaleEnum.valueOf(
                    getParameter(PARAM_INDEX).toString().toUpperCase()).getLocale();
        } catch (Exception e) {
            throw new ParameterConversionException("Invalid locale name!");
        }
    }
}
