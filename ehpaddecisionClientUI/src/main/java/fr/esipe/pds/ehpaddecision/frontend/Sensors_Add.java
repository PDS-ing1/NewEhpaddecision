package fr.esipe.pds.ehpaddecision.frontend;
import fr.esipe.pds.ehpaddecision.backend.EhpadBackEnd;
import fr.esipe.pds.ehpaddecision.backend.HomeBackEnd;
import fr.esipe.pds.ehpaddecision.backend.OpeningBackEnd;
import fr.esipe.pds.ehpaddecision.backend.Sensor_Backend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JTextField;

import org.apache.log4j.helpers.LogLog;
import org.slf4j.LoggerFactory;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Sensors_Add extends JPanel implements ActionListener{

	private JFrame frame;
	public JLabel getLblMacadress() {
		return lblMacadress;
	}

	public static JTextField textField = new JTextField();
	public static JButton btnSubmit;
	public JLabel lblMacadress;
	public JLabel lblBrand;
	public static JComboBox comboBox;
	public JLabel lblNewLabel;
	public static JComboBox comboBox_1;
	public JLabel lblType;
	public static JComboBox comboBox_2;
	public JButton btnBack;
	private HomeBackEnd homebackend;
	private Sensor_Backend sensor_backend;
	private EhpadPage ehpadPage;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {


				try {

					Sensors_Add window = new Sensors_Add();
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
	public Sensors_Add() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//homebackend = new HomeBackEnd(this);
		sensor_backend = new Sensor_Backend(this);
		
		frame = new JFrame("Add_Sensors");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblMacadress = new JLabel("Mac_adress");
		lblMacadress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblMacadress.setBounds(10, 11, 80, 14);
		frame.getContentPane().add(lblMacadress);

		textField = new JTextField();
		textField.setBounds(244, 9, 180, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblBrand.setBounds(10, 50, 80, 14);
		frame.getContentPane().add(lblBrand);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"X-Sense", "Nest Protect", "Fire Angel", "Heiman", "Jalo Helsinki", "AngelEye", "Cavius", "Siemens"}));
		comboBox.setBounds(244, 40, 180, 20);
		frame.getContentPane().add(comboBox);

		lblNewLabel = new JLabel("Location");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 85, 80, 14);
		frame.getContentPane().add(lblNewLabel);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Living room", "Kitchen", "Dinning Room", "Library", "Corridor1", "Corridor2", "Corridor3", "Corridor4"}));
		comboBox_1.setBounds(244, 83, 180, 20);
		frame.getContentPane().add(comboBox_1);

		lblType = new JLabel("Type");
		lblType.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblType.setBounds(10, 120, 80, 14);
		frame.getContentPane().add(lblType);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Temperatures_Sensors", "Smoke_Sensors"}));
		comboBox_2.setBounds(244, 118, 180, 20);
		frame.getContentPane().add(comboBox_2);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 183, 116, 65);
		frame.getContentPane().add(btnBack);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(308, 183, 116, 65);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(sensor_backend);
		
		/*{
			public void actionPerformed(ActionEvent ae) {
				System.out.println("action button Submit");

				String macAdress2 = textField.getText();  
				// String code = codeVille.getText();

				try{
					String macAdress1 = textField.getText(); 
					Statement state = SdzConnection.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					PreparedStatement test = SdzConnection.test(macAdress1);

					//state.executeUpdate("INSERT INTO sensor"+ "VALUES (1,"+macAdress+",'allumé')");
					JOptionPane.showMessageDialog(null, "requete exécuté avec succès");

					textField.setText("");
					//codeVille.setText("");




				}

				catch(SQLException ex ){

					System.out.println(ex);


				}
			}


			});*/
		};





	public static JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
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
	public void setLblMacadress(JLabel lblMacadress) {
		this.lblMacadress = lblMacadress;
	}

	public JLabel getLblBrand() {
		return lblBrand;
	}

	public void setLblBrand(JLabel lblBrand) {
		this.lblBrand = lblBrand;
	}

	public static JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public static JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public static JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
