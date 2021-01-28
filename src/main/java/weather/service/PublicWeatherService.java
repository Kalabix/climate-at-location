package weather.service;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

import common.jerseyclient.JerseyClientBuilder;

import common.dtos.WeatherDto;
import common.exceptions.JerseyClientBuildException;
import common.exceptions.Messages;
import common.exceptions.WeatherAPIRequestException;
import weather.interfaces.PublicWeatherServiceInterface;

public class PublicWeatherService implements PublicWeatherServiceInterface {

	// dummy values for the demo
	private final static String TARGET = "http://weatherapi.com";
	private final static String PATH = "/";

	@Override
	public WeatherDto getWeatherReportByLocation(String location)
			throws WeatherAPIRequestException, JerseyClientBuildException {
		if (location == null || location.isEmpty()) {
			throw new WeatherAPIRequestException(Messages.INVALID_LOCATION);
		}

		try {
			return requestWeatherData(location);
		} catch (Exception e) {
			throw new WeatherAPIRequestException(Messages.WEATHERAPI_CONNECTION_FAILED + e.getLocalizedMessage());
		}

	}

	private Invocation.Builder createJerseyClient(String location) throws JerseyClientBuildException {
		return new JerseyClientBuilder().setTarget(TARGET).setPath(PATH).setMediaType(MediaType.APPLICATION_JSON)
				.setLocationParameter(location).build();
	}

	private WeatherDto requestWeatherData(String location) throws JerseyClientBuildException {
		return createJerseyClient(location).get(WeatherDto.class);
	}
}
