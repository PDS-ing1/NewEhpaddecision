package fr.esipe.pds.ehpaddecision.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import javax.swing.*;
public class EhpadMain {
	
	
	private static  final Logger log = LoggerFactory.getLogger(EhpadMain.class);
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
	
		public void run() {
			log.info("Welcome to EHPAD DECISION");
			EhpadPage ehpadpage = new EhpadPage();
		}
		
		}
	);
	}

	}
