package fr.esipe.pds.ehpaddecision.connectionpool;

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
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
/**
 * 
 * 
 *
 */
public class JDBCConnectionPool implements InterfaceJDBCConnectionPool {
    private static final Logger log = LoggerFactory.getLogger(JDBCConnectionPool.class);
	InputStream input = null;
	private Properties properties = new Properties();
	//private List<Connection> connexions = new ArrayList<Connection>(); 
	private final String URL             =  Tools.propertiesFileHandler("url");
	private final String USER            =  Tools.propertiesFileHandler("username");
	private final String PSWD            =  Tools.propertiesFileHandler("pswd");
	private int nbConnectionPool;
	private Vector<Connection> connexions;
	private int nbConnections;
	

	
	/*public JDBCConnectionPool(){
		try {
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
		}
		
	}*/
	
	public JDBCConnectionPool(){
		connexions = new Vector<Connection>();
		nbConnectionPool = 0;
		try{
			nbConnectionPool =Integer.parseInt((Tools.propertiesFileHandler("nb_connection"))) ;
		}catch (Exception e){
			nbConnectionPool = 5;
		}
	}
	
	/*public  void putConnection() throws IOException{
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
	}*/
	
	public Vector<Connection> returnConnections() {
		return connexions;
	}
	public Connection getConnection() throws Exception{	
		if (!connexions.isEmpty())
		{
			Connection con = connexions.lastElement();
			connexions.removeElement(connexions);
			poolReady();
			log.info("One connection was taken from the pool");
			return con;
		}
		else
			throw new Exception ("Sorry, your pool is empty of connections");
	}
	
	/**This function load the file */
	/*
	private FileReader LoadConnectionFile() throws FileNotFoundException{
		System.out.println("Loading file ...");
		return new FileReader("src/main/resource/ConnectionCount.config");
	}
	*/
	
	/** This function get the count of connection in pool */
	/*
	 * private int GetConnectionCountFromFile(){
		try{
		FileReader file = LoadConnectionFile();
		BufferedReader br = new BufferedReader(file);
		return Integer.parseInt(br.readLine());
		}catch(Exception e){
			return 0;
		}
	}*/

	/**This function add the connection */
	/*
	 * @SuppressWarnings("resource")
	 
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
	}*/
	
	/**This function delete the connection*/
	/*
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
		
	}*/
	
	public synchronized int totalConnections(){
		return (connexions.size());
	}
	
	public void free(Connection connection){
		if (connection != null){
			connexions.add(connection);
			log.info("A free connection is available. Plus one connection in the pool");
		}
		poolReady();
		
	}
	
	public void closeAll(){
		//DeleteConnectionCountFromFile();
		for (Connection con: connexions)
		{
			try { 
				 if(!con.isClosed());
				 {
					 con.close();
					 log.info("One connection closed has been closed");
				 }
			}catch 
				(SQLException e){
				log.error("Sorry, some problems with your connection, cannot close it");
			}
		}
	}
			
	// this method wil declare that the pool is ready to be used
	public void poolReady() {
		String ready = "Hello, your pool is ready + ";
		log.info("Please, your pool has been created and it is ready now ");
		
	}
	
	public void loadConnectionsList() throws SQLException{
		// TODO Auto-generated method stub
		for (int i = 0; i< nbConnections; i++){
			Connection newConnection = this.newConnection();
		}
	}

	
	private Connection newConnection(){
		Connection con = null; 
		try {
			   con = DriverManager.getConnection(URL, USER, PSWD);
	            nbConnections++;
		} catch (SQLException e) {
            log.error("Sorry, something is wrong with this connection :\n" + e.getMessage());
        }
		return con;
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

