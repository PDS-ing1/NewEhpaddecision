package fr.esipe.pds.ehpaddecision.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;

// this class is only for test, it should be removed at the end of tests. 
// TODO remove class test 
public class test {

	  public static void main(String[] args)
	  {
	    try
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	System.out.println("Driver O.K.");
	    	
	      // create a mysql database connection
	      String myDriver = "com.mysql.cj.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
	      String user = "root";
	      String passwd = "";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl,user,passwd);//DriverManager.getConnection(myUrl, "root", "");
	      System.out.println ("Connexion effective");
	      
	      Statement st = conn.createStatement();
	      st.executeUpdate("INSERT INTO alert VALUES (7,'TOMA',155523858894)");

	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      e.printStackTrace();
	    }

	  }
	 }
