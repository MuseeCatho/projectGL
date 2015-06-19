package dao;

import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Enrichments;
import mapping.Period;
import mapping.Proposition;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

	public Proposition getProposition(Integer id_enrichments) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Proposition.class)
				.add(Restrictions.eq("id_enrichments", id_enrichments))
				.setProjection(Projections.rowCount());
		Proposition results = (Proposition) cr.uniqueResult();
		return results;
	}
}