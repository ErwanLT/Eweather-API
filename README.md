[![Build Status](https://travis-ci.com/ErwanLT/Eweather-API.svg?branch=main)](https://travis-ci.com/ErwanLT/Eweather-API)
[![codecov](https://codecov.io/gh/ErwanLT/Eweather-API/branch/main/graph/badge.svg?token=L3LMtknX9P)](undefined)
# Eweather-API
API to call Eweather

- swagger-ui : http://localhost:8080/swagger-ui.html

## Use Case
### Get weather forecast

- methode : GET
- URL : /eweather/forecast
- params : location
- example : /eweather/forecast?location=Paris
- response :
```json
{
    "latitude": 48.8566969,
    "longitude": 2.3514616,
    "timezone": "Europe/Paris",
    "location": "Paris, Île-de-France, France métropolitaine, France",
    "currently": {
        "time": "1601631736",
        "summary": "Pluie",
        "icon": "rain",
        "precipIntensity": 1.7406,
        "precipProbability": 0.53,
        "precipType": "rain",
        "temperature": 12.87,
        "apparentTemperature": 12.87,
        "dewPoint": 10.47,
        "humidity": 0.85,
        "windSpeed": 4.0,
        "windBearing": 158,
        "windGust": 6.43,
        "pressure": 986.0,
        "cloudCover": 0.99,
        "ozone": 311.7,
        "visibility": 11.643,
        "nearestStormBearing": null,
        "nearestStormDistance": null
    },
    "hourly": {
        "summary": "Pluie jusqu’à demain matin.",
        "icon": "rain",
        "data": [
            {
                "time": "1601629200",
                "summary": "Pluie",
                "icon": "rain",
                "precipIntensity": 2.394,
                "precipProbability": 0.65,
                "precipType": "rain",
                "temperature": 12.43,
                "apparentTemperature": 12.43,
                "dewPoint": 10.56,
                "humidity": 0.88,
                "windSpeed": 4.66,
                "windBearing": 155,
                "windGust": 7.47,
                "pressure": 985.8,
                "cloudCover": 0.99,
                "ozone": 310.7,
                "visibility": 8.557,
                "precipAccumulation": null
            }
        ]
    },
    "daily": {
        "summary": "Pluie pendant toute la semaine.",
        "icon": "rain",
        "data": [
            {
                "time": "1601589600",
                "summary": "Pluie toute la journée.",
                "icon": "rain",
                "sunriseTime": "1601617980",
                "sunsetTime": "1601659680",
                "moonPhase": 0.53,
                "precipIntensity": 0.8043,
                "precipIntensityMax": 2.731,
                "precipProbability": 0.98,
                "precipIntensityMaxTime": "1601624220",
                "precipAccumulation": null,
                "precipType": "rain",
                "temperatureHigh": 15.28,
                "temperatureHighTime": "1601645160",
                "temperatureLow": 8.69,
                "temperatureLowTime": "1601704800",
                "apparentTemperatureHigh": 15.0,
                "apparentTemperatureHighTime": "1601645160",
                "apparentTemperatureLow": 7.64,
                "apparentTemperatureLowTime": "1601704800",
                "temperatureMin": 10.88,
                "temperatureMinTime": "1601604420",
                "temperatureMax": 15.28,
                "temperatureMaxTime": "1601645160",
                "apparentTemperatureMin": 11.15,
                "apparentTemperatureMinTime": "1601604420",
                "apparentTemperatureMax": 15.0,
                "apparentTemperatureMaxTime": "1601645160",
                "dewPoint": 10.16,
                "humidity": 0.85,
                "pressure": 988.8,
                "windSpeed": 4.02,
                "windGust": 15.04,
                "windGustTime": "1601609580",
                "windBearing": 146,
                "cloudCover": 0.99,
                "uvIndex": 2,
                "uvIndexTime": "1601638680",
                "visibility": 13.398,
                "ozone": 311.8
            }
        ]
    },
    "alerts": [
        {
            "title": "Moderate Rain-flood Warning",
            "time": "1601611620",
            "expire": null,
            "uri": "http://vigilance.meteofrance.com/"
        }
    ]
}
```