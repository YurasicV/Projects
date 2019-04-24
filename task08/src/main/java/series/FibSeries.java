package series;

public class FibSeries {
    public static String generate(long minValue, long maxValue) {
        StringBuilder stringBuilder = new StringBuilder();
        long valueA = 0;
        long valueB = 1;
        while (valueB <= maxValue) {
            if (valueB >= minValue) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(valueB);
            }
            valueB = valueA + valueB;
            valueA = valueB - valueA;
        }
        return stringBuilder.toString();
    }
}
