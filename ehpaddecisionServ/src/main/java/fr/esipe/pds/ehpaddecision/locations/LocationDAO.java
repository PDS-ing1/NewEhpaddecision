package fr.esipe.pds.ehpaddecision.locations;

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

import fr.esipe.pds.ehpaddecision.dao.AbDAO;
import fr.esipe.pds.ehpaddecision.principales.Location;

//this class should contain the CRUD methods of the object Location 
//Create a sensor , delete a or many sensors, update a sensor, and display all sensors,
// TODO review this class and correct mistakes

public class LocationDAO  extends AbDAO<Location> {
	// to be able to convert Json into a readable file
	private JsonFactory factory = new JsonFactory();
	// to track all steps (logs)
	private final Logger log = LoggerFactory.getLogger(LocationDAO.class);	

	public LocationDAO (Connection connection) 
	{
		super(connection);
	}
	@Override
	public Location create(Location location) {
		// call the connection to be sure that there is one connection (at least) available to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO LOCATION (ID_LOCATION,NAME_LOCATION, HALL_NB, FLOOR_NB, BUILDING_NB ,DATE_CREATION)"
								+ " VALUES (? , ? ,?, ? , ?, ? )", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, location.getIdLocation());
				preparedStatement.setString(2, location.getNameLocation());
				preparedStatement.setInt(3, location.getHall_nb());
				preparedStatement.setInt(4, location.getFloor_nb());
				preparedStatement.setInt(5, location.getBuilding_nb());
				preparedStatement.setTimestamp(6, location.getDateCreation());
				preparedStatement.execute();
				ResultSet rs = preparedStatement.getGeneratedKeys();
			} catch (Exception e) {
				log.error("Sorry, something is wrong with the creation, please try again : " + e.getMessage());
				e.printStackTrace();
			}
		}	
		return location;
	}
	
	
	
	public void update(Location location) {
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE LOCATION SET BUILDING_NB = ? WHERE ID_LOCATION =" + location.getIdLocation());
				preparedStatement.setInt(1, location.getBuilding_nb());
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("An error occurred during the update of a location : " + e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	public void delete(int idLocation) {
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM LOCATION where ID_LOCATION=(?)");
				preparedStatement.setInt(1, idLocation);
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("Sorry, it seems like something wrong was happened with deleting this alert, try again : " + e.getMessage());
				e.printStackTrace();
			}
		}		
	}
	
	@Override
	public void delete(Location obj) {
		delete(obj.getIdLocation());		
		
	}

	public List<Location> displayAllLocations() {
		List<Location> locationList = new ArrayList<Location>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LOCATION");
				ResultSet rs = preparedStatement.executeQuery();
				Location location;
				while (rs.next()) {
					location = locationsHandler(rs);
					if(location != null)
					{
						locationList.add(location);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return locationList;
	}
	private Location locationsHandler(ResultSet rs) {
		{
			Location location = null;
			try {
				location = new Location(rs.getInt("ID_LOCATION"),rs.getString("NAME_LOCATION"), rs.getInt("HALL_NB"),rs.getInt("FLOOR_NB"), rs.getInt("BUILDING_NB"),rs.getTimestamp("DATE_CREATION"));
			} catch (SQLException e) {
				log.error("Sorry, we occured an error while retrieving this location from the result : " + e.getMessage());
			}
				return location;
			}
		}

	@Override
	public List<Location> find(List<String> values) {
		List<Location> locationList = new ArrayList<Location>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LOCATION");
				ResultSet rs = preparedStatement.executeQuery();
				Location location;
				while (rs.next()) {
					location = locationsHandler(rs);
					if(location != null)
					{
						locationList.add(location);
					}
				}
			} catch (Exception e) {
				log.error("Oh it seems to be a big URL, try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return locationList;
	}
}

