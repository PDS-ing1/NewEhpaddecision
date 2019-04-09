package fr.esipe.pds.ehpaddecision.users;

import java.sql.Timestamp;

public class Users {

	private int idUser; 
	private String nameUser;
	private String passwordUser; 
	private Timestamp dateCreation;
	
	
	
	public Users(int idUser, String nameUser, String passwordUser, Timestamp dateCreation){
		this.idUser=idUser;
		this.nameUser=nameUser;
		this.passwordUser=passwordUser;
		this.dateCreation=dateCreation;
		
	}

	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public String getNameUser() {
		return nameUser;
	}



	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}



	public String getPasswordUser() {
		return passwordUser;
	}



	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}



	public Timestamp getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}
		
	
}
