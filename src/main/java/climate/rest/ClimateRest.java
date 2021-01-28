package climate.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import climate.service.ClimateService;
import common.dtos.ClimateDto;
import common.exceptions.JerseyClientBuildException;

/**
 * A resource for checking climate reports
 *
 */
@Path("/climate")
public class ClimateRest {
	/**
	 * Gets climate data for a specific location
	 * /climate-at-location/climate/{location}
	 * 
	 * @param  location 		The location a weather report is requested for.
	 * @return ClimateDto		The climate data for a location
	 * @throws Exception
	 * @throws JerseyClientBuildException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{location}")
	@NotNull
	public ClimateDto getClimate(@PathParam("location") String location) throws Exception, JerseyClientBuildException {
		return ClimateService.getInstance().getClimateReportByLocation(location);
	}
}
