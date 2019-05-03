package locale;

import converter.Locale;

public class UkrainianLocale extends Locale {
    public UkrainianLocale() {
        setDigit1(new String[][] {
                {"ноль","один","два","три","чотири","п'ять","шість","сім","вісім","дев'ять"},
                {"ноль","одна","дві","три","чотири","п'ять","шість","сім","вісім","дев'ять"},
        });
        setDigit10(new String[] {"", "десять", "двадцять", "тридцять", "сорок", "п'ятдесят",
                "шістдесят", "сімдесят", "вісімдесят", "дев'яносто"});
        setDigit11(new String[] {"", "одинадцять", "дванадцять", "тринадцять", "чотирнадцять",
                "п'ятнадцять", "шістнадцять", "сімнадцять", "вісімнадцять", "дев'ятнадцять"});
        setDigit100(new String[] {"", "сто", "двісті", "триста", "чотириста", "п'ятсот",
                "шістсот", "сімсот", "вісімсот", "дев'ятсот"});
        setTriads(new String[][] {
                {"", "", "", "0"},
                {"тисяча", "тисячи", "тисяч", "1"},
                {"мільйон", "мільйона", "мільйонів", "0"},
                {"мільярд", "мільярда", "мільярдів", "0"},
                {"трильйон", "трильйона", "трильйонів", "0"},
        });
    }
}