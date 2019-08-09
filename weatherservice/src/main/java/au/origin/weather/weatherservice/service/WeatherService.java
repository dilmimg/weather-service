package au.origin.weather.weatherservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.origin.weather.weatherservice.dao.WeatherDao;
import au.origin.weather.weatherservice.entity.Weather;
import au.origin.weather.weatherservice.model.CityTemperature;
import au.origin.weather.weatherservice.model.WeatherDetails;

@Service
public class WeatherService {

	@Autowired
	private WeatherDao weatherDao;
	
	public WeatherDetails getWeatherDetails(){

		return convertToWeatherDetails(this.weatherDao.findAll());
		
	}
	
	private WeatherDetails convertToWeatherDetails(List<Weather> weatherList) {
		
		WeatherDetails weatherDetails = new WeatherDetails();
		
		
		List<CityTemperature> cityTemperatureList = weatherList.stream()
				.map(weather -> new CityTemperature(weather.getCity(),Integer.toString(weather.getTemperature())))
				.collect(Collectors.toList());
		
		weatherDetails.setCities(cityTemperatureList);
		
		return weatherDetails;
	}
}
