package counter;

public class LuckyTicketPiterCounter extends LuckyTicketCounter {
    @Override
    protected boolean isLucky(int[] digits) {
        return (digits[0] + digits[2]+ digits[4]) == (digits[1] + digits[3] + digits[5]);
    }
}
