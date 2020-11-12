package fr.eletutour.eweather.controller;

import fr.eletutour.eweather.dto.Forecast;
import fr.eletutour.eweather.services.IWeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * EWeather rest controller
 */
@RestController
@RequestMapping("/eweather")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class EweatherAPIController {

    private final IWeatherService weatherService;

    @Autowired
    public EweatherAPIController(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    @ApiOperation(value = "Get the weather forecast for a location",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "operation created", response = Forecast.class),
            @ApiResponse(code = 500, message = "An error occured")
    }
    )
    public Forecast getWeather(@RequestParam(name = "location") String location) throws Exception {
        return weatherService.getForecast(location);
    }

    @GetMapping("/forecastLocation")
    @ApiOperation(value = "Get the weather forecast for the latitude and the longitude",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "operation created", response = Forecast.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public Forecast getWeather(@RequestParam(name = "latitude")String latitude,
                                     @RequestParam(name = "longitude")String longitude) throws Exception{
        return weatherService.getForecast(latitude, longitude);
    }
}
