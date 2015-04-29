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
public class PeriodDaoImpl implements PeriodDao{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public PeriodDaoImpl(){
		
	}
	
	public Collection<Period> getPeriod(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class);
		List<Period> results = cr.list();
		return results;
	} 
	
//	public ArrayList<String> getPeriod(){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction(); 
//		Criteria cr = session.createCriteria(Period.class);
//		List<Period> results = cr.list();
//		ArrayList<String> resultsString = (ArrayList<String>) session.createCriteria(Period.class.getName());
//		return resultsString;
//	} 
}
