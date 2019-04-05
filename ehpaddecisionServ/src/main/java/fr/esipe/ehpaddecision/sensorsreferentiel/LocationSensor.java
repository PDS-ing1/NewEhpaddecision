package fr.esipe.ehpaddecision.sensorsreferentiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonFactory;

//this class should contain the CRUD methods of the object Location 
//Create a sensor , delete a or many sensors, update a sensor, and display all sensors,

public class LocationSensor  {
	// to be able to convert Json into a readable file
	private JsonFactory factory = new JsonFactory();
	// to track all steps (logs)
	private final Logger log = LoggerFactory.getLogger(LocationSensor.class);	

	public LocationSensor(Connection connection) 
	{
		super();
	}
	
	
	public LocationSensor create(LocationSensor place) {

		// call the connection to be sure that there is one connection (at least) available to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO TABLEofLocation (AAA, ATTRIBUT2, AA, _DATE)"
								+ " VALUES (? , ? , ? , ? )", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, place.get());
				preparedStatement.setString(2, place.get());
				preparedStatement.setInt(3, place.get());
				preparedStatement.setTimestamp(4, place .getCreationDate());
				preparedStatement.execute();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				int lastCreatedId = 0;
				if(rs.next()){
					lastCreatedId = rs.getInt(1);
					place.setIdPlace(lastCreatedId);
				}
			} catch (Exception e) {
				log.error("Sorry, something is wrong with the creation, please try again : " + e.getMessage());
				e.printStackTrace();
			}
		}	
		
		return place;

	}
	
	
	
	public void update(LocationSensor place) {
		// Checks if the connection is not null before using it
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE TABLE SET NAME = ? WHERE ID_PLACE =" + place.getIdPlace());
				preparedStatement.setString(1, place.getNamePlace());
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("Sorr, something is wrong with the update, try again please : " + e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	public void delete(LocationSensor obj) {
		delete(obj.getIdLocationSensor());		
	}


	
}
