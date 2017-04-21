package com.iyihua.itimes.model.user;

import java.io.Serializable;

//@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 2665659143236349257L;
//	@Column(nullable = false)
	private Integer roleId;
//	@Column(nullable = false)
	private String roleName;
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
