package fr.esipe.pds.ehpaddecision.frontend;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alerts;
import fr.esipe.pds.ehpaddecision.principales.Locations;
import fr.esipe.pds.ehpaddecision.principales.Users;

public class HomePageFront extends JPanel {

	
/*
	private JPanel firstpanel = new JPanel(new FlowLayout());
	
	private JLabel labelName = new JLabel("name :");
	private JTextField textfName  = new JTextField(10);

	private JButton buttonNew     = new JButton("New ");
	private JButton buttonDelete  = new JButton("Delete");
	private JButton buttonUpdate  = new JButton("Update");
	private JButton buttonDisplay = new JButton("Display");
	
	private JTextArea textArea = new JTextArea();
	
	private JScrollPane scrollTextArea;
	private HomeBackEnd homebackend;
	private Font textAreaF;
	
	
	public HomePageFront()
	{
		setLayout(new BorderLayout());
		textAreaF = new Font("Calibri", Font.PLAIN, 25);
		homebackend = new HomeBackEnd(this);
		buttonNew.addActionListener(homebackend);
		buttonDisplay.addActionListener(homebackend);
		buttonDelete.addActionListener(homebackend);
		buttonUpdate.addActionListener(homebackend);
		firstpanel.add(labelName);
		firstpanel.add(textfName);
		firstpanel.add(buttonNew);
		firstpanel.add(buttonDelete);
		firstpanel.add(buttonUpdate);
		this.add(firstpanel, BorderLayout.NORTH);
		
		textArea.setEditable(false);
		textArea.setFont(textAreaF);
		scrollTextArea = new JScrollPane(textArea);
		scrollTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollTextArea, BorderLayout.CENTER);
		this.add(buttonDisplay, BorderLayout.SOUTH);
	}


	public JPanel getFirstpanel() {
		return firstpanel;
	}


	public void setFirstpanel(JPanel firstpanel) {
		this.firstpanel = firstpanel;
	}


	public JLabel getLabelName() {
		return labelName;
	}


	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}


	public JTextField getTextfName() {
		return textfName;
	}


	public void setTextfName(JTextField textfName) {
		this.textfName = textfName;
	}


	public JButton getButtonNew() {
		return buttonNew;
	}


	public void setButtonNew(JButton buttonNew) {
		this.buttonNew = buttonNew;
	}


	public JButton getButtonDelete() {
		return buttonDelete;
	}


	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}


	public JButton getButtonUpdate() {
		return buttonUpdate;
	}


	public void setButtonUpdate(JButton buttonUpdate) {
		this.buttonUpdate = buttonUpdate;
	}


	public JButton getButtonDisplay() {
		return buttonDisplay;
	}


	public void setButtonDisplay(JButton buttonDisplay) {
		this.buttonDisplay = buttonDisplay;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JScrollPane getScrollTextArea() {
		return scrollTextArea;
	}


	public void setScrollTextArea(JScrollPane scrollTextArea) {
		this.scrollTextArea = scrollTextArea;
	}


	public HomeBackEnd getHomebackend() {
		return homebackend;
	}


	public void setHomebackend(HomeBackEnd homebackend) {
		this.homebackend = homebackend;
	}


	public Font getTextAreaF() {
		return textAreaF;
	}


	public void setTextAreaF(Font textAreaF) {
		this.textAreaF = textAreaF;
	}
	
*/
	private static final  Logger log = LoggerFactory.getLogger(HomePageFront.class);
	private JPanel firstpanel = new JPanel(new CardLayout());
	
	public HomePageFront()
	{
		initComponents();
		started();
		setLayout(new BorderLayout());
		firstpanel.add(jTabbedPane1);
		this.add(firstpanel, BorderLayout.NORTH);

	}
	public void init(){
		Alerts();
		Users();
		Locations();
	}
	
	public JPanel getFirstpanel() {
		return firstpanel;
	}


	public void setFirstpanel(JPanel firstpanel) {
		this.firstpanel = firstpanel;
	}
	
    private void started(){
		dtm1=new DefaultTableModel();
		dtm1.addColumn("ID Alert");
		dtm1.addColumn("Name Alert");
		dtm1.addColumn("Date");
		tabNI.setModel(dtm1);
		dtm2=new DefaultTableModel();
		dtm2.addColumn("ID User");
		dtm2.addColumn("Name User");
		dtm2.addColumn("Date");
		tabSI.setModel(dtm2);
		dtm3=new DefaultTableModel();
		dtm3.addColumn("ID Location");
		dtm3.addColumn("Name Location");
		dtm3.addColumn("Date");
		tabSR.setModel(dtm3);
		dtm4=new DefaultTableModel();
		dtm4.addColumn("ID Capture");
		dtm4.addColumn("Name Capture");
		dtm4.addColumn("Date");
		tabCA.setModel(dtm4);
    }
    
    public void viderTable(DefaultTableModel d){
        for(int i = d.getRowCount(); i > 0; --i)
            d.removeRow(i-1);
    }
    
    @SuppressWarnings("unchecked")
    public void Alerts(){
    	viderTable(dtm1);
    	Alerts Alert = new Alerts ();
		String serializedObject = Tools.serializeObject(Alert, Alert.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);
		
		try 
		{
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				List<Alerts> alerts = (List<Alerts>) Tools.deserializeObject(answer);
				jTabbedPane1.setTitleAt(0,alerts.size()+" Alerts" );
				for(Alerts alert : alerts)
				{
					
					id_alert=alert.getIdAlert();
		            name_alert=alert.getNameAlert();
		            date_alert=alert.getCreationDate()+"";
		            Object[] rowData={id_alert,name_alert,date_alert};
		            dtm1.addRow(rowData);
				}
				tabNI.setModel(dtm1);
			}
			else {
				JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} 
		catch (IOException e1){
			log.error(e1.getMessage());
		} 
		catch (AllConnectionUsedException usedConnection){
			log.error(usedConnection.getMessage());
		}   
    }
    @SuppressWarnings("unchecked")
    public void Users(){
    	viderTable(dtm2);
    	Users User = new Users ();
		String serializedObject = Tools.serializeObject(User, User.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Users.class, serializedObject,null);
		
		try 
		{
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				List<Users> users = (List<Users>) Tools.deserializeObject(answer);
				jTabbedPane1.setTitleAt(1,users.size()+" Users" );
				for(Users user : users)
				{
					
					id_user=user.getIdUser();
		            name_user=user.getNameUser();
		            date_user=user.getDateCreation()+"";
		            Object[] rowData={id_user,name_user,date_user};
		            dtm2.addRow(rowData);
				}
				tabSI.setModel(dtm2);
			}
			else {
				JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} 
		catch (IOException e1){
			log.error(e1.getMessage());
		} 
		catch (AllConnectionUsedException usedConnection){
			log.error(usedConnection.getMessage());
		}   
    }
    
    @SuppressWarnings("unchecked")
    public void Locations(){
    	viderTable(dtm3);
    	
    	Locations Location = new Locations ();
	    String serializedObject = Tools.serializeObject(Location, Location.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Locations.class, serializedObject,null);
		System.out.println(serializedObject);
		System.out.println(jsRequest);
		try 
		{
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				List<Locations> locations = (List<Locations>) Tools.deserializeObject(answer);
				jTabbedPane1.setTitleAt(2,locations.size()+" Locations" );
				for(Locations location : locations)
				{
					id_location=location.getIdLocation();
		            name_location=location.getNameLocation();
		            date_location=location.getDateCreation()+"";
		            Object[] rowData={id_location,name_location,date_location};
		            dtm3.addRow(rowData);
				}
				tabSR.setModel(dtm3);
			}
			else {
				JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} 
		catch (IOException e1){
			log.error(e1.getMessage());
		} 
		catch (AllConnectionUsedException usedConnection){
			log.error(usedConnection.getMessage());
		}      
    }     
       
    
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        
        NIpnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabNI = new javax.swing.JTable();
        
        SIpnl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabSI = new javax.swing.JTable();
        
        SRpnl = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabSR = new javax.swing.JTable();
        
        CApnl = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabCA = new javax.swing.JTable();
        
        
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        // Alerts 
        // start edit
        NIpnl.setName("NIpnl"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabNI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabNI.setName("tabNI"); // NOI18N
      
        jScrollPane1.setViewportView(tabNI);

        javax.swing.GroupLayout NIpnlLayout = new javax.swing.GroupLayout(NIpnl);
        NIpnl.setLayout(NIpnlLayout);
        NIpnlLayout.setHorizontalGroup(
            NIpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NIpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        NIpnlLayout.setVerticalGroup(
            NIpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NIpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Alerts", NIpnl);

        // Users
        // start Edit
        SIpnl.setName("SIpnl"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tabSI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabSI.setName("tabSI"); // NOI18N
        jScrollPane2.setViewportView(tabSI);

        javax.swing.GroupLayout SIpnlLayout = new javax.swing.GroupLayout(SIpnl);
        SIpnl.setLayout(SIpnlLayout);
        SIpnlLayout.setHorizontalGroup(
            SIpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        SIpnlLayout.setVerticalGroup(
            SIpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SIpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", SIpnl);

        // Location
        // start Edit
        SRpnl.setName("SRpnl"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        tabSR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabSR.setName("tabSR"); // NOI18N
        jScrollPane4.setViewportView(tabSR);

        javax.swing.GroupLayout SRpnlLayout = new javax.swing.GroupLayout(SRpnl);
        SRpnl.setLayout(SRpnlLayout);
        SRpnlLayout.setHorizontalGroup(
            SRpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SRpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        SRpnlLayout.setVerticalGroup(
            SRpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SRpnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        jTabbedPane1.addTab("Locations", SRpnl);
        
        // Capture
        // start Edit
        CApnl.setName("CApnl"); // NOI18N

        jScrollPane4.setName("jScrollPane3"); // NOI18N

        tabCA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabCA.setName("tabCA"); // NOI18N
        jScrollPane3.setViewportView(tabCA);

        javax.swing.GroupLayout CApnlLayout = new javax.swing.GroupLayout(CApnl);
        CApnl.setLayout(CApnlLayout);
        CApnlLayout.setHorizontalGroup(
            CApnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CApnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        CApnlLayout.setVerticalGroup(
            CApnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CApnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        jTabbedPane1.addTab("Captures", CApnl);
        
    }                       



	private DefaultTableModel dtm1;
    private DefaultTableModel dtm2;
    private DefaultTableModel dtm3;
    private DefaultTableModel dtm4;
    
    private int id_user,id_alert,id_location,id_capture,num_captures,num_users,num_locations,num_alerts;
    private String name_user,name_alert,name_location,name_capture,date_capture,date_user,date_alert,date_location;
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel NIpnl;
    private javax.swing.JPanel SIpnl;
    private javax.swing.JPanel SRpnl;
    private javax.swing.JPanel CApnl;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    
    private javax.swing.JTabbedPane jTabbedPane1;
    
    private javax.swing.JTable tabNI;
    private javax.swing.JTable tabSI;
    private javax.swing.JTable tabSR;
    private javax.swing.JTable tabCA;
    // End of variables declaration  

}
