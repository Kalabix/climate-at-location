package common.dtos.builders;

import common.interfaces.BuilderInterface;
import common.dtos.ClimateDto;
import common.dtos.WeatherDto;

/**
 * This is the builder for reconciling the response from the
 * PublicWeatherServiceAPI and the ClimateAPI
 * 
 *
 */
public class ClimateDTOBuilder implements BuilderInterface<ClimateDto> {
	WeatherDto weatherDto;

	public ClimateDTOBuilder(WeatherDto weatherDto) {
		this.weatherDto = weatherDto;
	}

	public static ClimateDTOBuilder ClimateDTOBuilder(WeatherDto weatherDto) {
		return new ClimateDTOBuilder(weatherDto);
	}

	@Override
	public ClimateDto build() {
		ClimateDto climateDto = new ClimateDto();
		climateDto.setHumidity(this.weatherDto.getHumidity());
		climateDto.setOutlook(this.weatherDto.getOutlook());
		climateDto.setTempeture(this.weatherDto.getTempeture());
		climateDto.setDescription(createDescription(this.weatherDto));

		return climateDto;
	}

	/**
	 * Creates a human readable description based on the data from the
	 * 
	 * @param weatherDto
	 */
	private String createDescription(WeatherDto weatherDto) {
		StringBuilder sb = new StringBuilder();
		sb.append("The weather today looks ");
		if (weatherDto.getTempeture() < 20) {
			sb.append("cold");
		} else {
			sb.append("hot");
		}

		return sb.toString();
	}
}
