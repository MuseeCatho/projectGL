package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import mapping.User;

public class UserManagerDao extends DAO {
	
	public UserManagerDao() {
		super(User.class);
	}

	public List<User> searchUsers(int admin, String searchString, int pageNumber, int pageCapacity){
		int firstNumberRow = pageCapacity * (pageNumber - 1);
		int lastNumberRow = firstNumberRow + pageCapacity - 1;
		begin();
		Criteria cr = session.createCriteria(objClass);
		Disjunction disjunction = Restrictions.disjunction();//for OR operations
		searchString = "%" + searchString + "%";
		disjunction.add(Restrictions.ilike("firstname", searchString));
		disjunction.add(Restrictions.ilike("name", searchString));
		disjunction.add(Restrictions.ilike("pseudo", searchString));
		disjunction.add(Restrictions.ilike("name", searchString));
		cr.add(disjunction);
		cr.add(Restrictions.eq("admin", admin));
		cr.add(Restrictions.between("id",firstNumberRow, lastNumberRow));
		List<User> results = cr.list();
		return results;
	}
}
