package com.springboot.simplicate.models;

public class Metadata {

	private Integer count;
	private Integer total_count;
	private Integer offset;
	private Integer limit;
	private Integer upper_limit;
	private Boolean nocleanup;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getUpper_limit() {
		return upper_limit;
	}

	public void setUpper_limit(Integer upper_limit) {
		this.upper_limit = upper_limit;
	}

	public Boolean getNocleanup() {
		return nocleanup;
	}

	public void setNocleanup(Boolean nocleanup) {
		this.nocleanup = nocleanup;
	}
}
