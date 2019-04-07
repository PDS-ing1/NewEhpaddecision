package fr.esipe.pds.ehpaddecision.main;

import fr.esipe.pds.ehpaddecision.backend.ConnectionStarting;
import fr.esipe.pds.ehpaddecision.clientsocket.SClient;

public class ClientServerConnection {
	private static SClient sclient;

	
	public static ConnectionStarting callSocket()
	{
		sclient = new SClient();
		ConnectionStarting socketState = sclient.go();
		return socketState;
	}

	
	public static SClient returnClientSocket() {
		return sclient;
	}
	
	
}
