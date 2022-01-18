/**
 * 
 */
package com.performio.weatherclient.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author Anil Jaguri
 *
 */
@Data
@ConfigurationProperties("weatherapp")
public class VaultServerConfiguration {
	
	private String userName;
	private String apiKey;
}
