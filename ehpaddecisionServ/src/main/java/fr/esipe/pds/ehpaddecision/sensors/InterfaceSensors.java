package fr.esipe.pds.ehpaddecision.sensors;

import java.util.List;

import fr.esipe.pds.ehpaddecision.principales.Alerts;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;

public interface InterfaceSensors {
	void create (Temperatures_Sensors temperatures_sensors);
	void update (Temperatures_Sensors temperatures_sensors);
	//void delete (int userId);*/
	
	// to display all Users.
	List<SensorsTemperaturesDAO> DisplayAllTemperaturesSensors(); 

}
