package fr.esipe.pds.ehpaddecision.sensorsreferentiel;
import java.sql.Connection;
import java.sql.SQLException;

import fr.esipe.pds.ehpaddecision.sensorsreferentiel.AlertsDAO;


public class DAOHandler {
	public static AbDAO  getDAOHandler(Connection connection, Class entityClass) throws Exception {
		
		if(entityClass.equals(Alerts.class))
			return new AlertsDAO(connection);
		else if(entityClass.equals(Users.class))
			return new UsersDAO(connection);
		else
			throw new Exception();
	}

	

}
