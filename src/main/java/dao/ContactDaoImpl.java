package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Comment;
import mapping.Museum;
import mapping.Period;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class ContactDaoImpl implements ContactDao<Museum, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public ContactDaoImpl(){
		
	}
	
	public Collection<Museum> getInfoMuseum(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Museum.class);
		Collection<Museum> results = cr.list();
		return results;
	}
	
	public void updateContact(Museum entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.update(entity);
        session.getTransaction().commit();
	}
	
}
