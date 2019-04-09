package client;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;

public class Alarmpage extends JFrame {

	private JPanel contentPane;
	private InsertAlarm insert = new InsertAlarm();
	private Display display = new Display();
	private DeleteAlarm delete = new DeleteAlarm();
	private UpdateAlarm update = new UpdateAlarm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alarmpage frame = new Alarmpage();
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
	public Alarmpage() {
		setTitle("DECISION - ALARMS");
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e4) {
				display.setVisible(true);
			}
		});

		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(309, 86, 89, 23);
		panel.add(btnInsert);
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e4) {
				insert.setVisible(true);
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(309, 120, 89, 23);
		panel.add(btnDelete);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e4) {
				delete.setVisible(true);
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(309, 154, 89, 23);
		panel.add(btnUpdate);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e4) {
				update.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("Alarms");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(83, 36, 53, 14);
		panel.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Alarm 1");
		btnNewButton_1.setBounds(64, 52, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnAlarm = new JButton("Alarm 2");
		btnAlarm.setBounds(64, 86, 89, 23);
		panel.add(btnAlarm);

		JButton btnAlarm_1 = new JButton("Alarm 3");
		btnAlarm_1.setBounds(64, 120, 89, 23);
		panel.add(btnAlarm_1);

		JButton btnAlarm_2 = new JButton("Alarm 4");
		btnAlarm_2.setBounds(64, 154, 89, 23);
		panel.add(btnAlarm_2);

		JButton btnAlarm_3 = new JButton("Alarm 5");
		btnAlarm_3.setBounds(64, 189, 89, 23);
		panel.add(btnAlarm_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Alarmpage.class.getResource("/client/iot.jpg")));
		lblNewLabel_1.setBounds(0, 0, 424, 251);
		panel.add(lblNewLabel_1);
	}
}
