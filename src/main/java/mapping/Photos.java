package mapping;


public class Photos implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String link_photos;
	private int id_object; 	
	private String name_f;
	private String name_e;
	private Boolean showI;
	
	public Photos(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getLink_photos() {
		return link_photos;
	}

	public void setLink_photos(String link_photos) {
		this.link_photos = link_photos;
	}

	public int getId_object() {
		return id_object;
	}

	public void setId_object(int id_object) {
		this.id_object = id_object;
	}

	public String getName_f() {
		return name_f;
	}

	public void setName_f(String name_f) {
		this.name_f = name_f;
	}

	public String getName_e() {
		return name_e;
	}

	public void setName_e(String name_e) {
		this.name_e = name_e;
	}

	public Boolean getShowI() {
		return showI;
	}

	public void setShowI(Boolean showI) {
		this.showI = showI;
	}

	public Photos(int id, String link_photos, int id_object, String name_f, String name_e, Boolean showI){
		this.id=id;
		this.link_photos=link_photos; 
		this.id_object=id_object;
		this.name_f=name_f;
		this.name_e=name_e;
		this.showI=showI;
	}
}
