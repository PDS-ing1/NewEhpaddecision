package fr.esipe.pds.ehpaddecision.frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;


public class Dashboard extends JFrame {

	private JButton close = new JButton("Close");
	private JButton display_all = new JButton ("Display all analysis");
	private JButton display_filtered = new JButton("Display filtred analysis");
	private JButton personalize_filter = new JButton("Personalize your filter");

	
	
	
	public Dashboard(){
		
		this.setTitle("EHPAD Decision ");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}				
		});
	
	
	
		display_all.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			display_all();
		}

						
		});
	

		display_filtered.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			display_filtered();
			}				
		});
		
		personalize_filter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			personalize_filter();
			}				
		});
		
		
		
	}
	
	private void display_all() {
		// TODO Auto-generated method stub
	}
	private void display_filtered() {
		// TODO Auto-generated method stub
		// Choose the way to handle this Button, by Queries where we stored all queries type, CRUD or wirte the lines of code here
	}
	private void personalize_filter() { }
	
	
	
	
	
}
