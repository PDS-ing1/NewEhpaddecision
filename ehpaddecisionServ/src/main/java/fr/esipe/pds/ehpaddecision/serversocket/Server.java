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
	// TODO no more brute value in code, all values should be in the properties file
	private ServerSocket serverSocket;
	private static final int server_port =7070;
	
	public Server(){
		con = null;
	}
	
	// turn on the connection pool 
	// give access to client to connect
	// TODO remove sysout at the end 
	public void launch(){
		log.info("The server is launching ! ");
		DataSource.startConnectionPool();
		//JDBCConnectionPool dt = new JDBCConnectionPool();
		
		try { 
			serverSocket = new ServerSocket(server_port);
				if (true ) {
					log.info("The server is ready, waiting a request from a client...");
					Socket socket = serverSocket.accept();
					con = DataSource.getConnection(null, null, null);
					System.out.println("A client is on line");
					ServerHandler srvHandler = new ServerHandler(socket, con);
					Thread cth = new Thread(srvHandler);
					cth.start();
				}
		}catch (Exception e){
			log.error("Sorry, something is wrong with the server : " + e.getMessage());
			DataSource.closeConnectionPool();
		}
	}
	
}
