package fr.esipe.pds.ehpaddecision.sensors;

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
import fr.esipe.pds.ehpaddecision.locations.LocationDAO;
import fr.esipe.pds.ehpaddecision.principales.Alerts;
import fr.esipe.pds.ehpaddecision.principales.Locations;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;
import fr.esipe.pds.ehpaddecision.principales.Users;

public class SensorsTemperaturesDAO extends AbDAO<Temperatures_Sensors> {

	// to be able to convert Json into a readable file
	private JsonFactory factory = new JsonFactory();
	// to track all steps (logs)
	private final Logger log = LoggerFactory.getLogger(LocationDAO.class);	

	public SensorsTemperaturesDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	private Temperatures_Sensors sensorsHandler(ResultSet rs) {
		{
			Temperatures_Sensors temperatures_sensors = null;
			try {
				temperatures_sensors = new Temperatures_Sensors(rs.getString("macAdress"), rs.getString("Brand"), rs.getString("Location"), rs.getString("mode"), rs.getLong("date"), rs.getInt("temperatureMin"), rs.getInt("temperatureMax"));
			} catch (SQLException e) {
				log.error("Sorry, we occured an error while retrieving this sensor from the result : " + e.getMessage());
			}
			return temperatures_sensors;
		}
	}


	@Override
	public Temperatures_Sensors create(Temperatures_Sensors temperatures_sensors) {
		// TODO Auto-generated method stub
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO temperatures_sensors (macAdress, Brand, Location, mode, date, temperatureMin, temperatureMax)"
								+ " VALUES (? , ? , ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, temperatures_sensors.getMacAdress());
				preparedStatement.setString(2, temperatures_sensors.getBrand());
				preparedStatement.setString(3, temperatures_sensors.getLocation());
				preparedStatement.setString(4, temperatures_sensors.getMode());
				preparedStatement.setLong(5, temperatures_sensors.getDate());
				preparedStatement.setInt(6, temperatures_sensors.getTemperatureMin());
				preparedStatement.setInt(7, temperatures_sensors.getTemperatureMax());

				preparedStatement.execute();
				ResultSet rs = preparedStatement.getGeneratedKeys();
			} catch (Exception e) {
				log.error("Sorry, something is wrong with the creation, please try again : " + e.getMessage());
				e.printStackTrace();
			}
		}	
		return temperatures_sensors;
	}




	@Override
	public void update(Temperatures_Sensors temperatures_sensors) {
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE temperatures_sensors SET mode = ? WHERE macAdress =" + temperatures_sensors.getMacAdress());
				preparedStatement.setString(1, temperatures_sensors.getMacAdress());
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("An error occurred during the update of a location : " + e.getMessage());
				e.printStackTrace();
			}
		}

	}


	@Override
	public void delete(Temperatures_Sensors obj) {
		// TODO Auto-generated method stub

	}

	public List<Temperatures_Sensors> DisplayAllTemperaturesSensors() {
		List<Temperatures_Sensors> temperatures_sensors = new ArrayList<Temperatures_Sensors>();
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM temperatures_sensors");
				ResultSet rs = preparedStatement.executeQuery();
				Temperatures_Sensors temperatures_sensor;
				while (rs.next()) {
					temperatures_sensor = sensorsHandler(rs);
					if(temperatures_sensor != null)
					{
						temperatures_sensor.add(temperatures_sensor);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return temperatures_sensors;
	}

	@Override
	public List<Temperatures_Sensors> find(List<String> values) {
		
		List<Temperatures_Sensors> temperatures_sensors = new ArrayList<Temperatures_Sensors>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM temperatures_sensors");
				ResultSet rs = preparedStatement.executeQuery();
				Temperatures_Sensors temperatures_sensor;
				while (rs.next()) {
					temperatures_sensor = sensorsHandler(rs);
					if(temperatures_sensor != null)
					{
						temperatures_sensor.add(temperatures_sensor);
					}
				}
			} catch (Exception e) {
				log.error("Oh it seems to be a big URL, try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return temperatures_sensors;
	}

}
