package dao;

import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;
import mapping.Period;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class PeriodDaoImpl implements PeriodDao<Period, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public PeriodDaoImpl(){
		
	}
	
	public Period getPeriodId(Integer idPeriod){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class)
				.add(Restrictions.eq("id",idPeriod));
		Period period = (Period) cr.uniqueResult();
		return period;
		
	}
	public Collection<Period> getPeriodByOrder(Integer order,Integer oldValue){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class)
				.add(Restrictions.ge("order",order))
		.add(Restrictions.ne("order",oldValue));
		List<Period> period = cr.list();
		return period;
		
	}
	
	public Period getUniquePeriodByOrder(Integer order){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class)
				.add(Restrictions.eq("order",order));
		Period period = (Period) cr.uniqueResult();
		return period;
		
	}

	public Collection<Period> getPeriod(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class);
		cr.addOrder( Order.asc("order") );
		List<Period> period = cr.list();
		return period;
		
	}
	
	public void insertPeriod(Period entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}
	
	public void updatePeriod(Period entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.update(entity);
        session.getTransaction().commit();
	}
	
	public void deletePeriod(Period entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.delete(entity);
        session.getTransaction().commit();
	}
}
