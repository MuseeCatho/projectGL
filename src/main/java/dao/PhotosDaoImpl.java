package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Enrichments;
import mapping.ObjectCategory;
import mapping.Period;
import mapping.Photos;
import mapping.Proposition;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class PhotosDaoImpl implements PhotosDao<Photos, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public PhotosDaoImpl() {

	}

	public Collection<Photos> getPhotos(Integer idPhotos) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Photos.class).add(
				Restrictions.eq("id_object", idPhotos));
		List<Photos> photos = cr.list();
		return photos;

	} 

	public void insertPhotos(Photos entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}

	
	public Collection<Photos> getLastPhotos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		DetachedCriteria maxId = DetachedCriteria.forClass(Photos.class)
				.setProjection(Projections.max("id"));
		return session.createCriteria(Photos.class)
				.add(Property.forName("id").eq(maxId)).list();
	}
}
