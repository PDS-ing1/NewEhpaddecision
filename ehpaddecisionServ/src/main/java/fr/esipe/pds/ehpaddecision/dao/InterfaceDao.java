package fr.esipe.pds.ehpaddecision.dao;

import java.sql.Connection;
import java.util.List;

public abstract class InterfaceDao<O> {
	//O as object 
	protected Connection connection;

	public InterfaceDao(Connection connection) {
		this.connection = connection;
	}
	
	public abstract O create(O obj);
	
	public abstract void update(O obj);
	
	public abstract void delete(O obj);	
	
	public abstract List<O> find(List<String> fields, List<String> values);
	
	public abstract List<O> findAll();

}
