package fr.eletutour.eweather.services.impl;

import com.google.gson.Gson;
import fr.eletutour.eweather.dto.Forecast;
import fr.eletutour.eweather.dto.LocationData;
import fr.eletutour.eweather.dto.LocationError;
import fr.eletutour.eweather.exceptions.LocationIssueException;
import fr.eletutour.eweather.services.IGsonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsonService implements IGsonService {
    @Override
    public LocationData[] stringToLocations(String locationIQResponse) throws LocationIssueException {
        Gson g = new Gson();
        if (locationIQResponse.contains("error")) {
            LocationError error = g.fromJson(locationIQResponse, LocationError.class);
            log.debug(error.getError());
            throw new LocationIssueException(error.getError());
        }
        return g.fromJson(locationIQResponse, LocationData[].class);
    }

    @Override
    public Forecast stringToForecast(String darkSkyResponse) {
        Gson g = new Gson();
        return g.fromJson(darkSkyResponse, Forecast.class);
    }
}
