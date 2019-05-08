package converter;

public interface Locale {
    String get1(int digit, int gender);
    String get10(int digit);
    String get11(int digit);
    String get100(int digit);
    String getTriad(int digit, int triad);
    int getTriadGender(int triad);
}
