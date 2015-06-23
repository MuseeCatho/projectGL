package dao;

import java.util.Collection;

import mapping.Enrichments;

public interface EnrichmentsDao<Enrichments, Integer> {
	
	public void insertEnrichments(Enrichments entity);
	public Collection<Enrichments> getLastEnrichments();
	public Collection<Enrichments> getEnrichments();
	public Collection<Enrichments> getTotalEnrichments();
	public Collection<Enrichments> getObjectEnrichments(Integer idObject);
}
