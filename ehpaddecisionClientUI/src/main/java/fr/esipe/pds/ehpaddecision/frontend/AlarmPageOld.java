package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;

public class AlarmPageOld extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlarmPageOld frame = new AlarmPageOld();
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
	public AlarmPageOld() {
		setTitle("DECISION - ALERTS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.setBounds(309, 52, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(309, 86, 89, 23);
		panel.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(309, 120, 89, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(309, 154, 89, 23);
		panel.add(btnUpdate);
		
		textField = new JTextField();
		textField.setBounds(23, 52, 180, 137);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Alarms");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(83, 36, 53, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		// to 
		//lblNewLabel_1.setIcon(new ImageIcon(AlarmPage.class.getResource("/fr/pds/ehpaddecision/frontend/images/iot.jpg")));
		lblNewLabel_1.setBounds(0, 0, 424, 251);
		panel.add(lblNewLabel_1);
	}
}

