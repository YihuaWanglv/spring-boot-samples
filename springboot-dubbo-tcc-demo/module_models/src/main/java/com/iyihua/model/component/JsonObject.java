package com.iyihua.model.component;

import java.io.Serializable;

public class JsonObject implements Serializable {

	private static final long serialVersionUID = 5636518400415762281L;
	private int status = 1;
	private String message;
	private Object data;

	public JsonObject() {
		super();
	}

	public JsonObject(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
