package action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mapping.User;
import addons.Pagination;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DAO;
import dao.UserDaoImpl;
import dao.UserManagerDao;

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
	private String resultAjax;
	private int admin;
	private int id;

	private String searchString;
	private int pageNumber;
	private int pageCapacity = 10;
	private List<User> users;
	private int ban;
	int numberUsers;
	List<String> pageLis; // for the pagination

	private static final long serialVersionUID = 1L;


	public String signIn() throws NoSuchAlgorithmException{

		UserDaoImpl userDao=new UserDaoImpl();
		System.out.println("signIn - pseudo : "+this.pseudo);
		System.out.println("signIn - password : "+this.password);
		System.out.println("signIn - admin : "+this.admin);

		user =userDao.findUserAdmin(this.pseudo, hashPassword(this.password),this.admin);
		//user =userDao.findUserAdmin("roro78220", "AZERTY");
		if(user==null){
			result=0;
		}else{
			Map session = ActionContext.getContext().getSession();
			if(this.admin==1){
				session.put("id_userAdmin", user.getId());
				session.put("firstnameAdmin", user.getFirstname());
			}else{
				session.put("id_user", user.getId());
				session.put("firstname", user.getFirstname());
			}
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
	
	public String logOutAdmin() throws Exception { 
		Map session = ActionContext.getContext().getSession();
		session.remove("id_userAdmin");
		session.remove("firstnameAdmin");
		return SUCCESS;
	}
	public String getInfoProfil(){
		UserDaoImpl userDao=new UserDaoImpl();
		User user=userDao.findUserById(this.id);

		Gson gson = new Gson();
		resultAjax = gson.toJson(user);
		System.out.println(resultAjax);


		return SUCCESS;
	}
	public String updateProfil(){
		UserDaoImpl userDao=new UserDaoImpl();
		User user=userDao.findUserById(this.id);
		user.setPseudo(this.pseudo);
		user.setFirstname(this.firstname);
		user.setName(this.name);
		user.setCountry(this.country);
		user.setCity(this.city);
		user.setMail(this.email);
		user.setJob(this.job);
		userDao.updateUser(user);
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

		User user = new User(new Integer(0), this.firstname, this.name,hashPassword(this.password),this.job, this.pseudo, this.country, this.city,this.email, new Integer(0), new Integer(0));
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

	public String hashPassword(String password) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(this.password.getBytes());
		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}


		return sb.toString();
	}


	public String searchUsers(){
		UserManagerDao userManagerDao = new UserManagerDao();
		this.users = userManagerDao.searchUsers(this.admin, this.ban, this.searchString, this.pageNumber, this.pageCapacity);
		this.numberUsers = userManagerDao.countUsers(this.admin, this.ban, this.searchString);
		// creation of StringLis :
		int numberPages = (int) Math.ceil((float)(numberUsers) / pageCapacity);
		System.out.println("users.size() : " + numberUsers + ", numberPages : " + numberPages);
		// handle the pagination :
		Pagination pagination = new Pagination("<a onclick=\"usersData.pageNumber=%;usersData.search();\">", "%");
		this.pageLis = pagination.createPagination(pageNumber, numberPages);
		return SUCCESS;
	}
	
	public String permuteAdmin(){
		//System.out.println("permute admin " + this.id);
		DAO<User> userDao=new DAO<User>(User.class);
		User user= userDao.find(this.id);
		user.setAdmin(1 - user.getAdmin());
		userDao.update(user);
		return searchUsers();
	}
	
	public String permuteBan(){
		System.out.println("permute ban " + this.id);
		DAO<User> userDao=new DAO<User>(User.class);
		User user= userDao.find(this.id);
		user.setBan(1 - user.getBan());
		userDao.update(user);
		return searchUsers();
	}
	
	public String deleteUser(){
		System.out.println("delete user " + this.id);
		DAO<User> userDao=new DAO<User>(User.class);
		User user= userDao.find(this.id);
		userDao.delete(user);
		return searchUsers();
	}
	
	public String insertUsersForTest(){
		String pseudo = "-TEST-";
		DAO<User> userDao = new DAO<User>(User.class);
		for(int i = 0; i < 15; i++){ // insert i * 10 users
			for(int j = 0; j < i * 10; j++){
				String newPseudo = pseudo + "-" + i + "-" + j + "-";
				User user = new User(new Integer(0), "#", "#", "#","#", newPseudo, "#", "#", "#", new Integer(0), new Integer(0));
				userDao.insert(user);
			}
		}
		System.out.println("all inserted ...");
		return SUCCESS;
	}

	/* getters and setters */
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResultAjax() {
		return resultAjax;
	}

	public void setResultAjax(String resultAjax) {
		this.resultAjax = resultAjax;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getNumberUsers() {
		return numberUsers;
	}

	public void setNumberUsers(int numberUsers) {
		this.numberUsers = numberUsers;
	}
	
	public List<String> getPageLis() {
		return pageLis;
	}

	public void setPageLis(List<String> pageLis) {
		this.pageLis = pageLis;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}
	
}
