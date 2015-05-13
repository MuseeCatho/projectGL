package action;

import java.util.ArrayList;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;

public class CategoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	private String title_f;
	private String title_e;
	private String id_category;
	private String link_category;
	private String result;
	
	public String getAllCategory(){
		System.out.println("getAllCategory");
		CategoryDaoImpl categoriesDao = new CategoryDaoImpl();
		
		listCategory =new ArrayList<Category>( categoriesDao.getCategory());
		Gson gson = new Gson();
		
		result = gson.toJson(listCategory);
		System.out.println("getAllCategory -- json"+result);
		return SUCCESS;
	}
	
public String deleteCategory(){
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category category=categoryDao.findCategoryById(new Integer(this.id_category));
		categoryDao.deleteCategory(category);
		
		return SUCCESS;
	}
	
	public String addCategory(){
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		if(this.link_category!=null){
			this.link_category="img/category/other.jpg";
		}
		Category category =new Category(new Integer(0),this.title_f,this.title_e,this.link_category);
		categoryDao.insertCategory(category);
		return SUCCESS;
	}
	
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public String getTitle_f() {
		return title_f;
	}

	public void setTitle_f(String title_f) {
		this.title_f = title_f;
	}

	public String getTitle_e() {
		return title_e;
	}

	public void setTitle_e(String title_e) {
		this.title_e = title_e;
	}

	public String getId_category() {
		return id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}

	public String getLink_category() {
		return link_category;
	}

	public void setLink_category(String link_category) {
		this.link_category = link_category;
	}
	

}
