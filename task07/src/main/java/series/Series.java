package series;

public class Series {
    public static String generate(long number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long i = 1; i * i <= number; i++) {
            if (i > 1) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static String generate(long number, Condition condition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long i = 1; condition.checked(i, number); i++) {
            if (i > 1) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
