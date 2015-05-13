package dao;

import java.util.Collection;
import java.util.List;

import mapping.Period;
import mapping.Photos;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;
public class PhotosDaoImpl implements PhotosDao<Photos, Integer>{

	private Session currentSession;
	private Transaction currentTransaction;
	
	public PhotosDaoImpl(){
		
	}
	
	public Collection<Photos> getPhotos(Integer idPhotos){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Photos.class)
				.add(Restrictions.eq("id_object",idPhotos));
		List<Photos> photos = cr.list();
		return photos;	
	
	} 
}
