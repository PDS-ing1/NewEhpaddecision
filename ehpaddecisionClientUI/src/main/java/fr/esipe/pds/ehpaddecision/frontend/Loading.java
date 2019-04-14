package fr.esipe.pds.ehpaddecision.frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Loading  extends JWindow{
	
		private Thread th;
		private JProgressBar bar;
		private static JButton launch ;
	
		public Loading(){
			
			setSize(490, 370);
			setLocationRelativeTo(null);
			
			th = new Thread(new Handling());
			bar  = new JProgressBar();
			bar.setMaximum(300);
			bar .setMinimum(0);
			bar.setStringPainted(true);
			bar.setBackground(Color.white);
			
			
			
		
					th = new Thread(new Handling());
					th.start();
					
					
				
			
				
			
			
			
			
			JPanel pan = new JPanel();
			JLabel img = new JLabel(new ImageIcon("images/chargement.jpg"));
			img.setVerticalAlignment(JLabel.CENTER);
			img.setHorizontalAlignment(JLabel.CENTER);
			
			pan.setBorder(BorderFactory.createLineBorder(Color.blue));
			pan.add(img);
			getContentPane().add(pan, BorderLayout.NORTH);
			getContentPane().add(bar, BorderLayout.CENTER);
			getContentPane().add(new JLabel("Loading in progress, please wait..."), BorderLayout.SOUTH);
		
		}
		


	class Handling implements Runnable{

		public void run(){
			
			
			for(int val = 0; val <= 300; val++){
				bar.setValue(val);
				try {
					th.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		setVisible(false);
		}	
	}


	}