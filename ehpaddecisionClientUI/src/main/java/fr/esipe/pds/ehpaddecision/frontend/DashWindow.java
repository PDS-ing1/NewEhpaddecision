package fr.esipe.pds.ehpaddecision.frontend;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
public class DashWindow extends JDialog {

    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtComponentId;
    private javax.swing.JTextField txtName;
   
   // private javax.swing.JTextField txtSalary;

    boolean addRecord = false;

    private void clearInputBoxes()
    {
        txtComponentId.setText("");
        txtName.setText("");
        cboType.setSelectedItem("");
        txtLocation.setText("");
       
        //txtSalary.setText("");
    }
   /* private void addNew()
    {
        String sql_stmt = "INSERT INTO employees (full_name,gender,department,position,salary)";
        sql_stmt += " VALUES ('" + txtFullName.getText() + "','" + cboGender.getSelectedItem().toString() + "','" + txtDepartment.getText() + "','" + txtPosition.getText() + "','" + txtSalary.getText() + "')";
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }*/
    
    
    
    private void loadRecords() throws SQLException
    {
        String sql_stmt = "SELECT * FROM SENSOR;";
        ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
        jTable1.setModel(tableModel);
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (jTable1.getSelectedRow() >= 0) {
                    Object component_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                    Object name = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                    Object type = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
                    Object location = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
                   

                    txtComponentId.setText(component_id.toString());
                    txtName.setText(name.toString());
                    cboType.setSelectedItem(type.toString());
                    txtLocation.setText(location.toString());              
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }
    public DashWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void initComponents() {
    	
    	  javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
          javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
          txtComponentId = new javax.swing.JTextField();
          javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
          txtName = new javax.swing.JTextField();
          javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
          cboType = new javax.swing.JComboBox<>();
          javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
          txtLocation = new javax.swing.JTextField();
         
         
         // JButton btnAddNew = new javax.swing.JButton();
         JButton btnUpdate = new javax.swing.JButton();
         JButton btnDelete = new javax.swing.JButton();
         JButton btnClose = new javax.swing.JButton();
         JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
          jTable1 = new javax.swing.JTable();
    }
    
}