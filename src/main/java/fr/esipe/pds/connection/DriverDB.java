package fr.esipe.pds.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {

	DriverClass d=new DriverClass();
	
	  public String insertAndUpdate(String firstName,String          lastName,int erNumber,int age,String gender) throws ClassNotFoundException, SQLException
	    {
	        
	        String re="";
	        Class.forName(d.Driver);
	    Connection con=DriverManager.getConnection(d.Path,d.UserName,d.password);
		return re;    
	    
	}

	public String Delete(int d) {
		// TODO Auto-generated method stub
		return null;
	}

}
