package nested;

import java.util.Collections;
import java.util.LinkedList;

public class NestedList {
    private LinkedList<Nested> list;

    public NestedList() {
        list = new LinkedList<Nested>();
    }

    public void add(Nested nested) {
        list.addLast(nested);
    }

    public int count() {
        return list.size();
    }

    public Nested get(int index) {
        return ((index >= 0) && (index < list.size())) ? list.get(index) : null;
    }

    public void clear() {
        list.clear();
    }

    public void sort() {
        Collections.sort(list, new NestedComparator());
    }
}
