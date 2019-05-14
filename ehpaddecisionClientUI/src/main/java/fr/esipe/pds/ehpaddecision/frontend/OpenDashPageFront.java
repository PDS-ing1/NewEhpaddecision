package fr.esipe.pds.ehpaddecision.frontend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class OpenDashPageFront extends javax.swing.JFrame {

	// for the new code 
	
	 jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
   
    jLabel11 = new javax.swing.JLabel();
    txt_rech = new javax.swing.JTextField();
  
    com_rech = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
   
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    //until here

   /* 
       
    
    public OpenDashPageFront() {        
        initComponents();
        
       
    }
    
  
     
     

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_rech = new javax.swing.JTextField();
        com_rech = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        table();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Accueil Ehpad Decision Dashboard");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 10, 370, 40);

        jLabel2.setText("Personalize your search ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 230, 160, 40);
        getContentPane().add(txt_rech);
        txt_rech.setBounds(240, 290, 150, 40);

        com_rech.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "id_alert", "name_alert", "id_sensor", "name_sensor", "id_location", "name_location", "id_user", "name_user", "date", "num_fac" }));
        getContentPane().add(com_rech);
        com_rech.setBounds(240, 240, 150, 22);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(670, 230, 140, 40);

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(30, 560, 120, 25);

        jButton2.setText("Voir les détails ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(890, 230, 140, 40);

        jLabel3.setText("For any question, please contact us at : ehpaddecisionmanagement@ehpad.fr");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 580, 520, 30);

        jLabel4.setText("Input");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 290, 50, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "DATE", "COMMENT"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 940, 160);

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          if(txt_rech.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Please enter an id");
           
       }else{
           
 }else{
           
           if(com_rech.getSelectedItem().equals("id_alert")){
               rs=db.querySelectAll("alert", "id_alert LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
      }else if (com_rech.getSelectedItem().equals("name_alert")){
               rs=db.querySelectAll("alert", "name_alert LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
               
      }else if (com_rech.getSelectedItem().equals("id_sensor")){
               rs=db.querySelectAll("sensor", "id_sensor LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
      }else if (com_rech.getSelectedItem().equals("sensor_name")){
               rs=db.querySelectAll("sensor", "sensor_name LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
               
               
      }else if (com_rech.getSelectedItem().equals("id_location")){
               rs=db.querySelectAll("location", "id_location LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
      }else if (com_rech.getSelectedItem().equals("name_location")){
               rs=db.querySelectAll("location", "name_location LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
               
      }else if (com_rech.getSelectedItem().equals("id_user")){
               rs=db.querySelectAll("user", "id_user LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
               
      }else if (com_rech.getSelectedItem().equals("name_user")){
               rs=db.querySelectAll("user", "name_user LIKE '%" + txt_rech.getText()+ "%' ");
               table.setModel(new ResultSetTableModel(rs));
               
      }else if (com_rech.getSelectedItem().equals("date")){
               rs=db.querySelectAll("date", "date_derniere_remise LIKE '%" + txt_rech.getText()+ "%' ");
               table_client.setModel(new ResultSetTableModel(rs));
      }else if (com_rech.getSelectedItem().equals("num_fac")){
               rs=db.querySelectAll("client", "num_fac LIKE '%" + txt_rech.getText()+ "%' ");
               table_client.setModel(new ResultSetTableModel(rs));
      }
    }
    }                                        

   /* private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     Principal ra=new Principal();
       ra.setVisible(true);
       this.dispose();  
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    
    
    */
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpenDashPageFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenDashPageFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenDashPageFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenDashPageFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
*/
        /* Create and display the form */
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenDashPageFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox com_rech;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_rech;
    // End of variables declaration        
    
    private static final String PILOTE ="com.mysql.jdbc.Driver";
    private static final String URL_DATABASE ="jdbc:mysql://localhost:3306/ehpaddecision";
    public static Connection getConnection()
    {
      Connection connection = null;
      boolean ok = false;
      try{ Class.forName( PILOTE ); ok = true; } 
     catch ( ClassNotFoundException e )
     {
       System.out.println( "ERREUR chargement du pilote: pilote non trouve" );
       e.printStackTrace();
     }
    
     //--- connexion  la base de donnes
     if ( ok )
     {
       try
       {
         connection = DriverManager.getConnection(  
        		 "jdbc:mysql://localhost:3306/pds1","root","");  
       } 
       catch ( SQLException e )
       {
         System.out.println( "ERREUR de connexion  la base de donnees: " + 
                                       URL_DATABASE );
         e.printStackTrace();
       }
     }
    
      return connection;
    }
    */
    
}

