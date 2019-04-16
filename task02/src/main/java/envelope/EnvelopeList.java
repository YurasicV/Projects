package envelope;

import compare.EnvelopesComparator;

import java.util.Collections;
import java.util.LinkedList;

public class EnvelopeList {
    private LinkedList<Envelope> list;

    public EnvelopeList() {
        list = new LinkedList<Envelope>();
    }

    public void addEnvelope(Envelope envelope) {
        list.addLast(envelope);
    }

    public int count() {
        return list.size();
    }

    public Envelope getEnvelope(int index) {
        return ((index >= 0) && (index < list.size())) ? list.get(index) : null;
    }

    public void clear() {
        list.clear();
    }

    public void sort() {
        Collections.sort(list, new EnvelopesComparator());
    }
}
