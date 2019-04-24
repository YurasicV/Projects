package parameters;

public abstract class Validator {
    private ParameterList parameterList;
    protected String message = "";
    protected boolean valid;

    public Validator(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isValid() {
        return valid;
    }

    public abstract void validate();

    protected Parameter getParameter(int index) throws IndexOutOfBoundsException {
        return parameterList.get(index);
    }
}
