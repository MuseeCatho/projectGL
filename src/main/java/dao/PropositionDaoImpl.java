package dao;

import java.util.List;

import mapping.Category;
import mapping.Proposition;
import mapping.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bdd.HibernateUtil;

public class PropositionDaoImpl implements PropositionDao<Proposition, Integer>{
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public PropositionDaoImpl(){
		
	}
	
	
}
