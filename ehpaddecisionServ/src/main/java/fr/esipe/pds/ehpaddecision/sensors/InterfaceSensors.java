package fr.esipe.pds.ehpaddecision.sensors;

import java.util.List;

import fr.esipe.pds.ehpaddecision.principales.Alert;
import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;

public interface InterfaceSensors {
	Temperatures_Sensors create (Temperatures_Sensors temperatures_sensors);
	void update (Temperatures_Sensors temperatures_sensors);
	void delete (Temperatures_Sensors temperatures_sensors);
	
	// to display all Sensors.
	List<Temperatures_Sensors> DisplayAllTemperaturesSensors();

}
