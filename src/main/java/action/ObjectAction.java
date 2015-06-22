package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.Comment;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.ObjectPage;
import mapping.ObjectCategory;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.ObjectCategoryDaoImpl;

import com.google.gson.Gson;

public class ObjectAction extends ActionSupport {

	private static ObjectDaoImpl objectDao;
	private int id;
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
			result = 1;
			System.out.println("objet ajout�");

		}
		return SUCCESS;
	}
	
	public String deleteObject(){
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		ObjectMuseum object=objectDao.findObjectById(this.id);
		objectDao.deleteObject(object);
		result=1;
		return SUCCESS;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
