package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.ObjectMuseum;
import mapping.Period;
import mapping.Photos;
import bean.ObjectPage;
import mapping.ObjectCategory;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.ObjectDaoImpl;
import dao.PeriodDaoImpl;
import dao.PhotosDaoImpl;
import dao.ObjectCategoryDaoImpl;


public class ResearchAction extends ActionSupport{

	private String research;

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String research(){
		
		if (this.research!=null){
			ObjectDaoImpl objectDao = new ObjectDaoImpl();
			String research = this.research;
			objectDao.getOeuvres(Integer.parseInt(research));
		}
		
		return SUCCESS;
	}
}
