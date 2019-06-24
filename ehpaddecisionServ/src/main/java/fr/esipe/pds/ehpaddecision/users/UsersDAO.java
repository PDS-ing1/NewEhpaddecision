package fr.esipe.pds.ehpaddecision.users;

import fr.esipe.pds.ehpaddecision.principales.User;
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

import fr.esipe.pds.ehpaddecision.alertsreferentiel.AlertsDAO;
import fr.esipe.pds.ehpaddecision.dao.AbDAO;

public class UsersDAO extends AbDAO<User>{
	private final Logger log = LoggerFactory.getLogger(AlertsDAO.class);	
	private JsonFactory jsFactory = new JsonFactory();

	public UsersDAO (Connection connection) 
	{
		super(connection);
	}

	
	private User usersHandler(ResultSet rs) {
		{
			User user = null;
			try {
				user = new User(rs.getInt("ID_USER"), rs.getString("NAME"), rs.getTimestamp("creation_Date"));
			} catch (SQLException e) {
				log.error("Sorry, we occured an error while retrieving this alert from the result : " + e.getMessage());
			}
				return user;
			}
		}
	
	
	
	public void update(User user) {
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
	public User create(User user) {
	
		// quick check if there is any free connection to use 
			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO USER (ID_USER, NAME, CREATION_DATE)"
									+ " VALUES (? , ?, ? )", Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setInt(1, user.getIdUser());
					preparedStatement.setString(2, user.getNameUser());
					preparedStatement.setTimestamp(3, user.getDateCreation());
					preparedStatement.execute();
					ResultSet rs = preparedStatement.getGeneratedKeys();

				} catch (Exception e) {
					log.error("Sorry, this creation couldn't execute : " + e.getMessage());
					e.printStackTrace();
				}
			}	
			
			return user;

		}

	
	public void delete(User obj) {
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
	public List<User> DisplayAllUsers() {
		List<User> userList = new ArrayList<User>();

		if(connection != null)
		{
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
				ResultSet rs = preparedStatement.executeQuery();
				User user;
				while (rs.next()) {
					user = usersHandler(rs);
					if(user != null)
					{
						userList.add(user);
					}
				}
			} catch (Exception e) {
				log.error("Oh, it looks like a big url.. try again : " + e.getMessage());
				e.printStackTrace();
			}
		}

		return userList;
	}



	@Override
	public List<User> find(List<String> values) {
		List<User> userList = new ArrayList<User>();

			if(connection != null)
			{
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER ");
					ResultSet rs = preparedStatement.executeQuery();
					User user;
					while (rs.next()) {
						user = usersHandler(rs);
						if(user != null)
						{
							userList.add(user);
						}
					}
				} catch (Exception e) {
					log.error("Oh it seems to be a big URL, try again : to find all users " + e.getMessage());
					e.printStackTrace();
				}
			}

			return userList;
		}


	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
