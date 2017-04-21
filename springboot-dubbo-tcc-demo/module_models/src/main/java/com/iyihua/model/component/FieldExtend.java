package com.iyihua.model.component;

import java.io.Serializable;

/**
 * 
 * @ClassName: FieldExtend
 * @Description: 可以传递给界面层的一些默认公共字段
 * @author: wanglvyh@cf-ec.com
 * @date: 2016年1月19日 下午5:49:45
 */
public class FieldExtend implements Serializable {

	private static final long serialVersionUID = -4575690508264431038L;
	protected boolean editting = false;
	public boolean isEditting() {
		return editting;
	}
	public void setEditting(boolean editting) {
		this.editting = editting;
	}
}
