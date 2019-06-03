package fr.esipe.pds.ehpaddecision.backend;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.DefaultListModel;

public class Connection123 {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver O.K");
			
			String url = "jdbc:mysql://localhost:3306/ehpaddecision?serverTimezone=UTC";
			String user = "root";
			String passwd = "";
			
			java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connection OK");
			Statement stm = conn.createStatement();
			String req = "SELECT * FROM temperatures_sensors";
			ResultSet rst = stm.executeQuery(req);
			ResultSetMetaData resultMeta = rst.getMetaData();
			
			System.out.println("\n*********************************************");
			
			while(rst.next())
			{
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + rst.getObject(i).toString() + "\t |");
				
				System.out.println("\n------------------------------------------");
				
			}
			
			rst.close();
			stm.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}

}
}
