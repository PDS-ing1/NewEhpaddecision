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

import fr.esipe.pds.ehpaddecision.frontend.AlertPage;
import fr.esipe.pds.ehpaddecision.frontend.ResultSetTableModel;

public class SimulHumidity {

	static int donnee = 90; 
	static int j = 0;
	static java.util.Date myDate = new java.util.Date();

	static int[] id = {1,2,3,4,5,6};
	static int[] temperature = {-5,-2,-1, 0,1,2,3,4,5,6,10, 11, 15, 16,17,18, 19, 20, 25, 26,30,31,32,33,34, 35,39, 40, 45,50};

	static	Random rand = new Random();
	public SimulHumidity(int donnee) {
		super();
		this.donnee = donnee;

	}

	public  static void main(String[] args) {

		SimulHumidity simul = new SimulHumidity(90);
		Integer resultat;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> result = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception { 
				try {
					Thread.sleep(donnee * 400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return Integer.valueOf(100);
			}
		});	
		executor.shutdown();

		long debut = System.currentTimeMillis();
		int compteur = 0;
		Connection connect = getConnection();
		while ( compteur != donnee) {

			compteur++;
			try {
				Thread.sleep(donnee * 100);
				try {
					Statement st = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);


					st.executeUpdate("INSERT INTO humidity_sensor"
							+ "(humidity_sensor_id,temperatureMin,temperatureMax,sensor_humiditysensor_id)"

+ "VALUES('"+id[rand.nextInt(5)]+"','"+temperature[rand.nextInt(30)]+"','"+ 45+"','"+id[rand.nextInt(5)]+"')");

					ArrayList<Integer> list = new ArrayList<Integer>();

					ResultSet result1 = st.executeQuery("SELECT temperatureMin FROM humidity_sensor");

					ResultSetMetaData resultMeta = result1.getMetaData();

					while(result1.next()){         

						for (int i = 1; i <= resultMeta.getColumnCount(); i++){ 
							list.add(result1.getInt(i));


							for(int elem : list) {

								System.out.println(elem);

								if (elem < 5 || elem > 39)
								{
									System.out.println("alerte température");
									String sql ="SELECT humidity_sensor_id FROM humidity_sensor where temperatureMin = " + elem ;
									ResultSet result2 = st.executeQuery(sql);

									try {
										Connection connection = AlertPage.getConnection();
										Statement st1 = connection.createStatement();
										ResultSet rs = st1.executeQuery(sql);	
										while(rs.next()) {
											String id = rs.getString("id");
											System.out.println(id); 

										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									ResultSetMetaData resultMeta2 = result2.getMetaData();

									while(result2.next()){         
										for(int j = 1; j <= resultMeta2.getColumnCount(); j++)


											System.out.print("\t" +result2.getInt(j)+"\t |");

										System.out.println("\n---------------------------------");


									}
									st.executeUpdate("INSERT INTO alert"
											+ "(id_Alert,name,creation_Date,id_sensor,type_alert)"

+ "VALUES('"+id[rand.nextInt(5)]+"','"+"alerte température"+"','"+myDate.toString()+"','"+id[rand.nextInt(5)]+"','"+ "alerte température" +"')");
									ResultSet rs;
									ResultSetTableModel rtm;
									rs = st.executeQuery( "SELECT * FROM alert" );
									rtm = new ResultSetTableModel(rs);
									TablePanel tablePanel = new TablePanel( rtm );
									updateTable(tablePanel);
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
			System.out.println("donnée N°"+compteur);
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
	public synchronized static void updateTable(TablePanel tablePanel) throws InterruptedException, SQLException {


		Connection connection = getConnection();

		Statement st;
		ResultSetTableModel rtm;
		try {
			st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY );

			ResultSet rs;

			rs = st.executeQuery( "SELECT * FROM alert" );
			rtm = new ResultSetTableModel(rs);
			Thread.sleep(100);
			for (int i = 0;i<rtm.getRowCount();i++) {
				for(int j = 0;j<rtm.getRowCount();j++) {
					rtm.setValueAt("", i, j);
				}
			}
			tablePanel.update(rtm);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
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




		return connection;
	}
	private static final String PILOTE ="com.mysql.cj.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
	private static final String user = "root";
	private static final String passwd = "";

}

