package dao;

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
	
	public Period getPeriod(Integer idPeriod){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Period.class)
				.add(Restrictions.eq("id",idPeriod));
		Period period = (Period) cr.uniqueResult();
		return period;
		
	} 
}
