package fr.esipe.pds.ehpaddecision.principales;

import java.sql.Timestamp;

public class Users {

	private int idUser; 
	private String nameUser;
	private Timestamp dateCreation;
	
	public Users(){
		
	}
	
	public Users(String nameUser){
		this.nameUser=nameUser;
		this.dateCreation=new Timestamp(System.currentTimeMillis());
		
	}
	
	public Users(int idUser, String nameUser, Timestamp dateCreation){
		this.idUser=idUser;
		this.nameUser=nameUser;
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



	public Timestamp getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", nameUser=" + nameUser + ", dateCreation=" + dateCreation + "]";
	}
	
		
	
}
