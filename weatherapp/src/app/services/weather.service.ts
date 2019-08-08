import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherDetails } from '../models/weather-details';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })
  export class WeatherService {
    baseUrl = environment.serviceHostname;

    constructor(private httpClient: HttpClient) { }

    public getWeatherDetails(): Observable<WeatherDetails> {
      const url = this.baseUrl + '/api/temperature/city';
      return this.httpClient.get<WeatherDetails>(url);
    }
}
