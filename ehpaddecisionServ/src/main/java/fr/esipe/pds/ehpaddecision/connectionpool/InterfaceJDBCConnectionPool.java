package fr.esipe.pds.ehpaddecision.connectionpool;
import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceJDBCConnectionPool {

		 
		 
		public void loadConnectionsList() throws SQLException;
		
		
		
		 //get a connection
		 //launch  exception when there is no connection more 
		
		public Connection getConnection() throws Exception;
		
		 
		public void free(Connection connection);
		
		
		
		//Closes all connections
		
		public void closeAll();

	}