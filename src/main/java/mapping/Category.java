package mapping;

public class Category implements java.io.Serializable {
	
	private Integer id;
	private String name_f;
	private String name_e;
	private String link_category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getLink_category() {
		return link_category;
	}
	public void setLink_category(String link_category) {
		this.link_category = link_category;
	}
	
	public Category(int id, String name_f, String name_e, String link_category){
		this.id=id;
		this.name_f= name_f;
		this.name_e=name_e;
		this.link_category=link_category;
		
	}
	public Category(){
		
	}

}
