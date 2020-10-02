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
 * DailyDTO class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Daily {

    private String summary;
    private String icon;
    private List<DailyDataPoint> data;
}
