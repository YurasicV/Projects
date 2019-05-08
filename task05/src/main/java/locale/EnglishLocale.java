package locale;

import converter.Locale;

public class EnglishLocale implements Locale {
    private String[][] digit1 = new String[][] {
            {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
            {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
    };
    private String[] digit10 = new String[] {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};
    private String[] digit11 = new String[] {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] digit100 = new String[] {"", "one hundred", "two hundred", "three hundred", "four hundred",
            "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
    private String[][] triads = new String[][] {
            {"", "", "", "0"},
            {"thousand", "thousand", "thousand", "1"},
            {"million", "million", "million", "0"},
            {"billion", "billion", "billion", "0"},
            {"trillion", "trillion", "trillion", "0"},
    };

    @Override
    public String get1(int digit, int gender) {
        return digit1[gender][digit];
    }

    @Override
    public String get10(int digit) {
        return digit10[digit];
    }

    @Override
    public String get11(int digit) {
        return digit11[digit];
    }

    @Override
    public String get100(int digit) {
        return digit100[digit];
    }

    @Override
    public String getTriad(int digit, int triad) {
        if (digit == 1) {
            return triads[triad][0];
        } else if (digit >= 2 && digit <= 4) {
            return triads[triad][1];
        } else {
            return triads[triad][2];
        }
    }

    @Override
    public int getTriadGender(int triad) {
        return Integer.parseInt(triads[triad][3]);
    }
}
