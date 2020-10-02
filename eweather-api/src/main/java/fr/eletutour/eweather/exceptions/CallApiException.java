package fr.eletutour.eweather.exceptions;

public class CallApiException extends RuntimeException {
    public CallApiException(String s) {
        super(s);
    }
}
