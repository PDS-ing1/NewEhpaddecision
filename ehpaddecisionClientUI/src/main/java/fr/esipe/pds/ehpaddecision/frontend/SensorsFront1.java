package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

import fr.esipe.pds.ehpaddecision.backend.Sensor_Backend;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class SensorsFront1 extends JPanel implements ActionListener{

	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblNewLabel_1;
	JLabel lblTempmax;
	static JComboBox comboBox;
	JRadioButton rdbtnNewRadioButton ;
	static JRadioButton rdbtnNewRadioButton_1;
	static JButton btnSubmit1;
	JLabel lblSeuildioxidecarbone;
	private Sensor_Backend sensor_backend;
	private EhpadPage ehpadPage;
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
	 */
	public SensorsFront1() {
		initialize();
		windowOppened(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sensor_backend = new Sensor_Backend(this);
		
		
		frame = new JFrame("Configuration");
		frame.setBounds(100, 100, 550, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(378, 36, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblAdresseMac = new JLabel("User_Name");
		lblAdresseMac.setBounds(378, 11, 130, 14);
		frame.getContentPane().add(lblAdresseMac);

		textField_1 = new JTextField();
		textField_1.setBounds(378, 84, 130, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("User_firstName");
		lblNewLabel.setBounds(378, 59, 130, 14);
		frame.getContentPane().add(lblNewLabel);

		JList list = new JList();
		list.setBounds(294, 155, 100, -14);
		frame.getContentPane().add(list);

		btnSubmit1 = new JButton("Submit");btnSubmit1.addActionListener(this);
		btnSubmit1.setBounds(394, 368, 130, 57);
		frame.getContentPane().add(btnSubmit1);
		btnSubmit1.addActionListener(sensor_backend);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 36, 130, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);

		lblNewLabel_1 = new JLabel("Temp_Min");
		lblNewLabel_1.setBounds(10, 11, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		lblTempmax = new JLabel("Temp_Max");
		lblTempmax.setBounds(10, 67, 130, 14);
		frame.getContentPane().add(lblTempmax);
		lblTempmax.setVisible(false);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 84, 130, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);

		lblSeuildioxidecarbone = new JLabel("Seuil_DioxideCarbone");
		lblSeuildioxidecarbone.setBounds(10, 115, 150, 14);
		lblSeuildioxidecarbone.setVisible(false);
		frame.getContentPane().add(lblSeuildioxidecarbone);
		
		

		textField_4 = new JTextField();
		textField_4.setBounds(10, 140, 150, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);

		rdbtnNewRadioButton = new JRadioButton("Smoke_Sensors");rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setBounds(378, 111, 130, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Temperature_Sensors");rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_1.setBounds(378, 148, 150, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblMacadress = new JLabel("Temperatures_Sensors_List");
		lblMacadress.setBounds(10, 235, 200, 14);
		frame.getContentPane().add(lblMacadress);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 368, 130, 57);
		frame.getContentPane().add(btnBack);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"off", "on"}));
		comboBox.setBounds(10, 203, 130, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 178, 130, 14);
		frame.getContentPane().add(lblState);
		
		list_1 = new JList();
		list_1.setBounds(264, 260, 260, 97);
		frame.getContentPane().add(list_1);
		list_1.setVisibleRowCount(-1);
		
		
		
		
		list_2 = new JList();
		list_2.setBounds(10, 260, 244, 97);
		frame.getContentPane().add(list_2);
		list_2.setVisibleRowCount(-1);
		
		
		JLabel lblSmokesensorslist = new JLabel("Smoke_Sensors_List");
		lblSmokesensorslist.setBounds(264, 235, 200, 14);
		frame.getContentPane().add(lblSmokesensorslist);
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

	public static JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public static JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public static JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
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

	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	public void setRdbtnNewRadioButton(JRadioButton rdbtnNewRadioButton) {
		this.rdbtnNewRadioButton = rdbtnNewRadioButton;
	}

	public static JRadioButton getRdbtnNewRadioButton_1() {
		return rdbtnNewRadioButton_1;
	}

	public void setRdbtnNewRadioButton_1(JRadioButton rdbtnNewRadioButton_1) {
		this.rdbtnNewRadioButton_1 = rdbtnNewRadioButton_1;
	}

	public static JButton getBtnSubmit1() {
		return btnSubmit1;
	}

	public void setBtnSubmit1(JButton btnSubmit1) {
		this.btnSubmit1 = btnSubmit1;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rdbtnNewRadioButton){
			textField_4.setVisible(true);
			lblSeuildioxidecarbone.setVisible(true);
			textField_2.setVisible(false);
			textField_3.setVisible(false);
		}
		
		if(e.getSource() == rdbtnNewRadioButton_1){
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(false);
			lblSeuildioxidecarbone.setVisible(false);
			lblNewLabel_1.setVisible(true);
			lblTempmax.setVisible(true);
			
			
		}
		
		if(e.getSource() == btnSubmit1){
			
			System.out.print(textField.getText());
			System.out.print(textField_1.getText());
		}
		

	}
	
	public void windowOppened(java.awt.event.WindowEvent e) {

		try {
			ClientServerConnection.callSocket();
			System.out.print("TOT89");



		} catch(Exception ex){
			System.out.println(ex.getMessage());

		}
	}
	
	
}
