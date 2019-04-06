package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAlarm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAlarm frame = new DeleteAlarm();
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
	public DeleteAlarm() {
		setTitle("                                       DELETE AN ALARM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrezLidentifiantDe = new JLabel("Entrez l'identifiant de l'alarme que vous souhaitez effacer : ");
		lblEntrezLidentifiantDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEntrezLidentifiantDe.setBounds(54, 32, 314, 14);
		contentPane.add(lblEntrezLidentifiantDe);
		
		JLabel lblIdAlarme = new JLabel("Id Alarme");
		lblIdAlarme.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIdAlarme.setBounds(26, 86, 61, 14);
		contentPane.add(lblIdAlarme);
		
		textField = new JTextField();
		textField.setBounds(117, 83, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(168, 185, 89, 23);
		contentPane.add(btnNewButton);
	}

}
