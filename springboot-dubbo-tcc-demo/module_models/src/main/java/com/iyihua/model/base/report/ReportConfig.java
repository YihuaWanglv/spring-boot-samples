package com.iyihua.model.base.report;

import java.io.Serializable;

public class ReportConfig implements Serializable {

	private static final long serialVersionUID = -2926494650507649343L;
	
	private String key;
	private int enabled = 1;
	private String type = "bar";
	private int muti = 0;
	private String title;
	
	public static class Builder {
		private String key;
		private int enabled = 1;
		private String type = "bar";
		private int muti = 0;
		private String title;
		
        public Builder(String key) {
            this.key = key;
        }
        public Builder enabled(int enabled) {
            this.enabled = enabled;
            return this;
        }
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        public Builder muti(int muti) {
            this.muti = muti;
            return this;
        }
        public Builder title(String title) {
        	this.title = title;
        	return this;
        }
        
        public ReportConfig build() {
            return new ReportConfig(this);
        }
    }
    private ReportConfig(Builder b) {
        this.key = b.key;
        this.enabled = b.enabled;
        this.type = b.type;
        this.muti = b.muti;
        this.title = b.title;
    }
    
    public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMuti() {
		return muti;
	}
	public void setMuti(int muti) {
		this.muti = muti;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
