package fr.eletutour.eweather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HourlyDataPoint extends DataPoint {

    private Double precipAccumulation;
}
