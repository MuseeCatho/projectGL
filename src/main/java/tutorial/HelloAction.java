package tutorial;

import com.opensymphony.xwork2.ActionSupport;
public class HelloAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  public static final String MESSAGE = "La vache quoi !!!";
  private String message;
  public String execute()
  {
      setMessage(MESSAGE);
      return SUCCESS;
  }
  
  public String connect()
  {
      System.out.println("eeeeeeeeeeeee");
      return SUCCESS;
  }
  public String getMessage() {
      return message;
  }
  public void setMessage(String message) {
      this.message = message;
  }
}