package dao;

import java.util.Collection;
import java.util.List;

import mapping.Video;

public interface VideoDao<Video, Integer> {

	public Collection<mapping.Video> getVideo(Integer idVideo);
	
	public void insertVideos(Video entity);
	public Collection<Video> getLastVideos();
}
