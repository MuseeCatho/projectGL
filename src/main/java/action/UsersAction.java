package action;

import mapping.User;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDaoImpl;

public class UsersAction extends ActionSupport{

	/**
	 * 
	 */
	private User user;
	private String pseudo;
	private String password;
	private int result;


	


	private static final long serialVersionUID = 1L;

	
	public String signIn(){
	
	UserDaoImpl userDao=new UserDaoImpl();
	System.out.println("signIn - pseudo : "+this.pseudo);
	System.out.println("signIn - password : "+this.password);
	
	user =userDao.findUserAdmin(this.pseudo, this.password);
	//user =userDao.findUserAdmin("roro78220", "AZERTY");
	if(user==null){
		result=0;
	}else{
		result=1;
	}
	System.out.println(result);
	
	
	return SUCCESS;
	}
	


	public void setPassword(String password) {
		this.password = password;
	}



	public int getResult() {
		return result;
	}



	public void setResult(int result) {
		this.result = result;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPasssword(String password) {
		this.password = password;
	}

}
