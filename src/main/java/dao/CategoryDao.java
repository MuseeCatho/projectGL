package dao;

import java.util.Collection;

import mapping.Category;

public interface CategoryDao<Category, Integer> {
	
	public Collection<Category> getCategory();
	
	public void insertCategory(Category entity);
	
	public Category findCategoryById(Integer id);
	
	public void deleteCategory(Category entity);
	
}
