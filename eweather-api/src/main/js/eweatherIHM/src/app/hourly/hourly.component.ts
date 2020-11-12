import {Component, Input, OnInit} from '@angular/core';
import {Hourly} from '../models/hourly';

@Component({
  selector: 'app-hourly',
  templateUrl: './hourly.component.html',
  styleUrls: ['./hourly.component.css']
})
export class HourlyComponent implements OnInit {

  @Input() hourly: Hourly;

  constructor() { }

  ngOnInit(): void {
  }

}
