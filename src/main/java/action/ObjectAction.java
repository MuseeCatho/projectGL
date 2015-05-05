package action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;
import mapping.Period;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;

import com.google.gson.Gson;
public class ObjectAction extends ActionSupport{
	
	private static ObjectDaoImpl objectDao;
	private String title_f;
	private String title_e;
	private String description_f;
	private String description_e;
	private String country;
	private String city;
	private String reference;
	private Integer period;
	private String latitude;
	private String longitude;
	private List<Period> listP;
	private List<Category> listCategory;
	private String categories;
	private int result;
	private List<ObjectMuseum> listObject;

	
	public ObjectAction(){
		getListOeuvre();
	}



	public String addObjectAction(){
		
		PeriodDaoImpl periods = new PeriodDaoImpl();
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		CategoryDaoImpl categories = new CategoryDaoImpl();
		
		listP = new ArrayList<Period>();
		listP = (List<Period>) periods.getPeriod();
		
		listCategory = new ArrayList<Category>();
		listCategory = (List<Category>) categories.getCategory();

		System.out.println("objet prêt à être ajouté");
		System.out.println("title_f: "+this.title_f);
		System.out.println("desc: "+this.description_f);
		System.out.println("ref: "+this.reference);
		System.out.println("latitude: "+this.latitude);
		System.out.println("longitude: "+this.longitude);
		System.out.println("Période: "+this.period);
		System.out.println("Categories: "+this.categories);

		if (this.title_e == null){
			this.title_e = this.title_f;
		} 
		if (this.description_e == null){
			this.description_e = this.description_f;
		}
		if(this.title_f!=null){
			ObjectMuseum object = new ObjectMuseum(new Integer(0),this.period, this.title_f,this.title_e,this.country,this.reference,this.description_e,this.description_f,"20","30","89",null,new Date(),this.city, 4.0,4.0);
			objectDao.addObject(object);
			result=1;
			System.out.println("objet ajouté");
		}
		return SUCCESS;
	}
	
	
	
	
	public void setPeriod(Integer period) {
		this.period = period;
	}


	public String getCategories() {
		return categories;
	}



	public void setCategories(String categories) {
		this.categories = categories;
	}



	public List<Period> getListP() {
		return listP;
	}



	public List<Category> getListCategory() {
		return listCategory;
	}
	
	public List<ObjectMuseum> getListOeuvre(){
		
		ObjectDaoImpl objectDao=new ObjectDaoImpl();
		listObject =new ArrayList<ObjectMuseum>(objectDao.getLocations());
		ArrayList list = new ArrayList();
			
		return list;
	}

	


	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}



	public void setListP(List<Period> listP) {
		this.listP = listP;
	}


	public String getDescription_e() {
		return description_e;
	}
	public void setDescription_e(String description_e) {
		this.description_e = description_e;
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
	public String getDescription_f() {
		return description_f;
	}
	public void setDescription_f(String description_f) {
		this.description_f = description_f;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getDefaultSearchEngine() {
		return "Moyen Age";
	}
	public String getLatitude() {
		return latitude;

	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	public List<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}



	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}



	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}

}

/*package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.struts2.interceptor.ServletRequestAware;

import mapping.ObjectMuseum;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;

public class ObjectAction extends ActionSupport{
	private static ObjectDaoImpl objectDao;
	private List<ObjectMuseum> listObject;
	
	public ObjectAction(){
		getListOeuvre();
	}

	public List<ObjectMuseum> getListOeuvre(){
		
		ObjectDaoImpl objectDao=new ObjectDaoImpl();
		listObject =new ArrayList<ObjectMuseum>(objectDao.getLocations());
		ArrayList list = new ArrayList();
		
		for (ObjectMuseum e: listObject) {

			System.out.println(e);
		}		
		return list;
	}
	
	
	
	public List<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}



	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}



	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}

	
	
}

*/
