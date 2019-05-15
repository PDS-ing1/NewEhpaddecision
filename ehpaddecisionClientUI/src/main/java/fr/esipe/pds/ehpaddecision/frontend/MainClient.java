package fr.esipe.pds.ehpaddecision.frontend;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class MainClient {
	static JFrame mainFrame = new JFrame( "LISTE DES ALERTES" );

	
	
	
	public MainClient() {

		// -------------------------------- start IHM

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		mainFrame.setSize( 1240, 480 );
		mainFrame.setVisible( true );
		mainFrame.setLayout(new FlowLayout());

		JButton humiditysensor = new JButton(" humidity sensor");
		JButton smokesensor = new JButton("smoke sensor");
		JButton boutonRefresh = new JButton("Refresh");
		//JButton boutonModify = new JButton("Modify");

		JTable dataTable = new JTable();
		dataTable.setModel(new javax.swing.table.DefaultTableModel(

				new Object [][] {
					{"1", "alerte fumée", "900"},
					{"2", "alerte température", "00"},
					{"3", "alerte température", "-100"},
					{"4", "alerte fumée", "340"},
					{"5", "alerte fumée", "600"},
					{"6", "alerte température", "50"},
					{"7", "alerte fumée", "500"},
					{"5", "alerte fumée", "500"}
				},new String [] {
						"Id", "Type","données"
				}

				));

		JScrollPane scrolDataTable = new javax.swing.JScrollPane();
		scrolDataTable.setViewportView(dataTable);


		mainFrame.add(humiditysensor); 
		mainFrame.add(smokesensor);       
		mainFrame.add(boutonRefresh);
		mainFrame.add( dataTable , BorderLayout.NORTH);


		mainFrame.repaint();

		humiditysensor.addActionListener(new ActionListener(){
			public synchronized void actionPerformed(ActionEvent event){
				new JOptionPane();
				//new SimulHumidity(80);

				//SimulHumidity.main(null);
				//tablePanel.repaint();
			}
		});   

		smokesensor.addActionListener(new ActionListener(){
			public synchronized void actionPerformed(ActionEvent event){
				new JOptionPane();
				//new SimulSmoke(80);
				//SimulSmoke.main(null);
				//tablePanel.repaint();
			}
		});  

		boutonRefresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//main(null);
			}
		});
	}
	public JFrame getFrame(){
		return mainFrame;
	}}
