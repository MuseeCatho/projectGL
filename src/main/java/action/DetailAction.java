package action;

import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport{

	/**
	 * 
	 */
	private String id;
	
	
	private static final long serialVersionUID = 1L;
	
	public String showdetail(){
		System.out.println("toto");
		System.out.println("id :"+ this.id);
		
		
		return SUCCESS;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
