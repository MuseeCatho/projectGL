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
	private String description_f;
	private String reference;
	private static final long serialVersionUID = 1L;

	
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
		/*if (this.title_f==null || this.title_e==null){
			this.title_f="NULL";
			this.title_e="NULL";
		}*/
		ObjectMuseum object = new ObjectMuseum(new Integer(0),new Integer(3), this.title_f,"Book","BELGIQUE",this.reference,this.description_f,"Livre bis","20","30","89",null,new Date(),"Anvers",null,null);
		result=1;
		objectDao.addObject(object);
		System.out.println("objet ajouté");
		
		return SUCCESS;
	}

}
