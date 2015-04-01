package bdd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapping.Utilisateur;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import dbwConnection.DbwConnection;
import dbwConnection.ResultSet;
import bdd.ConnexionJDBC;

public class JDBC extends ActionSupport implements ServletRequestAware{
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/WEB-INF/test_jdbc.jsp";
    HttpServletRequest request;
    

//    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
//        /* Initialisation de l'objet Java et récupération des messages */
//        TestJDBC test = new TestJDBC();
//        List<String> messages = test.executerTests();
//
//        /* Enregistrement de la liste des messages dans l'objet requête */
//        request.setAttribute( ATT_MESSAGES, messages );
//
//        /* Transmission vers la page en charge de l'affichage des résultats */
//        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
//    }
    public String connect() throws SQLException{
    	System.out.println("testtttttt");
//    ConnexionJDBC test = new ConnexionJDBC();
//      List<String> messages = test.executerTests();
       
//       try {
//    	   
//           DbwConnection conn = new DbwConnection("http://edel6.free.fr/dbw.php", "edel6", "edel6app","edel6.sql.free.fr", "edel6");
//
//           ResultSet rs = conn.executeQuery("SELECT * FROM object");
//
//           while (rs.next()) {
//        	   String title=rs.getString("title");
//               System.out.print("title :"+ title);
//           }
//
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	 
        session.beginTransaction();
        Utilisateur users = new Utilisateur();
 
        users.setMot_de_passe("toto2");
        users.setEmail("test@test2.fr");
        users.setDate_inscription(new Date());
 
        session.save(users);
        session.getTransaction().commit();
       
       
    	return SUCCESS;
    }
    
    public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
 
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
}