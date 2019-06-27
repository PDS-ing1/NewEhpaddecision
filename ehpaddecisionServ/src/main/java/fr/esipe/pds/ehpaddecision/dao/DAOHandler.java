
package fr.esipe.pds.ehpaddecision.dao;
import java.sql.Connection;
import java.sql.SQLException;

import fr.esipe.pds.ehpaddecision.alertsreferentiel.AlertsDAO;
import fr.esipe.pds.ehpaddecision.locations.LocationDAO;
import fr.esipe.pds.ehpaddecision.sensors.SensorsDAO;
import fr.esipe.pds.ehpaddecision.sensors.SensorsSmokeDAO;
import fr.esipe.pds.ehpaddecision.sensors.SensorsTemperaturesDAO;
import fr.esipe.pds.ehpaddecision.users.UsersDAO;



public class DAOHandler {
	public static AbDAO  getDAOHandler(Connection connection, Class entityClass) throws Exception {

		// run some test with sysout
		// TODO remvoe sysout
		if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Alert.class)){
			System.out.println("here");
			return new AlertsDAO(connection);
		}
		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.User.class)){
			System.out.println("not here");
			return new UsersDAO(connection);
		}
		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Location.class)){
			System.out.println("not here");
			return new LocationDAO(connection);
		}
		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors.class)){
			System.out.println("not here");
			return new SensorsTemperaturesDAO(connection);

		}
		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Sensors.class)){
			System.out.println("not here");
			return new SensorsDAO(connection);
		}
		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Smoke_Sensors.class)){
			System.out.println("not here");
			return new SensorsSmokeDAO(connection);

		}
		else{
			System.out.println("Oops");

			throw new Exception();
		}
	}



}
//=======
//package fr.esipe.pds.ehpaddecision.dao;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import fr.esipe.pds.ehpaddecision.alertsreferentiel.AlertsDAO;
//import fr.esipe.pds.ehpaddecision.locations.LocationDAO;
//import fr.esipe.pds.ehpaddecision.sensors.SensorsDAO;
//import fr.esipe.pds.ehpaddecision.sensors.SensorsSmokeDAO;
//import fr.esipe.pds.ehpaddecision.sensors.SensorsTemperaturesDAO;
//import fr.esipe.pds.ehpaddecision.users.UsersDAO;
//import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;
//
//
//public class DAOHandler {
//	public static AbDAO  getDAOHandler(Connection connection, Class entityClass) throws Exception {
//		
//		// run some test with sysout
//		// TODO remvoe sysout
//		if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Alerts.class)){
//		     System.out.println("here");
//			return new AlertsDAO(connection);
//		}
//		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Users.class)){
//			System.out.println("not here");
//			return new UsersDAO(connection);
//		}
//		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Locations.class)){
//			System.out.println("not here");
//			return new LocationDAO(connection);
//		}
//		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors.class)){
//			System.out.println("not here");
//			return new SensorsTemperaturesDAO(connection);
//			
//		}
//		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Sensors.class)){
//			System.out.println("not here");
//			return new SensorsDAO(connection);
//		}
//		
//		
//		else if(entityClass.equals(fr.esipe.pds.ehpaddecision.principales.Smoke_Sensors.class)){
//			System.out.println("not here");
//			return new SensorsSmokeDAO(connection);
//			
//		}
//		else{
//			System.out.println("Oops");
//		
//			throw new Exception();
//			}
//	}
//
//	
//
//}
//>>>>>>> acd8d61 Commit test
