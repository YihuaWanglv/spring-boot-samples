package com.iyihua.itimes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 7525327812218241962L;

	@Id
	@GeneratedValue
	private Long itemId;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private Date date;
	@Column
	private Long categoryId;
	@Column
	private Long locationId;
	@Column
	private Long projectId;
	@Column
	private String item;
	@Column
	private String tags;
	@Column(nullable = false)
	private BigDecimal duration;
	@Column(nullable = false)
	private String year;
	@Column(nullable = false)
	private String month;
	@Column(nullable = false)
	private String day;
	@Column
	private String week;
	@Column
	private String userName;
	@Column
	private String categoryName;
	@Column
	private String projectName;
	@Column
	private String locationName;
	@Column
	private String result;

	public Item() {
		super();
	}

	public Item(Long itemId, Long userId, Date date, Long categoryId, Long locationId, Long projectId,
			String item, String tags, BigDecimal duration, String year, String month, String day, String week,
			String userName, String categoryName, String projectName, String locationName) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.date = date;
		this.categoryId = categoryId;
		this.locationId = locationId;
		this.projectId = projectId;
		this.item = item;
		this.tags = tags;
		this.duration = duration;
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
		this.userName = userName;
		this.categoryName = categoryName;
		this.projectName = projectName;
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", date=" + date + ", categoryId=" + categoryId
				+ ", locationId=" + locationId + ", projectId=" + projectId + ", item=" + item + ", tags="
				+ tags + ", duration=" + duration + ", year=" + year + ", month=" + month + ", day=" + day + ", week="
				+ week + ", userName=" + userName + ", categoryName=" + categoryName + ", projectName=" + projectName
				+ ", locationName=" + locationName + "]";
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
