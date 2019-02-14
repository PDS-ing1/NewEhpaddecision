package fr.esipe.pds.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DriverClass {
	
	public static final String Driver = null;
	public static final String Path = null;
	public static final String UserName = null;
	public static final String password = null;
	private Properties properties = new Properties();
	private List<Connection> connexions = new ArrayList<Connection>(); 
	
	
	public DriverClass(){
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
		
	}
}
