package console;

import nested.Envelope;
import nested.Nested;

public class EnvelopeReader extends NestedReader {

    public EnvelopeReader(Writer writer) {
        super(writer);
    }

    public Nested read(int index) {
        writer.print("\nEnvelope " + index + "\n-----------\n");
        double sizeA = readSize("Input size a : ");
        double sizeB = readSize("Input size b : ");
        return new Envelope(index, sizeA, sizeB);
    }
}
