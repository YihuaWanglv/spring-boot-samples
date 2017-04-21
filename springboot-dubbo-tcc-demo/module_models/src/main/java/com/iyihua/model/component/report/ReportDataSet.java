package com.iyihua.model.component.report;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportDataSet {
	
	Set<String> labels;
	Map<String, List<BigDecimal>> dataset = new HashMap<String, List<BigDecimal>>();
	
	public Set<String> getLabels() {
		return labels;
	}
	public void setLabels(Set<String> labels) {
		this.labels = labels;
	}
	public Map<String, List<BigDecimal>> getDataset() {
		return dataset;
	}
	public void setDataset(Map<String, List<BigDecimal>> dataset) {
		this.dataset = dataset;
	}

}
