import {Component, Input, OnInit} from '@angular/core';
import {Daily} from '../models/daily';

@Component({
  selector: 'app-daily',
  templateUrl: './daily.component.html',
  styleUrls: ['./daily.component.css']
})
export class DailyComponent implements OnInit {

  @Input() daily: Daily;

  constructor() { }

  ngOnInit(): void {
  }

}
