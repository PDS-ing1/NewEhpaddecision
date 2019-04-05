package fr.esipe.pds.ehpaddecision.clientsocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import fr.esipe.pds.ehpaddecision.*;
import fr.esipe.pds.ehpaddecision.backend.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.backend.ConnectionStarting;






// S as Socket 
public class SClient {
	// to add logs
	//private static final Logger log = 
	
	// TODO add address_ip in properties file
	//private final String ADRESS_IP = Extensions.getBalise("address_ip");
	//private final int N_PORT = Integer.parseInt(Extensions.getBalise("n_port"));
	
	private BufferedReader readFromServer;
	private PrintWriter writeToServer;
	
	// Set a delay for the the server, after this delay we will send a timeout error
	
	private final int TIMEOUT = 2000;
	private Socket socket;
	
	public void SClient(){
	}

	public ConnectionStarting go(){
		try {
			// log 
			
			// connection to one socket
			//socket = new Socket(ADRESS_IP, N_PORT);
			
			// if the servers takes a long time to send an answer, we will send that as a timeout
			socket.setSoTimeout(TIMEOUT);
			// for read from Server and write to it
			readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writeToServer = new PrintWriter(socket.getOutputStream(), true);		
			
			
	
			String str = readFromServer.readLine();
			{
				throw new AllConnectionUsedException();
			}	
						//log.info("Connected to the server");*
				//return ConnectionStarting.WELLDONE;
			}
			catch (AllConnectionUsedException e) 
			{
				//log.error("Disconnected from server - Client Error : " + e.getMessage());
				return ConnectionStarting.CONNECTION_PROBLEM;
				
			} 
			catch (SocketTimeoutException e) 
			{
				//log.error("The socket timed out : " + e.getMessage() + ".\nThe server cannot  be reach and cannot response to your last request !");
			}
			catch (Exception e) {
				//log.error("Disconnected from server - Client Error : " + e.getMessage());
			}
			return ConnectionStarting.CONNECTION_PROBLEM;
	}

	
	public String sendToServer(String requestToSendToServer) throws IOException, AllConnectionUsedException
	{
		String answerServerClient = "";
		
		//log.info("Request sent to the server :\n" + Util.indentJsonOutput(requestToSendToServer));
		
		// Send the request to the server
		writeToServer.println(requestToSendToServer);

		// Receive an answer from the the server
		answerServerClient = readFromServer.readLine();
		
		return answerServerClient;
	}
		
	
	public void closeCommunication()
	{
		try {
			readFromServer.close();
			writeToServer.close();
			socket.shutdownOutput();
			//log.info("No more communication");
		} catch (IOException e) {
			//log.error(e.getMessage());
		}
	}

}
