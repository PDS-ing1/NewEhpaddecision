package fr.esipe.pds.ehpaddecision.principales;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensors {

	private String macAdress;
	private String Brand;
	private String Location;
	private String Type;
	private String mode = "off";
	private String state = "false";
	private long date = System.currentTimeMillis();

	@JsonCreator
	public Sensors(@JsonProperty("macAdress") String macAdress,@JsonProperty("Brand") String Brand,@JsonProperty("Location") String Location,@JsonProperty("Type") String Type, @JsonProperty("mode") String mode, @JsonProperty("state") String state, @JsonProperty("date") long date){

		this.macAdress = macAdress;
		this.Brand = Brand;
		this.Location = Location;
		this.Type = Type;
		this.mode = mode;
		this.state = state;
		this.date = date;
	}


	public Sensors() {
		// TODO Auto-generated constructor stub
	}
	public Sensors(Object object) {
		// TODO Auto-generated constructor stub
	}


	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

//	public void setState(Boolean state) {
//		this.state = state;
//
//
//
//	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String toString() {

		return "sensors1 [macAdress=" + macAdress + ", Brand=" + Brand + ", Location=" + Location + ", Type=" + Type +", mode=" + mode +", state=" + state +", date=" + date +"]";

		//		return "Sensors [macAdress=" + macAdress + ", Brand=" + Brand + ", Location=" + Location + ", Type=" + Type +", mode=" + mode +", date=" + date +"]";
		//>>>>>>> acd8d61 Commit test
	}


}
