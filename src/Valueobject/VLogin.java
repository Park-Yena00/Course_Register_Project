package Valueobject;
//coderabbit review
public class VLogin {
	
	private String userId;
	private String passwd;
	private String studentnumber;
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String passwd) {
		this.passwd = passwd;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return passwd;
	}
	public String getStudentnumber() {
		return studentnumber;
	}

}
