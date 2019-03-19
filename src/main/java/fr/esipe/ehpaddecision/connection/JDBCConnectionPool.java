package fr.esipe.ehpaddecision.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import org.apache.log4j.BasicConfigurator;

public class JDBCConnectionPool {
	InputStream input = null;
	private Properties properties = new Properties();
	private List<Connection> connexions = new ArrayList<Connection>(); 
	public List<Connection> availableConnections;
	public List<Connection> busyConnections;
	public void add(List<Connection> connections) { 
		
	}
	
	public JDBCConnectionPool(){
	/*	try {
			FileInputStream fis = new FileInputStream("src/main/resource/properties.xml");
	        System.out.println( "properties files found !" );

			properties.loadFromXML(fis);
			
	        System.out.println( "properties loaded properly!" );
	        
	        Class.forName("com.mysql.jdbc.Driver");//Set driver	        
	        
	        for(int i = 0; i <1; i++) {
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
		}*/
		
	}
	
	
	public  void putConnection() throws IOException{
		int countConnection = GetConnectionCountFromFile();
	
		input = new FileInputStream("src/main/resource/properties.xml");
		properties.loadFromXML(input);

		if(countConnection <= 2){
		 try {
			connexions.add(DriverManager.getConnection(properties.getProperty("url"),
			    		properties.getProperty("user"), 
			    		properties.getProperty("password")));
			// add a connection ==> incrementation of the queue
			AddConnectionCountFromFile();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		System.out.println("connection number after auth =" + GetConnectionCountFromFile());
		  BasicConfigurator.configure();
	}
	public Connection getConnection(){	
		return connexions.get(0);
		
	}
	
	/**This fonction load the file */
	private FileReader LoadConnectionFile() throws FileNotFoundException{
		System.out.println("Loading file ...");
		return new FileReader("src/main/resource/ConnectionCount.config");
	}
	
	/** This fontion get the count of connection in pool */
	private int GetConnectionCountFromFile(){
		try{
		FileReader file = LoadConnectionFile();
		BufferedReader br = new BufferedReader(file);
		return Integer.parseInt(br.readLine());
		}catch(Exception e){
			return 0;
		}
	}
	
	/**This fonction add the connection */
	@SuppressWarnings("resource")
	private void AddConnectionCountFromFile() throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = null;
		int count = GetConnectionCountFromFile();
		System.out.println(count);
		fw = new FileWriter("src/main/resource/ConnectionCount.config");
		bw = new BufferedWriter(fw);
		bw.write(count+1);
		BufferedWriter writer = new BufferedWriter(fw);
		System.out.println(count);
		writer.write(new Integer(count+1).toString());
		writer.close();
	}
	
	//This fonction delete the connection
	private void DeleteConnectionCountFromFile() throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = null;
		int count = GetConnectionCountFromFile();
		System.out.println(count);
		fw = new FileWriter("src/main/resource/ConnectionCount.config");
		bw = new BufferedWriter(fw);
		bw.write(count+1);
		BufferedWriter writer = new BufferedWriter(fw);
		System.out.println(count);
		writer.write(new Integer(count-1).toString());
		writer.close();
		
	}
	public synchronized int totalConnections(){
		return (connexions.size());
	}
	
	public boolean free(Connection connection){
		return connexions.add(connection);
	}
	
	public boolean closeAll() throws IOException{
		DeleteConnectionCountFromFile();
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

	
	
	

}
