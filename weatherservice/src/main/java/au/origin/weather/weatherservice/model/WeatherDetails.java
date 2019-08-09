package au.origin.weather.weatherservice.model;

import java.io.Serializable;
import java.util.List;

public class WeatherDetails implements Serializable {

	private static final long serialVersionUID = -3174312467496347659L;
	
	private List<CityTemperature> cities;

	public List<CityTemperature> getCities() {
		return cities;
	}

	public void setCities(List<CityTemperature> cities) {
		this.cities = cities;
	}

}
