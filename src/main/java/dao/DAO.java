package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class DAO<MappingObject> {
	protected Session session;
	protected Class<MappingObject> objClass;
	
	public DAO(Class<MappingObject> objClass){
		this.objClass = objClass;
	}
	
	// beginning and end of the transaction :
	public void begin(){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}
	
	public void end(){
		session.getTransaction().commit();
	}
	
	// setters :
	public void insert(MappingObject obj){
		begin();
        session.save(obj);
        end();
	}
	
	public void update(MappingObject obj){
		begin();
		session.update(obj);
		end();
	}
	
	public void delete(MappingObject obj){
		begin();
        session.delete(obj);
        end();
	}
	
	//getters :
	public MappingObject find(int id){
		begin();
		Criteria cr = session.createCriteria(objClass);
		cr.add(Restrictions.eq("id",id));
		MappingObject obj = (MappingObject) cr.uniqueResult();
		return obj;
	}
	
	public List<MappingObject> findAll(){
		begin();
		Criteria cr = session.createCriteria(objClass);
		List<MappingObject> results = cr.list();
		return results;
	}
	
	public List<MappingObject> findAll(int firstNumberRow, int lastNumberRow){
		begin();
		Criteria cr = session.createCriteria(objClass);
		cr.add(Restrictions.between("id",firstNumberRow, lastNumberRow));
		List<MappingObject> results = cr.list();
		return results;
	}
}