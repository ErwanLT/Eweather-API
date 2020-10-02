package fr.eletutour.eweather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Forecast class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {
    private double latitude;

    private double longitude;

    private String timezone;

    private String location;

    /**
     * A data point containing the current weather.css conditions at the requested location.
     */
    private Currently currently;

    private Hourly hourly;

    /**
     * A data block containing the weather.css conditions day-by-day for the next week.
     */
    private Daily daily;

    private List<Alert> alerts = new ArrayList<>();
}
