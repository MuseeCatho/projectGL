package mapping;

import java.util.Date;

public class Enrichments implements java.io.Serializable {
	
	private Integer id;
	private Integer user_id;
	private Integer object_id;
	private String new_description;
	private String source;
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getObject_id() {
		return object_id;
	}
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}
	public String getNew_description() {
		return new_description;
	}
	public void setNew_description(String new_description) {
		this.new_description = new_description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Enrichments(int id, int user_id, int object_id, String new_description, String source, Date date){
		this.id=id;
		this.user_id=user_id;
		this.object_id=object_id;
		this.new_description=new_description;
		this.source=source;
		this.date=date;
	}
	public Enrichments(){
		
	}

}
