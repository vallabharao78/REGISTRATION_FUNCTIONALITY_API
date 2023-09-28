package com.vallabha.bindings;

public class UnlockDetails {

	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
	
	public UnlockDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTempPwd() {
		return tempPwd;
	}


	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}


	public String getNewPwd() {
		return newPwd;
	}


	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	public String getConfirmPwd() {
		return confirmPwd;
	}


	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}


	@Override
	public String toString() {
		return "UnlockDetails [email=" + email + ", tempPwd=" + tempPwd + ", newPwd=" + newPwd + ", confirmPwd="
				+ confirmPwd + ", getEmail()=" + getEmail() + ", getTempPwd()=" + getTempPwd() + ", getNewPwd()="
				+ getNewPwd() + ", getConfirmPwd()=" + getConfirmPwd() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	public UnlockDetails(String email, String tempPwd, String newPwd, String confirmPwd) {
		super();
		this.email = email;
		this.tempPwd = tempPwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}
	
}
