package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class InsertAlarm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertAlarm frame = new InsertAlarm();
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
	public InsertAlarm() {
		setForeground(SystemColor.textHighlight);
		setTitle("                                          INSERT AN ALARM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setToolTipText("ALARM INSERT");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remplir les champs suivants pour cr\u00E9er une alarme : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(74, 25, 297, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdentifiant.setBounds(27, 68, 70, 14);
		contentPane.add(lblIdentifiant);
		
		JLabel lblTypeDalarme = new JLabel("Type d'alarme");
		lblTypeDalarme.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTypeDalarme.setBounds(27, 103, 85, 14);
		contentPane.add(lblTypeDalarme);
		
		JLabel lblCapteurAssoci = new JLabel("Capteur associ\u00E9");
		lblCapteurAssoci.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCapteurAssoci.setBounds(27, 138, 99, 14);
		contentPane.add(lblCapteurAssoci);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnValider.setBounds(170, 201, 89, 23);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setBounds(170, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 100, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 135, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
