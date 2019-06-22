package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import fr.esipe.pds.ehpaddecision.backend.AdminModel;
import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alert;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.TextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class AdminView extends JFrame {

	private JPanel ctpMain;
	private JTextField txtSensorCount;
	private JLabel lblNumber;
	private JLabel lblNewLabel;
	private JTextField txtAlertCount;
	private JTextField textUserCount;
	private JTextField txtLocationCount;
	private int sensorCmp = 0;
	private AdminModel adminModel;
	JComboBox alertCbx;
	JComboBox locationCbx;
	JComboBox sensorCbx;
	JComboBox floorCbx;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientServerConnection.callSocket();
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminView() {
		
		initCompenents(); 
		createEvents();
		
	}
/*	public void init(){
		initCalcSAlerts();
			}*/
	// creating events
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	
	// initializating compenents
	public void initCompenents() {
		///DView frame = new DView();
		//frame.setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminView.class.getResource("/fr/esipe/pds/ehpaddecision/frontend/images/admin.png")));
		setTitle("Dashboard GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 790, 412);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		lblNumber = new JLabel("Number of sensors");
		txtSensorCount = new JTextField();
		txtSensorCount.setEditable(false);
		txtSensorCount.setColumns(10);
	//	textField.setText(initCalcSAlerts());
		lblNewLabel = new JLabel("Number of alerts");
		txtAlertCount = new JTextField();
		txtAlertCount.setEditable(false);
		txtAlertCount.setColumns(10);
		alertCbx = new JComboBox();
		locationCbx = new JComboBox<>();
		sensorCbx = new JComboBox<>();
		floorCbx = new JComboBox<>();
		JLabel lblNumberOfSensors = new JLabel("Number of sensors ON ");
		
		JLabel lblNumberOfSensors_1 = new JLabel("Number of sensors OFF");
		
		JLabel lblNumberOfSensors_2 = new JLabel("Number of sensors in config");
		
		JLabel lblNumberOfPerson = new JLabel("Number of person");
		
		JLabel lblNumberOfLocations = new JLabel("Number of locations");
		
		JEditorPane dtrpnOn = new JEditorPane();
		dtrpnOn.setEditable(false);
		dtrpnOn.setEnabled(false);
		dtrpnOn.setBackground(Color.GREEN);
		dtrpnOn.setText("ON");
		dtrpnOn.setForeground(Color.GREEN);
		
		JEditorPane dtrpnOff = new JEditorPane();
		dtrpnOff.setEnabled(false);
		dtrpnOff.setEditable(false);
		dtrpnOff.setText("OFF");
		dtrpnOff.setForeground(Color.RED);
		dtrpnOff.setBackground(Color.RED);
		
		JEditorPane dtrpnConf = new JEditorPane();
		dtrpnConf.setEditable(false);
		dtrpnConf.setEnabled(false);
		dtrpnConf.setText("CF");
		dtrpnConf.setForeground(Color.DARK_GRAY);
		dtrpnConf.setBackground(Color.DARK_GRAY);
		
		JButton btnShowMore = new JButton("Show more");
		btnShowMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EhpadPage ehpad = new EhpadPage();
				ehpad.setVisible(true);
			}
		});
		btnShowMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EhpadPage ehpad = new EhpadPage();
				ehpad.setVisible(true);
			}
		});
		
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(new TitledBorder(null, "Advanced research", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnActualize = new JButton("Actualize");
		btnActualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnExport = new JButton("Export PDF");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textUserCount = new JTextField();
		textUserCount.setEditable(false);
		textUserCount.setColumns(10);
		
		txtLocationCount = new JTextField();
		txtLocationCount.setEditable(false);
		txtLocationCount.setColumns(10);
		
		JTextArea txtrSearch = new JTextArea();
		txtrSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		txtrSearch.setColumns(10);
		
		JLabel lblSensorOnCount = new JLabel("SensorOn");
		lblSensorOnCount.setBackground(new Color(255, 255, 255));
		
		JLabel lblSensorOffCount = new JLabel("SensOff");
		
		JLabel lblSensorConf = new JLabel("SensorConf");
		
		JPanel panelButton2 = new JPanel();
		panelButton2.setBorder(new TitledBorder(null, "Filtring More", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberOfPerson, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumberOfLocations, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumber)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtAlertCount, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addComponent(txtLocationCount, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addComponent(textUserCount, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
								.addComponent(txtSensorCount, 0, 0, Short.MAX_VALUE))
							.addGap(42)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addComponent(lblNumberOfSensors_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(dtrpnOff, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addComponent(lblNumberOfSensors, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(dtrpnOn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtrSearch, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNumberOfSensors_2))
									.addGap(18)
									.addComponent(dtrpnConf, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSensorOffCount)
								.addComponent(lblSensorOnCount)
								.addComponent(lblSensorConf))
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(btnShowMore)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnActualize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExport, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(panelBottom, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelButton2, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(btnActualize)
							.addGap(18)
							.addComponent(btnExport)
							.addGap(18)
							.addComponent(btnShowMore))
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSensorOnCount, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNumber)
									.addComponent(lblNumberOfSensors)
									.addComponent(txtSensorCount, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addComponent(dtrpnOn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSensorOffCount)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(lblNumberOfSensors_1)
										.addComponent(txtAlertCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(dtrpnOff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNumberOfSensors_2)
										.addComponent(lblNumberOfPerson)
										.addComponent(textUserCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_ctpMain.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
											.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNumberOfLocations)
												.addComponent(txtLocationCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_ctpMain.createSequentialGroup()
											.addGap(18)
											.addComponent(txtrSearch, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSensorConf)
										.addComponent(dtrpnConf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelButton2, 0, 0, Short.MAX_VALUE)
						.addComponent(panelBottom, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblTttt = new JLabel("By date");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		JLabel lblDate = new JLabel("Date");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Date"}));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_panelButton2 = new GroupLayout(panelButton2);
		gl_panelButton2.setHorizontalGroup(
			gl_panelButton2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelButton2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTttt)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panelButton2.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelButton2.createSequentialGroup()
					.addContainerGap(261, Short.MAX_VALUE)
					.addComponent(btnSearch))
		);
		gl_panelButton2.setVerticalGroup(
			gl_panelButton2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButton2.createSequentialGroup()
					.addComponent(lblTttt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelButton2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
		);
		panelButton2.setLayout(gl_panelButton2);
		
		
		alertCbx.setModel(new DefaultComboBoxModel(new String[] {"Fake Alerts", "Closed Alerts", "Acknowlegded Alerts"}));
		
		 
		locationCbx.setModel(new DefaultComboBoxModel(new String[] {"Living room", "Kitchen", "Dinning room","Library", "Corridor 1", "Corridor 2", "Corridor 3", "Corridor 4"}));
		
		JLabel lblLocation = new JLabel("Location");
		
		JLabel lblTypeAlert = new JLabel("Type Alert\r\n");
		
		sensorCbx.setModel(new DefaultComboBoxModel(new String[] {"Temperatures_Sensors", "Smoke_Sensors"}));
		JLabel lblTypeSensor = new JLabel("Type Sensor");
		
		JLabel lblFloor = new JLabel("Floor ");
		floorCbx.setModel(new DefaultComboBoxModel(new String[] {"Etage 1 ", "Etage 2"}));
		
		GroupLayout gl_panelBottom = new GroupLayout(panelBottom);
		gl_panelBottom.setHorizontalGroup(
			gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBottom.createSequentialGroup()
					.addGroup(gl_panelBottom.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeAlert, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocation, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTypeSensor, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFloor))
					.addGap(75)
					.addGroup(gl_panelBottom.createParallelGroup(Alignment.LEADING)
						.addComponent(floorCbx, 0, 144, Short.MAX_VALUE)
						.addComponent(sensorCbx, 0, 144, Short.MAX_VALUE)
						.addComponent(locationCbx, Alignment.TRAILING, 0, 144, Short.MAX_VALUE)
						.addComponent(alertCbx, 0, 144, Short.MAX_VALUE))
					.addGap(91))
		);
		gl_panelBottom.setVerticalGroup(
			gl_panelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBottom.createSequentialGroup()
					.addGroup(gl_panelBottom.createParallelGroup(Alignment.BASELINE)
						.addComponent(alertCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTypeAlert))
					.addGap(18)
					.addGroup(gl_panelBottom.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelBottom.createSequentialGroup()
							.addGroup(gl_panelBottom.createParallelGroup(Alignment.BASELINE)
								.addComponent(sensorCbx, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTypeSensor))
							.addGap(18)
							.addComponent(locationCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLocation))
					.addGap(18)
					.addGroup(gl_panelBottom.createParallelGroup(Alignment.BASELINE)
						.addComponent(floorCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFloor))
					.addContainerGap())
		);
		panelBottom.setLayout(gl_panelBottom);
		ctpMain.setLayout(gl_ctpMain);
		// TODO Auto-generated method stub
		// set model
		adminModel = new AdminModel();
		txtSensorCount.setText("" + adminModel.getNumberSensor());
		txtAlertCount.setText("" + adminModel.getNumberAlert());
		txtLocationCount.setText("" + adminModel.getNumberLocation());
		textUserCount.setText("" + adminModel.getNumberUser());
		lblSensorOffCount.setText("" + adminModel.getSensorOffCount());
		lblSensorOnCount.setText("" + adminModel.getSensorOnCount());
		lblSensorConf.setText("" + adminModel.getSensorConfCount());
		// alert
		ComboBoxModel<String> alertComboBoxModel = new DefaultComboBoxModel<>(new String[] {"Fake alert", "Closed alert","Acknowlegded Alerts"});
		alertCbx.setModel(alertComboBoxModel);
		
		// location
		ComboBoxModel<String> locationComboBoxModel = new  DefaultComboBoxModel<>(new String[] {"Living room", "Kitchen", "Dinning room","Library", "Corridor 1", "Corridor 2", "Corridor 3", "Corridor 4"});
		locationCbx.setModel(locationComboBoxModel);
		
		//sensor
		ComboBoxModel<String> sensorComboBoxModel = new  DefaultComboBoxModel<>(new String[] {"Temperature", "Smoke"});
		sensorCbx.setModel(sensorComboBoxModel);
		
		//floor 
		ComboBoxModel<String> floorComboBoxModel = new  DefaultComboBoxModel<>(new String[] {"Floor 1", "Floor 2"});
		floorCbx.setModel(floorComboBoxModel);
	}
	
	private String homePageSpell;
	private String pageOpeningSpell;
	private CardLayout cdLayout;
	private HomePageFront frontPage;
	public void showPage(String ehpadname) {
		// TODO Auto-generated method stub
		if(homePageSpell.equals(ehpadname)) frontPage.init();
		cdLayout.show(this.getContentPane(), ehpadname);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void getParams() {
		//String alertFilterValue = alertCbx.getSelectedItem()
	}
}
