package console;

import envelope.Envelope;
import java.util.Scanner;

/*
Class allows to read data of envelopes
 */
public class EnvelopeReader {
    private Scanner in;
    private Writer writer;

    public EnvelopeReader(Writer writer) {
        this.writer = writer;
        in = new Scanner(System.in);
    }

    public Envelope readEnvelope(int index) {
        writer.print("\nEnvelope " + index + "\n-----------\n");
        double sizeA = readSize("Input size a : ");
        double sizeB = readSize("Input size b : ");
        return new Envelope(index, sizeA, sizeB);
    }

    public boolean isOneMoreTime() {
        writer.print("\nDo you want to continue? (Yes/No) : ");
        String strAnswer = in.next().toUpperCase();
        return strAnswer.equals("Y") || strAnswer.equals("YES");
    }

    private double readSize(String label) {
        double size = 0;
        boolean readError = true;
        writer.print(label);
        while (readError) {
            readError = false;
            try {
                size = in.nextDouble();
            } catch (Exception e) {
                readError = true;
                writer.print("Invalid number! Try again : ");
                in.next();
                continue;
            }
            if (size <= 0) {
                readError = true;
                writer.print("Not a positive number! Try again : ");
            }
        }
        return size;
    }
}
