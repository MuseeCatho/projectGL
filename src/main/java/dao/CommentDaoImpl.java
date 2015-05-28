package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mapping.Category;
import mapping.Comment;
import mapping.Period;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class CommentDaoImpl implements CommentDao<Comment, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public CommentDaoImpl(){
		
	}
	
	public Collection<Comment> getComment(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Comment.class);
		Collection<Comment> results = cr.list();
		return results;
	} 
	
	public Collection<Comment> findCommentById(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("object_id",id));
		Collection<Comment> results = cr.list();
		return results;
	}
	public Comment findCommentByIdComment(Integer idComment){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("id",idComment));
		Comment comment = (Comment) cr.uniqueResult();
		return comment;
	}
	
	public Collection<Comment> findCommentByIdObjectByShow(Integer id, Integer show){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("object_id",id));
		cr.add(Restrictions.eq("show",show));
		Collection<Comment> results = cr.list();
		return results;
	}
	
	public void insertComment(Comment entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.save(entity);
        session.getTransaction().commit();
	}
	
	public void deleteComment(Comment entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.delete(entity);
        session.getTransaction().commit();
	}
	
	public void updateComment(Comment entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();    
        session.update(entity);
        session.getTransaction().commit();
	}
}
