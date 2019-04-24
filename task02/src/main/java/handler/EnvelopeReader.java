package handler;

import ui.UserInterface;
import nested.Envelope;
import nested.Nested;

public class EnvelopeReader implements NestedReader {
    private UserInterface ui;

    public EnvelopeReader(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public Nested read(int index) {
        ui.print("\nEnvelope " + index + "\n-----------\n");
        double sizeA = ui.readPositiveDouble("Input size a : ");
        double sizeB = ui.readPositiveDouble("Input size b : ");
        return new Envelope(index, sizeA, sizeB);
    }
}
