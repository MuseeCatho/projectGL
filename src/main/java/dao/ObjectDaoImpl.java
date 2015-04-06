package dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.ObjectMuseum;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class ObjectDaoImpl implements ObjectDao<ObjectMuseum, Integer>{

	
	private Session currentSession;
	private Transaction currentTransaction;


	public ObjectDaoImpl() {
	}
	

	public void insert(ObjectMuseum entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
		
	}
	
	public Collection<ObjectMuseum> getLocations(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(ObjectMuseum.class);
		List<ObjectMuseum> results = cr.list();
		return results;
	}



	
	
}
