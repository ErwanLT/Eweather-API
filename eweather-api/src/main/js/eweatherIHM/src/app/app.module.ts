import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

import {WeatherServiceService} from './services/weather-service.service';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { ForecastComponent } from './forecast/forecast.component';
import {MatTabsModule} from '@angular/material/tabs';
import { CurrentlyComponent } from './currently/currently.component';
import { HourlyComponent } from './hourly/hourly.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { DailyComponent } from './daily/daily.component';
import { FormComponent } from './form/form.component';
import { FooterComponent } from './footer/footer.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { MapComponent } from './map/map.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    ForecastComponent,
    CurrentlyComponent,
    HourlyComponent,
    DailyComponent,
    FormComponent,
    FooterComponent,
    MapComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        NgbModule,
        BrowserAnimationsModule,
        ServiceWorkerModule.register('ngsw-worker.js', {enabled: environment.production}),
        MatTabsModule,
        MatExpansionModule,
        LeafletModule,
        FontAwesomeModule
    ],
  providers: [WeatherServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
