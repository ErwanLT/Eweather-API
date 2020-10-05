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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * EWeather rest controller
 */
@RestController
@RequestMapping("/eweather")
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
    public ResponseEntity getWeather(@RequestParam(name = "location") String location) throws Exception {
        return new ResponseEntity(weatherService.getForecast(location), HttpStatus.OK);
    }
}
