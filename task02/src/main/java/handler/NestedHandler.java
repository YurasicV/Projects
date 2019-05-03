package handler;

import ui.UserInterface;
import nested.Nested;
import java.util.ArrayList;
import java.util.List;

public class NestedHandler {
    private int nestedCount;
    private NestedReader nestedReader;
    private UserInterface ui;
    private List<Nested> nestedList;

    public NestedHandler(int nestedCount, NestedReader nestedReader, UserInterface ui) {
        this.nestedCount = nestedCount;
        this.nestedReader = nestedReader;
        this.ui = ui;
        nestedList = new ArrayList<>();
    }

    public void run() {
        do {
            inputNestedList();
            ui.print(getNestedResult());
        } while (ui.isContinued());
    }

    private void inputNestedList() {
        nestedList.clear();
        for (int i = 0; i < nestedCount; i++) {
            nestedList.add(nestedReader.read(nestedList.size() + 1));
        }
    }

    private String getNestedResult() {
        Nested nested1;
        Nested nested2;
        StringBuilder result = new StringBuilder("\nComparison result:\n");
        for (int i = 0; i < nestedList.size() - 1; i++) {
            nested1 = nestedList.get(i);
            for (int j = (i + 1); j < nestedList.size(); j++) {
                nested2 = nestedList.get(j);
                if (nested1.isNestedTo(nested2)) {
                    result.append(nested1).append(" can be nested into ");
                    result.append(nested2).append('\n');
                } else if (nested2.isNestedTo(nested1)) {
                    result.append(nested2).append(" can be nested into ");
                    result.append(nested1).append('\n');
                } else {
                    result.append(nested1).append(" and ").append(nested2);
                    result.append(" cannot be nested into each other\n");
                }
            }
        }
        return result.toString();
    }
}
