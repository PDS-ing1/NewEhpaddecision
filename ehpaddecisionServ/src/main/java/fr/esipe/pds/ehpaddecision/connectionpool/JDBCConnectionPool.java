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
		
	 
	    private static final Logger log = LoggerFactory.getLogger(JDBCConnectionPool.class);
	    private final String url             =  Tools.propertiesFileHandler("url");
	    private final String user            =  Tools.propertiesFileHandler("username");
	    private final String pswd            =  Tools.propertiesFileHandler("password");
	    private int connectionsAvailableNb;
	    private int connectionsRecentlyCreated;
	    private Vector<Connection> connections;
		
		public JDBCConnectionPool() {
			connections = new Vector<Connection>();
			connectionsRecentlyCreated = 0;
			log.info("This Database is linked to this url : " + url);
			try
			{
				connectionsAvailableNb = Integer.parseInt(Tools.propertiesFileHandler("nb_connection"));
			}
			catch(Exception e)
			{
				log.error("File unloaded from properties !");
				connectionsAvailableNb = 10;
			}

			log.info(connectionsAvailableNb + " connection(s) should be put inside the connection pool.");
		} 
		

		public void loadConnectionPool() throws SQLException {		
					
	        for (int i = 0; i < connectionsAvailableNb; i++ )
	        {
	        	Connection createdConnection = this.newConnection(); 
	        	if(createdConnection != null) {
	                connections.addElement(createdConnection);
	                log.info("A connection has been created and is being added to the pool. (" + ( (i+1) + "/" + connectionsAvailableNb) + ")" );
	        	}
	        	else {
	        		log.error("Some erros faced the creation of the connection so your connections are equals to null !");
	        
	        		throw new SQLException("A connection is equal to null !");
	        	}
	        }
	        poolReady();
		}

		public Connection getConnection() throws Exception {
			if(!connections.isEmpty())
			{
				Connection connection = connections.lastElement();
		        connections.removeElement(connection);
				log.info("We just took a connection from the pool");
				poolReady();
		        return connection; 
			}
			else
			{
				throw new Exception("No more connection available in the pool ! Please try later.");
			}     
		}

		public void putConnection(Connection connection) {
			if(connection != null)
			{
				connections.addElement(connection);	
				log.info("A connection is being added to the connection pool.");			
			}
			poolReady();
			
		}

		public void closeAllConnections() {
			for(Connection con : connections)
			{
				try {
					if(!con.isClosed())
					{
						con.close();	
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


		private Connection newConnection(){
	        Connection connection = null;
	        try {
	        	System.out.println("JE SUSI LA 1");
	        	connection = DriverManager.getConnection(url, user, pswd);
	            connectionsRecentlyCreated++;
	            System.out.println("JE SUSI LA ");
	        } catch (SQLException e) {
	            log.error("Sorry, an exception from SQL has been added " + e.getMessage());
	        }
	        return connection;
	    }  

		public int connectionStillAlives(){
			return connections.size();
		}
		
		private void poolReady()
		{
			String welcome   = "  -------------------------------------------  ";
			String creation  = "- Connection created   : " + connectionsRecentlyCreated;
			String connectionActual = "- Actual connection: " + connectionStillAlives();
			String end 		 = "------------------------------------";
			log.info("The pool is ready :\n" + welcome  + creation + "\n" + connectionActual + "\n" + end + "\n");
		}

	}

