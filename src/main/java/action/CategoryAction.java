package action;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import mapping.Category;
import mapping.ObjectMuseum;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;

public class CategoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	private String title_f;
	private String title_e;
	private String id_category;
	private String link_category;
	private String result;
	private File[] uploads;
    private String[] uploadFileNames;
    private String[] uploadContentTypes;
	
	public String getAllCategory(){
		System.out.println("getAllCategory");
		CategoryDaoImpl categoriesDao = new CategoryDaoImpl();
		
		listCategory =new ArrayList<Category>( categoriesDao.getCategory());
		Gson gson = new Gson();
		
		result = gson.toJson(listCategory);
		System.out.println("getAllCategory -- json"+result);
		return SUCCESS;
	}
	
public String deleteCategory(){
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		Category category=categoryDao.findCategoryById(new Integer(this.id_category));
		categoryDao.deleteCategory(category);
		
		return SUCCESS;
	}
	
	public String addCategory() throws Exception{
		

		String link_picture;
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		if(uploadFileNames==null){ //si il n'y a pas de photo
			link_picture="img/category/other.jpg";
		}else{
			ServletContext context = ServletActionContext.getServletContext();
			String webroot = context.getRealPath("/")+"\\src\\main\\webapp\\img\\category";
			upload(webroot);
			link_picture="img/category/"+uploadFileNames[0];
		}
		Category category =new Category(new Integer(0),this.title_f,this.title_e,link_picture);
		categoryDao.insertCategory(category);
		return SUCCESS;
	}
	
	public String upload(String path) throws Exception {
    	/* write the files in the eclipse repository */
        System.out.println("\n\n upload2");
        System.out.println("files:");
        for(int i = 0; i < uploads.length; i++) {
            System.out.println("*** " + uploads[i] + "\t" + uploads[i].length());
            File dest = new File(path+"\\" + uploadFileNames[i]);
			FileUtils.copyFile(uploads[i], dest);
        }
        System.out.println("filenames:");
        for (String n : uploadFileNames) {
            System.out.println("*** " + n);
        }
        System.out.println("content types:");
        for (String c : uploadContentTypes) {
            System.out.println("*** " + c);
        }
        System.out.println("\n\n");
        
        return SUCCESS;
    }
	
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public String getTitle_f() {
		return title_f;
	}

	public void setTitle_f(String title_f) {
		this.title_f = title_f;
	}

	public String getTitle_e() {
		return title_e;
	}

	public void setTitle_e(String title_e) {
		this.title_e = title_e;
	}

	public String getId_category() {
		return id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}

	public String getLink_category() {
		return link_category;
	}

	public void setLink_category(String link_category) {
		this.link_category = link_category;
	}
	
	public File[] getUpload() {
        return this.uploads;
    }

    public void setUpload(File[] upload) {
        this.uploads = upload;
    }

    public String[] getUploadFileName() {
        return this.uploadFileNames;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileNames = uploadFileName;
    }

    public String[] getUploadContentType() {
        return this.uploadContentTypes;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentTypes = uploadContentType;
    }
}
