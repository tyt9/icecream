package login.model;

import java.util.Date;

public class Admin {
	private String adminId;
	private String name;
	private String password;
	private Date regDate;

	
	
	public Admin(String adminId, String name, String password, Date regDate) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}



	public String getAdminId() {
		return adminId;
	}



	public String getName() {
		return name;
	}



	public String getPassword() {
		return password;
	}



	public Date getRegDate() {
		return regDate;
	}



	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", password=" + password + ", regDate=" + regDate + "]";
	}

}
