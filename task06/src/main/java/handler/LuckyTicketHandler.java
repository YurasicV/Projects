package handler;

import content.DataContent;
import content.FileContent;
import ui.UserInterface;

public class LuckyTicketHandler {
    private UserInterface ui;

    public LuckyTicketHandler(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        String fileName = ui.readString("Enter full file name: ");   // src/main/resources/method.txt
        FileContent content = new FileContent(fileName);
        if (content.load()) {
            ui.print(getCountingResult(content));
        } else {
            ui.print(content.getErrorMessage());
        }
    }

    private String getCountingResult(DataContent content) {
        for (LuckyTicketEnum luckyTicketEnum: LuckyTicketEnum.values()) {
            if (content.isContained(luckyTicketEnum.toString())) {
                return "Amount of " + luckyTicketEnum + " lucky tickets is " +
                        luckyTicketEnum.getCounter().count();
            }
        }
        return "Counting method is not specified!";
    }
}
