package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import fr.esipe.pds.ehpaddecision.*;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import fr.esipe.pds.ehpaddecision.frontend.openingPage;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;


public class OpeningBackEnd implements ActionListener{
	
	private EhpadPage ehpadPage;
	private openingPage openingPage;
	
	public OpeningBackEnd (EhpadPage ehpadPage, openingPage openinPage){
		this.ehpadPage = ehpadPage;
		this.openingPage = openingPage;
	}

	
	
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() instanceof JButton)
		{
			JButton clickedButton = (JButton)ae.getSource();

			if(clickedButton == openingPage.getAccessToServerButton())
			{				
				openingPage.connectionStatus().getToolTipText();
				
				ConnectionStarting status = ClientServerConnection.callSocket();
				openingPage.connectionStatus().setText("");
				switch(status)
				{					
					case FAIL:
						JOptionPane.showMessageDialog(null, ConnectionStarting.FAIL);
						break;	
						
					case CONNECTION_PROBLEM:
						JOptionPane.showMessageDialog(null, ConnectionStarting.CONNECTION_PROBLEM);
						break;
	
					case WELLDONE:
						JOptionPane.showMessageDialog(null, ConnectionStarting.WELLDONE);
						
						ehpadPage.showPage(true);	
						break;
				}
			}
		}

	}
}
	

