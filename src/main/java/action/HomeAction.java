package action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import mapping.Category;
import mapping.ObjectMuseum;
import mapping.Photos_Site;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDaoImpl;
import dao.PhotosSiteDaoImpl;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	private File[] uploads;
    private String[] uploadFileNames;
    private String[] uploadContentTypes;
	
	public String getAllCategory(){
		System.out.println("getAllCategory");
		CategoryDaoImpl categoriesDao = new CategoryDaoImpl();
		
		listCategory =new ArrayList<Category>( categoriesDao.getCategory());
		System.out.println("getAllCategory -- listCategory.size :"+listCategory.get(0).getName_e());
		return SUCCESS;
	}
	
	public String addPhotoPresentation() throws Exception{
		if(this.uploadFileNames==null){ //si il n'y a pas de photo
			System.out.print("NULL");
		}
		else{
			PhotosSiteDaoImpl photoSiteDao = new PhotosSiteDaoImpl();
			Photos_Site photoSite=photoSiteDao.findPhotoPresentation(new Integer(1));
			String webroot;
			/////////////////////////
			//////////////////////
			
			////////////////////////////
			//////////////////////////
			webroot="img"+File.separatorChar+this.uploadFileNames[0];
			String webrootAbsolut = getPath()+File.separatorChar+webroot;
			upload(webrootAbsolut);
			Photos_Site entity =new Photos_Site(new Integer(1),"photo presentation",webroot);
			if(photoSite==null){
				System.out.println("insert");
				photoSiteDao.insertPhotoPresentation(entity);
			}else{
				System.out.println("update");
				photoSiteDao.updatePhotoPresentation(entity);
			}
		}
		
		
		
		return SUCCESS;
		
	}
	
	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println("fullPath " + fullPath);
		System.out.println("pathArr "+ pathArr[0]);
		fullPath = pathArr[0];
		
		String reponsePath = "";
// to read a file from webcontent
		reponsePath = new File(fullPath).getPath();
		System.out.println("response Path "+reponsePath);
		return reponsePath;
	}
	public void upload(String path) throws Exception {
    	/* write the files in the eclipse repository */
        System.out.println("\n\n upload2");
        System.out.println("files:");
        for(int i = 0; i < uploads.length; i++) {
            System.out.println("*** " + uploads[i] + "\t" + uploads[i].length());
            File dest = new File(path);
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
    }

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public File[] getUploads() {
		return uploads;
	}

	public void setUploads(File[] uploads) {
		this.uploads = uploads;
	}

	public String[] getUploadFileNames() {
		return uploadFileNames;
	}

	public void setUploadFileNames(String[] uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public String[] getUploadContentTypes() {
		return uploadContentTypes;
	}

	public void setUploadContentTypes(String[] uploadContentTypes) {
		this.uploadContentTypes = uploadContentTypes;
	}

	

}
