package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alert;
import fr.esipe.pds.ehpaddecision.principales.Location;
import fr.esipe.pds.ehpaddecision.principales.User;

public class HomeBackEnd { //implements ActionListener {
	/*
	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	private HomePageFront homePageFront;
	public HomeBackEnd (HomePageFront homePageFront){
		this.homePageFront=homePageFront;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae) {
		{
			if(ae.getSource()== homePageFront.getButtonNew()) {
				System.out.println("action button test1");
				try
				{
					String nameAlert = homePageFront.getTextfName().getText();
					System.out.println("Name Alerte "+nameAlert);
					if(nameAlert.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False name, try again");
					}
					else {
						// Alert test
						
						Alerts alert = new Alerts(nameAlert);
						System.out.println(alert.toString());
					    String serializedObject = Tools.serializeObject(alert, alert.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Alerts.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					    
					    user test
					    Users user = new Users (nameAlert);
						System.out.println(user.toString());
					    String serializedObject = Tools.serializeObject(user, user.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Users.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					    
					    
					    //Location test 
					    Locations location = new Locations(nameAlert);
						System.out.println(location.toString());
					    String serializedObject = Tools.serializeObject(location, location.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Locations.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					    
					    
					    
					    
					    // to do the same lines of code for other uc, (locations, users, sensors..)
					    
						log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
						String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
						if(error.equals("")) {
							Alerts alertNewCreated = (Alerts)Tools.deserializeObject(answer);
							int idAlert = alertNewCreated.getIdAlert();
							JOptionPane.showMessageDialog(homePageFront, "A new alert has been created  " + idAlert, null, JOptionPane.INFORMATION_MESSAGE);

						}
						else {
							JOptionPane.showMessageDialog(homePageFront, error, "An error was found", JOptionPane.ERROR_MESSAGE);
						}
					}			
				}
				catch(Exception e1) {
					log.error(e1.getMessage());
				}
			}
			// Test Location 
			if(ae.getSource()==homePageFront.getButtonDisplay()) {
				
				Locations Location = new Locations ();
				System.out.println(Location.toString());
			    String serializedObject = Tools.serializeObject(Location, Location.getClass(), "");
				String jsRequest = Tools.serializeQuery(Queries.SELECT, Locations.class, serializedObject,null);
				System.out.println(serializedObject);
			    
			    
			    // String jsRequest = Tools.serializeObject(Queries.SELECT, Alerts.class, null);
				// String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);
				
			    System.out.println(jsRequest);
				try 
				{
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(error.equals(""))
					{
						List<Locations> locations = (List<Locations>) Tools.deserializeObject(answer);
						String locationsText = "";
						for(Locations location : locations)
						{
							locationsText += location+ "\n";
						}
						homePageFront.getTextArea().setText(locationsText);
					}
					else {
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}

				} 
				catch (IOException e1){
					log.error(e1.getMessage());
				} 
				catch (AllConnectionUsedException usedConnection){
					log.error(usedConnection.getMessage());
				}
			}
			
			// test user 
			/*
			if(ae.getSource()==homePageFront.getButtonDisplay()) {
				
				Users Users = new Users ();
				System.out.println(Users.toString());
			    String serializedObject = Tools.serializeObject(Users, Users.getClass(), "");
				String jsRequest = Tools.serializeQuery(Queries.SELECT, Users.class, serializedObject,null);
				System.out.println(serializedObject);
			    
			    
			    // String jsRequest = Tools.serializeObject(Queries.SELECT, Alerts.class, null);
				// String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);
				
			    System.out.println(jsRequest);
				try 
				{
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(error.equals(""))
					{
						List<Users> users = (List<Users>) Tools.deserializeObject(answer);
						String locationsText = "";
						for(Users User : users)
						{
							locationsText += User+ "\n";
						}
						homePageFront.getTextArea().setText(locationsText);
					}
					else {
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}

				} 
				catch (IOException e1){
					log.error(e1.getMessage());
				} 
				catch (AllConnectionUsedException usedConnection){
					log.error(usedConnection.getMessage());
				}
			}
			*/
			// Test Alert
			/*
			if(ae.getSource()==homePageFront.getButtonDisplay()) {
				
				Alerts Alerts = new Alerts ();
				System.out.println(Alerts.toString());
			    String serializedObject = Tools.serializeObject(Alerts, Alerts.getClass(), "");
				String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);
				System.out.println(serializedObject);
			    
			    
			    // String jsRequest = Tools.serializeObject(Queries.SELECT, Alerts.class, null);
				// String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);
				
			    System.out.println(jsRequest);
				try 
				{
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(error.equals(""))
					{
						List<Alerts> alerts = (List<Alerts>) Tools.deserializeObject(answer);
						String locationsText = "";
						for(Alerts alert : alerts)
						{
							locationsText += alert+ "\n";
						}
						homePageFront.getTextArea().setText(locationsText);
					}
					else {
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}

				} 
				catch (IOException e1){
					log.error(e1.getMessage());
				} 
				catch (AllConnectionUsedException usedConnection){
					log.error(usedConnection.getMessage());
				}
			}
			 *  /
			if(ae.getSource() == homePageFront.getButtonDelete()){
				String idInString = JOptionPane.showInputDialog(null, "Please enter the ID of the alert to delete :"
						, "Delete", JOptionPane.QUESTION_MESSAGE);

				try {				
					int id = Integer.parseInt(idInString);
					Alerts alert = new Alerts(id, "", null);
					String serializedObject = Tools.serializeObject(alert, Alerts.class, "");
					String jsRequest = Tools.serializeObject(Queries.DELETE, Alerts.class, serializedObject);
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					
					if(!error.equals("")){
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception exp){
					log.error("Failed conversion, try again...");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}

			if(ae.getSource() == homePageFront.getButtonUpdate()) {
				String idInString = JOptionPane.showInputDialog(null, "Please enter an ID of alert to update :"
						, "Updating", JOptionPane.QUESTION_MESSAGE);

				try {
					int id = Integer.parseInt(idInString);

					String newAlertName = JOptionPane.showInputDialog(null, "Please enter the new name of your alert :"
							, "Creating", JOptionPane.QUESTION_MESSAGE);

					Alerts alertUpdating = new Alerts(id, newAlertName,  null);				
					String serializedObject = Tools.serializeObject(alertUpdating, alertUpdating.getClass(), "");
					String jsRequest = Tools.serializeObject(Queries.UPDATE, Alerts.class, serializedObject);
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(!error.equals(""))
					{
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception exp){
					log.error("The convertion into an Integer did not work");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}
	*/
}