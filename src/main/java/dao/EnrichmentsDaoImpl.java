package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Enrichments;
import mapping.Proposition;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class EnrichmentsDaoImpl implements EnrichmentsDao<Enrichments, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public EnrichmentsDaoImpl() {

	}

	public void insertEnrichments(Enrichments entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}

}
