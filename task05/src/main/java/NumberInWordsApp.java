import handler.NumberInWordsHandler;
import ui.ConsoleInterface;
import parameters.ParameterList;

public class NumberInWordsApp {
    public static void main(String[] args) {
        NumberInWordsHandler numberInWordsHandler = new NumberInWordsHandler(
                new ParameterList(args),
                new ConsoleInterface());
        numberInWordsHandler.run();
    }
}
