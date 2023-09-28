package com.vallabha.bindings;

import lombok.Data;

@Data
public class PasswordDetails {

	private String newPassword;
	private String confirmPassword;
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "PasswordDetails [newPassword=" + newPassword + ", confirmPassword=" + confirmPassword
				+ ", getNewPassword()=" + getNewPassword() + ", getConfirmPassword()=" + getConfirmPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public PasswordDetails(String newPassword, String confirmPassword) {
		super();
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	public PasswordDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
