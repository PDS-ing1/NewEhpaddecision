package fr.esipe.pds.ehpaddecision.principales;

import java.sql.Timestamp;

public class Location {
	private int idLocation; 
	private String nameLocation;
	private int hall_nb;
	private int floor_nb;
	private int building_nb;
	private Timestamp dateCreation;
		
	public Location(int idLocation,String nameLocation, int hall_nb, int floor_nb, int building_nb, Timestamp dateCreation){
		this.idLocation=idLocation;
		this.nameLocation=nameLocation;
		this.floor_nb=floor_nb;
		this.building_nb=building_nb;
		this.dateCreation=dateCreation;
		
	}
	public Location( String nameLocation) {
		this.nameLocation=nameLocation;
		this.hall_nb=0;
		this.floor_nb=0;
		this.building_nb=0;
		this.dateCreation = new Timestamp(System.currentTimeMillis());
	}
	public Location(){
	}
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	public String getNameLocation() {
		return nameLocation;
	}
	public void setNameLocation(String nameLocation) {
		this.nameLocation = nameLocation;
	}
	public int getHall_nb() {
		return hall_nb;
	}
	public void setHall_nb(int hall_nb) {
		this.hall_nb = hall_nb;
	}
	public int getFloor_nb() {
		return floor_nb;
	}
	public void setFloor_nb(int floor_nb) {
		this.floor_nb = floor_nb;
	}
	public int getBuilding_nb() {
		return building_nb;
	}
	public void setBuilding_nb(int building_nb) {
		this.building_nb = building_nb;
	}
	public Timestamp getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Locations [idLocation=" + idLocation + ", nameLocation=" + nameLocation + ", hall_nb=" + hall_nb
				+ ", floor_nb=" + floor_nb + ", building_nb=" + building_nb + ", dateCreation=" + dateCreation + "]";
	}

	
}
