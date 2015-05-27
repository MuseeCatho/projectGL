package mapping;

import java.util.Date;

public class Comment implements java.io.Serializable {
	
	private Integer id;
	private Integer user_id;
	private Integer object_id;
	private String text;
	private Date date;
	private Integer show;
	
	public Comment() {
	}
	
	public Comment(Integer id, Integer user_id, Integer object_id, String text,
			Date date,Integer show) {
		this.id = id;
		this.user_id = user_id;
		this.object_id = object_id;
		this.text = text;
		this.date = date;
		this.show=show;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}
	
	
	

}
