package action;

import java.util.Date;

import mapping.Comment;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;

public class CommentsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_id;
	private String id;
	private String object_id;
	private String text;
	private int result;
	
	
	public String addComment(){
		CommentDaoImpl commentDao = new CommentDaoImpl();
		Comment comment= new Comment(new Integer(0),new Integer(this.user_id),new Integer(this.object_id),this.text,new Date());
		commentDao.insertComment(comment);
		result=1;
		return SUCCESS;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getObject_id() {
		return object_id;
	}


	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}
	
	
	

}
