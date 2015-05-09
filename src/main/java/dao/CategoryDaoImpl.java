package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class CategoryDaoImpl implements CategoryDao<Category, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public CategoryDaoImpl(){
		
	}
	
	public Collection<Category> getCategory(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Category.class);
		Collection<Category> results = cr.list();
		return results;
	} 
	
	public Category findCategoryById(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Category.class);
		cr.add(Restrictions.eq("id",id));
		Category category = (Category) cr.uniqueResult();
		return category;
	}
	
	public void insertCategory(Category entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}
	
	public void deleteCategory(Category entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.delete(entity);
        session.getTransaction().commit();
	}
}
