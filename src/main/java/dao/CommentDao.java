package dao;

import java.util.Collection;

import mapping.Category;
import mapping.Comment;

public interface CommentDao<Comment, Integer> {
	
	public Collection<Comment> getComment();
	
	public void insertComment(Comment entity);
	
	public Collection<Comment> findCommentById(Integer id);
	
	public Comment findCommentByIdComment(Integer idComment);
	
	public void deleteComment(Comment entity);
	
	public Collection<Comment> findCommentByIdObjectByShow(Integer id,Integer show);
	
	public void updateComment(Comment entity);
	
}
