package fr.esipe.pds.ehpaddecision.mocksimu;


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


public class SimulHumidity {
			
	static int donnee = 90; 
	
	static int[] id = {1,2,3,4,5,6};
	static int[] temperature = {-5,-2,-1, 0,1,2,3,4,5,6,10, 11, 15, 16,17,18, 19, 20, 25, 26,30,31,32,33,34, 35,39, 40, 45,50};

	static	Random rand = new Random();
	public SimulHumidity(int donnee) {
		super();
		this.donnee = donnee;
		
	}
	
	//faire un arraylist et un thread qui raffraichit l'ArrayList en temps réel.
	
	public  static void main(String[] args) {
		
	SimulHumidity simul = new SimulHumidity(90);
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
		
		while ( compteur != donnee) {
			
			compteur++;
			try {
				Thread.sleep(donnee * 1000);
				try {
				      getConnection().createStatement(
				        ResultSet.TYPE_SCROLL_INSENSITIVE,
				        ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO test"
				        		+ "(id,temperature)"
				        		+ "VALUES('"+id[rand.nextInt(5)]+"',"
				        				
				        				+ "'"+temperature[rand.nextInt(30)]+"'"
		        						+ ")"
				        			
				        						
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
			
			
			
			System.out.println("table bien remplie. ");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();

		}

	}
	
	// TODO to be replaced by the coonection already done

	 public static Connection getConnection()
	  {
	    Connection connection = null;
	    boolean ok = false;
	    try{ Class.forName( PILOTE ); ok = true; } 
	   catch ( ClassNotFoundException e )
	   {
	     System.out.println( "ERREUR chargement du pilote: pilote non trouve" );
	     e.printStackTrace();
	   }
	  
	   //--- connexion  la base de donnes
	   if ( ok )
	   {
	     try
	     {
	       connection = DriverManager.getConnection(  
	      		 "jdbc:mysql://localhost:3306/pds1","root","");  
	     } 
	     catch ( SQLException e )
	     {
	       System.out.println( "ERREUR de connexion a la base de donnes: " + 
	                                     URL_DATABASE );
	       e.printStackTrace();
	     }
	   }
	  
	    return connection;
	  }

	private static final String PILOTE ="com.mysql.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/pds1";
	private static final String user = "root";
	private static final String passwd = "";
	
}




