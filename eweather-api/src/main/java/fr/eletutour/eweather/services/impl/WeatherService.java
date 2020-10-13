package fr.eletutour.eweather.services.impl;

import fr.eletutour.eweather.dto.Forecast;
import fr.eletutour.eweather.dto.LocationData;
import fr.eletutour.eweather.exceptions.LocationIssueException;
import fr.eletutour.eweather.services.IDarkSkyService;
import fr.eletutour.eweather.services.IGsonService;
import fr.eletutour.eweather.services.ILocationService;
import fr.eletutour.eweather.services.IWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Implementation of {@link IWeatherService}
 */
@Service
@Slf4j
public class WeatherService implements IWeatherService {

    private final IGsonService gsonService;

    private final IDarkSkyService darkSkyService;

    private final ILocationService locationIQService;

    @Autowired
    public WeatherService(IGsonService gsonService, IDarkSkyService darkSkyService, ILocationService locationIQService) {
        this.gsonService = gsonService;
        this.darkSkyService = darkSkyService;
        this.locationIQService = locationIQService;
    }

    @Override
    public Forecast getForecast(String location) {
        if (location.isEmpty()) {
            //ne devrait jamais arriver car champs obligatoire
            throw new LocationIssueException("Le champs location est obligatoire.");
        } else {
            String locationIQResponse = locationIQService.callApi(location);
            log.info(locationIQResponse);

            if (locationIQResponse.isEmpty()) {
                throw new LocationIssueException("L'appel à LocationIQ n'a remonté aucun résultat.");
            } else {
                LocationData[] ld = gsonService.stringToLocations(locationIQResponse);
                LocationData l = ld[0];
                return getForecast(l.getLat(), l.getLon(), l.getDisplayName());
            }
        }
    }

    @Override
    public Forecast getForecast(String latitude, String longitude) throws Exception {
        String locationIQResponse = locationIQService.callApi(latitude, longitude);
        if (locationIQResponse.isEmpty()) {
            throw new LocationIssueException("L'appel à LocationIQ n'a remonté aucun résultat.");
        } else {
            LocationData ld = gsonService.stringToLocationReverse(locationIQResponse);
            return getForecast(latitude, longitude, ld.getDisplayName());
        }
    }

    private Forecast getForecast(String lat, String lon, String displayName) {
        Forecast forecast;

        String darkSkyResponse = darkSkyService.callApi(lat, lon);
        log.info(darkSkyResponse);

        forecast = gsonService.stringToForecast(darkSkyResponse);
        forecast.setLocation(displayName);

        return forecast;
    }
}
