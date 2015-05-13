package action;

import java.util.ArrayList;
import java.util.List;

import mapping.Category;
import mapping.Period;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.PeriodDaoImpl;

public class PeriodAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Period> listPeriod;
	private String result;
	private String title_period;
	private String id_category;
	private String date;
	private String description_e;
	private String description_f;

	public String getAllPeriod(){
		System.out.println("getAllCategory");
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		
		listPeriod =new ArrayList<Period>( periodDao.getPeriod());
		Gson gson = new Gson();
		
		result = gson.toJson(listPeriod);
		System.out.println("getAllCategory -- json"+result);
		return SUCCESS;
	}
	
	public String deletePeriod(){
		
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		Period period=periodDao.getPeriodId(new Integer(this.id_category));
		periodDao.deletePeriod(period);
		
		return SUCCESS;
	}
	
	public String addPeriod(){
		
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		Period period =new Period(new Integer(0),this.title_period,this.date,this.description_e,this.description_f);
		periodDao.insertPeriod(period);
		return SUCCESS;
	}
	
	public List<Period> getListPeriod() {
		return listPeriod;
	}

	public void setListPeriod(List<Period> listPeriod) {
		this.listPeriod = listPeriod;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTitle_period() {
		return title_period;
	}

	public void setTitle_period(String title_period) {
		this.title_period = title_period;
	}

	public String getId_category() {
		return id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription_e() {
		return description_e;
	}

	public void setDescription_e(String description_e) {
		this.description_e = description_e;
	}

	public String getDescription_f() {
		return description_f;
	}

	public void setDescription_f(String description_f) {
		this.description_f = description_f;
	}
}
