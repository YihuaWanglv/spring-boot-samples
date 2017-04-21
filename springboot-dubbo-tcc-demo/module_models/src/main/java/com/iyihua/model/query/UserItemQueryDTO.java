package com.iyihua.model.query;

import java.io.Serializable;
import java.util.Date;

import com.iyihua.model.base.ItemDTO;
import com.iyihua.model.component.Page;

public class UserItemQueryDTO extends Page<ItemDTO> implements Serializable {

	private static final long serialVersionUID = 8815731290188501622L;

	private Long userId;
	private Long categoryId;
	private Long locationId;
	private Long projectId;
	private String tags;
	private Date date;
	private Date dateStart;
	private Date dateEnd;
	private String dateString;
	private String dateStringStart;
	private String dateStringEnd;
	private String userName;
	private String categoryName;
	private String projectName;
	private String locationName;
	private String year;
	private String month;
	private String day;
	private String week;

	@Override
	public String toString() {
		return "UserItemQueryDTO [userId=" + userId + ", categoryId=" + categoryId + ", locationId=" + locationId + ", projectId=" + projectId + ", tags=" + tags + ", date=" + date + ", dateStart="
				+ dateStart + ", dateEnd=" + dateEnd + ", dateString=" + dateString + ", dateStringStart=" + dateStringStart + ", dateStringEnd=" + dateStringEnd + ", userName=" + userName
				+ ", categoryName=" + categoryName + ", projectName=" + projectName + ", locationName=" + locationName + ", year=" + year + ", month=" + month + ", day=" + day + ", week=" + week
				+ "]";
	}

	public UserItemQueryDTO() {
		super();
	}

	public UserItemQueryDTO(Long userId, Long categoryId, Long locationId, Long projectId, String tags, Date date, Date dateStart, Date dateEnd, String dateString, String dateStringStart,
			String dateStringEnd, String userName, String categoryName, String projectName, String locationName, String year, String month, String day, String week) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
		this.locationId = locationId;
		this.projectId = projectId;
		this.tags = tags;
		this.date = date;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.dateString = dateString;
		this.dateStringStart = dateStringStart;
		this.dateStringEnd = dateStringEnd;
		this.userName = userName;
		this.categoryName = categoryName;
		this.projectName = projectName;
		this.locationName = locationName;
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getDateStringStart() {
		return dateStringStart;
	}
	public void setDateStringStart(String dateStringStart) {
		this.dateStringStart = dateStringStart;
	}
	public String getDateStringEnd() {
		return dateStringEnd;
	}
	public void setDateStringEnd(String dateStringEnd) {
		this.dateStringEnd = dateStringEnd;
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
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

}
