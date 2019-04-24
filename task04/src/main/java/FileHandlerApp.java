import ui.ConsoleInterface;
import parameters.ParameterList;
import handler.FileHandler;

public class FileHandlerApp {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler(
                new ParameterList(args),
                new ConsoleInterface());
        fileHandler.run();
    }
}
