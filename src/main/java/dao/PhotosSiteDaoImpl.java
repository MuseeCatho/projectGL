package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Enrichments;
import mapping.ObjectCategory;
import mapping.Period;
import mapping.Photos;
import mapping.Photos_Site;
import mapping.Proposition;
import mapping.User;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class PhotosSiteDaoImpl implements PhotoSiteDao<Photos_Site, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public PhotosSiteDaoImpl() {

	}

	public Photos_Site findPhotoPresentation(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Photos_Site.class);
		cr.add(Restrictions.eq("id",id));
		Photos_Site photoPresentation = (Photos_Site) cr.uniqueResult();
		return photoPresentation;
	}
	
	public void updatePhotoPresentation(Photos_Site entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.update(entity);
        session.getTransaction().commit();
	}
	public void insertPhotoPresentation(Photos_Site entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}
}
