package com.iyihua.model.base.user;

import java.io.Serializable;

public class UserConfigDTO implements Serializable {

	private static final long serialVersionUID = -4683278640778658076L;
	
	private long userConfigId;
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
