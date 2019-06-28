package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

import fr.esipe.pds.ehpaddecision.backend.Connection123;
import fr.esipe.pds.ehpaddecision.backend.Sensor_Backend;
import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class SensorsFront1 extends JPanel implements ActionListener{
	private static final  Logger log = LoggerFactory.getLogger(SensorsFront1.class);

	private JFrame frame;
	private static JTextField User_Name_Field;
	private static JTextField User_firstName_Field;
	private static JTextField Temp_Min_Field;
	private static JTextField Temp_Max_Field;
	private static JTextField PPM_Field;
	private static JTextField MacAdressTextField;

	JLabel lblNewLabel_1;
	JLabel lblTempmax;
	static JComboBox comboBox;
	static JRadioButton rdbtnNewRadioButton ;
	static JRadioButton rdbtnNewRadioButton_1;
	static JButton btnSubmit1;
	static JButton btnBack; 
	JLabel lblSeuildioxidecarbone;
	private Sensor_Backend sensor_backend;
	private EhpadPage ehpadPage;
	public static DefaultListModel temperatures = new DefaultListModel();
	private JList list_1;
	private JList list_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorsFront1 window = new SensorsFront1();
					window.frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public SensorsFront1() throws SQLException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sensor_backend = new Sensor_Backend(this);


		frame = new JFrame("Configuration");
		frame.setBounds(100, 100, 670, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(sensor_backend);

		User_Name_Field = new JTextField();
		User_Name_Field.setBounds(514, 36, 130, 20);
		frame.getContentPane().add(User_Name_Field);
		User_Name_Field.setColumns(10);

		JLabel lblAdresseMac = new JLabel("User_Name");
		lblAdresseMac.setBounds(514, 11, 130, 14);
		frame.getContentPane().add(lblAdresseMac);

		User_firstName_Field = new JTextField();
		User_firstName_Field.setBounds(514, 84, 130, 20);
		frame.getContentPane().add(User_firstName_Field);
		User_firstName_Field.setColumns(10);

		JLabel lblNewLabel = new JLabel("User_firstName");
		lblNewLabel.setBounds(514, 59, 130, 14);
		frame.getContentPane().add(lblNewLabel);

		JList list = new JList();
		list.setBounds(294, 155, 100, -14);
		frame.getContentPane().add(list);

		btnSubmit1 = new JButton("Submit");btnSubmit1.addActionListener(this);
		btnSubmit1.setBounds(514, 548, 130, 57);
		frame.getContentPane().add(btnSubmit1);
		btnSubmit1.addActionListener(sensor_backend);

		Temp_Min_Field = new JTextField();
		Temp_Min_Field.setBounds(10, 36, 130, 20);
		frame.getContentPane().add(Temp_Min_Field);
		Temp_Min_Field.setColumns(10);
		Temp_Min_Field.setVisible(false);

		lblNewLabel_1 = new JLabel("Temp_Min");
		lblNewLabel_1.setBounds(10, 11, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		lblTempmax = new JLabel("Temp_Max");
		lblTempmax.setBounds(10, 67, 130, 14);
		frame.getContentPane().add(lblTempmax);
		lblTempmax.setVisible(false);

		Temp_Max_Field = new JTextField();
		Temp_Max_Field.setBounds(10, 84, 130, 20);
		frame.getContentPane().add(Temp_Max_Field);
		Temp_Max_Field.setColumns(10);
		Temp_Max_Field.setVisible(false);

		lblSeuildioxidecarbone = new JLabel("Seuil_DioxideCarbone");
		lblSeuildioxidecarbone.setBounds(10, 115, 150, 14);
		lblSeuildioxidecarbone.setVisible(false);

		MacAdressTextField = new JTextField();
		MacAdressTextField.setBounds(180, 36, 130, 20);
		frame.getContentPane().add(MacAdressTextField);
		MacAdressTextField.setColumns(10);
		frame.getContentPane().add(lblSeuildioxidecarbone);



		PPM_Field = new JTextField();
		PPM_Field.setBounds(10, 140, 150, 20);
		frame.getContentPane().add(PPM_Field);
		PPM_Field.setColumns(10);
		PPM_Field.setVisible(false);

		rdbtnNewRadioButton = new JRadioButton("Smoke_Sensors");rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setBounds(494, 139, 130, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Temperature_Sensors");rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_1.setBounds(494, 174, 150, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JLabel lblMacadress = new JLabel("Temperatures_Sensors_List");
		lblMacadress.setBounds(10, 235, 200, 14);
		frame.getContentPane().add(lblMacadress);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 548, 130, 57);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						frame.dispose();
						SensorPlan sensorPlan = new SensorPlan(2);
						sensorPlan.frame.setVisible(true);
						
					}
			
				});

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"off", "on"}));
		comboBox.setBounds(10, 203, 130, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 178, 130, 14);
		frame.getContentPane().add(lblState);

		list_1 = new JList();
		list_1.setBounds(354, 260, 290, 277);
		frame.getContentPane().add(list_1);
		list_1.setVisibleRowCount(-1);




		list_2 = new JList(temperatures);
		list_2.setBounds(10, 260, 290, 277);
		frame.getContentPane().add(list_2);
		list_2.setVisibleRowCount(-1);


		JLabel lblSmokesensorslist = new JLabel("Smoke_Sensors_List");
		lblSmokesensorslist.setBounds(354, 235, 290, 14);
		frame.getContentPane().add(lblSmokesensorslist);

		JLabel lblMacadress_1 = new JLabel("MacAdress");
		lblMacadress_1.setBounds(180, 11, 130, 14);
		frame.getContentPane().add(lblMacadress_1);
	}



	public JFrame getFrame() {
		return this.frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static JTextField getUser_Name_Field() {
		return User_Name_Field;
	}

	public static void setUser_Name_Field(JTextField user_Name_Field) {
		User_Name_Field = user_Name_Field;
	}

	public static JTextField getUser_firstName_Field() {
		return User_firstName_Field;
	}

	public static void setUser_firstName_Field(JTextField user_firstName_Field) {
		User_firstName_Field = user_firstName_Field;
	}

	public static JTextField getTemp_Min_Field() {
		return Temp_Min_Field;
	}

	public static void setTemp_Min_Field(JTextField temp_Min_Field) {
		Temp_Min_Field = temp_Min_Field;
	}

	public static JTextField getTemp_Max_Field() {
		return Temp_Max_Field;
	}

	public void setTemp_Max_Field(JTextField temp_Max_Field) {
		Temp_Max_Field = temp_Max_Field;
	}

	public static JTextField getPPM_Field() {
		return PPM_Field;
	}

	public void setPPM_Field(JTextField pPM_Field) {
		PPM_Field = pPM_Field;
	}

	public static JTextField getMacAdressTextField() {
		return MacAdressTextField;
	}

	public void setMacAdressTextField(JTextField macAdressTextField) {
		MacAdressTextField = macAdressTextField;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblTempmax() {
		return lblTempmax;
	}

	public void setLblTempmax(JLabel lblTempmax) {
		this.lblTempmax = lblTempmax;
	}

	public static JComboBox getComboBox() {
		return comboBox;
	}

	public static void setComboBox(JComboBox comboBox) {
		SensorsFront1.comboBox = comboBox;
	}

	public static JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	public static void setRdbtnNewRadioButton(JRadioButton rdbtnNewRadioButton) {
		SensorsFront1.rdbtnNewRadioButton = rdbtnNewRadioButton;
	}

	public static JRadioButton getRdbtnNewRadioButton_1() {
		return rdbtnNewRadioButton_1;
	}

	public static void setRdbtnNewRadioButton_1(JRadioButton rdbtnNewRadioButton_1) {
		SensorsFront1.rdbtnNewRadioButton_1 = rdbtnNewRadioButton_1;
	}

	public static JButton getBtnSubmit1() {
		return btnSubmit1;
	}

	public static void setBtnSubmit1(JButton btnSubmit1) {
		SensorsFront1.btnSubmit1 = btnSubmit1;
	}

	public JLabel getLblSeuildioxidecarbone() {
		return lblSeuildioxidecarbone;
	}

	public void setLblSeuildioxidecarbone(JLabel lblSeuildioxidecarbone) {
		this.lblSeuildioxidecarbone = lblSeuildioxidecarbone;
	}

	public Sensor_Backend getSensor_backend() {
		return sensor_backend;
	}

	public void setSensor_backend(Sensor_Backend sensor_backend) {
		this.sensor_backend = sensor_backend;
	}

	public EhpadPage getEhpadPage() {
		return ehpadPage;
	}

	public void setEhpadPage(EhpadPage ehpadPage) {
		this.ehpadPage = ehpadPage;
	}

	public JList getList_1() {
		return list_1;
	}

	public void setList_1(JList list_1) {
		this.list_1 = list_1;
	}

	public JList getList_2() {
		return list_2;
	}

	public void setList_2(JList list_2) {
		this.list_2 = list_2;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rdbtnNewRadioButton){
			PPM_Field.setVisible(true);
			lblSeuildioxidecarbone.setVisible(true);
			lblNewLabel_1.setVisible(false);
			lblTempmax.setVisible(false);
			Temp_Min_Field.setVisible(false);
			Temp_Max_Field.setVisible(false);
		}

		if(e.getSource() == rdbtnNewRadioButton_1){
			Temp_Min_Field.setVisible(true);
			Temp_Max_Field.setVisible(true);
			PPM_Field.setVisible(false);
			lblSeuildioxidecarbone.setVisible(false);
			lblNewLabel_1.setVisible(true);
			lblTempmax.setVisible(true);


		}

		if(e.getSource()== btnBack) {

			System.out.println("action button Back");
			frame.setVisible(false);

		}

		if(e.getSource() == btnSubmit1){

			System.out.print(User_Name_Field.getText());
			System.out.print(User_firstName_Field.getText());
		}


	}

}