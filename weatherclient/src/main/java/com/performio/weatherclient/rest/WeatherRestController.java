/**
 * 
 */
package com.performio.weatherclient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.performio.weatherclient.domain.CityWeather;
import com.performio.weatherclient.service.WeatherService;

/**
 * @author Anil Jaguri
 *
 */

@RestController
@RequestMapping("/")
public class WeatherRestController implements AbstractWeatherRestController{

	@Autowired
	WeatherService weatherService;
	@Override
	public CityWeather getCityWeather(String cityName) throws Exception {
		if(cityName==null || cityName.length()==0) {
			throw new Exception("City Not provided. City is mandatory..");
		}
		return weatherService.getCityWeather(cityName);
	}
}
