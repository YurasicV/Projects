package locale;

import converter.Locale;

public class UkrainianLocale implements Locale {
    private String[][] digit1 = new String[][] {
            {"ноль","один","два","три","чотири","п'ять","шість","сім","вісім","дев'ять"},
            {"ноль","одна","дві","три","чотири","п'ять","шість","сім","вісім","дев'ять"},
    };
    private String[] digit10 = new String[] {"", "десять", "двадцять", "тридцять", "сорок", "п'ятдесят",
            "шістдесят", "сімдесят", "вісімдесят", "дев'яносто"};
    private String[] digit11 = new String[] {"", "одинадцять", "дванадцять", "тринадцять", "чотирнадцять",
            "п'ятнадцять", "шістнадцять", "сімнадцять", "вісімнадцять", "дев'ятнадцять"};
    private String[] digit100 = new String[] {"", "сто", "двісті", "триста", "чотириста", "п'ятсот",
            "шістсот", "сімсот", "вісімсот", "дев'ятсот"};
    private String[][] triads = new String[][] {
            {"", "", "", "0"},
            {"тисяча", "тисячи", "тисяч", "1"},
            {"мільйон", "мільйона", "мільйонів", "0"},
            {"мільярд", "мільярда", "мільярдів", "0"},
            {"трильйон", "трильйона", "трильйонів", "0"},
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