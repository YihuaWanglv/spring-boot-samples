package com.iyihua.itimes.web.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.iyihua.model.base.ItemDTO;

public class ItemSaveDTO extends ItemDTO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -4919237811532671391L;

	protected String itemDate;
	
	public ItemSaveDTO() {
		super();
	}
	public ItemSaveDTO(Long itemId, Long userId, Date date, Long categoryId, Long locationId, Long projectId, String item, String tags, BigDecimal duration, String year, String month, String day,
			String week, String userName, String categoryName, String projectName, String locationName, String result, String itemDate) {
		super(itemId, userId, date, categoryId, locationId, projectId, item, tags, duration, year, month, day, week, userName, categoryName, projectName, locationName, result);
		this.itemDate = itemDate;
	}
	@Override
	public String toString() {
		return "ItemSaveDTO [itemDate=" + itemDate + ", itemId=" + itemId + ", userId=" + userId + ", date=" + date + ", categoryId=" + categoryId + ", locationId=" + locationId + ", projectId="
				+ projectId + ", item=" + item + ", tags=" + tags + ", duration=" + duration + ", year=" + year + ", month=" + month + ", day=" + day + ", week=" + week + ", userName=" + userName
				+ ", categoryName=" + categoryName + ", projectName=" + projectName + ", locationName=" + locationName + ", result=" + result + ", fieldExtend=" + fieldExtend + "]";
	}
	public String getItemDate() {
		return itemDate;
	}
	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}

}
