package climate.service;

import common.dtos.ClimateDto;
import common.dtos.builders.ClimateDTOBuilder;
import common.exceptions.JerseyClientBuildException;
import common.exceptions.WeatherAPIRequestException;
import weather.service.PublicWeatherService;

/**
 * Basic service for all weather requests.
 *
 */
public class ClimateService {

	private static ClimateService service = null;

	public static ClimateService getInstance() {
		if (service == null) {
			service = new ClimateService();
		}
		return service;
	}

	/**
	 * Returns the climate based on the location provided.
	 * 
	 * @param location 		The location a weather report is requested for.
	 * @return ClimateDto   The climate data for a location
	 * @throws WeatherAPIRequestException
	 * @throws JerseyClientBuildException
	 */
	public static ClimateDto getClimateReportByLocation(String location)
			throws WeatherAPIRequestException, JerseyClientBuildException {

		PublicWeatherService service = new PublicWeatherService();

		return ClimateDTOBuilder.ClimateDTOBuilder(service.getWeatherReportByLocation(location)).build();
	}
}
