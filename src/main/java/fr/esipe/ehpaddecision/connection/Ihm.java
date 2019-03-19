package fr.esipe.ehpaddecision.connection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Ihm extends JFrame implements ActionListener {

	public static boolean flag = false;
	public static int er=0;
	//JDBCConnectionPool drivrebase = new JDBCConnectionPool();
	
	CardLayout card;
	
	JButton insert, delete, update, submitDelete, submitUpdate;
	JPanel panel_insert, panel_delete, panel_update, panel, panel_update_in;
	JLabel label_delete, label_update, label_update_er, Result;
	JTextField n_delete, update_n;

	 public Ihm() {
	        card = new CardLayout();
	        panel  = new JPanel();
	        panel.setBackground(Color.GRAY);  
	        panel_insert = new JPanel();
	        panel_delete = new JPanel();
	        panel_update = new JPanel();
	        panel_update_in =new JPanel();
	        insert = new JButton("INSERT");
	        delete = new JButton("DELETE");
	        update = new JButton("UPDATE");
	        
	        Result=new JLabel("");
	        label_delete = new JLabel("Enter an id to delete");
	        Font font = new Font("Times New Romen", Font.BOLD, 20);
	        submitDelete =new JButton("Submit delete");
	        submitUpdate =new JButton("Submit update");
	        n_delete= new JTextField(20);
	        update_n=new JTextField(20);
	        label_update = new JLabel("Enter new values...");
	        label_update.setFont(font);
	        label_update_er=new JLabel("Enter id number");
	        label_update_er.setFont(font);
	        
	        setLayout(card);
	        //FIRST PAGE
	        panel.add(insert);
	        panel.add(delete);
	        panel.add(update);
	        
	        //INSERT CODE
	        panel_insert.add(new IhmForm(card, getContentPane()));
	        
	        panel_insert.add(new Service(card, getContentPane()));
	       //DELETE CODE
	        
	        panel_delete.add(label_delete);
	        panel_delete.add(n_delete);
	        panel_delete.add(submitDelete);
	        panel_delete.add(Result);
	        panel_delete.add(new Service(card, getContentPane()));
	        
	        panel_update_in.add(label_update_er);
	        panel_update_in.add(update_n);
	        panel_update_in.add(submitUpdate);
	        panel_update_in.add(new Service(card, getContentPane()));
	       
	        // UPDATE CODE
	        
	        panel_update.setLayout(new BorderLayout());
	        panel_update.add(label_update,BorderLayout.NORTH);
	        panel_update.add(new IhmForm(card, getContentPane()));
	        add(panel, "1");
	        add(panel_insert, "2");
	        add(panel_delete, "3");
	        add(panel_update_in,"4");
	        add(panel_update, "5");
	        
	        insert.addActionListener(this);
	        delete.addActionListener(this);
	        update.addActionListener(this);
	        
	        
	    
	        
	        
	        submitDelete.addActionListener(new ActionListener() {
	        	
	        	
	        	 public void actionPerformed(ActionEvent event)  {
	        		 
	        		 int d=Integer.parseInt(n_delete.getText().toString());
	            	 	String requete = "DELETE FROM clients WHERE Identifiant = '"+d+"' ";
	            	       
	            	 	try {
	            	 		Statement st = Connections.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            			 st.executeUpdate(requete);
	            			 JOptionPane.showMessageDialog(null, "requete ex�cut�e avec succ�s");
	            			 
	            	 	}
	            	 	catch (SQLException ex) {
	            	 		ex.printStackTrace();
	            	 	}
	                 
	     
	             }
	         
	        		 });
	        
	        update.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	              flag=true;
	            }
	        });
	        
	
	 submitUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
             card.show(getContentPane(), "5");
           /**  er=Integer.parseInt(update_n.getText().toString());*/
             String nom = IhmForm.getLast_name().getText().toString();
             String prenom = IhmForm.getFirst_name().getText().toString();
      	 	int ident1 = Integer.parseInt(IhmForm.getId().getText().toString());
      	 	int age2 = Integer.parseInt(IhmForm.getF_age().getText().toString());
      	 	String gen="";
 			if(IhmForm.getMasculin().isSelected()){
                 gen="female";
             }else{
               gen="male";
             }
 			String genre = gen;
              int id=Integer.parseInt(update_n.getText().toString());
              
 	       	 	String requete = "UPDATE clients SET prenom = '"+prenom+"', nom ='"+nom+"', matricule= '562', age= '"+age2+"', genre= '"+genre+"', identifiant= '"+ident1+"'WHERE identifiant = '"+id+"' ";
 	       	 			          	         
 	       	       
 	       	 	try {
 	       	 		Statement st = connexions.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
 	       			 st.executeUpdate(requete);
 	       			 JOptionPane.showMessageDialog(null, "Query executed with success"); 
 	       	 	}
 	       	 	catch (SQLException ex) {
 	       	 		ex.printStackTrace();
 	       	 	}
 	        }
      });
    setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(500, 500);
     setVisible(true);
 }

 public static void main(String[] args) {
     // TODO code application logic here
     Ihm obj = new Ihm();
 }

 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == insert) {
         card.show(getContentPane(), "2");
     } else if (e.getSource() == delete) {
         card.show(getContentPane(), "3");
     } else if (e.getSource() == update) {
         card.show(getContentPane(), "4");
     }
     
 }


}
