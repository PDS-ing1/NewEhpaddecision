package fr.esipe.pds.ehpaddecision.backend;
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
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alerts;

public class HomeBackEnd implements ActionListener
{
	
	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	 
	private HomePageFront homePageFront;
	
	public HomeBackEnd (HomePageFront homePageFront){
		this.homePageFront=homePageFront;
	}
	

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae) {
		{
			if(ae.getSource()== homePageFront.getButtonNew())
			{
				try
				{
					String nameAlert = homePageFront.getTextfName().getText();
					System.out.println("Name Alerte "+nameAlert);
					if(nameAlert.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False name, try again");
					}
					else
					{
						Alerts alert = new Alerts(nameAlert);
						System.out.println("mon alerte "+alert.toString());
						String serializedObject = Tools.serializeObject(alert, alert.getClass(), "");
						String jsRequest= "INSERT INTO ALERT (ID_ALERT, NAME, CREATION_DATE) VALUES (2, 'Default')";
						//String jsRequest = Tools.serializeObject(Queries.INSERT, Alerts.class, serializedObject);
						System.out.println("SQL Query " +jsRequest);
						System.out.println("jsRequest"+jsRequest.toString());				
						String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
						System.out.println("Answer"+ answer);
						log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
						String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
						if(error.equals(""))
						{
							Alerts alertNewCreated = (Alerts)Tools.deserializeObject(answer);
							int idAlert = alertNewCreated.getIdAlert();
							JOptionPane.showMessageDialog(homePageFront, "A new alert has been created  " + idAlert, null, JOptionPane.INFORMATION_MESSAGE);

						}
						else
						{
							JOptionPane.showMessageDialog(homePageFront, error, "Une erreur a été trouvée", JOptionPane.ERROR_MESSAGE);
						}
					}			
				}
				catch(Exception e1)
				{
					log.error(e1.getMessage());
				}
			}
			if(ae.getSource()==homePageFront.getButtonDisplay())
			{
				String jsRequest = Tools.serializeObject(Queries.SELECT, Alerts.class, null);
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
					else
					{
						JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
					}

				} 
				catch (IOException e1) 
				{
					log.error(e1.getMessage());
				} 
				catch (AllConnectionUsedException usedConnection) 
				{
					log.error(usedConnection.getMessage());
				}
			}

			if(ae.getSource() == homePageFront.getButtonDelete())
			{
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
					if(!error.equals(""))
					{
						JOptionPane.showMessageDialog(homePageFront, error, "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception exp)
				{
					log.error("Failed conversion, try again...");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}

			if(ae.getSource() == homePageFront.getButtonUpdate())
			{
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
				catch(Exception exp)
				{
					log.error("The convertion into a Integer did not work");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}
}