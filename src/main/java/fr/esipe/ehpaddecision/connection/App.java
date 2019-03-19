package fr.esipe.ehpaddecision.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	final static Logger logger = Logger.getLogger(JDBCConnectionPool.class);

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
        logger.info("Query properly executed");
        try {
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        } catch (SQLException e) {
        //traitement de l'exception
        	logger.error("Error,!");
        }
    	try {
	
	        while(resultats.next()){
					System.out.println(resultats.getString(3));
	
	        }
		} catch (SQLException e) {
			logger.error("Sorry, something wrong!");
			e.printStackTrace();
		}
    	
    	ds.free(con);
        
    }
private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
}