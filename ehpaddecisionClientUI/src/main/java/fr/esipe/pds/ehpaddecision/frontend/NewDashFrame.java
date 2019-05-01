package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Choice;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class NewDashFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_5;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					NewDashFrame frame = new NewDashFrame();
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
	public NewDashFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("221px:grow"),
				ColumnSpec.decode("85px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("85px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("85px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),}));
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "1, 2, fill, default");
		
		JButton btnFiltreN_1 = new JButton("Filtrer votre recherche");
		panel.add(btnFiltreN_1, "2, 2, left, top");
		
		textField_5 = new JTextField();
		panel.add(textField_5, "4, 2, fill, default");
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox, BorderLayout.NORTH);
		
		table_1 = new JTable();
		panel_2.add(table_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Voir tous les capteurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("157px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("37px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("179px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		panel_3.add(btnNewButton, "2, 2, left, top");
		
		TextField textField = new TextField();
		panel_3.add(textField, "4, 2, default, top");
		
		Button button = new Button("Voir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel_3.add(button, "6, 2, left, top");
		
		JButton btnVoirToutesLes = new JButton("Voir toutes les alertes");
		panel_3.add(btnVoirToutesLes, "2, 4, default, top");
		
		TextField textField_1 = new TextField();
		panel_3.add(textField_1, "4, 4");
		
		Button button_1 = new Button("Voir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mettre ici l'appel request socket 
				// recupere l'objet liste , dans un variable global.
			}
		});
		panel_3.add(button_1, "6, 4");
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1, "2, 6");
		
		Button button_2 = new Button("Voir");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		TextField textField_2 = new TextField();
		panel_3.add(textField_2, "4, 6");
		panel_3.add(button_2, "6, 6");
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_3.add(btnNewButton_2, "2, 8");
		
		TextField textField_3 = new TextField();
		panel_3.add(textField_3, "4, 8");
		
		Button button_3 = new Button("Voir");
		panel_3.add(button_3, "6, 8");
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3, "2, 10");
		
		TextField textField_4 = new TextField();
		panel_3.add(textField_4, "4, 10");
		
		Button button_4 = new Button("Voir");
		panel_3.add(button_4, "6, 10");
		
		
	}

}
