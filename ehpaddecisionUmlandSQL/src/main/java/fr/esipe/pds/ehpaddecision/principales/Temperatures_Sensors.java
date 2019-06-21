package fr.esipe.pds.ehpaddecision.principales;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperatures_Sensors {

	private String macAdress;
	private String Brand;
	private String Location;
	private String Type;
	private String mode;
	private long date;
	private int temperatureMin = 5;
	private int temperatureMax = 39;

	@JsonCreator
	public Temperatures_Sensors(@JsonProperty("macAdress") String macAdress,@JsonProperty("Brand") String Brand,@JsonProperty("Location") String Location,@JsonProperty("mode") String mode, @JsonProperty("date") long date, @JsonProperty("temperatureMin") int temperatureMin, @JsonProperty("temperatureMax") int temperatureMax ){

		this.macAdress = macAdress;
		this.Brand = Brand;
		this.Location = Location;
		this.mode = mode;
		this.date = date;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
	}

	public String getMacAdress() {
		return macAdress;
	}

	public int getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public int getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String toString() {
		return "temperatures_sensors [macAdress=" + macAdress + ", Brand=" + Brand + ", Location=" + Location + ", mode=" + mode +", date=" + date +", temperatureMin=" + temperatureMin +", temperatureMax=" + temperatureMax +"]";
	}


}
