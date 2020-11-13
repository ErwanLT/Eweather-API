import {Component, OnInit} from '@angular/core';
import {WeatherServiceService} from './services/weather-service.service';
import {Forecast} from './models/forecast';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'eweatherIHM';

  forecast: Forecast = new Forecast();

  display = false;

  constructor(private weatherService: WeatherServiceService) {
  }

  ngOnInit(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        this.weatherService.getWeatherLocation(position.coords.latitude.toString(), position.coords.longitude.toString())
          .subscribe(data => {
            this.forecast = data;
            this.display = true;
        });
      });
    }
  }

  setForecast(forecast: Forecast) {
    this.forecast = forecast;
  }
}
