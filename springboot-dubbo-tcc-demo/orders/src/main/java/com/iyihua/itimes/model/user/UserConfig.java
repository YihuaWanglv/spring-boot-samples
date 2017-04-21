package com.iyihua.itimes.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserConfig implements Serializable {

	private static final long serialVersionUID = -4683278640778658076L;
	@Id
	@GeneratedValue
	private long userConfigId;
	@Column
	private String detail;
	
	public long getUserConfigId() {
		return userConfigId;
	}
	public void setUserConfigId(long userConfigId) {
		this.userConfigId = userConfigId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
