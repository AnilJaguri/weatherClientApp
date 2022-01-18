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
public class CloudsModel {

	private Double cloudinessPercent;
}
