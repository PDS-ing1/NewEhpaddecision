package fr.esipe.pds.ehpaddecision.principales;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperatures_Sensors {
	
	private int id_sensor;
	private String macAdress;
		private String Brand;
	private String Location;
	private String Type;
	
	@JsonCreator
	public Temperatures_Sensors(@JsonProperty("macAdress") String macAdress,@JsonProperty("Brand") String Brand,@JsonProperty("Location") String Location){
		this.id_sensor= id_sensor;
		this.macAdress = macAdress;
		this.Brand = Brand;
		this.Location = Location;
	}
	public Temperatures_Sensors(int id_sensor){
		this.id_sensor=id_sensor;
	}

	public Temperatures_Sensors() {
		// TODO Auto-generated constructor stub
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
	
	public int getId_sensor() {
		return id_sensor;
	}

	public void setId_sensor(int id_sensor) {
		this.id_sensor = id_sensor;
	}
	
	public String toString() {
		return "temperatures_sensors [macAdress=" + macAdress + ", Brand=" + Brand + ", Location=" + Location + "]";
	}
	

}
