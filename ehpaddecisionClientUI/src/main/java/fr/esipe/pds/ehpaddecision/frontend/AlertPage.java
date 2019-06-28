package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;





public class AlertPage
{
	private static DefaultListSelectionModel selectionModel;
	static JFrame mainFrame;
	public static void main(String[] args)
	{

		Connection connection = getConnection();
		try
		{	

			Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY );
			ResultSet rs = st.executeQuery( "SELECT * FROM alert" );
			ResultSetTableModel rtm = new ResultSetTableModel( rs );
			TablePanel tablePanel = new TablePanel( rtm );
			tablePanel.setBounds(200, 5, 452, 426);



			for (int i = 0;i<rtm.getRowCount();i++) {
				for(int j = 0;j<rtm.getRowCount();j++) {
					rtm.setValueAt("", i, j);
				}
			}
			tablePanel.update(rtm);

			mainFrame = new JFrame( "LISTE DES ALERTES" );
			mainFrame.getContentPane().setLayout(null);
			mainFrame.getContentPane().add( tablePanel);

			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			mainFrame.setSize( 1240, 480 );
			mainFrame.setVisible( true );


			JButton humiditysensor = new JButton(" humidity sensor");
			humiditysensor.setBounds(674, 207, 107, 21);
			JButton smokesensor = new JButton("smoke sensor");
			smokesensor.setBounds(791, 207, 95, 21);
			JButton boutonRefresh = new JButton("Refresh");
			boutonRefresh.setBounds(896, 207, 67, 21);

			mainFrame.getContentPane().add(humiditysensor); 
			mainFrame.getContentPane().add(smokesensor);       
			mainFrame.getContentPane().add(boutonRefresh);
			
			JButton back = new JButton("BACK");
			back.setBounds(801, 255, 85, 21);
			mainFrame.getContentPane().add(back);
			back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					SensorPlan sensorPlan = new SensorPlan(2);
					mainFrame.dispose();
				}
				
			});

			humiditysensor.addActionListener(new ActionListener(){
				public synchronized void actionPerformed(ActionEvent event){
					new JOptionPane();
					new SimulHumidity(80);

					SimulHumidity.main(null);
					tablePanel.repaint();
				}
			});   

			smokesensor.addActionListener(new ActionListener(){
				public synchronized void actionPerformed(ActionEvent event){
					new JOptionPane();
					new SimulSmoke(80);
					SimulSmoke.main(null);
					tablePanel.repaint();
				}
			});  

			boutonRefresh.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					main(null);
				}
			});
		} 
		catch ( SQLException e )
		{

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
				System.out.println( "ERREUR de connexion  la base de donnees: " + 
						URL_DATABASE );
				e.printStackTrace();
			}
		}

		return connection;
	}
	private static final String PILOTE ="com.mysql.cj.jdbc.Driver";
	private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";

	public JFrame getFrame() {
		
		return mainFrame;
	}

}


class TablePanel extends JPanel
{
	private JTable table;

	public TablePanel( TableModel model )
	{
		table = new JTable( model );
		JTextArea alertes = new JTextArea();
		alertes.setToolTipText("Descriptif des alertes");
		alertes.setBounds(256, 152, 130, 75);
		add(alertes);


		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if(table.getSelectedRow() != -1 && table.getSelectedColumn() != -1) {
					String selData = table.getValueAt(table.getSelectedRow(),1).toString();

					System.out.println(selData);
					String sql ="select * from test where id = " +selData ;
					// String sql =" select * from test where id = '"+selData+"'";


					try {
						Connection connection = AlertPage.getConnection();
						Statement st = connection.createStatement();
						ResultSet rs = st.executeQuery(sql);

						while(rs.next()) {

							String id = rs.getString("id_alert");
							String name = rs.getString("name");
							String temperature = rs.getString("temperature");
							String heure = rs.getString("creation_date");
							String id_sensor = rs.getString("id_sensor");
							String type_alert = rs.getString("type_alert");


							System.out.println(id+temperature+heure);
							alertes.setText("identifiant: " +id+"\n"+"temperature:"+temperature+"\n"+"id_sensor:"+id_sensor+"\n"+"heure:"+heure);


						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}
			}


		});

		setLayout( new BorderLayout() );
		add( new JScrollPane( table ), BorderLayout.CENTER );
	}



	public void update(TableModel model){

		table.setModel(model);
		//tableModel.getDataVector().elementAt(jTable.getSelectedRow());

	}




}