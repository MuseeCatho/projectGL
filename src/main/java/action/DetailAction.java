package action;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLDecoder;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import javax.servlet.ServletContext;

import mapping.Category;
import mapping.Comment;
import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import mapping.Proposition;
import mapping.Video;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import bean.CommentDetail;
import bean.DetailPage;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.EnrichmentsDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.PropositionDaoImpl;
import dao.UserDaoImpl;
import dao.VideoDaoImpl;

public class DetailAction extends ActionSupport {

	private int id;
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List listDetailPage;
	private List<String> listPhoto;
	private List<String> listVideo;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listDetail;
	private ArrayList<Video> listDetailVideo;
	private ArrayList<Comment> listComment;
	private ArrayList<CommentDetail> listCommentAndNameUser;
	private ArrayList<Enrichments> listLastEnrichments;
	private ArrayList<Photos> listPhotos;
	private String periodObjectString;
	private String listPhotoString;
	private String listVideoString;

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
	private String listImageUploadS;
	private String name_f;
	private String name_e;
	private Boolean showI;
	private static String link;
	private String paramValue;
	private static Integer idPage;

	public Integer getIdPage() {
		return idPage;
	}

	public void setIdPage(Integer idPage) {
		this.idPage = idPage;
	}

	private static final long serialVersionUID = 1L;

	public String showdetail() {
		setIdPage(this.id);
		System.out.println(getIdPage());
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		VideoDaoImpl videoDao = new VideoDaoImpl();
		CommentDaoImpl commentDao = new CommentDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		listDetailPage = new ArrayList();
		listVideo = new ArrayList<String>();
		listPhoto = new ArrayList<String>();
		listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(this.id));
		listDetail = new ArrayList<Photos>(photosDao.getPhotos(this.id));
		listDetailVideo = new ArrayList<Video>(videoDao.getVideo(this.id));
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
				if (!p.getShowI()) {
					listPhoto.add(p.getLink_photos());
				}
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

			for (Video v : listDetailVideo) {
				if (!v.getShowI()) {
					listVideo.add(v.getLink_video());
				}
			}
			StringBuilder sv = new StringBuilder();

			for (String strv : listVideo) {
				sv.append(strv).append(","); // separating contents using semi
												// colon
			}

			if (listVideo.size() == 0) {
				listVideoString = "img/object/autre.jpg";
			} else {
				listVideoString = sv.toString();
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
					periodObjectString, listPhotoString, listVideoString);
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

	public String addPhotos() throws Exception {
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		Photos photos = new Photos(new Integer(0), this.getLink(),
				this.object_id, this.name_f, this.name_e, this.showI);
		photosDao.insertPhotos(photos);
		return SUCCESS;
	}

	public BufferedImage decodeToImage() {
		BufferedImage image = null;
		byte[] imageByte;
		try {
			String[] base64Image = this.listImageUploadS.split(",");
			String base64ImageDecode = base64Image[1];
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(base64ImageDecode);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	public String addMedia() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss.SSS");
		String date = sdf.format(new Date());
		this.setLink("img/object/" + date + "images.jpg");
		BufferedImage newImg;
		String imgstr;
		newImg = decodeToImage();

		ImageIO.write(newImg, "jpg", new File(System.getProperty("user.home")
				+ "/workspace/projectGL/src/main/webapp/" + link));
		return SUCCESS;
	}

	public String getLastEnrichmentId() {

		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();

		listLastEnrichments = new ArrayList<Enrichments>(enrichmentsDao.getLastEnrichments());
		Gson gson = new Gson();
		result = gson.toJson(listLastEnrichments);
		return SUCCESS;
	}

	public String getLastPhotosId() {

		PhotosDaoImpl photosDao = new PhotosDaoImpl();

		listPhotos = new ArrayList<Photos>(photosDao.getLastPhotos());
		Gson gson = new Gson();
		result = gson.toJson(listPhotos);
		return SUCCESS;
	}
	
	/*public String execute(){System.out.println(this.id);
	    setParamValue(Integer.toString(this.id));
	    return SUCCESS; 
	}*/

	public String addVideo() throws Exception {
		String webroot;
		
		if (uploadFileNames == null) { // si il n'y a pas de photo
			webroot = "img/category/other.jpg";
		} else {
			webroot = "video" + File.separatorChar + uploadFileNames[0];
			String webrootAbsolut = getPath() + File.separatorChar + webroot;
			upload(webrootAbsolut);
		}
		System.out.println(webroot);
		
		VideoDaoImpl videoDao = new VideoDaoImpl();
		Video video =new Video(new Integer(0),webroot, 1,"As","As",true);
		videoDao.insertVideos(video);

		return SUCCESS;
	}

	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println("fullPath " + fullPath);
		System.out.println("pathArr " + pathArr[0]);
		fullPath = pathArr[0];

		String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath();
		System.out.println("response Path " + reponsePath);
		return reponsePath;
	}

	public void upload(String path) throws Exception {
		/* write the files in the eclipse repository */
		System.out.println("\n\n upload2");
		System.out.println("files:");
		for (int i = 0; i < uploads.length; i++) {
			System.out
					.println("*** " + uploads[i] + "\t" + uploads[i].length());
			File dest = new File(path);
			FileUtils.copyFile(uploads[i], dest);
		}
		System.out.println("filenames:");
		for (String n : uploadFileNames) {
			System.out.println("*** " + n);
		}
		System.out.println("content types:");
		for (String c : uploadContentTypes) {
			System.out.println("*** " + c);
		}
		System.out.println("\n\n");
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

	public ArrayList<Enrichments> getlistLastEnrichments() {
		return listLastEnrichments;
	}

	public void setlistLastEnrichments(ArrayList<Enrichments> listLastEnrichments) {
		this.listLastEnrichments = listLastEnrichments;
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

	public String getListImageUploadS() {
		return listImageUploadS;
	}

	public void setListImageUploadS(String listImageUploadS) {
		this.listImageUploadS = listImageUploadS;
	}

	public String getName_f() {
		return name_f;
	}

	public void setName_f(String name_f) {
		this.name_f = name_f;
	}

	public String getName_e() {
		return name_e;
	}

	public void setName_e(String name_e) {
		this.name_e = name_e;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getShowI() {
		return showI;
	}

	public void setShowI(Boolean showI) {
		this.showI = showI;
	}

	public List<String> getListVideo() {
		return listVideo;
	}

	public void setListVideo(List<String> listVideo) {
		this.listVideo = listVideo;
	}

	public ArrayList<Video> getListDetailVideo() {
		return listDetailVideo;
	}

	public void setListDetailVideo(ArrayList<Video> listDetailVideo) {
		this.listDetailVideo = listDetailVideo;
	}

	public ArrayList<Photos> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(ArrayList<Photos> listPhotos) {
		this.listPhotos = listPhotos;
	}

	public String getListVideoString() {
		return listVideoString;
	}

	public void setListVideoString(String listVideoString) {
		this.listVideoString = listVideoString;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	

	
}
