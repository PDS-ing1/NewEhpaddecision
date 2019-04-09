package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.CardLayout;
import javax.swing.JFrame;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;

import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;
import fr.esipe.pds.ehpaddecision.frontend.OpenPageFront;


import fr.esipe.pds.ehpaddecision.backend.*;



@SuppressWarnings("serial")
public class EhpadPage extends JFrame {
	private HomePageFront homePage;
	private OpenPageFront openingPage;
	private String homePageSpell;
	private String pageOpeningSpell;
	private CardLayout cdLayout;
	private EhpadBackEnd ehpadbackend;
	public EhpadPage()
	{
		cdLayout = new CardLayout();
		setLayout(cdLayout);
		this.setSize(800, 450);
		
		openingPage = new OpenPageFront(this);
		homePage = new HomePageFront();		

		pageOpeningSpell = "Welcome_PAGE";
	    add(openingPage, pageOpeningSpell);
	    
	    homePageSpell = "HOME_PAGE";
	    add(homePage, homePageSpell);
	    
	    ehpadbackend = new EhpadBackEnd(this);
		
		this.setTitle("EHPAD DECISION");
		cdLayout.show(this.getContentPane(),pageOpeningSpell );
		setLocationRelativeTo(null);
		this.addWindowListener(ehpadbackend );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public String returnNameEhpad() {
		return homePageSpell;
	}

	public void showPage(String ehpadname) {
		// TODO Auto-generated method stub
		cdLayout.show(this.getContentPane(), ehpadname);
	}
}
