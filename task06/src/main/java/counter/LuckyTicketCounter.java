package counter;

public abstract class LuckyTicketCounter {
    public int count() {
        int MIN_NUMBER = 0;
        int MAX_NUMBER = 999999;
        int counter = 0;
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            if (isLucky(numberToDigits(number))) {
                counter++;
            }
        }
        return counter;
    }

    private int[] numberToDigits(int number) {
        int[] digits = new int[6];
        digits[0] = number / 100000;
        digits[1] = (number / 10000) % 10;
        digits[2] = (number / 1000) % 10;
        digits[3] = (number / 100) % 10;
        digits[4] = (number / 10) % 10;
        digits[5] = number % 10;
        return digits;
    }

    protected abstract boolean isLucky(int[] digits);
}
