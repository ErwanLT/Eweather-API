package fr.eletutour.eweather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPoint {
    private String time;
    private String summary;
    private String icon;
    private Double precipIntensity;
    private Double precipProbability;
    private String precipType;
    private Double temperature;
    private Double apparentTemperature;
    private Double dewPoint;
    private Double humidity;
    private Double windSpeed;
    private Integer windBearing;
    private Double windGust;
    private Double pressure;
    private Integer uvIndex;
    private Double cloudCover;
    private Double ozone;
    private Double visibility;
}
