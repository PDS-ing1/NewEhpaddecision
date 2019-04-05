package fr.esipe.pds.ehpaddecision.connectionpool;


import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DataSource {
	
	//Connection connection = source.getConnection("user", "password");
	private static final Logger log = LoggerFactory.getLogger(DataSource.class);
	private static JDBCConnectionPool connectionPool = new JDBCConnectionPool();
	//public static JDBCConnectionPool pool;
	//private static boolean ConnectionPoolFilled = false;
	//public static void startPoolConnection() { 
		//ConnectionPoolFilled = true;}
		
	public DataSource () {}
	
	public static synchronized Connection getConnection() {
		//connectionPool.putConnection();
		//return connectionPool.getConnection();
		try {
			return connectionPool.getConnection();
		} catch (Exception e){
			log.error("Sorry, something is wrong, check you connectivity : " + e.getMessage());
			return null;
		}
		
	}
	
	public static synchronized void free(Connection connection){
		connectionPool.free(connection);
	}
	
	public static void closeConnections() {
		connectionPool.closeAll();
	}
	
	//public DataSource (){

	//	pool = new  JDBCConnectionPool();	
    //   System.out.println( "DataSource created !" );
        //logger.info("DataSource well created");

	//}
	
	public static int totalConnections(){
		return (connectionPool.totalConnections());
	}
	public static boolean connectionPoolFilled(){
	return connectionPoolFilled();
	}
	
	public static void startConnections() {
		try {
			connectionPool.loadConnectionsList();
		}catch (SQLException e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public static int connectionsAvailable() {
		return connectionPool.totalConnections();
	}
	
}
