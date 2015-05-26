package bean;

import java.util.Date;

public class CommentDetail implements java.io.Serializable {
	
	private Integer id;
	private String pseudo;
	private String text;
	private Date date;
	private Integer show;
	
	
	public CommentDetail(Integer id, String pseudo,
			String text, Date date,Integer show) {
		super();
		this.id = id;
		this.pseudo = pseudo;
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
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}

	

}
