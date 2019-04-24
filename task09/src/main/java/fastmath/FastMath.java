package fastmath;

public class FastMath {
    public static long pow(long base, long exponent) {
        long power = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                power *= base;
                exponent--;
            }
            exponent /= 2;
            base *= base;
        }
        return power;
    }
}
