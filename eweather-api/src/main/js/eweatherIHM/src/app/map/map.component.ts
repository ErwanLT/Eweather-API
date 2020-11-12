import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Forecast} from '../models/forecast';
import {icon, latLng, Map, Marker, tileLayer} from 'leaflet';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, OnChanges {

  @Input() forecast: Forecast;

  map: Map;

  options: any = {};
  layersControl: any = {};
  marker: Marker;

  constructor() { }

  ngOnInit(): void {
    this.options = {
      layers: [
        tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
          attribution: '&copy; OpenStreetMap contributors'
        })
      ],
      zoom: 7,
      center: latLng(this.forecast.latitude, this.forecast.longitude)
    };

    this.layersControl = {
      baseLayers: {
        'Open Street Map': tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { maxZoom: 18, attribution: '...' }),
      },
      overlays: {
        Temperature: tileLayer('https://tile.openweathermap.org/map/temp_new/{z}/{x}/{y}.png?appid=' + atob(environment.appid)),
        Nuages: tileLayer('https://tile.openweathermap.org/map/clouds_new/{z}/{x}/{y}.png?appid=' + atob(environment.appid)),
        Pluie: tileLayer('https://tile.openweathermap.org/map/precipitation_new/{z}/{x}/{y}.png?appid=' + atob(environment.appid)),
        Vent: tileLayer('https://tile.openweathermap.org/map/wind_new/{z}/{x}/{y}.png?appid=' + atob(environment.appid))
      }
    };
  }

  onMapReady(map: Map) {
    this.map = map;
    this.addSampleMarker();
  }

  private addSampleMarker() {
    this.marker = new Marker([this.forecast.latitude, this.forecast.longitude])
      .setIcon(
        icon({
          iconSize: [25, 41],
          iconAnchor: [13, 41],
          iconUrl: 'assets/img/marker-icon.png',
          shadowUrl: 'assets/img/marker-shadow.png'
        }));
    this.marker.addTo(this.map);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.forecast){
      if (this.marker){
        this.marker.remove();
      }
      this.reloadLayers(this.forecast);
    }
  }

  reloadLayers(forecast: Forecast) {
    this.options.center = latLng(forecast.latitude, forecast.longitude);
    this.map.setView(latLng(forecast.latitude, forecast.longitude), 7);
    this.onMapReady(this.map);
  }

}
