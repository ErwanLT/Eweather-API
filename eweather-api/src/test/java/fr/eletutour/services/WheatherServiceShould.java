package fr.eletutour.services;

import fr.eletutour.eweather.exceptions.LocationIssueException;
import fr.eletutour.eweather.services.IWeatherService;
import fr.eletutour.eweather.services.impl.DarkSkyService;
import fr.eletutour.eweather.services.impl.GsonService;
import fr.eletutour.eweather.services.impl.LocationIQService;
import fr.eletutour.eweather.services.impl.WeatherService;
import org.junit.Before;
import org.junit.Test;

public class WheatherServiceShould {

    private IWeatherService weatherService;

    @Before
    public void init(){
        weatherService = new WeatherService(new GsonService(),new DarkSkyService(), new LocationIQService());
    }

    @Test(expected = LocationIssueException.class)
    public void throw_LocationIssueException_if_location_empty() throws Exception {
        weatherService.getForecast("");
    }

    @Test(expected = LocationIssueException.class)
    public void throw_LocationIssueException_if_latitude_empty() throws Exception {
        weatherService.getForecast("", "45");
    }

    @Test(expected = LocationIssueException.class)
    public void throw_LocationIssueException_if_longitude_empty() throws Exception {
        weatherService.getForecast("45", "");
    }

}
