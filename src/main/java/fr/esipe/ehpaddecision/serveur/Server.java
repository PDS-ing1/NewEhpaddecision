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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

	/**
	 * This class implements java Socket server
	 * @author 
	 *
	 */
public class Server implements Runnable {  
	
	     private static Gson gson;
		private Object serversocket;
	    //static ServerSocket variable
	    private static ServerSocket server;
	    //socket server port on which it will listen
	    private static int port = 8855;
	    private static Properties properties = new Properties();
		private List<Connection> connexions = new ArrayList<Connection>(); 
	    
	    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
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
	            String[] parts = message.split(";");
	            String action = parts[0];
	            String data = parts[1];
	            
	            if(action.equals("Create")){
	            	Create(data);
	            	message = "Create";
	            }
	            
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
				Socket client = ((ServerSocket) this.serversocket).accept();
			
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
			while (!((ServerSocket) serversocket).isClosed())
				AcceptConnection();
		}
		
		private static Connection openConnection() throws SQLException{
			Connection connection = null;
			/*connexions.add(DriverManager.getConnection(properties.getProperty("url"),
		    		properties.getProperty("user"), 
		    		properties.getProperty("password")));*/
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pds?serverTimezone=UTC","root", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
			
		}
	    
		public static void Create(String mode) throws SQLException{
			Connection connection=openConnection();
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement ps=null;
			 
			try {
				stmt = connection.createStatement();
				int autoIncKeyFromFunc = -1;
			    rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

			    if (rs.next()) {
			        autoIncKeyFromFunc = rs.getInt(1);
			    }
			    if (autoIncKeyFromFunc == 0)
			    	autoIncKeyFromFunc = 1;
			    
			    System.out.println("====================> " + autoIncKeyFromFunc);
				String query="insert into capteurs (idCapteurs,mode) values (?,?)";
				ps=connection.prepareStatement(query);
				ps.setInt(1, autoIncKeyFromFunc);
				ps.setString(2, mode);
				System.out.println(ps);
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Read() throws SQLException{
			Connection connection=openConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				String query="select * from capteurs";
				ps=connection.prepareStatement(query);
				//ps.setString(1, sl_no);
				System.out.println(ps);
				rs=ps.executeQuery();
				while(rs.next()){
				System.out.println("mode > " + rs.getString("mode"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Update(String mode, int idCapteurs) throws SQLException{
			Connection connection=openConnection();
			PreparedStatement ps=null;
			try {
				String query="update capteurs set mode=? where idCapteurs=?";
				ps=connection.prepareStatement(query);
				ps.setString(1, mode);
				ps.setInt(2, idCapteurs);
				System.out.println(ps);
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void Delete(int idCapteurs)throws SQLException{
			Connection connection=openConnection();
			PreparedStatement ps=null;
			try {
				String query="delete from capteurs where idCapteurs=?";
				ps=connection.prepareStatement(query);
				ps.setInt(1, idCapteurs);
				System.out.println(ps);
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

