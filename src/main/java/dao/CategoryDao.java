package dao;

import java.util.Collection;

import mapping.Category;

public interface CategoryDao<Category, Integer> {
	
	public Collection<Category> getCategory();
	
}
