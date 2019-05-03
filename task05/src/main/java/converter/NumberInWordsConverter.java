package converter;

public class NumberInWordsConverter {

    public static String convert(long number, Locale locale) {
        if (number < 0) {
            return "";
        }

        StringBuilder inWords = new StringBuilder();
        int triad = 0;
        do {
            appendTriadNumberInWords(inWords, locale, (int) (number % 1000), triad++);
            number /= 1000;
        } while (number > 0);

        return inWords.toString();
    }

    private static void appendTriadNumberInWords(StringBuilder inWords,
                                                 Locale locale, int triadNumber, int triad) {
        if (triadNumber == 0 && triad > 0) {
            return;
        }

        int hundreds = triadNumber / 100;
        int tens = (triadNumber / 10) % 10;
        int ones = triadNumber % 10;
        int triadGender = locale.getTriadGender(triad);

        appendWord(inWords, locale.getTriad(ones, triad));
        if (tens == 1) {
            appendWord(inWords, locale.get11(ones));
        } else {
            appendWord(inWords, locale.get1(ones, triadGender));
            appendWord(inWords, locale.get10(tens));
        }
        appendWord(inWords, locale.get100(hundreds));
    }

    private static void appendWord(StringBuilder inWords, String word) {
        if (!word.isEmpty()) {
            if (inWords.length() > 0) {
                inWords.insert(0, ' ');
            }
            inWords.insert(0, word);
        }
    }
}
