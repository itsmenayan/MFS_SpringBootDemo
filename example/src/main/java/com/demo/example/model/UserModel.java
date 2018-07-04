package com.demo.example.model;

import com.demo.example.utils.PasswordUtils;

public class UserModel {
	
	
	private String userName;
	private String email;
	private String password;
	private String passKey;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		if(this.passKey==null) {
			this.passKey = PasswordUtils.getSalt(30);
		}
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassKey() {
		if(this.passKey==null) {
			this.passKey = PasswordUtils.getSalt(30);
		}
		return passKey;
	}
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
	
	
	

}
