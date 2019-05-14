package fr.esipe.pds.ehpaddecision.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SdzConnection {
	 
	//import javax.swing.JOptionPane;
	
	
		public String myDriver = "com.mysql.cj.jdbc.Driver";			
		public static String url = "jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
		public static String user = "root";
		public static String passwd = "";
		public static Connection connect;
	 
		
		
		
	 
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	 
	        connect = DriverManager.getConnection(url, user, passwd);
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	 
	      }
	    }		
	    return connect;	
	  }





	public static PreparedStatement test(String macAdress) {
		PreparedStatement test = sdzConnection.preparedStatement("INSERT INTO sensor VALUES (?,?,?)");
		return null;
	}
	}

