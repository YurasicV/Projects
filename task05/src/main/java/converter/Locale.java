package converter;

public abstract class Locale {
    private String[][] digit1;
    private String[] digit10;
    private String[] digit11;
    private String[] digit100;
    private String[][] triads;

    String get1(int digit, int gender) {
        return digit1[gender][digit];
    }

    String get10(int digit) {
        return digit10[digit];
    }

    String get11(int digit) {
        return digit11[digit];
    }

    String get100(int digit) {
        return digit100[digit];
    }

    String getTriad(int digit, int triad) {
        if (digit == 1) {
            return triads[triad][0];
        } else if (digit >= 2 && digit <= 4) {
            return triads[triad][1];
        } else {
            return triads[triad][2];
        }
    }

    int getTriadGender(int triad) {
        return Integer.parseInt(triads[triad][3]);
    }

    protected void setDigit1(String[][] digit1) {
        this.digit1 = digit1;
    }

    protected void setDigit10(String[] digit10) {
        this.digit10 = digit10;
    }

    protected void setDigit11(String[] digit11) {
        this.digit11 = digit11;
    }

    protected void setDigit100(String[] digit100) {
        this.digit100 = digit100;
    }

    protected void setTriads(String[][] triads) {
        this.triads = triads;
    }
}
