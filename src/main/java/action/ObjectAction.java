package action;

import java.util.Date;

import mapping.ObjectMuseum;

import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;

public class ObjectAction extends ActionSupport{

	/**
	 * 
	 */
	private static ObjectDaoImpl objectDao;
	private String title_f;
	private String title_e;
	private String description_f;
	private String description_e;
	private String country;
	private String city;
	private String reference;
	private String latitude;
	private String longitude;
	private int result;
	
	private static final long serialVersionUID = 1L;

	public String addObjectAction(){
		
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		System.out.println("objet prêt à être ajouté");
		System.out.println("title_f: "+this.title_f);
		System.out.println("desc: "+this.description_f);
		System.out.println("ref: "+this.reference);
		System.out.println("latitude: "+this.latitude);
		System.out.println("longitude: "+this.longitude);
		if (this.title_e == null){
			this.title_e = this.title_f;
		} 
		if (this.description_e == null){
			this.description_e = this.description_f;
		}
		ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3), this.title_f,this.title_e,this.country,this.reference,this.description_e,this.description_f,"20","30","89",null,new Date(),this.city, Double.parseDouble(this.latitude), Double.parseDouble(this.longitude));
		result=1;
		objectDao.addObject(object);
		System.out.println("objet ajouté");
		
		return SUCCESS;
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
	
	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}
	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}

}
