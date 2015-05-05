package action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.ObjectPage;

import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;

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
	private List<String> listOfPeriod;
	private List<Integer> listOfPeriodId;
	private List<Period> listP;
	private int result;
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List<ObjectPage> listObjectPage;
	private Photos photosObject;

	
	public ObjectAction(){
		ListObject();
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public ArrayList<String> listperiod() {
		listOfPeriod = new ArrayList<String>();
		listOfPeriod.add("Antiquit�");
		listOfPeriod.add("Moyen Age");
		listOfPeriod.add("Pr�histoire");
		return (ArrayList<String>) listOfPeriod;
	}

	public String addObjectAction(){
		
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
//		listOfPeriod = listperiod();//va charger une liste de p�riode dans le formulaire
//		listOfPeriod = new ArrayList<String>();
//		listOfPeriodId = new ArrayList<Integer>();
		//System.out.println(listP);
		
		/*List list = new ArrayList(collectionPeriods);
//		Gson gson = new Gson();
//		String resultperiod = gson.toJson(listOfPeriods);
//		System.out.println(resultperiod);
		for(int i=0;i<collectionPeriods.size();i++){
//			listOfPeriod.add(listOfPeriods[i])
			Period p=(Period) list.get(i);
			listOfPeriodId.add(p.getId());
			listOfPeriod.add(p.getName());
		}*/
		
		//Collection<ObjectMuseum> listOfPeriodss = objectDao.getLocations();
		
//		listOfPeriodId = new ArrayList<Integer>();
//		listOfPeriodId.add(1);
//		listOfPeriodId.add(2);
//		listOfPeriodId.add(3);
		System.out.println("objet pr�t � �tre ajout�");
		System.out.println("title_f: "+this.title_f);
		System.out.println("desc: "+this.description_f);
		System.out.println("ref: "+this.reference);
		System.out.println("latitude: "+this.latitude);
		System.out.println("longitude: "+this.longitude);
		System.out.println("P�riode: "+this.period);

		if (this.title_e == null){
			this.title_e = this.title_f;
		} 
		if (this.description_e == null){
			this.description_e = this.description_f;
		}
		if(this.title_f!=null){
			ObjectMuseum object = new ObjectMuseum(new Integer(0),this.period, this.title_f,this.title_e,this.country,this.reference,this.description_e,this.description_f,"20","30","89",null,new Date(),this.city, Double.parseDouble(this.latitude), Double.parseDouble(this.longitude));
			objectDao.addObject(object);
			result=1;
			System.out.println("objet ajout�");
		}
		return SUCCESS;
	}
	
	public Photos getPhotosObject() {
		return photosObject;
	}

	public void setPhotosObject(Photos photosObject) {
		this.photosObject = photosObject;
	}

	public String ListObject(){
		ObjectDaoImpl objectDao=new ObjectDaoImpl();
		PeriodDaoImpl periodDao=new PeriodDaoImpl();
		PhotosDaoImpl photosDao=new PhotosDaoImpl();
		
		listObject =new ArrayList<ObjectMuseum>(objectDao.getLocations());
		listObjectPage = new ArrayList<ObjectPage>();
		
		for(ObjectMuseum e:listObject){
			periodObject = periodDao.getPeriod(e.getPeriod_id());
			photosObject = photosDao.getPhotos(e.getPeriod_id());
			ObjectPage objectPage = new ObjectPage(new Integer(0), e.getPeriod_id(), e.getTitle_f(), e.getTitle_e(), e.getCountry(), e.getReference(), e.getDescription_e(), e.getDescription_f(), e.getLength(),e.getHeigth(),e.getWidth(), e.getArcheologist(), e.getDate(),e.getCity(),e.getLatitude(), e.getLongitude(), periodObject.getName(),photosObject.getLink_photos());
			listObjectPage.add(objectPage);
		}
		return city;
	}
	public List<ObjectPage> getListObjectPage() {
		return listObjectPage;
	}

	public void setListObjectPage(List<ObjectPage> listObjectPage) {
		this.listObjectPage = listObjectPage;
	}

	public Period getPeriodObject() {
		return periodObject;
	}

	public void setPeriodObject(Period periodObject) {
		this.periodObject = periodObject;
	}

	public List<Period> getListP() {
		return listP;
	}

	public void setListP(List<Period> listP) {
		this.listP = listP;
	}

	public List<Integer> getListOfPeriodId() {
		return listOfPeriodId;
	}

	public void setListOfPeriodId(List<Integer> listOfPeriodId) {
		this.listOfPeriodId = listOfPeriodId;
	}

	public List<String> getListOfPeriod() {
		return listOfPeriod;
	}


	public void setListOfPeriod(List<String> listOfPeriod) {
		this.listOfPeriod = listOfPeriod;
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