/**
 * 
 */
package com.performio.weatherclient.domain;

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
public class CityDetailsModel {

	private String country;
	private String cityName;
	private String sunrise;
	private String sunset;
	private String timezone;
}
