package handle;

import console.NestedReader;
import console.Writer;
import nested.Nested;
import nested.NestedList;

public class NestedHandle {
    private final int MAX_NESTED_COUNT = 2;
    private NestedReader nestedReader;
    private Writer writer;
    private NestedList nestedList;

    public NestedHandle(NestedReader nestedReader, Writer writer) {
        this.nestedReader = nestedReader;
        this.writer = writer;
        nestedList = new NestedList();
    }

    public void run() {
        do {
            inputNestedList();
            nestedList.sort();
            writer.print(getCompareResult());
        } while (nestedReader.isOneMore());
    }

    private void inputNestedList() {
        nestedList.clear();
        for (int i = 0; i < MAX_NESTED_COUNT; i++) {
            nestedList.add(nestedReader.read(nestedList.count()+1));
        }
    }

    private String getCompareResult() {
        Nested nested1;
        Nested nested2;
        StringBuilder result = new StringBuilder("Comparison result:\n");
        for (int i = 0; i < MAX_NESTED_COUNT; i++) {
            nested1 = nestedList.get(i);
            for (int j = (i + 1); j < MAX_NESTED_COUNT; j++) {
                nested2 = nestedList.get(j);
                if (nested1.isNestedTo(nested2)) {
                    result.append(nested1).append(" can be nested into ");
                    result.append(nested2).append("\n");
                } else {
                    result.append(nested1).append(" and ").append(nested2);
                    result.append(" cannot be nested into each other\n");
                }
            }
        }
        return result.toString();
    }
}
