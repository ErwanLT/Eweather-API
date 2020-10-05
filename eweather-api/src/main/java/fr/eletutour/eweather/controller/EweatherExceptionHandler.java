package fr.eletutour.eweather.controller;

import fr.eletutour.eweather.exceptions.ApiError;
import fr.eletutour.eweather.exceptions.LocationIssueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EweatherExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String LOCATION_ERROR = "Une erreur concernant la location est survenue.";

    @ExceptionHandler(value = LocationIssueException.class)
    public ResponseEntity handleLocationIssueException(LocationIssueException exception){
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, LOCATION_ERROR, exception));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
