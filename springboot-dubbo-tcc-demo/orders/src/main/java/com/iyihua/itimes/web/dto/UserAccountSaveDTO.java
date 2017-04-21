package com.iyihua.itimes.web.dto;

import java.io.Serializable;

public class UserAccountSaveDTO implements Serializable {

	private static final long serialVersionUID = -1783479447382828886L;
	private Long id;
	private String name;
	private String password;
	private String email;
	private String mobile;

	public UserAccountSaveDTO() {
		super();
	}

	public UserAccountSaveDTO(Long id, String name, String password, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
