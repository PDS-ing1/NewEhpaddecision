package fr.esipe.pds.ehpaddecision.connectionpool;


import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DataSource {
	
	private static final Logger log = LoggerFactory.getLogger(DataSource.class);
	private static JDBCConnectionPool connectionPool = new JDBCConnectionPool();

	public DataSource() {}
	

	public static synchronized Connection getConnection()
	{
		try {
			return connectionPool.getConnection();
		} catch (Exception e) {
			log.error("The connections are not availabe :\n" + e.getMessage());
			return null;
		}
	}
	
	
	public static synchronized void putConnection(Connection connection)
	{
		connectionPool.putConnection(connection);
	}
	

	public static void closeConnectionPool()
	{
		connectionPool.closeAllConnections();
	}
	
	public static void startConnectionPool() {
		try {
			connectionPool.fillConnectionsList();
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}	
	
	public static int getRemaningConnections(){
		return connectionPool.connectionStillAlives();
	}
	

}
