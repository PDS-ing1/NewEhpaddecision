package fr.esipe.pds.ehpaddecision.dao;
import java.sql.Connection;
import java.sql.SQLException;

import fr.esipe.pds.ehpaddecision.alertsreferentiel.AlertsDAO;
import fr.esipe.pds.ehpaddecision.users.UsersDAO;


public class DAOHandler {
	public static AbDAO  getDAOHandler(Connection connection, Class entityClass) throws Exception {
		
		// run some test with sysout
		// TODO remvoe sysout
		if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Alerts.class)){
		     System.out.println("here");
			return new AlertsDAO(connection);
		}else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Users.class)){
			System.out.println("not here");
			return new UsersDAO(connection);
		}else{
			System.out.println("Oops");
		
			throw new Exception();
			}
	}

	

}
