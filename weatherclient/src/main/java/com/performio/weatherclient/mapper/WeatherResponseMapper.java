/**
 * 
 */
package com.performio.weatherclient.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.performio.weatherclient.domain.CityDetailsModel;
import com.performio.weatherclient.domain.CityWeather;
import com.performio.weatherclient.domain.CloudsModel;
import com.performio.weatherclient.domain.CoordinatesModel;
import com.performio.weatherclient.domain.MainWeather;
import com.performio.weatherclient.domain.WeatherDescriptionModel;
import com.performio.weatherclient.domain.WindModel;
import com.performio.weatherclient.utils.Utility;

import lombok.Builder;


/**
 * @author Anil Jaguri
 *
 */

@Builder
@Component
public class WeatherResponseMapper {
    private final ObjectMapper objectMapper;
   
    @Autowired
    Utility utils;
	/**
	 * @param response
	 * @return CityWeather
	 * 
	 * Below method maps the response from openWeather API to the CityWeather which is DTO object
	 * @throws Exception 
	 */
	public CityWeather mapCityWeather(ResponseEntity<String> response) throws Exception {
		try{
			JsonNode root = objectMapper.readTree(response.getBody());
			
			CoordinatesModel coordinatesDetails=CoordinatesModel.builder().
					latitude(root.path("coord").path("lat").asDouble()).
					longitude(root.path("coord").path("lon").asDouble()).build();
			
			CityDetailsModel cityDetails=CityDetailsModel.builder().cityName(root.path("name").asText())
					.country(root.path("sys").path("country").asText())
					.sunrise(utils.unixDateFormatter(root.path("sys").path("sunrise").asLong()))
					.sunset(utils.unixDateFormatter(root.path("sys").path("sunset").asLong()))
					.timezone(utils.convertTimeZone(root.path("timezone").asLong())).build();
			
			CloudsModel cloudDetails=CloudsModel.builder().cloudinessPercent(root.path("clouds").path("all").asDouble()).build();
			
			MainWeather mainWeatherDetails=MainWeather.builder().feelsLike(root.path("main").path("feels_like").asDouble())
					.humidity(root.path("main").path("humidity").asDouble())
					.maxTemp(root.path("main").path("temp_max").asDouble())
					.minTemp(root.path("main").path("temp_min").asDouble())
					.pressure(root.path("main").path("pressure").asDouble())
					.temperature(root.path("main").path("temp").asDouble())
					.visibility(root.path("visibility").asDouble())
					.build();
			
			WeatherDescriptionModel weatherDescDetails=WeatherDescriptionModel.builder()
					.description(root.path("weather").get(0).path("description").asText()).build();
			
			WindModel windDetails=WindModel.builder().windDirectionDegree(root.path("wind").path("deg").asDouble())
					.windSpeed(root.path("wind").path("speed").asDouble()).build();
			
			return CityWeather.builder()
					.cityCoordinates(coordinatesDetails)
					.cityDetails(cityDetails)
					.couldDetails(cloudDetails)
					.mainWeatherDetails(mainWeatherDetails)
					.weatherDescDetails(weatherDescDetails)
					.windDetails(windDetails)
					.response("Success : 200 OK")
					.build();
				    

		}catch(JsonProcessingException ex)
		{
			throw new Exception("Exception while mapping response object "+ex.getMessage().toString());
		}
	}

}
