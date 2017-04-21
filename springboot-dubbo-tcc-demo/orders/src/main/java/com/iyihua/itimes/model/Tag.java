package com.iyihua.itimes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag implements Serializable {

	
	private static final long serialVersionUID = 7525327812218240005L;
	@Id
	@GeneratedValue
	private Long tagId;
	@Column(nullable = false)
	private String tagName;
	@Column(nullable = false)
	private Long userId;
	
	
	public Tag() {
		super();
	}
	public Tag(Long tagId, String tagName, Long userId) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Tags [tagId=" + tagId + ", tagName=" + tagName + ", userId=" + userId + "]";
	}
	public Long getTagId() {
		return tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
