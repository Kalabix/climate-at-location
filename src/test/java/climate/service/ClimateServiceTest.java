package climate.service;

import javax.ws.rs.client.Invocation;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import common.dtos.ClimateDto;
import common.exceptions.JerseyClientBuildException;
import common.exceptions.WeatherAPIRequestException;
import climate.service.ClimateService;

public class ClimateServiceTest {

	private ClimateService service;
	private Invocation.Builder builder = mock(Invocation.Builder.class);
	private ClimateDto mock = mock(ClimateDto.class);

	@Before
	public void setUp() {
		service = ClimateService.getInstance();

	}

	@Test(expected = WeatherAPIRequestException.class)
	public void testNullLocation() throws WeatherAPIRequestException, JerseyClientBuildException {
		when(builder.get(ClimateDto.class)).thenReturn(mock);
		service.getClimateReportByLocation(null);
	}

	@Test(expected = WeatherAPIRequestException.class)
	public void testNoLocation() throws WeatherAPIRequestException, JerseyClientBuildException {
		when(builder.get(ClimateDto.class)).thenReturn(mock);
		service.getClimateReportByLocation("");
	}

}
