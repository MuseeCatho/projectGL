package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Period;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class CategoryDaoImpl /*implements CategoryDao<Category, Integer>*/{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public CategoryDaoImpl(){
		
	}
	
	public Collection<Category> getCategory(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class);
		Collection<Category> results = cr.list();
		return results;
	} 
}
