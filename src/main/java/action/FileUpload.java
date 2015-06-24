package action;

import java.io.File;


import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport{
	private File[] uploads;
	private String[] uploadFileNames;
	private String[] uploadContentTypes;
	private String testParam;
	private String mediasToDelete;
	private String mediasToDeleteTypes;


	public String upload() throws Exception {
		/* write the files in the eclipse repository */
		System.out.println("\n\n upload2");
		System.out.println("files:");
		if(uploads != null){
			for(int i = 0; i < uploads.length; i++) {
				System.out.println("*** " + uploads[i] + "\t" + uploads[i].length());
				File dest = new File("upload/" + uploadFileNames[i]);
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
		}
		System.out.println("\n\n");
		if(testParam != null){
			System.out.println("testParam : " + testParam + "\n\n");
		}
		if(mediasToDelete != null){
			System.out.println("mediasToDelete : " + mediasToDelete);
		}
		if(mediasToDeleteTypes != null){
			System.out.println("mediasToDeleteTypes : " + mediasToDeleteTypes);
		}
		return SUCCESS;
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

	public String getTestParam() {
		return testParam;
	}

	public void setTestParam(String testParam) {
		this.testParam = testParam;
	}

	public String getMediasToDelete() {
		return mediasToDelete;
	}

	public void setMediasToDelete(String mediasToDelete) {
		this.mediasToDelete = mediasToDelete;
	}

	public String getMediasToDeleteTypes() {
		return mediasToDeleteTypes;
	}

	public void setMediasToDeleteTypes(String mediasToDeleteTypes) {
		this.mediasToDeleteTypes = mediasToDeleteTypes;
	}
	
	
}
