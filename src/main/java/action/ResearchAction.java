package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.ObjectPage;
import mapping.ObjectCategory;
import action.ObjectAction;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.ObjectCategoryDaoImpl;


public class ResearchAction extends ActionSupport{

	private String research;
	private List<ObjectPage> listObjectPage;
	private List<ObjectMuseum> listObject;
	private List<Period> listP;
	private List<Category> listCategory;
	private Collection<Photos> photosObject;
	private ArrayList<Photos> listPhotos;
	private String photoUnique;
	private Period periodObject;
	private ObjectPage object;

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String research(){
		System.out.println("debut recherche");
		if (this.research!=null){
//			ObjectDaoImpl objectDao = new ObjectDaoImpl();
			
			String research_word = this.research;
//			objectDao.getOeuvres(Integer.parseInt(research_word));
//			System.out.println("l'objet à rechercher est "+research_word);
			ObjectDaoImpl objectDao = new ObjectDaoImpl();
			PeriodDaoImpl periodDao = new PeriodDaoImpl();
			PhotosDaoImpl photosDao = new PhotosDaoImpl();

		

			//listObject = new ArrayList<ObjectMuseum>(objectDao.getObjectResearch(research_word));
			listObject = new ArrayList<ObjectMuseum>(objectDao.getLocations());
			listObjectPage = new ArrayList<ObjectPage>();
			

			for (ObjectMuseum e : listObject) {
				listPhotos = new ArrayList<Photos>(photosDao.getPhotos(e.getId()));
				
				if(listPhotos.size()==0){
					for(Photos p:listPhotos){
						photoUnique = "img/object/autre.jpg";
					}
				}
				else{
					photoUnique = listPhotos.get(0).getLink_photos();
				}
				
				periodObject = periodDao.getPeriodId(e.getPeriod_id());
				photosObject = photosDao.getPhotos(e.getPeriod_id());
				ObjectPage objectPage = new ObjectPage(e.getId(),
						e.getPeriod_id(), e.getTitle_f(), e.getTitle_e(),
						e.getCountry(), e.getReference(), e.getDescription_e(),
						e.getDescription_f(), e.getLength(), e.getHeigth(),
						e.getWidth(), e.getArcheologist(), e.getDate(),
						e.getCity(), e.getLatitude(), e.getLongitude(),
						periodObject.getName(), photoUnique);
				listObjectPage.add(objectPage);
			}
		}
		
		return SUCCESS;
	}
}
