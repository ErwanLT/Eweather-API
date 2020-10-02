package fr.eletutour.eweather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyDataPoint {
    private String time;
    private String summary;
    private String icon;
    private String sunriseTime;
    private String sunsetTime;
    private Double moonPhase;
    private Double precipIntensity;
    private Double precipIntensityMax;
    private Double precipProbability;
    private String precipIntensityMaxTime;
    private Double precipAccumulation;
    private String precipType;
    private Double temperatureHigh;
    private String temperatureHighTime;
    private Double temperatureLow;
    private String temperatureLowTime;
    private Double apparentTemperatureHigh;
    private String apparentTemperatureHighTime;
    private Double apparentTemperatureLow;
    private String apparentTemperatureLowTime;
    private Double temperatureMin;
    private String temperatureMinTime;
    private Double temperatureMax;
    private String temperatureMaxTime;
    private Double apparentTemperatureMin;
    private String apparentTemperatureMinTime;
    private Double apparentTemperatureMax;
    private String apparentTemperatureMaxTime;
    private Double dewPoint;
    private Double humidity;
    private Double pressure;
    private Double windSpeed;
    private Double windGust;
    private String windGustTime;
    private Integer windBearing;
    private Double cloudCover;
    private Integer uvIndex;
    private String uvIndexTime;
    private Double visibility;
    private Double ozone;
}
