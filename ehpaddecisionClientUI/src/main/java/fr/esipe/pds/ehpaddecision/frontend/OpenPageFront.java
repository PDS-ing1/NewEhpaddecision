package fr.esipe.pds.ehpaddecision.frontend;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.esipe.pds.ehpaddecision.backend.OpeningBackEnd;
import fr.esipe.pds.ehpaddecision.main.EhpadMain;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;;



public class OpenPageFront extends JPanel{
	
	private OpeningBackEnd openbackend;
	private EhpadMain ehpadmain;
	private  JButton gotoServer;
	private int pWidth;
	private int pHeight;
	private JLabel connectionStatus;
	private EhpadPage ehpadPage;
	
	
	public OpenPageFront(EhpadPage ehpadPage)
	{
		setLayout(new BorderLayout());
		connectionStatus = new JLabel("", SwingConstants.CENTER);
		this.ehpadPage = ehpadPage;
		pWidth = ehpadPage.getWidth();
		pHeight = ehpadPage.getHeight();
		setBackground(new Color(255,255,255));
		
		
		openbackend = new OpeningBackEnd(ehpadPage, this);
			
				
		gotoServer = new JButton("Go to servers");
		gotoServer.addActionListener(openbackend);
		connectionStatus.setFont(new Font("Calibri", Font.BOLD, 22));
	
		add(connectionStatus, BorderLayout.CENTER);
		add(gotoServer, BorderLayout.NORTH);
	}
	
	public  JButton serverAccess() {
		return gotoServer;
	}

	public JLabel connectionState() {
		return connectionStatus;
	}



	
	
}
