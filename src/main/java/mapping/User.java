package mapping;

import java.util.Date;

/**
 * Model class for Stock
 */
public class User implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	private String firstname;
	private String name;
	private String password;
	private String job;
	private String pseudo;
	private String country;
	private String city;
	private String mail;
	private Integer ban;
	private Integer admin;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getBan() {
		return ban;
	}
	public void setBan(Integer ban) {
		this.ban = ban;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public User(Integer id, String firstname, String name, String password,
			String job, String pseudo, String country, String city,
			String mail, Integer ban, Integer admin) {
		this.id = id;
		this.firstname = firstname;
		this.name = name;
		this.password = password;
		this.job = job;
		this.pseudo = pseudo;
		this.country = country;
		this.city = city;
		this.mail = mail;
		this.ban = ban;
		this.admin = admin;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}