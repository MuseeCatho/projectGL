package dao;

import java.util.Collection;
import java.util.List;

import mapping.Photos;

public interface PhotosDao<Photos, Integer> {

	public Collection<mapping.Photos> getPhotos(Integer idPhotos);
	
	public void insertPhotos(Photos entity);
	public Collection<Photos> getLastPhotos();
}
