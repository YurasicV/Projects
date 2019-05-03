package locale;

import converter.Locale;

public class EnglishLocale extends Locale {
    public EnglishLocale() {
        setDigit1(new String[][] {
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
        });
        setDigit10(new String[] {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety"});
        setDigit11(new String[] {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"});
        setDigit100(new String[] {"", "one hundred", "two hundred", "three hundred", "four hundred",
                "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"});
        setTriads(new String[][] {
                {"", "", "", "0"},
                {"thousand", "thousand", "thousand", "1"},
                {"million", "million", "million", "0"},
                {"billion", "billion", "billion", "0"},
                {"trillion", "trillion", "trillion", "0"},
        });
    }
}