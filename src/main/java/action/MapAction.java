package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import mapping.ObjectMuseum;

import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;



public class MapAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ObjectDaoImpl objectDao;
	private List<ObjectMuseum> listObject;
	private String result;

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLocation(){
		
		ObjectDaoImpl objectDao=new ObjectDaoImpl();
		listObject =new ArrayList<ObjectMuseum>(objectDao.getLocations());
		
		
		Gson gson = new Gson();
		
		result = gson.toJson(listObject);
		System.out.println(result);
		
		return SUCCESS;
	}
	
	public List<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public void insert(){
		ObjectDaoImpl objectDao=new ObjectDaoImpl();
		ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);
		objectDao.insert(object);
	}


	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}



	public static void setObjectDao(ObjectDaoImpl objectDao) {
		MapAction.objectDao = objectDao;
	}
	
}
