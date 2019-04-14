package fr.esipe.pds.ehpaddecision.frontend;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class Home {
	private static final JMenuItem Bon_de_reservation = null;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu edition = new JMenu("Edition");
	private JMenu Sensors = new JMenu("Sensors");
	private JMenu users = new JMenu("Users");
	
	private JMenu contrat = new JMenu("Contrat");
	private JMenuItem bdd = new JMenuItem("Data");
	private JMenu help = new JMenu("Help");
	private JMenu user = new JMenu("Customers");
	public static String adr;
	private JMenu settings = new JMenu("Settings");
	private JMenuItem server = new JMenuItem("Send a request to the server");
	private JMenuItem help_support = new JMenuItem("Help and Support");
	private JMenuItem print = new JMenuItem("Printing");
	private JMenuItem list_sensors = new JMenuItem("All sensors");
	private JMenuItem liste_client_ = new JMenuItem("Liste des clients en attente");
	
	private JMenuItem all_users_logged = new JMenuItem("Liste des clients sous contrat");
	static 	JMenuItem liste_voiture_sorties = new JMenuItem("All breaks sensors ");
	static 	JMenuItem liste_voiture_reserve = new JMenuItem("All sensors should be revieweds");
	
	private JMenuItem all_users = new JMenuItem("All users");
	private JMenuItem new_intervention = new JMenuItem("New intervention");
	private JMenuItem change_change = new JMenuItem("Cancel a change");
	private JMenuItem contrat_listes = new JMenuItem("Liste des contrats");
	private JMenuItem facture_listes = new JMenuItem("Liste des factures");
	private JMenuItem close = new JMenuItem("Close");
	
	private JMenuItem new_alerte= new JMenuItem("Nouvelle Alerte");
	private JMenu maj_sensor = new JMenu("New update");
	private JMenuItem display_vehicule = new JMenuItem("Display");
	private JMenuItem create_sensor = new JMenuItem("Create");
	private JMenuItem update_sensor = new JMenuItem("Update");
	private JMenuItem delete_sensor = new JMenuItem("Delete");
	
	private JMenu maj_user = new JMenu("New update");
	private JMenuItem display = new JMenuItem("Display");
	private JMenuItem create = new JMenuItem("Create");
	private JMenuItem update = new JMenuItem("Update");
	private JMenuItem delete = new JMenuItem("Delete");
	
	
	final Background contient= new Background();
	final Background2 contient2= new Background2();
	private static JSplitPane split;
	private static JPanel menu = new JPanel();
	private JTabbedPane p;
	
	
	private static boolean ok =false, left=true, right=false ,top=false, bottom=false;
	private static String rowCount,rowCount2,rowCount3,rowCount4,rowCount5,rowCount6;
	private  int row1,row2,row3,row4,row6;
	private JTextField text3,text1,text2,text4,text6;
	public static int onglet = JTabbedPane.LEFT;
	
	
	public Home(boolean ok){
		this.ok=ok;
	}
	
public Home(){
		
		this.setTitle("EHPAD Decision ");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		close .addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}				
		});
		this.settings.add(bdd);
		this.settings.add(close);
		
		new_alerte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {	
			//facture();
				
			}
		});
		
		
	
		
		public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException, NotBoundException, InterruptedException{
			BDD zd = new BDD(null, "Etape 1/2 : Configuration de la base de donnée", true);
			new Client(null, "Etape 2/2 : Informations utilisateur", true);
			if(true){
		loading wind = new loading();
			wind.setVisible(true);
			Thread.sleep(4500);
			wind.setVisible(false);
			
			
		
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				
					new Home();
				}
			});
			}
		}
		
		
}
