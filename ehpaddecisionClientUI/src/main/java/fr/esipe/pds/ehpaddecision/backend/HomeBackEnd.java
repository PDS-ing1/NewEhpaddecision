package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.frontend.MainPage;








public class HomeBackEnd implements ActionListener
{
	
	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);
	private MainPage mainPage; 
	
	public HomeBackEnd (MainPage mainPage){
		this.mainPage=mainPage;
	}
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}