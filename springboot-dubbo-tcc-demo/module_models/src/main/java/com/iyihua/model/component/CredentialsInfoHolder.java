package com.iyihua.model.component;

public class CredentialsInfoHolder {

	private String password;
	private String salt;

	public CredentialsInfoHolder() {
		super();
	}

	public CredentialsInfoHolder(String password, String salt) {
		this.password = password;
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
