package bean;

import java.util.Date;

public class CommentDetail implements java.io.Serializable {
	
	private Integer id;
	private String pseudo;
	private String text;
	private Date date;
	
	
	public CommentDetail(Integer id, String pseudo,
			String text, Date date) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.text = text;
		this.date = date;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	

}
