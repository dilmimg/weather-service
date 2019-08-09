package au.origin.weather.weatherservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weather {

	@Id
	@GeneratedValue
	private Long id;
	
	private String city;
	
	private int temperature;
	
	public Weather() {
		super();
	}
	public Weather(String city, int temperature) {
		super();
		this.city = city;
		this.temperature = temperature;
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	
}
