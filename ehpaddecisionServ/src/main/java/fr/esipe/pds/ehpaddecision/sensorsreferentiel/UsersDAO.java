package fr.esipe.pds.ehpaddecision.sensorsreferentiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;

import fr.esipe.pds.ehpaddecision.sensorsreferentiel.Users;

public class UsersDAO extends AbDAO<Users>{
	private final Logger log = LoggerFactory.getLogger(AlertsDAO.class);	
	private JsonFactory jsFactory = new JsonFactory();

	public UsersDAO (Connection connection) 
	{
		super(connection);
	}

	
	private Users usersHandler(ResultSet rs) {
		{
			Users user = null;
			try {
				user = new Users(rs.getInt("ID_USER"), rs.getString("NAME"),null, rs.getTimestamp("DATE_CREATION"));
			} catch (SQLException e) {
				log.error("Sorry, we occured an error while retrieving this alert from the result : " + e.getMessage());
			}
				return user;
			}
		}
	
	
	
	public void update(Users user) {
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE USER SET NAME = ? WHERE ID_USER =" + user.getIdUser());
				preparedStatement.setString(1, user.getNameUser());
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("Sorry we can't update this user, try again: " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

	// this method will create new user into the table USER
	public Users create(Users users) {
	
		// quick check if there is any free connection to use 
			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO USER (ID, LAST_NAME, FIRST_NAME, CREATION_DATE)"
									+ " VALUES (? , ? , ? , ?, ? )", Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setInt(1, users.getIdUser());
					preparedStatement.setString(2, users.getNameUser());
					preparedStatement.setTimestamp(3, users.getDateCreation());
					preparedStatement.execute();
					ResultSet rs = preparedStatement.getGeneratedKeys();

				} catch (Exception e) {
					log.error("Sorry, this creation couldn't execute : " + e.getMessage());
					e.printStackTrace();
				}
			}	
			
			return users;

		}

	
	public void delete(Users obj) {
		delete(obj.getIdUser());		
	}
	// this method will delete one user from the table using his id
	public void delete(int userId){
		// quick check if there is any free connection to use 
		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM USER where ID_USER=(?)");
				preparedStatement.setInt(1, userId);
				preparedStatement.execute();
			} catch (Exception e) {
				log.error("Sorry, it seems like something wrong was happened with deleting this user, try again : " + e.getMessage());
				e.printStackTrace();
			}
		}		
	}



	// this method should be able to show us all users 
	public List<Users> DisplayAllUsers() {
		List<Users> users = new ArrayList<Users>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
				ResultSet rs = preparedStatement.executeQuery();
				Users user;
				while (rs.next()) {
					user = usersHandler(rs);
					if(user != null)
					{
						users.add(user);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return users;
	}



	@Override
	public List<Users> find(List<String> values) {
		List<Users> users = new ArrayList<Users>();

			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER ");
					ResultSet rs = preparedStatement.executeQuery();
					Users user;
					while (rs.next()) {
						user = usersHandler(rs);
						if(user != null)
						{
							users.add(user);
						}
					}
				} catch (Exception e) {
					log.error("Oh it seems to be a big URL, try again : to find all users " + e.getMessage());
					e.printStackTrace();
				}
			}

			return users;
		}

	
}
