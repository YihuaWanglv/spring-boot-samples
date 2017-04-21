package com.iyihua.model.component;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = -8110767556267656062L;

	protected Integer page = -1;
	protected Integer total;
	protected Integer size = 20;
	protected Integer max;
	protected Integer start = 0;
	protected List<T> items;

	public Page() {
		super();
	}

	public Page(Integer page, Integer total, Integer size, Integer max, Integer start, List<T> items) {
		super();
		this.page = page;
		this.total = total;
		this.size = size;
		this.max = max;
		this.start = start;
		this.items = items;
	}

	public int getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if (page == null) {
			return;
		}
		if (this.size > 0 && page > 0) {
			this.start = (page-1) * this.size;
		}
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

}
