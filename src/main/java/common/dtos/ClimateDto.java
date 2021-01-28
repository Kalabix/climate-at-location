package common.dtos;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * Represents data object returned from ClimateAPI
 *
 */
@XmlRootElement(name = "ClimateDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClimateDto {
	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "tempeture")
	private int tempeture;

	@XmlElement(name = "humidity")
	private int humidity;

	@XmlElement(name = "outlook")
	private String outlook;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTempeture() {
		return tempeture;
	}

	public void setTempeture(int tempeture) {
		this.tempeture = tempeture;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

}
