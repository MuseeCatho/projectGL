package dao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Period;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class UserDaoImpl implements UserDao<User, Integer>{

	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public User findUserAdmin(String pseudo,String password,int admin){
		System.out.println("pseudo : "+pseudo);
		System.out.println("password : "+password);
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("admin",new Integer(admin)));
		if(password!=null){
		cr.add(Restrictions.eq("password",password));
		}
		cr.add(Restrictions.eq("pseudo",pseudo));
		User user = (User) cr.uniqueResult();
		return user;
	}
	
	public User findUserById(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("id",id));
		User user = (User) cr.uniqueResult();
		return user;
	}
	
	public void updateUser(User entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.update(entity);
        session.getTransaction().commit();
	}
	
	public void insertUser(User entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}
	
	public void getUsers(){
		System.out.print("ouai 12");
		try {
			FileWriter fw = new FileWriter ("ren.txt");
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter file = new PrintWriter (bw); 
			file.print("ren");
			file.close();
			System.out.println("ouai10");
		}
		catch (Exception e){
			System.out.println("ouai12");
			//System.out.println(e.toString());
		}
		/*Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(User.class);
		List<User> results = cr.list();
		return results;*/
	}



	
	
}
