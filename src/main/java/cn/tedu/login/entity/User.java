package cn.tedu.login.entity;

public class User {
	private int id;
    private String username;
    private String pwd;
    private String name;
    private String gender;
	
	
	public User() {
		super();
	}
	public User(int id, String username, String pwd, String name, String gender) {
		
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User :id=" + id + ", username=" + username + ", password=" + pwd + ", name=" + name + ", gender=" + gender;
	}
	
}
