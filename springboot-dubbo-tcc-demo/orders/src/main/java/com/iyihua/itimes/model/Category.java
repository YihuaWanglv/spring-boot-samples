package com.iyihua.itimes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Category implements Serializable {

	private static final long serialVersionUID = 7525327812218240002L;
	@Id
	@GeneratedValue
	private Long categoryId;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private String categoryName;
	@Column
	private Integer categoryType;
	@Column
	private Long parentId;

	public Category() {
		super();
	}

	public Category(Long categoryId, Long userId, String categoryName, Integer categoryType, Long parentId) {
		super();
		this.categoryId = categoryId;
		this.userId = userId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", userId=" + userId + ", categoryName=" + categoryName
				+ ", categoryType=" + categoryType + ", parentId=" + parentId + "]";
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
