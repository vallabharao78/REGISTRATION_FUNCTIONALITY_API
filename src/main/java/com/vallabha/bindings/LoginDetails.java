package com.vallabha.bindings;

import lombok.Data;

@Data
public class LoginDetails {

	private String userName;
	private String password;
	
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
	public LoginDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public LoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginDetails [userName=" + userName + ", password=" + password + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
