import handler.SeriesHandler;
import parameters.ParameterList;
import ui.ConsoleInterface;

public class SeriesApp {
    public static void main(String[] args) {
        SeriesHandler seriesHandler = new SeriesHandler(
                new ParameterList(args),
                new ConsoleInterface());
        seriesHandler.run();
    }
}
