package fr.esipe.pds.connection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Interface extends JFrame implements ActionListener {

	public static boolean flag = false;
	public static int er=0;
	//JDBCConnectionPool drivrebase = new JDBCConnectionPool();
	
	CardLayout card;
	
	JButton insert, delete, update, submitDelete, submitUpdate;
	JPanel panel_insert, panel_delete, panel_update, panel, panel_update_in;
	JLabel label_delete, label_update, label_update_er, Result;
	JTextField n_delete, update_n;

	 public Interface() {
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
	        label_delete = new JLabel("Enter enroolemnt number for DELETE data");
	        Font font = new Font("Times New Romen", Font.BOLD, 20);
	        submitDelete =new JButton("Submit delete");
	        submitUpdate =new JButton("Submit update");
	        n_delete= new JTextField(20);
	        update_n=new JTextField(20);
	        label_update = new JLabel("Enter new values...");
	        label_update.setFont(font);
	        label_update_er=new JLabel("Enter er Number");
	        label_update_er.setFont(font);
	        
	        setLayout(card);
	        //FIRST PAGE
	        panel.add(insert);
	        panel.add(delete);
	        panel.add(update);
	        //INSERT CODE
	        panel_insert.add(new Interface_Form(card, getContentPane()));
	        setLocationRelativeTo(null);
	      
	       //DELETE CODE
	        
	        panel_delete.add(label_delete);
	        panel_delete.add(n_delete);
	        panel_delete.add(submitDelete);
	        panel_delete.add(Result);
	        panel_delete.add(new Back(card, getContentPane()));
	        
	        panel_update_in.add(label_update_er);
	        panel_update_in.add(update_n);
	        panel_update_in.add(submitUpdate);
	        panel_update_in.add(new Back(card, getContentPane()));
	       
	        // UPDATE CODE
	        
	        panel_update.setLayout(new BorderLayout());
	        panel_update.add(label_update,BorderLayout.NORTH);
	        panel_update.add(new Interface_Form(card, getContentPane()));
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
	                 
	                 String re="";
	                 int d=Integer.parseInt(n_delete.getText().toString());
				//	 re=drivrebase.Delete(d);
					 Result.setText(re);
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
             er=Integer.parseInt(update_n.getText().toString());
         }
     });
    setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(500, 500);
     setVisible(true);
 }

 public static void main(String[] args) {
     // TODO code application logic here
     Interface obj = new Interface();
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
