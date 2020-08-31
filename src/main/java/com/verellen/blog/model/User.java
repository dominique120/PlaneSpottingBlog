package com.verellen.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column
	String password;
	
	@Id
	String user;
	
	public User() { }
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public User(String user, String password) {
		super();
		this.password = password;
		this.user = user;
	}
}
