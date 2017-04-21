package com.iyihua.model.base;

import java.io.Serializable;

import com.iyihua.model.component.FieldExtend;

public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 7525327812218241004L;
	private Long projectId;
	private String projectName;
	private Long userId;
	
	private FieldExtend fieldExtend = new FieldExtend();
	
	public ProjectDTO() {
		super();
	}
	public ProjectDTO(Long projectId, String projectName, Long userId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", userId=" + userId + "]";
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public FieldExtend getFieldExtend() {
		return fieldExtend;
	}
	public void setFieldExtend(FieldExtend fieldExtend) {
		this.fieldExtend = fieldExtend;
	}
}
