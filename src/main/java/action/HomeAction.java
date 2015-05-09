package action;

import java.util.ArrayList;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	
	public String getAllCategory(){
		System.out.println("getAllCategory");
		CategoryDaoImpl categoriesDao = new CategoryDaoImpl();
		
		listCategory =new ArrayList<Category>( categoriesDao.getCategory());
		System.out.println("getAllCategory -- listCategory.size :"+listCategory.get(0).getName_e());
		return SUCCESS;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	

}
