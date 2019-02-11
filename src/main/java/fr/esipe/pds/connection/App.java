package fr.esipe.pds.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        System.out.println( "Start connection pool !" );
        
        DataSource ds = new DataSource();
        Connection con = ds.getConnection();
        
        
        ResultSet resultats = null;
        String requete = "SELECT * FROM categories";
        try {
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        } catch (SQLException e) {
        //traitement de l'exception
        }
    	try {
	
	        while(resultats.next()){
					System.out.println(resultats.getString(3));
	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ds.free(con);
        
    }
}
