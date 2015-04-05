package dao;

import java.util.Collection;
import java.util.List;




public interface ObjectDao<ObjectMuseum, Integer> {

	

	public void insert(ObjectMuseum entity);
	
	public Collection<ObjectMuseum> getLocations();

}