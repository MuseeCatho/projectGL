package action;

import java.util.Map;

import mapping.User;

import com.opensymphony.xwork2.ActionContext;
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
	private int admin;


	


	private static final long serialVersionUID = 1L;

	
	public String signIn(){
	
	UserDaoImpl userDao=new UserDaoImpl();
	System.out.println("signIn - pseudo : "+this.pseudo);
	System.out.println("signIn - password : "+this.password);
	System.out.println("signIn - admin : "+this.admin);
	
	user =userDao.findUserAdmin(this.pseudo, this.password,this.admin);
	//user =userDao.findUserAdmin("roro78220", "AZERTY");
		if(user==null){
			result=0;
		}else{
			Map session = ActionContext.getContext().getSession();
			session.put("id_user", user.getId());
			session.put("firstname", user.getFirstname());
			result=1;
		}
	System.out.println(result);
	
	
	return SUCCESS;
	}
	
	 public String logout() throws Exception {
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//session.removeAttribute("logined");
		//session.removeAttribute("context"); 
		Map session = ActionContext.getContext().getSession();
		session.remove("id_user");
       session.remove("firstname");
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
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
