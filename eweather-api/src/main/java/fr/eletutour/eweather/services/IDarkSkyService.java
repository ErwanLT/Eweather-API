package fr.eletutour.eweather.services;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * DarkSky Service
 */
public interface IDarkSkyService {

    String callApi(String latitude, String longitude);
}
