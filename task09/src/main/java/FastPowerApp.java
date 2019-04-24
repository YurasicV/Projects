import handler.FastPowerHandler;
import parameters.ParameterList;
import ui.ConsoleInterface;

public class FastPowerApp {
    public static void main(String[] args) {
        FastPowerHandler fastPowerHandler = new FastPowerHandler(
                new ParameterList(args),
                new ConsoleInterface());
        fastPowerHandler.run();
    }
}
