package mapping;


public class Period implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Integer order;
	private String name;
	private String date;
	private String description_e;
	private String description_f;
	
	
	public Period(int id,String name){
		this.id=id;
		this.name = name;
	}
	public Period(){
		
	}

	public Period(int id,Integer order, String name, String date, String description_e,
			String description_f) {
		this.id = id;
		this.order = order;
		this.name = name;
		this.date = date;
		this.description_e = description_e;
		this.description_f = description_f;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription_e() {
		return description_e;
	}
	public void setDescription_e(String description_e) {
		this.description_e = description_e;
	}
	public String getDescription_f() {
		return description_f;
	}
	public void setDescription_f(String description_f) {
		this.description_f = description_f;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

}
