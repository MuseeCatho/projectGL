package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.ObjectMuseum;
import mapping.User;

import bean.Research;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
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
	
	public Collection<ObjectMuseum> getObjectResearch(String research){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
        ArrayList<String> listObject=new ArrayList<String>();
        String[] parts = research.split(" ");
    	for(String s : parts) listObject.add(s);
		Criteria cr = session.createCriteria(ObjectMuseum.class);
		Disjunction disjunction = Restrictions.disjunction();//Permet de faire des operations OR
		
		for(String object:listObject){
			object= "%"+object;
			object+="%";
			disjunction.add(Restrictions.ilike("title_f", object));
			cr.add(disjunction);
		}
		List<ObjectMuseum> results = cr.list();
		return results;
	}
	
	//public Collection<ObjectMuseum> getObjectAdvResearch(Research research){
	public Collection<ObjectMuseum> getObjectAdvResearch(String research){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
        ArrayList<String> listObject=new ArrayList<String>();
        String[] parts = research.split(" ");
    	for(String s : parts) listObject.add(s);
		Criteria cr = session.createCriteria(ObjectMuseum.class);
		Disjunction disjunction = Restrictions.disjunction();//Permet de faire des operations OR
		
		for(String object:listObject){
			object= "%"+object;
			object+="%";
			disjunction.add(Restrictions.ilike("title_f", object));
			cr.add(disjunction);
		}
		List<ObjectMuseum> results = cr.list();
		return results;
	}
	
	public Collection<ObjectMuseum> getOeuvres(Integer idOeuvre){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(ObjectMuseum.class)
		.add(Restrictions.eq("id",idOeuvre));
		List<ObjectMuseum> results = cr.list();
		return results;
	}

	/*public ObjectMuseum addObject(String pseudo,String password,int admin){
		System.out.println("pseudo : "+pseudo);
		System.out.println("password : "+password);
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("admin",new Integer(admin)));
		cr.add(Restrictions.eq("password",password));
		cr.add(Restrictions.eq("pseudo",pseudo));
		User user = (User) cr.uniqueResult();
		return user;
	}*/
	
	public void addObject(ObjectMuseum objet) {//Exemple d'ajout objet 
		 	Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        
	        //Add new Employee object
	       // ObjectMuseum obj = new ObjectMuseum();
	        /*obj.setTitle_f("titre 1");
	        obj.setTitle_e("title 1");
	        obj.setCountry("France");
	        obj.setDate(new Date());
	        obj.setDescription_f("Ajout d'objet Test");
	        obj.setCity("Paris");*/
	         
	        //Save the employee in database
	        session.save(objet);
	 
	        //Commit the transaction
	        session.getTransaction().commit();
	        HibernateUtil.shutdown();
	}




	
	
}
