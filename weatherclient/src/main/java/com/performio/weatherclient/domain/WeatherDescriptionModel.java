/**
 * 
 */
package com.performio.weatherclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Anil Jaguri
 *
 */
@Builder
@Getter
@Setter
public class WeatherDescriptionModel {

	private String main;
	private String description;
	
	
}
