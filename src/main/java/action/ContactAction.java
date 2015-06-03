package action;

import java.util.ArrayList;
import java.util.List;

import mapping.Category;
import mapping.Museum;
import mapping.ObjectMuseum;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.ContactDaoImpl;
import dao.PropositionDaoImpl;

public class ContactAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Museum> listMuseum;
	
	

	public String getInfoContact(){
		ContactDaoImpl contactDao = new ContactDaoImpl();
		listMuseum= new ArrayList(contactDao.getInfoMuseum());
		
		return SUCCESS;
	}

	public List<Museum> getListMuseum() {
		return listMuseum;
	}

	public void setListMuseum(List<Museum> listMuseum) {
		this.listMuseum = listMuseum;
	}

}
