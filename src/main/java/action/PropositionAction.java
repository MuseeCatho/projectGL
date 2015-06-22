package action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Photos;
import mapping.Proposition;
import bean.PropositionPage;

import com.opensymphony.xwork2.ActionSupport;

import dao.EnrichmentsDaoImpl;
import dao.ObjectDaoImpl;
import dao.PhotosDaoImpl;
import dao.PropositionDaoImpl;

public class PropositionAction extends ActionSupport {

	private ArrayList listEnrichment;
	private ArrayList<Enrichments>listTotalEnrichments;
	private ArrayList<ObjectMuseum> listObject;
	private ArrayList propositionObject;
	private List arrayListObject;
	private ArrayList<Photos> listPhotos;
	private String photoUnique;

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
				PropositionPage propositionPage = new PropositionPage((Integer) listEnrichment.get(i),photoUnique, o.getTitle_f(), o.getTitle_e(), (BigInteger)propositionObject.get(pro));
				arrayListObject.add(propositionPage);
			}
			}
		}

		return SUCCESS;
	}

	
	public PropositionAction() {
	}
	
	

	public ArrayList getListEnrichment() {
		return listEnrichment;
	}


	public void setListEnrichment(ArrayList listEnrichment) {
		this.listEnrichment = listEnrichment;
	}


	public ArrayList<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(ArrayList<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public ArrayList<Enrichments> getListTotalEnrichments() {
		return listTotalEnrichments;
	}


	public void setListTotalEnrichments(ArrayList<Enrichments> listTotalEnrichments) {
		this.listTotalEnrichments = listTotalEnrichments;
	}


	public Collection<Proposition> getPropositionObject() {
		return propositionObject;
	}


	public void setPropositionObject(ArrayList propositionObject) {
		this.propositionObject = propositionObject;
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


	public List getArrayListObject() {
		return arrayListObject;
	}


	public void setArrayListObject(List arrayListObject) {
		this.arrayListObject = arrayListObject;
	}

	
	

}
