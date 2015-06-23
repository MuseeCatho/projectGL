package dao;

import java.math.BigInteger;
import java.util.Collection;

import mapping.Category;
import mapping.Proposition;

public interface PropositionDao<Proposition, Integer> {
	
	public void insertProposition(Proposition entity);	
	public Collection<mapping.Proposition> getProposition(Integer object_id);

}
