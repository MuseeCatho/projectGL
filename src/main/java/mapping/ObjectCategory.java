package mapping;


public class ObjectCategory implements java.io.Serializable {
	
	private Integer id;
	private Integer object_id;
	private Integer category_id;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getObject_id() {
		return object_id;
	}
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public ObjectCategory(int object_id, int category_id){
		this.object_id = object_id;
		this.category_id= category_id;
		
		
	}
	public ObjectCategory(){
		
	}

}
