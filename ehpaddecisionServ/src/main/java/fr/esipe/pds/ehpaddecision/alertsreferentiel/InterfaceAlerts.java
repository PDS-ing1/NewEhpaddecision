package fr.esipe.pds.ehpaddecision.alertsreferentiel;

import fr.esipe.pds.ehpaddecision.principales.Alert;
import java.util.List;

public interface InterfaceAlerts {
	Alert create (Alert alert);
	void update (Alert alert);
	void delete (int alertId);
	
	// to display all alerts.
	List<Alert> DisplayAllAlerts(); 
}
