import console.EnvelopeReader;
import console.Writer;
import handle.NestedHandle;

public class EnvelopesApp {
    public static void main(String[] args) {
        Writer writer = new Writer();
        EnvelopeReader envelopeReader = new EnvelopeReader(writer);
        NestedHandle nestedHandle = new NestedHandle(envelopeReader, writer);
        nestedHandle.run();
    }
}
