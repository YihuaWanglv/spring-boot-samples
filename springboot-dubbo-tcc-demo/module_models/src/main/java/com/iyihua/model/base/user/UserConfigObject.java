package com.iyihua.model.base.user;

import java.io.Serializable;
import java.util.List;

import com.iyihua.model.base.report.ReportConfig;

public class UserConfigObject implements Serializable {

	private static final long serialVersionUID = 1507401697090937031L;

	List<ReportConfig> reportConfigs;

	public List<ReportConfig> getReportConfigs() {
		return reportConfigs;
	}

	public void setReportConfigs(List<ReportConfig> reportConfigs) {
		this.reportConfigs = reportConfigs;
	}

}
