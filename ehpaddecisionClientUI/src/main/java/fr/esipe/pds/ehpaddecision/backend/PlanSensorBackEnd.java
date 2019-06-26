package fr.esipe.pds.ehpaddecision.backend;



import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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



public class PlanSensorBackEnd implements ActionListener,  WindowListener{

	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	private SensorPlan planSensor;
	public PlanSensorBackEnd (SensorPlan planSensor){
		this.planSensor=planSensor;
	}

	public void fillFrame(JPanel kitchen, JPanel library, JPanel livingRoom, JPanel dinningRoom, JPanel  corridor1, JPanel corridor2, JPanel corridor3, JPanel corridor4)
	{
	
			Sensors sensor  = new Sensors();
			System.out.println(sensor.toString());
			String serializedObject = Tools.serializeObject(sensor, sensor.getClass(), "");
			String jsRequest = Tools.serializeQuery(Queries.SELECT, Sensors.class, serializedObject, null);
			System.out.println(jsRequest);
			System.out.println("toto Boum");
			ClientServerConnection.callSocket();
			System.out.print("TOTOOOOO");

			try 
			{
				String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
				System.out.print("TOTOOOOO");
				System.out.print(answer);
				log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
				String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
				if(error.equals(""))
				{
					System.out.print("TOTO HELLO");
					List<Sensors> sensors = (List<Sensors>) Tools.deserializeObject(answer);
					System.out.print("TOTO HELLO5");
					System.out.println(answer);

					while (!sensors.isEmpty())
					{
						System.out.print("TOTO HELLO10");
						//TODO : ajouter la condtion if sensors.get(0).getState() == ?
						
					  if(sensors.get(0).getMode().toLowerCase() == "on")
						  {
						  System.out.print("TOTO HELLO On");
								  JButton boutonSensor = new JButton (sensors.get(0).getMacAdress());
								  boutonSensor.setBackground(Color.GREEN);
								  boutonSensor.setVisible(true);
								  
								  if(sensors.get(0).getLocation().toUpperCase()== "KITCHEN")
								  {
									  kitchen.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "LIBRARY")
								  {
									  library.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation()== "Living room")
								  {
									  livingRoom.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "DINNING ROOM")
								  {
									  dinningRoom.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR1")
								  {
									  corridor1.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR2")
								  {
									  corridor2.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR3")
								  {
									  corridor3.add(boutonSensor);
									  
								  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR4")
								  {
									  corridor4.add(boutonSensor);
									  
								  }else 
								  {
									  
								  }
								  //sensors.remove(0);
									  
						  }else 
						  {
							  System.out.print("TOTO HELLO OFF");
							  
							  JButton boutonSensor = new JButton (sensors.get(0).getMacAdress());
							  boutonSensor.setBackground(Color.GRAY); 
							  boutonSensor.setVisible(true);
							  System.out.print("TOTO HELLO OFF");
							  
							  if(sensors.get(0).getLocation().toUpperCase()== "KITCHEN")
							  {
								  kitchen.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "LIBRARY")
							  {
								  library.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation()== "Living room")
							  {
								  livingRoom.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "DINNING ROOM")
							  {
								  dinningRoom.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR1")
							  {
								  corridor1.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR2")
							  {
								  corridor2.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR3")
							  {
								  corridor3.add(boutonSensor);
								  
							  }else if (sensors.get(0).getLocation().toUpperCase()== "CORRIDOR4")
							  {
								  corridor4.add(boutonSensor);
								  
							  }else 
							  {
								  
							  }
							  //sensors.remove(0);
						  }
					  
					 
					}
				} 
			}
			catch (IOException e1){
				log.error(e1.getMessage());
			}
			catch (AllConnectionUsedException usedConnection){
				log.error(usedConnection.getMessage());
			}

		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
