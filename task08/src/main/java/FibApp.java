import handler.FibHandler;
import parameters.ParameterList;
import ui.ConsoleInterface;

public class FibApp {
    public static void main(String[] args) {
        FibHandler fibHandler = new FibHandler(
                new ParameterList(args),
                new ConsoleInterface());
        fibHandler.run();
    }
}
