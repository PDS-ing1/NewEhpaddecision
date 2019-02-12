package fr.esipe.pds.connection;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class interfacePool extends JFrame implements ActionListener 
{
	
	    private JButton bouton1;
	    private JButton bouton2;
	    private JButton bouton3;
	
	    private JButton bouton5;
	    private JLabel label1;
	    private JLabel label2;
	    private JLabel label3;
	    
	    private JLabel label5;
	    private JTextField entre1, sortie1;
	    private JTextField entre2, sortie2;
	    private JTextField entre3, sortie3;
	    private JTextField entre4, sortie4;
	    private JTextField entre5, sortie5;
	    
	    public interfacePool (JDBCConnectionPool jcp) 
	    {
	    	
	        setTitle("Interface Pool"); setSize(700, 700);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new FlowLayout());
	        getContentPane().setBackground(new Color(200,200,200));
	        bouton1 = new JButton("SELECTIONNER UN OBJET");
	        bouton1.addActionListener(this);
	       
	      
	       
	        bouton2 = new JButton("MODIFIER L'ETAT D'UN OBJET");
	        bouton2.addActionListener(this);
	        
	        
	        bouton3 = new JButton("SUPPRIMER UN OBJET");
	        bouton3.addActionListener(this);
	        
	       
	        
	        bouton5 = new JButton("AJOUTER UN OBJET");
	        bouton5.addActionListener(this);
	        
	        getContentPane().setLayout(new GridLayout(14,1));
	        
	       
	        
	        entre1 = new JTextField("ENTREZ LE NUMERO D'UN OBJET", 20);
	        entre1.addActionListener(this);
	        getContentPane().add(entre1);
	        sortie1 = new JTextField(20);
	        sortie1.setEditable(false);
	        sortie1.setForeground(Color.RED);
	        getContentPane().add(sortie1);
	        getContentPane().add(bouton1);
	        
	        
	        entre2 = new JTextField("ENTREZ LE NOUVEL ETAT DE VOTRE OBJET (ON/OFF)", 20);
	        entre2.addActionListener(this);
	        getContentPane().add(entre2);
	        
	       
	        entre3 = new JTextField("ENTREZ LE NUMERO DE VOTRE OBJET", 20);
	        entre3.addActionListener(this);
	        getContentPane().add(entre3);
	        
	        
	        getContentPane().add(bouton2);
	        
	        entre4 = new JTextField("ENTREZ LE NUMERO DE VOTRE OBJET", 20);
	        entre4.addActionListener(this);
	        getContentPane().add(entre4);
	        
	        
	        getContentPane().add(bouton3);
	        
	        entre5 = new JTextField("ENTREZ L'ETAT DE VOTRE NOUVEL OBJET", 20);
	        entre5.addActionListener(this);
	        getContentPane().add(entre5);
	        
	        getContentPane().add(bouton5);
	     
	    }
	     
	   
	   
	    public void actionPerformed(ActionEvent event) 
	    {
	       if (event.getSource()== bouton1)
	       {
	    	   String id =entre1.getText();
	    	   int identifient = Integer.parseInt(id);
	    	
	    	   boolean result ;
			   Connection connection = jcp.getConnection();
			   Statement ordre = connection.createStatement();
			   String sql = "Select Etat from Objwhere Id_Objets ="+ identifient;
			   ResultSet rs = ordre.executeQuery(sql);
			   while (rs.next())
			   {
				   result = rs.getBoolean("Etat");
			   }
			   if (result == true){
				   sortie1.setText("ON");
			   }
			   else 
			   {
				   sortie1.setText("OFF");
			   }
	       }
	       if (event.getSource()== bouton2)
	       {
	    	   String id =entre2.getText();
	    	   int identifient = Integer.parseInt(id);
	    	   String etat =entre3.getText();
	    	   Boolean idEtat = Boolean.parseBoolean(etat);
	    	
			   Connection connection = jcp.getConnection();
			   Statement ordre = connection.createStatement();
			   String sql = "UPDATE Etat from Objets_Connectes set " + idEtat + "where Id_Objets ="+ identifient;
			   ordre.executeQuery(sql);
			   
	       }
	       if (event.getSource()== bouton3)
	       {
	    	   String id =entre4.getText();
	    	   int identifient = Integer.parseInt(id);
	    	
			   Connection connection = jcp.getConnection();
			   Statement ordre = connection.createStatement();
			   String sql = "DELETE FROM Objets_Connectes WHERE Id_Objets="+ identifient;
			   ordre.executeQuery(sql);
			  
			   
	       }
	       if (event.getSource()== bouton5)
	       {
	    	   String etat =entre5.getText();
	    	   Boolean identifientEtat = Boolean.parseBoolean(etat);
	    	
			   Connection connection = jcp.getConnection();
			   Statement ordre = connection.createStatement();
			   String sql = "INSERT INTO Objets_Connectes(Etat) VALUES"+ identifientEtat;
			   ordre.executeQuery(sql);
	       }
	    	
	    }
	    public static void main (String[] args) {
			
	    	JDBCConnectionPool jcp = new JDBCConnectionPool();
			interfacePool instance = new interfacePool(jcp);
			instance.setVisible(true);
	    }
}



