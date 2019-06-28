//package fr.esipe.pds.ehpaddecision.frontend;
//
//
//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JToggleButton;
//import java.awt.BorderLayout;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import java.awt.Color;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class DeleteSensor implements ActionListener{
//
//	public JFrame frame;
//	private JTextField textField;
//	JButton btnBack;
//	JButton btnNewButton;
//	
//	
//	/**
//	 * Launch the application.
//	 */
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DeleteSensor window = new DeleteSensor();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public DeleteSensor() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.getContentPane().setBackground(Color.ORANGE);
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		textField = new JTextField();
//		textField.setBounds(112, 69, 259, 20);
//		frame.getContentPane().add(textField);
//		textField.setColumns(10);
//		
//		JLabel lblNewLabel = new JLabel("Mac adress");
//		lblNewLabel.setBounds(29, 72, 73, 14);
//		frame.getContentPane().add(lblNewLabel);
//		
//	    btnNewButton = new JButton("Delete the sensor\r\n");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBackground(Color.LIGHT_GRAY);
//		btnNewButton.setForeground(Color.BLACK);
//		btnNewButton.setBounds(160, 131, 170, 53);
//		frame.getContentPane().add(btnNewButton);
//		
//	    btnBack = new JButton("BACK");
//		btnBack.setBackground(Color.LIGHT_GRAY);
//		btnBack.setBounds(13, 219, 96, 31);
//		frame.getContentPane().add(btnBack);
//		frame.setVisible(true);
//	}
//	
//	@Override
//	
//	public void actionPerformed(ActionEvent ev) {
//		
//		if(ev.getSource()== btnBack)
//			
//		{	
//		   SensorPlan instance = new SensorPlan();
//		   instance.begin();
//		   instance.frame.setVisible(true);
//		   	
//		}
//		
//	}
//}
//
