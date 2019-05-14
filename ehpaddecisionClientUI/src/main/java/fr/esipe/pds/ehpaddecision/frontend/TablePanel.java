package fr.esipe.pds.ehpaddecision.frontend;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;

public class TablePanel extends JPanel
{
	private JTable table;
	
	public TablePanel( TableModel model )
	{
		table = new JTable( model );
		JTextArea alertes = new JTextArea();
		alertes.setToolTipText("Descriptif des alertes");
		alertes.setBounds(256, 152, 130, 75);
		add(alertes);
		

		table.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {

				if(table.getSelectedRow() != -1 && table.getSelectedColumn() != -1) {
					String selData = table.getValueAt(table.getSelectedRow(),1).toString();
					
					System.out.println(selData);
					String sql ="select * from test where id = " +selData ;
					// String sql =" select * from test where id = '"+selData+"'";
					
					
						try {
							Connection connection = AlertPage.getConnection();
							Statement st = connection.createStatement();
							ResultSet rs = st.executeQuery(sql);
							
							while(rs.next()) {
							
							String id = rs.getString("id");
							String temperature = rs.getString("temperature");
							String heure = rs.getString("creation_date");
							System.out.println(id+temperature+heure);
							alertes.setText("identifiant: " +id+"\n"+"temperature:"+temperature+"\n"+"heure:"+heure);
								
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
				
				}
			}

			
		});

		setLayout( new BorderLayout() );
		add( new JScrollPane( table ), BorderLayout.CENTER );
	}



	public void update(TableModel model){

		table.setModel(model);
		//tableModel.getDataVector().elementAt(jTable.getSelectedRow());

	}
}
