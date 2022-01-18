/**
 * 
 */
package com.performio.weatherclient.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.performio.weatherclient.domain.CityWeather;
import com.performio.weatherclient.mapper.WeatherResponseMapper;
import com.performio.weatherclient.utils.VaultServerConfiguration;

/**
 * @author Anil Jaguri
 *
 */
@Service
@EnableConfigurationProperties(VaultServerConfiguration.class)
public class WeatherServiceImpl implements WeatherService,CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(WeatherServiceImpl.class);
	@Autowired
	WeatherResponseMapper mapper;
	private VaultServerConfiguration vaultConfig;
	private final RestTemplate restTemplate;

	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&APPID={key}";

	/**
	 * @param vaultConfig
	 * @param restTemplate
	 */
	public WeatherServiceImpl(VaultServerConfiguration vaultConfig, RestTemplateBuilder restTemplateBuilder) {
		this.vaultConfig = vaultConfig;
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public CityWeather getCityWeather(String cityName) throws Exception {
		ResponseEntity<String> response = null;
		try {
			 final String apiKey=vaultConfig.getApiKey();
			URI url = new UriTemplate(WEATHER_URL).expand(cityName, apiKey);
			response = restTemplate.getForEntity(url, String.class);
			if (response != null && response.getStatusCode().toString().equalsIgnoreCase("200 OK")) {
				return mapper.mapCityWeather(response);
			}
			return null;
		} catch (Exception ex) {
			return CityWeather.builder().response(ex.getLocalizedMessage()).build();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("=======Loading Properties=========");
		//logger.info("username ::"+vaultConfig.getUserName());
		//logger.info("APIKey ::"+vaultConfig.getApiKey());
	}
}
