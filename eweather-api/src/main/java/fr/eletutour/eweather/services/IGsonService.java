package fr.eletutour.eweather.services;

import fr.eletutour.eweather.dto.Forecast;
import fr.eletutour.eweather.dto.LocationData;
import fr.eletutour.eweather.exceptions.LocationIssueException;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Gson Service
 */
public interface IGsonService {


    LocationData[] stringToLocations(String locationIQResponse) throws LocationIssueException;

    Forecast stringToForecast(String darkSkyResponse);
}
