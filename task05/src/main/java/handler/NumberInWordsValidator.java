package handler;

import converter.AbstractLocale;
import parameters.ParameterList;
import parameters.Validator;

public class NumberInWordsValidator extends Validator {
    private long number;
    private AbstractLocale locale;

    NumberInWordsValidator(ParameterList parameterList) {
        super(parameterList);
    }

    @Override
    public void validate() {
        valid = isValidNumber() && isValidLocale();
    }

    long getNumber() {
        return number;
    }

    AbstractLocale getLocale() {
        return locale;
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
        if (number < 0) {
            message = "Non-negative integer number must specified!";
        }
        return true;
    }

    private boolean isValidLocale() {
        final int PARAM_INDEX = 1;
        message = "";
        try {
            locale = LocaleEnum.valueOf(
                    getParameter(PARAM_INDEX).toString().toUpperCase()).getLocale();
        } catch (Exception e) {
            message = "Invalid locale name!";
            return false;
        }
        return true;
    }
}
