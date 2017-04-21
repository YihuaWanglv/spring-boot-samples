package com.iyihua.remote.base.report;

import java.util.List;

import com.iyihua.model.base.report.CategoryReport;
import com.iyihua.model.base.report.CategoryTimeReport;
import com.iyihua.model.base.report.ReportData;
import com.iyihua.model.base.report.ReportQuery;

public interface ReportRemote {

//	public List<CategoryReport> reportCategory();
//	
//	public List<CategoryTimeReport> reportCategoryTime();

	/**
	 * 根据GroupType做简单的所用时间统计
	 * 	type=0,表示根据category统计
	 *  type=1,表示根据project统计
	 *  type=2,表示根据location统计
	 * @param query
	 * @return
	 */
	public List<ReportData> reportSimple(ReportQuery query);
	
	/**
	 * 根据GroupType做以时间分组的所用时间统计
	 * 	type=0,表示根据category统计
	 *  type=1,表示根据project统计
	 *  type=2,表示根据location统计
	 * 默认的时间分组维度为month
	 * @param query
	 * @return
	 */
	public List<ReportData> reportWithTime(ReportQuery query);
}
