package com.usermanagement.dto;

public class UserDto {

	private String name;
	private String email;

	private String password;

	private String about;

	private String roles;

	
	public UserDto( String name, String email, String password, String about, String roles) {
		super();

		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.roles = roles;

	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "User name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", roles=" + roles ;
	}

}
