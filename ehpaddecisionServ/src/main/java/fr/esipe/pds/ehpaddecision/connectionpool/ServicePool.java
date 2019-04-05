package fr.esipe.pds.ehpaddecision.connectionpool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ServicePool {
	   public static void main( String[] args ) throws IOException
	    {
	        System.out.println( "Start connection pool !" );
	        
	        DataSource ds = new DataSource();
	        Connection con = ds.getConnection();
	        
	       /* Logger log = Logger.getLogger(DataSource.class.getName());
	        DataSource al = new DataSource();
			al.log = Logger.getLogger(
					DataSource.class.getName());
			al.log.log(Level.INFO, "connexion numéro "+ con);*/
	        System.out.println("Nombre de connections ==> " + DataSource.totalConnections());
	          
	        ResultSet resultats = null;
	        String requete = "SELECT * FROM categories";
	      //  logger.info("Query properly executed");
	        try {
	        Statement stmt = con.createStatement();
	        resultats = stmt.executeQuery(requete);
	        } catch (SQLException e) {
	        //traitement de l'exception
	        //	logger.error("Error,!");
	        }
	    	try {
		
		        while(resultats.next()){
						System.out.println(resultats.getString(3));
		
		        }
			} catch (SQLException e) {
				//logger.error("Sorry, something wrong!");
				e.printStackTrace();
			}
	    	
	    	ds.free(con);
	        
	    }
}
