package parameters;

public abstract class ParameterData {
    private ParameterList parameterList;
    private String message = "";
    private boolean valid;

    public ParameterData(ParameterList parameterList) {
        this.parameterList = parameterList;
        this.valid = getValid();
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    protected Parameter getParameter(int index) throws IndexOutOfBoundsException {
        return parameterList.get(index);
    }

    protected abstract void convert() throws ParameterConversionException;

    private boolean getValid() {
        try {
            convert();
            return true;
        } catch (ParameterConversionException e) {
            message = e.getMessage();
            return false;
        }
    }
}
