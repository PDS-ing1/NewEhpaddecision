package fr.esipe.pds.ehpaddecision.start;

import fr.esipe.pds.ehpaddecision.serversocket.Server;

/**
 * This main class will launch the server
 */

public class Launcher {
	public static void main(String [] args){
		System.out.println("fff");
		Server server = new Server();
		server.launch();
	}
}
