package mapping;


public class Proposition implements java.io.Serializable {
	
	private Integer id;
	private String etat;
	private String type;
	private Integer id_medias;
	public Integer getId_medias() {
		return id_medias;
	}
	public void setId_medias(Integer id_medias) {
		this.id_medias = id_medias;
	}
	private Integer id_enrichments;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public Integer getId_enrichments() {
		return id_enrichments;
	}
	public void setId_enrichments(Integer id_enrichments) {
		this.id_enrichments = id_enrichments;
	}
	public Proposition(Integer id, String etat, String type, int id_medias,int id_enrichments){
		this.id=id;
		this.etat=etat;
		this.type=type;
		this.id_medias=id_medias;
		this.id_enrichments=id_enrichments;
		
	}
	public Proposition(){
		
	}

}
