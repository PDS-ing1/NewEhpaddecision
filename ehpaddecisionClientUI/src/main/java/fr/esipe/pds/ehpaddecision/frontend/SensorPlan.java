package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;


import fr.esipe.pds.ehpaddecision.backend.PlanSensorBackEnd;

import javax.swing.JToolBar;
import javax.swing.JList;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Panel;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Button;



	



public class SensorPlan extends JFrame implements ActionListener{
	private JButton button_1;
	public JFrame frame;
	PlanSensorBackEnd  sensorPlanBackEnd;

	JButton button ;
	JButton btnNewButton_1;
	
	Sensors_Add instance ;

	String living_room = "Living room";
	String kitchen = "Kitchen";
	String dinning_Room = "Dinning Room";
	String library = "Library";
	String corridor1 = "Corridor1";
	String corridor2 = "Corridor2";
	String corridor3 = "Corridor3";

	JButton kitchen2;
	JButton dinning_Room2;
	JButton corridor1_2;
	JButton corridor2_1;
	JButton dinning_Room1;
	JButton coridor2_2;
	JButton coridor2_3;
	JButton corridor3_2;
	JButton library2;
	JButton living_room1;
	JButton living_room2;
	JButton kitchen1;
	JButton library1;
	JButton corridor3_1;
	JButton corridor1_1;
	JButton btnNewButton;

	public void begin()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorPlan window = new SensorPlan();
					window.setVisible(true);
					instance = new Sensors_Add();
					instance.getFrame().setVisible(false);
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

	public SensorPlan(Sensors_Add sensors_Add) {
		this.instance = sensors_Add;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		//frame = new JFrame();
		sensorPlanBackEnd = new PlanSensorBackEnd(this);
		instance = new Sensors_Add();
		getContentPane().setBackground(Color.ORANGE);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(415, 480);
		setResizable(false);


		btnNewButton = new JButton("Add a sensor");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.getFrame().setVisible(true);
				
			}
			
		});
		btnNewButton.setBounds(20, 11, 174, 23);
		getContentPane().add(btnNewButton);
		
		
		btnNewButton_1 = new JButton("Delete a sensor\r\n");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(20, 44, 174, 23);
		getContentPane().add(btnNewButton_1);
		
		//btnNewButton_1.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {

				//instance = new DeleteSensor();
				//instance.setVisible(true);
			//}
		//});

		JButton btnNewButton_2 = new JButton("Set up a sensor");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_2.setBounds(198, 11, 190, 23);
		getContentPane().add(btnNewButton_2);


		btnNewButton_2.setBounds(198, 11, 190, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Visualize indicators ");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(198, 44, 190, 23);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EhpadPage ehpad = new EhpadPage();
				ehpad.setVisible(true);
			}
		});

		button = new JButton("Refresh");
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(sensorPlanBackEnd);
		button.setBounds(198, 77, 190, 23);
		getContentPane().add(button);

		button_1 = new JButton("Visulize Alerts");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainClient client = new MainClient();
				
				client.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(20, 79, 174, 21);
		getContentPane().add(button_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(33, 129, 330, 281);
		getContentPane().add(panel);
		panel.setLayout(null);

		kitchen2 = new JButton("available");
		kitchen2.setForeground(Color.WHITE);
		kitchen2.setBackground(Color.WHITE);
		kitchen2.setBounds(2, 22, 97, 27);
		panel.add(kitchen2);
		kitchen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kitchen2.setText(kitchen);
			}
		});
		dinning_Room2 = new JButton("available");
		dinning_Room2.setBackground(Color.WHITE);
		dinning_Room2.setForeground(Color.WHITE);
		dinning_Room2.setBounds(225, 22, 100, 25);
		panel.add(dinning_Room2);
		dinning_Room2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dinning_Room2.setText(dinning_Room);
			}
		});

		corridor1_2 = new JButton("available\r\n");
		corridor1_2.setBackground(Color.WHITE);
		corridor1_2.setForeground(Color.WHITE);
		corridor1_2.setBounds(112, 60, 103, 27);
		panel.add(corridor1_2);
		corridor1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corridor1_2.setText(corridor1);
			}
		});

		corridor2_1 = new JButton("Sensor");
		corridor2_1.setBounds(112, 97, 103, 27);
		panel.add(corridor2_1);
		corridor2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corridor2_1.setText(corridor2);
			}
		});

		dinning_Room1 = new JButton("Sensor");
		dinning_Room1.setBounds(223, 57, 102, 27);
		panel.add(dinning_Room1);
		dinning_Room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dinning_Room1.setText(dinning_Room);

			}
		});

		coridor2_2 = new JButton("available");
		coridor2_2.setBackground(Color.WHITE);
		coridor2_2.setForeground(Color.WHITE);
		coridor2_2.setBounds(112, 134, 103, 27);
		panel.add(coridor2_2);
		coridor2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coridor2_2.setText(corridor2);
			}
		});

		coridor2_3 = new JButton("Sensor");
		coridor2_3.setBounds(112, 171, 102, 27);
		panel.add(coridor2_3);
		coridor2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coridor2_3.setText(corridor2);
			}
		});

		corridor3_2 = new JButton("available");
		corridor3_2.setBackground(Color.WHITE);
		corridor3_2.setForeground(Color.WHITE);
		corridor3_2.setBounds(112, 208, 103, 27);
		panel.add(corridor3_2);
		corridor3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corridor3_2.setText(corridor3);
			}
		});
		library2 = new JButton("available");
		library2.setBackground(Color.WHITE);
		library2.setForeground(Color.WHITE);
		library2.setBounds(225, 246, 100, 25);
		panel.add(library2);
		library2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				library2.setText(library);
			}
		});

		living_room1 = new JButton("Sensor");
		living_room1.setBounds(2, 242, 100, 27);
		panel.add(living_room1);

		living_room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				living_room1.setText(living_room);
			}
		});

		living_room2 = new JButton("available");
		living_room2.setBackground(Color.WHITE);
		living_room2.setForeground(Color.WHITE);
		living_room2.setBounds(2, 208, 100, 24);
		panel.add(living_room2);

		living_room2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				living_room2.setText(living_room);
			}
		});

		kitchen1 = new JButton("Senor");
		kitchen1.setBounds(2, 59, 100, 24);
		panel.add(kitchen1);

		kitchen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kitchen1.setText(kitchen);
			}
		});

		library1 = new JButton("Sensor");
		library1.setBounds(225, 208, 100, 27);
		panel.add(library1);
		library1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				library1.setText(library);
			}
		});


		corridor1_1 = new JButton("Sensor");
		corridor1_1.setBounds(109, 22, 108, 30);
		panel.add(corridor1_1);
		corridor1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corridor1_1.setText(corridor1);
			}
		});

		corridor3_1 = new JButton("Sensor");
		corridor3_1.setBounds(112, 245, 103, 24);
		panel.add(corridor3_1);
		corridor3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corridor3_1.setText(corridor3);
			}
			
		});
		
		
		



		setVisible(true);
	}

	public void AddButtonavailable(String location)
	{
		if(location == living_room)
		{
			living_room2.setBackground(Color.GRAY);

		}
		if(location == kitchen)
		{
			kitchen2.setBackground(Color.GRAY);

		}
		if(location == dinning_Room )
		{
			dinning_Room2.setBackground(Color.GRAY);

		}
		if(location == library )
		{
			library2.setBackground(Color.GRAY);

		}
		if(location == corridor3)
		{
			corridor3_2.setBackground(Color.GRAY);

		}
		if(location == corridor2)
		{
			coridor2_2.setBackground(Color.GRAY);

		}
		if(location == corridor1)
		{
			corridor1_2.setBackground(Color.GRAY);

		}

	}



	public void setButtonIs_Active(String location,String mode)
	{
		if(mode.toUpperCase() == "ON")
		{
			if(location == living_room)
			{
				living_room1.setBackground(Color.GREEN);

			}
			if(location == kitchen)
			{
				kitchen1.setBackground(Color.GREEN);

			}
			if(location == dinning_Room )
			{
				dinning_Room1.setBackground(Color.GREEN);

			}
			if(location == library )
			{
				library1.setBackground(Color.GREEN);

			}
			if(location == corridor3)
			{
				corridor3_1.setBackground(Color.GREEN);

			}
			if(location == corridor2)
			{
				corridor2_1.setBackground(Color.GREEN);

			}
			if(location == corridor1)
			{
				corridor1_1.setBackground(Color.GREEN);

			}
		}
		else 
		{
			if(location == living_room)
			{
				living_room2.setBackground(Color.GRAY);

			}
			if(location == kitchen)
			{
				kitchen2.setBackground(Color.GRAY);

			}
			if(location == dinning_Room )
			{
				dinning_Room2.setBackground(Color.GRAY);

			}
			if(location == library )
			{
				library2.setBackground(Color.GRAY);

			}
			if(location == corridor3)
			{
				corridor3_2.setBackground(Color.GRAY);

			}
			if(location == corridor2)
			{
				coridor2_2.setBackground(Color.GRAY);

			}
			if(location == corridor1)
			{
				corridor1_2.setBackground(Color.GRAY);

			}
		}

	}
	
	public JButton getButonAdd()
	{
		return btnNewButton;
	}


	public JButton getButonAlerts() {
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}
}

