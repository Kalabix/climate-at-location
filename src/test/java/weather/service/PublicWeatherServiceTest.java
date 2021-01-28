package weather.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import common.dtos.WeatherDto;
import common.exceptions.JerseyClientBuildException;
import common.exceptions.WeatherAPIRequestException;
@RunWith(PowerMockRunner.class)
@PrepareForTest(PublicWeatherService.class)
public class PublicWeatherServiceTest {

	
	@Test(expected = WeatherAPIRequestException.class)
	public void testNullLocation() throws WeatherAPIRequestException, JerseyClientBuildException {
		PublicWeatherService service = new PublicWeatherService();
		service.getWeatherReportByLocation(null);
	}
	
	@Test(expected = WeatherAPIRequestException.class)
	public void testEmptyLocation() throws WeatherAPIRequestException, JerseyClientBuildException {
		PublicWeatherService service = new PublicWeatherService();
		service.getWeatherReportByLocation("");
	}
	
	@Test(expected = WeatherAPIRequestException.class)
	public void testWeatherApiNotResponding() throws WeatherAPIRequestException, JerseyClientBuildException {
		PublicWeatherService service = new PublicWeatherService();
		service.getWeatherReportByLocation("Galway");
	}
	
	@Test
	public void testWeatherApiCanReturnResultWhenUp() throws Exception {
		PublicWeatherService mock = PowerMockito.mock( PublicWeatherService.class );
		String location = new String("galway");
		PowerMockito.doReturn((new WeatherDto())).when(mock, "requestWeatherData",location);
		mock.getWeatherReportByLocation(location);
	}
	
}
