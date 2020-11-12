import {AfterViewChecked, Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Forecast} from '../models/forecast';
import {Currently} from '../models/currently';
import {Daily} from '../models/daily';
import {Hourly} from '../models/hourly';

@Component({
  selector: 'app-forecast',
  templateUrl: './forecast.component.html',
  styleUrls: ['./forecast.component.css']
})
export class ForecastComponent implements OnInit, OnChanges {

  @Input() forecast: Forecast;

  currently: Currently;
  daily: Daily;
  hourly: Hourly;

  constructor() { }

  ngOnInit(): void {
    if (this.forecast) {
      this.currently = this.forecast.currently;
      this.daily = this.forecast.daily;
      this.hourly = this.forecast.hourly;
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.forecast){
      this.currently = this.forecast.currently;
      this.daily = this.forecast.daily;
      this.hourly = this.forecast.hourly;
    }
  }





}
