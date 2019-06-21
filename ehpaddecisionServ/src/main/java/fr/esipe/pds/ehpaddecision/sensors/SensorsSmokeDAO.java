package fr.esipe.pds.ehpaddecision.sensors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;

import fr.esipe.pds.ehpaddecision.dao.AbDAO;
import fr.esipe.pds.ehpaddecision.locations.LocationDAO;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Smoke_Sensors;

public class SensorsSmokeDAO extends AbDAO<SensorsSmokeDAO>{
	// to be able to convert Json into a readable file
	private JsonFactory factory = new JsonFactory();
	// to track all steps (logs)
	private final Logger log = LoggerFactory.getLogger(LocationDAO.class);

	public SensorsSmokeDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	private Smoke_Sensors sensorsHandler(ResultSet rs) {
		{
			Smoke_Sensors smoke_sensors = null;
			try {
				smoke_sensors = new Smoke_Sensors(rs.getString("macAdress"), rs.getString("Brand"), rs.getString("Location"), rs.getString("Type"), rs.getLong("date"));
			} catch (SQLException e) {
				log.error("Sorry, we occured an error while retrieving this sensor from the result : " + e.getMessage());
			}
			return smoke_sensors;
		}
	}

	public Smoke_Sensors create(Smoke_Sensors smoke_sensors) {
		// TODO Auto-generated method stub
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO smoke_sensor (macAdress, Brand, Location, Type, mode, date)"
								+ " VALUES (? , ? , ? , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, smoke_sensors.getMacAdress());
				preparedStatement.setString(2, smoke_sensors.getBrand());
				preparedStatement.setString(3, smoke_sensors.getLocation());
				preparedStatement.setString(4, smoke_sensors.getType());
				preparedStatement.setString(5, smoke_sensors.getMode());
				preparedStatement.setLong(6, smoke_sensors.getDate());
				preparedStatement.execute();
				ResultSet rs = preparedStatement.getGeneratedKeys();
			} catch (Exception e) {
				log.error("Sorry, something is wrong with the creation, please try again : " + e.getMessage());
				e.printStackTrace();
			}
		}	
		return smoke_sensors;
	}


	@Override
	public void update(SensorsSmokeDAO obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(SensorsSmokeDAO obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public SensorsSmokeDAO create(SensorsSmokeDAO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SensorsSmokeDAO> find(List<String> values) {
		// TODO Auto-generated method stub
		return null;
	}






}
