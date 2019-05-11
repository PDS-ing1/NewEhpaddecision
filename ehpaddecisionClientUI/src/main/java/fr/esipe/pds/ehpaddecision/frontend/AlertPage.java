package synthese;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	public static void main(String[] args)
  {
	  
    Connection connection = getConnection();
    try
    {
        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
                								   ResultSet.CONCUR_READ_ONLY );
        ResultSet rs = st.executeQuery( "SELECT * FROM alerts" );
        ResultSetTableModel rtm = new ResultSetTableModel( rs );
        TablePanel tablePanel = new TablePanel( rtm );
 
        
        JFrame mainFrame = new JFrame( "LISTE DES ALERTES" );
        mainFrame.add( tablePanel , BorderLayout.NORTH);
       
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        mainFrame.setSize( 1240, 480 );
        mainFrame.setVisible( true );
        mainFrame.setLayout(new FlowLayout());
        
        JButton humiditysensor = new JButton(" humidity sensor");
        JButton smokesensor = new JButton("smoke sensor");
        JButton boutonRefresh = new JButton("Refresh");
        
        mainFrame.add(humiditysensor); 
        mainFrame.add(smokesensor);       
        mainFrame.add(boutonRefresh);
        
        JLabel descriptif = new JLabel("Descriptif des alertes");
        descriptif.setFont(new Font("Times New Roman", Font.BOLD, 12));
        descriptif.setBounds(54, 32, 119, 14);
	
		 mainFrame.add( descriptif , BorderLayout.SOUTH);
        
		JTextArea alertes = new JTextArea();
		alertes.setToolTipText("Descriptif des alertes");
		alertes.setBounds(256, 152, 130, 75);
		mainFrame.add(alertes, BorderLayout.SOUTH);
		
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
      		 "jdbc:mysql://localhost:3306/pds1","root","");  
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
private static final String PILOTE ="com.mysql.jdbc.Driver";
private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/pds1";
}

class TablePanel extends JPanel
{
  public TablePanel( TableModel model )
  {
    table = new JTable( model );
    
    setLayout( new BorderLayout() );
    add( new JScrollPane( table ), BorderLayout.CENTER );
  }
  private JTable table;
  
  public void update(TableModel model){

				table.setModel(model);

	    
  }
  
}
