package fr.esipe.pds.ehpaddecision.sensors;

import java.util.List;

import fr.esipe.pds.ehpaddecision.principales.Sensors;
import fr.esipe.pds.ehpaddecision.principales.Temperatures_Sensors;

public interface InterfaceSensorDAO {

	List<Sensors>  findAll();

}
