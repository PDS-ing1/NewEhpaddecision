package fr.esipe.pds.ehpaddecision.locations;

import java.sql.Timestamp;

public class Locations {
	private int idLocation; 
	private int hall_nb;
	private int floor_nb;
	private int building_nb;
	private Timestamp dateCreation;
		
	public Locations(int idLocation, int hall_nb, int floor_nb, int building_nb, Timestamp dateCreation){
		this.idLocation=idLocation;
		this.floor_nb=floor_nb;
		this.building_nb=building_nb;
		this.dateCreation=dateCreation;
		
	}
	
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
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

}
