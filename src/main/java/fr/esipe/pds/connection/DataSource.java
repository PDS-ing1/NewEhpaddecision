package fr.esipe.pds.connection;

import java.sql.Connection;

public class DataSource {
	
	//Connection connection = source.getConnection("user", "password");
	
	public static JDBCConnectionPool pool;
		
	
	
	public Connection getConnection(){
		return pool.getConnection();
	}
	public void free(Connection connection){
		
	}
	public void closeConnections(){
		
	}
	
	public DataSource (){

		pool = new  JDBCConnectionPool();	
        System.out.println( "DataSource created !" );

	}
	
	
	
	
	
	
	
	
	
}
