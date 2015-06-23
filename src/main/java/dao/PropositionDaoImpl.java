package dao;

import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Enrichments;
import mapping.Period;
import mapping.Photos;
import mapping.Proposition;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class PropositionDaoImpl implements PropositionDao<Proposition, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public PropositionDaoImpl() {

	}

	public void insertProposition(Proposition entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}

	public Collection<Proposition> getProposition(Integer object_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		SQLQuery sq = session.createSQLQuery(
    		    "SELECT COUNT(p.id) FROM proposition p INNER JOIN enrichment e   ON p.id_enrichments=e.id AND e.object_id="+object_id+" GROUP BY(e.object_id)");
		List results = sq.list();
		return results;
	}
}