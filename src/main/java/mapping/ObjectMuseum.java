package mapping;

import java.util.Date;

/**
 * Model class for Stock
 */
public class ObjectMuseum implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	private Integer period_id;
	private String title;
	private String country;
	private String reference;
	private String description;
	private String length;
	private String heigth;
	private String width;
	private String archeologist;
	private Date date;
	private String city;
	
	public ObjectMuseum(Integer id, Integer period_id, String title, String country,
			String reference, String description, String length, String heigth,
			String width, String archeologist, Date date, String city) {
		this.id = id;
		this.period_id = period_id;
		this.title = title;
		this.country = country;
		this.reference = reference;
		this.description = description;
		this.length = length;
		this.heigth = heigth;
		this.width = width;
		this.archeologist = archeologist;
		this.date = date;
		this.city = city;
	}

	
	public ObjectMuseum() {
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPeriod_id() {
		return period_id;
	}
	public void setPeriod_id(Integer period_id) {
		this.period_id = period_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getHeigth() {
		return heigth;
	}
	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getArcheologist() {
		return archeologist;
	}
	public void setArcheologist(String archeologist) {
		this.archeologist = archeologist;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
 
}