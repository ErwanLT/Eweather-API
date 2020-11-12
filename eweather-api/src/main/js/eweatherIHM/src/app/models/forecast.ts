import {Currently} from './currently';
import {Hourly} from './hourly';
import {Daily} from './daily';

export class Forecast {
  public latitude: number;
  public longitude: number;
  public timezone: string;
  public location: string;
  public currently: Currently;
  public hourly: Hourly;
  public daily: Daily;

  constructor();

  constructor(obj?: any) {
    if (obj) {
      this.latitude = obj.latitude || 0;
      this.longitude = obj.longitude || 0;
      this.timezone = obj.timezone || '';
      this.location = obj.location || '';
      this.currently = obj.currently;
      this.hourly = obj.hourly;
      this.daily = obj.daily;
    } else {
      this.latitude = 0;
      this.longitude = 0;
      this.timezone = '';
      this.location = '';
      this.currently = new Currently();
      this.hourly = new Hourly();
      this.daily = new Daily();
    }

  }
}
