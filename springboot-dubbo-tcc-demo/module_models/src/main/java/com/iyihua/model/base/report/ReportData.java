package com.iyihua.model.base.report;

import java.math.BigDecimal;

public class ReportData {

	private long typeId;
	private String typeName;
	private BigDecimal durations = BigDecimal.ZERO;
	private String reportdate;
	
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public BigDecimal getDurations() {
		return durations;
	}
	public void setDurations(BigDecimal durations) {
		this.durations = durations;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
