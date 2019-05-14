package fr.esipe.pds.ehpaddecision.start;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import fr.esipe.pds.ehpaddecision.serversocket.Server;
import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;

/**
 * This main class will launch the server
 */
// TODO remove sysout

public class Launcher {

	public static void main(String [] args){
		
		Server server = new Server();
		server.launch();

		// create a mysql database connection
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
		String user = "root";
		String passwd = "";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver O.K.");

			// create a mysql database connection
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl,user,passwd);//DriverManager.getConnection(myUrl, "root", "");
			System.out.println ("Connexion effective");
			 

			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// st.executeUpdate("INSERT INTO alert VALUES (4,'Fred',1555238588982)");
			
			
			String query = "SELECT * from alert";
			

			PreparedStatement prepare = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet result = st.executeQuery(query);

			ResultSetMetaData resultMeta = result.getMetaData();
			
			

				
				


			result.close();
			st.close();
			conn.close();


		} catch (Exception e)
		{
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
