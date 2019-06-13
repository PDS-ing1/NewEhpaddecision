package fr.esipe.pds.ehpaddecision.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.tools.Tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.frontend.HomePageFront;
import fr.esipe.pds.ehpaddecision.frontend.SensorPlan;
import fr.esipe.pds.ehpaddecision.frontend.SensorsFront1;
import fr.esipe.pds.ehpaddecision.frontend.Sensors_Add;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alerts;
import fr.esipe.pds.ehpaddecision.principales.Locations;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Smoke_Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;
import fr.esipe.pds.ehpaddecision.principales.Users;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.frontend.Sensors_Add;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;

public class Sensor_Backend implements ActionListener, WindowListener {
	private static final  Logger log = LoggerFactory.getLogger(Sensor_Backend.class);
	private Sensors_Add sensors_add;
	private SensorsFront1 sensorsfront1;
	private SensorPlan sensorPlan;



	public Sensor_Backend(Sensors_Add sensors_add) {
		this.sensors_add = sensors_add;
	}


	public Sensor_Backend(SensorsFront1 sensorsFront1) {
		this.sensorsfront1 = sensorsfront1;
	}



	public void actionPerformed(ActionEvent ae) {
		{
			if(ae.getSource()== Sensors_Add.getBtnSubmit()){
				System.out.println("action button Submit");
				try
				{
					String macAdress = Sensors_Add.getTextField().getText();
					String brand = Sensors_Add.getComboBox().getSelectedItem().toString();
					String location = Sensors_Add.getComboBox_1().getSelectedItem().toString();
					String type = Sensors_Add.getComboBox_2().getSelectedItem().toString();
					String mode = "off";
					long date = System.currentTimeMillis();
					int temperatureMin = 5;
					int temperatureMax = 39;
					ClientServerConnection.callSocket();


					System.out.println("Mac_adress"+macAdress+brand+location+type);
					if(macAdress.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False mac_adress, try again");
					}
					else {
						System.out.println("Pas encore Fait");

						if(type == "Temperatures_Sensors"){
							Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand , location, mode, date, temperatureMin, temperatureMax);
							//Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand);

							System.out.println(temperatures_sensors.toString());
							String serializedObject = Tools.serializeObject(temperatures_sensors, temperatures_sensors.getClass(), "");
							String jsRequest = Tools.serializeQuery(Queries.INSERT, Temperatures_Sensors.class, serializedObject,null);
							System.out.println(jsRequest);
							System.out.println("toto3");
							//ClientServerConnection.callSocket();
							System.out.print("TOT5");
							String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);


							log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
							String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
							if(error.equals("")) {
								Temperatures_Sensors temperatures_sensorsNewCreated = (Temperatures_Sensors)Tools.deserializeObject(answer);
								String MacAdress = temperatures_sensorsNewCreated.getMacAdress();
								String Brand = temperatures_sensorsNewCreated.getBrand();
								String Location = temperatures_sensorsNewCreated.getLocation();

								JOptionPane.showMessageDialog(sensors_add, "A new Temperatures_Sensors has been created  " + MacAdress + Brand + Location, null, JOptionPane.INFORMATION_MESSAGE);



								Sensors sensors = new Sensors(macAdress, brand, location, type, mode, date);
								System.out.println(sensors.toString());
								String serializedObject1 = Tools.serializeObject(sensors, sensors.getClass(), "");
								String jsRequest1 = Tools.serializeQuery(Queries.INSERT, Sensors.class, serializedObject1, null);
								System.out.println(jsRequest1);
								System.out.println("toto87");
								//ClientServerConnection.callSocket();
								System.out.println("TOT6");
								String answer1 = ClientServerConnection.returnClientSocket().sendToServer(jsRequest1);






								log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer1));
								String error1 = Tools.jsonNode(JSONExample.ERROR, answer1).trim();
								if(error1.equals("")) {
									Sensors sensorsNewCreated = (Sensors)Tools.deserializeObject(answer1);
									String MacAdress1 = sensorsNewCreated.getMacAdress();
									String Brand1 = sensorsNewCreated.getBrand();
									String Location1 = sensorsNewCreated.getLocation();
									String Type1 = sensorsNewCreated.getType();

									JOptionPane.showMessageDialog(sensors_add, "A new Sensors has been created  " + MacAdress1 + Brand1 + Location1 + Type1, null, JOptionPane.INFORMATION_MESSAGE);


								}else
								{
									JOptionPane.showMessageDialog(sensors_add, error, "An error was found", JOptionPane.ERROR_MESSAGE);

								}



							}

						}
						if(type == "Smoke_Sensors"){

							Smoke_Sensors smoke_sensors = new Smoke_Sensors(macAdress, brand , location, mode, date);

							System.out.println(smoke_sensors.toString());
							String serializedObject = Tools.serializeObject(smoke_sensors, smoke_sensors.getClass(), "");
							String jsRequest = Tools.serializeQuery(Queries.INSERT, Smoke_Sensors.class, serializedObject, null);
							System.out.println(jsRequest);
							System.out.println("toto3");
							//ClientServerConnection.callSocket();
							System.out.print("TOT5");
							String answer2 = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
							System.out.println(answer2);


							log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer2));
							String error2 = Tools.jsonNode(JSONExample.ERROR, answer2).trim();
							if(error2.equals("")) {
								Smoke_Sensors smoke_sensorsNewCreated = (Smoke_Sensors)Tools.deserializeObject(answer2);
								String MacAdress2 = smoke_sensorsNewCreated.getMacAdress();
								String Brand2 = smoke_sensorsNewCreated.getBrand();
								String Location2 = smoke_sensorsNewCreated.getLocation();

								JOptionPane.showMessageDialog(sensors_add, "A new Smoke_Sensors has been created  " + MacAdress2 + Brand2 + Location2, null, JOptionPane.INFORMATION_MESSAGE);



								Sensors sensors = new Sensors(macAdress, brand, location, type, mode, date);
								System.out.println(sensors.toString());
								String serializedObject3 = Tools.serializeObject(sensors, sensors.getClass(), "");
								String jsRequest3 = Tools.serializeQuery(Queries.INSERT, Sensors.class, serializedObject3, null);
								System.out.println(jsRequest3);
								System.out.println("toto87");
								//ClientServerConnection.callSocket();
								System.out.println("TOT6");
								String answer3 = ClientServerConnection.returnClientSocket().sendToServer(jsRequest3);



								log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer3));
								String error3 = Tools.jsonNode(JSONExample.ERROR, answer3).trim();
								if(error3.equals("")) {
									Sensors sensorsNewCreated = (Sensors)Tools.deserializeObject(answer3);
									String MacAdress3 = sensorsNewCreated.getMacAdress();
									String Brand3 = sensorsNewCreated.getBrand();
									String Location3 = sensorsNewCreated.getLocation();
									String Type3 = sensorsNewCreated.getType();

									JOptionPane.showMessageDialog(sensors_add, "A new Sensors has been created  " + MacAdress3 + Brand3 + Location3 + Type3, null, JOptionPane.INFORMATION_MESSAGE);


								}else
								{
									JOptionPane.showMessageDialog(sensors_add, error3, "An error was found", JOptionPane.ERROR_MESSAGE);

								}






							}


						}
					}
					sensorPlan.AddButtonavailable(location);
				}







				catch(Exception e0){
					log.error(e0.getMessage());
				}





			}


			if(ae.getSource() == Sensors_Add.getBtnDelete()){
				System.out.println("Action button Delete");
				try
				{
					String macAdress = Sensors_Add.getTextField().getText();
					String brand = Sensors_Add.getComboBox().getSelectedItem().toString();
					String location = Sensors_Add.getComboBox_1().getSelectedItem().toString();
					String type = Sensors_Add.getComboBox_2().getSelectedItem().toString();
					String mode = "off";
					long date = System.currentTimeMillis();
					int temperatureMin = 5;
					int temperatureMax = 39;
					ClientServerConnection.callSocket();


					System.out.println("Mac_adress"+macAdress+brand+location+type);
					if(macAdress.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False mac_adress, try again");
					}
					else {
						System.out.println("Pas encore Fait");
						//ClientServerConnection.callSocket();
						if(type == "Temperatures_Sensors"){
							Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand , location, mode, date, temperatureMin, temperatureMax);
							//Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand);

							System.out.println(temperatures_sensors.toString());
							String serializedObject = Tools.serializeObject(temperatures_sensors, temperatures_sensors.getClass(), "");
							String jsRequest = Tools.serializeQuery(Queries.DELETE, Temperatures_Sensors.class, serializedObject,null);
							System.out.println(jsRequest);
							System.out.println("toto218");
							System.out.print("TOT537");
							String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
							System.out.println(answer);




						}


					}
				} catch(Exception exp){
					log.error("The Delete Failed");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}




			/*if(ae.getSource()== SensorsFront1.getBtnSubmit1()){
			System.out.println("action button Submit1");
			try
			{
				String macAdress = Sensors.class;
				/*String brand = Sensors_Add.getComboBox().getSelectedItem().toString();
				String location = Sensors_Add.getComboBox_1().getSelectedItem().toString();
				String type = Sensors_Add.getComboBox_2().getSelectedItem().toString();
				String mode = "off";
				long date = System.currentTimeMillis();
				int temperatureMin = 5;
				int temperatureMax = 39;
				ClientServerConnection.callSocket();


				System.out.println("Mac_adress"+macAdress+brand+location+type);
				if(macAdress.length() <= 0)
			} catch(Exception e0){
				log.error(e0.getMessage());
			}*/



			if(ae.getSource() == SensorsFront1.getBtnSubmit1()) {
				System.out.println("Action Button Submit1");

				try {

					String macAdress = SensorsFront1.getMacAdressTextField().getText();
					String Brand = SensorsFront1.getUser_firstName_Field().getText();
					String mode = SensorsFront1.getComboBox().getSelectedItem().toString();
					String Seuil_DioxideCarbone = SensorsFront1.getPPM_Field().getText();
					JRadioButton ButtonTemperatures = SensorsFront1.getRdbtnNewRadioButton_1();
					JRadioButton ButtonSmoke = SensorsFront1.getRdbtnNewRadioButton();
					String Temperature_Min = SensorsFront1.getTemp_Min_Field().getText();
					String Temperature_Max = SensorsFront1.getTemp_Max_Field().getText();
					Long date = System.currentTimeMillis();

					System.out.println("Mac_adress"+macAdress+Brand);
					ClientServerConnection.callSocket();

					//String id = Integer.parseInt(idInString);

					int temperature_min = Integer.parseInt(Temperature_Min.trim());
					JOptionPane.showMessageDialog(null, "OKKKKKK", "convert", JOptionPane.WARNING_MESSAGE);
					int temperature_max = Integer.parseInt(Temperature_Max.trim());
					JOptionPane.showMessageDialog(null, "OKKKKKK", "convert", JOptionPane.WARNING_MESSAGE);

					/*String newAlertName = JOptionPane.showInputDialog(null, "Please enter the new name of your alert :"
							, "Creating", JOptionPane.QUESTION_MESSAGE); */


					if(macAdress.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False mac_adress, try again");
					}
					else {
						System.out.println("Pas encore Fait");

						if(ButtonTemperatures.getSelectedObjects() != null) {


							Temperatures_Sensors temperaturesSensorsUpdating = new Temperatures_Sensors(macAdress, Brand, null, mode, date, temperature_min, temperature_max);
							//Temperatures_Sensors temperaturesSensorsUpdating = new Temperatures_Sensors(macAdress, Brand);
							System.out.println(temperaturesSensorsUpdating.toString());
							String serializedObject = Tools.serializeObject(temperaturesSensorsUpdating, temperaturesSensorsUpdating.getClass(), "");
							System.out.println(serializedObject);
							String jsRequest = Tools.serializeQuery(Queries.UPDATE, Temperatures_Sensors.class, serializedObject, null);
							System.out.println(jsRequest);


							System.out.println("Ca avance ?");
							String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);


							JOptionPane.showMessageDialog(sensorsfront1, "A new Sensors has been updated  " + macAdress + Brand + mode + temperature_min + temperature_max, null, JOptionPane.INFORMATION_MESSAGE);
							System.out.println(answer);

							log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
							String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
							if(!error.equals(""))
							{
								JOptionPane.showMessageDialog(sensorsfront1, error, "Error", JOptionPane.ERROR_MESSAGE);
							}


						}
					}
				}
				catch(Exception exp){
					log.error("The convertion into an Integer did not work");
					JOptionPane.showMessageDialog(null, "Sorry, something is wrong with it", "Cannot convert", JOptionPane.WARNING_MESSAGE);
				}
			}







		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("CA COMEEEEEEENNNNNNNNNNCCCCCCEEEEEEEE");

		Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors();
		
		//Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand);

		System.out.println(temperatures_sensors.toString());
		String serializedObject = Tools.serializeObject(temperatures_sensors, temperatures_sensors.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Temperatures_Sensors.class, serializedObject, null);
		System.out.println(jsRequest);
		System.out.println("toto3");
		ClientServerConnection.callSocket();
		System.out.print("TOT54321"
				+ "");
		//String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);


		try 
		{
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				List<Temperatures_Sensors> temperaturesSensors = (List<Temperatures_Sensors>) Tools.deserializeObject(answer);
				String temperaturesSensorText = "";
				for(Temperatures_Sensors temperatures_Sensors : temperaturesSensors)
				{
					temperaturesSensorText += temperaturesSensors+ "\n";
				}
				System.out.println(answer);
				//homePageFront.getTextArea().setText(locationsText);
				//sensorsfront1.getList_1()
			}
			else {
				JOptionPane.showMessageDialog(sensorsfront1, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} 
		catch (IOException e1){
			log.error(e1.getMessage());
		}
		catch (AllConnectionUsedException usedConnection){
			log.error(usedConnection.getMessage());
		}
	}












	/*if(ae.getSource()==homePageFront.getButtonDisplay()) {

		Locations Location = new Locations ();
		System.out.println(Location.toString());
	    String serializedObject = Tools.serializeObject(Location, Location.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Locations.class, serializedObject,null);
		System.out.println(serializedObject);


	    // String jsRequest = Tools.serializeObject(Queries.SELECT, Alerts.class, null);
		// String jsRequest = Tools.serializeQuery(Queries.SELECT, Alerts.class, serializedObject,null);

	    System.out.println(jsRequest);
		try 
		{
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				List<Locations> locations = (List<Locations>) Tools.deserializeObject(answer);
				String locationsText = "";
				for(Locations location : locations)
				{
					locationsText += location+ "\n";
				}
				homePageFront.getTextArea().setText(locationsText);
			}
			else {
				JOptionPane.showMessageDialog(homePageFront, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

		} 
		catch (IOException e1){
			log.error(e1.getMessage());
		} 
		catch (AllConnectionUsedException usedConnection){
			log.error(usedConnection.getMessage());
		}
	}*/



@Override
public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub

}


@Override
public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub

}


@Override
public void windowClosing(WindowEvent arg0) {
	// TODO Auto-generated method stub

}


@Override
public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub

}


@Override
public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub

}


@Override
public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub

}






}

