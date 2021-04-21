package pl.sidor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeneralUtil {

    private static final int INDEX = 0;
    private static final int INDEX_POLAND = 171;

    /**
     * Method get a list of sorted countries
     *
     * @return Sorted list of countries
     */
    public static List<String> getAllCountries() {
        List<String> country = new ArrayList<>();
        for (String countryCode : Locale.getISOCountries()) {
            Locale obj = new Locale("", countryCode);
            country.add(obj.getDisplayCountry());
        }
        Collections.sort(country);
        Collections.swap(country, INDEX, INDEX_POLAND);
        return country;
    }
}
