package fr.eletutour.services;

import fr.eletutour.eweather.exceptions.LocationIssueException;
import fr.eletutour.eweather.services.ILocationService;
import fr.eletutour.eweather.services.IWeatherService;
import fr.eletutour.eweather.services.impl.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WheatherServiceShould {

    private IWeatherService weatherService;

    private ILocationService locationService;

    @Before
    public void init(){
        locationService = mock(LocationIQService.class);
        weatherService = new WeatherService(new GsonService(),new DarkSkyService(), locationService);
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

    @Test(expected = LocationIssueException.class)
    public void throw_LocationIssueException_if_response_empty_1() throws Exception {
        when(locationService.callApi(anyString())).thenReturn("");
        weatherService.getForecast("Paris");
    }

    @Test(expected = LocationIssueException.class)
    public void throw_LocationIssueException_if_response_empty_2() throws Exception {
        when(locationService.callApi(anyString(), anyString())).thenReturn("");
        weatherService.getForecast("45","45");
    }

}
