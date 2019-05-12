package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JToolBar;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import fr.esipe.pds.ehpaddecision.frontend.images.*;

import javax.swing.SwingConstants;

public class SensorPlan implements ActionListener{

	public JFrame frame;
	JLabel image1;
	JLabel image2;
	JLabel image3;
	JButton btnNewButton_1;
	
	public void begin()
	{
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				SensorPlan window = new SensorPlan();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	}
	public static void main(String[] args) {
		SensorPlan window = new SensorPlan();
		window.begin();
	}

	/**
	 * Create the application.
	 */
	public SensorPlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(415, 480);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 78, 387, 290);
		frame.getContentPane().add(panel);
		frame.setTitle("Welcome !");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{1, 0};
		gbl_panel.rowHeights = new int[]{1, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel image = new JLabel( new ImageIcon( "src/main/java/fr/esipe/pds/ehpaddecision/frontend/maison de retraite.png"));
		image.setHorizontalTextPosition(SwingConstants.CENTER);
		image.setIgnoreRepaint(true);
		image.setEnabled(true);
		GridBagConstraints gbc_image = new GridBagConstraints();
		gbc_image.anchor = GridBagConstraints.CENTER;
		gbc_image.gridx = 0;
		gbc_image.gridy = 0;
		panel.add(image, gbc_image);
		panel.setVisible(true);
		
		image1 = new JLabel( new ImageIcon( "src/main/java/fr/esipe/pds/ehpaddecision/frontend/croix rouge.png"));
		image2 = new JLabel( new ImageIcon( "src/main/java/fr/esipe/pds/ehpaddecision/frontend/croix verte.png"));
	    image3 = new JLabel( new ImageIcon( "src/main/java/fr/esipe/pds/ehpaddecision/frontend/croix grise.png"));
		
	    
	    
		JLabel lblNewLabel = new JLabel(" Important: An alert has been reported ! For more information, please see the plan ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 381, 409, 59);
		lblNewLabel.setVisible(false);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add a sensor");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(20, 11, 174, 23);
		frame.getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("Delete a sensor\r\n");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(20, 44, 174, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Set up a sensor");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(198, 11, 190, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Visualize indicators ");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(198, 44, 190, 23);
		frame.getContentPane().add(btnNewButton_3);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnNewButton_1 )
		{
			DeleteSensor instance = new DeleteSensor();
			instance.frame.setVisible(true);
		}
		
	}
}
