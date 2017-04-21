package com.iyihua.model.base.report;

public class ReportQuery {

	@SuppressWarnings("unused")
	private int type = 0;
	@SuppressWarnings("unused")
	private Long userId;
	@SuppressWarnings("unused")
	private Integer dimension;
	private ReportQuery(Builder b) {
		this.type = b.type;
		this.userId = b.userId;
		this.dimension = b.dimension;
	}
	public static class Builder {
		private int type = 0;
		private Long userId;
		private Integer dimension;
		public Builder(int type) {
            this.type = type;
        }
		public Builder userId(Long userId) {
			this.userId = userId;
			return this;
		}
		public Builder dimension(Integer dimension) {
			this.dimension = dimension;
			return this;
		}
		public ReportQuery build() {
            return new ReportQuery(this);
        }
	}
}
