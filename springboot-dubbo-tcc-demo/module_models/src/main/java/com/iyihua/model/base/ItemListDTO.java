package com.iyihua.model.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemListDTO implements Serializable {

	private static final long serialVersionUID = -5657133739278304577L;

	Long userId;
	Integer type; // 0=day, 1=week, 2=month, 3=year
	Date start;
	Date end;
	Date next;

	List<ItemDTO> items;

	public ItemListDTO() {
		super();
	}

	public ItemListDTO(Long userId, Integer type, Date start, Date end, Date next, List<ItemDTO> items) {
		super();
		this.userId = userId;
		this.type = type;
		this.start = start;
		this.end = end;
		this.next = next;
		this.items = items;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getNext() {
		return next;
	}

	public void setNext(Date next) {
		this.next = next;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
