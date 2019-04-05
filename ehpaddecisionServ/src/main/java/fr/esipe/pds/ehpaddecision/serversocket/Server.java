package fr.esipe.pds.ehpaddecision.serversocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;


public class Server {
	private final Logger log = LoggerFactory.getLogger(Server.class);
	private static Connection con;
	
	private ServerSocket serverSocket;
	//private static final int ;
	
	public Server(){
		con = null;
	}
	
	// turn on the connection pool 
	// give access to client to connect
	
	public void launch(){
		log.info("The server is launching ! ");
		DataSource.startConnections();
		
		try { 
			serverSocket = new ServerSocket(nbPort);
			while (true) {
				if (DataSource.connectionsAvailable() > 0 ) {
					log.info("The server is ready, waiting a request from a client...");
					Socket socket = serverSocket.accept();
					con = DataSource.getConnection();
					ServerHandler srvHandler = new ServerHandler(socket, con);
					Thread cth = new Thread(srvHandler);
					cth.start();
					
				}
			}
		}catch (Exception e){
			log.error("Sorry, something is wrong with the server : " + e.getMessage());
			DataSource.closeConnections();
		}
	}
	
}
