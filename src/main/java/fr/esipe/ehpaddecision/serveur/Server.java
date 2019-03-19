package fr.esipe.ehpaddecision.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

	/**
	 * This class implements java Socket server
	 * @author 
	 *
	 */
public class Server implements Runnable {  
	
	     private Gson gson;
	    //static ServerSocket variable
	    private static ServerSocket server;
	    //socket server port on which it will listen
	    private static int port = 8855;
	    
	    public static void main(String args[]) throws IOException, ClassNotFoundException{
	        //create the socket server object
	        server = new ServerSocket(port);
	        //keep listens indefinitely until receives 'exit' call or program terminates
	        while(true){
	            System.out.println("Wait a request to handle");
	            
	            //creating socket and waiting for client connection
	            Socket socket = server.accept();
	            //To convert queries to json and to get back json file
	        	  
	        	// creation of the json converter
				GsonBuilder builder = new GsonBuilder();
				gson = builder.setPrettyPrinting().create(); // PrettyPrinting to have a readable result
	            
	            //read from socket to ObjectInputStream object
	            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
	            
	            //convert ObjectInputStream object to String
	            String message = (String) ois.readObject();
	           
	            System.out.println("Message Received: " + message);
	            //create ObjectOutputStream object
	            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	            //write object to Socket
	            oos.writeObject("Hi Client "+message);
	            //close resources
	            ois.close();
	            oos.close();
	            socket.close();
	            
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
		@Override
		// how the server will work (behavior)
		public void run(){
			while (!serversocket.isClosed())
				AcceptConnection();
		}
	    
	}

