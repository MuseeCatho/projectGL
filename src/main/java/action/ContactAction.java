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
	private String id;
	private String address;
	private String phone;
	private String mail;
	private String access;
	private String schedule;
	private String presentation_e;
	private String presentation_f;
	
	
	

	public String getInfoContact(){
		ContactDaoImpl contactDao = new ContactDaoImpl();
		listMuseum= new ArrayList(contactDao.getInfoMuseum());
		return SUCCESS;
	}
	
	public String updateContact(){
		
		ContactDaoImpl contactDao = new ContactDaoImpl();
		Museum museum=new Museum(new Integer (1),this.address,this.phone,this.mail,this.access,this.schedule,this.presentation_e,this.presentation_f);
		contactDao.updateContact(museum);
		return SUCCESS;
	}
	

	public List<Museum> getListMuseum() {
		return listMuseum;
	}

	public void setListMuseum(List<Museum> listMuseum) {
		this.listMuseum = listMuseum;
	}

	public String getPresentation_e() {
		return presentation_e;
	}

	public void setPresentation_e(String presentation_e) {
		this.presentation_e = presentation_e;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPresentation_f() {
		return presentation_f;
	}

	public void setPresentation_f(String presentation_f) {
		this.presentation_f = presentation_f;
	}
	

}