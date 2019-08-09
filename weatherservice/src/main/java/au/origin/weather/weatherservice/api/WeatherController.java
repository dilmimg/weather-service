package au.origin.weather.weatherservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import au.origin.weather.weatherservice.model.WeatherDetails;
import au.origin.weather.weatherservice.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/temperature/city")
	public ResponseEntity<WeatherDetails> getWeather(){
		return ResponseEntity.ok(this.weatherService.getWeatherDetails());
	}

}
