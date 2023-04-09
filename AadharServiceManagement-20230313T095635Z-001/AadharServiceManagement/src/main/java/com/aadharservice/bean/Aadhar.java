package com.aadharservice.bean;


public class Aadhar {

	private Integer aadharnumber;
	
	private Integer id;

	private String name;

	private String email;
	
	private String password;
	
	private String about;

	private String roles;

	public Integer getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(Integer aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Aadhar(Integer aadharnumber, Integer id, String name, String email, String password, String about,
			String roles) {
		super();
		this.aadharnumber = aadharnumber;
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.roles = roles;
	}

	public Aadhar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Aadhar [aadharnumber=" + aadharnumber + ", id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", about=" + about + ", roles=" + roles + "]";
	}
	
	
	

}
