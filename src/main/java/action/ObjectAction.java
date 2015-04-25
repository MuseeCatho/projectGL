package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private List<String> listPeriod;
	private String period;
	
	private static final long serialVersionUID = 1L;

	
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
	
	public List<String> getListPeriod() {
		return listPeriod;
	}
	public void setListPeriod(List<String> listPeriod) {
		this.listPeriod = listPeriod;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDefaultSearchEngine() {
		return "Moyen Age";
	}

	private int result;

	
	
	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}
	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}
	
	public String addObjectAction(){
		
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		System.out.println("objet prêt à être ajouté");
		System.out.println("title_f: "+this.title_f);
		System.out.println("desc: "+this.description_f);
		System.out.println("ref: "+this.reference);
		if (this.title_e == null){
			this.title_e = this.title_f;
		} 
		if (this.description_e == null){
			this.description_e = this.description_f;
		}
		if(this.title_f!=null){
			ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3), this.title_f,this.title_e,this.country,this.reference,this.description_e,this.description_f,"20","30","89",null,new Date(),this.city,null,null);
			objectDao.addObject(object);
			result=1;
			System.out.println("objet ajouté");
			this.title_f=null;
		}
			
		
		
	
		
		return SUCCESS;
	}
	
//	public void SelectAction(){
//		 
//		listPeriod = new ArrayList<String>();
//		listPeriod.add("Préhistoire");
//		listPeriod.add("Antiquité");
//		listPeriod.add("Moyen-Age");
//		listPeriod.add("Temps Moderne");
//		
//	}
//	
//	public String display() {
//		return NONE;
//	}
//	public String execute() {
//		return SUCCESS;
//	}
}
