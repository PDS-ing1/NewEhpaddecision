package fr.esipe.pds.ehpaddecision.principales;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Smoke_Sensors {
	
	private String macAdress;
	private String Brand;
	private String Location;
	private String Type;
	private String mode;
	private long date = System.currentTimeMillis();
	
	@JsonCreator
	public Smoke_Sensors(@JsonProperty("macAdress") String macAdress,@JsonProperty("Brand") String Brand,@JsonProperty("Location") String Location,@JsonProperty("mode") String mode, @JsonProperty("date") long date ){
		//public Smoke_Sensors(String macAdress, String Brand, String Location, String mode, long date){
		this.macAdress = macAdress;
		this.Brand = Brand;
		this.Location = Location;
		this.mode = mode;
		this.date = date;
	}

	public String getMacAdress() {
		return macAdress;
	}

	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
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
	
	public String toString() {
		return "smoke_sensor [macAdress=" + macAdress + ", Brand=" + Brand + ", Location=" + Location + ", mode=" + mode +", date=" + date +"]";
	}
	

}
