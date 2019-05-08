package series;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Series {
    public static String generate(long number) {
        return LongStream.rangeClosed(1, (long) Math.sqrt(number))
                .mapToObj(Long::toString)
                .collect(Collectors.joining(","));
    }
}
