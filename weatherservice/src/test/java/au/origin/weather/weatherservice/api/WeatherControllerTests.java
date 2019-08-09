package au.origin.weather.weatherservice.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import au.origin.weather.weatherservice.model.CityTemperature;
import au.origin.weather.weatherservice.model.WeatherDetails;
import au.origin.weather.weatherservice.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTests {
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private WeatherService weatherService;
    
    @Test
    public void givenWeatherDetailsShouldReturnJson()
      throws Exception {
        
		CityTemperature cityTemperature = new CityTemperature("Sydney", "30");
		List<CityTemperature> temperatureList = Stream.of(cityTemperature).collect(Collectors.toList());
		
		WeatherDetails weatherDetails = new WeatherDetails();
		weatherDetails.setCities(temperatureList);
     
		Mockito.when(weatherService.getWeatherDetails()).thenReturn(weatherDetails);
     
        mvc.perform(get("/temperature/city")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().json("{\"cities\":[{\"name\":\"Sydney\",\"temperature\":\"30\"}]}"));

    }

    @Test
    public void givenEmptyWeatherDetailsShouldReturnEmptyJson()
      throws Exception {
        
		List<CityTemperature> temperatureList = new ArrayList();
		
		WeatherDetails weatherDetails = new WeatherDetails();
		weatherDetails.setCities(temperatureList);
     
		Mockito.when(weatherService.getWeatherDetails()).thenReturn(weatherDetails);
     
        mvc.perform(get("/temperature/city")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().json("{\"cities\":[]}"));

    }

}
