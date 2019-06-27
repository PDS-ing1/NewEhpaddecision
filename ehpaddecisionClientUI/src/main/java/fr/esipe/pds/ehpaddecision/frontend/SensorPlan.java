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

import fr.esipe.pds.ehpaddecision.backend.HomeBackEnd;

//import com.jgoodies.forms.factories.DefaultComponentFactory;


import fr.esipe.pds.ehpaddecision.backend.PlanSensorBackEnd;
import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Sensors;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;
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
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;







public class SensorPlan extends JFrame implements ActionListener, WindowListener {
	private JButton button_1;
	//public JFrame frame;
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
	JPanel kitchenn, libraryy;
	JPanel livingRoom, dinningRoom, corridorr1, corridorr2,corridorr3,corridorr4;
	private static final  Logger log = LoggerFactory.getLogger(HomeBackEnd.class);

	JButton boutonSensor;


	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorPlan window = new SensorPlan();
					window.setVisible(true);
					//					instance = new Sensors_Add();
					//					instance.getFrame().setVisible(false);




				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	//	public static void main(String[] args) {
	//		SensorPlan window = new SensorPlan();
	//		window.begin();
	//	}

	/**
	 * Create the application.
	 */
	public SensorPlan() {
		setResizable(false);
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
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

		instance = new Sensors_Add();
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(741, 693);


		btnNewButton = new JButton("Add a sensor");
		btnNewButton.setBounds(120, 11, 174, 23);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.getFrame().setVisible(true);

			}

		});
		getContentPane().setLayout(null);

		livingRoom = new JPanel();
		livingRoom.setBounds(10, 131, 359, 117);
		getContentPane().add(livingRoom);
		livingRoom.setBackground(Color.PINK);
		livingRoom.setForeground(Color.PINK);
		livingRoom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(btnNewButton);


		btnNewButton_1 = new JButton("Delete a sensor\r\n");
		btnNewButton_1.setBounds(120, 44, 174, 23);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnNewButton_1);

		//btnNewButton_1.addActionListener(new ActionListener() {
		//public void actionPerformed(ActionEvent arg0) {

		//instance = new DeleteSensor();
		//instance.setVisible(true);
		//}
		//});

		JButton btnNewButton_2 = new JButton("Set up a sensor");
		btnNewButton_2.setBounds(406, 11, 190, 23);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		getContentPane().add(btnNewButton_2);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Visualize indicators ");
		btnNewButton_3.setBounds(406, 44, 190, 23);
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EhpadPage ehpad = new EhpadPage();
				ehpad.setVisible(true);
			}
		});

		

		button_1 = new JButton("Visulize Alerts");
		button_1.setBounds(120, 77, 174, 23);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainClient client = new MainClient();

				client.getFrame().setVisible(true);
			}
		});
		getContentPane().add(button_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(658, 204, 59, 68);
		getContentPane().add(panel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(658, 411, 59, 235);
		getContentPane().add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(658, 268, 59, 147);
		getContentPane().add(panel_4);

		corridorr1 = new JPanel();
		corridorr1.setBounds(369, 131, 289, 117);
		getContentPane().add(corridorr1);
		corridorr1.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		corridorr1.setForeground(Color.BLACK);
		corridorr1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		corridorr3 = new JPanel();
		corridorr3.setBounds(407, 376, 251, 147);
		getContentPane().add(corridorr3);
		corridorr3.setBackground(new Color(238, 232, 170));
		corridorr3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		corridorr4 = new JPanel();
		corridorr4.setBounds(369, 523, 289, 123);
		getContentPane().add(corridorr4);
		corridorr4.setBackground(new Color(221, 160, 221));
		corridorr4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		corridorr2 = new JPanel();
		corridorr2.setBounds(343, 250, 315, 123);
		getContentPane().add(corridorr2);
		corridorr2.setBackground(new Color(255, 222, 173));
		corridorr2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		libraryy = new JPanel();
		libraryy.setBounds(10, 523, 359, 123);
		getContentPane().add(libraryy);
		libraryy.setBackground(Color.MAGENTA);
		libraryy.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		dinningRoom = new JPanel();
		dinningRoom.setBounds(10, 250, 332, 126);
		getContentPane().add(dinningRoom);
		dinningRoom.setBackground(Color.YELLOW);
		dinningRoom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		kitchenn = new JPanel();
		kitchenn.setBounds(10, 376, 397, 147);
		getContentPane().add(kitchenn);
		kitchenn.setBackground(SystemColor.activeCaption);
		kitchenn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(658, 131, 59, 77);
		getContentPane().add(panel_6);
        
		button = new JButton("Refresh");
		button.setBounds(406, 77, 190, 23);
		button.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(button);
		button.setVisible(true);

		sensorPlanBackEnd = new PlanSensorBackEnd(this);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Sensors sensor  = new Sensors();
				System.out.println(sensor.toString());
				String serializedObject = Tools.serializeObject(sensor, sensor.getClass(), "");
				String jsRequest = Tools.serializeQuery(Queries.SELECT, Sensors.class, serializedObject, null);
				System.out.println(jsRequest);
				System.out.println("toto Boum");
				ClientServerConnection.callSocket();
				System.out.print("TOTOOOOO");

				try 
				{
					String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
					System.out.print("TOTOOOOO");
					System.out.print(answer);
					log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
					String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
					if(error.equals(""))
					{
						System.out.print("TOTO HELLO");
						List<Sensors> sensors = (List<Sensors>) Tools.deserializeObject(answer);
						System.out.print("TOTO HELLO5");
						System.out.println(sensors);



						for(int i = 0; i< sensors.size();i++)
						{
							System.out.print("TOTO HELLO10");

							switch(sensors.get(i).getState().toUpperCase())
							{

							case "FALSE":
								switch(sensors.get(i).getMode().toUpperCase())
								{
								case "ON":

									System.out.print("TOTO HELLO On");
									boutonSensor = new JButton (sensors.get(i).getMacAdress());
									boutonSensor.setBackground(Color.GREEN);
									boutonSensor.setVisible(true);
									
									switch(sensors.get(i).getLocation().toUpperCase().trim())
									{

									case "KITCHEN":

										kitchenn.add(boutonSensor);
										break;

									case "LIBRARY":

										libraryy.add(boutonSensor);
										break;

									case "LIVING ROOM":

										livingRoom.add(boutonSensor);
										break;

									case "DINNING ROOM":

										dinningRoom.add(boutonSensor);
										break;

									case "CORRIDOR1":

										corridorr1.add(boutonSensor);
										break;

									case "CORRIDOR2":

										corridorr2.add(boutonSensor);
										break;

									case "CORRIDOR3":

										corridorr3.add(boutonSensor);
										break;

									case "CORRIDOR4":

										corridorr4.add(boutonSensor);
										break;

									default :
										break;


									}
									break;
								case "OFF":


									boutonSensor = new JButton (sensors.get(i).getMacAdress());

									boutonSensor.setBackground(Color.GRAY); 
									boutonSensor.setVisible(true);
									System.out.print("TOTOHELLOOFF");
									System.out.print(sensors.get(i).getLocation().toUpperCase().trim());

									switch(sensors.get(i).getLocation().toUpperCase().trim())
									{
									case "KITCHEN":

										kitchenn.add(boutonSensor);
										break;

									case "LIBRARY":

										libraryy.add(boutonSensor);
										break;

									case "LIVING ROOM":

										System.out.print("BonneNuit");
										livingRoom.add(boutonSensor);
										//planSensor.getContentPane().add(boutonSensor);
										//planSensor.repaint();

										break;

									case "DINNING ROOM":

										dinningRoom.add(boutonSensor);
										break;

									case "CORRIDOR1":

										corridorr1.add(boutonSensor);
										break;

									case "CORRIDOR2":

										corridorr2.add(boutonSensor);
										break;

									case "CORRIDOR3":

										corridorr3.add(boutonSensor);
										break;

									case "CORRIDOR4":

										corridorr4.add(boutonSensor);
										break;

									default:
										System.out.print("Bonsoir");
										break;


									}break;
								default : 
									break;
								}


								break;
							default:
								boutonSensor = new JButton (sensors.get(i).getMacAdress());

								boutonSensor.setBackground(Color.RED); 
								boutonSensor.setVisible(true);
								System.out.print("TOTOHELLOOFF");
								System.out.print(sensors.get(i).getLocation().toUpperCase().trim());

								switch(sensors.get(i).getLocation().toUpperCase().trim())
								{
								case "KITCHEN":

									kitchenn.add(boutonSensor);
									break;

								case "LIBRARY":

									libraryy.add(boutonSensor);
									break;

								case "LIVING ROOM":

									System.out.print("BonneNuit");
									livingRoom.add(boutonSensor);
									//planSensor.getContentPane().add(boutonSensor);
									//planSensor.repaint();

									break;

								case "DINNING ROOM":

									dinningRoom.add(boutonSensor);
									break;

								case "CORRIDOR1":

									corridorr1.add(boutonSensor);
									break;

								case "CORRIDOR2":

									corridorr2.add(boutonSensor);
									break;

								case "CORRIDOR3":

									corridorr3.add(boutonSensor);
									break;

								case "CORRIDOR4":

									corridorr4.add(boutonSensor);
									break;

								default:
									System.out.print("Bonsoir");
									break;


								}
								break;
							}
						} 
					}
				}
				catch (IOException e1){
					log.error(e1.getMessage());
				}
				catch (AllConnectionUsedException usedConnection){
					log.error(usedConnection.getMessage());
				}


			}
		});
		
		//this.addWindowListener(sensorPlanBackEnd);
//		Sensors sensor  = new Sensors();
//		System.out.println(sensor.toString());
//		String serializedObject = Tools.serializeObject(sensor, sensor.getClass(), "");
//		String jsRequest = Tools.serializeQuery(Queries.SELECT, Sensors.class, serializedObject, null);
//		System.out.println(jsRequest);
//		System.out.println("toto Boum");
//		ClientServerConnection.callSocket();
//		System.out.print("TOTOOOOO");
//
//		try 
//		{
//			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
//			System.out.print("TOTOOOOO");
//			System.out.print(answer);
//			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
//			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
//			if(error.equals(""))
//			{
//				System.out.print("TOTO HELLO");
//				List<Sensors> sensors = (List<Sensors>) Tools.deserializeObject(answer);
//				System.out.print("TOTO HELLO5");
//				System.out.println(sensors);
//
//
//
//				for(int i = 0; i< sensors.size();i++)
//				{
//					System.out.print("TOTO HELLO10");
//
//					switch(sensors.get(i).getState().toUpperCase())
//					{
//
//					case "FALSE":
//						switch(sensors.get(i).getMode().toUpperCase())
//						{
//						case "ON":
//
//							System.out.print("TOTO HELLO On");
//							boutonSensor = new JButton (sensors.get(i).getMacAdress());
//							boutonSensor.setBackground(Color.GREEN);
//							boutonSensor.setVisible(true);
//
//							switch(sensors.get(i).getLocation().toUpperCase().trim())
//							{
//
//							case "KITCHEN":
//
//								kitchenn.add(boutonSensor);
//								break;
//
//							case "LIBRARY":
//
//								libraryy.add(boutonSensor);
//								break;
//
//							case "LIVING ROOM":
//
//								livingRoom.add(boutonSensor);
//								break;
//
//							case "DINNING ROOM":
//
//								dinningRoom.add(boutonSensor);
//								break;
//
//							case "CORRIDOR1":
//
//								corridorr1.add(boutonSensor);
//								break;
//
//							case "CORRIDOR2":
//
//								corridorr2.add(boutonSensor);
//								break;
//
//							case "CORRIDOR3":
//
//								corridorr3.add(boutonSensor);
//								break;
//
//							case "CORRIDOR4":
//
//								corridorr4.add(boutonSensor);
//								break;
//
//							default :
//								break;
//
//
//							}
//							break;
//						case "OFF":
//
//
//							boutonSensor = new JButton (sensors.get(i).getMacAdress());
//
//							boutonSensor.setBackground(Color.GRAY); 
//							boutonSensor.setVisible(true);
//							System.out.print("TOTOHELLOOFF");
//							System.out.print(sensors.get(i).getLocation().toUpperCase().trim());
//
//							switch(sensors.get(i).getLocation().toUpperCase().trim())
//							{
//							case "KITCHEN":
//
//								kitchenn.add(boutonSensor);
//								break;
//
//							case "LIBRARY":
//
//								libraryy.add(boutonSensor);
//								break;
//
//							case "LIVING ROOM":
//
//								System.out.print("BonneNuit");
//								livingRoom.add(boutonSensor);
//								//planSensor.getContentPane().add(boutonSensor);
//								//planSensor.repaint();
//
//								break;
//
//							case "DINNING ROOM":
//
//								dinningRoom.add(boutonSensor);
//								break;
//
//							case "CORRIDOR1":
//
//								corridorr1.add(boutonSensor);
//								break;
//
//							case "CORRIDOR2":
//
//								corridorr2.add(boutonSensor);
//								break;
//
//							case "CORRIDOR3":
//
//								corridorr3.add(boutonSensor);
//								break;
//
//							case "CORRIDOR4":
//
//								corridorr4.add(boutonSensor);
//								break;
//
//							default:
//								System.out.print("Bonsoir");
//								break;
//
//
//							}break;
//						default : 
//							break;
//						}
//
//
//						break;
//					default:
//						boutonSensor = new JButton (sensors.get(i).getMacAdress());
//
//						boutonSensor.setBackground(Color.RED); 
//						boutonSensor.setVisible(true);
//						System.out.print("TOTOHELLOOFF");
//						System.out.print(sensors.get(i).getLocation().toUpperCase().trim());
//
//						switch(sensors.get(i).getLocation().toUpperCase().trim())
//						{
//						case "KITCHEN":
//
//							kitchenn.add(boutonSensor);
//							break;
//
//						case "LIBRARY":
//
//							libraryy.add(boutonSensor);
//							break;
//
//						case "LIVING ROOM":
//
//							System.out.print("BonneNuit");
//							livingRoom.add(boutonSensor);
//							//planSensor.getContentPane().add(boutonSensor);
//							//planSensor.repaint();
//
//							break;
//
//						case "DINNING ROOM":
//
//							dinningRoom.add(boutonSensor);
//							break;
//
//						case "CORRIDOR1":
//
//							corridorr1.add(boutonSensor);
//							break;
//
//						case "CORRIDOR2":
//
//							corridorr2.add(boutonSensor);
//							break;
//
//						case "CORRIDOR3":
//
//							corridorr3.add(boutonSensor);
//							break;
//
//						case "CORRIDOR4":
//
//							corridorr4.add(boutonSensor);
//							break;
//
//						default:
//							System.out.print("Bonsoir");
//							break;
//
//
//						}
//						break;
//					}
//				} 
//			}
//		}
//		catch (IOException e1){
//			log.error(e1.getMessage());
//		}
//		catch (AllConnectionUsedException usedConnection){
//			log.error(usedConnection.getMessage());
//		}

		setVisible(true);
	}

	//	public void AddButtonavailable(String location)
	//	{
	//		if(location == living_room)
	//		{
	//			living_room2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == kitchen)
	//		{
	//			kitchen2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == dinning_Room )
	//		{
	//			dinning_Room2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == library )
	//		{
	//			library2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == corridor3)
	//		{
	//			corridor3_2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == corridor2)
	//		{
	//			coridor2_2.setBackground(Color.GRAY);
	//
	//		}
	//		if(location == corridor1)
	//		{
	//			corridor1_2.setBackground(Color.GRAY);
	//
	//		}
	//
	//	}
	//
	//
	//
	//	public void setButtonIs_Active(String location,String mode)
	//	{
	//		if(mode.toUpperCase() == "ON")
	//		{
	//			if(location == living_room)
	//			{
	//				living_room1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == kitchen)
	//			{
	//				kitchen1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == dinning_Room )
	//			{
	//				dinning_Room1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == library )
	//			{
	//				library1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == corridor3)
	//			{
	//				corridor3_1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == corridor2)
	//			{
	//				corridor2_1.setBackground(Color.GREEN);
	//
	//			}
	//			if(location == corridor1)
	//			{
	//				corridor1_1.setBackground(Color.GREEN);
	//
	//			}
	//		}
	//		else 
	//		{
	//			if(location == living_room)
	//			{
	//				living_room2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == kitchen)
	//			{
	//				kitchen2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == dinning_Room )
	//			{
	//				dinning_Room2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == library )
	//			{
	//				library2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == corridor3)
	//			{
	//				corridor3_2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == corridor2)
	//			{
	//				coridor2_2.setBackground(Color.GRAY);
	//
	//			}
	//			if(location == corridor1)
	//			{
	//				corridor1_2.setBackground(Color.GRAY);
	//
	//			}
	//		}
	//
	//	}

	public JButton getButonAdd()
	{
		return btnNewButton;
	}


	public JPanel getKitchenn() {
		return kitchenn;
	}
	public void setKitchenn(JPanel kitchenn) {
		this.kitchenn = kitchenn;
	}
	public JPanel getLibraryy() {
		return libraryy;
	}
	public void setLibraryy(JPanel libraryy) {
		this.libraryy = libraryy;
	}
	public JPanel getLivingRoom() {
		return livingRoom;
	}
	public void setLivingRoom(JPanel livingRoom) {
		this.livingRoom = livingRoom;
	}
	public JPanel getDinningRoom() {
		return dinningRoom;
	}
	public void setDinningRoom(JPanel dinningRoom) {
		this.dinningRoom = dinningRoom;
	}
	public JPanel getCorridorr1() {
		return corridorr1;
	}
	public void setCorridorr1(JPanel corridorr1) {
		this.corridorr1 = corridorr1;
	}
	public JPanel getCorridorr2() {
		return corridorr2;
	}
	public void setCorridorr2(JPanel corridorr2) {
		this.corridorr2 = corridorr2;
	}
	public JPanel getCorridorr3() {
		return corridorr3;
	}
	public void setCorridorr3(JPanel corridorr3) {
		this.corridorr3 = corridorr3;
	}
	public JPanel getCorridorr4() {
		return corridorr4;
	}
	public void setCorridorr4(JPanel corridorr4) {
		this.corridorr4 = corridorr4;
	}
	public JButton getButonAlerts() {
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowOpened(WindowEvent arg0) {

	}
}

