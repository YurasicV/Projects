package series;

import java.util.LinkedList;
import java.util.List;

public class Series {
    public static String generateMethod1(long number) {
        return generateWithCondition(number, (i, n) -> i * i <= n);
    }

    public static String generateMethod2(long number) {
        return generateWithCondition((long)Math.sqrt(number), (i, n) -> i <= n);
    }

    private static String generateWithCondition(long number, Condition condition) {
        List<Long> list = new LinkedList<>();
        for (long i = 1; condition.checked(i, number); i++) {
            list.add(i);
        }
        return list.toString();
    }
}
