package action;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.codec.binary.Base64;

import mapping.Comment;
import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import mapping.Proposition;

import org.apache.commons.io.FileUtils;

import bean.CommentDetail;
import bean.DetailPage;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CommentDaoImpl;
import dao.EnrichmentsDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.PropositionDaoImpl;
import dao.UserDaoImpl;

public class DetailAction extends ActionSupport {

	private int id;
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List listDetailPage;
	private List<String> listPhoto;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listDetail;
	private ArrayList<Comment> listComment;
	private ArrayList<CommentDetail> listCommentAndNameUser;
	private ArrayList<Enrichments> listEnrichments;
	private String periodObjectString;
	private String listPhotoString;

	private Date date;
	private String etat;
	private String type;
	private Integer id_medias;
	private Integer id_enrichments;
	private int user_id;
	private int object_id;
	private String new_description;
	private String source;
	private Object result;
	private String[] uploadFileNames;
	private String[] uploadContentTypes;
	private File[] uploads;
	private ArrayList listImageUpload;

	private static final long serialVersionUID = 1L;

	public String showdetail() {
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		CommentDaoImpl commentDao = new CommentDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		listDetailPage = new ArrayList();
		listPhoto = new ArrayList<String>();
		listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(this.id));
		listDetail = new ArrayList<Photos>(photosDao.getPhotos(this.id));
		listComment = new ArrayList<Comment>(
				commentDao.findCommentById(this.id));
		listCommentAndNameUser = new ArrayList<CommentDetail>();
		if (listComment.size() > 0) {
			for (Comment e : listComment) {
				CommentDetail commentDetail = new CommentDetail(e.getId(),
						userDao.findUserById(e.getUser_id()).getPseudo(),
						e.getText(), e.getDate(), e.getShow());
				listCommentAndNameUser.add(commentDetail);
			}
		}

		for (ObjectMuseum e : listObject) {

			periodObject = periodDao.getPeriodId(this.id);
			for (Photos p : listDetail) {
				listPhoto.add(p.getLink_photos());
			}
			StringBuilder sb = new StringBuilder();

			for (String str : listPhoto) {
				sb.append(str).append(","); // separating contents using semi
											// colon
			}

			if (listPhoto.size() == 0) {
				listPhotoString = "img/object/autre.jpg";
			} else {
				listPhotoString = sb.toString();
			}

			if (periodObject == null) {
				periodObjectString = "no period";
			} else {
				periodObjectString = periodObject.getName();
			}
			DetailPage objectPage = new DetailPage(this.id, e.getPeriod_id(),
					e.getTitle_f(), e.getTitle_e(), e.getCountry(),
					e.getReference(), e.getDescription_e(),
					e.getDescription_f(), e.getLength(), e.getHeigth(),
					e.getWidth(), e.getArcheologist(), e.getDate(),
					e.getCity(), e.getLatitude(), e.getLongitude(),
					periodObjectString, listPhotoString);
			listDetailPage.add(objectPage);
		}

		return SUCCESS;
	}

	public String addProposition() {
		PropositionDaoImpl propositionDao = new PropositionDaoImpl();
		Proposition proposition = new Proposition(new Integer(0), this.etat,
				this.type, this.id_medias, this.id_enrichments);
		propositionDao.insertProposition(proposition);

		return SUCCESS;
	}

	public String addEnrichments() {
		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();
		Enrichments enrichments = new Enrichments(new Integer(0), this.user_id,
				this.object_id, this.new_description, this.source, this.date);
		enrichmentsDao.insertEnrichments(enrichments);
		return SUCCESS;
	}

	public String addMedia() throws Exception {
		this.listImageUpload = new ArrayList();
		//System.out.println(this.listImageUpload);
		for (int i = 0; i < this.listImageUpload.size()+1;i++) {
			
			try {
				/*System.out.println(System.getProperty("user.home"));
				File fichier = new File("/home/amandine/workspace/"
						+ "imageas.jpg");
				PrintWriter out  = new PrintWriter(new FileWriter(fichier));
			     
			        out.println(this.listImageUpload);
			      out.close();*/
			      //ByteArrayOutputStream bos = new ByteArrayOutputStream();
			      byte[] bytes = Base64.decodeBase64(this.listImageUpload.get(i));
			      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			        Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
			        
			        //ImageIO is a class containing static methods for locating ImageReaders
			        //and ImageWriters, and performing simple encoding and decoding. 
			 
			        ImageReader reader = (ImageReader) readers.next();
			        Object source = bis; 
			        ImageInputStream iis = ImageIO.createImageInputStream(source); 
			        reader.setInput(iis, true);
			        ImageReadParam param = reader.getDefaultReadParam();
			 
			        Image image = reader.read(0, param);
			        //got an image file
			 
			        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			        //bufferedImage is the RenderedImage to be written
			 
			        Graphics2D g2 = bufferedImage.createGraphics();
			        g2.drawImage(image, null, null);
			 
			        File imageFile = new File("/home/amandine/workspace/"+ "images.jpg");
			        ImageIO.write(bufferedImage, "jpg", imageFile);
			 
			        System.out.println(imageFile.getPath());
				if (imageFile.createNewFile())
					System.out.println("Le fichier a été créé");
				else
					System.out
							.println("Erreur, Impossible de créer ce fichier");
			} catch (Exception e) {
				System.out.println("Impossible de créer le fichier");
			}
		}

		/*
		 * String link_picture; CategoryDaoImpl categoryDao = new
		 * CategoryDaoImpl(); if(uploadFileNames==null){ //si il n'y a pas de
		 * photo link_picture="img/autre.jpg"; }else{ ServletContext context =
		 * ServletActionContext.getServletContext(); String webroot =
		 * context.getRealPath("/")+"\\src\\main\\webapp\\img\\object";
		 * upload(webroot); link_picture="img/category/"+uploadFileNames[0]; }
		 */
		// Category category =new Category(new
		// Integer(0),this.title_f,this.title_e,link_picture);
		// categoryDao.insertCategory(category);
		return SUCCESS;
	}

	

	public String upload(String path) throws Exception {
		/* write the files in the eclipse repository */
		for (int i = 0; i < uploads.length; i++) {
			File dest = new File(path + "\\" + uploadFileNames[i]);
			FileUtils.copyFile(uploads[i], dest);
		}
		return SUCCESS;
	}

	public String getLastEnrichmentId() {

		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();

		listEnrichments = new ArrayList<Enrichments>(
				enrichmentsDao.getEnrichments());
		Gson gson = new Gson();
		result = gson.toJson(listEnrichments);
		return SUCCESS;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getPeriodObjectString() {
		return periodObjectString;
	}

	public void setPeriodObjectString(String periodObjectString) {
		this.periodObjectString = periodObjectString;
	}

	public String getListPhotoString() {
		return listPhotoString;
	}

	public void setListPhotoString(String listPhotoString) {
		this.listPhotoString = listPhotoString;
	}

	public Date getDate() {
		return date;
	}

	public ArrayList<Enrichments> getListEnrichments() {
		return listEnrichments;
	}

	public void setListEnrichments(ArrayList<Enrichments> listEnrichments) {
		this.listEnrichments = listEnrichments;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId_medias() {
		return id_medias;
	}

	public void setId_medias(Integer id_medias) {
		this.id_medias = id_medias;
	}

	public Integer getId_enrichments() {
		return id_enrichments;
	}

	public void setId_enrichments(Integer id_enrichments) {
		this.id_enrichments = id_enrichments;
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

	public void setListPhoto(List<String> listPhoto) {
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}

	public String getNew_description() {
		return new_description;
	}

	public void setNew_description(String new_description) {
		this.new_description = new_description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String[] getUploadFileNames() {
		return uploadFileNames;
	}

	public void setUploadFileNames(String[] uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public String[] getUploadContentTypes() {
		return uploadContentTypes;
	}

	public void setUploadContentTypes(String[] uploadContentTypes) {
		this.uploadContentTypes = uploadContentTypes;
	}

	public File[] getUploads() {
		return uploads;
	}

	public void setUploads(File[] uploads) {
		this.uploads = uploads;
	}

	public ArrayList getListImageUpload() {
		return listImageUpload;
	}

	public void setListImageUpload(ArrayList listImageUpload) {
		this.listImageUpload = listImageUpload;
	}

}
