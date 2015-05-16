package action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Comment;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.CommentDetail;
import bean.DetailPage;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.UserDaoImpl;

public class DetailAction extends ActionSupport {

	private int id;	
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List listDetailPage;
	private List <String>listPhoto;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listDetail;
	private ArrayList<Comment> listComment;
	private ArrayList<CommentDetail> listCommentAndNameUser;
	private String periodObjectString;
	private String listPhotoString;
	
	private static final long serialVersionUID = 1L;
	
	
	public String showdetail(){
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		CommentDaoImpl commentDao = new CommentDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		listDetailPage = new ArrayList();
		listPhoto = new ArrayList<String>();
		listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(this.id));
		listDetail = new ArrayList<Photos>(photosDao.getPhotos(this.id));
		listComment = new ArrayList<Comment>(commentDao.findCommentById(this.id));
		listCommentAndNameUser=new ArrayList<CommentDetail>();
		if(listComment.size()>0){
			for (Comment e : listComment) {
				CommentDetail commentDetail=new CommentDetail(e.getId(),userDao.findUserById(e.getUser_id()).getPseudo(),e.getText(),e.getDate());
				listCommentAndNameUser.add(commentDetail);
			}
		}
		
		
		for (ObjectMuseum e : listObject) {

			periodObject = periodDao.getPeriodId(this.id);
			for(Photos p:listDetail){
				listPhoto.add(p.getLink_photos());
			}
			StringBuilder sb = new StringBuilder();
			
	        for(String str : listPhoto){
	            sb.append(str).append(","); //separating contents using semi colon
	        }
	      
	        if(listPhoto.size()==0){
	        	listPhotoString = "img/object/autre.jpg";
			}
	        else{
	        	listPhotoString=sb.toString();
	        }
	        
	        if(periodObject==null){
	        	periodObjectString="no period";
	        }
	        else{
		        periodObjectString=periodObject.getName();
	        }
			DetailPage objectPage = new DetailPage(this.id,
					e.getPeriod_id(), e.getTitle_f(), e.getTitle_e(),
					e.getCountry(), e.getReference(), e.getDescription_e(),
					e.getDescription_f(), e.getLength(), e.getHeigth(),
					e.getWidth(), e.getArcheologist(), e.getDate(),
					e.getCity(), e.getLatitude(), e.getLongitude(),
					periodObjectString,	listPhotoString);
			listDetailPage.add(objectPage);
		}
		
		return SUCCESS;
	}

	public String deleteImage(){
		
		/*CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category category=categoryDao.findCategoryById(new Integer(this.id_category));
		categoryDao.deleteCategory(category);*/
		
		return SUCCESS;
	}

	public List getListDetailPage() {
		return listDetailPage;
	}

	public void setListDetailPage(List listDetailPage) {
		this.listDetailPage = listDetailPage;
	}

	public List getListPhoto() {
		return listPhoto;
	}

	public void setListPhoto(List listPhoto) {
		this.listPhoto = listPhoto;
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
	public ArrayList<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}

	public ArrayList<CommentDetail> getListCommentAndNameUser() {
		return listCommentAndNameUser;
	}

	public void setListCommentAndNameUser(
			ArrayList<CommentDetail> listCommentAndNameUser) {
		this.listCommentAndNameUser = listCommentAndNameUser;
	}
	

}
