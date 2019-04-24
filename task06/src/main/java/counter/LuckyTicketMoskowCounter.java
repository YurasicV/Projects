package counter;

public class LuckyTicketMoskowCounter extends LuckyTicketCounter {
    @Override
    protected boolean isLucky(int[] digits) {
        return (digits[0] + digits[1]+ digits[2]) == (digits[3] + digits[4] + digits[5]);
    }
}
