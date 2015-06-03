package dao;

import java.util.Collection;

import mapping.Category;
import mapping.Comment;

public interface ContactDao<Museum, Integer> {
	
	public Collection<Museum> getInfoMuseum();
	
	
}
