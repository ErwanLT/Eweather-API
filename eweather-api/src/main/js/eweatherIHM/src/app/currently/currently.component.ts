import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Currently} from '../models/currently';
import {Forecast} from '../models/forecast';
import {BehaviorSubject} from 'rxjs';
import {Map, Marker, icon, tileLayer, circle, polygon, latLng} from 'leaflet';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-currently',
  templateUrl: './currently.component.html',
  styleUrls: ['./currently.component.css']
})
export class CurrentlyComponent implements OnInit {

  @Input() currently: Currently;

  constructor() { }

  ngOnInit(): void {
  }

}
