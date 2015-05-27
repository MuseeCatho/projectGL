package action.admin;

import com.opensymphony.xwork2.ActionSupport;

public class Navigation extends ActionSupport{
	String pageName;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String execute(){
		System.out.println("pageName : " + pageName);
		return SUCCESS;
	}
}
