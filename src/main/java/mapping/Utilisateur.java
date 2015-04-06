package mapping;

import java.util.Date;

/**
 * Model class for Stock
 */
public class Utilisateur implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	private String email;
	private String mot_de_passe;
	//private String nom;
	private Date date_inscription;
 
//	public Utilisateur(Integer id, String email, String mot_de_passe,
//			String nom, Date date_inscription) {
//		this.id = id;
//		this.email = email;
//		this.mot_de_passe = mot_de_passe;
//		this.nom = nom;
//		this.date_inscription = date_inscription;
//	}
//	
	public Utilisateur(Integer id, String email, String mot_de_passe, Date date_inscription) {
		this.id = id;
		this.email = email;
		this.mot_de_passe = mot_de_passe;

		this.date_inscription = date_inscription;
	}
	
	public Utilisateur() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
}