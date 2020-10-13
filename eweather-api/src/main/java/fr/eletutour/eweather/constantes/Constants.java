package fr.eletutour.eweather.constantes;

public class Constants {
    public static final String DARK_SKY_KEY = System.getenv("DARKSKY_KEY");
    public static final String DARK_SKY_URL = "https://api.darksky.net/forecast/";
    public static final String DARK_SKY_SI_UNIT = "&units=si";
    public static final String DARK_SKY_LANG = "?lang=fr";
    public static final String DARK_SKY_EXCLUDE = "&exclude=minutely";
    public static final String LOCATIONIQ_KEY = System.getenv("LOCATIONIQ_KEY");
    public static final String LOCATIONIQ_URL1 = "https://eu1.locationiq.com/v1/search.php?key=";
    public static final String LOCATIONIQ_REVERSE = "https://eu1.locationiq.com/v1/reverse.php?key=";
    public static final String LOCATIONIQ_URL2 = "&format=json&accept-language=fr";
    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String FORMAT_DD_MM_YYYY_HH_MM = "dd/MM/yyyy hh:mm";
    public static final String FORMAT_DD_MM_YYYY_HH = "dd/MM/yyyy HH";
    public static final String FORMAT_HH_DD_MM = "HH'h' dd/MM";
    public static final String FORMAT_HH_MM = "hh:mm";
    public static final String FORMAT_EEEE_D_MMM_YYYY = "EEEE, d MMM yyyy";
    public static final String FORMAT_D_MMM_YYYY = "d MMM yyyy";

    private Constants() {
    }

    public static String getDarkSkyUrl(String latitude, String longitude) {

        return DARK_SKY_URL + DARK_SKY_KEY + "/" + latitude + "," + longitude + DARK_SKY_LANG + DARK_SKY_SI_UNIT + DARK_SKY_EXCLUDE;
    }

    public static String getDarkSkyUrl(String latitude, String longitude, Long date) {

        return DARK_SKY_URL + DARK_SKY_KEY + "/" + latitude + "," + longitude + "," + date + DARK_SKY_LANG + DARK_SKY_SI_UNIT + DARK_SKY_EXCLUDE;
    }

    public static String getLocationiqUrl(String location) {
        return LOCATIONIQ_URL1 + LOCATIONIQ_KEY + "&q=" + location + LOCATIONIQ_URL2;
    }

    public static String getLocationReverseGeocoding(String latitude, String longitude) {
        return LOCATIONIQ_REVERSE + LOCATIONIQ_KEY + "&lat=" + latitude + "&lon=" + longitude + "&zoom=10" + LOCATIONIQ_URL2;
    }
}
