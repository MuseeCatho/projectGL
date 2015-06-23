package dao;

import java.util.Collection;

import mapping.Category;
import mapping.Comment;
import mapping.Museum;

public interface ContactDao<Museum, Integer> {
	
	public Collection<Museum> getInfoMuseum();
	
	public void updateContact(Museum entity);
}
