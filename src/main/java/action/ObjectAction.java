package action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import mapping.Category;
import mapping.Comment;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import mapping.Photos_Site;
import bean.ObjectPage;
import mapping.ObjectCategory;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.ObjectCategoryDaoImpl;
import dao.PhotosSiteDaoImpl;

import com.google.gson.Gson;

public class ObjectAction extends ActionSupport {

	private static ObjectDaoImpl objectDao;
	private String title_f;
	private String title_e;
	private String description_f;
	private String description_e;
	private String country;
	private String city;
	private String reference;
	private Integer period;
	private String latitude;
	private String longitude;
	private List<Period> listP;
	private List<Category> listCategory;
	private String categories;
	private int result;
	private List<ObjectMuseum> listObject;
	private Period periodObject;
	private List<ObjectPage> listObjectPage;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listPhotos;
	private String photoUnique;
	private String orderObject;
	private String file1;
	private File[] uploads;
    private String[] uploadFileNames;
    private String[] uploadContentTypes;

	public ObjectAction() {
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String addObjectAction() {

		PeriodDaoImpl periods = new PeriodDaoImpl();
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		CategoryDaoImpl categories = new CategoryDaoImpl();

		listP = new ArrayList<Period>();
		listP = (List<Period>) periods.getPeriod();

		listCategory = new ArrayList<Category>();
		listCategory = (List<Category>) categories.getCategory();

		System.out.println("objet pr�t � �tre ajout�");
		System.out.println("title_f: " + this.title_f);
		System.out.println("desc: " + this.description_f);
		System.out.println("ref: " + this.reference);
		System.out.println("latitude: " + this.latitude);
		System.out.println("longitude: " + this.longitude);
		System.out.println("P�riode: " + this.period);
		System.out.println("Categories: " + this.categories);

		if (this.title_e == null) {

			this.title_e = this.title_f;
		}
		if (this.description_e == null) {
			this.description_e = this.description_f;
		}

		if (this.title_f != null) {
			ArrayList<String> listCatIdStr = new ArrayList<String>(
					Arrays.asList(this.categories.split(",")));
			ArrayList<Integer> listCatId = new ArrayList<Integer>();
			for (String s : listCatIdStr)
				listCatId.add(Integer.valueOf(s));// conversion de la liste
													// string en int
			System.out.println("lcid:" + listCatId.get(0));
			ObjectMuseum object = new ObjectMuseum(new Integer(0), this.period,
					this.title_f, this.title_e, this.country, this.reference,
					this.description_e, this.description_f, "20", "30", "89",
					null, new Date(), this.city,
					Double.parseDouble(this.latitude),
					Double.parseDouble(this.longitude));
			objectDao.addObject(object);
			System.out.println("id objet :" + object.getId());
			ObjectCategoryDaoImpl objCat = new ObjectCategoryDaoImpl();
			objCat.insertCategoryOfObject(listCatId, object.getId());
			PhotosDaoImpl photoSiteDao = new PhotosDaoImpl();
			String webroot;
			System.out.println(this.file1);
			System.out.println(this.uploadFileNames);
			if(this.uploadFileNames!=null){
				webroot="img"+File.separatorChar+this.uploadFileNames[0];
				Photos photos=new Photos(new Integer(1), webroot,object.getId(),"","",true);
				photoSiteDao.insertPhotos(photos);
			}
			

			/*String webrootAbsolut = getPath()+File.separatorChar+webroot;
			upload(webrootAbsolut);
			Photos_Site entity =new Photos_Site(new Integer(1),"photo presentation",webroot);
			if(photoSite==null){
				photoSiteDao.insertPhotoPresentation(entity);
			}else{
				photoSiteDao.updatePhotoPresentation(entity);
			}*/
			result = 1;
			System.out.println("objet ajout�");

		}
		return SUCCESS;
	}


    public void upload(String path) throws Exception {
    	/* write the files in the eclipse repository */
        System.out.println("\n\n upload2");
        System.out.println("files:");
        for(int i = 0; i < uploads.length; i++) {
            System.out.println("*** " + uploads[i] + "\t" + uploads[i].length());
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
    public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println("fullPath " + fullPath);
		System.out.println("pathArr "+ pathArr[0]);
		fullPath = pathArr[0];
		
		String reponsePath = "";
// to read a file from webcontent
		reponsePath = new File(fullPath).getPath();
		System.out.println("response Path "+reponsePath);
		return reponsePath;
	}
    public File[] getUpload() {
        return this.uploads;
    }
    public void setUpload(File[] upload) {
        this.uploads = upload;
    }
    public String[] getUploadFileName() {
        return this.uploadFileNames;
    }
    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileNames = uploadFileName;
    }
    public String[] getUploadContentType() {
        return this.uploadContentTypes;
    }
    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentTypes = uploadContentType;
    }

	public String getCategories() {
		return categories;
	}

	public String listObject() {

		ObjectDaoImpl objectDao = new ObjectDaoImpl();

		listObject = new ArrayList<ObjectMuseum>(objectDao.getLocations());
		listObjectPage = new ArrayList<ObjectPage>();

		PeriodDaoImpl periods = new PeriodDaoImpl();
		listP = new ArrayList<Period>();
		listP = (List<Period>) periods.getPeriod();

		CategoryDaoImpl categories = new CategoryDaoImpl();
		listCategory = new ArrayList<Category>();
		listCategory = (List<Category>) categories.getCategory();

		createListObject(listObject, listPhotos, photoUnique, periodObject,
				photosObject, listObjectPage, this.orderObject);

		return SUCCESS;
	}

	public static void createListObject(List<ObjectMuseum> listObject2,
			ArrayList<Photos> listPhotos, String photoUnique,
			Period periodObject, Collection<Photos> photosObject,
			List<ObjectPage> listObjectPage, String orderObject) {

		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		PhotosDaoImpl photosDao = new PhotosDaoImpl();
		CommentDaoImpl commentDao = new CommentDaoImpl();
		for (ObjectMuseum e : listObject2) {
			listPhotos = new ArrayList<Photos>(photosDao.getPhotos(e.getId()));

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
			// liste des commentaires

			List<Comment> listComment = new ArrayList<Comment>(
					commentDao.findCommentByIdObjectByShow(
							new Integer(e.getId()), new Integer(0)));

			periodObject = periodDao.getPeriodId(e.getPeriod_id());
			photosObject = photosDao.getPhotos(e.getPeriod_id());
			ObjectPage objectPage = new ObjectPage(e.getId(), e.getPeriod_id(),
					e.getTitle_f(), e.getTitle_e(), e.getCountry(),
					e.getReference(), e.getDescription_e(),
					e.getDescription_f(), e.getLength(), e.getHeigth(),
					e.getWidth(), e.getArcheologist(), e.getDate(),
					e.getCity(), e.getLatitude(), e.getLongitude(),
					periodObject.getName(), photoUnique, listComment.size());
			listObjectPage.add(objectPage);

		}
		// on trie par nombre de commentaire
		if (orderObject != null) {
			Collections.sort(listObjectPage);
			Collections.reverse(listObjectPage);
		}
	}

	public String detailObject() {

		return SUCCESS;
	}

	public List<ObjectPage> getListObjectPage() {
		return listObjectPage;
	}

	public void setListObjectPage(List<ObjectPage> listObjectPage) {
		this.listObjectPage = listObjectPage;
	}

	public Period getPeriodObject() {
		return periodObject;
	}

	public void setPeriodObject(Period periodObject) {
		this.periodObject = periodObject;
	}

	public List<Period> getListP() {
		return listP;
	}

	public void setListP(List<Period> listP) {
		this.listP = listP;
	}

	public String getDescription_e() {
		return description_e;
	}

	public void setDescription_e(String description_e) {
		this.description_e = description_e;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTitle_f() {
		return title_f;
	}

	public void setTitle_f(String title_f) {
		this.title_f = title_f;
	}

	public String getTitle_e() {
		return title_e;
	}

	public void setTitle_e(String title_e) {
		this.title_e = title_e;
	}

	public String getDescription_f() {
		return description_f;
	}

	public void setDescription_f(String description_f) {
		this.description_f = description_f;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getDefaultSearchEngine() {
		return "Moyen Age";
	}

	public String getLatitude() {
		return latitude;

	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(List<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public static ObjectDaoImpl getObjectDao() {
		return objectDao;
	}

	public static void setObjectDao(ObjectDaoImpl objectDao) {
		ObjectAction.objectDao = objectDao;
	}

	public String getOrderObject() {
		return orderObject;
	}

	public void setOrderObject(String orderObject) {
		this.orderObject = orderObject;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public List<ObjectMuseum> getListOeuvre() {
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		listObject = new ArrayList<ObjectMuseum>(objectDao.getLocations());
		ArrayList list = new ArrayList();
		return list;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public Collection<Photos> getPhotosObject() {
		return photosObject;
	}

	public void setPhotosObject(Collection<Photos> photosObject) {
		this.photosObject = photosObject;
	}

	public File[] getUploads() {
		return uploads;
	}

	public void setUploads(File[] uploads) {
		this.uploads = uploads;
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

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}
	
	
	
	
	
	

}

/*
 * package action;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.UnsupportedEncodingException; import java.security.Principal; import
 * java.util.ArrayList; import java.util.Collection; import
 * java.util.Enumeration; import java.util.List; import java.util.Locale; import
 * java.util.Map;
 * 
 * import javax.servlet.DispatcherType; import javax.servlet.RequestDispatcher;
 * import javax.servlet.ServletContext; import javax.servlet.ServletException;
 * import javax.servlet.ServletInputStream; import javax.servlet.ServletRequest;
 * import javax.servlet.ServletResponse; import javax.servlet.http.Cookie;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession; import javax.servlet.http.Part;
 * 
 * import org.apache.struts2.interceptor.ServletRequestAware;
 * 
 * import mapping.ObjectMuseum;
 * 
 * import com.google.gson.Gson; import com.opensymphony.xwork2.ActionSupport;
 * 
 * import dao.ObjectDaoImpl;
 * 
 * public class ObjectAction extends ActionSupport{ private static ObjectDaoImpl
 * objectDao; private List<ObjectMuseum> listObject;
 * 
 * public ObjectAction(){ getListOeuvre(); }
 * 
 * public List<ObjectMuseum> getListOeuvre(){
 * 
 * ObjectDaoImpl objectDao=new ObjectDaoImpl(); listObject =new
 * ArrayList<ObjectMuseum>(objectDao.getLocations()); ArrayList list = new
 * ArrayList();
 * 
 * for (ObjectMuseum e: listObject) {
 * 
 * System.out.println(e); } return list; }
 * 
 * 
 * 
 * public List<ObjectMuseum> getListObject() { return listObject; }
 * 
 * public void setListObject(List<ObjectMuseum> listObject) { this.listObject =
 * listObject; }
 * 
 * 
 * 
 * public static ObjectDaoImpl getObjectDao() { return objectDao; }
 * 
 * 
 * 
 * public static void setObjectDao(ObjectDaoImpl objectDao) {
 * ObjectAction.objectDao = objectDao; }
 * 
 * 
 * 
 * }
 */
