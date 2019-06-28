package fr.esipe.pds.ehpaddecision.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.RandomStringUtils;

import fr.esipe.pds.ehpaddecision.frontend.ResultSetTableModel;

public class SimulSmoke {

	static int donnees = 90; 
	static java.util.Date myDate = new java.util.Date();
	static int[]id = {1,2,3,4,5,6};
	static String[]stream = {"0","1"};





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
				Thread.sleep(donnees * 100);
				try {
					Statement st = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					st.executeUpdate("INSERT INTO smoke_sensor"
							+ "(smoke_sensor_id,steam_identified,sensor_smokesensor_id)"
							+ "VALUES('"+id[rand.nextInt(6)]+"','"+stream[rand.nextInt(2)]+"','"+id[rand.nextInt(6)] +"')");

					ArrayList<Integer> list = new ArrayList<Integer>();

					ResultSet result1 = st.executeQuery("SELECT steam_identified FROM smoke_sensor");

					ResultSetMetaData resultMeta = result1.getMetaData();

					while(result1.next()){     


						for (int i = 1; i <= resultMeta.getColumnCount(); i++){ 
							list.add(result1.getInt(i));


							for(int elem : list) {

								System.out.println(elem);

								if (elem == 1)
								{
									System.out.println("alerte fumée");

									ResultSet result2 = st.executeQuery("SELECT smoke_sensor_id FROM smoke_sensor where  steam_identified = 1 ");

									ResultSetMetaData resultMeta2 = result2.getMetaData();

									while(result2.next()){         
										for(int j = 1; j <= resultMeta2.getColumnCount(); j++) {

											System.out.print("\t" +result2.getString(j)+"\t |");

											System.out.println("\n---------------------------------");
											st.executeUpdate("INSERT INTO alert"
													+ "(id_Alert,name,creation_Date,id_sensor,type_alert)"

+ "VALUES('"+id[rand.nextInt(5)]+"','"+"alerte fumée"+"','"+myDate.toString()+"','"+id[rand.nextInt(5)]+"','"+ "alerte fumée" +"')");
											ResultSet rs;
											ResultSetTableModel rtm;
											rs = st.executeQuery( "SELECT * FROM alert" );
											rtm = new ResultSetTableModel(rs);
											TablePanel tablePanel = new TablePanel( rtm );
										}


									}

								}
							}

						}
					}


				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Donnée N°"+compteur);
		}
		try {
			resultat = result.get();

			System.out.println("requête effectuée. ");

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
			System.out.println( "ERREUR chargement du pilote: pilote non trouve" );
			e.printStackTrace();
		}

		//--- connexion  la base de donnes
		if ( ok )
		{
			try
			{
				connection = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC","root","");  
			} 
			catch ( SQLException e )
			{
				System.out.println( "ERREUR de connexion a la base de donnes: " + 
						URL_DATABASE );
				e.printStackTrace();
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();

		Statement st;

		try {
			st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT steam_identified FROM smoke_sensor");

			ResultSetMetaData resultMeta = result.getMetaData();

			while(result.next()){         

				for (int i = 1; i <= resultMeta.getColumnCount(); i++){ 
					al.add(result.getInt(i)); 

					for(int elem: al)
					{
						System.out.println (elem);

						if (result.getInt(i)== 1)

							System.out.println("Alerte fumée ! ");

					}
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return connection;
	}

	private static final String PILOTE ="com.mysql.cj.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
	private static final String user = "root";
	private static final String passwd = "";

}
