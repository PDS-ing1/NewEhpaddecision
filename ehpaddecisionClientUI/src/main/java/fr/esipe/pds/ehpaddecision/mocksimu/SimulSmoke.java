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

public class SimulSmoke {

				
		static int donnees = 90; 
		
		static int[]id = {1,2,3,4,5,6};
		static int[]smokeppm = {0,10,20,30,40,50,60,70,80,90,100,150,200,300,400,500,600,700,800,900,1000};

		static	Random rand = new Random();
		public SimulSmoke(int donnee) {
			super();
			this.donnees = donnee;
			
		}
		
		public  static void main(String[] args) {
			
		SimulSmoke simul = new SimulSmoke(90);
			Integer resultat;
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<Integer> result = executor.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					try {
						Thread.sleep(donnees * 4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					return Integer.valueOf(100);
				}
			});	
			executor.shutdown();
			
			long debut = System.currentTimeMillis();
			int compteur = 0;
			
			while ( compteur != donnees) {
				
				compteur++;
				try {
					Thread.sleep(donnees * 1000);
					try {
					      getConnection().createStatement(
					        ResultSet.TYPE_SCROLL_INSENSITIVE,
					        ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO testsmoke"
					        		+ "(id,smokeppm)"
					        		+ "VALUES('"+id[rand.nextInt(5)]+"',"
					        				
					        				+ "'"+smokeppm[rand.nextInt(21)]+"'"
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


