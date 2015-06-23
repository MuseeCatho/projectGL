package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Enrichments;
import mapping.ObjectCategory;
import mapping.Period;
import mapping.Video;
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

public class VideoDaoImpl implements VideoDao<Video, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public VideoDaoImpl() {

	}

	public Collection<Video> getVideo(Integer idVideo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Video.class).add(
				Restrictions.eq("id_object", idVideo));
		List<Video> photos = cr.list();
		return photos;

	} 

	public void insertVideos(Video entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		
	}

	public Collection<Video> getLastVideos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		DetachedCriteria maxId = DetachedCriteria.forClass(Video.class)
				.setProjection(Projections.max("id"));
		return session.createCriteria(Video.class)
				.add(Property.forName("id").eq(maxId)).list();
	}
}
