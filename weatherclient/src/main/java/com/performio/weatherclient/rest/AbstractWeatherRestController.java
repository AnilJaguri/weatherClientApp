/**
 * 
 */
package com.performio.weatherclient.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.performio.weatherclient.domain.CityWeather;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


/**
 * @author Anil Jaguri
 *
 */

@RequestMapping("/")
public interface AbstractWeatherRestController {

	@GetMapping(path="/weather",produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="Get City Weather based on City and Country Name or CityName", responses= {
			@ApiResponse(responseCode="200", description="City Weather Retrieved Successfully"),
			@ApiResponse(responseCode="401", description="Not Authorized to view the resource"),
			@ApiResponse(responseCode="403", description="Accessing the resource is forbidden"),
			@ApiResponse(responseCode="404", description="The Resource is not found"),
			@ApiResponse(responseCode="500", description="Internal Server Error")
	})
	public CityWeather getCityWeather(@RequestParam(name = "cityName", required = true) String cityName) throws Exception;

}
