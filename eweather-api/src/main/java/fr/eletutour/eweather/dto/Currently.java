package fr.eletutour.eweather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * CurrentlyDTO class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currently extends DataPoint {
    private Double nearestStormBearing;
    private Double nearestStormDistance;
}
