/**
 * 
 */
package com.performio.weatherclient.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Anil Jaguri
 *
 */

@Getter
@Builder
public class CityWeather {
	
	private String response="";
	private CoordinatesModel cityCoordinates;
	private CityDetailsModel cityDetails;
	private CloudsModel couldDetails;
	private MainWeather mainWeatherDetails;
	private WeatherDescriptionModel weatherDescDetails;
	private WindModel windDetails;
	
}
