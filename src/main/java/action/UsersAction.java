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
	private String firstname;
	private String name;
	private String email;
	private String country;
	private String city;
	private String job;	
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
	
	 public String logOut() throws Exception {
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//session.removeAttribute("logined");
		//session.removeAttribute("context"); 
		Map session = ActionContext.getContext().getSession();
		session.remove("id_user");
       session.remove("firstname");
       return SUCCESS;
   }
	 
	 public String addUser() throws Exception {
		 UserDaoImpl userDao=new UserDaoImpl();
		 
		 System.out.println("addUser - pseudo : "+this.pseudo);
		 System.out.println("addUser - password : "+this.password);
		 System.out.println("addUser - name : "+this.name);
		 System.out.println("addUser - firstname : "+this.firstname);
		 System.out.println("addUser - email : "+this.email);
		 System.out.println("addUser - country : "+this.country);
		 System.out.println("addUser - city : "+this.city);
		 System.out.println("addUser - job : "+this.job);
		 
		 User user = new User(new Integer(0), this.firstname, this.name, this.password,this.job, this.pseudo, this.country, this.city,this.email, new Integer(0), new Integer(0));
		 userDao.insertUser(user);
		 
		 result=0;
		 
	       return SUCCESS;
	   }
	 
	 public String checkPseudo() throws Exception {
		 
		 UserDaoImpl userDao=new UserDaoImpl();
		 user =userDao.findUserAdmin(this.pseudo,null,0);
		 if(user==null){
			 result=0;
		 }else{
			 result=1;
		 }
		 System.out.println("result : "+result);
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
