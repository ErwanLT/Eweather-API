import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Forecast} from '../models/forecast';

@Injectable()

@Injectable({
  providedIn: 'root'
})
export class WeatherServiceService {

  private weatherURL: string;
  private weatherLocationURL: string;

  constructor(private http: HttpClient) {
    this.weatherURL = 'http://localhost:8080/eweather/forecast?location=';
    this.weatherLocationURL = 'http://localhost:8080/eweather/forecastLocation?';
  }

  public getWeather(location: string): Observable<Forecast> {
    return this.http.get<Forecast>(this.weatherURL + location);
  }

  public getWeatherLocation(latitude: string, longitude: string): Observable<Forecast> {
    const lat = 'latitude=' + latitude;
    const long = 'longitude=' + longitude;

    const urlToCall = this.weatherLocationURL + lat + '&' + long;

    return this.http.get<Forecast>(urlToCall);
  }
}
