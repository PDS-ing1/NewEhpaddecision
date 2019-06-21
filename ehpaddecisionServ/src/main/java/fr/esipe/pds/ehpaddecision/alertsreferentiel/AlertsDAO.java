package fr.esipe.pds.ehpaddecision.alertsreferentiel;

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
import fr.esipe.pds.ehpaddecision.principales.Alert;

import fr.esipe.pds.ehpaddecision.dao.AbDAO;

public class AlertsDAO extends AbDAO<Alert> implements InterfaceAlerts{
	private final Logger log = LoggerFactory.getLogger(AlertsDAO.class);	
	private JsonFactory jsFactory = new JsonFactory();


	public AlertsDAO (Connection connection){
		super(connection);
	}

	
	private Alert alertsHandler(ResultSet rs) {
		{
			Alert alert = null;
			try {
				alert = new Alert(rs.getInt("ID_ALERT"), rs.getString("NAME"),rs.getTimestamp("CREATION_DATE"));
			} catch (SQLException e) {
				log.error("Sorry, we faced an error while retrieving this alert from the result : " + e.getMessage());
			}
				return alert;
			}
		}
	
	
	
	public void update(Alert alert) {
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

	public Alert create(Alert alert) {
	
		// quick check if there is any free connection to use 
			if(connection != null)
			{
				System.out.println("je cree mon alerte");
				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO ALERT (ID_ALERT, NAME, CREATION_DATE)"
									+ " VALUES (? , ? , ? )", Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setInt(1, alert.getIdAlert());
					preparedStatement.setString(2, alert.getNameAlert());
					preparedStatement.setTimestamp(3, alert.getCreationDate());
					preparedStatement.execute();
					ResultSet rs = preparedStatement.getGeneratedKeys();

				} catch (Exception e) {
					log.error("Sorry, this creation couldn't execute : " + e.getMessage());
					e.printStackTrace();
				}
			}	
			
			return alert;

		}

	
	public void delete(Alert obj) {
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



	
	public List<Alert> DisplayAllAlerts() {
		List<Alert> alertList = new ArrayList<Alert>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALERT");
				ResultSet rs = preparedStatement.executeQuery();
				Alert alert;
				while (rs.next()) {
					alert = alertsHandler(rs);
					if(alert != null)
					{
						alertList.add(alert);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return alertList;
	}



	@Override
	public List<Alert> find(List<String> values) {
		List<Alert> alertList = new ArrayList<Alert>();

			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALERT");
					ResultSet rs = preparedStatement.executeQuery();
					Alert alert;
					while (rs.next()) {
						alert = alertsHandler(rs);
						if(alert != null)
						{
							alertList.add(alert);
						}
					}
				} catch (Exception e) {
					log.error("Oh it seems to be a big URL, try again : " + e.getMessage());
					e.printStackTrace();
				}
			}

			return alertList;
		}
	
}
