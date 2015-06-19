package addons;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	private String aBalise;
	private String aValue;
	private List<String> pageLis;
	private int pageNumber;
	private int numberPages;
	
	public Pagination(){
		/* do nothing */
		System.out.println("instanciated ...");
	}
	public Pagination(String aBalise, String aValue){
		/*
		 * the string aBalise contains the opening html code for the balise a
		 * the string aValue contains the characters between the two balise a
		 * all % characters in the a balise will be replace by the page number or by suspension point
		 */
		this.aBalise = aBalise;
		this.aValue = aValue;
	}
	
	public void createPagination(){
		this.pageLis = createPagination(this.pageNumber, this.numberPages);
	}
	
	public List<String> createPagination(int pageNumber, int numberPages){
		List<String> pageLis = new ArrayList<String>();
		if(numberPages >= 2){
			if(pageNumber > 1){
				pageLis.add(getPageCode(false, pageNumber));
			}
			// for the first page : page[0]
			pageLis.add(getPageCode(1, pageNumber));
			// for the second page : page[1]
			if(pageNumber <= 5 || numberPages <= 9){
				pageLis.add(getPageCode(2, pageNumber));
			}
			else{
				pageLis.add(getPageCode(-1, pageNumber)); // - 1 for "..."
			}
			if(numberPages > 2){
				// for the third page : page[2]
				int firstMiddlePageNumber;
				if(pageNumber <= 5){
					firstMiddlePageNumber = 3;
				}
				else if(numberPages - pageNumber < 4){
					firstMiddlePageNumber = Math.max(3, numberPages - 6);
				}
				else{
					firstMiddlePageNumber = pageNumber - 2;
				}
				pageLis.add(getPageCode(firstMiddlePageNumber, pageNumber));
				if(numberPages > 3){
					// for the other middle pages
					for(int i = 1; i <= Math.min(4, numberPages - 3); i ++){
						pageLis.add(getPageCode(firstMiddlePageNumber + i, pageNumber));
					}
					if(numberPages > 7){
						// just after middle page : "..." or n - 1 :
						if(numberPages <= 9 || numberPages - pageNumber <= 4){
							pageLis.add(getPageCode(firstMiddlePageNumber + 5, pageNumber));
						}
						else{
							pageLis.add(getPageCode(-1, pageNumber));
						}
						if(numberPages >= 9){
							pageLis.add(getPageCode(numberPages, pageNumber));
						}
					}
				}
			}
		}
		if(pageNumber < numberPages){
			pageLis.add(getPageCode(true, pageNumber));
		}
		return pageLis;
	}

	private String getPageCode(int pageNumber, int currentPageNumber){
		/* return the <li> balise
		 * call it with negative pageNumber to set suspension points
		 */
		String pageCode = "<li";
		
		if(pageNumber < 0){
			pageCode += "><a href=\"#\">...</a></li>";
			return pageCode;
		}
		String aBalise = this.aBalise.replaceAll("%", Integer.toString(pageNumber));
		String aValue = this.aValue.replaceAll("%", Integer.toString(pageNumber));
		if(pageNumber == currentPageNumber){
			pageCode += " class=\"active\">" + aBalise + aValue;
		}
		else{
			pageCode += ">" + aBalise + aValue;
		}
		pageCode += "</a></li>";
		return pageCode;
	}

	private String getPageCode(boolean nextPage, int currentPageNumber){
		/* return the <li> balise
		 * call it with true for display a next button or false for display a previous button
		 */
		String aBalise;
		String buttonValue;
		int newPageNumber;
		if(nextPage){
			buttonValue = "&raquo;";
			aBalise = this.aBalise.replaceAll("%", Integer.toString(currentPageNumber + 1));
		}
		else{
			buttonValue = "&laquo;";
			aBalise = this.aBalise.replaceAll("%", Integer.toString(currentPageNumber - 1));
		}
		String pageCode = "<li>" + aBalise + buttonValue + "</a></li>";
		return pageCode;
	}
	
	/* getters and setters */
	public String getaBalise() {
		return aBalise;
	}

	public void setaBalise(String aBalise) {
		this.aBalise = aBalise;
	}

	public String getaValue() {
		return aValue;
	}

	public void setaValue(String aValue) {
		this.aValue = aValue;
	}

	public List<String> getPageLis() {
		return pageLis;
	}

	public void setPageLis(List<String> pageLis) {
		this.pageLis = pageLis;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}
}
