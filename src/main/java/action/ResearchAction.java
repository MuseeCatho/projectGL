package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.Comment;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.ObjectPage;
import mapping.ObjectCategory;
import action.ObjectAction;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.ObjectCategoryDaoImpl;
import bean.Research;


public class ResearchAction extends ActionSupport{

	private String research;
	private String keyword;
	private String keywordExclude;
	private String reference;
	private String period;
	private String categories;
	private String country;
	private String city;
	private List<ObjectPage> listObjectPage;
	private List<ObjectMuseum> listObject;
	private List<Period> listP;
	private List<Category> listCategory;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listPhotos;
	private String photoUnique;
	private Period periodObject;
	private ObjectPage object;

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeywordExclude() {
		return keywordExclude;
	}

	public void setKeywordExclude(String keywordExclude) {
		this.keywordExclude = keywordExclude;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<ObjectPage> getListObjectPage() {
		return listObjectPage;
	}

	public void setListObjectPage(List<ObjectPage> listObjectPage) {
		this.listObjectPage = listObjectPage;
	}

	public List<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public List<Period> getListP() {
		return listP;
	}

	public void setListP(List<Period> listP) {
		this.listP = listP;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public Collection<Photos> getPhotosObject() {
		return photosObject;
	}

	public void setPhotosObject(Collection<Photos> photosObject) {
		this.photosObject = photosObject;
	}

	public ArrayList<Photos> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(ArrayList<Photos> listPhotos) {
		this.listPhotos = listPhotos;
	}

	public String getPhotoUnique() {
		return photoUnique;
	}

	public void setPhotoUnique(String photoUnique) {
		this.photoUnique = photoUnique;
	}

	public Period getPeriodObject() {
		return periodObject;
	}

	public void setPeriodObject(Period periodObject) {
		this.periodObject = periodObject;
	}

	public ObjectPage getObject() {
		return object;
	}

	public void setObject(ObjectPage object) {
		this.object = object;
	}

	public String research(){
		System.out.println("debut recherche");
		if (this.research!=null){
//			ObjectDaoImpl objectDao = new ObjectDaoImpl();
			
			String research_word = this.research;
//			objectDao.getOeuvres(Integer.parseInt(research_word));
//			System.out.println("l'objet à rechercher est "+research_word);
			ObjectDaoImpl objectDao = new ObjectDaoImpl();

		
			listObject = new ArrayList<ObjectMuseum>(objectDao.getObjectResearch(research_word));
			listObjectPage = new ArrayList<ObjectPage>();
			

			ObjectAction.createListObject(listObject, listPhotos, 
					photoUnique,  periodObject, photosObject, listObjectPage,null);
		}
		
		return SUCCESS;
	}
	
	public String advancedResearch(){
		
		PeriodDaoImpl periods = new PeriodDaoImpl();
		listP = new ArrayList<Period>();
		listP = (List<Period>) periods.getPeriod();
		
		CategoryDaoImpl categories = new CategoryDaoImpl();
		listCategory = new ArrayList<Category>();
		listCategory = (List<Category>) categories.getCategory(); 
		
		System.out.println("debut recherche avancée");

		
		//Research research=new Research(this.keyword, this.keywordExclude, this.reference, this.country, this.city);
			
		String research_word = this.keyword;
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		
		//Obtention de la période
		Period period =new Period();
		Integer period_id = Integer.parseInt(this.period);
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		period = periodDao.getPeriodId(period_id);
		
		//Obtention des catégories
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		List<Category> listCategoryChoices=new ArrayList<Category>();
		if(this.categories!=null){
			ArrayList<String> listCatIdStr = new  ArrayList<String>(Arrays.asList(this.categories.split(", ")));
			ArrayList<Integer> listCatId = new ArrayList<Integer>();
	
			for(String s : listCatIdStr) 
				listCatId.add(Integer.parseInt(s));
	
			
			for(int id=0; id <listCatId.size();id++){
				listCategoryChoices.add(categoryDao.findCategoryById(listCatId.get(id)));
			}
		}
		else{
			listCategoryChoices=null;
		}
	
		
		Research research=new Research(this.keyword, this.keywordExclude, this.reference, listCategoryChoices, period, this.country, this.city);

		listObject = new ArrayList<ObjectMuseum>(objectDao.getObjectAdvResearch(research));
		listObjectPage = new ArrayList<ObjectPage>();
		

		ObjectAction.createListObject(listObject,listPhotos, 
				photoUnique,  periodObject, photosObject, listObjectPage,null);

		
		return SUCCESS;
	}
	
}
