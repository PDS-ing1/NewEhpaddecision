package fr.esipe.ehpaddecision.sensorsreferentiel;

import java.util.List;

public interface InterfaceLocation {
	
		void create (LocationDAO location);
		void update (LocationDAO location);
		void delete (int idLocation);
		
		// to display all locations.
		List<LocationDAO> DisplayAllLocations();
	}