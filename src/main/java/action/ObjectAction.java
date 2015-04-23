package action;

import java.util.Date;

import mapping.ObjectMuseum;

import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;

public class ObjectAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ObjectDaoImpl objectDao;
	
	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}
	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}
	
	public String addObjectAction(){
		
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3),"Livre","Book","BELGIQUE","789898-78","livre representant...","Livre bis","20","30","89",null,new Date(),"Anvers",null,null);
		objectDao.addObject(object);
		System.out.println("objet ajouté");
		
		return SUCCESS;
	}

}
