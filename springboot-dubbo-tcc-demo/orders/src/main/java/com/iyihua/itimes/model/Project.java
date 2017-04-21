package com.iyihua.itimes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 7525327812218240004L;
	@Id
	@GeneratedValue
	private Long projectId;
	@Column(nullable = false)
	private String projectName;
	@Column(nullable = false)
	private Long userId;
	
	public Project() {
		super();
	}
	public Project(Long projectId, String projectName, Long userId) {
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
	
	
}
