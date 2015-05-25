package action;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import mapping.ObjectMuseum;
import mapping.User;
import dao.DAO;
import dao.ObjectDaoImpl;

public class Test_DAO extends ActionSupport{
	List<User> results; 
	List<ObjectMuseum> listObject;
	
	public List<User> getResults() {
		return results;
	}

	public void setResults(List<User> results) {
		this.results = results;
	}

	public String test_UserDAO(){
		System.out.println("eddy0");
		DAO<User> userDao=new DAO<User>(User.class);
		results = (ArrayList<User>) userDao.findAll();
		System.out.println("size : " + results.size());
		System.out.println("id : " + results.get(0).getCity());
		/*listObject = new ArrayList<ObjectMuseum>(objectDao.getLocations());
		
		Gson gson = new Gson();
		
		results2 = gson.toJson(listObject);
		System.out.println(results2);
		
		//results = new DAO(User.class).findAll();
		//System.out.println(results.size() + " users found");
		System.out.println("ranas");*/
		return SUCCESS;
	}
}
