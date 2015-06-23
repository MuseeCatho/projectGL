package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Enrichments;
import mapping.ObjectMuseum;
import mapping.Proposition;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
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

	public Collection<Enrichments> getLastEnrichments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		DetachedCriteria maxId = DetachedCriteria.forClass(Enrichments.class)
				.setProjection(Projections.max("id"));
		return session.createCriteria(Enrichments.class).list();
	}

	public Collection<Enrichments> getEnrichments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Enrichments.class)
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("object_id").as("object_id")));
		List<Enrichments> results = cr.list();
		System.out.println(results);
		return results;
	}
	public Collection<Enrichments> getTotalEnrichments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Enrichments.class);
		List<Enrichments> results = cr.list();
		return results;
	}
	public Collection<Enrichments> getObjectEnrichments(Integer idObject) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Enrichments.class);
		cr.add(Restrictions.eq("object_id",idObject));
		List<Enrichments> results = cr.list();
		return results;
	}
}