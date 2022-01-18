/**
 * 
 */
package com.performio.weatherclient.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anil Jaguri
 *
 */
@Builder
@Getter
@Setter
public class MainWeather {

	private Double temperature;
	private Double feelsLike;
	private Double minTemp;
	private Double maxTemp;
	private Double pressure;
	private Double humidity;
	private Double visibility; 
	
}
