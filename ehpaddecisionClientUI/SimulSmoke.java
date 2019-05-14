package synthese;


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

public class SimulSmoke {


	static int donnees = 90; 
	static java.util.Date myDate = new java.util.Date();
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
				Thread.sleep(donnees * 100);
				try {
					Statement st = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					st.executeUpdate("INSERT INTO testsmoke"
									+ "(id,smokeppm,creation_date)"
									+ "VALUES('"+id[rand.nextInt(6)]+"','"+smokeppm[rand.nextInt(21)]+"','"+ myDate.toString() +"')");
					
					ArrayList<Integer> list = new ArrayList<Integer>();

					ResultSet result1 = st.executeQuery("SELECT smokeppm FROM smoke_sensor");

					ResultSetMetaData resultMeta = result1.getMetaData();

					while(result1.next()){         

						for (int i = 1; i <= resultMeta.getColumnCount(); i++){ 
							list.add(result1.getInt(i));


							for(int elem : list) {

								System.out.println(elem);

								if (elem > 300)
								{
									System.out.println("alerte fumée");

									ResultSet result2 = st.executeQuery("SELECT id FROM smoke_sensor where  smokeppm = 'elem' ");

									ResultSetMetaData resultMeta2 = result2.getMetaData();

									while(result2.next()){         
										for(int j = 1; j <= resultMeta2.getColumnCount(); j++) {

											System.out.print("\t" +result2.getInt(j)+"\t |");

										System.out.println("\n---------------------------------");
										st.executeUpdate("INSERT INTO alerts"
												+ "(id_sensor,type,time)"

												+ "VALUES('"+result2.getInt(j)+"','"+"alerte fumée"+"','"+ myDate.toString() +"')");
										ResultSet rs;
										ResultSetTableModel rtm;
										rs = st.executeQuery( "SELECT * FROM alerts" );
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
						"jdbc:mysql://localhost:3306/pds1","root","");  
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
			ResultSet result = st.executeQuery("SELECT smokeppm FROM smoke_sensor");

			ResultSetMetaData resultMeta = result.getMetaData();

			while(result.next()){         

				for (int i = 1; i <= resultMeta.getColumnCount(); i++){ 
					al.add(result.getInt(i)); 

					for(int elem: al)
					{
						System.out.println (elem);

						if (result.getInt(i)>300)

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

	private static final String PILOTE ="com.mysql.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc: mysql://localhost:3306/pds1";
	private static final String user = "root";
	private static final String passwd = "";

}


