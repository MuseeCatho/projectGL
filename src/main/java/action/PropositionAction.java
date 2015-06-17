package action;

import java.util.ArrayList;

import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Proposition;
import bean.PropositionPage;

import com.opensymphony.xwork2.ActionSupport;

import dao.EnrichmentsDaoImpl;
import dao.ObjectDaoImpl;
import dao.PropositionDaoImpl;

public class PropositionAction extends ActionSupport {

	private ArrayList<Enrichments> listEnrichment;
	private ArrayList<ObjectMuseum> listObject;
	private Proposition propositionObject;
	private ArrayList arrayListObject;

	public String showEnrichment() {
		EnrichmentsDaoImpl enrichmentsDao = new EnrichmentsDaoImpl();
		ObjectDaoImpl objectDao = new ObjectDaoImpl();
		PropositionDaoImpl propositionDao = new PropositionDaoImpl();
		listEnrichment = new ArrayList<Enrichments>(
				enrichmentsDao.getEnrichments());

		for (Enrichments e : listEnrichment) {
			listObject = new ArrayList<ObjectMuseum>(objectDao.getOeuvres(e
					.getId()));
			propositionObject = propositionDao.getProposition(e.getObject_id());
			for (ObjectMuseum o : listObject) {
				PropositionPage propositionPage = new PropositionPage(
						e.getId(), null, o.getTitle_f(), o.getTitle_e(), e.getDate(), propositionObject.getId_enrichments());
			}
			arrayListObject.add(propositionObject);
		}

		return SUCCESS;
	}

	public PropositionAction() {
	}

	public ArrayList<ObjectMuseum> getListObject() {
		return listObject;
	}

	public void setListObject(ArrayList<ObjectMuseum> listObject) {
		this.listObject = listObject;
	}

	public Proposition getPropositionObject() {
		return propositionObject;
	}

	public void setPropositionObject(Proposition propositionObject) {
		this.propositionObject = propositionObject;
	}

	public ArrayList getArrayListObject() {
		return arrayListObject;
	}

	public void setArrayListObject(ArrayList arrayListObject) {
		this.arrayListObject = arrayListObject;
	}

	public void setListEnrichment(ArrayList<Enrichments> listEnrichment) {
		this.listEnrichment = listEnrichment;
	}

}
