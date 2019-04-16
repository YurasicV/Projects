package parameters;

import java.util.LinkedList;

/*
Class parses parameter's string and allows to get each parameter
 */
public class ParameterList {
    private LinkedList<Parameter> list;
    private int index;

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

    public Parameter getNextParameter() {
        return ((index >= 0) && (index < list.size())) ? list.get(index++) : null;
    }

    public void init() {
        index = 0;
    }

    private void initList(String[] args) {
        init();
        list = new LinkedList<Parameter>();
        for (String arg: args) {
            list.addLast(new Parameter(arg.trim()));
        }
    }
}
