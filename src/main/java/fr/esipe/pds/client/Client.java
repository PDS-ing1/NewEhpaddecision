package fr.esipe.pds.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public Client(String host, int port) {
		try {
			String serverHostname = new String ("127.0.0.1");
			System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");
			
			Socket outputsocket = null; 
			PrintWriter output = null;
			BufferedReader input = null;
			
			try { 
				outputsocket = new Socket(serverHostname, 8081); 
				output = new PrintWriter(outputsocket.getOutputStream(), true);
				input = new BufferedReader(new InputStreamReader(outputsocket.getInputStream()));
			} catch (IOException e){
				System.err.println("Unknown host" + serverHostname);
				System.exit(1);
			} //catch (IOException e){ 
				//System.err.println("Unable to get streams from server");
				//System.exit(1);
			//}
			  BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			   while (true) {
	                System.out.print("client: ");
	                String userInput = stdIn.readLine();
	                /** Exit on 'q' char sent */
	                if ("q".equals(userInput)) {
	                    break;
	                }
	                output.println(userInput);
	                System.out.println("server: " + input.readLine());
	            }
			   /** Closing all the resources */
	            output.close();
	            input.close();
	            stdIn.close();
	            outputsocket.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		}
	//}

	public static void main(String args[]) {
       String host = "127.0.0.1";
        int port = 8081;
        new Client(host, port);
    }
}
