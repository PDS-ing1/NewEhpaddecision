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
 */public class JDBCConnectionPool implements InterfaceJDBCConnectionPool {
		
	    private Vector<Connection> connections;
	    private static final Logger log = LoggerFactory.getLogger(JDBCConnectionPool.class);
	    private final String URL             =  Tools.propertiesFileHandler("url");
	    private final String USER            =  Tools.propertiesFileHandler("username");
	    private final String PSWD            =  Tools.propertiesFileHandler("password");
	    private int numberOfConnections;
	    private int numberOfConnectionsCreated;
		
		public JDBCConnectionPool() {
			connections = new Vector<Connection>();
			numberOfConnectionsCreated = 0;
			log.info("Database URL : " + URL);
			try
			{
				numberOfConnections = Integer.parseInt(Tools.propertiesFileHandler("nb_connection"));
			}
			catch(Exception e)
			{
				log.error("File unloaded from properties !");
				numberOfConnections = 10;
			}

			log.info(numberOfConnections + " connection(s) should be put inside the connection pool.");
		} 
		

		public void fillConnectionsList() throws SQLException {		
					
	        for (int i = 0; i < numberOfConnections; i++ )
	        {
	        	Connection createdConnection = this.createConnection(); 
	        	if(createdConnection != null) {
	                connections.addElement(createdConnection);
	                log.info("A connection has been created and is being added to the pool. (" + ( (i+1) + "/" + numberOfConnections) + ")" );
	        	}
	        	else {
	        		log.error("Some erros faced the creation of the connection so your connections are equals to null !");
	        
	        		throw new SQLException("A connection is equal to null !");
	        	}
	        }
	        displayConnectionPoolState();
		}

		public Connection getConnection() throws Exception {
			if(!connections.isEmpty())
			{
				Connection connection = connections.lastElement();
		        connections.removeElement(connection);
				log.info("A connection is being retrieved from the conection pool.");
				displayConnectionPoolState();
		        return connection; 
			}
			else
			{
				throw new Exception("There are no connections left in the connection pool ! Please try later.");
			}     
		}

		public void putConnection(Connection connection) {
			if(connection != null)
			{
				connections.addElement(connection);	
				log.info("A connection is being added to the connection pool.");			
			}
			displayConnectionPoolState();
			
		}

		public void closeAllConnections() {
			for(Connection connection : connections)
			{
				try {
					if(!connection.isClosed())
					{
						connection.close();	
						log.info("A connection has been closed.");
					}
				} catch (SQLException e) {
		            log.error("An error occurs during the closing of the connection :\n" + e.getMessage());
				}
			}
		}
			
		
	    public Vector<Connection> getConnections() {
			return connections;
		}


		private Connection createConnection(){
	        Connection connection = null;
	        try {
	        	System.out.println("JE SUSI LA 1");
	        	connection = DriverManager.getConnection(URL, USER, PSWD);
	            numberOfConnectionsCreated++;
	            System.out.println("JE SUSI LA ");
	        } catch (SQLException e) {
	            log.error("A SQL Exception has been raised during the creation of a connection :\n" + e.getMessage());
	        }
	        return connection;
	    }  

		public int connectionStillAlives(){
			return connections.size();
		}
		
		private void displayConnectionPoolState()
		{
			String creation  = "- Connection created   : " + numberOfConnectionsCreated;
			String remaining = "- Actual connection: " + connectionStillAlives();
			String end 		 = "------------------------------------";
			log.info("Connection pool state :\n" + creation + "\n" + remaining + "\n" + end + "\n");
		}


		
		

	}

