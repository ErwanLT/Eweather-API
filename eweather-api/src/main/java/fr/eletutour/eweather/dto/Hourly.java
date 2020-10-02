package fr.eletutour.eweather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Hourly class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hourly {

    private String summary;
    private String icon;
    private List<HourlyDataPoint> data;
}
