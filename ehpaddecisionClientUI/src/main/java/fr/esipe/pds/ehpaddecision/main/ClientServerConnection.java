package fr.esipe.pds.ehpaddecision.main;

import fr.esipe.pds.ehpaddecision.backend.ConnectionStarting;
import fr.esipe.pds.ehpaddecision.clientsocket.SClient;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;

public class ClientServerConnection {
	private static SClient sclient;

	
	public static ConnectionStarting callSocket()
	{
		sclient = new SClient();
		ConnectionStarting socketState = null;
		try {
			socketState = sclient.go();
		} catch (AllConnectionUsedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socketState;
	}

	
	public static SClient returnClientSocket() {
		return sclient;
	}
	
	
}
