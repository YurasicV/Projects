package parameters;

public class Parameter {
    private String value;

    Parameter(String value) {
        this.value = value.trim().replaceAll("^\"|\"$", "");
    }

    @Override
    public String toString() {
        return value;
    }
}
