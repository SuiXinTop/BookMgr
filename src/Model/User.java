package Model;

public class User {
	private String user_id;
	private String user_name;
	private String user_sex;
	private int user_age;
	private String user_phone;
	private String user_password;
	
	public User() {
		super();
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_sex() {
		return user_sex;
	}
	
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	
	public int getUser_age() {
		return user_age;
	}
	
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	
	public String getUser_phone() {
		return user_phone;
	}
	
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
}
