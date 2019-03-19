package fr.esipe.ehpaddecision.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Server extends Thread {

	// the server
	private ServerSocket serversocket;
	
	//To convert queries to json and to get back json file
	private Gson gson; 
	/** this constructor is used to create a server on the port XXXX 
	 * using listen port
	 */
	Server(){
		try{
			// create the port 
			int serverPort = 8081; // the port used 
			serversocket = new ServerSocket(serverPort); //
			
			// creation of the json converter
			GsonBuilder builder = new GsonBuilder();
			gson = builder.setPrettyPrinting().create(); // PrettyPrinting to have a readable result
		} catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	/** this fonction should be able to accept the communication between the client and the server 
	 * and establish it
	 * protocol used between the client and the server
	 */
	
	private void AcceptConnection(){
		try{
			
			// Accept client's request to connect to the server
			Socket client = this.serversocket.accept();
		
			// the obejct that allows us to recieve a requeste from the client 
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			// the object that allows us to send a response to the client
			PrintWriter output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
			
						
			// while the cliend is connected 
			while (!client.isClosed()){
				
				// if the request has been sent 
				if(input.ready()){
					
					// receive the request and convert it to Json
					String request = gson.fromJson(input.readLine(), String.class);
					
					
					// once the client is disconnected close the communication
					if (null == request)
						client.close();
					// else print his request
					else 
						System.out.println(request);
					}
				}
			}catch (IOException ex) {
				System.out.println(" Sorry, we lost the connection.. please reach out to us if the problem persists");
		}
	}
	// how the server will work (behavior)
	public void run(){
		while (!serversocket.isClosed())
			AcceptConnection();
	}
	// the main method to launch and run the server
	
	public static void main (String[] args){
		Server server = new Server();
		server.run();
		
	}
	
	
	
	
}
