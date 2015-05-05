package dao;

import java.util.Collection;
import java.util.List;

import mapping.Photos;

public interface PhotosDao<Photos, Integer> {

	public mapping.Photos getPhotos(Integer idPhotos);
}
