package series;

import java.util.LinkedList;
import java.util.List;

public class FibSeries {
    public static String generate(long minValue, long maxValue) {
        List<Long> list = new LinkedList<>();
        long valueA = 0;
        long valueB = 1;
        while (valueB <= maxValue) {
            if (valueB >= minValue) {
                list.add(valueB);
            }
            valueB = valueA + valueB;
            valueA = valueB - valueA;
        }
        return list.toString();
    }
}
