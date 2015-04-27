package dao;

import java.util.Collection;
import java.util.List;




public interface UserDao<User, Integer> {

	
	public User findUserAdmin(String pseudo,String password,int admin);
	
	public void insertUser(User entity);

}