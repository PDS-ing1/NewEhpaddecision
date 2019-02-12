package fr.esipe.pds.connection;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class interfacePool extends JFrame implements ActionListener 
{
	
	    private JButton bouton1;
	    private JButton bouton2;
	    private JButton bouton3;
	    private JButton bouton4;
	    private JButton bouton5;
	    private JLabel label1;
	    private JLabel label2;
	    private JLabel label3;
	    private JLabel label4;
	    private JLabel label5;
	    
	    public interfacePool () 
	    {
	        setTitle("Interface Pool"); setSize(2000, 720);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new FlowLayout());
	        getContentPane().setBackground(new Color(200,200,200));
	        bouton1 = new JButton("SELECT");
	        bouton1.addActionListener(this);
	       
	       
	       
	        bouton2 = new JButton("UPDATE");
	        bouton2.addActionListener(this);
	        
	        
	        bouton3 = new JButton("DELETE");
	        bouton3.addActionListener(this);
	        
	        bouton4 = new JButton("SELECT");
	        bouton4.addActionListener(this);
	        
	        bouton5 = new JButton("ADD");
	        bouton5.addActionListener(this);
	        
	        getContentPane().setLayout(new GridLayout(5,1));
	        
	        getContentPane().add(bouton1);
	        label1 = new JLabel("Sélectionner l'état de l'objet connecté numéro 12");
	        label1.setForeground(Color.BLACK);
	        getContentPane().add(label1);
	        getContentPane().add(bouton2);
	        label2 = new JLabel("Modifier l'état de l'objet 12");
	        label2.setForeground(Color.BLACK);
	        getContentPane().add(label2);
	        getContentPane().add(bouton3);
	        label3 = new JLabel("Supprimer l'objet numéro 10");
	        label3.setForeground(Color.BLACK);
	        getContentPane().add(label3);
	        getContentPane().add(bouton4);
	        label4 = new JLabel("Sélectionner l'objet connecté numéro 10");
	        label4.setForeground(Color.BLACK);
	        getContentPane().add(label4);
	        getContentPane().add(bouton5);
	        label5 = new JLabel("Ajouter l'utilisateur numéro 15");
	        label5.setForeground(Color.BLACK);
	        getContentPane().add(label5);
	        
	    
	        
	       
	       
	        
	    }
	    public void actionPerformed(ActionEvent event) 
	    {
	        // TODO 
	   
	    }
	    
	  

	    	public static void main (String[] args) {
	    		
	    		interfacePool instance = new interfacePool();
	    		instance.setVisible(true);
	        }
	    }
