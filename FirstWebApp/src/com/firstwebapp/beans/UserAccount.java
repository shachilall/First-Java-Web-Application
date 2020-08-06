package com.firstwebapp.beans;

import java.io.Serializable;

public class UserAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;

	public UserAccount() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
