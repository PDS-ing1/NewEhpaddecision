package fr.esipe.ehpaddecision.sensorsreferentiel;

import java.util.List;

public interface InterfaceAlerts {
	void create (AlertsDAO alert);
	void update (AlertsDAO alert);
	void delete (int alertId);
	
	// to display all currentUsers.
	List<AlertsDAO> DisplayAllAlerts();
}
