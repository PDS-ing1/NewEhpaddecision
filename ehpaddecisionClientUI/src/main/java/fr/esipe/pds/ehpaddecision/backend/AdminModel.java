package fr.esipe.pds.ehpaddecision.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.esipe.pds.ehpaddecision.enumerations.JSONExample;
import fr.esipe.pds.ehpaddecision.enumerations.Queries;
import fr.esipe.pds.ehpaddecision.exceptions.AllConnectionUsedException;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.principales.Alert;
import fr.esipe.pds.ehpaddecision.principales.Location;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.User;

public class AdminModel {
	//private int numberSensor;
	//private int numberAlert;
	//private int numberUser;
	//private int numberLocation;
	
	
	
	public AdminModel() {
		initModel();
	}
	
	private void initModel() {
		loadAlertList();
		loadSensorList();
		loadUserList();
		loadLocationList();
	}
	
	private void loadSensorList() {
		Sensors sensor = new Sensors (null, null, null, null, null, 0L);
	    String serializedObject = Tools.serializeObject(sensor, sensor.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Sensors.class, serializedObject,null);
		System.out.println(serializedObject);
		System.out.println(jsRequest);
		try 
		{
			//ClientServerConnection.callSocket();
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			//log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				sensorList = (List<Sensors>) Tools.deserializeObject(answer);
			}
			else {
				//TODO message error
			}

		} 
		catch (IOException e1){
			//log.error(e1.getMessage());
			e1.printStackTrace();
		} 
		catch (AllConnectionUsedException usedConnectionEx){
			//log.error(usedConnectionEx.getMessage());
			usedConnectionEx.printStackTrace();
		}
		
	}

	private void loadLocationList() {

    	Location location = new Location ();
	    String serializedObject = Tools.serializeObject(location, location.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Location.class, serializedObject,null);
		System.out.println(serializedObject);
		System.out.println(jsRequest);
		try 
		{
			//ClientServerConnection.callSocket();
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			//log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				locationList = (List<Location>) Tools.deserializeObject(answer);
			}
			else {
				//TODO message error
			}

		} 
		catch (IOException e1){
			//log.error(e1.getMessage());
			e1.printStackTrace();
		} 
		catch (AllConnectionUsedException usedConnectionEx){
			//log.error(usedConnectionEx.getMessage());
			usedConnectionEx.printStackTrace();
		}
	}

	private void loadUserList() {
		// TODO Auto-generated method stub
		User User = new User ();
		String serializedObject = Tools.serializeObject(User, User.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, User.class, serializedObject,null);
		
		try 
		{
			//ClientServerConnection.callSocket();
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			//log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				userList = (List<User>) Tools.deserializeObject(answer);
				
			}
			else {
				//TODO message error
			}

		} 
		catch (IOException e1){
			//log.error(e1.getMessage());
			e1.printStackTrace();
		} 
		catch (AllConnectionUsedException usedConnectionEx){
			//log.error(usedConnectionEx.getMessage());
			usedConnectionEx.printStackTrace();
		}
	}

	private void loadAlertList() {
		// TODO Auto-generated method stub
		Alert Alert = new Alert ();
		String serializedObject = Tools.serializeObject(Alert, Alert.getClass(), "");
		String jsRequest = Tools.serializeQuery(Queries.SELECT, Alert.class, serializedObject,null);
		
		try 
		{
			//ClientServerConnection.callSocket();
			String answer = ClientServerConnection.returnClientSocket().sendToServer(jsRequest);
			//log.info("Getting the answer from the server..." + Tools.getPrettyJson(answer));
			String error = Tools.jsonNode(JSONExample.ERROR, answer).trim();
			if(error.equals(""))
			{
				alertList = (List<Alert>) Tools.deserializeObject(answer);
			}
			else {
				//TODO message error
			}

		} 
		catch (IOException e1){
			//log.error(e1.getMessage());
			e1.printStackTrace();
		} 
		catch (AllConnectionUsedException usedConnectionEx){
			//log.error(usedConnectionEx.getMessage());
			usedConnectionEx.printStackTrace();
		}
	}

	private List<Alert> alertList = new ArrayList<>();
	private List<Location> locationList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	private List<Sensors> sensorList = new ArrayList<>();
	
	private void initData() {
		
	}
	
	public List<Alert> getAlertList() {
		return alertList;
	}
	public void setAlertList(List<Alert> alertList) {
		this.alertList = alertList;
	}
	public List<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Sensors> getSensorList() {
		return sensorList;
	}
	public void setSensorList(List<Sensors> sensorList) {
		this.sensorList = sensorList;
	}
	public int getNumberSensor() {
		return sensorList.size();
	}
	public int getNumberAlert() {
		return alertList.size();
	}
	public int getNumberUser() {
		return userList.size();
	}
	public int getNumberLocation() {
		return locationList.size();
	}
	
	public int getSensorOnCount() {
		return (int)this.sensorList.stream().filter(s -> "on".equalsIgnoreCase(s.getMode())).count();
	}
	
	public int getSensorOffCount() {
		return (int)this.sensorList.stream().filter(s -> "off".equalsIgnoreCase(s.getMode())).count();
	}
	
	public int getSensorConfCount() {
		return (int)this.sensorList.stream().filter(s -> "conf".equalsIgnoreCase(s.getMode())).count();
	}

}
