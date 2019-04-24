package parameters;

import java.util.ArrayList;

public class ParameterList extends ArrayList<Parameter> {
    private ArrayList<Parameter> list;

    public ParameterList(String[] args) {
        initList(args);
    }

    public ParameterList(String argsStr, String delimiter) {
        String[] args = argsStr.split(delimiter);
        initList(args);
    }

    public ParameterList(String argsStr) {
        this(argsStr, " ");
    }

    public int count() {
        return list.size();
    }

    public Parameter get(int index) throws IndexOutOfBoundsException {
        return list.get(index);
    }

    private void initList(String[] args) {
        list = new ArrayList<>();
        for (String arg: args) {
            list.add(new Parameter(arg));
        }
    }
}
