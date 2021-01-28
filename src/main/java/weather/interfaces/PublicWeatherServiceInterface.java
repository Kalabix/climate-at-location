package weather.interfaces;

import common.exceptions.JerseyClientBuildException;
import common.exceptions.WeatherAPIRequestException;
import common.dtos.WeatherDto;

/**
 * Defines expected behavior from the PublicWeatherAPI
 */
public interface PublicWeatherServiceInterface {
	
	/**
	 * 
	 * @param location - the location for the weather report
	 * @return WeatherDto - response from the PublicWeatherAPI
	 * @throws WeatherAPIRequestException
	 * @throws JerseyClientBuildException
	 */
	WeatherDto getWeatherReportByLocation(String location)
			throws WeatherAPIRequestException, JerseyClientBuildException;
}
