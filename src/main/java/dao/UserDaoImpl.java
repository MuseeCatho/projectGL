package dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.ObjectMuseum;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class UserDaoImpl implements UserDao<User, Integer>{

	
	private Session currentSession;
	private Transaction currentTransaction;


	public UserDaoImpl() {
	}
	
	
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
	
	public void insertUser(User entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}



	
	
}
