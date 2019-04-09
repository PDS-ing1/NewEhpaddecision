package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.frontend.MainPageOld;

public class MainPageBackEndOld implements ActionListener
{
	
	private static final  Logger log = LoggerFactory.getLogger(MainPageBackEndOld.class);
	private MainPageOld mainPageOld; 
	
	public MainPageBackEndOld (MainPageOld mainPageOld){
		this.mainPageOld=mainPageOld;
	}
	

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}

}