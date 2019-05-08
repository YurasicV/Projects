package series;

import java.util.ArrayList;
import java.util.List;

public class FibSeries {
    public static String generate(long minValue, long maxValue) {
        List<String> list = new ArrayList<>();
        long valueA = 0;
        long valueB = 1;
        while (valueB <= maxValue) {
            if (valueB >= minValue) {
                list.add(String.valueOf(valueB));
            }
            valueB = valueA + valueB;
            valueA = valueB - valueA;
        }
        return String.join(",", list);
    }
}
