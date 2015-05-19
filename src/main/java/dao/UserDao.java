package dao;

import java.util.Collection;
import java.util.List;

import mapping.User;




public interface UserDao<User, Integer> {

	
	public User findUserAdmin(String pseudo,String password,int admin);
	
	public void insertUser(User entity);
	public User findUserById(Integer id);
	public void updateUser(User entity);

}