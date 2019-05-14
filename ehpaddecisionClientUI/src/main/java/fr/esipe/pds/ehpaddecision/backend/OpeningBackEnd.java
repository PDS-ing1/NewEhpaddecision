package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import fr.esipe.pds.ehpaddecision.*;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import fr.esipe.pds.ehpaddecision.frontend.OpenPageFront;
import fr.esipe.pds.ehpaddecision.frontend.Sensors_Add;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.main.EhpadMain;

public class OpeningBackEnd implements ActionListener{
	private EhpadPage ehpadPage;
	private OpenPageFront openFront;
	private Sensors_Add sensors_add;
	private EhpadPage ehpadPage2;

	public OpeningBackEnd(EhpadPage ehpadPage, OpenPageFront openFront) {
		this.ehpadPage=ehpadPage;
		this.openFront = openFront; 
	}

	public OpeningBackEnd(EhpadPage ehpadPage2, Sensors_Add sensors_add) {
		// TODO Auto-generated constructor stub
		this.ehpadPage2=ehpadPage2;
		this.sensors_add=sensors_add;
		
	}

	// this class of Opening Back End checks if we are connected to the server and get back a message
	@SuppressWarnings("incomplete-switch")
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() instanceof JButton)
		{
			JButton clickedButton = (JButton)ae.getSource();

			if(clickedButton == openFront.serverAccess())
			{				
				openFront.connectionState().setText(ConnectionStarting.TRYAGAIN.getMessage());
				
				ConnectionStarting status = ClientServerConnection.callSocket();
				openFront.connectionState().setText("");
				switch(status)
				{	
				// if we are not connected, we will get back an error message of Fail with ERROR_MESSAGE as a pop up
					case FAIL:
						JOptionPane.showMessageDialog(null, ConnectionStarting.FAIL,null, JOptionPane.ERROR_MESSAGE);
						break;	
						
					case CONNECTION_PROBLEM:
						JOptionPane.showMessageDialog(null, ConnectionStarting.CONNECTION_PROBLEM, null, JOptionPane.ERROR_MESSAGE);
						break;
	
					case WELLDONE:
						JOptionPane.showMessageDialog(null, ConnectionStarting.WELLDONE, null, JOptionPane.INFORMATION_MESSAGE);
						ehpadPage.showPage(ehpadPage.returnNameEhpad());
						ehpadPage.setVisible(true);
						
						break;
				}
			}
		}

	}
}
	

