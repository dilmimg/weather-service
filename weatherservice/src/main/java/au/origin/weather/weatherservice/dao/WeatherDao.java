package au.origin.weather.weatherservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.origin.weather.weatherservice.entity.Weather;


@Repository
public interface WeatherDao extends JpaRepository<Weather, Long>{

}