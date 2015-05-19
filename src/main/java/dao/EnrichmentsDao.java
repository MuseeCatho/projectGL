package dao;

import java.util.Collection;

import mapping.Enrichments;

public interface EnrichmentsDao<Enrichments, Integer> {
	
	public void insertEnrichments(Enrichments entity);
}
