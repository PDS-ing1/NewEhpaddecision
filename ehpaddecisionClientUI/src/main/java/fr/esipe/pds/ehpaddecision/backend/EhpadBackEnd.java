package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import fr.esipe.pds.ehpaddecision.frontend.SensorPlan;
import fr.esipe.pds.ehpaddecision.frontend.Sensors_Add;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;

public class EhpadBackEnd extends WindowAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(EhpadBackEnd.class);

	private  EhpadBackEnd ehpadbackend;

	private Sensors_Add sensors_Add;	

	public EhpadBackEnd(EhpadBackEnd ehpadbackend) {
		this.ehpadbackend = ehpadbackend;
	}	

	
	public EhpadBackEnd(EhpadPage ehpadPage) {
		// TODO Auto-generated constructor stub
	}


	public EhpadBackEnd(Sensors_Add sensors_Add) {
		// TODO Auto-generated constructor stub
		this.sensors_Add = sensors_Add;
	}


	public void windowClosing(WindowEvent e) {
		exit();
	}	

	private void exit()
	{
		log.info("Awesome, the application is closed");
		try {
			ClientServerConnection.returnClientSocket().closeCommunication();
			SensorPlan sensorPlan = new SensorPlan(2);
		} catch (Exception e) {
			log.error("Sorry, something is wrong with exiting of this socket :\n" + e.getMessage());
		}
		System.exit(0);		
	}

}

