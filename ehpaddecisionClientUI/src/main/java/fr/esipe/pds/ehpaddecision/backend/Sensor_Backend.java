package fr.esipe.pds.ehpaddecision.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

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
import fr.esipe.pds.ehpaddecision.principales.Alert;
import fr.esipe.pds.ehpaddecision.principales.Location;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Smoke_Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;
import fr.esipe.pds.ehpaddecision.principales.User;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.frontend.Sensors_Add;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;

public class Sensor_Backend implements ActionListener {
	private static final  Logger log = LoggerFactory.getLogger(Sensor_Backend.class);
	private Sensors_Add sensors_add;
		SensorPlan sensorPlan;
	


	public Sensor_Backend(Sensors_Add sensors_add) {
		this.sensors_add = sensors_add;
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


					System.out.println("Mac_adress"+macAdress+brand+location+type);
					if(macAdress.length() <= 0)
					{
						JOptionPane.showMessageDialog(null, "False mac_adress, try again");
					}
					else {
						System.out.println("Pas encore Fait");

						if(type == "Temperatures_Sensors"){
							Temperatures_Sensors temperatures_sensors = new Temperatures_Sensors(macAdress, brand , location, mode, date, temperatureMin, temperatureMax);

							System.out.println(temperatures_sensors.toString());
							String serializedObject = Tools.serializeObject(temperatures_sensors, temperatures_sensors.getClass(), "");
							String jsRequest = Tools.serializeQuery(Queries.INSERT, Temperatures_Sensors.class, serializedObject,null);
							System.out.println(jsRequest);
							System.out.println("toto3");
							ClientServerConnection.callSocket();
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
							String serializedObject2 = Tools.serializeObject(smoke_sensors, smoke_sensors.getClass(), "");
							String jsRequest2 = Tools.serializeQuery(Queries.INSERT, Smoke_Sensors.class, serializedObject2,null);
							System.out.println(jsRequest2);
							System.out.println("toto3");
							ClientServerConnection.callSocket();
							System.out.print("TOT5");
							String answer2 = ClientServerConnection.returnClientSocket().sendToServer(jsRequest2);


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


			


		}
	}
}

