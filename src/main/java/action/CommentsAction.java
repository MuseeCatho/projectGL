package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Collection;

import mapping.Comment;
import bean.CommentDetail;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.CommentDaoImpl;
import dao.UserDaoImpl;

public class CommentsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_id;
	private String id;
	private String object_id;
	private String text;
	private List<Comment> listComment;
	private ArrayList<CommentDetail> listCommentAndNameUser;
	private String result;
	
	
	public String addComment(){
		CommentDaoImpl commentDao = new CommentDaoImpl();
		Comment comment= new Comment(new Integer(0),new Integer(this.user_id),new Integer(this.object_id),this.text,new Date(),new Integer(0));
		commentDao.insertComment(comment);
		result="1";
		return SUCCESS;
	}
	
	public String getCommentById(){
		CommentDaoImpl commentDao = new CommentDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		listComment = new ArrayList<Comment>(commentDao.findCommentById(new Integer(this.object_id)));
		
		listCommentAndNameUser=new ArrayList<CommentDetail>();
		if(listComment.size()>0){
			for (Comment e : listComment) {
				CommentDetail commentDetail=new CommentDetail(e.getId(),userDao.findUserById(e.getUser_id()).getPseudo(),e.getText(),e.getDate(),e.getShow());
				listCommentAndNameUser.add(commentDetail);
			}
		}
		
		Gson gson = new Gson();
		result = gson.toJson(listCommentAndNameUser);
		System.out.println(result);
		
		return SUCCESS;
	}

	public String deleteComment(){
		CommentDaoImpl commentDao = new CommentDaoImpl();
		Comment comment =commentDao.findCommentByIdComment(new Integer(this.id));
		commentDao.deleteComment(comment);
		return SUCCESS;
	}
	
	public String valideComment(){
		CommentDaoImpl commentDao = new CommentDaoImpl();
		Comment comment =commentDao.findCommentByIdComment(new Integer(this.id));
		comment.setShow(new Integer(1));
		commentDao.updateComment(comment);
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


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public ArrayList<CommentDetail> getListCommentAndNameUser() {
		return listCommentAndNameUser;
	}

	public void setListCommentAndNameUser(
			ArrayList<CommentDetail> listCommentAndNameUser) {
		this.listCommentAndNameUser = listCommentAndNameUser;
	}
	
	
	

}
