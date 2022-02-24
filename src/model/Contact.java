package model;

public class Contact {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String group;
	
	public static final String TABLE = "contacts";
	public static final String COL_ID = "id";
	public static final String COL_NAME = "name";
	public static final String COL_MOBILE = "mobileno";
	public static final String COL_GROUP = "grp";
	public static final String COL_EMAIL = "email";
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", group=" + group
				+ "]";
	}
}
