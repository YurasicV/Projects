package counter;

public class LuckyTicketPiterCounter extends LuckyTicketCounter {
    @Override
    protected boolean isLucky(int[] digits) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int digit: digits) {
            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
        }
        return (sumEven == sumOdd);
    }
}
