package action;

import java.util.ArrayList;
import java.util.List;

import mapping.Category;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;

public class LocaleAction extends ActionSupport{

	private List<Category> listCategory;
	
	
	//business logic
	public String execute() {
		return "SUCCESS";

	}
	


	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

}