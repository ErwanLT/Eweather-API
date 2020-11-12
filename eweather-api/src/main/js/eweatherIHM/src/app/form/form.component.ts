import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Forecast} from '../models/forecast';
import {WeatherServiceService} from '../services/weather-service.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output() forecast: EventEmitter<Forecast> = new EventEmitter<Forecast>();

  location = '';

  constructor(private weatherService: WeatherServiceService) { }

  ngOnInit(): void {
  }

  onSubmit(location: string) {
    this.weatherService.getWeather(location).subscribe(data => {
      this.forecast.emit(data);
    });
  }
}
