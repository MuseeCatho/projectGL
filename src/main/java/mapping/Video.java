package mapping;


public class Video implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String link_video;
	private int id_object; 	
	private String name_f;
	private String name_e;
	private Boolean showI;
	
	public Video(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getLink_video() {
		return link_video;
	}

	public void setLink_video(String link_video) {
		this.link_video = link_video;
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

	public Video(int id, String link_video, int id_object, String name_f, String name_e, Boolean showI){
		this.id=id;
		this.link_video=link_video; 
		this.id_object=id_object;
		this.name_f=name_f;
		this.name_e=name_e;
		this.showI=showI;
	}
}
