import handler.LuckyTicketHandler;
import ui.ConsoleInterface;

public class LuckyTicketApp {
    public static void main(String[] args) {
        LuckyTicketHandler luckyTicketHandler =
                new LuckyTicketHandler(new ConsoleInterface());
        luckyTicketHandler.run();
    }
}
