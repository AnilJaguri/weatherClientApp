/**
 * 
 */
package com.performio.weatherclient.service;

import org.springframework.stereotype.Service;

import com.performio.weatherclient.domain.CityWeather;

/**
 * @author Anil Jaguri
 *
 */
@Service
public interface WeatherService {

	public CityWeather getCityWeather(String CityName) throws Exception;
}
