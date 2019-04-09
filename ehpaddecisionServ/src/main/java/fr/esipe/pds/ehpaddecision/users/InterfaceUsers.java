package fr.esipe.pds.ehpaddecision.users;

import java.util.List;

public interface InterfaceUsers {
	void create (UsersDAO user);
	void update (UsersDAO use);
	void delete (int userId);
	
	// to display all currentUsers.
	List<UsersDAO> DisplayAllUsers();
}
