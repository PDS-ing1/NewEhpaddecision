package fr.esipe.pds.ehpaddecision.users;

import java.util.List;
import fr.esipe.pds.ehpaddecision.principales.Users;

public interface InterfaceUsers {
	void create (Users user);
	void update (Users use);
	void delete (int userId);
	
	// to display all Users.
	List<Users> DisplayAllUsers(); 
}
