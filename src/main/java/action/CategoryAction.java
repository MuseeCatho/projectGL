package action;

import java.util.List;

import mapping.Category;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;

public class CategoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	
	public String addCategory(){
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category category =new Category(new Integer(0),"","","");
		categoryDao.insertCategory(category);
		return SUCCESS;
	}
	
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	
	

}
