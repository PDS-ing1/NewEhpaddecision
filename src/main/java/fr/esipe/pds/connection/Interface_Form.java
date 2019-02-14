package fr.esipe.pds.connection;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Interface_Form extends JPanel{
	
	 public static boolean flag1=false;
	    CardLayout cardLayout;
	    Container container;
	    JLabel label_name, label_last_name, label_id,label_age, label_dept, label_gender, _label_for_delete, nothing, result;
	   
	   JTextField first_name, last_name, id, f_age, f_dept, f_gender, delete_no;
	    JRadioButton masculin, feminin;
	    ButtonGroup btngrp;
	    JButton submit;
	
	    
	    public Interface_Form(CardLayout cn, Container cr) {
	        
	    	//these lines of code are to show labels on fields 
	    	submit = new JButton("SUBMIT");
	        label_name = new JLabel("prenom");
	        label_last_name = new JLabel("nom:");
	        label_id = new JLabel("identifiant");
	        label_dept = new JLabel("role");
	        label_gender = new JLabel("genre");
	        label_age = new JLabel("age:");
	        nothing = new JLabel(" ");
	        result=new JLabel("");
	        
	        //these lines of code are to ask users about their information
	        first_name = new JTextField(12);
	        last_name = new JTextField(12);
	        id = new JTextField(10);
	        f_dept = new JTextField(12);
	        f_age = new JTextField(12);
	        
	        //To choose the gender male or female and then to press submit
	        masculin = new JRadioButton("male", true);
	        feminin = new JRadioButton("Female");
	        btngrp = new ButtonGroup();
	        btngrp.add(masculin);
	        btngrp.add(feminin);
	        
	         setLayout(new GridLayout(8, 3));
	         add(label_name);
	         add(first_name);
	         add(label_last_name);
	         add(last_name);
	         add(id);
	         add(label_id);
	         add(label_age);
	         add(f_age);
	         add(label_gender);
	         add(masculin);
	         add(nothing);
	         add(feminin);
	         add(submit);
	         add(new Back(cardLayout, container));
	         add(result);
	         
	         submit.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            
	                 if(Interface.flag==false)
	                 {
	                     try {
	                         query();
	                     } catch (ClassNotFoundException ex) {
	                         Logger.getLogger(Interface_Form.class.getName()).log(Level.SEVERE, null, ex);
	                     } catch (SQLException ex) {
	                         Logger.getLogger(Interface_Form.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	                  }
	                 else
	                 {
	                     flag1=true;
	                     try {
	                         query();
	                     } catch (ClassNotFoundException ex) {
	                         Logger.getLogger(Interface_Form.class.getName()).log(Level.SEVERE, null, ex);
	                     } catch (SQLException ex) {
	                         Logger.getLogger(Interface_Form.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	                 }
	               
	             }
	         });
	      } 
	    public void query() throws ClassNotFoundException, SQLException
	    {
	        String req="";
	                   
	                   DriverDB drivrebase=new DriverDB();
	                   int er=Integer.parseInt(id.getText().toString());
	                   int age=Integer.parseInt(f_age.getText().toString());
	                   String gen="";
	                   
	                   if(masculin.isSelected()){
	                       gen="female";
	                   }else{
	                     gen="male";
	                   }
	                   req =drivrebase.insertAndUpdate(first_name.getText().toString(), last_name.getText().toString(),er , age, gen);
	                   result.setText(req);
	                  }
	
}
