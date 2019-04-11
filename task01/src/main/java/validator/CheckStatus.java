package validator;

enum CheckStatus {
    NOT_CHECKED("Parameters are not checked"),
    VALID("Parameters are correct"),
    NO_PARAMS("You must specify two integer parameters: rows and cols number"),
    WRONG_NUMBER_OF_PARAMS("Wrong number of parameters"),
    WRONG_PARAM_1("First parameter must be integer (rows number)"),
    WRONG_PARAM_2("Second parameter must be integer (cols number)");

    private String checkStatusMessage;

    private CheckStatus(String checkStatusMessage) {
        this.checkStatusMessage = checkStatusMessage;
    }

    public String getMessage(){
        return checkStatusMessage;
    }
}
