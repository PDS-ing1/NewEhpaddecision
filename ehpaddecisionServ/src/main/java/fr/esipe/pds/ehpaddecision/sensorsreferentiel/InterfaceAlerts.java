package fr.esipe.pds.ehpaddecision.sensorsreferentiel;

import java.util.List;

public interface InterfaceAlerts {
	Alerts create (Alerts alert);
	void update (Alerts alert);
	void delete (int alertId);
	
	// to display all currentUsers.
	List<Alerts> DisplayAllAlerts();
}
