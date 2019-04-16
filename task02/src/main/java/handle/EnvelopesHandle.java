package handle;

import console.EnvelopeReader;
import console.Writer;
import envelope.Envelope;
import envelope.EnvelopeList;

public class EnvelopesHandle {
    private final int MAX_ENVELOPES_COUNT = 2;
    private EnvelopeReader envelopeReader;
    private Writer writer;
    private EnvelopeList envelopeList;

    public EnvelopesHandle(EnvelopeReader envelopeReader, Writer writer) {
        this.envelopeReader = envelopeReader;
        this.writer = writer;
        envelopeList = new EnvelopeList();
    }

    public void run() {
        do {
            inputEnvelops();
            envelopeList.sort();
            writer.print(getCompareResult());
        } while (envelopeReader.isOneMoreTime());
    }

    private void inputEnvelops() {
        envelopeList.clear();
        for (int i = 0; i < MAX_ENVELOPES_COUNT; i++) {
            envelopeList.addEnvelope(envelopeReader.readEnvelope(
                    envelopeList.count()+1));
        }
    }

    private String getCompareResult() {
        Envelope envelope1;
        Envelope envelope2;
        StringBuilder result = new StringBuilder("Comparison result:\n");
        for (int i = 0; i < MAX_ENVELOPES_COUNT; i++) {
            envelope1 = envelopeList.getEnvelope(i);
            for (int j = (i + 1); j < MAX_ENVELOPES_COUNT; j++) {
                envelope2 = envelopeList.getEnvelope(j);
                if (envelope1.isNestedTo(envelope2)) {
                    result.append(envelope1).append(" can be nested into ");
                    result.append(envelope2).append("\n");
                } else {
                    result.append(envelope1).append(" and ").append(envelope2);
                    result.append(" cannot be nested into each other\n");
                }
            }
        }
        return result.toString();
    }
}
