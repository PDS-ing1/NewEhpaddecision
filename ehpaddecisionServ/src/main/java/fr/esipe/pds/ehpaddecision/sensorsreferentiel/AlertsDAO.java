package fr.esipe.pds.ehpaddecision.sensorsreferentiel;

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

import fr.esipe.pds.ehpaddecision.sensorsreferentiel.Alerts;

public class AlertsDAO extends AbDAO<Alerts> implements InterfaceAlerts{
	private final Logger log = LoggerFactory.getLogger(AlertsDAO.class);	
	private JsonFactory jsFactory = new JsonFactory();


	public AlertsDAO (Connection connection) 
	{
		super(connection);
	}

	
	private Alerts alertsHandler(ResultSet rs) {
		{
			Alerts alert = null;
			try {
				alert = new Alerts(rs.getInt("ID_ALERT"), rs.getString("NAME"),rs.getTimestamp("CREATION_DATE"));
			} catch (SQLException e) {
				log.error("Sorry, we faced an error while retrieving this alert from the result : " + e.getMessage());
			}
				return alert;
			}
		}
	
	
	
	public void update(Alerts alert) {
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE ALERT SET NAME = ? WHERE ID_ALERT =" + alert.getIdAlert());
				preparedStatement.setString(1, alert.getNameAlert());
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("An error occurred during the update of a location : " + e.getMessage());
				e.printStackTrace();
			}
		}

	}








	
	public Alerts create(Alerts alerts) {
	
		// quick check if there is any free connection to use 
			if(connection != null)
			{
				System.out.println("je cree mon alerte");
				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO ALERT (ID_ALERT, NAME, CREATION_DATE)"
									+ " VALUES (? , ? , ? )", Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setInt(1, alerts.getIdAlert());
					preparedStatement.setString(2, alerts.getNameAlert());
					preparedStatement.setTimestamp(3, alerts.getCreationDate());
					preparedStatement.execute();
					ResultSet rs = preparedStatement.getGeneratedKeys();

				} catch (Exception e) {
					log.error("Sorry, this creation couldn't execute : " + e.getMessage());
					e.printStackTrace();
				}
			}	
			
			return alerts;

		}

	
	public void delete(Alerts obj) {
		delete(obj.getIdAlert());		
	}
	
	public void delete(int alertId){
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM ALERT where ID_ALERT=(?)");
				preparedStatement.setInt(1, alertId);
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("Sorry, it seems like something wrong was happened with deleting this alert, try again : " + e.getMessage());
				e.printStackTrace();
			}
		}		
	}



	
	public List<Alerts> DisplayAllAlerts() {
		List<Alerts> alerts = new ArrayList<Alerts>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALERT");
				ResultSet rs = preparedStatement.executeQuery();
				Alerts alert;
				while (rs.next()) {
					alert = alertsHandler(rs);
					if(alert != null)
					{
						alerts.add(alert);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return alerts;
	}



	@Override
	public List<Alerts> find(List<String> values) {
		List<Alerts> alerts = new ArrayList<Alerts>();

			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALERT");
					ResultSet rs = preparedStatement.executeQuery();
					Alerts alert;
					while (rs.next()) {
						alert = alertsHandler(rs);
						if(alert != null)
						{
							alerts.add(alert);
						}
					}
				} catch (Exception e) {
					log.error("Oh it seems to be a big URL, try again : " + e.getMessage());
					e.printStackTrace();
				}
			}

			return alerts;
		}
	
}
