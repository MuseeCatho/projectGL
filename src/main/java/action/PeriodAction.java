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
	private String orderPeriod;

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
	public String updatePeriod(){
		
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		
		Period period=periodDao.getPeriodId(new Integer(this.id_category));
		if(periodDao.getUniquePeriodByOrder(new Integer(this.orderPeriod))!=null){
			changeOrder(new Integer(this.orderPeriod),period.getOrder());
		}
		
		period.setOrder(new Integer(this.orderPeriod));
		periodDao.updatePeriod(period);
		
		return SUCCESS;
	}
	public void changeOrder(Integer order,Integer oldValue){
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		//on regarde si le numéro est deja utilisé
				List<Period> listPeriodBis=(List<Period>) periodDao.getPeriodByOrder(order,oldValue);
				for(Period e:listPeriodBis){
					e.setOrder(e.getOrder()+1);
					periodDao.updatePeriod(e);
				}
	}
	
	public String addPeriod(){
		
		PeriodDaoImpl periodDao = new PeriodDaoImpl();
		
		listPeriod =new ArrayList<Period>( periodDao.getPeriod());
		int max=0;
		for (int i=1;i<listPeriod.size();i++){
			if(listPeriod.get(i).getOrder()>listPeriod.get(i-1).getOrder()){
				max=listPeriod.get(i).getOrder();
			}
		}
		
		Period period =new Period(new Integer(0),max+1,this.title_period,this.date,this.description_e,this.description_f);
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

	public String getOrderPeriod() {
		return orderPeriod;
	}

	public void setOrderPeriod(String orderPeriod) {
		this.orderPeriod = orderPeriod;
	}
}
