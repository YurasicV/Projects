package handler;

import file.Content;
import file.ContentService;
import file.FileContentService;
import ui.UserInterface;

public class LuckyTicketHandler {
    private UserInterface ui;

    public LuckyTicketHandler(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {
        String fileName = ui.readString("Enter full file name: ");   // src/main/resources/method.txt
        ContentService contentService = new FileContentService(fileName);
        Content content = contentService.read();
        if (content != null) {
            ui.print(getCountingResult(content));
        } else {
            ui.print(contentService.getErrorMessage());
        }
    }

    private String getCountingResult(Content content) {
        for (LuckyTicketEnum luckyTicketEnum: LuckyTicketEnum.values()) {
            if (content.contains(luckyTicketEnum.toString())) {
                return "Amount of " + luckyTicketEnum + " lucky tickets is " +
                        luckyTicketEnum.getCounter().count();
            }
        }
        return "Counting method is not specified!";
    }
}
