package fr.esipe.pds.ehpaddecision.users;

import java.util.List;
import fr.esipe.pds.ehpaddecision.principales.User;

public interface InterfaceUsers {
	void create (User user);
	void update (User use);
	void delete (int userId);
	
	// to display all Users.
	List<User> DisplayAllUsers(); 
}
