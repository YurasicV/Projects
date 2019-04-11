package validator;

/*
Class for input parameters validation and parsing
 */
public class Validator {
    private CheckStatus checkStatus;
    private int param1;
    private int param2;

    public Validator() {
        checkStatus = CheckStatus.NOT_CHECKED;
    }

    public String getCheckStatusMessage() {
        return checkStatus.getMessage();
    }

    public int getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public boolean isValidate(String[] args) {
        tryToParseParameters(args);
        return checkStatus == CheckStatus.VALID;
    }

    private void tryToParseParameters(String[] args) {
        final int NUMBER_OF_PARAMS = 2;

        param1 = 0;
        param2 = 0;
        checkStatus = CheckStatus.NOT_CHECKED;

        if (args.length == 0) {
            checkStatus = CheckStatus.NO_PARAMS;
        } else if (args.length != NUMBER_OF_PARAMS) {
            checkStatus = CheckStatus.WRONG_NUMBER_OF_PARAMS;
        } else if (!isInteger(args[0])) {
            checkStatus = CheckStatus.WRONG_PARAM_1;
        } else if (!isInteger(args[1])) {
            checkStatus = CheckStatus.WRONG_PARAM_2;
        } else {
            param1 = Integer.parseInt(args[0]);
            param2 = Integer.parseInt(args[1]);
            checkStatus = CheckStatus.VALID;
        }
    }

    // method checks can string be transformed to integer
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
