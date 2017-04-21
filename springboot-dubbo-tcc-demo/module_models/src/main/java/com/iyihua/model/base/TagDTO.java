package com.iyihua.model.base;

import java.io.Serializable;

import com.iyihua.model.component.FieldExtend;

public class TagDTO implements Serializable {

	private static final long serialVersionUID = 7525327812218241005L;
	private Long tagId;
	private String tagName;
	private Long userId;

	private FieldExtend fieldExtend = new FieldExtend();

	public TagDTO() {
		super();
	}

	public TagDTO(Long tagId, String tagName, Long userId) {
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
	public FieldExtend getFieldExtend() {
		return fieldExtend;
	}
	public void setFieldExtend(FieldExtend fieldExtend) {
		this.fieldExtend = fieldExtend;
	}
}
