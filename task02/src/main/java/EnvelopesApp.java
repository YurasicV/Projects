import handler.EnvelopeReader;
import handler.NestedHandler;
import ui.ConsoleInterface;

public class EnvelopesApp {
    public static void main(String[] args) {
        final int MAX_ENVELOPES_COUNT = 2;
        ConsoleInterface console = new ConsoleInterface();
        EnvelopeReader envelopeReader = new EnvelopeReader(console);

        NestedHandler nestedHandler = new NestedHandler(MAX_ENVELOPES_COUNT,
                envelopeReader, console);
        nestedHandler.run();
    }
}
