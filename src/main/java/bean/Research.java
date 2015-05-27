package bean;

import java.util.Date;
import java.util.List;

import mapping.Category;
import mapping.Period;

public class Research {
	private String keyword;
	private String keywordExclude;
	private String reference;
	private List<Category> listCategory;
	private Period period;
	private String country;
	private String city;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeywordExclude() {
		return keywordExclude;
	}
	public void setKeywordExclude(String keywordExclude) {
		this.keywordExclude = keywordExclude;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Research(String keyword, String keywordExclude, String reference, List<Category> listCategory, Period period, String country, String city){
		this.keyword=keyword;
		this.keywordExclude=keywordExclude;
		this.reference=reference;
		this.listCategory=listCategory;
		this.period=period;
		this.country=country;
		this.city=city;
	}
	
}
