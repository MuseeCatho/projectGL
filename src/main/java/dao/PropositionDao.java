package dao;

import java.util.Collection;

import mapping.Category;
import mapping.Proposition;

public interface PropositionDao<Proposition, Integer> {
	
	public void insertProposition(Proposition entity);
}
