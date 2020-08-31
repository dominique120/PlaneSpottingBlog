package com.verellen.blog.model;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String userName, String password) {
		super();
		this.password = password;
		this.userName = userName;
	}

	String password;
	String userName;

}
