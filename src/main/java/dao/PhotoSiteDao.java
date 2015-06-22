package dao;

import java.util.Collection;
import java.util.List;

import mapping.Photos_Site;
import mapping.User;




public interface PhotoSiteDao<Photo_Site, Integer> {

	
	public Photos_Site findPhotoPresentation(Integer id);
	public void updatePhotoPresentation(Photo_Site entity);
	public void insertPhotoPresentation(Photo_Site entity);

}