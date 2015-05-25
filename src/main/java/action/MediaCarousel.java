package action;

import com.opensymphony.xwork2.ActionSupport;

public class MediaCarousel extends ActionSupport{
	String mediaType;
	String mediaNames;
	String width;
	String height;
	String mediaCarouselId;
	
	public String execute(){
		System.out.println("ranas");
		return SUCCESS;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaNames() {
		return mediaNames;
	}

	public void setMediaNames(String mediaNames) {
		this.mediaNames = mediaNames;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMediaCarouselId() {
		return mediaCarouselId;
	}

	public void setMediaCarouselId(String mediaCarouselId) {
		this.mediaCarouselId = mediaCarouselId;
	}
	
}
