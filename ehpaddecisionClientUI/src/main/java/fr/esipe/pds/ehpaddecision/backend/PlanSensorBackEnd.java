
package fr.esipe.pds.ehpaddecision.backend;



import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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

import fr.esipe.pds.ehpaddecision.principales.Alert;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.User;

public class PlanSensorBackEnd implements ActionListener, WindowListener{

	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	private SensorPlan planSensor;
	JButton boutonSensor;

	public PlanSensorBackEnd (SensorPlan planSensor){
		this.planSensor=planSensor;
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
				System.out.println(sensors);



				for(int i = 0; i< sensors.size();i++)
				{
					System.out.print("TOTO HELLO10");
					//TODO : ajouter la condtion if sensors.get(0).getState() == ?


					if(sensors.get(i).getMode().toUpperCase() == "ON")
					{
						System.out.print("TOTO HELLO On");
						boutonSensor = new JButton (sensors.get(i).getMacAdress());
						boutonSensor.setBackground(Color.GREEN);
						boutonSensor.setVisible(true);

						switch(sensors.get(i).getLocation().toUpperCase().trim())
						{
						
						case "KITCHEN":

							planSensor.getKitchenn().add(boutonSensor);
							break;

						case "LIBRARY":

							planSensor.getLibraryy().add(boutonSensor);
							break;

						case "LIVING ROOM":

							planSensor.getLivingRoom().add(boutonSensor);
							break;

						case "DINNING ROOM":

							planSensor.getDinningRoom().add(boutonSensor);
							break;

						case "CORRIDOR1":

							planSensor.getCorridorr1().add(boutonSensor);
							break;

						case "CORRIDOR2":

							planSensor.getCorridorr2().add(boutonSensor);
							break;

						case "CORRIDOR3":

							planSensor.getCorridorr3().add(boutonSensor);
							break;

						case "CORRIDOR4":

							planSensor.getCorridorr4().add(boutonSensor);
							break;

						default :
							break;


						}


					}else 
					{


						boutonSensor = new JButton (sensors.get(i).getMacAdress());
						
						boutonSensor.setBackground(Color.GRAY); 
						boutonSensor.setVisible(true);
						System.out.print("TOTOHELLOOFF");
						System.out.print(sensors.get(i).getLocation().toUpperCase().trim());

						switch(sensors.get(i).getLocation().toUpperCase().trim())
						{
						case "KITCHEN":

							planSensor.getKitchenn().add(boutonSensor);
							break;

						case "LIBRARY":

							planSensor.getLibraryy().add(boutonSensor);
							break;

						case "LIVING ROOM":

							System.out.print("BonneNuit");
							planSensor.getLivingRoom().add(boutonSensor);
							//planSensor.getContentPane().add(boutonSensor);
							//planSensor.repaint();
							
							break;

						case "DINNING ROOM":

							planSensor.getDinningRoom().add(boutonSensor);
							break;
							
						case "CORRIDOR1":

							planSensor.getCorridorr1().add(boutonSensor);
							break;

						case "CORRIDOR2":

							planSensor.getCorridorr2().add(boutonSensor);
							break;
							
						case "CORRIDOR3":

							planSensor.getCorridorr3().add(boutonSensor);
							break;
							
						case "CORRIDOR4":

							planSensor.getCorridorr4().add(boutonSensor);
							break;
							
						default:
							System.out.print("Bonsoir");
							break;


						}

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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	 
}
