import console.EnvelopeReader;
import console.Writer;
import handle.EnvelopesHandle;

public class EnvelopesApp {
    public static void main(String[] args) {
        Writer writer = new Writer();
        EnvelopeReader envelopeReader = new EnvelopeReader(writer);
        EnvelopesHandle envelopesHandle = new EnvelopesHandle(envelopeReader, writer);
        envelopesHandle.run();
    }
}
