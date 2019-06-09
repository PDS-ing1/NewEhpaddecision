package fr.esipe.pds.ehpaddecision.clientsocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.backend.ConnectionStarting;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.main.EhpadMain;

// S as Socket 
public class SClient {
	// to add logs
	
	
	// TODO add address_ip in properties file, and remove the unuseful comments
	// TODO no value directly in code is allowed, to be removed and put it in the properties file.
	private final String ADRESS_IP = "localhost";
	private final int N_PORT = 7070;
	private static  final Logger log = LoggerFactory.getLogger(EhpadMain.class);

	private BufferedReader readFromServer;
	private PrintWriter writeToServer;
	
	// Set a delay for the the server, after this delay we will send a timeout error, this timeout is not ON now.
	private final int TIMEOUT = 2000;
	private Socket socket;
	
	public void SClient(){
	}

	public ConnectionStarting go() throws AllConnectionUsedException{
		
		try {
			// log 
			// connection to one socket
			log.info(ADRESS_IP);
			socket = new Socket(ADRESS_IP, N_PORT);
			// if the servers takes a long time to send an answer, we will send that as a timeout
			//socket.setSoTimeout(TIMEOUT); // turn off the timeout for some tests
			// for read from Server and write to it
			
			
			writeToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);	
			readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
	
			/*String error = readFromServer.readLine();
			System.out.println(" error " + error);
			if (error.equalsIgnoreCase(ConnectionStarting.CONNECTION_PROBLEM.getMessage())){	
				throw new AllConnectionUsedException();
			}*/
				log.info("Connected to the server");
				//String s= "INSERT INTO ALERT (ID_ALERT, NAME, CREATION_DATE) VALUES (1 , 'Default' , null )";
				return ConnectionStarting.WELLDONE;
			}
			catch (Exception e){
			log.error("Disconnected."+  e.getMessage());
		}
			return ConnectionStarting.CONNECTION_PROBLEM;
	}

	
	public String sendToServer(String requestToSendToServer) throws IOException, AllConnectionUsedException
	{
		String answerServerClient = "";
		
		
		// Send the request to the server
		System.out.println("WriteToServer will be executed");
		System.out.println(requestToSendToServer);
		writeToServer.println(requestToSendToServer);
		System.out.println("WriteToServer have been executed");
		
		
		// Receive an answer from the the server
		answerServerClient = readFromServer.readLine();
		System.out.println("toto6");
		return answerServerClient;
	}
		
	
	public void closeCommunication()
	{
		try {
			readFromServer.close();
			writeToServer.close();
			socket.shutdownOutput();
			log.info("No more communication");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
