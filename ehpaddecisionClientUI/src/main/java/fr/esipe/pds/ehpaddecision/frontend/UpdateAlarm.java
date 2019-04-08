package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class UpdateAlarm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAlarm frame = new UpdateAlarm();
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
	public UpdateAlarm() {
		setTitle("                                         UPDATE AN ALARM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 11, 212, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alarme \u00E0 modifier");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(57, 11, 108, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdentifiant.setBounds(10, 62, 62, 14);
		panel.add(lblIdentifiant);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblType.setBounds(10, 108, 46, 14);
		panel.add(lblType);
		
		JLabel lblCapteurAssoci = new JLabel("Capteur associ\u00E9");
		lblCapteurAssoci.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCapteurAssoci.setBounds(10, 153, 83, 14);
		panel.add(lblCapteurAssoci);
		
		textField = new JTextField();
		textField.setBounds(116, 59, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 105, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 150, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(215, 11, 219, 204);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modifications \u00E0 faire");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(45, 11, 115, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Identifiant");
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBounds(10, 62, 62, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Type");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBounds(10, 106, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Capteur associ\u00E9");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_2.setBounds(10, 151, 83, 14);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 59, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 103, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(123, 148, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnValider.setBounds(172, 227, 89, 23);
		contentPane.add(btnValider);
	}
}
