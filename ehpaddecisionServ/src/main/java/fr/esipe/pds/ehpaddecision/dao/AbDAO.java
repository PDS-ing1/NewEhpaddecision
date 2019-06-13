package fr.esipe.pds.ehpaddecision.dao;

import java.sql.Connection;
import java.util.List;

public abstract class AbDAO<O> {
	//O as object 
	protected Connection connection;

	public AbDAO(Connection connection) {
		this.connection = connection;
		
	}
	
	public abstract O create(O obj);
	
	public abstract void update(O obj);
	
	public abstract void delete(O obj);	
	
	public abstract List<O> find(List<String> values);
	
	public abstract List<O> findAll();

	

}
