package fr.eletutour.eweather.services;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Location Service
 */
public interface ILocationService {

    String callApi(String location);

    String callApi(String latitude, String longitude);
}
