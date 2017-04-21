package com.iyihua.model.base.report;

import java.math.BigDecimal;

public class CategoryReport {

	private long categoryId;
	private String categoryName;
	private BigDecimal durations = BigDecimal.ZERO;
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BigDecimal getDurations() {
		return durations;
	}
	public void setDurations(BigDecimal durations) {
		this.durations = durations;
	}
	
	
	
}
