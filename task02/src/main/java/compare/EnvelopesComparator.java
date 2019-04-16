package compare;

import envelope.Envelope;

import java.util.Comparator;

/*
Class compares two envelopes
 */
public class EnvelopesComparator implements Comparator<Envelope>{
    public int compare(Envelope envelope1, Envelope envelope2) {
        if (envelope1.isNestedTo(envelope2)) {
            return -1;
        }
        if (envelope2.isNestedTo(envelope1)) {
            return 1;
        }
        return 0;
    }
}
