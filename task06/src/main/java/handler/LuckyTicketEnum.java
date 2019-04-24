package handler;

import counter.LuckyTicketCounter;
import counter.LuckyTicketMoskowCounter;
import counter.LuckyTicketPiterCounter;

public enum LuckyTicketEnum {
    MOSKOW, PITER;

    public LuckyTicketCounter getCounter() {
        switch (this) {
            case MOSKOW: return new LuckyTicketMoskowCounter();
            default: return new LuckyTicketPiterCounter();
        }
    }
}
