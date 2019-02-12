package fr.esipe.pds.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCConnectionPool {
	
	private Properties properties = new Properties();
	private List<Connection> connexions = new ArrayList<Connection>(); 
	private String url, username, password;
	//private int maxConnections;
	//private boolean waitIfBusy;
	public List<Connection> availableConnections;
	public List<Connection> busyConnections;
	public void add(List<Connection> connections) { 
		
	}
	
	public JDBCConnectionPool(){
		try {
			FileInputStream fis = new FileInputStream("src/main/resource/properties.xml");
	        System.out.println( "properties files found !" );

			properties.loadFromXML(fis);
			
	        System.out.println( "properties loaded properly!" );
	        
	        Class.forName("com.mysql.jdbc.Driver");//Set driver	        
	        
	        for(int i = 0; i <10; i++) {
		        Connection connection = (Connection) DriverManager.getConnection(properties.getProperty("url"),
		        		properties.getProperty("user"), 
		        		properties.getProperty("password"));
		        connexions.add(connection);
	        }
	        System.out.println( "properties loaded properly!" );
	        
		} catch (IOException e) {
			System.out.println("Unable to load properties from file !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Unable to create Connection !");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public  void putConnection(){
		for(int i=0; i<25; i++){
		 try {
			connexions.add(DriverManager.getConnection(properties.getProperty("url"),
			    		properties.getProperty("user"), 
			    		properties.getProperty("password")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public Connection getConnection(){	
		return connexions.remove(0);
		
	}
	
	public synchronized int totalConnections(){
		return (connexions.size());
	}
	
	public boolean free(Connection connection){
		//busyConnections.remove(connection);
		//availableConnections.add(connection);
		return connexions.add(connection);
	//Pour réveiller les threads qui attendent une connexion libre
		//notifyAll();
		
	}
	public boolean closeAll(){
		
		for (Connection connection : connexions)
		{
			try {
				connection.close();
			} catch (SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
		
		
		
	/*closeConnections(availableConnections);
		availableConnections = new ArrayList<Connection>();
		closeConnections(busyConnections);
		busyConnections = new ArrayList<Connection>();*/
	}
	
	/*private void closeConnections(List<Connection> connection) {
		try {
			for (int i=0; i < connection.size(); i++){
				Connection connection2 = (Connection) connection
			}
		}
		 TODO Auto-generated method stub	
	}*/

	
	
	/*public synchronized String toString(){
		String info = "ConnectionPool (" + url +"," + username +")" + ", available =" + availableConnections.size() 			+ ", busy =" + busyConnections.size() + ", max=" + maxConnections;
		return (info);
	}*/

}
