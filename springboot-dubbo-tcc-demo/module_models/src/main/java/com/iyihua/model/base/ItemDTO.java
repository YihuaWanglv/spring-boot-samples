package com.iyihua.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.iyihua.model.component.FieldExtend;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 7527822112218242002L;

	protected Long itemId;
	protected Long userId;
	protected Date date;
	protected Long categoryId;
	protected Long locationId;
	protected Long projectId;
	protected String item;
	protected String tags;
	protected BigDecimal duration;
	protected String year;
	protected String month;
	protected String day;
	protected String week;
	protected String userName;
	protected String categoryName;
	protected String projectName;
	protected String locationName;
	protected String result;
	
	protected FieldExtend fieldExtend = new FieldExtend();

	public ItemDTO() {
		super();
	}

	public ItemDTO(Long itemId, Long userId, Date date, Long categoryId, Long locationId, Long projectId, String item, String tags, BigDecimal duration, String year, String month, String day,
			String week, String userName, String categoryName, String projectName, String locationName, String result) {
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
		this.result = result;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemId=" + itemId + ", userId=" + userId + ", date=" + date + ", categoryId=" + categoryId + ", locationId=" + locationId + ", projectId=" + projectId + ", item=" + item
				+ ", tags=" + tags + ", duration=" + duration + ", year=" + year + ", month=" + month + ", day=" + day + ", week=" + week + ", userName=" + userName + ", categoryName=" + categoryName
				+ ", projectName=" + projectName + ", locationName=" + locationName + ", result=" + result + "]";
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

	public FieldExtend getFieldExtend() {
		return fieldExtend;
	}
	public void setFieldExtend(FieldExtend fieldExtend) {
		this.fieldExtend = fieldExtend;
	}
}
