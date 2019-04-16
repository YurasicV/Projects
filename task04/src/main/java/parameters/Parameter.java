package parameters;

/*
Class describes a parameter and transforms it to different types
 */
public class Parameter {
    private String value;

    public Parameter(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public Integer toInteger() throws NumberFormatException{
        return Integer.valueOf(value);
    }

    public Double toDouble() throws NumberFormatException{
        return Double.valueOf(value);
    }
}
