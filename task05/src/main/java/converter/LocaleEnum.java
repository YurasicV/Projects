package converter;

import locale.EnglishLocale;
import locale.RussianLocale;
import locale.UkrainianLocale;

public enum LocaleEnum {
    EN, RU, UA;

    public Locale getLocale() {
        switch (this) {
            case RU: return new RussianLocale();
            case UA: return new UkrainianLocale();
            default: return new EnglishLocale();
        }
    }
}