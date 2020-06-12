package com.springboot.simplicate.models;

public class Avatar {

	private String initials;
	private String color;
	private String url_small;
	private String url_large;

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUrl_small() {
		return url_small;
	}

	public void setUrl_small(String url_small) {
		this.url_small = url_small;
	}

	public String getUrl_large() {
		return url_large;
	}

	public void setUrl_large(String url_large) {
		this.url_large = url_large;
	}
}