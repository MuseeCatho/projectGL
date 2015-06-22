package bean;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import mapping.ObjectMuseum;

/**
 * Model class for Stock
 */
public class PropositionPage implements java.io.Serializable {

	private int idEnrichments;
	private Object linkPhoto;
	private String title_f;
	private String title_e;
	private BigInteger number;

	public PropositionPage(int idEnrichments, String linkPhoto,String title_f,
			String title_e,  BigInteger number) {
		this.idEnrichments = idEnrichments;
		this.linkPhoto=linkPhoto;
		this.title_f = title_f;
		this.title_e = title_e;
		this.number = number;
	}

	public int getIdEnrichments() {
		return idEnrichments;
	}

	public void setIdEnrichments(int idEnrichments) {
		this.idEnrichments = idEnrichments;
	}

	public Object getLinkPhoto() {
		return linkPhoto;
	}

	public void setLinkPhoto(Object linkPhoto) {
		this.linkPhoto = linkPhoto;
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

	public BigInteger getNumber() {
		return number;
	}

	public void setNumber(BigInteger number) {
		this.number = number;
	}

	




}
