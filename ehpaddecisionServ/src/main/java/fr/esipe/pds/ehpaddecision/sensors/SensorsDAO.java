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

public class SensorsDAO extends AbDAO<Sensors>{
	
	// to be able to convert Json into a readable file
		private JsonFactory factory = new JsonFactory();
		// to track all steps (logs)
		private final Logger log = LoggerFactory.getLogger(LocationDAO.class);	

		public SensorsDAO(Connection connection) {
			super(connection);
			// TODO Auto-generated constructor stub
		}
		
		private Sensors sensorsHandler(ResultSet rs) {
			{
				Sensors sensors = null;
				try {
					sensors = new Sensors(rs.getString("macAdress"), rs.getString("Brand"), rs.getString("Location"), rs.getString("Type"), rs.getString("mode"), rs.getLong("date"));
				} catch (SQLException e) {
					log.error("Sorry, we occured an error while retrieving this sensor from the result : " + e.getMessage());
				}
				return sensors;
			}
		}
		
		public Sensors create(Sensors sensors) {
			// TODO Auto-generated method stub
			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO sensor (macAdress, Brand, Location, Type, mode, date)"
									+ " VALUES (? , ? , ? , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setString(1, sensors.getMacAdress());
					preparedStatement.setString(2, sensors.getBrand());
					preparedStatement.setString(3, sensors.getLocation());
					preparedStatement.setString(4, sensors.getType());
					preparedStatement.setString(5, sensors.getMode());
					preparedStatement.setLong(6, sensors.getDate());
					preparedStatement.execute();
					ResultSet rs = preparedStatement.getGeneratedKeys();
				} catch (Exception e) {
					log.error("Sorry, something is wrong with the creation, please try again : " + e.getMessage());
					e.printStackTrace();
				}
			}	
			return sensors;
		}

		@Override
		public void update(Sensors obj) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Sensors obj) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Sensors> find(List<String> values) {
			// TODO Auto-generated method stub
			return null;
		}

	
	
	
	

}