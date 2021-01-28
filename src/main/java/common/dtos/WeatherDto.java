package common.dtos;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * Represents data object returned from PublicWeatherAPI
 *
 */
@XmlRootElement(name = "WeatherDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherDto {

	@XmlElement(name = "location")
	private String location;

	@XmlElement(name = "tempeture")
	private int tempeture;

	@XmlElement(name = "humidity")
	private int humidity;

	@XmlElement(name = "outlook")
	private String outlook;

	public String getLocation() {
		return location;
	}

	public int getTempeture() {
		return tempeture;
	}

	public int getHumidity() {
		return humidity;
	}

	public String getOutlook() {
		return outlook;
	}

}
