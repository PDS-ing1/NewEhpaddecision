package fr.esipe.ehpaddecision.connection;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class IhmForm extends JPanel{
	
	 public static boolean flag1=false;
	    CardLayout cardLayout;
	    Container container;
	    JLabel label_name, label_last_name, label_id,label_age, label_dept, label_gender, _label_for_delete, nothing, result;
	   
	   static JTextField first_name;
	static JTextField last_name;
	static JTextField id;
	static JTextField f_age;
	JTextField f_dept;
	JTextField f_gender;
	JTextField delete_no;
	    static JRadioButton Masculin;
		JRadioButton Feminin;
	    ButtonGroup btngrp;
	    JButton submit;
	
	    
	    public IhmForm(CardLayout cn, Container cr) {
	        
	    	//these lines of code are to show labels on fields 
	    	submit = new JButton("SUBMIT");
	        label_name = new JLabel("Prenom");
	        label_last_name = new JLabel("Nom:");
	        label_id = new JLabel("Identifiant");
	        label_dept = new JLabel("Role");
	        
	        label_gender = new JLabel("Genre");
	        label_age = new JLabel("Age:");
	        nothing = new JLabel(" ");
	        result=new JLabel("");
	        
	        //these lines of code are to ask users about their information
	        first_name = new JTextField(12);
	        last_name = new JTextField(12);
	        id = new JTextField();
	        f_dept = new JTextField(12);
	        f_age = new JTextField(12);
	        
	        //To choose the gender male or female and then to press submit
	        Masculin = new JRadioButton("Male", true);
	        Feminin = new JRadioButton("Female");
	        btngrp = new ButtonGroup();
	        btngrp.add(Masculin);
	        btngrp.add(Feminin);
	        
	         setLayout(new GridLayout(8, 3));
	         add(label_name);
	         add(first_name);
	         add(label_last_name);
	         add(last_name);
	         add(label_id);
	         add(id);
	         
	         add(label_age);
	         add(f_age);
	         add(label_gender);
	         add(Masculin);
	         add(nothing);
	         add(Feminin);
	         add(submit);
	         
	         add(result);
	         
	         submit.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	                 if(Ihm.flag==false)
	                 {
	                     try {
	                         query();
	                     } catch (ClassNotFoundException ex) {
	                         Logger.getLogger(IhmForm.class.getName()).log(Level.SEVERE, null, ex);
	                     } catch (SQLException ex) {
	                         Logger.getLogger(IhmForm.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	                  }
	                 else
	                 {
	                     flag1=true;
	                     try {
	                         query();
	                     } catch (ClassNotFoundException ex) {
	                         Logger.getLogger(IhmForm.class.getName()).log(Level.SEVERE, null, ex);
	                     } catch (SQLException ex) {
	                         Logger.getLogger(IhmForm.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	                 }
	                 
	               
	             }
	         });
	      
	    
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String nom = first_name.getText().toString();
				String prenom = last_name.getText().toString();
				int ident = Integer.parseInt(id.getText().toString());
				int age1 = Integer.parseInt(f_age.getText().toString());
				String gen="";
				if(Masculin.isSelected()){
                    gen="female";
                }else{
                  gen="male";
                }
				
				

				String requete = "INSERT INTO clients(prenom, nom , matricule, age, genre, identifiant) VALUES ('"+nom+"','"+prenom+"', 564,'"+age1+"','"+gen+"','"+ident+"')";

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
	    }
    
	    public static JTextField getFirst_name() {
			return first_name;
		}
		public void setFirst_name(JTextField first_name) {
			this.first_name = first_name;
		}
		public static JTextField getLast_name() {
			return last_name;
		}
		public void setLast_name(JTextField last_name) {
			this.last_name = last_name;
		}
		public static JTextField getId() {
			return id;
		}
		public void setId(JTextField id) {
			this.id = id;
		}
		public static JTextField getF_age() {
			return f_age;
		}
		public void setF_age(JTextField f_age) {
			this.f_age = f_age;
		}
		public JTextField getF_dept() {
			return f_dept;
		}
		public void setF_dept(JTextField f_dept) {
			this.f_dept = f_dept;
		}
		public JTextField getF_gender() {
			return f_gender;
		}
		public void setF_gender(JTextField f_gender) {
			this.f_gender = f_gender;
		}
		public static JRadioButton getMasculin() {
			return Masculin;
		}
		public void setMasculin(JRadioButton masculin) {
			Masculin = masculin;
		}
		public JRadioButton getFeminin() {
			return Feminin;
		}
		public void setFeminin(JRadioButton feminin) {
			Feminin = feminin;
		}
		public void query() throws ClassNotFoundException, SQLException
	    {
	        String req="";
	                   
	                  // DriverDB drivrebase=new DriverDB();
	                   int er=Integer.parseInt(id.getText().toString());
	                   int age=Integer.parseInt(f_age.getText().toString());
	                   String gen="";
	                   
	                   if(Masculin.isSelected()){
	                       gen="female";
	                   }else{
	                     gen="male";
	                   }
	                  // req =drivrebase.insertAndUpdate(first_name.getText().toString(), last_name.getText().toString(),er , age, gen);
	                   result.setText(req);
	                  }
	
}
