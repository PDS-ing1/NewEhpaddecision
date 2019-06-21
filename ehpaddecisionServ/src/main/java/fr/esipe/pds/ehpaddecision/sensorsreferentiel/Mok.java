package synthese;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Mok {	
	static int donnee = 100; 
	static String[] idhumidity = {"1","2","3","4","5"};
	static String[] temperature = {"19", "17", "14", "25"};
	static	String[] sensorid= {"1","2","3","4","5"};
	
	static	Random rand = new Random();
	
	public  static void main(String[] args) {
	
		Integer resultat;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> result = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				try {
					Thread.sleep(donnee * 4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return Integer.valueOf(100);
			}
		});	
		executor.shutdown();
		
		long debut = System.currentTimeMillis();
		int compteur = 0;
		
		while (!result.isDone() && compteur != donnee) {
			
			compteur++;
			try {
				Thread.sleep(donnee * 1000);
				try {
				      getConnection().createStatement(
				        ResultSet.TYPE_SCROLL_INSENSITIVE,
				        ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO humidity_sensor"
				        		+ "(humidity_sensor_id,temperature)"
				        		+ "VALUES('"+idhumidity[rand.nextInt(3)]+"',"
				        				+ "'"+temperature[rand.nextInt(2)]
				        			
				        						
				        						);
				    } catch (SQLException e) {
					      e.printStackTrace();
					    }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(compteur);
		}
		try {
			resultat = result.get();
			System.out.println("((( - - - Fin de la transition - - - - ))) ");
			
			
			System.out.println("table bien remplie. ");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();

		}

	}
	
	
	 public static Connection getConnection()
	  {
	    Connection connection = null;
	    boolean ok = false;
	    try{ Class.forName( PILOTE ); ok = true; } 
	   catch ( ClassNotFoundException e )
	   {
	     System.out.println( "ERREUR chargement du pilote: pilote non trouv" );
	     e.printStackTrace();
	   }
	  
	   //--- connexion  la base de donnes
	   if ( ok )
	   {
	     try
	     {
	       connection = DriverManager.getConnection(  
	      		 "jdbc:mysql://localhost:3306/pds2","root","");  
	     } 
	     catch ( SQLException e )
	     {
	       System.out.println( "ERREUR de connexion  la base de donnes: " + 
	                                     URL_DATABASE );
	       e.printStackTrace();
	     }
	   }
	  
	    return connection;
	  }

	private static final String PILOTE ="com.mysql.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/pds2";
	private static final String user = "root";
	private static final String passwd = "";
	
}
