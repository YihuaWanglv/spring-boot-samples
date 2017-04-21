package com.iyihua.model.base;

import java.io.Serializable;

import com.iyihua.model.component.FieldExtend;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 127199294326731001L;

	private Long id;
	private String name;
	private String password;
	private Integer type;
	private String salt;
	private String email;
	private String mobile;
	private Integer deleted;
	private Integer enable;
	private String code;
	private long userConfigId;
//	private 

	private FieldExtend fieldExtend = new FieldExtend();

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, Integer type) {
		super();
		this.name = name;
	}
	
	public UserDTO(Long id, String name, String password, Integer type, String salt, String email, String mobile, Integer deleted, Integer enable, String code, FieldExtend fieldExtend) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
		this.salt = salt;
		this.email = email;
		this.mobile = mobile;
		this.deleted = deleted;
		this.enable = enable;
		this.code = code;
		this.fieldExtend = fieldExtend;
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldExtend getFieldExtend() {
		return fieldExtend;
	}
	public void setFieldExtend(FieldExtend fieldExtend) {
		this.fieldExtend = fieldExtend;
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

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public long getUserConfigId() {
		return userConfigId;
	}

	public void setUserConfigId(long userConfigId) {
		this.userConfigId = userConfigId;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + ", salt=" + salt + ", email=" + email + ", mobile=" + mobile + ", deleted=" + deleted
				+ ", enable=" + enable + ", code=" + code + ", fieldExtend=" + fieldExtend + "]";
	}

}
