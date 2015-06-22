package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import mapping.User;

public class UserManagerDao extends DAO {
	
	public UserManagerDao() {
		super(User.class);
	}

	public List<User> searchUsers(int admin, int ban, String searchString, int pageNumber, int pageCapacity){
		int firstNumberRow = pageCapacity * (pageNumber - 1);
		int lastNumberRow = firstNumberRow + pageCapacity;
		System.out.println("firstNumberRow : " + firstNumberRow + ", lastNumberRow : " + lastNumberRow);
		begin();
		Criteria cr = filterUser(admin, ban, searchString);
		cr.setFirstResult(firstNumberRow);
		cr.setMaxResults(lastNumberRow);
		List<User> results = cr.list();
		System.out.println("dao return site : " + results.size());
		// security :
		results = results.subList(0, Math.min(results.size(), pageCapacity));
		return results;
	}
	
	public int countUsers(int admin, int ban, String searchString){
		Criteria cr = filterUser(admin, ban, searchString);
		Number usersNumber = (Number)(cr.setProjection(Projections.rowCount()).uniqueResult());
		return (Integer) usersNumber;
	}
	
	private Criteria filterUser(int admin, int ban, String searchString){
		Criteria cr = session.createCriteria(objClass);
		Disjunction disjunction = Restrictions.disjunction();//for OR operations
		searchString = "%" + searchString + "%";
		disjunction.add(Restrictions.ilike("firstname", searchString));
		disjunction.add(Restrictions.ilike("name", searchString));
		disjunction.add(Restrictions.ilike("pseudo", searchString));
		disjunction.add(Restrictions.ilike("name", searchString));
		cr.add(disjunction);
		cr.add(Restrictions.eq("admin", new Integer(admin)));
		cr.add(Restrictions.eq("ban", new Integer(ban)));
		return cr;
	}
}
