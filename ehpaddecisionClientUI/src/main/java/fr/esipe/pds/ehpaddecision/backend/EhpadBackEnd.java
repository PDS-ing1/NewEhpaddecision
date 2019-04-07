package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;

public class EhpadBackEnd extends WindowAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(EhpadBackEnd.class);

	private  EhpadBackEnd ehpadbackend;	

	public EhpadBackEnd(EhpadBackEnd ehpadbackend) {
		this.ehpadbackend = ehpadbackend;
	}	

	
	public void windowClosing(WindowEvent e) {
		exit();
	}	

	private void exit()
	{
		log.info("Awesome, the application is closed");
		try {
			ClientServerConnection.returnClientSocket().closeCommunication();
		} catch (Exception e) {
			log.error("Sorry, something is wrong with exiting of this socket :\n" + e.getMessage());
		}
		System.exit(0);		
	}

}

