package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.ObjectCategory;
import mapping.ObjectMuseum;


import mapping.Period;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class ObjectCategoryDaoImpl {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public ObjectCategoryDaoImpl(){
		
	}
	
	public void insertCategoryOfObject(ArrayList<Integer> listIdCat, int objectId) {
		ObjectCategory objCat=new ObjectCategory();
		objCat.setObject_id(objectId);
		for(int i=0; i<listIdCat.size();i++){
			objCat.setCategory_id(listIdCat.get(i));
			Session session = HibernateUtil.getSessionFactory().openSession();
			
	        session.beginTransaction();    
	        session.save(objCat);
	        session.getTransaction().commit();
		}
		
		
        
	}
	
	public ObjectMuseum getObjectForCategorie(Integer category_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(ObjectCategory.class)
				.add(Restrictions.eq("category_id",category_id));
		ObjectMuseum object=new ObjectMuseum();
		//Period period = (Period) cr.uniqueResult();
		return object;
	}
	
//	public Collection<Category> getCategory(){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction(); 
//		Criteria cr = session.createCriteria(Category.class);
//		Collection<Category> results = cr.list();
//		return results;
//	} 
}
