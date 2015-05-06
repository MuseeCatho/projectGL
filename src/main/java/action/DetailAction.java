package action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.DetailPage;

import com.opensymphony.xwork2.ActionSupport;

import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;

public class DetailAction extends ActionSupport {

	private int id;	
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List<DetailPage> listDetailPage;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listDetail;
	
	private static final long serialVersionUID = 1L;
	
	
	public String showdetail(){
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();

		listDetailPage = new ArrayList<DetailPage>();
		listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(this.id));
		listDetail = new ArrayList<Photos>(photosDao.getPhotos(this.id));

		for (ObjectMuseum e : listObject) {
			String photoUnique = listDetail.get(0).getLink_photos();
			periodObject = periodDao.getPeriodId(e.getPeriod_id());
			photosObject = photosDao.getPhotos(e.getPeriod_id());
			DetailPage objectPage = new DetailPage(this.id,
					e.getPeriod_id(), e.getTitle_f(), e.getTitle_e(),
					e.getCountry(), e.getReference(), e.getDescription_e(),
					e.getDescription_f(), e.getLength(), e.getHeigth(),
					e.getWidth(), e.getArcheologist(), e.getDate(),
					e.getCity(), e.getLatitude(), e.getLongitude(),
					periodObject.getName(), photoUnique);
			listDetailPage.add(objectPage);
		}
		
		return SUCCESS;
	}


	public List<DetailPage> getListDetailPage() {
		return listDetailPage;
	}


	public void setListDetailPage(List<DetailPage> listDetailPage) {
		this.listDetailPage = listDetailPage;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<ObjectMuseum> getListObject() {
		return listObject;
	}


	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}


	public Period getPeriodObject() {
		return periodObject;
	}


	public void setPeriodObject(Period periodObject) {
		this.periodObject = periodObject;
	}


	public List<DetailPage> getListObjectPage() {
		return listDetailPage;
	}


	public void setListObjectPage(List<DetailPage> listObjectPage) {
		this.listDetailPage = listObjectPage;
	}


	public Collection<Photos> getPhotosObject() {
		return photosObject;
	}


	public void setPhotosObject(Collection<Photos> photosObject) {
		this.photosObject = photosObject;
	}


	public ArrayList<Photos> getListDetail() {
		return listDetail;
	}


	public void setListDetail(ArrayList<Photos> listDetail) {
		this.listDetail = listDetail;
	}
	

}
