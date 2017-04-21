package com.iyihua.model.component.message;

import java.io.Serializable;
import java.util.Map;

public class EmailMessage implements Serializable {

	private static final long serialVersionUID = 5774992021320625396L;
	private final String to;
	private final String subject;
	private final String content;
	private final Map<String, Object> params;
	public EmailMessage(final String to, final String subject, final String content, final Map<String, Object> params) {
		super();
		this.to = to;
		this.subject = subject;
		this.content = content;
		this.params = params;
	}
	public String getTo() {
		return to;
	}
	public String getSubject() {
		return subject;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public String getContent() {
		return content;
	}
}
