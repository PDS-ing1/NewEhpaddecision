package fr.esipe.pds.ehpaddecision.connectionpool;
import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceJDBCConnectionPool { 
	public void loadConnectionPool() throws SQLException;
	
	public Connection getConnection() throws Exception;
	
	public void putConnection(Connection connection);
	
	public void closeAllConnections();

}
