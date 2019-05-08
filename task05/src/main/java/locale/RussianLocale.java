package locale;

import converter.Locale;

public class RussianLocale implements Locale {
    private String[][] digit1 = new String[][] {
            {"ноль","один","два","три","четыре","пять","шесть","семь","восемь","девять"},
            {"ноль","одна","две","три","четыре","пять","шесть","семь","восемь","девять"},
    };
    private String[] digit10 = new String[] {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private String[] digit11 = new String[] {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private String[] digit100 = new String[] {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private String[][] triads = new String[][] {
            {"", "", "", "0"},
            {"тысяча", "тысячи", "тысяч", "1"},
            {"миллион", "миллиона", "миллионов", "0"},
            {"миллиард", "миллиарда", "миллиардов", "0"},
            {"триллион", "триллиона", "триллионов", "0"},
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
