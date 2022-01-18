/**
 * 
 */
package com.performio.weatherclient.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Anil Jaguri
 *
 */
@Component
public class Utility {

	/**
	 * @param unixSeconds
	 * @return
	 */
	public String unixDateFormatter(Long unixSeconds) {
		if (unixSeconds != null) {
			Date date = new java.util.Date(unixSeconds * 1000L);
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
			sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
			return sdf.format(date);
		}
		return null;
	}

	public String convertTimeZone(Long timeZone) {
		if (timeZone != null) {
			Date localTime = new Date((new Date().getTime()) + 1800 * 1000);
			return localTime.toLocaleString();
		}
		return null;
	}
}