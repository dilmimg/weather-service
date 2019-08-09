package au.origin.weather.weatherservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import au.origin.weather.weatherservice.dao.WeatherDao;
import au.origin.weather.weatherservice.entity.Weather;
import au.origin.weather.weatherservice.model.WeatherDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTests {
	
	@Autowired
	private WeatherService weatherservice;
	
	@MockBean
	private WeatherDao weatherDao;
	
	@Test
	public void shouldConvertWeatherListToWeatherDetails() {
		
		Weather weather = new Weather("Melbourne", 24);
		List<Weather> weatherList = Stream.of(weather).collect(Collectors.toList());
		
		Mockito.when(weatherDao.findAll()).thenReturn(weatherList);
		
		WeatherDetails weatherDetails = weatherservice.getWeatherDetails();
		
		assertThat(weatherDetails).isNotNull();
		assertThat(weatherDetails.getCities().size()).isEqualTo(1);
				
	}
	
	@Test
	public void shouldReturnEmptyWeatherDetailsWhenWeatherListIsEmpty() {
		
		List<Weather> weatherList = new ArrayList();
				
		Mockito.when(weatherDao.findAll()).thenReturn(weatherList);
		
		WeatherDetails weatherDetails = weatherservice.getWeatherDetails();

		assertThat(weatherDetails).isNotNull();
		assertThat(weatherDetails.getCities().size()).isEqualTo(0);
			
	}

}
