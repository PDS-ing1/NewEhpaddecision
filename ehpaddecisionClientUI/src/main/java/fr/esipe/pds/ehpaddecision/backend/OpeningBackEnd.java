package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import fr.esipe.pds.ehpaddecision.*;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import fr.esipe.pds.ehpaddecision.frontend.openingPage;


public class OpeningBackEnd implements ActionListener{
	
	private EhpadPage ehpadPage;
	private openingPage openingPage;
	
	public OpeningBackEnd (EhpadPage ehpadPage, openingPage openinPage){
		this.ehpadPage = ehpadPage;
		this.openingPage = openingPage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//@SuppressWarnings("incomplete-switch");
	//@Override
	/*public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton)
		{
			JButton clickedButton = (JButton)e.getSource();

			if(clickedButton == openingPage.getAccessToServerButton())
			{				
				openingPage.getConnectionStateLabel().setText(ConnectionStarting.TRYAGAIN);
				
				ConnectionStarting status = .initializeSocket();
				openingPage.getConnectionStateLabel().setText("");
				switch(status)
				{					
					case FAIL:
						JOptionPane.showMessageDialog(null, ConnectionStarting.FAIL, ConnectionStarting.FAIL, JOptionPane.ERROR_MESSAGE);
						break;	
						
					case CONNECTION_PROBLEM:
						JOptionPane.showMessageDialog(null, ConnectionStarting.CONNECTION_PROBLEM, ConnectionStarting.CONNECTION_PROBLEM,JOptionPane.ERROR_MESSAGE);
						break;
	
					case WELLDONE:
						JOptionPane.showMessageDialog(null, ConnectionStarting.WELLDONE , ConnectionStarting.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
						// Changes the pages in order to have the home page
						ehpadPage.changePage(ehpadPage.getHomePageName());
						//Updates the monitrackFrame
						ehpadPage.setVisible(true);	
						break;
				}
			}
		}

	}
	}*/
	

}
