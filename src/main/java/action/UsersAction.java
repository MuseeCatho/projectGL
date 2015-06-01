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
		this.users = userManagerDao.searchUsers(this.admin, this.searchString, this.pageNumber, this.pageCapacity);
		this.numberUsers = userManagerDao.countUsers(this.admin, this.searchString);
		// creation of StringLis :
		int numberPages = (int) Math.ceil((float)(numberUsers) / pageCapacity);
		System.out.println("users.size() : " + numberUsers + ", numberPages : " + numberPages);
		this.pageLis = createPagination(pageNumber, numberPages);
		System.out.println("number of page : " + this.pageLis.size());
		return SUCCESS;
	}

	private List<String> createPagination(int pageNumber, int numberPages){
		List<String> pageLis = new ArrayList<String>();
		if(numberPages >= 2){
			if(pageNumber > 1){
				pageLis.add(getPageCode(false, pageNumber));
			}
			// for the first page : page[0]
			pageLis.add(getPageCode(1, pageNumber));
			// for the second page : page[1]
			if(pageNumber <= 5 || numberPages <= 9){
				pageLis.add(getPageCode(2, pageNumber));
			}
			else{
				pageLis.add(getPageCode(-1, pageNumber)); // - 1 for "..."
			}
			if(numberPages > 2){
				// for the third page : page[2]
				int firstMiddlePageNumber;
				if(pageNumber <= 5){
					firstMiddlePageNumber = 3;
				}
				else if(numberPages - pageNumber < 4){
					firstMiddlePageNumber = Math.max(3, numberPages - 6);
				}
				else{
					firstMiddlePageNumber = pageNumber - 2;
				}
				pageLis.add(getPageCode(firstMiddlePageNumber, pageNumber));
				if(numberPages > 3){
					// for the other middle pages
					for(int i = 1; i <= Math.min(4, numberPages - 3); i ++){
						pageLis.add(getPageCode(firstMiddlePageNumber + i, pageNumber));
					}
					if(numberPages > 7){
						// just after middle page : "..." or n - 1 :
						if(numberPages <= 9 || numberPages - pageNumber <= 4){
							pageLis.add(getPageCode(firstMiddlePageNumber + 5, pageNumber));
						}
						else{
							pageLis.add(getPageCode(-1, pageNumber));
						}
						if(numberPages >= 9){
							pageLis.add(getPageCode(numberPages, pageNumber));
						}
					}
				}
			}
		}
		if(pageNumber < numberPages){
			pageLis.add(getPageCode(true, pageNumber));
		}
		return pageLis;
	}

	private String getPageCode(int pageNumber, int currentPageNumber){
		/* return the <li> balise
		 * call it with negative pageNumber to set suspension points
		 */
		String pageCode = "<li";
		if(pageNumber < 0){
			pageCode += "><a href=\"#\">...</a></li>";
			return pageCode;
		}
		else if(pageNumber == currentPageNumber){
			pageCode += " class=\"active\"><a href=\"#\">" + pageNumber + "</a>"; 
		}
		else{
			pageCode += " onclick=\"usersData.pageNumber=" + pageNumber + ";usersData.search();\"><a href=\"#\">" + pageNumber + "</a>";
		}
		pageCode += "</li>";
		return pageCode;
	}

	private String getPageCode(boolean nextPage, int currentPageNumber){
		/* return the <li> balise
		 * call it with true for display a next button or false for display a previous button
		 */
		String buttonValue;
		int newPageNumber;
		if(nextPage){
			buttonValue = "&raquo;";
			newPageNumber = currentPageNumber + 1;
		}
		else{
			buttonValue = "&laquo;";
			newPageNumber = currentPageNumber - 1;
		}
		String pageCode = "<li onclick=\"usersData.pageNumber = " + newPageNumber
				+ ";usersData.search();\"><a href=\"#\">" + buttonValue + "</a></li>";
		return pageCode;
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
}
