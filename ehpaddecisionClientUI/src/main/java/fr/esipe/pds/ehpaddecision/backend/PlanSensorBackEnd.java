package fr.esipe.pds.ehpaddecision.backend;



import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;
import fr.esipe.pds.ehpaddecision.frontend.SensorPlan;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;

import fr.esipe.pds.ehpaddecision.principales.Alerts;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Users;

public class PlanSensorBackEnd implements ActionListener{

	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	private SensorPlan planSensor;
	public PlanSensorBackEnd (SensorPlan planSensor){
		this.planSensor=planSensor;
	}


	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae) {
		{
			/*
			if(ae.getSource()== planSensor.getButonAlerts()){
				System.out.println("action button test1");
				try
				{
					String  = planSensor.getTextfName().getText();
					System.out.println("Name Alerte "+nameAlert);
					if(nameAlert.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False name, try again");
					}
					else {
						// Alert test
						/*
						Alerts alert = new Alerts(nameAlert);
						System.out.println(alert.toString());
					    String serializedObject = Tools.serializeObject(alert, alert.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Alerts.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			 */
			//user test
			/*
					    Users user = new Users (nameAlert);
						System.out.println(user.toString());
					    String serializedObject = Tools.serializeObject(user, user.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Users.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);


					    /*Location test 
					    Locations location = new Locations(nameAlert);
						System.out.println(location.toString());
					    String serializedObject = Tools.serializeObject(location, location.getClass(), "");
						String jsRequest = Tools.serializeQuery(Queries.INSERT, Locations.class, serializedObject,null);
					    System.out.println(jsRequest);
					    String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);

			 */


			// to do the same lines of code for other uc, (locations, users, sensors..)
			/*
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
			 */
		/*	if(ae.getSource()==planSensor.getButonAlerts()) {
				String jsRequest = Tools.serializeObject(Queries.SELECT, Alert.class, null);
				try 
				{
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(error.equals(""))
					{
						List<Alert> alerts = (List<Alert>) Tools.deserializeObject(answer);
						for(int i=0; i < alerts.size();i++)
						{
							String jsRequest2 = Tools.serializeObject(Queries.SELECT, Sensors.class, null);
							try 
							{
								String answer2 = ClientServerConnection.returnClientSocket().sendToServer(jsRequest2);
								log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer2));
								String error2 = Tools.jsonNode(JSONExample.ERROR, answer2).trim();
								if(error.equals(""))
								{
									List<Alert> alerts2 = (List<Alert>) Tools.deserializeObject(answer2);
									
								}
							}catch (IOException e1){
								log.error(e1.getMessage());
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(planSensor, error, "Error", JOptionPane.ERROR_MESSAGE);
					}

				} 
				catch (IOException e1){
					log.error(e1.getMessage());
				} 
				catch (AllConnectionUsedException usedConnection){
					log.error(usedConnection.getMessage());
				}
			}
			/*
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
			}*/
		}

	}

}
