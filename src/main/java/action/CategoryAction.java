package action;

import java.util.List;

import mapping.Category;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	
	public String getAllCategory(){
		
		
		return SUCCESS;
	}
	
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	
	

}
