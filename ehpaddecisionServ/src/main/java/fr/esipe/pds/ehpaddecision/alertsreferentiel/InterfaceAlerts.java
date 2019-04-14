package fr.esipe.pds.ehpaddecision.alertsreferentiel;

import fr.esipe.pds.ehpaddecision.principales.Alerts;
import java.util.List;

public interface InterfaceAlerts {
	Alerts create (Alerts alert);
	void update (Alerts alert);
	void delete (int alertId);
	
	// to display all alerts.
	List<Alerts> DisplayAllAlerts(); 
}
