package fr.esipe.pds.connection;

import java.io.IOException;
import java.sql.Connection;

public class DataSource {
	
	//Connection connection = source.getConnection("user", "password");
	
	public static JDBCConnectionPool pool;
	private static boolean ConnectionPoolFilled = false;	
	
		
	public static void startPoolConnection() { 
		ConnectionPoolFilled = true;
		
	}
	
	public static synchronized Connection getConnection() throws IOException{
		pool.putConnection();
		return pool.getConnection();

	}
	public void free(Connection connection){
		pool.free(connection);
	}
	
	public void closeConnections() throws IOException{
		pool.closeAll();
	}
	
	public DataSource (){

		pool = new  JDBCConnectionPool();	
        System.out.println( "DataSource created !" );

	}
	
	public static int totalConnections(){
		return (pool.totalConnections());
	}
	public static boolean connectionPoolFilled(){
	return connectionPoolFilled();
	}
	
	
	
	
	
	
	
	
}
