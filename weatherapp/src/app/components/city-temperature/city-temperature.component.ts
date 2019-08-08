import { CityTemperature } from './../../models/city-temperature';
import { Component, OnInit } from '@angular/core';
import { WeatherService } from 'src/app/services/weather.service';

@Component({
  selector: 'app-city-temperature',
  templateUrl: './city-temperature.component.html',
  styleUrls: ['./city-temperature.component.scss']
})
export class CityTemperatureComponent implements OnInit {

  cityTemperatures: CityTemperature[];
  isError = false;

  constructor(private weatherService: WeatherService) { }

  ngOnInit() {
    this.getTemperatures();
  }

  getTemperatures() {
    this.weatherService.getWeatherDetails().subscribe( details => {
      if (!details || details.cities && details.cities.length === 0) {
        this.isError = true;
        return;
      }
      this.cityTemperatures = details.cities;
    }, error => {
      this.isError = true;
    });
  }

}
