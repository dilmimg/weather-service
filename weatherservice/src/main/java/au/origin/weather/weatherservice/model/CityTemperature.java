package au.origin.weather.weatherservice.model;

import java.io.Serializable;

public class CityTemperature implements Serializable{

	private static final long serialVersionUID = -6391855477783289391L;
	
	private String name;
		
	private String temperature;
	
	public CityTemperature(String name, String temperature) {
		super();
		this.name = name;
		this.temperature = temperature;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
}
