package mapping;

import java.util.Date;

public class Proposition implements java.io.Serializable {
	
	private Integer id;
	private Date date;
	private String etat;
	private String type;
	private Integer id_audio;
	private Integer id_photos;
	private Integer id_videos;
	private Integer id_enrichments;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId_audio() {
		return id_audio;
	}
	public void setId_audio(Integer id_audio) {
		this.id_audio = id_audio;
	}
	public Integer getId_photos() {
		return id_photos;
	}
	public void setId_photos(Integer id_photos) {
		this.id_photos = id_photos;
	}
	public Integer getId_videos() {
		return id_videos;
	}
	public void setId_videos(Integer id_videos) {
		this.id_videos = id_videos;
	}
	public Integer getId_enrichments() {
		return id_enrichments;
	}
	public void setId_enrichments(Integer id_enrichments) {
		this.id_enrichments = id_enrichments;
	}
	public Proposition(Integer id, Date date, String etat, String type, int id_audio, int id_photos, int id_videos, int id_enrichments){
		this.id=id;
		this.date=date;
		this.etat=etat;
		this.type=type;
		this.id_audio=id_audio;
		this.id_photos=id_photos;
		this.id_videos=id_videos;
		this.id_enrichments=id_enrichments;
		
	}
	public Proposition(){
		
	}

}
