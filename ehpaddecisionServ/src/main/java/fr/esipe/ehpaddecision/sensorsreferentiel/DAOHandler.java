package fr.esipe.ehpaddecision.sensorsreferentiel;
import java.sql.Connection;



public class DAOHandler {
	public static AbDAO  getDAOHandler(Connection connection, Class entityClass) {
		
		if(entityClass.equals(CurrentUser.class))
			return new (connection);
		else if(entityClass.equals(Location.class))
			return new (connection);
	
	}

}
