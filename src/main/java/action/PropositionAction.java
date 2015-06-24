package action;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Comment;
import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import mapping.Proposition;
import mapping.User;
import mapping.Video;
import bean.CommentDetail;
import bean.DetailPage;
import bean.PropositionPage;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CommentDaoImpl;
import dao.EnrichmentsDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.PropositionDaoImpl;
import dao.UserDaoImpl;
import dao.VideoDaoImpl;

public class PropositionAction extends ActionSupport {

	private ArrayList listEnrichment;
	private ArrayList<Enrichments>listTotalEnrichments;
	private ArrayList<ObjectMuseum> listObject;
	private ArrayList<ObjectMuseum> listObjectAdmin;
	private ArrayList propositionObject;
	private List arrayListObject;
	private ArrayList<Photos> listPhotos;
	private String photoUnique;
	private int id;
	private Period periodObjectAdmin;
	private List listDetailPageAdmin;
	private List<String> listPhotoAdmin;
	private List<String> listVideoAdmin;
	private ArrayList<Photos> listDetailAdmin;
	private ArrayList<Video> listDetailAdminVideo;
	private ArrayList<Comment> listCommentAdmin;
	private ArrayList<CommentDetail> listCommentAndNameUserAdmin;
	private String periodObjectStringAdmin;
	private String listPhotoStringAdmin;
	private String listVideoStringAdmin;
	private ArrayList<Enrichments> listObjectEnrichment;
	private User listUserId;
	private ArrayList<Proposition> listProposition;
	private int idEnrichment;
	private String result;

	public String showEnrichment() {
		arrayListObject =  new ArrayList();
		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PropositionDaoImpl propositionDao = new PropositionDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		listEnrichment = new ArrayList(enrichmentsDao.getEnrichments());
		listTotalEnrichments = new ArrayList(enrichmentsDao.getTotalEnrichments());

		for (int i=0; i<listEnrichment.size(); i++) {
			listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres((Integer) listEnrichment.get(i)));
			for (ObjectMuseum o : listObject) {
				propositionObject = new ArrayList(propositionDao.getProposition(o.getId()));
				
				
				listPhotos = new ArrayList<Photos>(photosDao.getPhotos((Integer) listEnrichment.get(i)));
				if (listPhotos.size() == 0) {
					for (Photos p : listPhotos) {
						photoUnique = "img/object/autre.jpg";
					}
				} else {
					if (!listPhotos.get(0).getShowI()) {
						photoUnique = listPhotos.get(0).getLink_photos();
					} else {
						photoUnique = "img/object/autre.jpg";
					}
				}
				for(int pro=0; pro<propositionObject.size();pro++){
				PropositionPage propositionPage = new PropositionPage(o.getId(),photoUnique, o.getTitle_f(), o.getTitle_e(), (BigInteger)propositionObject.get(pro));
				arrayListObject.add(propositionPage);
			}
			}
		}

		return SUCCESS;
	}
	
	public String detailEnrichment(){
			ObjectDaoImpl objectDao = new ObjectDaoImpl();
			PeriodDaoImpl periodDao = new PeriodDaoImpl();
			PhotosDaoImpl photosDao = new PhotosDaoImpl();
			VideoDaoImpl videoDao = new VideoDaoImpl();
			CommentDaoImpl commentDao = new CommentDaoImpl();
			UserDaoImpl userDao = new UserDaoImpl();

			listDetailPageAdmin = new ArrayList();
			listVideoAdmin = new ArrayList<String>();
			listPhotoAdmin = new ArrayList<String>();
			listObjectAdmin = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(this.id));
			listDetailAdmin = new ArrayList<Photos>(photosDao.getPhotos(this.id));
			listDetailAdminVideo = new ArrayList<Video>(videoDao.getVideo(this.id));
			listCommentAdmin = new ArrayList<Comment>(
					commentDao.findCommentById(this.id));
			listCommentAndNameUserAdmin = new ArrayList<CommentDetail>();
			if (listCommentAdmin.size() > 0) {
				for (Comment e : listCommentAdmin) {
					CommentDetail commentDetail = new CommentDetail(e.getId(),
							userDao.findUserById(e.getUser_id()).getPseudo(),
							e.getText(), e.getDate(), e.getShow());
					listCommentAndNameUserAdmin.add(commentDetail);
				}
			}

			for (ObjectMuseum e : listObjectAdmin) {

				periodObjectAdmin = periodDao.getPeriodId(this.id);
				for (Photos p : listDetailAdmin) {
					if (!p.getShowI()) {
						listPhotoAdmin.add(p.getLink_photos());
					}
				}
				StringBuilder sb = new StringBuilder();

				for (String str : listPhotoAdmin) {
					sb.append(str).append(","); // separating contents using semi
												// colon
				}

				if (listPhotoAdmin.size() == 0) {
					listPhotoStringAdmin = "img/object/autre.jpg";
				} else {
					listPhotoStringAdmin = sb.toString();
				}

				for (Video v : listDetailAdminVideo) {
					if (!v.getShowI()) {
						listVideoAdmin.add(v.getLink_video());
					}
				}
				StringBuilder sv = new StringBuilder();

				for (String strv : listVideoAdmin) {
					sv.append(strv).append(","); // separating contents using semi
													// colon
				}

				if (listVideoAdmin.size() == 0) {
					listVideoStringAdmin = "img/object/autre.jpg";
				} else {
					listVideoStringAdmin = sv.toString();
				}

				if (periodObjectAdmin == null) {
					periodObjectStringAdmin = "no period";
				} else {
					periodObjectStringAdmin = periodObjectAdmin.getName();
				}
				DetailPage objectPage = new DetailPage(this.id, e.getPeriod_id(),
						e.getTitle_f(), e.getTitle_e(), e.getCountry(),
						e.getReference(), e.getDescription_e(),
						e.getDescription_f(), e.getLength(), e.getHeigth(),
						e.getWidth(), e.getArcheologist(), e.getDate(),
						e.getCity(), e.getLatitude(), e.getLongitude(),
						periodObjectStringAdmin, listPhotoStringAdmin, listVideoStringAdmin);
				listDetailPageAdmin.add(objectPage);
			}
			
			getObjectEnrichments();

		return SUCCESS;
	}
	
	public ArrayList<Video> getListDetailAdminVideo() {
		return listDetailAdminVideo;
	}

	public void setListDetailAdminVideo(ArrayList<Video> listDetailAdminVideo) {
		this.listDetailAdminVideo = listDetailAdminVideo;
	}

	public String getObjectEnrichments(){
		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		listObjectEnrichment = new ArrayList<Enrichments>(enrichmentsDao.getObjectEnrichments(this.id));
		for(Enrichments e:listObjectEnrichment){
		listUserId = userDao.findUserById(e.getUser_id());
		}
		return SUCCESS;
	}
	public String getListProposition(){
		PropositionDaoImpl propositionDao = new PropositionDaoImpl();
		listProposition = new ArrayList<Proposition>(propositionDao.getListProposition(this.idEnrichment));
		Gson gson = new Gson();
		result = gson.toJson(listProposition);
		return SUCCESS;
	}

	public ArrayList getListEnrichment() {
		return listEnrichment;
	}

	public void setListEnrichment(ArrayList listEnrichment) {
		this.listEnrichment = listEnrichment;
	}

	public ArrayList<Enrichments> getListTotalEnrichments() {
		return listTotalEnrichments;
	}

	public void setListTotalEnrichments(ArrayList<Enrichments> listTotalEnrichments) {
		this.listTotalEnrichments = listTotalEnrichments;
	}

	public ArrayList<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(ArrayList<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public ArrayList<ObjectMuseum> getListObjectAdmin() {
		return listObjectAdmin;
	}

	public void setListObjectAdmin(ArrayList<ObjectMuseum> listObjectAdmin) {
		this.listObjectAdmin = listObjectAdmin;
	}

	public ArrayList getPropositionObject() {
		return propositionObject;
	}

	public void setPropositionObject(ArrayList propositionObject) {
		this.propositionObject = propositionObject;
	}

	public List getArrayListObject() {
		return arrayListObject;
	}

	public void setArrayListObject(List arrayListObject) {
		this.arrayListObject = arrayListObject;
	}

	public ArrayList<Photos> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(ArrayList<Photos> listPhotos) {
		this.listPhotos = listPhotos;
	}

	public String getPhotoUnique() {
		return photoUnique;
	}

	public void setPhotoUnique(String photoUnique) {
		this.photoUnique = photoUnique;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Period getPeriodObjectAdmin() {
		return periodObjectAdmin;
	}

	public void setPeriodObjectAdmin(Period periodObjectAdmin) {
		this.periodObjectAdmin = periodObjectAdmin;
	}

	public List getListDetailPageAdmin() {
		return listDetailPageAdmin;
	}

	public void setListDetailPageAdmin(List listDetailPageAdmin) {
		this.listDetailPageAdmin = listDetailPageAdmin;
	}

	public List<String> getListPhotoAdmin() {
		return listPhotoAdmin;
	}

	public void setListPhotoAdmin(List<String> listPhotoAdmin) {
		this.listPhotoAdmin = listPhotoAdmin;
	}

	public List<String> getListVideoAdmin() {
		return listVideoAdmin;
	}

	public void setListVideoAdmin(List<String> listVideoAdmin) {
		this.listVideoAdmin = listVideoAdmin;
	}

	public ArrayList<Photos> getListDetailAdmin() {
		return listDetailAdmin;
	}

	public void setListDetailAdmin(ArrayList<Photos> listDetailAdmin) {
		this.listDetailAdmin = listDetailAdmin;
	}

	public ArrayList<Video> getListDetailVideoAdmin() {
		return listDetailAdminVideo;
	}

	public void setListDetailVideoAdmin(ArrayList<Video> listDetailAdminVideo) {
		this.listDetailAdminVideo = listDetailAdminVideo;
	}

	public ArrayList<Comment> getListCommentAdmin() {
		return listCommentAdmin;
	}

	public void setListCommentAdmin(ArrayList<Comment> listCommentAdmin) {
		this.listCommentAdmin = listCommentAdmin;
	}

	public ArrayList<CommentDetail> getListCommentAndNameUserAdmin() {
		return listCommentAndNameUserAdmin;
	}

	public void setListCommentAndNameUserAdmin(
			ArrayList<CommentDetail> listCommentAndNameUserAdmin) {
		this.listCommentAndNameUserAdmin = listCommentAndNameUserAdmin;
	}

	public String getPeriodObjectStringAdmin() {
		return periodObjectStringAdmin;
	}

	public void setPeriodObjectStringAdmin(String periodObjectStringAdmin) {
		this.periodObjectStringAdmin = periodObjectStringAdmin;
	}

	public String getListPhotoStringAdmin() {
		return listPhotoStringAdmin;
	}

	public void setListPhotoStringAdmin(String listPhotoStringAdmin) {
		this.listPhotoStringAdmin = listPhotoStringAdmin;
	}

	public String getListVideoStringAdmin() {
		return listVideoStringAdmin;
	}

	public void setListVideoStringAdmin(String listVideoStringAdmin) {
		this.listVideoStringAdmin = listVideoStringAdmin;
	}

	public ArrayList<Enrichments> getListObjectEnrichment() {
		return listObjectEnrichment;
	}

	public void setListObjectEnrichment(ArrayList<Enrichments> listObjectEnrichment) {
		this.listObjectEnrichment = listObjectEnrichment;
	}

	public User getListUserId() {
		return listUserId;
	}

	public void setListUserId(User listUserId) {
		this.listUserId = listUserId;
	}

	public int getIdEnrichment() {
		return idEnrichment;
	}

	public void setIdEnrichment(int idEnrichment) {
		this.idEnrichment = idEnrichment;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setListProposition(ArrayList<Proposition> listProposition) {
		this.listProposition = listProposition;
	}
	

	
}
