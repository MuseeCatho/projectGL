package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.ObjectMuseum;
import mapping.Period;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;
public class PeriodDaoImpl implements PeriodDao<Period, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public PeriodDaoImpl(){
		
	}
	
	public Collection<Period> getPeriod(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class);
		Collection<Period> results = cr.list();
		return results;
	} 
	
//	public Collection<Period> getPeriod(){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction(); 
//		Criteria cr = session.createCriteria(Period.class);
//		List<Period> results = cr.list();
//		Collection<Period> resultsString = (Collection<Period>) session.createCriteria(Period.class.getName());
//		return resultsString;
//	} 
}
