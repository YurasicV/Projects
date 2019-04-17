package nested;

import java.util.Comparator;

public class NestedComparator implements Comparator<Nested>{
    public int compare(Nested nested1, Nested nested2) {
        if (nested1.isNestedTo(nested2)) {
            return -1;
        }
        if (nested2.isNestedTo(nested1)) {
            return 1;
        }
        return 0;
    }
}
