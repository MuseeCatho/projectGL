package dao;

import java.util.Collection;
import java.util.List;




public interface ObjectDao<ObjectMuseum, Integer> {

	

	public void insert(ObjectMuseum entity);
	public void deleteObject(ObjectMuseum entity);
	
	public Collection<ObjectMuseum> getLocations();
	public Collection<ObjectMuseum> getOeuvres(Integer idOeuvre);
	
	public ObjectMuseum findObjectById(Integer idOeuvre);
	
	

}