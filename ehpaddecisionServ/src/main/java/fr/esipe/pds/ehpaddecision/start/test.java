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
	      // create a mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
	      Class.forName(myDriver);
	      Connection conn = DataSource.getConnection();//DriverManager.getConnection(myUrl, "root", "");
	      
	      Statement st = conn.createStatement();
	      st.executeUpdate("INSERT INTO alert VALUES (4,'Fred',1555238588982)");

	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }

	  }
	 }
