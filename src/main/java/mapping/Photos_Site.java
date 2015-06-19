package mapping;


public class Photos_Site implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String link_photo;
	
	
	public Photos_Site(int id, String name, String link_photo) {
		super();
		this.id = id;
		this.name = name;
		this.link_photo = link_photo;
	}
	
	public Photos_Site() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink_photo() {
		return link_photo;
	}
	public void setLink_photo(String link_photo) {
		this.link_photo = link_photo;
	}
	
}
